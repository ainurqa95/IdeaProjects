<%--
  Created by IntelliJ IDEA.
  User: ainur
  Date: 16.11.16
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en-US"> <!--<![endif]-->
<head>
    <!-- META TAGS -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />

    <!-- Title -->
    <title> Лес Парк Сад</title>

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,700,600,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700' rel='stylesheet' type='text/css'>

    <!-- Style Sheet-->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/template/css/tooltipster.css">
    <link href="css/ie.css" rel="${pageContext.servletContext.contextPath}/template/stylesheet" media="all">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/template/css/bootstrap.css">

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/template/css/responsive.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/template/css/prettyPhoto.css">
    <%--<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/template/style.css">--%>

    <!-- favicon -->
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/template/images/lopatka.jpg">

    <!-- Include the HTML5 shiv print polyfill for Internet Explorer browsers 8 and below -->
    <!--[if lt IE 10]><script src="${pageContext.servletContext.contextPath}/template/js/html5shiv-printshiv.js" media="all"></script><![endif]-->

    <%--<link type="text/css" rel="stylesheet" href="<c:url value="/template/style.css" />" />--%>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/template/style.css">

</head>
<body>


<!-- HEADER -->
<div class="header-bar">
    <div class="container">
        <div class="row">
            <div class="pric-icon span2">

            </div>

            <div class="span10 right">
                <div class="social-strip">
                    <ul>
                        <li><a href="${pageContext.servletContext.contextPath}/cart" class="wish">Корзина</a></li>


                        <c:choose>
                            <c:when test="${  session.getAttribute('idusers') == null }">
                                <li><a href="${pageContext.servletContext.contextPath}/user/register" class="account">Зарегистрироваться</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/user/login" class="check">Войти </a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${pageContext.servletContext.contextPath}/cabinet" class="check"> Мой профиль </a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/user/logout" class="check">Выйти </a></li>

                            </c:otherwise>
                        </c:choose>


                    </ul>
                </div>

                <div class="languages">
                    <a href="/" class="english active"><img src="${pageContext.servletContext.contextPath}/template/images/russia.png" alt=""></a>
                    <a href="/" class="english active"><img src="${pageContext.servletContext.contextPath}/template/images/tatarstan.jpg" alt=""></a>

                </div>
            </div>
        </div>
    </div>
</div>

<div class="header-top">
    <div class="container">
        <div class="row">

            <div class="span5">
                <div class="logo">
                    <a href="${pageContext.servletContext.contextPath}/main"><img src="${pageContext.servletContext.contextPath}/template/images/logo2.png" alt=""></a>
                    <h1><a href="${pageContext.servletContext.contextPath}/main"> <span>Садовая техника, бензоинструмент,строительное оборудование </span>  </a></h1>
                </div>
            </div>

            <div class="span5">
                <form>
                    <input type="text" placeholder="Type and hit enter">
                    <input type="submit" value="">
                </form>
            </div>

            <div class="span2">
                <div class="cart">
                    <ul>
                        <li class="first"><a href="${pageContext.servletContext.contextPath}/cart"></a><span></span></li>
                        <%--<li id="count_of_items" ><?php echo Cart::CountOfItemsInCart();?> товара(ов) <?php echo Cart::SumOfPricesInCart(); ?> руб</li>--%>
                        <li id="count_of_items" >${countOfCartProducts} товара(ов)  руб</li>

                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>

<header>
    <div class="container">
        <div class="row">
            <div class="span12">
                <nav class="desktop-nav">
                    <ul class="clearfix">
                        <li>
                            <a href="">О компании</a>
                            <ul class="clearfix sub-menu">
                                <li class="clearfix">
                                    <div class="links">

                                        <p>
                                            <a href="#">Контакты </a>
                                            <a href="#">Вакансии</a>
                                        </p>



                                    </div>

                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="${pageContext.servletContext.contextPath}/views/category/"> Категории </a>
                            <ul class="clearfix sub-menu menu-three">
                                <li class="clearfix">
                                    <!--
                                        <figure>
                                            <a href="#"><img src="/template/images/menu-img.png" alt=""/></a>
                                        </figure>
                                        -->
                                    <div class="links">
                                        <h3>Категории</h3>
                                        <p>
                                          
                                            <c:forEach items="${mainCategories}" var="category" varStatus="status">

                                                <a href="${pageContext.servletContext.contextPath}/category?mainid=${category.idmain_cat}"> ${category.name} </a>

                                            </c:forEach>

                                               <%--<a href="#">Работа с землей</a>--%>
                                                <%--<a href="#">Стрижка травы</a>--%>
                                                <%--<a href="#">Уход за газоном</a>--%>
                                                <%--<a href="#">Многофункциональные мини-тракторы</a>--%>
                                                <%--<a href="#">Работа с деревьями и кустарниками</a>--%>
                                                <%--<a href="#">Техника для резервного энергоснабжения</a> -->--%>
                                        </p>




                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li>


                            <a href="#">Каталог садовой техники</a>
                            <ul class="clearfix sub-menu menu-four">
                                <li class="clearfix">
                                    <c:forEach items="${mainCategories}" var="mainCategory" varStatus="status">
                                        <div class="our-product">
                                            <h3>${mainCategory.name}</h3>
                                            <c:forEach   items="${secondCategories}" var="secondCategory" varStatus="status"
                                                >
                                                <c:if test="${secondCategory.id_main_cat== mainCategory.idmain_cat}" >
                                                    <div class="clearfix">
                                                    <%--<a href="/category?mainid=${mainCategory.idmain_cat}&secondid=${secondCategory.id_second_cat}"/><img src="${pageContext.servletContext.contextPath}/template/images/shopping-img.png" alt=""/></a>--%>
                                                    <h4> <a href="/category/?mainid=${mainCategory.idmain_cat}&secondid=${secondCategory.id_second_cat}"> <h4> ${secondCategory.name} </h4></a></h4>

                                                    </div>

                                            </c:if>



                                            </c:forEach>
                                        </div>
                                    </c:forEach>



                                </li>
                            </ul>
                        </li>
                        <li><a href="#">Отзывы</a></li>
                        <li><a href="#">Новости </a></li>
                        <li><a href="#">Блог</a></li>
                        <li><a href="#">Наши акции</a></li>
                        <li><a href="#">Прайс Листы</a></li>
                        <li>
                            <a href="#">Страницы</a>
                            <ul class="clearfix">
                                <li><a href="index.html">Home</a></li>
                                <li><a href="product-grid.html">Product Grid</a></li>
                                <li><a href="product-list.html">Product List</a></li>
                                <li><a href="shopping-cart.html">Shopping cart</a></li>
                                <li><a href="checkout.html">Checkout</a></li>
                                <li><a href="single-product.html">Single Product</a></li>
                                <li><a href="blog.html">Blog</a></li>
                                <li><a href="single.html">Single</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>


            </div>
        </div>
    </div>
</header>

<!-- HEADER -->
