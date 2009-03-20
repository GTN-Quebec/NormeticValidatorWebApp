<?xml version="1.0" encoding="UTF-8"?>
<!-- 
Document   : Page1
Created on : 2-Apr-2008, 10:07:18 AM
Author     : jcano
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view locale="#{applicationScope.defaultLocale}">
        <f:loadBundle basename="lomvs.Bundle" var="msg"/>
        <webuijsf:page binding="#{Validator.page1}" id="page1">
            <webuijsf:html binding="#{Validator.html1}" id="html1">
                <webuijsf:head binding="#{Validator.head1}" id="head1">
                    <webuijsf:link binding="#{Validator.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Validator.body1}" focus="form1:tabSet1:tab1:layoutPanel1:fileUpload1" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Validator.form1}" id="form1" style="">
                        <div>
                            <jsp:directive.include file="Header_LomVS.jspf"/>
                        </div>
                        <h:panelGrid binding="#{Validator.mainPanel}" id="mainPanel" style="margin-bottom: 30px;" width="100%">
                            <h:panelGrid cellspacing="20" id="gridPanelHeader" style="width: 100%; height: 100%;">
                                <webuijsf:staticText binding="#{Validator.staticTextTitle}" id="staticTextTitle" style="font-size: 24px" text="#{msg.validatorTitle}"/>
                                <webuijsf:staticText binding="#{Validator.staticTextDescription}" id="staticTextDescription" style="font-size: 14px" text="#{msg.validatorDescription}"/>
                            </h:panelGrid>
                            <webuijsf:tabSet binding="#{Validator.tabSetValidationMethods}" id="tabSetValidationMethods" lite="true"
                                selected="#{SessionBean1.selectedTab}" style="border-style: ridge; margin: 10px;">
                                <webuijsf:tab actionExpression="#{Validator.tabUpload_action}" binding="#{Validator.tabUpload}" id="tabUpload"
                                    style="font-size: 18px" styleClass="Tab1Lnk_sun4" text="#{msg.tab1Title}">
                                    <webuijsf:panelLayout binding="#{Validator.layoutPanel1}" id="layoutPanel1" style="margin: 20px; width: 100%;">
                                        <h:panelGrid cellspacing="20" id="gridPanel2">
                                            <webuijsf:label binding="#{Validator.labelTitle}" id="labelTitle" style="font-size: 14px" text="#{msg.Uploadtext1}"/>
                                            <webuijsf:upload binding="#{Validator.fileUpload1}" columns="80" id="fileUpload1" label="#{msg.Uploadtext2}"
                                                preservePath="true" style="font-size: 14px"/>
                                            <webuijsf:button actionExpression="#{Validator.uploadFileButton_action}" binding="#{Validator.uploadFileButton}"
                                                id="uploadFileButton" style="font-size: 18px; width: 150px" text="#{msg.check}"/>
                                            <webuijsf:messageGroup binding="#{Validator.messageGroup1}" id="messageGroup1"
                                                style="width: 100%; text-align: left;" title="#{msg.errorGroupTitle}"/>
                                        </h:panelGrid>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{Validator.tabDirectInput_action}" binding="#{Validator.tabDirectInput}" id="tabDirectInput"
                                    style="font-size: 18px" styleClass="Tab1Lnk_sun4" text="#{msg.tabdirectInput}">
                                    <webuijsf:panelLayout binding="#{Validator.layoutPanel2}" id="layoutPanel2" style="margin: 20px; width: 100%">
                                        <h:panelGrid cellspacing="20" id="gridPanel1">
                                            <webuijsf:label binding="#{Validator.labelDirectInputTitle}" id="labelDirectInputTitle" text="#{msg.directInputText}"/>
                                            <webuijsf:textArea binding="#{Validator.textAreaDirectInput}" columns="100" id="textAreaDirectInput" rows="15"
                                                text="#{SessionBean1.directInputLomString}" valueChangeListenerExpression="#{Validator.textAreaDirectInput_processValueChange}"/>
                                            <webuijsf:panelLayout id="layoutPanel3" panelLayout="flow">
                                                <webuijsf:button actionExpression="#{Validator.directInputbutton_action}"
                                                    binding="#{Validator.directInputbutton}" id="directInputbutton" style="font-size: 18px; width: 150px" text="#{msg.check}"/>
                                                <webuijsf:button actionExpression="#{Validator.buttonClearDirectInput_action}"
                                                    binding="#{Validator.buttonClearDirectInput}" id="buttonClearDirectInput" immediate="true"
                                                    style="font-size: 18px; width: 150px" text="#{msg.clearDirectInputText}"/>
                                            </webuijsf:panelLayout>
                                            <webuijsf:messageGroup binding="#{Validator.messageGroup2}" id="messageGroup2"
                                                style="width: 100%; text-align: left;" title="#{msg.errorGroupTitle}"/>
                                        </h:panelGrid>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                        </h:panelGrid>
                        <div>
                            <jsp:directive.include file="Footer_LomVS.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
