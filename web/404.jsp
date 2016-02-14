<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechRepair</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css">        
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-modal.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.min.js"></script>   
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="navbar">
                        <div class="navbar-inner">
                            <a class="brand" href="index.jsp">TechRepair</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="span2">
                    <img src="img/logo.png"/><br/>
                    <b>Наш адрес:</b> г. Минск,<br/> ул. Карла Маркса, д. 16<br/>
                        <b>Индекс:</b> 220030<br/><br/>
                        <b>Телефоны:</b><br/>
                        <img src="img/life.png"/>&nbsp;7558872<br/>
                        <img src="img/velcom.png"/>7558872<br/>
                        <img src="img/mts.png"/>&nbsp;&nbsp;7558872<br/>
                        <br/><a href="http://clck.yandex.ru/redir/dtype=stred/pid=7/cid=1228/*http://pogoda.yandex.ru/minsk"><img src="http://info.weather.yandex.net/minsk/2_white.ru.png" border="0" alt=""/>
                        <img width="1" height="1" src="http://clck.yandex.ru/click/dtype=stred/pid=7/cid=1227/*http://img.yandex.ru/i/pix.gif" alt="" border="0"/></a>                </div>
                <div class="span7">
                    <div align="center">
                        <font style="color: red;"><h2>Извините, такая страница не найдена!</h2></font><br/>
                        <img src="img/404.jpg" width="620">
                    </div>
                </div>
                <div class="span3">
                    <div class="row">
                        <iframe frameborder="no" scrolling="no" style="border:0; width:307px;height:130px;" src="http://time.yandex.ru/pages/widget/informer/index.html?geoid=157&theme=analog&lang=ru&layout=horiz"></iframe>
                    </div>
                </div>
                <jsp:include page="jspf/footer.jsp" />
            </div>
        </div>
    </body>
</html>
