/*
 * Page1.java
 *
 * Created on 2-Apr-2008, 10:07:18 AM
 */
package lomvs;

import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.StaticText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.MessageGroup;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.Upload;
import com.sun.webui.jsf.model.UploadedFile;
import javax.faces.context.FacesContext;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;

import ca.licef.validator.NormeticValidator;
import ca.licef.validator.ValidationReport;
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
public class Validator extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {

    }
    private Page page1 = new Page();

    public Page getPage1() {
        return page1;
    }

    public void setPage1(Page p) {
        this.page1 = p;
    }
    private Html html1 = new Html();

    public Html getHtml1() {
        return html1;
    }

    public void setHtml1(Html h) {
        this.html1 = h;
    }
    private Head head1 = new Head();

    public Head getHead1() {
        return head1;
    }

    public void setHead1(Head h) {
        this.head1 = h;
    }
    private Link link1 = new Link();

    public Link getLink1() {
        return link1;
    }

    public void setLink1(Link l) {
        this.link1 = l;
    }
    private Body body1 = new Body();

    public Body getBody1() {
        return body1;
    }

    public void setBody1(Body b) {
        this.body1 = b;
    }
    private Form form1 = new Form();

    public Form getForm1() {
        return form1;
    }

    public void setForm1(Form f) {
        this.form1 = f;
    }
    private Upload fileUpload1 = new Upload();

    public Upload getFileUpload1() {
        return fileUpload1;
    }

    public void setFileUpload1(Upload u) {
        this.fileUpload1 = u;
    }
    private Button uploadFileButton = new Button();

    public Button getUploadFileButton() {
        return uploadFileButton;
    }

    public void setUploadFileButton(Button b) {
        this.uploadFileButton = b;
    }
    private MessageGroup messageGroup1 = new MessageGroup();

    public MessageGroup getMessageGroup1() {
        return messageGroup1;
    }

    public void setMessageGroup1(MessageGroup mg) {
        this.messageGroup1 = mg;
    }
    private MessageGroup messageGroup2 = new MessageGroup();

    public MessageGroup getMessageGroup2() {
        return messageGroup2;
    }

    public void setMessageGroup2(MessageGroup mg) {
        this.messageGroup2 = mg;
    }
    private TabSet tabSetValidationMethods = new TabSet();

    public TabSet getTabSetValidationMethods() {
        return tabSetValidationMethods;
    }

    public void setTabSetValidationMethods(TabSet ts) {
        this.tabSetValidationMethods = ts;
    }
    private Tab tabUpload = new Tab();

    public Tab getTabUpload() {
        return tabUpload;
    }

    public void setTabUpload(Tab t) {
        this.tabUpload = t;
    }
    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }
    private Tab tabDirectInput = new Tab();

    public Tab getTabDirectInput() {
        return tabDirectInput;
    }

    public void setTabDirectInput(Tab t) {
        this.tabDirectInput = t;
    }
    private PanelLayout layoutPanel2 = new PanelLayout();

    public PanelLayout getLayoutPanel2() {
        return layoutPanel2;
    }

    public void setLayoutPanel2(PanelLayout pl) {
        this.layoutPanel2 = pl;
    }
    private HtmlPanelGrid mainPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(HtmlPanelGrid hpg) {
        this.mainPanel = hpg;
    }
    private Label labelTitle = new Label();

    public Label getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(Label l) {
        this.labelTitle = l;
    }
    private TextArea textAreaDirectInput = new TextArea();

    public TextArea getTextAreaDirectInput() {
        return textAreaDirectInput;
    }

    public void setTextAreaDirectInput(TextArea ta) {
        this.textAreaDirectInput = ta;
    }
    private Button directInputbutton = new Button();

    public Button getDirectInputbutton() {
        return directInputbutton;
    }

    public void setDirectInputbutton(Button b) {
        this.directInputbutton = b;
    }
    private Button buttonClearDirectInput = new Button();

    public Button getButtonClearDirectInput() {
        return buttonClearDirectInput;
    }

    public void setButtonClearDirectInput(Button b) {
        this.buttonClearDirectInput = b;
    }
    private Label labelDirectInputTitle = new Label();

    public Label getLabelDirectInputTitle() {
        return labelDirectInputTitle;
    }

    public void setLabelDirectInputTitle(Label l) {
        this.labelDirectInputTitle = l;
    }
    private StaticText staticTextTitle = new StaticText();

    public StaticText getStaticTextTitle() {
        return staticTextTitle;
    }

    public void setStaticTextTitle(StaticText st) {
        this.staticTextTitle = st;
    }
    private StaticText staticTextDescription = new StaticText();

    public StaticText getStaticTextDescription() {
        return staticTextDescription;
    }

    public void setStaticTextDescription(StaticText st) {
        this.staticTextDescription = st;
    }
    private Checkbox checkboxShowRecommendationsForUpload = new Checkbox();

    public Checkbox getCheckboxShowRecommendationsForUpload() {
        return checkboxShowRecommendationsForUpload;
    }

    public void setCheckboxShowRecommendationsForUpload(Checkbox c) {
        this.checkboxShowRecommendationsForUpload = c;
    }
    private Checkbox checkboxShowRecommendationsForDirectInput = new Checkbox();

    public Checkbox getCheckboxShowRecommendationsForDirectInput() {
        return checkboxShowRecommendationsForDirectInput;
    }

    public void setCheckboxShowRecommendationsForDirectInput(Checkbox c) {
        this.checkboxShowRecommendationsForDirectInput = c;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Validator() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
       

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public String uploadFileButton_action() {
        String strIsDebug = FacesContext.getCurrentInstance().getExternalContext().getInitParameter( "isDebug" );
        boolean isDebug = ( "true".equals( strIsDebug ) );

        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", getApplicationBean1().getLocale() );

        UploadedFile uploadedFile = fileUpload1.getUploadedFile();

        // Temporary trace to debug FileUploadException : Processing of multipart/form-data request failed. Read timed out. - FB
        if( isDebug ) {
            System.out.println( "uploadFileButton_action at " + ( new Date() ) + " uploadedFile=" + uploadedFile + 
                " filename=" + ( uploadedFile == null ? "n/a" : uploadedFile.getOriginalName() ) ); 
        }

        if (uploadedFile == null) {
            error( bundle.getString("noFileUploaded"));
            return (null);
        }
        String uploadedFileName = uploadedFile.getOriginalName();
        if (uploadedFileName == null || uploadedFileName.length() < 2) {
            error( bundle.getString("noFileUploaded"));
            return (null);
        }
      
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

        String uploadedFileType = uploadedFile.getContentType();

        if (uploadedFileType.equals("text/xml") || 
            uploadedFileType.equals("application/x-xml") || 
            uploadedFileType.equals("application/xml") ||
            uploadedFileType.equals("application/octet-stream")) {
            try {
                InputStreamReader reader = new InputStreamReader(uploadedFile.getInputStream(), "UTF-8");
                BufferedReader lomReader = new BufferedReader(reader);
                StringWriter lomString = new StringWriter();
                BufferedWriter lomWriter = new BufferedWriter(lomString);
                String line = null;
                while ((line = lomReader.readLine()) != null) {
                    lomString.write(line);
                    lomString.write("\n");
                }

                getSessionBean1().setDirectInputLomString( lomString.toString() );
                getSessionBean1().setValidatedLomString( lomString.toString() );

                try {
                    validateLomString(getSessionBean1().getValidatedLomString());
                    return "Validation";
                } catch (Exception e) {
                    error( bundle.getString("cannotInitializeNormeticValidator") + e);
                    return (null);
                }
            } catch (Exception ex) {
                error( bundle.getString("cannotUploadFile") + justFileName);
                return (null);
            }
        } else {
            error( bundle.getString("invalidFileFormat"));
            return (null);
        }
    }

    public String tabUpload_action() {
        getSessionBean1().setSelectedTab( "tabUpload" );
        return null;
    }

    public String tabDirectInput_action() {
        getSessionBean1().setSelectedTab( "tabDirectInput" );
        return null;
    }

    public String directInputbutton_action() {
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", getApplicationBean1().getLocale() );

        String lomString = (String) textAreaDirectInput.getText();
        if (lomString == null || lomString.trim().length() == 0) {
            error(bundle.getString("emptyLomText"));
            return (null);
        }

        getSessionBean1().setValidatedLomString( lomString );
        try {
            validateLomString( getSessionBean1().getValidatedLomString() );
            return "Validation";
        } catch (Exception e) {
            error(bundle.getString("cannotInitializeNormeticValidator") + e);
            return (null);
        }
    }

    private synchronized boolean validateLomString(String lomString) throws Exception {
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
        validator.setLocale( locale );
        //validator.setForcedValidationEnabled( true );
        validator.setShowRecommendationsEnabled( getSessionBean1().isShowRecommendationsEnabled() );
        ValidationReport report = validator.validate(lomString);
        boolean isValid = ( report.getErrorCount() == 0 && report.getFatalErrorCount() == 0 );
        getSessionBean1().setReport( report );
       
        if( isDebug ) {
            endTime = new Date();
            long duration = endTime.getTime() - startTime.getTime();
            System.out.println( report.toString() );
            System.out.println( "End of validation.  isValid=" + isValid + " (" + endTime + ")" );
            System.out.println( "=> Time required to perform validation: " + duration + " ms.\n\n" );
        }

        return( isValid );
    }

    public void textAreaDirectInput_processValueChange(ValueChangeEvent event) {
        getSessionBean1().setDirectInputLomString( (String)event.getNewValue() );
    }

    public String buttonClearDirectInput_action() {
        textAreaDirectInput.setText( "" );
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

}

