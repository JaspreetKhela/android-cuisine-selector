package com.ut.cuisineselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {
    // Define a debugging tag
    private static String TAG = "DishDetail";

    // Define a variable for the selected dish (based on the selected cuisine)
    String selectedDish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // __________
        //
        // The following custom code was added to the default code
        // __________

        // Log a confirmation message
        Log.d(TAG, "Successfully redirected to DetailActivity.java");

        // Get the intent that was initiated in the MainActivity.java file
        Intent intent2 = getIntent();
        Bundle bundle = intent2.getExtras();

        // Get the user's selected cuisine
        String selectedCuisine = bundle.getString("EXTRA_CUISINE");

        // Define arrays of length 2 that will contain information about the dishes
        String[] indianDish = new String[2];
        String[] chineseDish = new String[2];
        String[] italianDish = new String[2];

        // Populate the indianDish array
        indianDish[0] = Dish.dishes[0].getName();
        indianDish[1] = Dish.dishes[0].getDescription();

        // Populate the chineseDish array
        chineseDish[0] = Dish.dishes[1].getName();
        chineseDish[1] = Dish.dishes[1].getDescription();

        // Populate the italianDish array
        italianDish[0] = Dish.dishes[2].getName();
        italianDish[1] = Dish.dishes[2].getDescription();

        // Log the arrays' values
        Log.d(TAG, "indianDish Array's Name: " + indianDish[0]);
        Log.d(TAG, "indianDish Array's Description: " + indianDish[1]);
        Log.d(TAG, "chineseDish Array's Name: " + chineseDish[0]);
        Log.d(TAG, "chineseDish Array's Description: " + chineseDish[1]);
        Log.d(TAG, "italianDish Array's Name: " + italianDish[0]);
        Log.d(TAG, "italianDish Array's Description: " + italianDish[1]);

        // Get references to the TextView widgets
        TextView cuisineName = (TextView) findViewById(R.id.textView3);
        TextView dishName = (TextView) findViewById(R.id.textView4);
        TextView dishDescription = (TextView) findViewById(R.id.textView5);

        // Get the reference to the ImageView widget used to display an image of the selected dish
        ImageView dishImage = (ImageView) findViewById(R.id.imageView);

        // Display information for the selected cuisine
        if (selectedCuisine.equals("Indian")) {
            // Update the selectedDish variable
            selectedDish = "Samosas";

            // Change the values of the TextView widgets
            cuisineName.setText("Indian Cuisine");
            dishName.setText(indianDish[0]);
            dishDescription.setText(indianDish[1]);

            // Update the ImageView to display the dish's image
            dishImage.setImageResource(R.drawable.samosas);
        }
        else if (selectedCuisine.equals("Chinese")) {
            // Update the selectedDish variable
            selectedDish = "Chow Mein";

            // Change the values of the TextView widgets
            cuisineName.setText("Chinese Cuisine");
            dishName.setText(chineseDish[0]);
            dishDescription.setText(chineseDish[1]);

            // Update the ImageView to display the dish's image
            dishImage.setImageResource(R.drawable.chowmein);
        }
        else if (selectedCuisine.equals("Italian")) {
            // Update the selectedDish variable
            selectedDish = "Ravioli";

            // Change the values of the TextView widgets
            cuisineName.setText("Italian Cuisine");
            dishName.setText(italianDish[0]);
            dishDescription.setText(italianDish[1]);

            // Update the ImageView to display the dish's image
            dishImage.setImageResource(R.drawable.ravioli);
        }

        // Get the reference to the orderDishButton
        Button orderDishButton = (Button) findViewById(R.id.button);

        // Define an event listener for the orderDishButton
        orderDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log the value of the selectedDish
                Log.d(TAG, selectedDish);

                // Log a confirmation message
                Log.d(TAG, "Redirecting to OrderDishActivity.java file");

                Intent intent3 = new Intent(DetailActivity.this, OrderDishActivity.class);
                intent3.putExtra("EXTRA_DISH", selectedDish);
                DetailActivity.this.startActivity(intent3);
            }
        });
    }

    // __________
    //
    // End of the custom code
    // __________
}