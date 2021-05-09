package co.nishchal.seconddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;

        Button tapMeButton = findViewById(R.id.tapMe);
        TextView countTextView = findViewById(R.id.countText);

        countTextView.setText(count + "");

        tapMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count;
                countTextView.setText(count + "");
            }
        });
    }
}