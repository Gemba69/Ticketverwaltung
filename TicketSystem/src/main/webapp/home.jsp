<%-- 
    Document   : home
    Created on : 29-Sep-2015, 11:44:50
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="resources/materialize/css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="resources/css/stylesheet.css"/>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Temporärer Titel</title>
    </head>
    <body>
        <nav>
            <div class="container">
                <ul id="slide-out" class="side-nav fixed">
                    <li><a href="#!">First Sidebar Link</a></li>
                    <li><a href="#!">Second Sidebar Link</a></li>
                </ul>
                <a href="#" data-activates="slide-out" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
            </div>
        </nav>
        <script type="text/javascript" src="resources/materialize/js/jQuery.js"></script>
        <script type="text/javascript" src="resources/materialize/js/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function init() {
                $(".button-collapse").sideNav();
            });
        </script>
    </body>
</html>
