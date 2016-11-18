<%--
  Created by IntelliJ IDEA.
  User: ainur
  Date: 16.11.16
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!-- FOOTER -->
<div class="shipping-wrap">
    <div class="container">
        <div class="row">
            <div class="span12">
                <div class="shipping">
                    <p><span>Бесплатная доставка </span> Выезд механиков БЕСПЛАТНЫЙ! </p>
                    <a href="#" class="button">Читать больше</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer-wrap">
    <div class="container">
        <div class="row">

            <div class="footer clearfix">

                <div class="span3">
                    <div class="widget">
                        <h3>Сервис покупателя</h3>
                        <ul>
                            <li><a href="#"> О нас </a></li>
                            <li><a href="#">Информация о доставке</a></li>
                            <li><a href="#"> Политика конфеденциальности</a></li>
                            <li><a href="#"> Условия покупки </a></li>
                        </ul>
                    </div>
                </div>

                <div class="span3">
                    <div class="widget">
                        <h3>Информация</h3>
                        <ul>
                            <li><a href="#">Вакансии </a></li>
                            <li><a href="#">Акции </a></li>
                            <li><a href="#">Прайс листы</a></li>
                            <li><a href="#">Карт сайта</a></li>
                        </ul>
                    </div>
                </div>

                <div class="span3">
                    <div class="widget">
                        <h3>Мой профиль</h3>
                        <ul>
                            <li><a href="#">Профиль</a></li>
                            <li><a href="#">История покупок</a></li>
                            <li><a href="#">Корзина</a></li>
                            <li><a href="#">Новости</a></li>
                        </ul>
                    </div>
                </div>

                <div class="span3">
                    <div class="widget">
                        <h3>Контакты</h3>
                        <ul>
                            <li>support@maxshop.com</li>
                            <li>+38649 123 456 789 00</li>
                            <li>Lorem ipsum address street no 24 b41</li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>

        <div class="row">
            <footer class="clearfix">
                <div class="span5">
                    <p>©ЛесПаркСад</p>
                </div>
                <div class="span2 back-top">
                    <a href="#"> <img src="images/back.png" alt=""></a>
                </div>
                <div class="span5">
                    <div class="social-icon">
                        <a class="rss" href=""></a>
                        <a class="twet" href=""></a>
                        <a class="fb" href=""></a>
                        <a class="google" href=""></a>
                        <a class="pin" href=""> </a>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>
<!-- FOOTER -->


<!-- Include the HTML5 shiv print polyfill for Internet Explorer browsers 8 and below -->
<!--[if lt IE 10]><script src="${pageContext.servletContext.contextPath}/js/html5shiv-printshiv.js" media="all"></script><![endif]-->

<script src="${pageContext.servletContext.contextPath}/template/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery-ui.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery.cycle.all.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/modernizr.custom.17475.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery.elastislide.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery.carouFredSel-6.0.4-packed.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery.selectBox.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery.tooltipster.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/jquery.prettyPhoto.js"></script>
<script src="${pageContext.servletContext.contextPath}/template/js/custom.js"></script>
<!--    <script src="/template/js/js_forajax.js"></script>      -->

<script >
    $(document).ready(function(){ // код ниже срабатывает при загрузки документа

        $(".one_tooltip").click(function () { // при нажатии на корзинку на нкопку

            var id = $(this).attr("data-id"); // находим id кнопки
            $.post("/cart/addAjax/"+id, {}, function (data) { // певрый параметр это где искать запрос ты срабатывает метож  actionAddAjax и эхом выводит количестов товара
                $("#count_of_items").html(data); //
            });
            return false;
        });
    });

</script>

