<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" /> 
	<xsl:template match="/">
		<html>
			<head>
				<title>Amazon.com Best Selling Books</title>
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
				<h1>Amazon.com Best Selling Books</h1>
				<table class="bookTable" cellspacing="0" cellpadding="0">
					<thead class="tblHeader">
					<tr>
						<td>Rank</td>
						<td>Title</td>
						<td>Author</td>
						<td>Publish Date</td>
						<td>Price (USD)</td>
					</tr>
					</thead>
					<xsl:for-each select="/AmazonBestSelling/Book">
						<tr class="bookCell">
							<td><xsl:value-of select="Rank"/></td>
							<td><a href="http://www.PerfectXML.com/bookredirect.asp?isbn={@ISBN}"><xsl:value-of select="Title"/></a></td>
							<td><xsl:value-of select="Author"/></td>
							<td><xsl:value-of select="PublishDate"/></td>
							<td>$<xsl:value-of select="Price"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
