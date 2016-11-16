<?php
           // require_once(ROOT.'/models/Category.php');
			//$categoryList = Category::getCategoryList();
			//$SecondCategoryList = Category::getSecondCategoryList();
            /*
            $fields = array('idproducts', 'price');
            $params = array('1'=> 2,'2' => 4,'4' => 3);
            $what_in = 'idproducts';
            $object_product =ProductsTable::find_all_with_fields_where_in($params,$fields,$what_in);
            print_r($object_product);
            */

?>

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
                <link rel="stylesheet" href="/template/css/tooltipster.css">
                <link href="css/ie.css" rel="/template/stylesheet" media="all">
                <link rel="stylesheet" href="/template/css/bootstrap.css">
                
				<link rel="stylesheet" href="/template/css/responsive.css">
                <link rel="stylesheet" href="/template/css/prettyPhoto.css">
                <link rel="stylesheet" href="/template/style.css">
				
				<!-- favicon -->
				<link rel="shortcut icon" href="/template/images/lopatka.jpg">

            <!-- Include the HTML5 shiv print polyfill for Internet Explorer browsers 8 and below -->
            <!--[if lt IE 10]><script src="js/html5shiv-printshiv.js" media="all"></script><![endif]-->
		</head>
		<body>				
				<!-- HEADER -->
				<div class="header-bar">
                    <div class="container">
                        <div class="row">


                            <div class="span10 right">
                                <div class="social-strip">
                                    <ul>
                                        
                                        <?php if(!User::isLogged()): ?>
                                        <li><a href="/user/register" class="account">Зарегистрироваться</a></li>
                                        <li><a href="/user/login" class="check">Войти </a></li>
                                    <?php else :?>
                                        <li><a href="/admin" class="check"> Админ Панель </a></li>
                                           <li><a href="/" class="check">На сайт </a></li>
                                        <li><a href="/user/logout" class="check">Выйти </a></li>
                                    <?php endif; ?>
                                    </ul>
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
                                    <a href="/"><img src="/template/images/logo2.png" alt=""></a>
                                    <h1><a href="/"> <span>Садовая техника, бензоинструмент,строительное оборудование </span>  </a></h1>
                                </div>
                            </div>

                            <div class="span5">
                                <form>
                                    <input type="text" placeholder="Type and hit enter">
                                    <input type="submit" value="">
                                </form>
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
                                            <a href="/admin"> Админ Панель</a>
        
                                        </li>

                                        <li>

                                        <li><a href="/">На сайт</a></li>
                                       
                                    </ul>
                                </nav>

                                <select>
                                    <option>BAGS</option>
                                    <option>Jackets</option>
                                    <option>ACCESORIES </option>
                                    <option>CATEGORIES</option>
                                    <option>Manufacters</option>
                                    <option>Sale </option>
                                    <option>Blog</option>
                                    <option>Dresses</option>
                                    <option>Jewelry</option>
                                    <option>ShOES</option>
                                    <option>Shirts</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </header>
				<!-- HEADER -->