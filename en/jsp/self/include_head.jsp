<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%
    Calendar objCal1 = Calendar.getInstance();
    Calendar objCal2 = Calendar.getInstance();
    objCal2.set(1970, 0, 1, 0, 0, 0);
    response.setDateHeader("Last-Modified", objCal1.getTime().getTime());
    response.setDateHeader("Expires", objCal2.getTime().getTime());
    response.setHeader("pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_m.css" type="text/css"
    media="only screen and (max-width:480px)" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css"
    media="only screen and (min-width:481px)" />
<!--[if IE]>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="all"/>
<![endif]-->
