package com.hfad.nicoleampornbinette.shoesteps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_shoes:
                Intent SHOES = new Intent(this, Shoes.class);
                startActivity(SHOES);
                return true;
            case R.id.action_miles:
                Intent MILES = new Intent(this, Miles.class);
                startActivity(MILES);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickStartTracking(View view) {
        Intent TRACK = new Intent(this, Track.class);
        startActivity(TRACK);
    }

    public void onClickAddNewShoes(View view) {
        Intent ADD = new Intent(this, Add.class);
        startActivity(ADD);
    }




}
