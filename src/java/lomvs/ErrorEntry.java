package lomvs;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import ca.licef.validator.ValidationIssue;

public class ErrorEntry implements Serializable {

    public ErrorEntry( ValidationIssue error, ResourceBundle bundle ) {
        this.error = error;
        this.bundle = bundle;
        this.severityIcon = ( error.getSeverity() == ValidationIssue.Severity.WARNING ? "Warning.gif" : "Error.gif" );
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
        StringBuilder str = new StringBuilder();
        str.append( error.getAlternateMessage() != null ? error.getAlternateMessage() : error.getMessage() );
        return( str.toString() );
    }

    public String getContext() {
        return( null );
    }

    public String getDetails() {
        return( error.getExplanation() );
    }

    public String getHelpReference() {
        if( !isHelpReferenceAvailable() ) 
            return( null );
        
        StringBuilder str = new StringBuilder();
        String[] fieldNumbers = error.getRelatedFieldNumber().split( "\\." );
        if( fieldNumbers.length == 0 )
            return( null );

        str.append( bundle.getString( "helpHeader" ) ).append( " " ).append( fieldNumbers[ 0 ] ).append( " " ).append( bundle.getString( "helpFooter" ) );
        str.append( " (p." ).append( error.getReference() ).append( ")" );

        return( str.toString() );
    }

    public String getHelpReferenceLink() {
        if( !isHelpReferenceAvailable() )
            return( null );

        String[] fieldNumbers = error.getRelatedFieldNumber().split( "\\." );
        if( fieldNumbers.length == 0 )
            return( null );

        try {
            int fieldNumber = Integer.parseInt( fieldNumbers[ 0 ] );
            return( ApplicationBean1.helpLinks[ fieldNumber - 1 ] );
        }
        catch( NumberFormatException e ) {
            return( null );
        }
    }

    public boolean isHelpReferenceAvailable() {
        return( error.getRelatedFieldNumber() != null && error.getReference() != null );
    }

    public String getLexicalScopeReference() {
        return( error.getLexicalField() );
    }

    public String getLexicalScopeReferenceLink() {
        String transformedRef = getLexicalScopeReference().replace( " ", "_" );
        transformedRef = transformedRef.replace( ",", "_" );
        transformedRef = transformedRef.replace( ":", "_" );
        return( "/vocab/" + bundle.getLocale().getLanguage() + "/" + transformedRef + ".html" );
    }

    public boolean isLexicalScopeReferenceAvailable() {
        return( error.getLexicalField() != null );
    }

    private ValidationIssue error;
    private String severityIcon;
    private String location;
    private ResourceBundle bundle;

}
