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
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.context.FacesContext;
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
public class SessionBean1 {

    public SessionBean1() {
    }

    public void setReport(ValidationReport report) {
        Locale locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle", locale );
        this.report = report;
        this.hasAtLeastOneHelpReference = false;
        this.hasAtLeastOneLexicalScopeReference = false;
        ValidationIssue[] issues = report.getIssues();
        ArrayList<ErrorEntry> errorList = new ArrayList<ErrorEntry>(issues.length);
        for (int i = 0; i < issues.length; i++) {
            ErrorEntry entry = new ErrorEntry(issues[i],bundle);
            errorList.add( entry );
            if( !hasAtLeastOneHelpReference && entry.isHelpReferenceAvailable() )
                hasAtLeastOneHelpReference = true;
            if( !hasAtLeastOneLexicalScopeReference && entry.isLexicalScopeReferenceAvailable() )
                hasAtLeastOneLexicalScopeReference = true;
        }
        this.errorListDataProvider = new ListDataModel(errorList);
        if( report.getFatalErrorCount() > 0 || report.getErrorCount() > 0 ) {
            this.verdict = "Error";
            this.verdictSummary = bundle.getString( "verdictSummaryError" );
            this.verdictDetail = bundle.getString( "verdictDetailError" );
        } else if ( report.getWarningCount() > 0) {
            this.verdict = "Warning";
            this.verdictSummary = bundle.getString( "verdictSummaryWarning" );
            this.verdictDetail = bundle.getString( "verdictDetailWarning" );
        } else {
            this.verdict = "Success";
            this.verdictSummary = bundle.getString( "verdictSummarySuccess" );
            this.verdictDetail = bundle.getString( "verdictDetailSuccess" );
        }
        this.issuesCount = report.getErrorCount() + report.getFatalErrorCount();
        if (this.isShowRecommendationsEnabled())
            this.issuesCount += report.getWarningCount();
    }

    public ValidationReport getReport() {
        return (this.report);
    }

    public String getReportText() {
        return (this.report.toString());
    }

    public DataModel getIssues() {
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

    public String getUploadedLomString() {
        return uploadedLomString;
    }

    public void setUploadedLomString(String uploadedLomString) {
        this.uploadedLomString = uploadedLomString;
    }

    public String getDecoratedValidatedString() {
        StringBuilder str = new StringBuilder();
        BufferedReader reader = new BufferedReader( new StringReader( getLomString() ) );
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

    public int getSelectedTab() {
         return this.selectedTab;
    }
    
    public  void setSelectedTab(int tab) {
        this.selectedTab = tab;
    }

    public boolean isHelpAvailableAtLeastOnce() {
        return( hasAtLeastOneHelpReference );
    }

    public boolean isLexicalScopeAvailableAtLeastOnce() {
        return( hasAtLeastOneLexicalScopeReference );
    }

    public UploadedFile getUploadedLomFile() {
        return uploadedLomFile;
    }

    public void setUploadedLomFile(UploadedFile uploadedLomFile) {
        this.uploadedLomFile = uploadedLomFile;
    }

    public String getLomString() {
        if (uploadedLomFile == null) {
            return directInputLomString;
        } else {
            return uploadedLomString;
        }
    }

    public int getIssuesCount() {
        return issuesCount;
    }

    public boolean isHasIssues() {
        return issuesCount > 0;
    }

    public String getVerdict() {
        return verdict;
    }

    public String getVerdictDetail() {
        return verdictDetail;
    }

    public String getVerdictSummary() {
        return verdictSummary;
    }

    private ValidationReport report;
    private boolean hasAtLeastOneHelpReference;
    private boolean hasAtLeastOneLexicalScopeReference;
    private DataModel errorListDataProvider = new ListDataModel();
    private String directInputLomString = "";
    private String uploadedLomString = "";
    private int selectedTab = 0;
    private int issuesCount = 0;
    private boolean isShowRecommendationsEnabled = true;
    private UploadedFile uploadedLomFile;
    private String verdict;
    private String verdictSummary;
    private String verdictDetail;
}
