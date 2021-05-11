package co.nishchal.seconddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LinearDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_demo);

        Intent intent = getIntent();
        int count = intent.getIntExtra("count", 0);

        TextView textView = findViewById(R.id.countText2);
        textView.setText(count + "");
    }
}