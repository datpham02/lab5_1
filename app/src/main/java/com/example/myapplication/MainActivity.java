package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText eWord,vWord,typeWord;
    Button btnAdd;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eWord = findViewById(R.id.eWord);
        vWord = findViewById(R.id.vWord);
        typeWord = findViewById(R.id.typeWord);
        btnAdd = findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = eWord.getText() + " - " + typeWord.getText() + " - " + vWord.getText();
                try {
                    FileOutputStream fileOutputStream = openFileOutput("tudien.txt", MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(data);
                    outputStreamWriter.close();
                    Toast.makeText(MainActivity.this, "Write file successfully", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Write file failed", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}