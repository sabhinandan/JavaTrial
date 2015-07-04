#!/bin/sh
INSTALLROOT=D:/installs/demoE
export INSTALLROOT
JAVA_HOME=C:/j2sdk1.4.2_03
export JAVA_HOME
JAVAVM=java
export JAVAVM
VBROKER_HOME=C:/BDP
export VBROKER_HOME
JACORB_HOME=<JACORB_HOME>
export JACORB_HOME
if [ -f $INSTALLROOT/nfienv.sh ] ; then
  . $INSTALLROOT/nfienv.sh
fi
OAD_PORT=16101
export OAD_PORT
OSAGENT_ADDR=192.168.97.83
export OSAGENT_ADDR
OSAGENT_PORT=14101
export OSAGENT_PORT
RMIPort=1099
export RMIPort
DBNAME=jdbc:oracle:thin:@192.168.97.97:1521:nstar
export DBNAME
DBUSER=depdemoE
export DBUSER
JAVA_OPTS="$JAVA_OPTS -Xmx500m -Xms100m "
export JAVA_OPTS                
CLASSPATH=\.\lib\activation.jar;.\lib\adapter.jar;.\lib\antlr.jar;.\lib\aqapi.jar;.\lib\avalon.jar;.\lib\axis.jar;.\lib\backport-util-concurrent.jar;.\lib\batik.jar;.\lib\BCEL.jar;.\lib\bsf.jar;.\lib\commonmgr.jar;.\lib\commons-cli-1.0.jar;.\lib\commons-discovery.jar;.\lib\commons-logging.jar;.\lib\commons-net-1.4.0.jar;.\lib\comms.jar;.\lib\cryptix-asn1.jar;.\lib\ejb_mgrcore.jar;.\lib\endorsed;.\lib\endorsed_JacORB;.\lib\esr_adapter.jar;.\lib\esr_xo_adapter.jar;.\lib\fop.jar;.\lib\gateway.jar;.\lib\j2ee.jar;.\lib\jakarta-oro-2.0.1.jar;.\lib\java_cup.jar;.\lib\jaxen-full.jar;.\lib\jaxrpc.jar;.\lib\jce1_2-do.jar;.\lib\JLex.jar;.\lib\jmscommon.jar;.\lib\js.jar;.\lib\ldapjdk.jar;.\lib\log4j-1.2.6.jar;.\lib\lsrmgr.jar;.\lib\mail.jar;.\lib\nfcommon.jar;.\lib\nfjacidl.jar;.\lib\nfsecurity.jar;.\lib\nls_charset12.zip;.\lib\ojdbc14.jar;.\lib\Phaos_SSLava.jar;.\lib\regexp.jar;.\lib\Rules4020.jar;.\lib\runtime.jar;.\lib\saaj.jar;.\lib\saxpath.jar;.\lib\soamgr.jar;.\lib\spicommon.jar;.\lib\tools.jar;.\lib\wsdl4j.jar;.\lib\xmlParserAPIs.jar;.\lib\xsltc.jar:.\lib\activation.jar;.\lib\adapter.jar;.\lib\antlr.jar;.\lib\aqapi.jar;.\lib\avalon.jar;.\lib\axis.jar;.\lib\backport-util-concurrent.jar;.\lib\batik.jar;.\lib\BCEL.jar;.\lib\bsf.jar;.\lib\commonmgr.jar;.\lib\commons-cli-1.0.jar;.\lib\commons-discovery.jar;.\lib\commons-logging.jar;.\lib\commons-net-1.4.0.jar;.\lib\comms.jar;.\lib\cryptix-asn1.jar;.\lib\ejb_mgrcore.jar;.\lib\endorsed;.\lib\endorsed_JacORB;.\lib\fop.jar;.\lib\gateway.jar;.\lib\j2ee.jar;.\lib\jakarta-oro-2.0.1.jar;.\lib\java_cup.jar;.\lib\jaxen-full.jar;.\lib\jaxrpc.jar;.\lib\jce1_2-do.jar;.\lib\JLex.jar;.\lib\jmscommon.jar;.\lib\js.jar;.\lib\ldapjdk.jar;.\lib\log4j-1.2.6.jar;.\lib\lsrmgr.jar;.\lib\mail.jar;.\lib\nfcommon.jar;.\lib\nfsecurity.jar;.\lib\nls_charset12.zip;.\lib\ojdbc14.jar;.\lib\Phaos_SSLava.jar;.\lib\regexp.jar;.\lib\Rules4020.jar;.\lib\runtime.jar;.\lib\saaj.jar;.\lib\saxpath.jar;.\lib\soamgr.jar;.\lib\spicommon.jar;.\lib\tools.jar;.\lib\wsdl4j.jar;.\lib\xmlParserAPIs.jar;.\lib\xsltc.jar:$CLASSPATH
CLASSPATH=\.\lib\activation.jar;.\lib\adapter.jar;.\lib\antlr.jar;.\lib\aqapi.jar;.\lib\avalon.jar;.\lib\axis.jar;.\lib\backport-util-concurrent.jar;.\lib\batik.jar;.\lib\BCEL.jar;.\lib\bsf.jar;.\lib\commonmgr.jar;.\lib\commons-cli-1.0.jar;.\lib\commons-discovery.jar;.\lib\commons-logging.jar;.\lib\commons-net-1.4.0.jar;.\lib\comms.jar;.\lib\cryptix-asn1.jar;.\lib\ejb_mgrcore.jar;.\lib\endorsed;.\lib\endorsed_JacORB;.\lib\esr_adapter.jar;.\lib\esr_xo_adapter.jar;.\lib\fop.jar;.\lib\gateway.jar;.\lib\j2ee.jar;.\lib\jakarta-oro-2.0.1.jar;.\lib\java_cup.jar;.\lib\jaxen-full.jar;.\lib\jaxrpc.jar;.\lib\jce1_2-do.jar;.\lib\JLex.jar;.\lib\jmscommon.jar;.\lib\js.jar;.\lib\ldapjdk.jar;.\lib\log4j-1.2.6.jar;.\lib\lsrmgr.jar;.\lib\mail.jar;.\lib\nfcommon.jar;.\lib\nfjacidl.jar;.\lib\nfsecurity.jar;.\lib\nls_charset12.zip;.\lib\ojdbc14.jar;.\lib\Phaos_SSLava.jar;.\lib\regexp.jar;.\lib\Rules4020.jar;.\lib\runtime.jar;.\lib\saaj.jar;.\lib\saxpath.jar;.\lib\soamgr.jar;.\lib\spicommon.jar;.\lib\tools.jar;.\lib\wsdl4j.jar;.\lib\xmlParserAPIs.jar;.\lib\xsltc.jar:$NFICLASSPATH:$CLASSPATH:$NMICLASSPATH
export CLASSPATH

