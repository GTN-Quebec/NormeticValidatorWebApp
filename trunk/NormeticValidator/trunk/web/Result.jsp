<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ValidationRaport
    Created on : 8-Apr-2008, 10:44:28 AM
    Author     : jcano
-->
<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<f:view locale="#{applicationScope.defaultLocale}">
    <f:loadBundle basename="lomvs.Bundle" var="msg"/>
    <html>
        <head>
            <title>Validation</title>
            <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/stylesheet.css" type="text/css" />
        </head>
        <body onload="" id="body1">
            <h:form id="form1">
                <div>
                    <jsp:directive.include file="Header_LomVS.jspf"/>
                </div>
                <h:panelGrid cellspacing="20" id="mainPanel2" style="margin-bottom: 30px;" width="100%">
                    <h:panelGrid columns="2" id="gridPaneGeneralInfo" rendered="false" style="border-style: ridge; border-color: gray; background-color: rgb(204, 204, 204); height: 192px; width: 100%">
                        <h:outputLabel id="label5" style="font-size: 14px" value="Result"/>
                        <h:outputText id="staticText7"/>
                        <h:outputLabel id="label4" style="font-size: 14px" value="File"/>
                        <h:outputText id="fileNamestaticText"/>
                        <h:outputLabel id="label3" style="font-size: 14px" value="Doctype"/>
                        <h:outputText id="fileTypeStaticText"/>
                        <h:outputLabel id="label2" style="font-size: 14px" value="RootElement"/>
                        <h:outputText id="rootElementstaticText"/>
                        <h:outputLabel id="label1" style="font-size: 14px" value="Root Namespace"/>
                        <h:outputText id="nameSpacestaticText"/>
                    </h:panelGrid>
                    <h:outputText id="staticTextReportTitle" style="font-size: 24px" value="#{msg.reportTitle}"/>
                    <h:outputText id="staticTextLom" value="#{Result.submittedLomHeader}"/>
                    <h:inputTextarea id="textAreaLom" readonly="true" rows="20" value="#{SessionBean1.decoratedValidatedString}" style="width:90%;"/>
                    <h:panelGroup styleClass="verdict#{SessionBean1.verdict}" layout="block">
                        <h:panelGroup layout="block" styleClass="verdictSummary">
                            <h:graphicImage value="../resources/img/#{SessionBean1.verdict}.gif"/>
                            <h:outputText value="#{SessionBean1.verdictSummary}"/>
                        </h:panelGroup>
                        <h:outputText value="#{SessionBean1.verdictDetail}" styleClass="verdictDetail"/>
                    </h:panelGroup>
                    <h:dataTable cellpadding="10" id="tableReportErrors" var="currentRow" styleClass="report"
                                 rendered="#{SessionBean1.hasIssues}" columnClasses="reportSeverity,reportErrors,reportHelp,reportScope"
                                 value="#{SessionBean1.issues}" style="valign:middle; text-align:center;width: 100%;">
                        <f:facet name="caption">
                            <h:outputText value="#{msg.errorTableTitle} (#{SessionBean1.issuesCount})"></h:outputText>
                        </f:facet>
                        <h:column id="tableColumnErrorSeverity">
                            <h:graphicImage value="/resources/img/#{currentRow.severityIcon}" id="imageErrorSeverity" 
                                            style="valign:top;padding: 10px;" width="24" height="24" />
                        </h:column>
                        <h:column id="tableColumnReportErrors"  > <!-- sort="column1"-->
                            <p>
                                <h:panelGroup id="layoutPanelErrorSummary"  style="padding: 10px; height: 100%; width: 100%">
                                    <h:outputText id="staticTextErrorLocation" value="#{currentRow.location}"/>
                                    <h:outputText id="staticTextErrorMessage" style="font-weight: bold" value="#{currentRow.message}"/>
                                </h:panelGroup>
                            </p>
                            <p>
                                <h:outputText id="staticTextErrorDetails" style="padding: 10px; " value="#{currentRow.details}"/>
                            </p>
                        </h:column>
                        <h:column id="tableColumnHelp"
                                  rendered="#{SessionBean1.helpAvailableAtLeastOnce}" > <!-- sort=columnt1 -->
                            <h:panelGrid id="groupPanelHelp" rendered="#{currentRow.helpReferenceAvailable}" ><!-- separator="&lt;br/&gt;" -->
                                <h:outputText id="staticTextHelp" value="#{msg.helpLabel}"/>
                                <h:outputLink id="imageHyperlinkHelp"
                                              target="_blank" value="#{currentRow.helpReferenceLink}">
                                    <h:graphicImage height="52" url="/resources/img/PdfIcon.png" width="52"/>
                                </h:outputLink>
                                <h:outputLink id="hyperlinkHelp" target="_blank"
                                              value="#{currentRow.helpReferenceLink}">
                                    <h:outputText value="#{currentRow.helpReference}"/>
                                </h:outputLink>
                            </h:panelGrid>
                        </h:column>
                        <h:column  id="tableColumnLexicalScope"
                                   rendered="#{SessionBean1.lexicalScopeAvailableAtLeastOnce}">
                            <h:panelGrid id="groupPanelLexicalScope" rendered="#{currentRow.lexicalScopeReferenceAvailable}" ><!-- separator="&lt;br/&gt;" -->
                                <h:outputText id="staticTextLexicalScopeHeader" value="#{msg.lexicalScopeHeader}"/>
                                <h:outputLink id="imageHyperlinkLexicalScope"
                                              target="_blank" value="#{currentRow.lexicalScopeReferenceLink}">
                                    <h:graphicImage height="52" url="/resources/img/LexicalScopeIcon.gif" width="52"/>
                                </h:outputLink>
                                <h:outputLink id="hyperlinkLexicalScope" target="_blank" value="#{currentRow.lexicalScopeReferenceLink}">
                                    <h:outputText value="#{currentRow.lexicalScopeReference}"/>
                                </h:outputLink>
                            </h:panelGrid>
                        </h:column>
                    </h:dataTable>
                    <h:panelGrid id="layoutPanelButtons" columns="2" style="width: 100%; height: 100%;">
                        <h:commandButton id="previousPageButton" style="font-size: 14px; width: 150px" value="#{msg.goBack}"
                                         action="#{Result.previousPageButton_action}"/>
                        <h:commandButton id="goDirectInputButton" rendered="#{SessionBean1.selectedTab ne 'tabDirectInput'}"
                                         style="font-size: 14px; width: 250px" value="#{msg.goDirectInput}"
                                         action="#{Result.goDirectInputButton_action}"/>
                    </h:panelGrid>
                </h:panelGrid>
                <div>
                    <jsp:directive.include file="Footer_LomVS.jspf"/>
                </div>
            </h:form>
        </body>
    </html>
</f:view>
