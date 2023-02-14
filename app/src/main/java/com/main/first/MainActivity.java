package com.main.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button validate;
    TextView whats_your_name;
    EditText my_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validate = findViewById(R.id.btn_validate);
        whats_your_name = findViewById(R.id.tv_whats_your_name);
        my_name = findViewById(R.id.et_my_name);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String our_name = my_name.getText().toString();

                if(our_name.equals("Viktors")){
                    Toast.makeText(getApplicationContext(),"Correct name",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Incorrect name",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}