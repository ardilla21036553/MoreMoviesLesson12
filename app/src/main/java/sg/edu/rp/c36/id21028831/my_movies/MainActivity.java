package sg.edu.rp.c36.id21028831.my_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spinnerRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle=findViewById(R.id.etTitle);
        etGenre=findViewById(R.id.etGenre);
        etYear=findViewById(R.id.etYear);
        spinnerRating=findViewById(R.id.spinnerRating);

    }

}