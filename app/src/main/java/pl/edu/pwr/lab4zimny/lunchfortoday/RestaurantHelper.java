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
        restaurants.add(new Restaurant("Bernard","http://bernard.wroclaw.pl/", "https://www.facebook.com/BERNARD-247172495065/"));
        restaurants.add(new Restaurant("Sukiennice 7","http://sukiennice7.pl/", "https://www.facebook.com/sukiennice7/"));
        restaurants.add(new Restaurant("Patio","https://restauracjapatio.eu/", "https://www.facebook.com/RestauracjaPatio/"));
        restaurants.add(new Restaurant("Soczewka","http://www.soczewka.wroclaw.pl/", "https://www.facebook.com/soczewkawroclaw/"));
        restaurants.add(new Restaurant("Wodnik","http://www.wodnik-hotel.pl/", "https://www.facebook.com/Hotel.RestauracjaWodnik/"));
        restaurants.add(new Restaurant("Marina","http://www.marina.wroc.pl/index/", "https://www.facebook.com/PrzystanMarina/"));
        restaurants.add(new Restaurant("Baszta","http://www.baszta.wroclaw.pl", "https://www.facebook.com/basztaniedzwiadka/"));
        restaurants.add(new Restaurant("4Hops","4hops.ontap.pl", "https://www.facebook.com/4hops/"));
    }

    public Restaurant pickRestaurant(int index){
        return restaurants.get(index);
    }
}
