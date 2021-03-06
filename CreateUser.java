package com.example.waqas.mhacks8;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by waqas on 10/8/2016.
 */

public class CreateUser  extends AppCompatActivity {

    private String myFirstName;
    private String myLastName;
    private String myAge;
    private String myGender;
    private String myCity;
    private String myState;
    private String myStartDate;
    private String myEndDate;
    private String myInterests;
    private String myUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myUserID = getIntent().getStringExtra("ID");
    }


    public void sendToTextFile(View view){
        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        age = (EditText) findViewById(R.id.etAge);
        gender = (EditText) findViewById(R.id.etGender);
        String info = firstName + "\n" + lastName + "\n" + age + "\n" + gender + "\n" + userID;

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("userData.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(info);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void readFile(View view){

        try{
            InputStream inputStream = this.openFileInput("userData.txt");
            if(inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                myFirstName = bufferedReader.readLine().toString();
                myLastName = bufferedReader.readLine().toString();
                myAge = bufferedReader.readLine().toString();
                myGender = bufferedReader.readLine().toString();
                myUserID = bufferedReader.readLine().toString();
            }
            else{
                //Open first page to create a userID
            }

            inputStream.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void switchView(View view){

    }
}
