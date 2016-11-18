<%--
  Created by IntelliJ IDEA.
  User: ainur
  Date: 16.11.16
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../layout/header.jsp"/>



<div class="wrapper">
    <div class="container">
        <div class="row ">



            <!-- SLIDER -->
            <div class="span9 slider">
                <div class="slider-slides">
                    <c:forEach   items="${sliderProducts}" var="item" >
                        <%--<div class="slides">--%>
                                <%--&lt;%&ndash;<a href="${pageContext.servletContext.contextPath}/products?idproducts=${item.idproducts}"><img src="${pageContext.servletContext.contextPath}${item.imagePathes}" alt="${item.name}"></a><!-- 870x373 -->&ndash;%&gt;--%>
                                <%--<div class="overlay">--%>
                                <%--<h1> ${item.name}</h1>--%>
                                <%--<p><span><${item.price}>%</span> Цена <br/> Brand: <span> ${item.brand}  </span> </p>--%>

                                     <%--</div>--%>
                                <%--</div>--%>
                        <div class="slides">
                            <a href="${pageContext.servletContext.contextPath}/products?idproducts=${item.idproducts}"><img src="${pageContext.servletContext.contextPath}${item.imagePathes}" alt="${item.name}"></a>
                            <div class="overlay">
                            <h1> ${item.name}</h1>
                            <p><span> Цена ${item.price} </span> скидка ${item.skidka}%<br/> Brand: <span> ${item.brand}</span> </p>
                            </div>
                        </div>

                    </c:forEach>
                    </div>
                    <%--<div class="slides">--%>
                        <%--<a href="#"><img src="http://placehold.it/870x373" alt=""></a>--%>
                        <%--<div class="overlay">--%>
                            <%--<h1>AWESOME FURNITUR</h1>--%>
                            <%--<p><span>50%</span> OFF <br/> TRENDY <span>DESIGNS</span> </p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="slides">--%>
                        <%--<a href="#"><img src="http://placehold.it/870x373" alt=""></a>--%>
                        <%--<div class="overlay">--%>
                            <%--<h1>LATEST FASHION</h1>--%>
                            <%--<p><span>30%</span> OFF <br/> TRENDY <span>DESIGNS</span> </p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>



                    <%--<?php foreach ($sliderProducts as $slider) : ?>--%>
                    <%--<div class="slides">--%>
                        <%--<? $path = Products::getImageByID($slider->idproducts,1); ?>--%>
                        <%--<a href="/products/<?php echo $slider->idproducts;?>"><img src='<?php echo $path;?>' alt="<?php echo $slider->name; ?>"></a><!-- 870x373 -->--%>
                        <%--<div class="overlay">--%>
                            <%--<h1> <?php echo $slider->name; ?></h1>--%>
                            <%--<p><span><?php echo $slider->price; ?>%</span> Цена <br/> Brand: <span> <?php echo $slider->brand; ?>  </span> </p>--%>
                        <%--</div>--%>
                    <%--</div>--%>


                    <%--<?php endforeach;?>--%>


                <a href="#" class="next"></a>
                <a href="#" class="prev"></a>
                <div class="slider-btn"></div>
            </div>
            <!-- SLIDER -->

            <!-- SPECIAL-OFFER -->
            <div class="span3">
                <div class="offers">
                    <figure>
                        <a href="${pageContext.servletContext.contextPath}/products?idproducts=19"><img src="${pageContext.servletContext.contextPath}/uploads/images/products/big/19.jpg" alt="Культиватор Caiman ELITE 60S D2"></a>
                        <div class="overlay">
                            <h1> Культиватор Caiman ELITE 60S D2<span> Скидка 10% </span> <small>  Ограниченное предложение </small></h1>
                        </div>
                    </figure>
                </div>

                <div class="offers">
                    <figure>
                        <a href="${pageContext.servletContext.contextPath}/products/18"><img src="${pageContext.servletContext.contextPath}/uploads/images/products/big/18.jpg" alt="Культиватор Caiman ELITE 60S D2"></a>
                        <div class="overlay">
                            <h1> Культиватор Craftsman 29932<span> Скидка 10% </span> <small>  Ограниченное предложение </small></h1>
                        </div>
                    </figure>
                </div>
            </div>
            <!-- SPECIAL-OFFER -->

        </div>
    </div>
