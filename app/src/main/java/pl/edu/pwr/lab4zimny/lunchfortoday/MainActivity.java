package pl.edu.pwr.lab4zimny.lunchfortoday;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private TextView restaurantName;
    private RestaurantHelper restaurantHelper;
    private Button facebookButton;
    private Button websiteButton;
    Intent facebookIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restaurantName = (TextView) findViewById(R.id.restaurantName);
        facebookButton = (Button) findViewById(R.id.facebookButton);
        websiteButton = (Button) findViewById(R.id.websiteButton);
        restaurantHelper = new RestaurantHelper();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
                handleShakeEvent();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    public void handleShakeEvent(){
        Random rand = new Random();
        int random = rand.nextInt(restaurantHelper.restaurants.size());
        restaurantName.setText(restaurantHelper.pickRestaurant(random).getName());
        restaurantName.setVisibility(View.VISIBLE);

        facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = restaurantHelper.pickRestaurant(random).getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(facebookIntent);
            }
        });
    }
}
