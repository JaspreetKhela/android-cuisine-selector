package com.ut.cuisineselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

public class OrderDishActivity extends AppCompatActivity {
    // Define a debugging tag
    private static String TAG = "OrderDetail";

    // Create a variable for the storing the value of the ordered dish
    String orderedDish;

    // Create a variable for storing the value of the quantity ordered of a dish
    int orderQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dish);

        // __________
        //
        // The following custom code was added to the default code
        // __________

        // Log a confirmation message
        Log.d(TAG, "Successfully redirected to OrderDishActivity.java");

        // Get the intent that was initiated in the MainActivity.java file
        Intent intent4 = getIntent();
        Bundle bundle2 = intent4.getExtras();

        // Get the user's selected cuisine
        orderedDish = bundle2.getString("EXTRA_DISH");

        // Confirm that the orderedDish is what the user selected
        Log.d(TAG, "Ordered Dish: " + orderedDish);

        // Get the reference of the TextView that displays the title of the layout
        TextView titleText = (TextView) findViewById(R.id.textView6);

        // Set the value of the titleText to the value of orderedDish
        titleText.setText(orderedDish);

        // Get the reference of the TextView that displays a confirmation message once an order has been placed
        TextView messageText = (TextView) findViewById(R.id.textView9);

        // Set the value of the messageText to initially be blank
        messageText.setText("");

        // Get the reference to the EditView that contains the quantity of the dish to be ordered
        TextView orderQuantityText = (TextView) findViewById(R.id.editTextNumber);

        // Get the reference to the button that is used to place an order
        Button placeOrderButton = (Button) findViewById(R.id.button2);

        // Define an event listener for the placeOrderButton
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Find the quantity of dishes ordered
                orderQuantity = Integer.parseInt(orderQuantityText.getText().toString());

                // Log the value of the selectedDish
                Log.d(TAG, "Quantity of " + orderedDish + " that was ordered: " + orderQuantityText.getText().toString());

                // If an order quantity greater than 0 is provided, then confirm the order has been placed
                if (orderQuantity != 0) {
                    messageText.setText("Your order for " + orderedDish + " has been placed!");
                }
                else {
                    messageText.setText("Please provide a valid quantity number for your order.");
                }
            }
        });

        // Get the reference to tht webView widget
        WebView happyDanceGif = (WebView) findViewById(R.id.webView) ;

        // Load a URL in the webView widget
        happyDanceGif.loadUrl("https://c.tenor.com/uC_5im6W2xkAAAAC/homer-happy.gif");

        // __________
        //
        // End of the custom code
        // __________
    }
}