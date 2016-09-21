<%-- 
    Document   : info
    Created on : 04/09/2016, 21:39:16
    Author     : hexp_
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>

        <!--Nav import /layout/topo.jsp -->
        <jsp:include page="../layout/topo.jsp"/>

        <!-- inicio container -->
        <div class="container">
            <!-- inicio row -->
            <div class="row">

                <div class="text-center">
                    <h2></h2>
                </div>

                <!-- inicio painel -->
                <div class="panel panel-default">

                    <div class="panel-heading"><h3 class="panel-title" >Dados da Rota</h3></div>

                    <!-- inicio corpo painel -->
                    <div class="panel-body">

                        <!-- inicio coluna esquerda -->
                        <div class="col-lg-3"></div>
                        <!-- fim coluna esquerda -->
                        
                        <!-- inicio coluna meio -->
                        <div class="col-lg-6">
                        
                            <!-- inicio lista -->
                            <div class="list-group">
                            
                            <ul>
                                <li class="list-group-item">
                                    <span class="label label-default">Descrição</span>
                                    <c:out value="${rota.descricao}"/>
                                </li>
                                
                                <li class="list-group-item">
                                    <span class="label label-default">Motorista</span>
                                    <c:out value="${rota.motorista}"/>
                                </li>
                                
                                <li class="list-group-item">
                                    <span class="label label-default">Ajudante</span>
                                    <c:out value="${rota.ajudante}"/>
                                </li>
                                
                                <li class="list-group-item">
                                    <span class="label label-default">Data Saída</span>
                                    <fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT -3" value="${rota.dtSaida}" />
                                </li>
                                
                                <li class="list-group-item">
                                    <span class="label label-default">Veículo</span>
                                    <c:out value="${rota.veiculo}"/>
                                </li>
                                
                                <li class="list-group-item">
                                    <span class="label label-default">Transportador</span>
                                    <c:out value="${rota.nomeTransp}"/>
                                </li>
                                
                            </ul>
                           
                        
                        </div>
                        <!-- fim lista -->
                                
                        </div>
                        <!-- fim coluna meio -->
                                
                        <!-- inicio coluna direita -->        
                        <div class="col-lg-3"></div>        
                        <!-- fim coluna direita -->

                    </div>
                    <!-- fim corpo painel -->

                </div>
                <!-- fim painel -->

            </div>   
            <!-- fim row -->

        </div>
        <!-- fim container -->

        <hr>

        <footer>
            <p>&copy; Company 2015</p>
        </footer>
    </div> <!-- /container -->        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.js"><\/script>')</script>

    <script src="js/vendor/bootstrap.min.js"></script>

    <script src="js/main.js"></script>

    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
    <script>
        (function(b, o, i, l, e, r) {
            b.GoogleAnalyticsObject = l;
            b[l] || (b[l] =
                    function() {
                        (b[l].q = b[l].q || []).push(arguments)
                    });
            b[l].l = +new Date;
            e = o.createElement(i);
            r = o.getElementsByTagName(i)[0];
            e.src = '//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e, r)
        }(window, document, 'script', 'ga'));
        ga('create', 'UA-XXXXX-X', 'auto');
        ga('send', 'pageview');
    </script>
</body>
</html>


