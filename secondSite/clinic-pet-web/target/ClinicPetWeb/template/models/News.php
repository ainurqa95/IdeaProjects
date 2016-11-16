<?php

class News
{
	
	public static function getNewsList ()
	{
		$db = DB::getConnection();

		$result = $db->query('SELECT * FROM news ORDER BY id ASC LIMIT 10');
		$result->setFetchMode(PDO::FETCH_ASSOC);
		$newsList = array();
		$i=0;
		while($row = $result->fetch()) {
			$newsList[$i]['id'] = $row['id'];
			$newsList[$i]['title'] = $row['title'];
			$newsList[$i]['date'] = $row['date'];
			$newsList[$i]['author_name'] = $row['author_name'];
			$newsList[$i]['short_content'] = $row['short_content'];
			$i++;
		}
		return $newsList;

	}
	public static function getNewsbyId ($id)
	{
		if($id){
		$db = DB::getConnection();

		$result = $db->query('SELECT * FROM news WHERE id=' . $id);
		$result->setFetchMode(PDO::FETCH_ASSOC);
		$news = $result->fetch();

		return $news;
	}


	}


}