</div>

<%--<!-- PRODUCT-OFFER -->--%>
<%--<div class="product_wrap">--%>
    <%--<div class="container">--%>
        <%--<div class="row heading-wrap">--%>
            <%--<div class="span12 heading">--%>
                <%--<h2> Рекомендуемые товары <span></span></h2>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="row">--%>
            <%--<?php--%>
                                <%--foreach ($latestProducts as $lastProd) { ?>--%>


            <%--<div class="span3 product">--%>

                <%--<div>--%>
                    <%--<figure> <?   $path = Products::getImageByID($lastProd['idproducts'],1); ?>--%>
                        <%--<a href="/products/<?php echo $lastProd['second_category_main_category_idmain_cat'];?>"><img src="<? echo $path; ?>" alt="<?echo  $lastProd['name'];?>"></a>--%>
                        <%--<div class="overlay">--%>

                            <%--<a href="/products/<?php echo $lastProd['second_category_main_category_idmain_cat'];?>" class="link"></a>--%>
                        <%--</div>--%>
                    <%--</figure>--%>
                    <%--<div class="detail">--%>
                        <%--<span><?php echo $lastProd['price']; ?></span>--%>
                        <%--<h4><?php echo $lastProd['name']; ?></h4>--%>
                        <%--<div class="icon">--%>
                            <%--<a href="/cart/add/<?php echo $lastProd['idproducts']; ?>" data-id="<?php echo $lastProd['idproducts'];?>"  class="one_tooltip" title="Add to wish list" id="add-to-cart"></a>--%>

                            <%--<a href="/products/<?php echo $lastProd['idproducts'];?>" class="three tooltip" title="Add to compare"></a>--%>



                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>

            <%--<?php }?>--%>


        <%--</div>--%>

    <%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<!-- PRODUCT-OFFER -->--%>

<%--<!-- CLIENTS -->--%>
<%--<div class="clients-wrap">--%>
    <%--<div class="container">--%>
        <%--<div class="row heading-wrap">--%>
            <%--<div class="span12 heading">--%>
                <%--<h2>Производители <span></span></h2>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="span12 clients">--%>
                <%--<ul class="elastislide-list clearfix" id="carousel">--%>
                    <%--<li><a href="#"><img src="http://placehold.it/141x28" alt=""></a></li>--%>
                    <%--<?foreach ($brandsList as $brand) { ?>--%>
                    <%--<li><a href="#"><img src="http://placehold.it/141x28" alt=""></a></li>--%>
                    <%--<h1><? echo $brand['name'];?> <span></span></h1>--%>
                    <%--<?} ?>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<!-- CLIENTS -->

<!-- CATEGORIES -->
<div class="categories-wrap">
    <div class="container">
        <div class="row">

            <div class="span4">
                <div class="categories">
                    <figure>
                        <img src="http://placehold.it/370x133" alt="">
                        <div class="cate-overlay">
                            <a href="#">Single Seat</a>
                        </div>
                    </figure>
                </div>
            </div>

            <div class="span4">
                <div class="categories">
                    <figure>
                        <img src="http://placehold.it/370x133png" alt="">
                        <div class="cate-overlay">
                            <a href="#">Surfaces</a>
                        </div>
                    </figure>
                </div>
            </div>

            <div class="span4">
                <div class="categories">
                    <figure>
                        <img src="http://placehold.it/370x133" alt="">
                        <div class="cate-overlay">
                            <a href="#">Storage</a>
                        </div>
                    </figure>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- CATEGORIES -->
<jsp:include page="../../layout/footer.jsp"/>




</body>
</html>
