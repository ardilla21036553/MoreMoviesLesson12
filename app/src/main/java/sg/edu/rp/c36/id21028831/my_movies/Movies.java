package sg.edu.rp.c36.id21028831.my_movies;

import java.io.Serializable;

public class Movies implements Serializable {
    private String title;
    private String genre;
    private int year;
    private int rating;

    public Movies(String title, String genre, int year, int rating) {

        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }


}
