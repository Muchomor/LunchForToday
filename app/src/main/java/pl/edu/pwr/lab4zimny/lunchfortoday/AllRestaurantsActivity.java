package pl.edu.pwr.lab4zimny.lunchfortoday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KubaLaptop on 06.06.2017.
 */

public class AllRestaurantsActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    List<String> allRestaurants;
    RestaurantHelper restaurantHelper;
    Intent websiteIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        restaurantHelper = new RestaurantHelper();
        list = (ListView) findViewById(R.id.listView1);

        makeListOfRestaurantsNames();

        adapter = new ArrayAdapter<>(this, R.layout.row, allRestaurants);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                openWebsite(position);
            }
        });
    }

    public void makeListOfRestaurantsNames(){
        allRestaurants = new ArrayList<>();
        for (int i = 0; i < restaurantHelper.restaurants.size(); i++) {
            allRestaurants.add(restaurantHelper.pickRestaurant(i).getName());
        }
    }

    public void openWebsite(int position) {
        Uri uriUrl = Uri.parse(restaurantHelper.pickRestaurant(position).getUrl());
        websiteIntent = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(websiteIntent);
    }
}
