package lomvs;

import java.util.Date;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCleaner implements HttpSessionListener {

    public SessionCleaner() {
    }

    public void sessionCreated( HttpSessionEvent event ) {
        //Date now = new Date();
        //System.out.println( "Session " + event.getSession().getId() + " created at " + now + "." );
    }

    public void sessionDestroyed( HttpSessionEvent event ) {
        //Date now = new Date();
        //System.out.println( "Session " + event.getSession().getId() + " destroyed at " + now + "." );

        // Perform cleanup code here, if needed.
    }

}
