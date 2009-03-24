<%@ page language="java" contentType="application/xml" %>
<!-- edited with XMLSpy v2007 rel. 3 sp1 (http://www.altova.com) by F. Bergeron (Xoxox) -->
<xs:schema xmlns="http://ltsc.ieee.org/xsd/LOM" xmlns:ag="http://ltsc.ieee.org/xsd/LOM/unique" xmlns:ex="http://ltsc.ieee.org/xsd/LOM/extend" xmlns:voc="http://ltsc.ieee.org/xsd/LOM/vocab" xmlns:xs="http://www.w3.org/2001/XMLSchema" targetNamespace="http://ltsc.ieee.org/xsd/LOM" elementFormDefault="qualified" version="IEEE LTSC LOM XML 1.0">
    <xs:annotation>
        <xs:documentation>
         This work is licensed under the Creative Commons Attribution-ShareAlike
         License.  To view a copy of this license, see the file license.txt,
         visit http://creativecommons.org/licenses/by-sa/2.0 or send a letter to
         Creative Commons, 559 Nathan Abbott Way, Stanford, California 94305, USA.
      </xs:documentation>
        <xs:documentation>
         This component schema defintion provides global type declarations for those
         LOM data elements whose values are taken from a Vocabulary data type.
      </xs:documentation>
    </xs:annotation>
    <xs:annotation>
        <xs:documentation>This component XSD requires schema components from other 
       schemas that are defined in other namespaces.  These statements import the 
       appropriate components. The xsi:schemaLocation attribute is used to specify 
       the location of the file that contains the schema that defines the namespace.  
       The xsi:schemaLocation attribute is optional and is ommitted.  By definition of 
       the composite schemas the appropriate namespaces and related files where those
       namespaces are defined are brought into scope.  Some XML parsers may require 
       these import statements to contain the optional xsi:schemaLocation attribute.</xs:documentation>
    </xs:annotation>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/unique" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/unique/strict.xsd"/>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/extend" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/extend/strict.xsd"/>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/vocab" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/vocab/strict.xsd.jsp"/>
    <!-- Vocabulary type declarations -->
    <!-- Source -->
    <xs:complexType name="sourceValue">
        <xs:simpleContent>
            <xs:extension base="voc:source">
                <xs:attributeGroup ref="ag:source"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 1.7 Structure -->
    <xs:complexType name="structureVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="structureValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="structureValue">
        <xs:simpleContent>
            <xs:extension base="voc:structure">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 1.8 Aggregation Level -->
    <xs:complexType name="aggregationLevelVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="aggregationLevelValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="aggregationLevelValue">
        <xs:simpleContent>
            <xs:extension base="voc:aggregationLevel">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 2.2 Status -->
    <xs:complexType name="statusVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="statusValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="statusValue">
        <xs:simpleContent>
            <xs:extension base="voc:status">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 2.3.1 Role -->
    <xs:complexType name="roleVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="roleValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="roleValue">
        <xs:simpleContent>
            <xs:extension base="voc:role">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 3.2.1 Role -->
    <xs:complexType name="roleMetaVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="roleMetaValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="roleMetaValue">
        <xs:simpleContent>
            <xs:extension base="voc:roleMeta">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 4.4.1.1 Type -->
    <xs:complexType name="typeVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="typeValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="typeValue">
        <xs:simpleContent>
            <xs:extension base="voc:type">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 4.4.1.2 Name -->
    <xs:complexType name="nameVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="nameValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="nameValue">
        <xs:simpleContent>
            <xs:extension base="voc:name">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.1 Interactivity Type -->
    <xs:complexType name="interactivityTypeVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="interactivityTypeValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="interactivityTypeValue">
        <xs:simpleContent>
            <xs:extension base="voc:interactivityType">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.2 Learning Resource Type -->
    <xs:complexType name="learningResourceTypeVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="learningResourceTypeValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="learningResourceTypeValue">
        <xs:simpleContent>
            <xs:extension base="voc:learningResourceType">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.3 Interactivity Level -->
    <xs:complexType name="interactivityLevelVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="interactivityLevelValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="interactivityLevelValue">
        <xs:simpleContent>
            <xs:extension base="voc:interactivityLevel">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.4 Semantic Density -->
    <xs:complexType name="semanticDensityVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="semanticDensityValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="semanticDensityValue">
        <xs:simpleContent>
            <xs:extension base="voc:semanticDensity">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.5 Intended End User Role -->
    <xs:complexType name="intendedEndUserRoleVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="intendedEndUserRoleValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="intendedEndUserRoleValue">
        <xs:simpleContent>
            <xs:extension base="voc:intendedEndUserRole">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.6 Context -->
    <xs:complexType name="contextVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="contextValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="contextValue">
        <xs:simpleContent>
            <xs:extension base="voc:context">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 5.8 Difficulty -->
    <xs:complexType name="difficultyVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="difficultyValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="difficultyValue">
        <xs:simpleContent>
            <xs:extension base="voc:difficulty">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 6.1 Cost -->
    <xs:complexType name="costVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="costValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="costValue">
        <xs:simpleContent>
            <xs:extension base="voc:cost">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 6.2 Copyright and Other Restrictions -->
    <xs:complexType name="copyrightAndOtherRestrictionsVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="copyrightAndOtherRestrictionsValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="copyrightAndOtherRestrictionsValue">
        <xs:simpleContent>
            <xs:extension base="voc:copyrightAndOtherRestrictions">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 7.1 Kind -->
    <xs:complexType name="kindVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="kindValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="kindValue">
        <xs:simpleContent>
            <xs:extension base="voc:kind">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- 9.1 Purpose -->
    <xs:complexType name="purposeVocab">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="source" type="sourceValue"/>
            <xs:element name="value" type="purposeValue"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="purposeValue">
        <xs:simpleContent>
            <xs:extension base="voc:purpose">
                <xs:attributeGroup ref="ag:value"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
</xs:schema>
