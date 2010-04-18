/*
 * ValidationRaport.java
 *
 * Created on 8-Apr-2008, 10:44:29 AM
 */
package lomvs;

import java.util.ResourceBundle;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;

import javax.faces.context.FacesContext;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author jcano
 */
public class Result {
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Result() {
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

    public String previousPageButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "previous";
    }

    public String homeButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String goDirectInputButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        getSessionBean1().setSelectedTab( 1 );
        return "previous";
    }

    public String getSubmittedLomHeader() {
        StringBuilder str = new StringBuilder();
        str.append( bundle.getString( "submittedLom" ) );
        if( getSessionBean1().getUploadedLomFile() != null ) {
            String fileName = getSessionBean1().getUploadedLomFile().getName();
            str.append( ": " ).append( Validator.justFileName(fileName) ).append( "." );
        }
        return( str.toString() );
    }

    private ResourceBundle bundle = ResourceBundle.getBundle( "lomvs.Bundle",
            FacesContext.getCurrentInstance().getApplication().getDefaultLocale());

}

