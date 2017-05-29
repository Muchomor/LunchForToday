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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private RestaurantHelper restaurantHelper;
    @BindView(R.id.restaurant_name) private TextView restaurantName;
    @BindView(R.id.shake_text_view) private TextView shakeTextView;
    @BindView(R.id.facebook_button) private Button facebookButton;
    @BindView(R.id.website_button) private Button websiteButton;
    Intent facebookIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        restaurantHelper = new RestaurantHelper();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake(int count) {
                handleShakeEvent();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    public void handleShakeEvent(){
        Random rand = new Random();
        int random = rand.nextInt(restaurantHelper.restaurants.size());
        restaurantName.setText(restaurantHelper.pickRestaurant(random).getName());
        restaurantName.setVisibility(View.VISIBLE);

        setFacebookButtonListener(random);
        changeVisibilities();
    }

    public void setFacebookButtonListener(int random){
        facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = restaurantHelper.pickRestaurant(random).getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(facebookIntent);
            }
        });
    }

    public void changeVisibilities(){
        shakeTextView.setVisibility(View.INVISIBLE);
        facebookButton.setVisibility(View.VISIBLE);
        websiteButton.setVisibility(View.VISIBLE);
    }

}
