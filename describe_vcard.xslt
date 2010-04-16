<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0"
                xmlns:v="http://www.imsglobal.org/xsd/imsvdex_v1p0">

  <xsl:output method="html"/>
  <xsl:param name="lang"/>
  <xsl:param name="fieldnum"/>

  <xsl:template match="v:vdex">
    <html>
      <head>
        <title>
          <xsl:call-template name="title" />
        </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
      </head>
      <body>
        <h1>
          <xsl:call-template name="title" />
        </h1>
        <h2>
          <xsl:apply-templates select="v:vocabName"/>
        </h2>
        <dl>
          <xsl:apply-templates select="v:term"/>
        </dl>
      </body>
    </html>      
  </xsl:template>

  <xsl:template name="title">
    <xsl:choose>
      <xsl:when test="$lang='fr'">
        <xsl:text>Vocabulaire pour le champ LOM </xsl:text>
      </xsl:when>
      <xsl:when test="$lang='en'">
        <xsl:text>Vocabulary for the LOM field </xsl:text>
      </xsl:when>
    </xsl:choose>
    <xsl:value-of select="$fieldnum"/>
  </xsl:template>

  <xsl:template match="v:term">
    <xsl:variable name="caption">
      <xsl:apply-templates select="v:caption"/>
    </xsl:variable>
    <dt>
      <xsl:choose>
        <xsl:when test="v:description and $caption != '' and translate($caption,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') != v:termIdentifier/text()">
          <em>
            <xsl:value-of select="$caption" />
          </em>
          <xsl:text> (</xsl:text>
            <code><xsl:value-of select="v:termIdentifier/text()"/></code>
          <xsl:text>)</xsl:text>
        </xsl:when>
        <xsl:otherwise>
          <code><xsl:value-of select="v:termIdentifier/text()"/></code>
        </xsl:otherwise>
      </xsl:choose>
    </dt>
    <dd>
      <xsl:choose>
        <xsl:when test="not(v:description)">
          <xsl:value-of select="$caption" />
        </xsl:when>
        <xsl:otherwise>
          <xsl:apply-templates select="v:description"/>
        </xsl:otherwise>
      </xsl:choose>
    </dd>
  </xsl:template>

  <xsl:template match="v:langstring">
    <xsl:if test="not(@language) or substring(@language,1,2)=$lang">
      <xsl:value-of select="text()"/>
    </xsl:if>
  </xsl:template>

  <xsl:template match="/">
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="*">
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="text()"/>

</xsl:stylesheet>