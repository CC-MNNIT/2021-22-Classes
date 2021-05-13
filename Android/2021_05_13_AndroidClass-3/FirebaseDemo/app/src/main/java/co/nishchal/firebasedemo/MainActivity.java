package co.nishchal.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        EditText text = findViewById(R.id.text);
        TextView view = findViewById(R.id.view);
        Button submit = findViewById(R.id.submit);
        Button fetch = findViewById(R.id.fetch);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        submit.setOnClickListener(v -> {
            ProgressDialog dialog = ProgressDialog.show(this, "", "Please wait...", true);
            Task<Void> task = myRef.setValue(text.getText().toString());
            task.addOnCompleteListener(command -> dialog.cancel());
            task.addOnCanceledListener(dialog::cancel);
        });

        fetch.setOnClickListener(v -> {
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot dataSnapshot) {
                    view.setText(dataSnapshot.getValue(String.class));
                }

                @Override
                public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}