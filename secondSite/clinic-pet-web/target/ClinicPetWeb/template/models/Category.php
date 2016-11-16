<?php
class Category
{
	
	public static function getCategoryList ()
	{
		$db = DB::getConnection();

		$result = $db->query('SELECT idmain_cat, name,date, name_uri  FROM main_category where status = 1 ORDER BY sort_order ASC LIMIT 10');
		$result->setFetchMode(PDO::FETCH_ASSOC);
		$categoryList = array();
		$i=0;
		while($row = $result->fetch()) {
			$categoryList[$i]['idmain_cat'] = $row['idmain_cat'];
			$categoryList[$i]['name'] = $row['name'];
			$categoryList[$i]['date'] = $row['date'];
			$categoryList[$i]['name_uri'] = $row['name_uri'];
			$i++;
		}
		return $categoryList;

	}
	
	public static function getCategorybyId ($idCategory)
	{

		if($id){
		$db = DB::getConnection();

		$result = $db->query('SELECT idmain_cat, name,date, name_uri FROM main_category WHERE idmain_cat=' . $idCategory);
		$result->setFetchMode(PDO::FETCH_ASSOC);
		$Category = $result->fetch();

		return $Category;
	}
	}
	public static function getCategorybyName ($NameCategory)
	{

		if($id){
		$db = DB::getConnection();

		$result = $db->query('SELECT idmain_cat, name,date, name_uri FROM main_category WHERE name_uri=' . $NameCategory);
		$result->setFetchMode(PDO::FETCH_ASSOC);
		$Category = $result->fetch();

		return $Category;
	}


	}


}