package com.hfad.nicoleampornbinette.shoesteps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Shoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.shoes_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_start:
                Intent START = new Intent(this, Start.class);
                startActivity(START);
                return true;
            case R.id.action_miles:
                Intent MILES = new Intent(this, Miles.class);
                startActivity(MILES);
                return true;
            case R.id.action_add:
                Intent ADD = new Intent(this, Add.class);
                startActivity(ADD);
                return true;
            case R.id.action_delete:
                Intent DELETE = new Intent(this, Delete.class);
                // use putExtra to assign shoes into bundle sent to DELETE
                startActivity(DELETE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
