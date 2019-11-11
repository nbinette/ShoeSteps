package com.hfad.nicoleampornbinette.shoesteps;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Add extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
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

    public void onClickPhoto(View view) {
        TextInputEditText shoeName = findViewById(R.id.shoe_one_name);
        TextInputEditText datePurchased = findViewById(R.id.date_purchased);
        Shoe myShoe = new Shoe(shoeName.getText().toString(), datePurchased.getText().toString());
        dispatchTakePictureIntent(myShoe);
    }
    /**
     * Start camera
     */
    private void dispatchTakePictureIntent(Shoe shoe) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra("shoeName", shoe.getName());
        takePictureIntent.putExtra("datePurchased", shoe.getDate());
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    /**
     * Get and load image in grid view
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            String shoeName = data.getStringExtra("shoeName");
            String datePurchased = data.getStringExtra("datePurchased");
            //loadImage(imageBitmap, shoeName, datePurchased);
        }
    }

    /**
     * Load image in grid view
     * @param imageBitmap
     */
    /*protected void loadImage(Bitmap imageBitmap, String shoeName, String datePurchased) {
        ImageView[] imageViews = {findViewById(R.id.shoe_one), findViewById(R.id.shoe_two), findViewById(R.id.shoe_three)};
        for (int i = 0; i < imageViews.length; i++) {
            if (imageViews[i].getDrawable() == null) {
                ImageView imageView = imageViews[i];
                imageView.setImageBitmap(imageBitmap);
                Intent SHOES = new Intent();
                TextView name = findViewById(R.id.shoe_one_name);
                TextView date = findViewById(R.id.shoe_one_date);
                TextView steps = findViewById(R.id.shoe_one_steps);
                TextView miles = findViewById(R.id.shoe_one_miles);
                switch(i) {
                    case 0:
                        name.setText(shoeName);
                        date.setText(datePurchased);
                        steps.setText(0);
                        miles.setText(0);
                        startActivity(SHOES);
                    case 1:
                        name = findViewById(R.id.shoe_two_name);
                        date = findViewById(R.id.shoe_two_date);
                        steps = findViewById(R.id.shoe_two_steps);
                        miles = findViewById(R.id.shoe_two_miles);
                        name.setText(shoeName);
                        date.setText(datePurchased);
                        steps.setText(0);
                        miles.setText(0);
                        startActivity(SHOES);
                    case 2:
                        name = findViewById(R.id.shoe_three_name);
                        date = findViewById(R.id.shoe_three_date);
                        steps = findViewById(R.id.shoe_three_steps);
                        miles = findViewById(R.id.shoe_three_miles);
                        name.setText(shoeName);
                        date.setText(datePurchased);
                        steps.setText(0);
                        miles.setText(0);
                        startActivity(SHOES);
                    default:
                        // All shoe storage occupied
                        startActivity(SHOES);
                }
            }
        }

    }
     */
}
