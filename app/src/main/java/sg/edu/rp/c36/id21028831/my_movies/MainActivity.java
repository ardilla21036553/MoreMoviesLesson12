package sg.edu.rp.c36.id21028831.my_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spinnerRating;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle=findViewById(R.id.etTitle);
        etGenre=findViewById(R.id.etGenre);
        etYear=findViewById(R.id.etYear);
        spinnerRating=findViewById(R.id.spinnerRating);
        btnInsert=findViewById(R.id.btnInsert);
        btnShow=findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=etTitle.getText().toString();
                String genre=etGenre.getText().toString();
                int year=Integer.parseInt(etYear.getText().toString());
                spinnerRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    String rating="";
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
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

                DBHelper dbh=new DBHelper(MainActivity.this);
                long inserted_id=dbh.insertMovie(title,genre,year,rating);

                if (inserted_id !=1){
                    Toast.makeText(MainActivity.this, "Insert Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}