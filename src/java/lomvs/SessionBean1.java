/*
 * SessionBean1.java
 *
 * Created on 2-Apr-2008, 10:07:18 AM
 */
package lomvs;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.data.provider.impl.ObjectListDataProvider;
import javax.faces.FacesException;
import ca.licef.validator.ValidationIssue;
import ca.licef.validator.ValidationReport;


/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @author jcano
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here

    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    // </editor-fold>
    public void setReport(ValidationReport report) {
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", getApplicationBean1().getLocale() );
        this.report = report;
        this.hasAtLeastOneHelpReference = false;
        this.hasAtLeastOneLexicalScopeReference = false;
        ValidationIssue[] issues = report.getIssues();
        ArrayList errorList = new ArrayList(issues.length);
        for (int i = 0; i < issues.length; i++) {
            ErrorEntry entry = new ErrorEntry(issues[i],bundle);
            errorList.add( entry );
            if( !hasAtLeastOneHelpReference && entry.isHelpReferenceAvailable() )
                hasAtLeastOneHelpReference = true;
            if( !hasAtLeastOneLexicalScopeReference && entry.isLexicalScopeReferenceAvailable() )
                hasAtLeastOneLexicalScopeReference = true;
        }
        this.errorListDataProvider.setList(errorList);
    }

    public ValidationReport getReport() {
        return (this.report);
    }

    public String getReportText() {
        return (this.report.toString());
    }

    public String getVerdictType() {
        if( report.getFatalErrorCount() > 0 || report.getErrorCount() > 0 )
            return( "error" );
        else if( report.getWarningCount() > 0 )
            return( "warning" );
        else
            return( "success" );
    }

    public String getVerdictSummary() {
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", getApplicationBean1().getLocale() );
        if( report.getFatalErrorCount() > 0 || report.getErrorCount() > 0 )
            return( bundle.getString( "verdictSummaryError" ) );
        else if( report.getWarningCount() > 0 )
            return( bundle.getString( "verdictSummaryWarning" ) );
        else
            return( bundle.getString( "verdictSummarySuccess" ) );
    }

    public String getVerdictDetail() {
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", getApplicationBean1().getLocale() );
        if( report.getFatalErrorCount() > 0 || report.getErrorCount() > 0 )
            return( bundle.getString( "verdictDetailError" ) );
        else if( report.getWarningCount() > 0 )
            return( bundle.getString( "verdictDetailWarning" ) );
        else
            return( bundle.getString( "verdictDetailSuccess" ) );
    }

    public ObjectListDataProvider getIssues() {
        return (this.errorListDataProvider);
    }

    public void setShowRecommendationsEnabled( boolean isShowRecommendationsEnabled ) {
        this.isShowRecommendationsEnabled = isShowRecommendationsEnabled;
    }

    public boolean isShowRecommendationsEnabled() {
        return( isShowRecommendationsEnabled );
    }

    public String getDirectInputLomString() {
        return (directInputLomString);
    }

    public void setDirectInputLomString(String lomString) {
        this.directInputLomString = lomString;
    }

    public String getValidatedLomString() {
        return (validatedLomString);
    }

    public String getDecoratedValidatedString() {
        StringBuilder str = new StringBuilder();
        BufferedReader reader = new BufferedReader( new StringReader( validatedLomString ) );
        try {
            for( int lineNumber = 1;; lineNumber++ ) {
                String line = reader.readLine();
                if( line == null )
                    break;
                str.append( lineNumber ).append( ": " ).append( line ).append( "\n" );
            }
        }
        catch( IOException ignoreUnreadableLine ) {
            // Should never happen but get out of the loop (just in case).
        }
        finally {
            try {
                reader.close();
            }
            catch( IOException ignore ) {
            }
        }
        return( str.toString() );
    }

    public void setValidatedLomString(String lomString) {
        this.validatedLomString = lomString;
    }

    public String getSelectedTab() {
         return this.selectedTab;
    }
    
    public  void setSelectedTab(String tab) {
        this.selectedTab = tab;
    }

    public boolean isHelpAvailableAtLeastOnce() {
        return( hasAtLeastOneHelpReference );
    }

    public boolean isLexicalScopeAvailableAtLeastOnce() {
        return( hasAtLeastOneLexicalScopeReference );
    }

    private ValidationReport report;
    private boolean hasAtLeastOneHelpReference;
    private boolean hasAtLeastOneLexicalScopeReference;
    private ObjectListDataProvider errorListDataProvider = new ObjectListDataProvider();
    private String directInputLomString = "";
    private String validatedLomString = "";
    private String selectedTab = "tabUpload";
    private boolean isShowRecommendationsEnabled = true;
    
}
