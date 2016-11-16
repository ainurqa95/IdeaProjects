                            <div class="span3">
                                <div id="sidebar">
                                    <div class="widget">
                                        <h4>Категории</h4>

                                        <div id="accordion">
                                            <?php 
                                            foreach ($categoryList as $categoryMain){
                                                # code...
                                            
                                            ?>
                                            <h5 <?php 
                                            if($categoryMain['idmain_cat'] == $idCategoryMain) echo  'class ="ui-accordion-header-active"';
                                             else echo 'class=""'; 
                                            ?> ><a href="/category/<?php echo $categoryMain['idmain_cat'];?>/1/page-1"><?php echo $categoryMain['name'];?></a></h5>
                                            <div>
                                                <ul>
                                                    <?php foreach ($SecondCategoryList as $categorySecond) {
                                                                        if($categorySecond['main_category_idmain_cat']==$categoryMain['idmain_cat'])

                                                                        { ?>
                                                    <li><a href="/category/<?php echo $categoryMain['idmain_cat']; ?>/<?php echo $categorySecond['idsecond_cat'];?>/page-1"/><?php echo $categorySecond['name'];?></a> </li>
                                                    <?php } }?>
  
                                                </ul>
                                            </div>
                                            <?php } ?>

                                           
                                        </div>

                                    </div>

                                    <div class="widget">
                                        <h4>Price Filter</h4>

                                        <div class="price-range">
                                            <div id="slider-range"></div>
                                            <p class="clearfix">
                                                <input type="text" id="amount" />
                                                <input type="text" id="amount2" />
                                            </p>
                                        </div>
                                    </div>

                                    <div class="widget">
                                        <h4>Featured Products</h4>

                                        <div class="featured">
                                            <ul>
                                                <li class="clearfix">
                                                    <figure>
                                                        <a href="#"><img src="http://placehold.it/50x50" alt=""></a>
                                                    </figure>
                                                    <div>
                                                        <h5>Brown Wood Chair</h5>
                                                        <span>$244.00</span>
                                                    </div>
                                                </li>

                                                <li class="clearfix">
                                                    <figure>
                                                        <a href="#"><img src="http://placehold.it/50x50" alt=""></a>
                                                    </figure>
                                                    <div>
                                                        <h5>Brown Wood Chair</h5>
                                                        <span>$244.00</span>
                                                    </div>
                                                </li>

                                                <li class="clearfix last">
                                                    <figure>
                                                        <a href="#"><img src="http://placehold.it/50x50" alt=""></a>
                                                    </figure>
                                                    <div>
                                                        <h5>Brown Wood Chair</h5>
                                                        <span>$244.00</span>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>

                                    </div>

                                </div>
                            </div>