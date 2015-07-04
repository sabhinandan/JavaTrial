<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:FormatUtil="http://xml.apache.org/xalan/xsltc/java/com.nightfire.maputil.FormatUtil" exclude-result-prefixes="FormatUtil">
	<xsl:output method="text" indent="no"/>
	<xsl:template match="/">
		<xsl:text>usoc.rule_set.</xsl:text>
		<xsl:choose>
			<xsl:when test="msgenvelope/header/tpCd='VRZ'">
				<xsl:text>NEUSTAR2VZE</xsl:text>
			</xsl:when>
			<xsl:when test="msgenvelope/header/tpCd='BST'">
				<xsl:text>NEUSTAR2BS</xsl:text>
			</xsl:when>
			<xsl:when test="msgenvelope/header/tpCd='AIT' or msgenvelope/header/tpCd='PBC' or msgenvelope/header/tpCd='SWB'" >
				<xsl:text>NEUSTAR2SBC</xsl:text>
			</xsl:when>
			<xsl:when test="msgenvelope/header/tpCd='VZW'">
				<xsl:text>NEUSTAR2VZW</xsl:text>
			</xsl:when>
			<xsl:when test="msgenvelope/header/tpCd='QST'">
				<xsl:text>NEUSTAR2QWEST</xsl:text>
			</xsl:when>
		</xsl:choose>
		<xsl:text>.</xsl:text><xsl:value-of select="msgenvelope/header/mrktCd"/>
		<xsl:text>.@code_category@</xsl:text>
		<xsl:choose>
			<xsl:when test="substring(msgenvelope/body/localAdmin/admin/tos,1,1) = '1'">
				<xsl:text>.BUSINESS</xsl:text>
			</xsl:when>
			<xsl:when test="substring(msgenvelope/body/localAdmin/admin/tos,1,1) = '2'">
				<xsl:text>.RESIDENCE</xsl:text>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
  
</xsl:stylesheet>