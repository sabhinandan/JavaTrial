<?xml version='1.0'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:FormatUtil="http://xml.apache.org/xalan/xsltc/java/com.nightfire.maputil.FormatUtil"
  exclude-result-prefixes="FormatUtil">

        <xsl:template name="ConvertWithValue">
		  <xsl:param name="Node"/>
		  <xsl:param name="Val"/>
		  <xsl:element name="{$Node}">
			<xsl:attribute name="value">
				<xsl:value-of select="$Val"/>
			</xsl:attribute>
		</xsl:element>
	</xsl:template>

	<xsl:template name="ccna_TO_CCNA">
	  <xsl:if test="ccna != ''">
		<CCNA value="{ccna}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="pon_TO_PON">
	 <xsl:if test="pon != ''">
		<PON value="{pon}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="ver_TO_VER">
	 <xsl:if test="ver != ''">
		<VER value="{ver}"/>
	 </xsl:if>
	</xsl:template>


	<!-- Field LOCQTY is not supported by ZTEL. As any CLEC will not send an order for multiple Service Locations, this field can be defaulted to value '001'. -->

	<xsl:template name="locqty_TO_LOCQTY">
	 <LOCQTY value="001"/>
	</xsl:template>

	<!-- Field HTQTY is not supported by ZTEL. It can be derived by counting the no. of occurences of hunt section (msgenvelope.body.localAdmin.hunt) and by proper padding to set it to 2 numeric. -->

	<xsl:template name="htqty_TO_HTQTY"> 
            <xsl:if test="../hunt">
		<HTQTY value="{format-number(count(../hunt),'00')}"/>
	    </xsl:if>	
	</xsl:template>

	<xsl:template name="atn_TO_ATN">
	 <xsl:if test="atn != ''">
	     <xsl:for-each select="atn">
	      <ATN>
		 <xsl:attribute name="value">
		 	<xsl:value-of select=(string(.))"/>
		 </xsl:attribute>
	      </ATN>
	      </xsl:for-each>
          </xsl:if>
	</xsl:template>
						
	<xsl:template name="dtsent_TO_DTSENT">
	 <xsl:if test="dtsent != ''">
	     <xsl:for-each select="dtsent">
	      <DTSENT>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="FormatUtil:formatCDSENT(substring(string(.),1,8),FormatUtil:format12to24(substring(string(.),9,6)))"/>
		 </xsl:attribute>
	      </DTSENT>
	      </xsl:for-each>
	 </xsl:if>
       	</xsl:template>

	<xsl:template name="ddd_TO_DDD">
	 <xsl:if test="ddd != ''">
	     <xsl:for-each select="ddd">
	      <DDD>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="FormatUtil:formatCYMD(string(.))"/>
		 </xsl:attribute>
	      </DDD>
	      </xsl:for-each>
	  </xsl:if>
       	</xsl:template>

	<xsl:template name="dddo_TO_DDDO">
	 <xsl:if test="dddo != ''">
	     <xsl:for-each select="dddo">
	      <DDDO>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="FormatUtil:formatCYMD(string(.))"/>
		 </xsl:attribute>
	      </DDDO>
	      </xsl:for-each>
	 </xsl:if>
       	</xsl:template>

	<xsl:template name="reqtyp_TO_REQTYP">
	 <xsl:if test="reqtyp != ''">
		<REQTYP value="{reqtyp}"/>
  	 </xsl:if>
	</xsl:template>

	<xsl:template name="act_TO_ACT">
	 <xsl:if test="act != ''">
		<ACT value="{act}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="sup_TO_SUP">
	 <xsl:if test="sup != ''">
		<SUP value="{sup}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="exp_TO_EXP">
	 <xsl:if test="exp != ''">
		<EXP value="{exp}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="cc_TO_CC">
	 <xsl:if test="cc != ''">
		<CC value="{cc}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="agauth_TO_AGAUTH">
	 <xsl:if test="agauth != ''">
		<AGAUTH value="{agauth}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="porttyp_TO_PORTTYP">
	 <xsl:if test="porttyp != ''">
		<PORTTYP value="{porttyp}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="actl_TO_ACTL">
	 <xsl:if test="actl != ''">
		<ACTL value="{actl}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="lst_TO_LST">
	 <xsl:if test="lst != ''">
		<LST value="{lst}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="lso_TO_LSO">
	 <xsl:if test="lso != ''">
		<LSO value="{lso}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="tos_TO_TOS">
	 <xsl:if test="tos != ''">
		<TOS value="{tos}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="spec_TO_SPEC">
	 <xsl:if test="spec != ''">
		<SPEC value="{spec}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="nc_TO_NC">
	 <xsl:if test="nc != ''">
		<NC value="{nc}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="nci_TO_NCI">
	 <xsl:if test="nci != ''">
		<NCI value="{nci}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="secnci_TO_SECNCI">
	 <xsl:if test="secnci != ''">
		<SECNCI value="{secnci}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="sli_TO_SLI">
	 <xsl:if test="sli != ''">
		<SLI value="{sli}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="ban1_TO_BAN1">
	 <xsl:if test="ban1 != ''">
		<BAN1 value="{ban1}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="acna_TO_ACNA">
	 <xsl:if test="acna != ''">
		<ACNA value="{acna}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="initname_TO_INIT">
	 <xsl:if test="name != ''">
		<INIT value="{name}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="inittelno_TO_INITTELNO">
	 <xsl:if test="telno != ''">
	     <xsl:for-each select="telno">
	      <TELNO>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </TELNO>
	      </xsl:for-each>
         </xsl:if>
	</xsl:template>


	<xsl:template name="impconname_TO_IMPCONNAME">
	 <xsl:if test="name != ''">
		<NAME value="{name}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="impcontelno_TO_IMPCONTELNO">
	 <xsl:if test="telno != ''">
	     <xsl:for-each select="telno">
	      <TELNO>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </TELNO>
	      </xsl:for-each>
         </xsl:if>
	</xsl:template>
	
	<xsl:template name="remarks_TO_REMARKS">
	 <xsl:if test="remarks != ''">
		<REMARKS value="{remarks}"/>
	 </xsl:if>
	</xsl:template>


	<xsl:template name="hnum_TO_HNUM">
	 <xsl:if test="hnum != ''">
		<HNUM value="{hnum}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="ha_TO_HA">
	 <xsl:if test="ha != ''">
		<HA value="{ha}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="hid_TO_HID">
	 <xsl:if test="hid != ''">
		<HID value="{hid}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="tip_TO_TIP">
	 <xsl:if test="tip != ''">
		<TIP value="{tip}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="tli_TO_TLI">
	 <xsl:if test="tli != ''">
	   <xsl:for-each select="tli">
	      <TLI>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </TLI>
	   </xsl:for-each>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="hntyp_TO_HNTYP">
	 <xsl:if test="hntyp != ''">
		<HNTYP value="{hntyp}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="hla_TO_HLA">
	 <xsl:if test="hla != ''">
		<HLA value="{hla}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="htseq_TO_HTSEQ">
	 <xsl:if test="htseq != ''">
		<HTSEQ value="{htseq}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="htn_TO_HTN">
	 <xsl:if test="htn != ''">
		 <xsl:for-each select="htn">
		      <HTN>
			 <xsl:attribute name="value">
				<xsl:value-of select="(string(.))"/>
			 </xsl:attribute>
		      </HTN>
		   </xsl:for-each>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="notyp_TO_NOTYP">
	 <xsl:if test="notyp != ''">
		<NOTYP value="{notyp}"/>
	 </xsl:if>
	</xsl:template>
	
	<xsl:template name="locnum_TO_LOCNUM">
	  <xsl:if test="locnum != ''">
	    	<LOCNUM value="{format-number(locnum,'000')}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="eulocnum_TO_LOCNUM">
	 <xsl:for-each select="/msgenvelope/body/localAdmin/location">
	  <xsl:if test="locnum != ''">
	    	<LOCNUM value="{format-number(locnum,'000')}"/>
 	 </xsl:if>
	  </xsl:for-each> 
	</xsl:template>


	<xsl:template name="name_TO_NAME">
	  <xsl:if test="name != ''">	
		<NAME value="{name}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="aft_TO_AFT">
	  <xsl:if test="aft != ''">
		<AFT value="{aft}"/>
 	 </xsl:if>
	</xsl:template>

	
	<xsl:template name="adrNo_TO_SANO">
	  <xsl:if test="adrNo != ''">
		<SANO value="{adrNo}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="adrSf_TO_SASF">
	  <xsl:if test="adrSf != ''">
		<SASF value="{adrSf}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="adrSdp_TO_SASD">
	  <xsl:if test="adrSdp != ''">
		<SASD value="{adrSdp}"/>
 	 </xsl:if>
	</xsl:template>
	
	<xsl:template name="adrSn_TO_SASN">
	  <xsl:if test="adrSn != ''">
		<SASN value="{adrSn}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="adrTh_TO_SATH">
	  <xsl:if test="adrTh != ''">
		<SATH value="{adrTh}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="adrSds_TO_SASS">
	  <xsl:if test="adrSds != ''">
		<SASS value="{adrSds}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="aai_TO_AAI">
	  <xsl:if test="aai != ''">
		<AAI value="{aai}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="ld1_TO_LD1">
	  <xsl:if test="ld1 != ''">
		<LD1 value="{ld1}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="lv1_TO_LV1">
	  <xsl:if test="lv1 != ''">
		<LV1 value="{lv1}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="ld2_TO_LD2">
	  <xsl:if test="ld2 != ''">
		<LD2 value="{ld2}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="lv2_TO_LV2">
	  <xsl:if test="lv2 != ''">
		<LV2 value="{lv2}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="ld3_TO_LD3">
	  <xsl:if test="ld3 != ''">
		<LD3 value="{ld3}"/>
 	 </xsl:if>
	</xsl:template>
	
	<xsl:template name="lv3_TO_LV3">
	  <xsl:if test="lv3 != ''">
		<LV3 value="{lv3}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="city_TO_CITY">
	  <xsl:if test="city != ''">
		<CITY value="{city}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="state_TO_STATE">
	  <xsl:if test="state != ''">
		<STATE value="{state}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="zipcode_TO_ZIP">
	  <xsl:if test="zipcode != ''">
		<ZIP value="{zipcode}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="lcon_TO_LCON">
	  <xsl:if test="lcon != ''">
		<LCON value="{lcon}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="lconTelno_TO_TELNO">
	  <xsl:if test="lconTelno != ''">
	   <xsl:for-each select="lconTelno">
	      <TELNO>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </TELNO>
	      </xsl:for-each>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="wsop_TO_WSOP">
	  <xsl:if test="wsop != ''">
		<WSOP value="{wsop}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="eatn_TO_EATN">
	  <xsl:if test="eatn != ''">
	    <xsl:for-each select="eatn">
	      <EATN>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </EATN>
	      </xsl:for-each>
	  </xsl:if>
	</xsl:template>

	<xsl:template name="fbi_TO_FBI">
	  <xsl:if test="fbi != ''">
		<FBI value="{fbi}"/>
 	 </xsl:if>
	</xsl:template>
	
	<xsl:template name="dnum_TO_DNUM">
	  <xsl:if test="dnum != ''">
		<DNUM value="{format-number(dnum,'00000')}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="discNmbr_TO_DISCNBR">
	  <xsl:if test="discNmbr != ''">
	     <xsl:for-each select="discNmbr">
	      <DISCNBR>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </DISCNBR>
	     </xsl:for-each>
	   </xsl:if>
	</xsl:template>
		
	<!-- Field PQTY is not supported by ZTEL. We can derive this field by counting the no. of
	ps_servicedetails occurences  with proper padding to set it to 5 numeric.-->

	<xsl:template name="pqty_TO_PQTY">
		<PQTY value="{format-number(count(service),'00000')}"/>
	</xsl:template>


	<xsl:template name="lnum_TO_LNUM">
	  <xsl:if test="lnum != ''">
		<LNUM value="{format-number(lnum,'00000')}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="lna_TO_LNA">
	  <xsl:if test="lna != ''">
		<LNA value="{lna}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="ltos_TO_LTOS">
	  <xsl:if test="ltos != ''">
		<LTOS value="{ltos}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="tns_TO_TNS">
	  <xsl:if test="tns != ''">
	   <xsl:for-each select="tns">
	      <TNS>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </TNS>
	      </xsl:for-each>
	</xsl:if>
	</xsl:template>

	<xsl:template name="ters_TO_TERS">
	  <xsl:if test="ters != ''">
         <TERS value="{ters}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="otn_TO_OTN">
	  <xsl:if test="otn != ''">
  	   <xsl:for-each select="otn">
	      <OTN>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </OTN>
	   </xsl:for-each>
	  </xsl:if>
	</xsl:template>

	<xsl:template name="pic_TO_PIC">
	  <xsl:if test="pic != ''">
		<PIC value="{pic}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="lpic_TO_LPIC">
	  <xsl:if test="lpic != ''">
		<LPIC value="{lpic}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="ecckt_TO_ECCKT">
	  <xsl:if test="ecckt != ''">
		<ECCKT value="{ecckt}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="systemid_TO_SYSTEMID">
	 <xsl:if test="systemid != ''">
		<SYSTEMID value="{systemid}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="shelf_TO_SHELF">
	 <xsl:if test="shelf != ''">
		<SHELF value="{shelf}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="sai_TO_s">
	  <xsl:if test="sai != ''">
		<S value="{sai}"/>
 	 </xsl:if>
	</xsl:template>
	
	
	<xsl:template name="tcopt_TO_TCOPT">
	  <xsl:if test="tcopt != ''">
		<TCOPT value="{tcopt}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="tctopri_TO_TCTOPRI">
	  <xsl:if test="tctopri != ''">
	   <xsl:for-each select="tctopri">
	      <TCTOPRI>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </TCTOPRI>
	   </xsl:for-each>
	  </xsl:if>
	</xsl:template>

	<xsl:template name="tcid_TO_TCIDPRI">
	  <xsl:if test="tcid != ''">
		<TCIDPRI value="{tcid}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="tcname_TO_TCNAMEPRI">
	  <xsl:if test="tcname != ''">
		<TCNAMEPRI value="{tcname}"/>
 	 </xsl:if>
	</xsl:template>


	<xsl:template name="tcper_TO_TCPER">
	<xsl:if test="tcper != ''">
	   <xsl:for-each select="tcper">
		<TCPER>
		<xsl:choose>
		<xsl:when test="string-length(string(.)) = 8">
		   <xsl:attribute name="value">
		 	<xsl:value-of select="FormatUtil:formatCYMD(string(.))"/>
		   </xsl:attribute>
		 </xsl:when>
		 <xsl:otherwise>
		   <xsl:attribute name="value">
		 	<xsl:value-of select="FormatUtil:formatCDSENT(substring(string(.),1,8),FormatUtil:format12to24(substring(string(.),9,6)))"/>
		   </xsl:attribute>
		 </xsl:otherwise>
		</xsl:choose>
		</TCPER>
	    </xsl:for-each>
 	 </xsl:if>
	</xsl:template>


	<xsl:template name="ba_TO_BA">
	  <xsl:if test="ba != ''">
		<BA value="{ba}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="block_TO_BLOCK">
	  <xsl:if test="block != ''">
		<BLOCK value="{block}"/>
 	 </xsl:if>
	</xsl:template>



	<xsl:template name="fa_TO_FA">
	  <xsl:if test="fa != ''">
		<FA value="{fa}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="feature_TO_FEATURE">
	  <xsl:if test="feature != ''">
		<FEATURE value="{feature}"/>
 	 </xsl:if>
	</xsl:template>

        <xsl:template name="value_TO_FEATUREDETAIL">
	  <xsl:if test="value != ''">
		<FEATUREDETAIL value="{value}"/>
 	 </xsl:if>
	</xsl:template>



	<xsl:template name="dlnum_TO_DLNUM"> 
	  <xsl:if test="dlnum != ''">
		<DLNUM value="{format-number(dlnum,'0000')}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="lact_TO_LACT">
	  <xsl:if test="lact != ''">
		<LACT value="{lact}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="ali_TO_ALI">
	  <xsl:if test="ali != ''">
		<ALI value="{ali}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="rty_TO_RTY">
	  <xsl:if test="rty != ''">
		<RTY value="{rty}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="lty_TO_LTY">
	  <xsl:if test="lty != ''">
		<LTY value="{lty}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="styc_TO_STYC">
	  <xsl:if test="styc != ''">
		<STYC value="{styc}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="toa_TO_TOA">
	  <xsl:if test="toa != ''">
		<TOA value="{toa}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="doi_TO_DOI">
	  <xsl:if test="doi != ''">
		<DOI value="{doi}"/>
 	  </xsl:if>
	</xsl:template>


 
	<xsl:template name="ltn_TO_LTN">
	   <xsl:if test="ltn != ''">
 		<xsl:for-each select="ltn">
		<LTN>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </LTN>
	      </xsl:for-each>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="lnln_TO_LNLN">
	  <xsl:if test="lnln != ''">
		<LNLN value="{lnln}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="lnfn_TO_LNFN">
	  <xsl:if test="lnfn != ''">
		<LNFN value="{lnfn}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="pla_TO_PLA">
	  <xsl:if test="pla != ''">
		<PLA value="{pla}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="des_TO_DES">
	  <xsl:if test="des != ''">
		<DES value="{des}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="tl_TO_TL">
	  <xsl:if test="tl != ''">
		<TL value="{tl}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="tit1e1_TO_TITLE1">
	
	  <xsl:if test="title1 != ''">
		<TITLE1 value="{title1}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="tit1e2_TO_TITLE2">
	
	  <xsl:if test="title2 != ''">
		<TITLE2 value="{title2}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adrNo_TO_LANO">
	  <xsl:if test="adrNo != ''">
		<LANO value="{adrNo}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adrSf_TO_LASF">
	  <xsl:if test="adrSf != ''">
		<LASF value="{adrSf}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adrSdp_TO_LASD">
	  <xsl:if test="adrSdp != ''">
		<LASD value="{adrSdp}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adrSn_TO_LASN">
	  <xsl:if test="adrSn != ''">
		<LASN value="{adrSn}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adrTh_TO_LATH">
	  <xsl:if test="adrTh != ''">
		<LATH value="{adrTh}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adrSds_TO_LASS">
	  <xsl:if test="adrSds != ''">
		<LASS value="{adrSds}"/>
 	  </xsl:if>
	</xsl:template>

		
	<xsl:template name="city_TO_LALOC">
	  <xsl:if test="city != ''">
		<LALOC value="{city}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="state_TO_LAST">
	  <xsl:if test="state != ''">
		<LAST value="{state}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="zipcode_TO_LAZC">
	  <xsl:if test="zipcode != ''">
		<LAZC value="{zipcode}"/>
 	  </xsl:if>
	</xsl:template>




	<xsl:template name="ltext_TO_LTEXT">
	  <xsl:if test="ltext != ''">
		<LTEXT value="{ltext}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="adi_TO_ADI">
	  <xsl:if test="adi != ''">
		<ADI value="{adi}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="ltxnum_TO_LTXNUM">
	  <xsl:if test="ltxnum != ''">
		<LTXNUM value="{ltxnum}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="ltxty_TO_LTXTY">
	  <xsl:if test="ltxty != ''">
		<LTXTY value="{ltxty}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="dlnm_TO_DLNM">
	  <xsl:if test="dlnm != ''">
		<DLNM value="{dlnm}"/>
 	  </xsl:if>
	</xsl:template>

	

	<xsl:template name="dirtyp_TO_DIRTYP">
	  <xsl:if test="dirtyp != ''">
		<DIRTYP value="{dirtyp}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="dirqtya_TO_DIRQTYA">
	  <xsl:if test="dirqtya != ''">
		<DIRQTYA value="{dirqtya}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="dirqtync_TO_DIRQTYNC">
	  <xsl:if test="dirqtync != ''">
		<DIRQTYNC value="{dirqtync}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="yph_TO_YPH">
	  <xsl:if test="yph != ''">
		<YPH value="{yph}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="yphv_TO_YPHV">
	  <xsl:if test="yphv != ''">
		<YPHV value="{yphv}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="lvl_TO_LVL">
	  <xsl:if test="lvl != ''">
		<LVL value="{lvl}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="pls_TO_PLS">
	  <xsl:if test="pls != ''">
		<PLS value="{pls}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="plinfo_TO_PLINFO">
	  <xsl:if test="plinfo != ''">
		<PLINFO value="{plinfo}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="pltn_TO_PLTN">
	  <xsl:if test="pltn != ''">
  	     <xsl:for-each select="pltn">
		<PLTN>
		  <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		   </xsl:attribute>
	        </PLTN>
	     </xsl:for-each>
	   </xsl:if>
	</xsl:template>

	<xsl:template name="so_TO_SO">
	  <xsl:if test="so != ''">
		<SO value="{so}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="fainfo_TO_FAINFO">
	  <xsl:if test="fainfo != ''">
		<FAINFO value="{fainfo}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="fatn_TO_FATN">
	  <xsl:if test="fatn != ''">
	     <xsl:for-each select="fatn">
		<FATN>
		    <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		    </xsl:attribute>
	        </FATN>
	     </xsl:for-each>
	  </xsl:if>
	</xsl:template>




