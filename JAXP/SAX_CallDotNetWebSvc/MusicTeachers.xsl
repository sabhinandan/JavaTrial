<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" /> 
	<xsl:template match="/">
		<html>
			<head>
				<title>Music Teachers</title>
			<style>
				BODY, A, TD {
					font-family: "Tahoma", Sans-Serif;
					font-size: 9pt;
					color: #333333;
				}

				BODY {
					background-color: White;
					margin: 1em;
				}

				A:hover {
					color: #0099CC;
				}

				.bookTable {
					padding: 2pt;
					width: 100%;
					border: solid 1px #999999;
				}

				.bookCell{
					padding: 2pt;
					text-align: left;
					border: none;
				}

				H1 {
					color: White;
					background-color: #0F3063;
					font-family: "Arial", Sans-Serif;
					font-size: 16pt;
					font-weight: bold;
					height: 22px;
					padding-left: 1pt;
				}

				H2 {
					color: gray;
					background-color: #FFFFFF;
					font-family: "Arial", Sans-Serif;
					font-size: 14pt;
					font-weight: bold;
					height: 18px;
					padding-left: 1pt;
				}

				.tblHeader {
					background-color: #DADADA;
					font-weight: bold;
				}

				.tblFooter {
					background-color: #CACACA;
					font-weight: bold;
					color:Teal;
				}
			</style>
			</head>
			<body>
				<h1>Music Teachers</h1>
				<table class="bookTable" cellspacing="0" cellpadding="0">
					<thead class="tblHeader">
					<tr>
						<td>Name</td>
						<td>Address</td>
						<td>Phone</td>
						<td>Email</td>
						<td>Type</td>
						<td>Instrument(s)</td>
						<td>Style</td>
						<td>Rate</td>
					</tr>
					</thead>
					<xsl:for-each select="//Details">
						<tr class="bookCell">
							<td valign="top"><b><xsl:value-of select="Name"/></b></td>
							<td valign="top"><xsl:value-of select="Address"/></td>
							<td nowrap="true" valign="top"><xsl:value-of select="Phone"/></td>
							<td valign="top">
								<xsl:if test="string(Email)">
									<a href="mailto:{Email}"><xsl:value-of select="Email"/></a>
								</xsl:if>
							</td>
							<td valign="top"><xsl:value-of select="Type"/></td>
							<td valign="top"><xsl:value-of select="Teaches"/></td>
							<td valign="top"><xsl:value-of select="Style"/></td>
							<td valign="top"><xsl:value-of select="Rates"/></td>
						</tr>
						<tr >
							<td colspan="8"><hr size="1" color="gray" /></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
