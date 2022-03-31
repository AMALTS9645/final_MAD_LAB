package com.example.sjcet.myapplicationexam1;

              import android.content.SharedPreferences;
              import android.support.v7.app.AppCompatActivity;
              import android.os.Bundle;
              import android.view.View;
              import android.widget.Button;
              import android.widget.TextView;
              import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView text_fname,text_lname,text_email,text_gender,text_dob;
    Button blogout;


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
        setContentView(R.layout.activity_main2);

        text_email = findViewById(R.id.text_email);
        text_fname = findViewById(R.id.text_fname);
        text_lname = findViewById(R.id.text_lname);
        text_gender = findViewById(R.id.text_gender);
        text_gender = findViewById(R.id.text_dob);
        blogout = findViewById(R.id.blogout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String fname = sharedPreferences.getString(KEY_FNAME,null);
        String lname = sharedPreferences.getString(KEY_LNAME,null);
        String email = sharedPreferences.getString(KEY_EMAILORPHONE, null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);
        String dob = sharedPreferences.getString(KEY_DOB,null);

        if (fname != null || email != null){
            text_fname.setText("fname- "+fname);
            text_lname.setText("lname- "+lname);
            text_email.setText("Email ID- "+email);
            text_gender.setText("gender- "+gender);
            text_dob.setText("dob- "+dob);
        }

        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(Main2Activity.this,"logged out successfully",Toast.LENGTH_SHORT).show();


            }
        });
    }
}
