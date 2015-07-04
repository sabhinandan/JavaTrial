<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" omit-xml-declaration="no" encoding="UTF-8" version="1.0" />
	
	<xsl:template match="/">
		<xsl:apply-templates />
	</xsl:template>
	
	<xsl:template match="*">
		<xsl:variable name="varElemName" select="translate(name(), 'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')" />
		<xsl:element name="{$varElemName}">
			<xsl:for-each select="@*">
				<xsl:variable name="varAttribName" select="translate(name(), 'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')" />
				<xsl:attribute name="{$varAttribName}"><xsl:value-of select="."/></xsl:attribute>
			</xsl:for-each>
			<xsl:apply-templates />
		</xsl:element>
	</xsl:template>

	
</xsl:stylesheet>
