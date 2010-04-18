/*
 * Page1.java
 *
 * Created on 2-Apr-2008, 10:07:18 AM
 */
package lomvs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.Application;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import ca.licef.validator.NormeticValidator;
import ca.licef.validator.ValidationReport;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.event.ValueChangeEvent;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author jcano
 */
public class Validator {
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Validator() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        ExpressionFactory efactory = app.getExpressionFactory();
        ValueExpression binding = efactory.createValueExpression(context.getELContext(),
                "#{SessionBean1}", SessionBean1.class);
        SessionBean1 value = (SessionBean1)binding.getValue(context.getELContext());
        return value;
    }

    public static String justFileName(String uploadedFileName) {
        // Some browsers return complete path name, some don't
        // Make sure we only have the file name
        // First, try forward slash
        int index = uploadedFileName.lastIndexOf('/');
        String justFileName;
        if (index >= 0) {
            justFileName = uploadedFileName.substring(index + 1);
        } else {
            // Try backslash
            index = uploadedFileName.lastIndexOf('\\');
            if (index >= 0) {
                justFileName = uploadedFileName.substring(index + 1);
            } else {
                // No forward or back slashes
                justFileName = uploadedFileName;
            }
        }
        return justFileName;
    }

    public String uploadFileButton_action() {
        SessionBean1 session = getSessionBean1();
        FacesContext fcontext = FacesContext.getCurrentInstance();
        String strIsDebug = fcontext.getExternalContext().getInitParameter( "isDebug" );
        boolean isDebug = ( "true".equals( strIsDebug ) );

        Locale locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", locale );

        UploadedFile uploadedFile = session.getUploadedLomFile();

        // Temporary trace to debug FileUploadException : Processing of multipart/form-data request failed. Read timed out. - FB
        if( isDebug ) {
            System.out.println( "uploadFileButton_action at " + ( new Date() ) + " uploadedFile=" + uploadedFile ); 
        }

        if (uploadedFile == null) {
            fcontext.addMessage("messageGroup1", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("errorGroupTitle"),
                                     bundle.getString("noFileUploaded")));
            return (null);
        }
        String uploadedFileName = uploadedFile.getName();
        if (uploadedFileName == null || uploadedFileName.length() < 2) {
            fcontext.addMessage("messageGroup1",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("errorGroupTitle"),
                                     bundle.getString("noFileUploaded")));
            return (null);
        }
        
        
        String uploadedFileType = uploadedFile.getContentType();

        if (uploadedFileType.equals("text/xml") || 
            uploadedFileType.equals("application/x-xml") || 
            uploadedFileType.equals("application/xml") ||
            uploadedFileType.equals("application/octet-stream")) {
            try {
                InputStreamReader reader = new InputStreamReader(uploadedFile.getInputStream(), "UTF-8");
                BufferedReader lomReader = new BufferedReader(reader);
                StringWriter lomString = new StringWriter();
                String line = null;
                while ((line = lomReader.readLine()) != null) {
                    lomString.write(line);
                    lomString.write("\n");
                }
                session.setUploadedLomString(lomString.toString());
                session.setDirectInputLomString("");
                try {
                    validateLomString(lomString.toString());
                    return "Validation";
                } catch (Exception e) {
                    fcontext.addMessage("messageGroup1",
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("errorGroupTitle"),
                                             bundle.getString("cannotInitializeNormeticValidator") + e));
                    return (null);
                }
            } catch (Exception ex) {
                fcontext.addMessage("messageGroup1",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("errorGroupTitle"),
                                         bundle.getString("cannotUploadFile") + justFileName(uploadedFileName)));
                return (null);
            }
        } else {
            fcontext.addMessage("messageGroup1",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("errorGroupTitle"),
                                     bundle.getString("invalidFileFormat")));
            return (null);
        }
    }

    public String directInputbutton_action() {
        SessionBean1 session = getSessionBean1();
        FacesContext fcontext = FacesContext.getCurrentInstance();
        Locale locale = fcontext.getApplication().getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", locale );

        String lomString = session.getDirectInputLomString();
        if (lomString == null || lomString.trim().length() == 0) {
            fcontext.addMessage("messageGroup2",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("errorGroupTitle"),
                                     bundle.getString("emptyLomText")));
            return (null);
        }

        session.setUploadedLomFile( null );
        session.setUploadedLomString( "" );
        try {
            validateLomString( lomString );
            return "Validation";
        } catch (Exception e) {
            fcontext.addMessage("messageGroup2",
                    new FacesMessage(bundle.getString("errorGroupTitle"),
                                     bundle.getString("cannotInitializeNormeticValidator") + e));
            return (null);
        }
    }

    private synchronized boolean validateLomString(String lomString) throws Exception {
        SessionBean1 session = getSessionBean1();
        String strIsDebug = FacesContext.getCurrentInstance().getExternalContext().getInitParameter( "isDebug" );
        boolean isDebug = ( "true".equals( strIsDebug ) );
        Date startTime = null;
        Date endTime = null;

        if( isDebug ) {
            startTime = new Date();
            System.out.println( "Start validating LOM (" + startTime + ")" );
            System.out.println( lomString );
        }

        NormeticValidator validator = new NormeticValidator();
        Locale locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", locale );
        validator.setLocale( locale );
        //validator.setForcedValidationEnabled( true );
        validator.setShowRecommendationsEnabled( session.isShowRecommendationsEnabled() );
        ValidationReport report = validator.validate(lomString);
        int issuesCount = report.getErrorCount() + report.getFatalErrorCount();
        boolean isValid = (issuesCount == 0);
        session.setReport( report );
       
        if( isDebug ) {
            endTime = new Date();
            long duration = endTime.getTime() - startTime.getTime();
            System.out.println( report.toString() );
            System.out.println( "End of validation.  isValid=" + isValid + " (" + endTime + ")" );
            System.out.println( "=> Time required to perform validation: " + duration + " ms.\n\n" );
        }

        return( isValid );
    }

    public String buttonClearDirectInput_action() {
        textarea.setValue( "" );
        return null;
    }

    public void checkboxShowRecommendationsForUpload_processValueChange(ValueChangeEvent event) {
        Boolean isChecked = (Boolean)event.getNewValue();
        getSessionBean1().setShowRecommendationsEnabled( isChecked.booleanValue() );
    }

    public void checkboxShowRecommendationsForDirectInput_processValueChange(ValueChangeEvent event) {
        Boolean isChecked = (Boolean)event.getNewValue();
        getSessionBean1().setShowRecommendationsEnabled( isChecked.booleanValue() );
    }

    public HtmlInputTextarea getTextarea() {
        return textarea;
    }

    public void setTextarea(HtmlInputTextarea textarea) {
        this.textarea = textarea;
    }

    private HtmlInputTextarea textarea;
}

