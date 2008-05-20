package lomvs;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import ca.licef.validator.ValidationIssue;

public class ErrorEntry implements Serializable {

    public ErrorEntry( ValidationIssue error, ResourceBundle bundle ) {
        this.error = error;
        this.bundle = bundle;
    }

    public String getSeverityIcon() {
        if( error.getSeverity() == ValidationIssue.Severity.WARNING )
            return( "ALERT_DEGRADED_LARGE" );
        else
            return( "ALERT_ERROR_LARGE" );
    }

    public String getLocation() {
        if( error.getLine() != -1 && error.getColumn() != -1 ) {
            MessageFormat formatter = new MessageFormat( bundle.getString( "errorLocation" ) );
            String line = error.getLine() + "";
            String column = error.getColumn() + "";
            return( formatter.format( new String[] { line, column } ) );
        }
        else
            return( null );
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

    private ResourceBundle bundle;
    private ValidationIssue error;

}
