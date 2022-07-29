package sg.edu.rp.c36.id21028831.my_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class showMovies extends AppCompatActivity {
    ArrayList<Movies> al;
    ListView lv;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        lv=findViewById(R.id.lv);

        al=new ArrayList<Movies>();
        caMovies= new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(caMovies);

        DBHelper dbh=new DBHelper(showMovies.this);
        al.clear();
        al.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();

    }
}