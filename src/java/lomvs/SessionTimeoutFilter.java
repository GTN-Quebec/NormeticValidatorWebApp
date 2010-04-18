package lomvs;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTimeoutFilter implements Filter {

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain filterChain ) throws IOException, ServletException {
        if( req instanceof HttpServletRequest && resp instanceof HttpServletResponse ) {
            HttpServletRequest httpReq = (HttpServletRequest)req;
            HttpServletResponse httpResp = (HttpServletResponse)resp;

            if( isSessionControlRequiredForThisResource( httpReq ) ) {
                if( isSessionInvalid( httpReq ) ) {
                    // create a new session
                    httpReq.getSession(true);
                    String timeoutUrl = httpReq.getContextPath() + "/" + getTimeoutPage();
                    //System.out.println( "Session expired.  Redirect to " + timeoutUrl );
                    httpResp.sendRedirect( timeoutUrl );
                    return;
                }
            }
        }
        filterChain.doFilter( req, resp ); 
    }

    /*
     * Session shouln't be checked for some pages (like the timeout page...)
     * Since we're redirecting to timeout page from this filter,
     * if we don't disable session control for it, filter will again redirect to it
     * and this will provoke an infinite loop.
     */
    private boolean isSessionControlRequiredForThisResource( HttpServletRequest req ) {
        String requestPath = req.getRequestURI();
        boolean isControlRequired = ( requestPath.indexOf( getTimeoutPage() ) == -1 );
        return( isControlRequired );
    }

    private String getTimeoutPage() {
        return( timeoutPage );
    }

    private boolean isSessionInvalid( HttpServletRequest req ) {
        boolean isSessionInvalid = ( req.getRequestedSessionId() != null && !req.isRequestedSessionIdValid() );
        return( isSessionInvalid );
    }

    public void destroy() {
    }

    private static final String timeoutPage = "";

}
