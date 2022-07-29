package sg.edu.rp.c36.id21028831.my_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showMovies extends AppCompatActivity {
    ArrayList<Movies> al;
    ListView lv;
    CustomAdapter caMovies;
    Button btnPg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        btnPg=findViewById(R.id.btnPg);
        lv=findViewById(R.id.lv);

        al=new ArrayList<>();
        caMovies= new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(caMovies);

        DBHelper dbh=new DBHelper(showMovies.this);
        al.clear();
        al.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();

        btnPg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(showMovies.this);
                al.clear();
                // al.addAll(dbh.getAllNotes());

                String filterText = "PG";
                al.addAll(dbh.getPgMovies(filterText));

                caMovies.notifyDataSetChanged();
            }
        });

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Movies data=al.get(position);
//                Intent i=new Intent(showMovies.this, editMovies.class);
//                i.putExtra("data", data);
//                startActivity(i);
//            }
//        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movies target = al.get(position);

                Intent i = new Intent(showMovies.this,
                        editMovies.class);
                i.putExtra("data", target);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(showMovies.this);
        al.clear();
        al.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();
    }
}