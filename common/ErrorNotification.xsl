<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:MapUtils="http://xml.apache.org/xalan/xsltc/java/com.nightfire.integrations.zteladapter.utils.MapUtils" exclude-result-prefixes="MapUtils">

	<xsl:template match="/">
		<msgenvelope>
			<header>
				<srcSystemCd>NeuStar</srcSystemCd>
				<srcSystemVer>01</srcSystemVer>
				<xsl:for-each select="msgenvelope/header">
					<xsl:copy-of select="capability"/>
					<xsl:copy-of select="orderIntent"/>
					<xsl:copy-of select="clecCd"/>
					<xsl:copy-of select="mrktCd"/>
				</xsl:for-each>
				<trgtSystemCd>ZOR</trgtSystemCd>
				<trgtSystemVer>01</trgtSystemVer>
			</header>
			<body>
				<xsl:for-each select="msgenvelope/body">
					<xsl:copy-of select="ordrno"/>
					<xsl:copy-of select="ccna"/>
					<xsl:for-each select="localAdmin/admin">
						<xsl:copy-of select="cc"/>
						<xsl:copy-of select="atn"/>
						<respTyp>ERROR</respTyp>
						<xsl:call-template name="create_Notify"/>
						<xsl:call-template name="create_RqstData"/>
					</xsl:for-each>
				</xsl:for-each>
			</body>
		</msgenvelope>
	</xsl:template>

	<!-- Creates the Error Notify Node -->
	<xsl:template name="create_Notify">
		<Notify>
			<tranNo>
				<xsl:value-of select="pon"/>
			</tranNo>
			<ver>
				<xsl:value-of select="ver"/>
			</ver>
			<act>
				<xsl:value-of select="act"/>
			</act>
			<activitySource>
				<xsl:value-of select="/msgenvelope/header/srcSystemCd"/> </activitySource>
			<activityType>E</activityType>
			<activityDt>
				<xsl:value-of select="dtsent"/>
			</activityDt>
			<error>
				<xsl:choose>
					<xsl:when test="contains(/msgenvelope/ERROR_MESSAGE/@value,'ruleerror')">
						<errorCd>DATA ERROR</errorCd>
						<errorInternalCd>DATA ERROR</errorInternalCd>
						<errorInfo>
							<errorDesc>
								<xsl:value-of select="MapUtils:getErrorMessage(string(/msgenvelope/ERROR_MESSAGE/@value),string('MESSAGE value=&quot;'),string('&quot; /&gt;'))"/>
							</errorDesc>
							<errorInternalDesc>[mxs_cExValidate] mxs.cc(2243): <xsl:value-of select="/msgenvelope/ERROR_MESSAGE/@value"/>
							</errorInternalDesc>
						</errorInfo>
					</xsl:when>
					<xsl:otherwise>
						<errorCd>
							<xsl:value-of select="/msgenvelope/ERROR_TYPE/@value"/>
						</errorCd>
						<errorInternalCd>
							<xsl:value-of select="/msgenvelope/ERROR_TYPE/@value"/>
						</errorInternalCd>
						<errorInfo>
							<errorDesc>
								<xsl:value-of select="/msgenvelope/ERROR_MESSAGE/@value"/>
							</errorDesc>
							<errorInternalDesc>[mxs_cExValidate] mxs.cc(2243): <xsl:value-of select="/msgenvelope/ERROR_MESSAGE/@value"/>
							</errorInternalDesc>
						</errorInfo>
					</xsl:otherwise>
				</xsl:choose>
			</error>
		</Notify>
	</xsl:template>


	<!-- Creates the RqstData Node -->	
	<xsl:template name="create_RqstData">
		<RqstData>
			<rqstDD>
				<xsl:value-of select="dtsent"/>
			</rqstDD>
			<lspVrsn>
				<xsl:value-of select="ver"/>
			</lspVrsn>
			<rqstTN>
				<rqstTN>
					<xsl:value-of select="atn"/>
				</rqstTN>
			</rqstTN>
		</RqstData>
	</xsl:template>	

</xsl:stylesheet><!-- Stylus Studio meta-information - (c)1998-2001 eXcelon Corp.
<metaInformation>
<scenarios ><scenario default="yes" name="Scenario1" userelativepaths="yes" url="..\..\..\..\..\..\..\..\..\NFI50_1\gateways\testgateway\output\rule error.xml" htmlbaseurl="" processortype="xalan" commandline="" additionalpath="E:\NFI43\lib" additionalclasspath="E:\NFI43\lib\spicommon.jar;E:\NFI43\lib\xercesImpl.jar;E:\NFI43\lib\xalan.jar;E:\NFI43\lib\xsltc.jar;E:\NFI43\lib\nfcommon.jar;E:\NFI43\lib\activation.jar;E:\NFI50_1" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext=""/></scenarios><MapperInfo  srcSchemaPath="" srcSchemaRoot="" srcSchemaPathIsRelative="yes" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" />
</metaInformation>
-->