<%-- 
    Document   : incluir
    Created on : 03/08/2016, 22:02:19
    Author     : hexp_
--%>

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

                    <div class="panel-heading"><h3 class="panel-title" >Dados da Carga</h3></div>
                   
                    <!-- inicio corpo do painel -->
                    <div class="panel-body">

                        <!-- incio form -->
                        <form action="incluirCarga.htm" method="post">

                            <!-- incio coluna direita-->
                            <div class="col-lg-3"></div>
                            <!-- fim coluna direita-->
                            
                            <!-- incio coluna meio-->
                            <div class="col-lg-6">     
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Conferente</span>
                                    <input type="text" class="form-control" placeholder="Conferente" aria-describedby="basic-addon1" name="conferente">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Cidade/UF</span>
                                    <input type="text" class="form-control" placeholder="Cidade - UF" aria-describedby="basic-addon1" name="cidadeUf">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Cliente</span>
                                    <input type="text" class="form-control" placeholder="Razão Social" aria-describedby="basic-addon1" name="cliente">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Danfe</span>
                                    <input type="number" class="form-control" min="0" step="1" placeholder="Número NFE" aria-describedby="basic-addon1" name="danfe">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Rota</span>
                                    <select class="form-control" title="Selecione uma rota" aria-describedby="basic-addon1" name="idTransportador">
                                        <c:forEach var="t" items="${transportadores}">
                                            <option value="${t.idTransportador}">${t.descricao}</option>
                                        </c:forEach>
                                    </select> 
                                </div>
                                
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Pedido</span>
                                    <input type="number" class="form-control" min="0" step="1" placeholder="Número do pedido" aria-describedby="basic-addon1" name="pedido">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Valor</span>
                                    <input type="number" class="form-control" min="0.00" step="0.01" placeholder="0.00" aria-describedby="basic-addon1" name="valor">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">QTD Volumes</span>
                                    <input type="number" class="form-control" min="0" step="1" placeholder="0" aria-describedby="basic-addon1" name="qtdVol">
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Emissão</span>
                                    <input type="date" class="form-control" aria-describedby="basic-addon1" name="dtEmi">
                                    <div class="input-group-btn">
                                        <input type="submit" class="btn btn-default" value="Incluir">
                                    </div> 
                                </div>



                            </div>
                            <!-- fim coluna meio -->
                            
                            <!-- inicio coluna esquerda -->
                            <div class="col-lg-3"></div>
                            <!-- fim coluna esquerda -->
                    </div>
                    <!-- fim corpo do painel -->


                    </form>
                    <!-- fim form -->    

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
