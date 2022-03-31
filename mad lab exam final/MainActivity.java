package com.example.sjcet.myapplicationexam1;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, uemailorphno,upassword,gender,dob;
    Button btnsubmit;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_EMAILORPHONE = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_DOB = "dob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        uemailorphno = findViewById(R.id.uemailorphno);
        upassword = findViewById(R.id.password);
        gender = findViewById(R.id.gender);
        dob = findViewById(R.id.dob);
        btnsubmit = findViewById(R.id.btsubmit);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

//        String name = sharedPreferences.getString(KEY_FNAME,null);

//        if (name != null) {
//            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//            startActivity(intent);
//        }


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_FNAME,firstname.getText().toString());
                editor.putString(KEY_LNAME,lastname.getText().toString());
                editor.putString(KEY_EMAILORPHONE,uemailorphno.getText().toString());
                editor.putString(KEY_GENDER,gender.getText().toString());
                editor.putString(KEY_DOB,dob.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });

    }
}