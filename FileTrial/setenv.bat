set INSTALLROOT=D:/installs/demoE
set JAVA_HOME=C:/j2sdk1.4.2_03
set VBROKER_HOME=C:/BDP
set JACORB_HOME=C:/BDP
call %INSTALLROOT%\nfienv.bat
set OAD_PORT=16101
set OSAGENT_ADDR=192.168.97.83
set OSAGENT_PORT=14101
set RMIPort=1099
set DBNAME=jdbc:oracle:thin:@192.168.97.97:1521:nstar
set DBUSER=depdemoE
set JAVA_OPTS=%JAVA_OPTS% -Xmx500m -Xms100m 
set CLASSPATH=%CLASSPATH%;.\lib\classes;.\lib\nls_charset12.zip;.\lib\jmscommon.jar;.\lib\aqapi.jar;.\lib\backport-util-concurrent.jar;.\lib\backport-util-concurrent.jar;.\lib\BCEL.jar;.\lib\JLex.jar;.\lib\Phaos_SSLava.jar;.\lib\activation.jar;.\lib\adapter.jar;.\lib\antlr.jar;.\lib\avalon.jar;.\lib\axis.jar;.\lib\batik.jar;.\lib\bsf.jar;.\lib\commons-discovery.jar;.\lib\commons-logging.jar;.\lib\commons-net-1.4.0.jar;.\lib\comms.jar;.\lib\cryptix-asn1.jar;.\lib\ejb_mgrcore.jar;.\lib\endorsed;.\lib\fop.jar;.\lib\gateway.jar;.\lib\jakarta-oro-2.0.1.jar;.\lib\java_cup.jar;.\lib\jaxen-full.jar;.\lib\jaxrpc.jar;.\lib\jce1_2-do.jar;.\lib\js.jar;.\lib\ldapjdk.jar;.\lib\mail.jar;.\lib\log4j-1.2.6.jar;.\lib\nfcommon.jar;.\lib\nfsecurity.jar;.\lib\ojdbc14.jar;.\lib\regexp.jar;.\lib\runtime.jar;.\lib\saaj.jar;.\lib\saxpath.jar;.\lib\tools.jar;.\lib\wsdl4j.jar;.\lib\xmlParserAPIs.jar;.\lib\xsltc.jar;.\lib\commonmgr.jar;.\lib\lsrmgr.jar;.\lib\soamgr.jar;.\lib\Rules4020.jar;.\lib\spicommon.jar;.\lib\sprint_adapter.jar;.\lib\wireless_nport.jar;.\lib\wireless_nport_stubs.jar;.\lib\wireless_nport_OBF30.jar;.\lib\wireless_nport_stubs_OBF30.jar;.\lib\commons-cli-1.0.jar;.\lib\asr.jar;.\lib\asr_maps.jar;.\lib\custom_rules;.\lib\commons-net-1.0.0.jar;.\lib\pre_port_validation.jar;.\lib\sbcmigrationtool.jar;.\lib\.nfs63F8;.\lib\bti_custom.jar;
set CLASSPATH=%NFICLASSPATH%;%CLASSPATH%;
