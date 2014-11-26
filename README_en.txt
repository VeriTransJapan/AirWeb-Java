###########################################################
# VeriTrans Air
# Sample Application AirWeb - Java version
# Version 1.1
# Copyright(c) 2013-2014 VeriTrans Inc.
# README_en.txt
###########################################################

===========================================================
Prerequisite
===========================================================
1. Java 1.7 and later
2. Apache ant
3. Web Server

===========================================================
 Installation Guide
===========================================================
1．Update config files to match your environment.
　　a) Application setting
　　　　<AirWebSample>/conf/air-config.properties
　　　　Set following values which are specific to you or your environment
　　　　　　MERCHANT_ID
　　　　　　MERCHANT_HASH
　　　　　　Note:Merchant ID and Merchant Hash Key at location https://air.veritrans.co.jp/map/users/edit
　　　　　　
　　　　　　FINISH_PAYMENT_RETURN_URL
　　　　　　UNFINISH_PAYMENT_RETURN_URL
　　　　　　ERROR_PAYMENT_RETURN_URL
　　　　　　FINISH_PAYMENT_ACCESS_URL
　　　　　　Note:More details about these values can be found at https://air.veritrans.co.jp/map/settings/air_web_preferences

　　b) Log setting
　　　　<AirWebSample>/conf/log4j.properties
　　　　Specify the location where you want to output the log file
　　　　　　log4j.appender.A2.File=log_dir_change_here/air_web_sample_java.log

2.Set value of webapp.home in build.xml file to the location of the AirWeb Sample Programm.
　　For example:
　　　　<property name="webapp.home" value="C:/Sample/AirWebSample" />

3．Build the AirWeb Sample application to create the war file.
　　For example:
　　　　<AirWebSample>/ant

4.Deploy the AirWeb Sample application.
　　Copy AirWebSample.war file created under <AirWebSample> folder to any Java Web Server.
　　　　In case of Tomcat:
　　　　　　<TOMCAT_HOME>/webapps/

5.Start the Web Server.
　　In case of Tomcat:
　　　　<TOMCAT_HOME>/bin/startup.sh

6.Access Sample Program using Web Browser.
　　　　http://localhost:port/AirWebSample/index.html
　　　　Specify the IP address and port on which Web server is running

===========================================================
LICENSE
===========================================================
・This product includes software developed by The Apache Software Foundation (http://www.apache.org/).

[EOF]