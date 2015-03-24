package com.example.newethan.exampleapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // public method - this is called "onclick" check the activity_main.xml
    public void sendButton(View view){
        // Lets grab the details about our textbox (formName)
        // Bare in mind for this example we haven't move all the textbox content over
        TextView x = (TextView) findViewById(R.id.formName);
        // Create a string variable and grab the text out of the textbox object
        String toastText = x.getText().toString();
        // If our variable is not empty....
        if (!TextUtils.isEmpty(toastText)){

            // Create Intent so we can get ready to start an activity - see the .class, that matches up with the activity name
            Intent intent = new Intent(this, DipslayMessage.class);
            // Setup putExtra which allows us to pass over values to new Activities
            intent.putExtra("test1", toastText);
            // Start Activity - see how it matches up with the intent object
            startActivity(intent);
        }
        else{
            // if the variable is empty create a toast and let them know
            Toast.makeText(this, "Please fill in the fields!", Toast.LENGTH_LONG).show();
        }

    }
    // public method - this is called "onclick" check the activity_main.xml
    public void clearButton(View view){
        // get all the text boxes
        TextView x = (TextView) findViewById(R.id.formName);
        TextView y = (TextView) findViewById(R.id.formEmail);
        TextView z = (TextView) findViewById(R.id.formMessage);
        // set all the text box content to nothing
        x.setText("");
        y.setText("");
        z.setText("");
        // display toast to let the user know they've been empties
        Toast.makeText(this, "Fields Cleared", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