<!-- ............Mapping for LSR form fields for BellSouth............. --> 

	<xsl:template name="lsrNo_TO_LSRNO">
	  <xsl:if test="lsrNo != ''">
		<LSRNO value="{lsrNo}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="sc_TO_SC">
	  <xsl:if test="sc != ''">
		<SC value="{sc}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="pbt_TO_PBT">
	 <xsl:if test="pbt != ''">
		<PBT value="{pbt}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="cic_TO_CIC">
	 <xsl:if test="cic != ''">
		<CIC value="{cic}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="lscp_TO_LSCP">
	 <xsl:if test="lscp != ''">
		<LSCP value="{lscp}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="initfaxno_TO_INITFAXNO">
	 <xsl:if test="faxno != ''">
	     <xsl:for-each select="faxno">
	      <FAXNO>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	      </FAXNO>
	      </xsl:for-each>
         </xsl:if>
	</xsl:template>

	<xsl:template name="apptime_TO_APPTIMEDDD">
	 <xsl:if test="apptime != ''">
	      <APPTIMEDDD value="{apptime}"/>
	</xsl:if>
	</xsl:template>


	<!-- ............Mapping for DL form fields for BellSouth............. --> 

	<xsl:template name="adrPr_TO_LAPR">
	  <xsl:if test="adrPr != ''">
		<LAPR value="{adrPr}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="sic_TO_SIC">
	  <xsl:if test="sic != ''">
		<SIC value="{sic}"/>
 	 </xsl:if>
	</xsl:template>

	<!-- ............Mapping for EU form fields for BellSouth............. --> 

	<xsl:template name="eumi_TO_EUMI">
	 <xsl:if test="eumi != ''">
		<EUMI value="{eumi}"/>
	 </xsl:if>
	</xsl:template>

	<xsl:template name="ncon_TO_NCON">
	 <xsl:if test="ncon != ''">
		<NCON value="{ncon}"/>
	 </xsl:if>
	</xsl:template>

	<!-- ............Mapping for PS form fields for BellSouth............. --> 

	
	<xsl:template name="pulse_TO_PULSE">
	 <xsl:if test="pulse != ''">
		<PULSE value="{pulse}"/>
	 </xsl:if>
	</xsl:template>


	<!-- ............Mapping for LSR form fields for SBC............. --> 

	<xsl:template name="dfdto_TO_DFDTO">
	  <xsl:if test="dfdto != ''">
		<DFDTO value="{dfdto}"/>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="rtr_TO_RTR">
	  <xsl:if test="rtr != ''">
		<RTR value="{rtr}"/>
 	 </xsl:if>
	</xsl:template>

