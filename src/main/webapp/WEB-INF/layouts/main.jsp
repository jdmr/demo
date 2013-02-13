<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s"   uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>DEMO - <sitemesh:write property='title'/></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="shortcut icon" href="<s:url value='/favicon.ico' />" type="image/x-icon" />
        <!-- For third-generation iPad with high-resolution Retina display: -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<s:url value='/apple-touch-icon-144x144-precomposed.png'/>">
        <!-- For iPhone with high-resolution Retina display: -->
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<s:url value='/apple-touch-icon-114x114-precomposed.png'/>">
        <!-- For first- and second-generation iPad: -->
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<s:url value='/apple-touch-icon-72x72-precomposed.png'/>">
        <!-- For non-Retina iPhone, iPod Touch, and Android 2.1+ devices: -->
        <link rel="apple-touch-icon-precomposed" href="<s:url value='/apple-touch-icon-precomposed.png'/>">
        
        <link rel="stylesheet" href="<s:url value='/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<s:url value='/css/bootstrap-responsive.min.css' />">
        <link rel="stylesheet" href="<s:url value='/css/smoothness/jquery-ui-1.9.1.custom.min.css' />" type="text/css">
        <link rel="stylesheet" href="<s:url value='/css/main.css' />">

        <script src="<s:url value='/js/vendor/modernizr-2.6.2.min.js' />"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->
        
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href="<s:url value='/' />" >DEMO</a>
                </div>
            </div>
        </div>

        <div class="container">
                    
            <sitemesh:write property='body'/>

        </div> <!-- /container -->
        
        <div class="footer" role="contentinfo">
            <div class="container">
                <div class="row">
                    <div class="span12">
                        <p>&copy; David Mendoza 2013</p>
                    </div>
                </div>
            </div>
        </div>

        <script src="<c:url value='/js/vendor/jquery-1.9.1.min.js' />"></script>
        <script src="<c:url value='/js/vendor/jquery-migrate-1.1.0.min.js' />"></script>
        <script src="<s:url value='/js/vendor/jquery-ui-1.9.1.custom.min.js' />"></script>
        <script src="<s:url value='/js/vendor/bootstrap.min.js' />"></script>

        <script src="<s:url value='/js/plugins.js' />"></script>
        <script src="<s:url value='/js/main.js' />"></script>
            
        <sitemesh:write property="content"/>
    </body>
</html>
