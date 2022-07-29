package sg.edu.rp.c36.id21028831.my_movies;

import java.io.Serializable;

public class Movies implements Serializable {
    private String title;
    private String genre;
    private int year;
    private int rating;
//help
    public Movies(String title, String genre, int year, int rating) {

        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){ return  title + "\n" + genre + "\n" + year + "\n" + rating; }

}
