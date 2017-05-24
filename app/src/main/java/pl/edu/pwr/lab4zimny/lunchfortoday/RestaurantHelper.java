package pl.edu.pwr.lab4zimny.lunchfortoday;

import java.util.ArrayList;

/**
 * Created by KubaLaptop on 24.05.2017.
 */

public class RestaurantHelper {
    public ArrayList<Restaurant> restaurants;

    public RestaurantHelper() {
        restaurants = new ArrayList<>();
        addRestaurants();
    }

    public void addRestaurants(){
        restaurants.add(new Restaurant("Bernard","http://bernard.wroclaw.pl/"));
        restaurants.add(new Restaurant("Sukiennice 7","http://sukiennice7.pl/"));
        restaurants.add(new Restaurant("Patio","https://restauracjapatio.eu/"));
        restaurants.add(new Restaurant("Soczewka","http://www.soczewka.wroclaw.pl/"));
        restaurants.add(new Restaurant("Wodnik","http://www.wodnik-hotel.pl/"));
        restaurants.add(new Restaurant("Marina","http://www.marina.wroc.pl/index/"));
    }

    public Restaurant pickRestaurant(int index){
        return restaurants.get(index);
    }
}
