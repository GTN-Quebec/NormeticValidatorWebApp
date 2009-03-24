<%@ page language="java" contentType="application/xml" %>
<!-- edited with XMLSpy v2007 rel. 3 sp1 (http://www.altova.com) by F. Bergeron (Xoxox) -->
<xs:schema xmlns="http://ltsc.ieee.org/xsd/LOM" xmlns:ag="http://ltsc.ieee.org/xsd/LOM/unique" xmlns:ex="http://ltsc.ieee.org/xsd/LOM/extend" xmlns:xs="http://www.w3.org/2001/XMLSchema" targetNamespace="http://ltsc.ieee.org/xsd/LOM" elementFormDefault="qualified" version="IEEE LTSC LOM XML 1.0">
    <xs:annotation>
        <xs:documentation>
         This work is licensed under the Creative Commons Attribution-ShareAlike
         License.  To view a copy of this license, see the file license.txt,
         visit http://creativecommons.org/licenses/by-sa/2.0 or send a letter to
         Creative Commons, 559 Nathan Abbott Way, Stanford, California 94305, USA.
      </xs:documentation>
        <xs:documentation>
         This component schema defintion defines global schema data type declarations
         for data types defined in the LOMv1.0 base schema.
      </xs:documentation>
    </xs:annotation>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/unique" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/unique/strict.xsd"/>
    <xs:import namespace="http://ltsc.ieee.org/xsd/LOM/extend" schemaLocation="http://localhost:8080<%= request.getContextPath() %>/xsd/normetic/extend/strict.xsd"/>
    <!-- Data type declarations -->
    <!-- CharacterString -->
    <xs:simpleType name="CharacterString">
        <xs:restriction base="xs:string"/>
    </xs:simpleType>
    <!-- LanguageId -->
    <xs:complexType name="LanguageId">
        <xs:simpleContent>
            <xs:extension base="xs:language">
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- VCard -->
    <xs:complexType name="VCard">
        <xs:simpleContent>
            <xs:extension base="CharacterString">
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- MimeType -->
    <xs:simpleType name="MimeType">
        <xs:restriction base="CharacterString"/>
    </xs:simpleType>
    <!-- Size -->
    <xs:simpleType name="Size">
        <xs:restriction base="xs:nonNegativeInteger"/>
    </xs:simpleType>
    <!-- LanguageString -->
    <xs:complexType name="LanguageString">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="string" type="LangString"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
        <xs:attributeGroup ref="ex:customAttributes"/>
    </xs:complexType>
    <xs:complexType name="LangString">
        <xs:simpleContent>
            <xs:extension base="CharacterString">
                <xs:attribute name="language" type="xs:language"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- DateTime -->
    <xs:complexType name="DateTime">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="dateTime" type="DateTimeValue"/>
            <xs:element name="description" type="description"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
    </xs:complexType>
    <xs:complexType name="DateTimeValue">
        <xs:simpleContent>
            <xs:extension base="DateTimeString">
                <xs:attributeGroup ref="ag:DateTimeValue"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- Regular expresion from Christian Klaue -->
    <xs:simpleType name="DateTimeString">
        <xs:restriction base="CharacterString">
            <xs:pattern value="([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})(\-(0[1-9]|1[0-2])(\-(0[1-9]|[1-2][0-9]|3[0-1])(T([0-1][0-9]|2[0-3])(:[0-5][0-9](:[0-5][0-9](\.[0-9]{1,}(Z|((\+|\-)([0-1][0-9]|2[0-3]):[0-5][0-9]))?)?)?)?)?)?)?"/>
        </xs:restriction>
    </xs:simpleType>
    <!-- Duration -->
    <xs:complexType name="Duration">
        <xs:choice minOccurs="0" maxOccurs="unbounded">
            <xs:element name="duration" type="DurationValue"/>
            <xs:element name="description" type="description"/>
            <xs:group ref="ex:customElements"/>
        </xs:choice>
    </xs:complexType>
    <xs:complexType name="DurationValue">
        <xs:simpleContent>
            <xs:extension base="DurationString">
                <xs:attributeGroup ref="ag:DurationValue"/>
                <xs:attributeGroup ref="ex:customAttributes"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
    <!-- Regular expresion from Christian Klaue -->
    <xs:simpleType name="DurationString">
        <xs:restriction base="CharacterString">
            <xs:pattern value="P([0-9]{1,}Y){0,1}([0-9]{1,}M){0,1}([0-9]{1,}D){0,1}(T([0-9]{1,}H){0,1}([0-9]{1,}M){0,1}([0-9]{1,}(\.[0-9]{1,}){0,1}S){0,1}){0,1}"/>
        </xs:restriction>
    </xs:simpleType>
</xs:schema>
