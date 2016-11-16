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

				
				<!-- Scripts -->
				<script src="/template/js/jquery-1.9.1.min.js"></script>
                <script src="/template/js/jquery-ui.js"></script>
                <script src="/template/js/jquery.cycle.all.js"></script>
                <script src="/template/js/modernizr.custom.17475.js"></script>
                <script src="/template/js/jquery.elastislide.js"></script>
                <script src="/template/js/jquery.carouFredSel-6.0.4-packed.js"></script>
                <script src="/template/js/jquery.selectBox.js"></script>
                <script src="/template/js/jquery.tooltipster.min.js"></script>
                <script src="/template/js/jquery.prettyPhoto.js"></script>
				<script src="/template/js/custom.js"></script>	
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
