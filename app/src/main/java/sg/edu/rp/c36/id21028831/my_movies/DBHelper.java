package sg.edu.rp.c36.id21028831.my_movies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myMovies.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_MOVIE = "Movie";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_RATING = "rating";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_MOVIE + "("
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_GENRE + " TEXT,"
                + COLUMN_YEAR + " INTEGER )";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_MOVIE + " ADD COLUMN  module_name TEXT ");
    }

    public long insertMovie(String Title, String Genre, int Year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, Title);
        values.put(COLUMN_GENRE, Genre);
        values.put(COLUMN_YEAR, Year);
        long result = db.insert(TABLE_MOVIE, null, values);
        db.close();
        Log.d("SQL Insert", "ID:" + result);
        return result;
    }
    /////
    public ArrayList<Movies> getAllSongs() {
        ArrayList<Movies> movies = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIE, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                //int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String genre = cursor.getString(2);
                int year = cursor.getInt(3);
                int rating = cursor.getInt(4);
                Movies movie = new Movies(title, genre, year, rating);
                movies.add(movie);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return movies;
    }
}
