 <!-- FOOTER -->

                <div class="footer-wrap">
                    <div class="container">
                       

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