<!-- ............Mapping for EU form fields for SBC............. --> 

	<xsl:template name="adrPr_TO_SAPR">
	  <xsl:if test="adrPr != ''">
		<SAPR value="{adrPr}"/>
 	 </xsl:if>
	</xsl:template>

<!--.............Mapping for DL form fields for SBC............. --> 

	<xsl:template name="prof_TO_PROF">
	  <xsl:if test="prof != ''">
		<PROF value="{prof}"/>
 	  </xsl:if>
	</xsl:template>

	<xsl:template name="lex_TO_LEX">
	 <xsl:if test="lex != ''">
		<LEX value="{lex}"/>
 	  </xsl:if>
	</xsl:template>

<!-- ............Mapping for LSR form fields for VZW............. --> 

	<xsl:template name="dated_TO_DATED">
	  <xsl:if test="dated != ''">		
              <xsl:for-each select="dated">
	        <DATED>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="FormatUtil:formatCYMD(string(.))"/>
		 </xsl:attribute>
	       </DATED>
	      </xsl:for-each>
 	 </xsl:if>
	</xsl:template>

	<xsl:template name="authnm_TO_AUTHNM">
	  <xsl:if test="authnm != ''">
		<AUTHNM value="{authnm}"/>
 	 </xsl:if>
	</xsl:template>

<!--.............Mapping for DL form fields for VZW............. --> 

	<xsl:template name="mtn_TO_MTN">
	  <xsl:if test="mtn != ''">
	      <xsl:for-each select="mtn">
	        <MTN>
		 <xsl:attribute name="value">
		 	<xsl:value-of select="(string(.))"/>
		 </xsl:attribute>
	        </MTN>
	      </xsl:for-each>
 	  </xsl:if>
	</xsl:template>       

<!--.............Mapping for EU form fields for VZW............. --> 

   <xsl:template name="erl_TO_ELT">
	 <xsl:if test="erl != ''">
		<ELT value="{erl}"/>
	 </xsl:if>
   </xsl:template>

  



</xsl:stylesheet>