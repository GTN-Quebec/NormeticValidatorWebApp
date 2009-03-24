/*
 * ValidationRaport.java
 *
 * Created on 8-Apr-2008, 10:44:29 AM
 */
package lomvs;

import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import java.io.*;
import java.net.*;
import javax.xml.*;
import javax.xml.validation.*;
import javax.xml.parsers.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.StaticText;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author jcano
 */
public class Result extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Page page1 = new Page();

    public Page getPage1() {
        return page1;
    }

    public void setPage1(Page p) {
        this.page1 = p;
    }
    private Html html1 = new Html();

    public Html getHtml1() {
        return html1;
    }

    public void setHtml1(Html h) {
        this.html1 = h;
    }
    private Head head1 = new Head();

    public Head getHead1() {
        return head1;
    }

    public void setHead1(Head h) {
        this.head1 = h;
    }
    private Link link1 = new Link();

    public Link getLink1() {
        return link1;
    }

    public void setLink1(Link l) {
        this.link1 = l;
    }
    private Body body1 = new Body();

    public Body getBody1() {
        return body1;
    }

    public void setBody1(Body b) {
        this.body1 = b;
    }
    private Form form1 = new Form();

    public Form getForm1() {
        return form1;
    }

    public void setForm1(Form f) {
        this.form1 = f;
    }
    private HtmlPanelGrid mainPanel2 = new HtmlPanelGrid();

    public HtmlPanelGrid getMainPanel2() {
        return mainPanel2;
    }

    public void setMainPanel2(HtmlPanelGrid hpg) {
        this.mainPanel2 = hpg;
    }
    private Button previousPageButton = new Button();

    public Button getPreviousPageButton() {
        return previousPageButton;
    }

    public void setPreviousPageButton(Button b) {
        this.previousPageButton = b;
    }
    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }
    private StaticText staticTextReportTitle = new StaticText();

    public StaticText getStaticTextReportTitle() {
        return staticTextReportTitle;
    }

    public void setStaticTextReportTitle(StaticText st) {
        this.staticTextReportTitle = st;
    }
    private HtmlPanelGrid gridPaneGeneralInfo = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPaneGeneralInfo() {
        return gridPaneGeneralInfo;
    }

    public void setGridPaneGeneralInfo(HtmlPanelGrid hpg) {
        this.gridPaneGeneralInfo = hpg;
    }
    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }
    private StaticText nameSpacestaticText = new StaticText();

    public StaticText getNameSpacestaticText() {
        return nameSpacestaticText;
    }

    public void setNameSpacestaticText(StaticText st) {
        this.nameSpacestaticText = st;
    }
    private StaticText rootElementstaticText = new StaticText();

    public StaticText getRootElementstaticText() {
        return rootElementstaticText;
    }

    public void setRootElementstaticText(StaticText st) {
        this.rootElementstaticText = st;
    }
    private Label label2 = new Label();

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label l) {
        this.label2 = l;
    }
    private StaticText fileTypeStaticText = new StaticText();

    public StaticText getFileTypeStaticText() {
        return fileTypeStaticText;
    }

    public void setFileTypeStaticText(StaticText st) {
        this.fileTypeStaticText = st;
    }
    private Label label3 = new Label();

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label l) {
        this.label3 = l;
    }
    private StaticText fileNamestaticText = new StaticText();

    public StaticText getFileNamestaticText() {
        return fileNamestaticText;
    }

    public void setFileNamestaticText(StaticText st) {
        this.fileNamestaticText = st;
    }
    private Label label4 = new Label();

    public Label getLabel4() {
        return label4;
    }

    public void setLabel4(Label l) {
        this.label4 = l;
    }
    private StaticText staticText7 = new StaticText();

    public StaticText getStaticText7() {
        return staticText7;
    }

    public void setStaticText7(StaticText st) {
        this.staticText7 = st;
    }
    private Label label5 = new Label();

    public Label getLabel5() {
        return label5;
    }

    public void setLabel5(Label l) {
        this.label5 = l;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private StaticText staticTextLom = new StaticText();

    public StaticText getStaticTextLom() {
        return staticTextLom;
    }

    public void setStaticTextLom(StaticText st) {
        this.staticTextLom = st;
    }
    private Table tableReportErrors = new Table();

    public Table getTableReportErrors() {
        return tableReportErrors;
    }

    public void setTableReportErrors(Table t) {
        this.tableReportErrors = t;
    }
    private StaticText staticTextHelp = new StaticText();

    public StaticText getStaticTextHelp() {
        return staticTextHelp;
    }

    public void setStaticTextHelp(StaticText st) {
        this.staticTextHelp = st;
    }
    private TableColumn tableColumnHelp = new TableColumn();

    public TableColumn getTableColumnHelp() {
        return tableColumnHelp;
    }

    public void setTableColumnHelp(TableColumn tc) {
        this.tableColumnHelp = tc;
    }
    private TableColumn tableColumnLexicalScope = new TableColumn();

    public TableColumn getTableColumnLexicalScope() {
        return tableColumnLexicalScope;
    }

    public void setTableColumnLexicalScope(TableColumn tc) {
        this.tableColumnLexicalScope = tc;
    }
    private ImageHyperlink imageHyperlinkLexicalScope = new ImageHyperlink();

    public ImageHyperlink getImageHyperlinkLexicalScope() {
        return imageHyperlinkLexicalScope;
    }

    public void setImageHyperlinkLexicalScope(ImageHyperlink ih) {
        this.imageHyperlinkLexicalScope = ih;
    }
    private StaticText staticTextLexicalScope = new StaticText();

    public StaticText getStaticTextLexicalScope() {
        return staticTextLexicalScope;
    }

    public void setStaticTextLexicalScope(StaticText st) {
        this.staticTextLexicalScope = st;
    }
    private Hyperlink hyperlinkHelp = new Hyperlink();

    public Hyperlink getHyperlinkHelp() {
        return hyperlinkHelp;
    }

    public void setHyperlinkHelp(Hyperlink h) {
        this.hyperlinkHelp = h;
    }
    private ImageHyperlink imageHyperlinkHelp = new ImageHyperlink();

    public ImageHyperlink getImageHyperlinkHelp() {
        return imageHyperlinkHelp;
    }

    public void setImageHyperlinkHelp(ImageHyperlink ih) {
        this.imageHyperlinkHelp = ih;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Result() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("ValidationRaport Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
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

}

