<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ValidationRaport
    Created on : 8-Apr-2008, 10:44:28 AM
    Author     : jcano
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view locale="#{applicationScope.defaultLocale}">
        <f:loadBundle basename="lomvs.Bundle" var="msg"/>
        <webuijsf:page binding="#{Result.page1}" id="page1">
            <webuijsf:html binding="#{Result.html1}" id="html1">
                <webuijsf:head binding="#{Result.head1}" id="head1">
                    <webuijsf:link binding="#{Result.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Result.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Result.form1}" id="form1">
                        <div style="">
                            <jsp:directive.include file="Header_LomVS.jspf"/>
                        </div>
                        <h:panelGrid binding="#{Result.mainPanel2}" cellspacing="20" id="mainPanel2" style="margin-bottom: 30px;" width="100%">
                            <h:panelGrid binding="#{Result.gridPaneGeneralInfo}" columns="2" id="gridPaneGeneralInfo" rendered="false" style="border-style: ridge; border-color: gray; background-color: rgb(204, 204, 204); height: 192px; width: 100%">
                                <webuijsf:label binding="#{Result.label5}" id="label5" style="font-size: 14px" text="Result"/>
                                <webuijsf:staticText binding="#{Result.staticText7}" id="staticText7"/>
                                <webuijsf:label binding="#{Result.label4}" id="label4" style="font-size: 14px" text="File"/>
                                <webuijsf:staticText binding="#{Result.fileNamestaticText}" id="fileNamestaticText"/>
                                <webuijsf:label binding="#{Result.label3}" id="label3" style="font-size: 14px" text="Doctype"/>
                                <webuijsf:staticText binding="#{Result.fileTypeStaticText}" id="fileTypeStaticText"/>
                                <webuijsf:label binding="#{Result.label2}" id="label2" style="font-size: 14px" text="RootElement"/>
                                <webuijsf:staticText binding="#{Result.rootElementstaticText}" id="rootElementstaticText"/>
                                <webuijsf:label binding="#{Result.label1}" id="label1" style="font-size: 14px" text="Root Namespace"/>
                                <webuijsf:staticText binding="#{Result.nameSpacestaticText}" id="nameSpacestaticText"/>
                            </h:panelGrid>
                            <webuijsf:staticText binding="#{Result.staticTextReportTitle}" id="staticTextReportTitle" style="font-size: 24px" text="#{msg.reportTitle}"/>
                            <webuijsf:staticText binding="#{Result.staticTextLom}" id="staticTextLom" text="#{msg.submittedLom}"/>
                            <webuijsf:textArea columns="200" id="textAreaLom" readOnly="true" rows="20" style="" text="#{SessionBean1.decoratedValidatedString}"/>
                            <webuijsf:alert detail="#{SessionBean1.verdictDetail}" id="alertVerdict" style="font-size: 18px"
                                summary="#{SessionBean1.verdictSummary}" type="#{SessionBean1.verdictType}"/>
                            <webuijsf:table binding="#{Result.tableReportErrors}" cellPadding="10" id="tableReportErrors"
                                rendered="#{SessionBean1.report.issueCount &gt; 0}" style="width: 100%;" title="#{msg.errorTableTitle}">
                                <webuijsf:tableRowGroup align="center" id="tableRowGroupReportErrors" rows="15" sourceData="#{SessionBean1.issues}"
                                    sourceVar="currentRow" valign="middle">
                                    <webuijsf:tableColumn id="tableColumnErrorSeverity" valign="middle" width="40">
                                        <webuijsf:image align="top" icon="#{currentRow.value['severityIcon']}" id="imageErrorSeverity" style="padding: 10px; "/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumnReportErrors" sort="column1" valign="middle" width="1000">
                                        <webuijsf:panelGroup block="true" id="groupPanelReportErrors" separator="&lt;br/&gt;" style="border-width: 0px; ">
                                            <webuijsf:panelLayout id="layoutPanelErrorSummary" panelLayout="flow" style="padding: 10px; height: 100%; width: 100%">
                                                <webuijsf:staticText id="staticTextErrorLocation" text="#{currentRow.value['location']}"/>
                                                <webuijsf:staticText id="staticTextErrorMessage" style="font-weight: bold" text="#{currentRow.value['message']}"/>
                                            </webuijsf:panelLayout>
                                            <webuijsf:staticText id="staticTextErrorDetails" style="padding: 10px; " text="#{currentRow.value['details']}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn align="center" binding="#{Result.tableColumnHelp}" id="tableColumnHelp"
                                        rendered="#{SessionBean1.helpAvailableAtLeastOnce}" valign="middle" width="200">
                                        <webuijsf:panelGroup id="groupPanelHelp" rendered="#{currentRow.value['helpReferenceAvailable']}" separator="&lt;br/&gt;">
                                            <webuijsf:staticText binding="#{Result.staticTextHelp}" id="staticTextHelp" text="#{msg.helpLabel}"/>
                                            <webuijsf:imageHyperlink binding="#{Result.imageHyperlinkHelp}" height="52" id="imageHyperlinkHelp"
                                                imageURL="/resources/img/PdfIcon.png" target="_blank" url="#{currentRow.value['helpReferenceLink']}" width="52"/>
                                            <webuijsf:hyperlink binding="#{Result.hyperlinkHelp}" id="hyperlinkHelp" target="_blank"
                                                text="#{currentRow.value['helpReference']}" url="#{currentRow.value['helpReferenceLink']}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn align="center" binding="#{Result.tableColumnLexicalScope}" id="tableColumnLexicalScope"
                                        rendered="#{SessionBean1.lexicalScopeAvailableAtLeastOnce}" valign="middle" width="200">
                                        <webuijsf:panelGroup id="groupPanelLexicalScope" rendered="#{currentRow.value['lexicalScopeReferenceAvailable']}" separator="&lt;br/&gt;">
                                            <webuijsf:staticText binding="#{Result.staticTextLexicalScopeHeader}" id="staticTextLexicalScopeHeader" text="#{msg.lexicalScopeHeader}"/>
                                            <webuijsf:imageHyperlink binding="#{Result.imageHyperlinkLexicalScope}" height="52" id="imageHyperlinkLexicalScope"
                                                imageURL="/resources/img/LexicalScopeIcon.gif" target="_blank"
                                                url="#{currentRow.value['lexicalScopeReferenceLink']}" width="52"/>
                                            <webuijsf:staticText binding="#{Result.staticTextLexicalScope}" id="staticTextLexicalScope" text="#{currentRow.value['lexicalScopeReference']}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:panelLayout id="layoutPanelButtons" panelLayout="flow" style="width: 100%; height: 100%;">
                                <webuijsf:button actionExpression="#{Result.previousPageButton_action}" binding="#{Result.previousPageButton}"
                                    id="previousPageButton" style="font-size: 14px; width: 150px" text="#{msg.goBack}"/>
                                <webuijsf:button actionExpression="#{Result.goDirectInputButton_action}" binding="#{Result.goDirectInputButton}"
                                    id="goDirectInputButton" style="font-size: 14px; width: 250px" text="#{msg.goDirectInput}" rendered="#{SessionBean1.selectedTab ne 'tabDirectInput'}"/>
                            </webuijsf:panelLayout>
                        </h:panelGrid>
                        <div style="">
                            <jsp:directive.include file="Footer_LomVS.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>