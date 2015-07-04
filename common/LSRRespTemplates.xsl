<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:FormatUtil="http://xml.apache.org/xalan/xsltc/java/com.nightfire.maputil.FormatUtil" exclude-result-prefixes="FormatUtil">

	<xsl:template match="/">
	</xsl:template>

	<!-- Mapping For Header Templates coomon to all responses -->
	<xsl:template name="Header_TO_Header">
		<xsl:for-each select="header">
			<xsl:call-template name="srcSystemCd_TO_srcSystemCd"/>
			<xsl:call-template name="srcSystemVer_TO_srcSystemVer"/>
			<xsl:call-template name="capability_TO_capability"/>
			<xsl:call-template name="orderIntent_TO_orderIntent"/>
			<xsl:call-template name="clecCd_TO_clecCd"/>
			<xsl:call-template name="mrktCd_TO_mrktCd"/>
			<xsl:call-template name="trgtSystemCd_TO_trgtSystemCd"/>
			<xsl:call-template name="trgtSystemVer_TO_trgtSystemVer"/>
		</xsl:for-each>
	</xsl:template>

	<!-- Fields whose mapping has to be taken from request body  -->

	<xsl:template name="body_TO_Response_body">
		<xsl:param name="RES"/>
		<xsl:for-each select="body/localAdmin/admin">
			<xsl:call-template name="ACT_TO_act"/>
			<xsl:call-template name="SUP_TO_sup"/>
			<xsl:text>transTyp&#x9;</xsl:text>LSR_PS<xsl:text>&#x9;&#xA;</xsl:text>
			<xsl:call-template name="DDD_TO_rqstDD"/>
			<xsl:call-template name="ATN_TO_rqstTN"/>
			<xsl:if test="not($RES = 'ack' or $RES = 'negack')">
				<xsl:call-template name="lspVrsn_TO_lspVrsn"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="pn_transTyp">
		<xsl:text>transTyp&#x9;</xsl:text>LINE_LOSS<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="notification_field_TO_body">
		<xsl:for-each select="/Response/Request/msgenvelope">
			<xsl:call-template name="ackcd_TO_ackcd"/>
			<xsl:call-template name="activitySource_TO_activitySource"/>
			<xsl:call-template name="activityType_TO_activityType"/>
			<xsl:call-template name="activityDt_TO_activityDt"/>
			<xsl:call-template name="DDD_TO_dd"/>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="srcSystemCd_TO_srcSystemCd">
		<xsl:text>srcSystemCd</xsl:text>
		<xsl:text>&#x9;</xsl:text>
		<xsl:value-of select="/Response/Request/msgenvelope/header/tpCd"/>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>


	<xsl:template name="srcSystemVer_TO_srcSystemVer">
		<xsl:text>srcSystemVer&#x9;01</xsl:text>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="capability_TO_capability">

		<xsl:if test="capability != ''">
			<xsl:text>capability</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="capability"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>


	<xsl:template name="orderIntent_TO_orderIntent">
		<xsl:if test="orderIntent != ''">
			<xsl:text>orderIntent</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="orderIntent"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>


	<xsl:template name="clecCd_TO_clecCd">
		<xsl:if test="clecCd != ''">
			<xsl:text>clecCd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="clecCd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="mrktCd_TO_mrktCd">
		<xsl:if test="mrktCd != ''">
			<xsl:text>mrktCd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="mrktCd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="trgtSystemCd_TO_trgtSystemCd">
		<xsl:if test="srcSystemCd != ''">
			<xsl:text>trgtSystemCd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="srcSystemCd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="trgtSystemVer_TO_trgtSystemVer">
		<xsl:if test="srcSystemVer != ''">
			<xsl:text>trgtSystemVer</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="srcSystemVer"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>


	<!-- Fields whose mapping has to be taken from request -->

	<xsl:template name="ACT_TO_act">
		<xsl:if test="act != ''">
			<xsl:text>act</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="act"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="SUP_TO_sup">
		<xsl:if test="sup != ''">
			<xsl:text>sup</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="sup"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>



	<xsl:template name="DDD_TO_rqstDD">
		<xsl:if test="ddd != ''">
			<xsl:text>rqstDD</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="ddd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>
	<xsl:template name="dd_From_Req">
		<xsl:if test="/Response/Request/msgenvelope/body/localAdmin/admin/ddd != ''">
			<xsl:text>dd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="/Response/Request/msgenvelope/body/localAdmin/admin/ddd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="ATN_TO_rqstTN">
		<xsl:param name="hyphen"/>
		<xsl:if test="atn != ''">
			<xsl:variable name="val" select="atn"/>
			<xsl:text>rqstTn</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatReqTel(string($val),string($hyphen))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="ackcd_TO_ackcd">
		<xsl:choose>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value='ack'">
				<xsl:text>ackCd&#x9;A</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value='negack'">
				<xsl:text>ackCd&#x9;R</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
		</xsl:choose>
	</xsl:template>


	<xsl:template name="activitySource_TO_activitySource">
		<xsl:if test="header/tpCd != ''">
			<xsl:text>activitySource</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="header/tpCd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="activityType_TO_activityType">
		<xsl:choose>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value='ack'">
				<xsl:text>activityType&#x9;A</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value='negack'">
				<xsl:text>activityType&#x9;R</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
		</xsl:choose>
	</xsl:template>

	<xsl:template name="activityDt_TO_activityDt">
		<xsl:text>activityDt</xsl:text>
		<xsl:text>&#x9;</xsl:text>
		<xsl:value-of select="FormatUtil:getCurrentDate('yyyyMMdd')"/>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="DDD_TO_dd">
		<xsl:if test="body/localAdmin/admin/ddd != ''">
			<xsl:text>dd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="body/localAdmin/admin/ddd"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="lspVrsn_TO_lspVrsn">
		<xsl:if test="ver != ''">
			<xsl:text>lspVrsn</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="ver"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>


	<xsl:template name="msgTyp_TO_msgTyp">
		<xsl:choose>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value ='ack'">
				<xsl:text>msgTyp&#x9;997</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:text>respTyp&#x9;ACK</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value = 'negack'">
				<xsl:text>msgTyp&#x9;997</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:text>respTyp&#x9;NACK</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response/ResponseType/@value = 'billing_completion'">
				<xsl:text>msgTyp&#x9;865</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:text>respTyp&#x9;BILLING COMPLETE</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
			<xsl:when test="/Response/lsr_order_response/ResponseType/@value = 'suppaccept'">
				<xsl:choose>
					<xsl:when test="/Response/Request/msgenvelope/body/localAdmin/admin/sup ='1'">
						<xsl:text>msgTyp&#x9;865</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
						<xsl:text>respTyp&#x9;CANCEL COMPLETE</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>msgTyp&#x9;865</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
						<xsl:text>respTyp&#x9;CONFIRMATION</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response/ResponseType/@value ='soc'">
				<xsl:text>msgTyp&#x9;865</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:text>respTyp&#x9;PROVISIONING COMPLETE</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response/ResponseType/@value ='focaccept'">
				<xsl:text>msgTyp&#x9;855</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>

				<xsl:text>respTyp&#x9;CONFIRMATION</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
			<xsl:when test="/Response/lsr_order_response[ResponseType/@value='jeopardy' and jeopardy/lr/lr_adminsection/VER/@value != '']">
				<xsl:text>msgTyp&#x9;865</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:text>respTyp&#x9;JEOPARDY</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response[ResponseType/@value ='jeopardy' and not(jeopardy/lr/lr_adminsection/VER)]">
				<xsl:text>msgTyp&#x9;855</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>

				<xsl:text>respTyp&#x9;JEOPARDY</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response/ResponseType/@value ='focreject'">
				<xsl:text>msgTyp&#x9;855</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:choose>
					<xsl:when test="/Response/lsr_order_response/focreject/REJECTTYPE/@value='NONFATAL'">
						<xsl:text>respTyp&#x9;REJECT</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>respTyp&#x9;FATAL REJECT</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response/ResponseType/@value ='suppreject'">
				<xsl:text>msgTyp&#x9;865</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:choose>
					<xsl:when test="/Response/lsr_order_response/suppreject/REJECTTYPE/@value='NONFATAL'">
						<xsl:text>respTyp&#x9;REJECT</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>respTyp&#x9;FATAL REJECT</xsl:text>
						<xsl:text>&#x9;&#xA;</xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>

			<xsl:when test="/Response/lsr_order_response/ResponseType/@value ='provider_notification'">
				<xsl:text>msgTyp&#x9;836</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
				<xsl:text>respTyp&#x9;LOSS NOTIFICATION</xsl:text>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:when>
		</xsl:choose>
	</xsl:template>

	<!-- LR Adminsection (lr_adminsection) Templates -->

	<xsl:template name="CCNA_TO_ccna">
		<xsl:for-each select="CCNA[@value != '']">
			<xsl:text>ccna</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>


	<xsl:template name="PON_TO_transNo">
		<xsl:for-each select="PON[@value != '']">
			<xsl:text>tranNo</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="VER_TO_ver">
		<xsl:for-each select="VER[@value != '']">
			<xsl:text>ver</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>


	<xsl:template name="AN_TO_an">
		<xsl:param name="hyphen"/>
		<xsl:for-each select="AN[@value != '']">
			<xsl:text>an</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatReqTel(string(@value), string($hyphen))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="ATN_TO_atn">
		<xsl:param name="hyphen"/>
		<xsl:for-each select="ATN[@value != '']">
			<xsl:text>atn</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatReqTel(string(@value), string($hyphen))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="ORD_TO_ordrNo">
		<xsl:for-each select="ORD[@value != '']">
			<xsl:text>ordrNo</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="INIT_TO_init">
		<xsl:for-each select="INIT[@value != '']">
			<xsl:text>init</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="DTSENT_TO_cdtSent">
		<xsl:for-each select="DTSENT[@value != '']">
			<xsl:text>cdtSent</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="REP_TO_rep">
		<xsl:for-each select="REP[@value != '']">
			<xsl:text>rep</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="REP_TELNO_TO_repTelNo">
		<xsl:param name="hyphen"/>
		<xsl:for-each select="REP_TELNO[@value != '']">
			<xsl:text>repTelNo</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatReqTel(string(@value), string($hyphen))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="TELNO_TO_repTelNo">
		<xsl:param name="hyphen"/>
		<xsl:for-each select="TELNO[@value != '']">
			<xsl:text>repTelNo</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatReqTel(string(@value), string($hyphen))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="RT_TO_rt">
		<xsl:for-each select="RT[@value != '']">
			<xsl:text>rt</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="DD_TO_dd">
		<xsl:for-each select="DD[@value != '']">
			<xsl:text>dd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>


	<xsl:template name="ESDD_TO_esdd">
		<xsl:for-each select="ESDD[@value != '']">
			<xsl:text>esdd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="AFVR_TO_afvr">
		<xsl:for-each select="AFVR[@value != '']">
			<xsl:text>afvr</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="ERRORCODE_TO_errorCd">
		<xsl:for-each select="ERRORCODE[@value != '']">
			<xsl:text>errorCd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>


	<xsl:template name="ERRORTEXT_TO_errorDesc">
		<xsl:for-each select="ERRORTEXT[@value != '']">
			<xsl:text>errorDesc</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="ERRORMESSAGE_TO_errorDesc">
		<xsl:for-each select="ERRORMESSAGE[@value != '']">
			<xsl:text>errorDesc</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="RCODE_TO_errorCd">
		<xsl:for-each select="RCODE[@value != '']">
			<xsl:text>errorCd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>


	<xsl:template name="RDET_TO_errorDesc">
		<xsl:for-each select="RDET[@value != '']">
			<xsl:text>errorDesc</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="ORD_TO_ord">
		<xsl:for-each select="ORD[@value != '']">
			<xsl:text>ord</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<!-- LR Circuitdetail section (lr_circuitdetail) Templates -->


	<xsl:template name="LNUM_TO_lnum">
		<xsl:for-each select="LNUM[@value != '']">
			<xsl:text>lnum</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="TNS_TO_tns">
		<xsl:param name="hyphen"/>
		<xsl:for-each select="TNS[@value != '']">
			<xsl:text>tns</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatReqTel(string(@value), string($hyphen))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>



	<!-- LSRCM Admin section (lsrcm_adminsection) Templates -->
	<!-- For CCNA, PON, VER, AN, ATN, RT, REP mapping refer LR Adminsection Mapping  -->

	<xsl:template name="RDTSENT_TO_cdtSent">
		<xsl:for-each select="RDTSENT[@value != '']">
			<xsl:text>cdtSent</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="CD_TO_cd">
		<xsl:for-each select="CD[@value != '']">
			<xsl:text>cd</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>


	<!-- Other Templates   -->

	<xsl:template name="DTSENT_TO_lsp_dt_sent">
		<xsl:for-each select="DTSENT[@value != '']">
			<xsl:text>lsp_dt_sent</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="DTSENT_TO_rdtSent">
		<xsl:for-each select="DTSENT[@value != '']">
			<xsl:text>rdtSent</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="REMARKS_TO_remarks">
		<xsl:for-each select="../REMARKS[@value != '']">
			<xsl:text>remarks</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="@value"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="lsrNo_From_Req">
		<xsl:if test="/Response/Request/msgenvelope/body/localAdmin/admin/lsrNo!=''">
			<xsl:text>lsrNo</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="/Response/Request/msgenvelope/body/localAdmin/admin/lsrNo"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template name="cc_From_Req">
		<xsl:if test="/Response/Request/msgenvelope/body/localAdmin/admin/cc!=''">
			<xsl:text>cc</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="/Response/Request/msgenvelope/body/localAdmin/admin/cc"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>


	<xsl:template name="lsr_ack_TO_body">
		<xsl:for-each select="lsr_ack">
			<xsl:call-template name="PON_TO_transNo"/>
			<xsl:call-template name="VER_TO_ver"/>
			<xsl:call-template name="CCNA_TO_ccna"/>
			<xsl:call-template name="AN_TO_an"/>
			<xsl:call-template name="ATN_TO_atn"/>
			<xsl:call-template name="lsrNo_From_Req"/>
			<xsl:call-template name="cc_From_Req"/>
			<xsl:for-each select="TRANSACT">
				<xsl:text>doc2</xsl:text>
				<xsl:text>&#x9;</xsl:text>
				<xsl:value-of select="@value"/>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:for-each>

			<xsl:for-each select="GROUP">
				<xsl:text>doc1</xsl:text>
				<xsl:text>&#x9;</xsl:text>
				<xsl:value-of select="@value"/>
				<xsl:text>&#x9;&#xA;</xsl:text>
			</xsl:for-each>
			<xsl:for-each select="reasoncontainer/reason">
				<xsl:call-template name="ERRORCODE_TO_errorCd"/>
				<xsl:call-template name="ERRORTEXT_TO_errorDesc"/>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="REJECTTYPE_TO_REJECTTYPE">
		<xsl:text>REJECTTYPE</xsl:text>
		<xsl:text>&#x9;</xsl:text>
		<xsl:value-of select="REJECTTYPE/@value"/>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>


	<xsl:template name="OrderNo_TO_ordrNo">
		<xsl:text>ordrNo</xsl:text>
		<xsl:text>&#x9;</xsl:text>
		<xsl:value-of select="OrderNo/@value"/>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="OrderNo_TO_tranNo">
		<xsl:text>tranNo</xsl:text>
		<xsl:text>&#x9;</xsl:text>
		<xsl:value-of select="OrderNo/@value"/>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="default_ver">
		<xsl:text>ver	01</xsl:text>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="default_sup">
		<xsl:text>sup	null</xsl:text>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>
	<xsl:template name="default_act">
		<xsl:text>act	LLN</xsl:text>
		<xsl:text>&#x9;&#xA;</xsl:text>
	</xsl:template>

	<xsl:template name="DTSENT_TO_rDt">
		<xsl:for-each select="DTSENT[@value != '']">
			<xsl:text>rDt</xsl:text>
			<xsl:text>&#x9;</xsl:text>
			<xsl:value-of select="FormatUtil:formatMDCY(string(@value))"/>
			<xsl:text>&#x9;&#xA;</xsl:text>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>