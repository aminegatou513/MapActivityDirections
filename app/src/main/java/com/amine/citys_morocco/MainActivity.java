package com.amine.citys_morocco;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("GoogleMaps Beta V5");
        setContentView(R.layout.mainactivity);
        text = findViewById(R.id.textView);
        text.setText("Welcome to GoogleMaps Beta V5\n Choose what you wan't to do in the menu above");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.our_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    ///

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.a1){
            Intent i = new Intent(this,MapsActivity.class);
            startActivity(i);
        }
        else if (id ==R.id.a2){
            Intent i = new Intent(this,Distance_Track.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    ///

}
