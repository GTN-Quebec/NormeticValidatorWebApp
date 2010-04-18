<?xml version="1.0" encoding="UTF-8"?>
<!--
Document : Page1
Created on : 2-Apr-2008, 10:07:18 AM
Author : jcano
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
            <h:form id="form1" enctype="multipart/form-data">
                <div>
                    <jsp:directive.include file="Header_LomVS.jspf"/>
                </div>
                <h:panelGrid id="mainPanel" style="margin-bottom: 30px;" width="100%">
                    <h:panelGrid cellspacing="20" id="gridPanelHeader" style="width: 100%; height: 100%;">
                        <h:outputText id="staticTextTitle" style="font-size: 24px" value="#{msg.validatorTitle}"/>
                        <h:outputText id="staticTextDescription" style="font-size: 14px" value="#{msg.validatorDescription}"/>
                    </h:panelGrid>
                    <t:panelTabbedPane id="tabSetValidationMethods"
                                       selectedIndex="#{SessionBean1.selectedTab}">
                        <t:panelTab id="tabUpload" label="#{msg.tab1Title}">
                            <h:panelGrid cellspacing="20" id="gridPanel2" style="margin: 20px; width: 100%;">
                                <h:outputLabel id="labelTitle" value="#{msg.Uploadtext1}"/>
                                <h:panelGroup>
                                    <h:outputLabel value="#{msg.Uploadtext2}" style="margin-right:20px; font-size:14px;"/>
                                    <t:inputFileUpload id="fileUpload1" label="#{msg.Uploadtext2}" maxlength="8192"
                                                   value="#{SessionBean1.uploadedLomFile}" accept="*/*" style="border-width:1px;font-size:12px;"/>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:selectBooleanCheckbox id="checkboxShowRecommendationsForUpload"
                                        value="#{SessionBean1.showRecommendationsEnabled}"
                                        valueChangeListener="#{Validator.checkboxShowRecommendationsForUpload_processValueChange}"/>
                                    <h:outputLabel value="#{msg.showRecommendations}" style="font-size:12px;"/>
                                </h:panelGroup>
                                <h:commandButton action="#{Validator.uploadFileButton_action}"
                                                 id="uploadFileButton" value="#{msg.check}"/>
                                <t:messages showDetail="true" id="messageGroup1"
                                            style="width: 100%; text-align: left;"/>
                            </h:panelGrid>
                        </t:panelTab>
                        <t:panelTab id="tabDirectInput" label="#{msg.tabdirectInput}">
                            <h:panelGrid cellspacing="20" id="gridPanel1">
                                <h:outputLabel id="labelDirectInputTitle" value="#{msg.directInputText}"/>
                                <h:inputTextarea binding="#{Validator.textarea}" cols="100" id="textAreaDirectInput" rows="15"
                                                 value="#{SessionBean1.directInputLomString}"/>
                                <h:panelGroup>
                                    <h:selectBooleanCheckbox
                                        id="checkboxShowRecommendationsForDirectInput"
                                        value="#{SessionBean1.showRecommendationsEnabled}"/>
                                    <h:outputLabel value="#{msg.showRecommendations}"/>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:commandButton
                                        id="directInputbutton" value="#{msg.check}"
                                        action="#{Validator.directInputbutton_action}"/>
                                    <h:commandButton
                                        id="buttonClearDirectInput" immediate="true"
                                        value="#{msg.clearDirectInputText}"
                                        action="#{Validator.buttonClearDirectInput_action}"/>
                                </h:panelGroup>
                                <t:messages id="messageGroup2" showDetail="true"
                                            style="width: 100%; text-align: left;"/>
                            </h:panelGrid>
                        </t:panelTab>
                    </t:panelTabbedPane>
                </h:panelGrid>
                <div>
                    <jsp:directive.include file="Footer_LomVS.jspf"/>
                </div>
            </h:form>
        </body>
    </html>
</f:view>
