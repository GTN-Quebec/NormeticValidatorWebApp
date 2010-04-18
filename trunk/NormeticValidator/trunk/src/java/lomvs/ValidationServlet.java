/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lomvs;

import ca.licef.validator.NormeticValidator;
import ca.licef.validator.ValidationIssue;
import ca.licef.validator.ValidationReport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import com.google.gson.Gson;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author maparent
 */
public class ValidationServlet extends HttpServlet {
    protected static Gson gson = new Gson();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Locale locale = null; //Locale.FRENCH;
        String lom;
        ValidationIssue[] issues = null;
        if (request.getContentType() != null && !request.getContentType().equals("application/xml")) {
            response.sendError(415, "Can only accept XML files.");
            return;
        }

        try {
            BufferedReader lomReader = request.getReader();
            StringWriter lomString = new StringWriter();
            String line = null;
            StringBuffer buffer = lomString.getBuffer();
            while ((line = lomReader.readLine()) != null) {
                lomString.write(line);
                lomString.write("\n");
                if (buffer.length() > 20000) {
                    lomReader.close();
                    response.sendError(413);
                    return;
                }
            }
            lom = lomString.toString().trim();
            if (lom.length() == 0) {
                response.sendError(400, "Empty POST. Please send a LOM file.");
                return;
            }
            // TODO: Check that no path, no parameters, accepts json...
            Enumeration locales = request.getLocales();
            while (locales.hasMoreElements()) {
                Locale loc = (Locale)locales.nextElement();
                if (loc.getISO3Language().equals(Locale.FRENCH.getISO3Language())) {
                    locale = Locale.FRENCH;
                    break;
                }
                if (loc.getISO3Language().equals(Locale.ENGLISH.getISO3Language())) {
                    locale = Locale.ENGLISH;
                    break;
                }
            }
            if (locale == null) {
                response.sendError(406, "Can only generate report in French or English.");
                return;
            }
        } catch (IOException ex) {
            response.sendError(500, "Internal error."+ex.toString());
            throw ex;
        }
        try {
            NormeticValidator validator = new NormeticValidator();
            validator.setLocale( locale );
            // Use a parameter?
            validator.setShowRecommendationsEnabled( true );
            ValidationReport report = validator.validate(lom);
            issues = report.getIssues();
        } catch (TransformerConfigurationException ex) {
            response.sendError(500, "Internal error."+ex.toString());
            return;
        } catch (TransformerException ex) {
            response.sendError(500, "Internal error."+ex.toString());
            return;
        } catch (SAXException ex) {
            response.sendError(400, "Malformed XML."+ex.toString());
            return;
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.print(StringEscapeUtils.unescapeJava(gson.toJson(issues)));
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=US-ASCII");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head></head><body><p>");
            out.println(getServletInfo());
            out.println("</p></body></html>");
        } finally {
            out.close();
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This service will validate a posted LOM file and return issues as JSON.";
    }// </editor-fold>

}
