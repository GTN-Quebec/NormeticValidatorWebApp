/*
 * ApplicationBean1.java
 *
 * Created on 2-Apr-2008, 10:07:17 AM
 */
package lomvs;

import java.util.Locale;
import javax.faces.context.FacesContext;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @author jcano
 */

public class ApplicationBean1 {

    /**
     * <p>Construct a new application data bean instance.</p>
     */
    public ApplicationBean1() {
        helpLinks = FacesContext.getCurrentInstance().getExternalContext().
                  getInitParameter( "helpLinks" ).split( "\\|" );
    }

    public Locale getLocale() {
        Locale locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        return( locale );
    }

    public static String[] helpLinks;
}
