###########################################################
# VeriTrans Air
# サンプルアプリケーション AirWeb - Java version
# Version 1.1
# Copyright(c) 2013-2014 VeriTrans Inc.
# README.txt
###########################################################

===========================================================
 事前準備
===========================================================
1. Java 1.7以降
2. Apache ant
3. Webアプリケーションサーバ

===========================================================
 インストールガイド
===========================================================
1．アプリケーションとログ設定
　　a) アプリケーション設定
　　　　<AirWebSample>/conf/air-config.properties
　　　　　　MERCHANT_ID
　　　　　　MERCHANT_HASH
　　　　　　※マーチャントIDとマーチャントハッシュはhttps://air.veritrans.co.jp/map/users/editに記載の情報をご使用ください。
　　　　　　
　　　　　　FINISH_PAYMENT_RETURN_URL
　　　　　　UNFINISH_PAYMENT_RETURN_URL
　　　　　　ERROR_PAYMENT_RETURN_URL
　　　　　　FINISH_PAYMENT_ACCESS_URL
　　　　　　※上記のURLの詳細についてはhttps://air.veritrans.co.jp/map/settings/air_web_preferencesからご確認お願いします。

　　b) ログ設定
　　　　<AirWebSample>/conf/log4j.properties
　　　　　　必要に応じてログファイルのの設定を行って下さい。
　　　　　　　　log4j.appender.A2.File=log_dir_change_here/air_web_sample_java.log

2.ビルド用準備
　　サンプルアプリケーションのホームディレクトリを指定してください。　
　　　　<property name="webapp.home" value="C:/Sample/AirWebSample" />

3．ビルド
　　サンプルアプリケーション解凍先にWarファイル（AirWebSample.war）が作成されたことを確認します。
　　　　例）
　　　　　　<AirWebSample>/ant -f build.xml

4.デプロイ
　　作成されたwarファイル（AirWebSample.war）をWebアプリケーションサーバにデプロイします。
　　　　Tomcatの場合：
　　　　　　<TOMCAT_HOME>/webapps/

5.Webアプリケーションサーバの起動
　　Tomcatの場合：
　　　　<TOMCAT_HOME>/bin/startup.sh

6.動作確認
　　Webブラウザで以下URLにアクセスし、稼働することを確認して下さい。
　　　　http://localhost:port/AirWebSample/index.html
　　　　localhost:portのところに導入サーバのIPとポートを指定してください。

===========================================================
ライセンス
===========================================================
・Apache Commons　　この製品／商品には、Apache Software Foundation(http://www.apache.org/)において開発されたソフトウェアが含まれます。

[EOF]