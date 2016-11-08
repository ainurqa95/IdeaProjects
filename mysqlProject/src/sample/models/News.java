package sample.models;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;

/**
 * Created by Айнур on 25.10.2016.
 */
public class News {
    private int id_news;
    String title;
    String author;
    String short_content;
    DateTimeAtCompleted date;

    public News(int id_news, String title, String author, String short_content) {
        this.id_news = id_news;
        this.title = title;
        this.author = author;
        this.short_content = short_content;
        //this.date = date;
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
