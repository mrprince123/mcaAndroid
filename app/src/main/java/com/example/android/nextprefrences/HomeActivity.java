package com.example.android.nextprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


    TextView textView_name, textView_email;
    Button button_logout;


    SharedPreferences sharedPreferences;
    // So Create a shared Preferences name and also create key name
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_email = findViewById(R.id.text_email);
        textView_name = findViewById(R.id.text_fullname);
        button_logout = findViewById(R.id.button_logout);


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name =sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if (name != null || email != null){
            // So set the data on textView
            textView_name.setText("Full Name - "+name);
            textView_email.setText("Email ID- "+email);
        }


        // So call to button for log out Session

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(HomeActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}