package sg.edu.rp.c36.id21028831.my_movies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class editMovies extends AppCompatActivity {
    EditText etID, etTitle, etGenre, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    Movies data;
    Spinner spinnerRating;
    String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movies);

        etID = findViewById(R.id.etID);
        etTitle=findViewById(R.id.etTitle);
        etGenre=findViewById(R.id.etGenre);
        etYear=findViewById(R.id.etYear);
        spinnerRating=findViewById(R.id.spinnerRating);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnCancel=findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");

        etID.setFocusable(false);
        etID.setText(String.valueOf(data.getId()));
        etTitle.setText(data.getTitle());
        etGenre.setText(data.getGenre());
        etYear.setText(String.valueOf(data.getYear()));

        spinnerRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position){
                    case 0:
                        rating="G";
                        break;

                    case 1:
                        rating="PG";
                        break;

                    case 2:
                        rating="PG13";
                        break;

                    case 3:
                        rating="NC16";
                        break;

                    case 4:
                        rating="M18";
                        break;

                    case 5:
                        rating="R21";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editMovies.this);
                data.setTitle(etTitle.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setRating(rating);
                dbh.updateMovie(data);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(editMovies.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the movie " + data.getTitle()+"?");
                myBuilder.setCancelable(true);

                myBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBHelper dbh = new DBHelper(editMovies.this);
                        dbh.deleteMovie(data.getId());
                        finish();
                    }
                });
                myBuilder.setNeutralButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(editMovies.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to discard the changes?");
                myBuilder.setCancelable(true);

                //configure the 'positive' button
                myBuilder.setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                myBuilder.setNegativeButton("DO NOT DISCARD", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


    }
}