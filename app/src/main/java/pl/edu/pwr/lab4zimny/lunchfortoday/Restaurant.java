package pl.edu.pwr.lab4zimny.lunchfortoday;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by KubaLaptop on 24.05.2017.
 */

public class Restaurant {

    private String name;
    private String url;
    private String facebookAddress;

    public Restaurant(String name, String url, String facebookAddress){
        this.name = name;
        this.url = url;
        this.facebookAddress = facebookAddress;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + facebookAddress;
            } else { //older versions of fb app
                return "fb://page/" + "100002123557545"; //funny prank, opens BERNI
            }
        } catch (PackageManager.NameNotFoundException e) {
            return facebookAddress;
        }
    }
}
