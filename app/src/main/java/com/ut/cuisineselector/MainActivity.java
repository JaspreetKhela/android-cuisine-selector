package com.ut.cuisineselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    //  Define a debugging tag
    private static String TAG = "Cuisines";

    // Define a listView for displaying the cuisine options
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // __________
        //
        // The following custom code was added to the default code
        // __________

        // Define array that contains different cuisines
        String[] cuisines = new String[Dish.dishes.length];

        // Populate the cuisines array
        for (int i=0; i < cuisines.length; i++) {
            cuisines[i] = Dish.dishes[i].getCuisine();
        }

        // Log the cuisines array loaded from the Dish.java file
        Log.d(TAG, "Cuisine Array: " + cuisines);

        // Find the reference to the listView that displays the available cuisines
        listView = (ListView) findViewById(R.id.listView);

        // Define the arrayAdapter that will be used to pass data from the cuisines array to the listView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuisines);

        // Bind the array data in the cuisines array to the listView
        listView.setAdapter(arrayAdapter);

        // Add an event listener to the listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Launch the DetailActivity.java file and pass on the selected cuisine
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("EXTRA_CUISINE", selectedItem);
                MainActivity.this.startActivity(intent);
            }
        });
        // __________
        //
        // End of the custom code
        // __________
        }
}
