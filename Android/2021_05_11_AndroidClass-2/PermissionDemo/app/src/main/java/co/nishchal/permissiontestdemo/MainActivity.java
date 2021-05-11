package co.nishchal.permissiontestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import kotlin.Unit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            Toast.makeText(this, "Permission is granted", Toast.LENGTH_LONG).show();
        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA},
                    1000);
        }

        CircularProgressBar circularProgressBar = findViewById(R.id.circularProgressBar);
// Set Progress
        circularProgressBar.setProgress(65f);
// or with animation
        circularProgressBar.setProgressWithAnimation(65f, 1000l); // =1s

// Set Progress Max
        circularProgressBar.setProgressMax(200f);

// Set ProgressBar Color
        circularProgressBar.setProgressBarColor(Color.BLACK);
// or with gradient
        circularProgressBar.setProgressBarColorStart(Color.GRAY);
        circularProgressBar.setProgressBarColorEnd(Color.RED);
        circularProgressBar.setProgressBarColorDirection(CircularProgressBar.GradientDirection.TOP_TO_BOTTOM);

// Set background ProgressBar Color
        circularProgressBar.setBackgroundProgressBarColor(Color.GRAY);
// or with gradient
        circularProgressBar.setBackgroundProgressBarColorStart(Color.WHITE);
        circularProgressBar.setBackgroundProgressBarColorEnd(Color.RED);
        circularProgressBar.setBackgroundProgressBarColorDirection(CircularProgressBar.GradientDirection.TOP_TO_BOTTOM);

// Set Width
        circularProgressBar.setProgressBarWidth(7f); // in DP
        circularProgressBar.setBackgroundProgressBarWidth(3f); // in DP

// Other
        circularProgressBar.setRoundBorder(true);
        circularProgressBar.setStartAngle(180f);
        circularProgressBar.setProgressDirection(CircularProgressBar.ProgressDirection.TO_RIGHT);

        circularProgressBar.setOnIndeterminateModeChangeListener(isEnable -> {
            // Do something
            return Unit.INSTANCE;
        });

        circularProgressBar.setOnProgressChangeListener(progress -> {
            // Do something
            return Unit.INSTANCE;
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted, can use camera.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Permission NOT granted, cannot use camera.", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}