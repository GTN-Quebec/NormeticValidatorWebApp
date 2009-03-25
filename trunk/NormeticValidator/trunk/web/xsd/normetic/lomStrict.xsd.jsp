<%@ page language="java" contentType="application/xml" %>
<!-- edited with XMLSpy v2007 rel. 3 sp1 (http://www.altova.com) by F. Bergeron (Xoxox) -->
<xs:schema xmlns="http://ltsc.ieee.org/xsd/LOM" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:ns1="http://ltsc.ieee.org/xsd/LOM/unique" xmlns:ns2="http://ltsc.ieee.org/xsd/LOM/vocab" xmlns:ns3="http://ltsc.ieee.org/xsd/LOM/extend" targetNamespace="http://ltsc.ieee.org/xsd/LOM" elementFormDefault="qualified" version="IEEE LTSC LOM XML 1.0">
    <xs:annotation>
        <xs:documentation>
        <%= request.getContextPath() %>
         This work is licensed under the Creative Commons Attribution-ShareAlike
         License.  To view a copy of this license, see the file license.txt,
         visit http://creativecommons.org/licenses/by-sa/2.0 or send a letter to
         Creative Commons, 559 Nathan Abbott Way, Stanford, California 94305, USA.
      </xs:documentation>
        <xs:documentation>
         This file represents a composite schema for validation of the following:
         1) The use of LOMv1.0 base schema (i.e., 1484.12.1-2002) vocabulary source/value
            pairs only
         2) Uniqueness constraints defined by LOMv1.0 base schema
         3) No existenace of any defined XML attribute/element extensions
      </xs:documentation>
        <xs:documentation>
         This file was modified slightly to validate Normetic application profile v1.1.
         Modified by: Frédéric Bergeron &lt;frederic.bergeron@licef.teluq.uqam.ca&gt;
         Date: 2007/05
      </xs:documentation>
    </xs:annotation>
    <!-- Learning Object Metadata -->
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/anyElement.xsd"/>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/unique" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/unique/strict.xsd"/>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/vocab" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/vocab/strict.xsd.jsp"/>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/extend" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/extend/strict.xsd"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/dataTypes.xsd.jsp"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/elementNames.xsd"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/elementTypes.xsd.jsp"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/rootElement.xsd"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/vocabValues.xsd"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/common/vocabTypes.xsd.jsp"/>
    <xs:include schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/normetic/vocabValues.xsd"/>
</xs:schema>