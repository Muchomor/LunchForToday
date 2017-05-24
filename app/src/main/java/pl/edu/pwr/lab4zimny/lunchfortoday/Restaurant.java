package pl.edu.pwr.lab4zimny.lunchfortoday;

/**
 * Created by KubaLaptop on 24.05.2017.
 */

public class Restaurant {

    private String name;
    private String url;

    public Restaurant(String name, String url){
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
