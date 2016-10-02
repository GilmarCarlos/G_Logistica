<%-- 
    Document   : dados-da-carga.jsp
    Created on : 02/10/2016, 18:54:04
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

                    <div class="panel-heading">
                        
                        <h3 class="panel-title" >Dados da Carga</h3>
                    
                    </div>

                    <!-- inicio corpo painel -->
                    <div class="panel-body">

                        <!--inicio div tabela -->
                        <div class="table-responsive">
                            
                            <!-- inicio da tabela -->
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Cidade</th>
                                        <th>Cliente</th>
                                        <th>Conferente</th>
                                        <th>Pedido</th>
                                        <th>NF-e</th>
                                        <th>Emissão NF-e</th>
                                        <th>Volumes</th>                                        
                                        <th>Valor</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <c:forEach var="rota" items="${rotas}">
                                    <tr>
                                        <td>${rota.cidadeUf}</td>
                                        <td>${rota.cliente}</td>
                                        <td>${rota.conferente}</td>
                                        <td>${rota.pedido}</td>
                                        <td>${rota.danfe}</td>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT -3" value="${rota.dtEmi}" /></td>
                                        <td>${rota.qtdVol}</td>
                                        <td><fmt:formatNumber value="${rota.valor}" type="currency" /></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                                
                            </table>
                            <!-- fim da tabela -->
                        
                        </div>
                        <!-- fim div tabela -->
      
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
        (function (b, o, i, l, e, r) {
            b.GoogleAnalyticsObject = l;
            b[l] || (b[l] =
                    function () {
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