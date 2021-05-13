package co.nishchal.locationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            TextView text = findViewById(R.id.text);
            Button fetchBtn = findViewById(R.id.fetch);
            // You can use the API that requires the permission.
            Toast.makeText(this, "Permission is granted", Toast.LENGTH_LONG).show();
            FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            fetchBtn.setOnClickListener(v -> {
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onSuccess(Location location) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    text.setText(location.getLatitude() + " " + location.getLongitude());
                                }
                            }
                        });
            });
        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1000);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Permission NOT granted", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}