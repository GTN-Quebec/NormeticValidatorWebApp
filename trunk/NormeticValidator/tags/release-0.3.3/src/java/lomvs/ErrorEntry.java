package lomvs;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import ca.licef.validator.ValidationIssue;

public class ErrorEntry implements Serializable {

    public ErrorEntry( ValidationIssue error, ResourceBundle bundle ) {
        this.error = error;
        this.severityIcon = ( error.getSeverity() == ValidationIssue.Severity.WARNING ? "ALERT_DEGRADED_LARGE" : "ALERT_ERROR_LARGE" );
        if( error.getLine() != -1 && error.getColumn() != -1 ) {
            MessageFormat formatter = new MessageFormat( bundle.getString( "errorLocation" ) );
            String line = error.getLine() + "";
            String column = error.getColumn() + "";
            this.location = formatter.format( new String[] { line, column } );
        }
    }

    public String getSeverityIcon() {
        return( severityIcon );
    }

    public String getLocation() {
        return( location );
    }

    public String getMessage() {
        return( error.getAlternateMessage() != null ? error.getAlternateMessage() : error.getMessage() );
    }

    public String getContext() {
        return( null );
    }

    public String getDetails() {
        return( error.getAlternateMessage() != null ? error.getMessage() : null );
    }

    private ValidationIssue error;
    private String severityIcon;
    private String location;

}
