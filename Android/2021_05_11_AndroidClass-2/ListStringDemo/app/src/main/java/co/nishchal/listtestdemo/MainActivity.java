package co.nishchal.listtestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] movieList = {"Shawshank Redeption", "Forrest Gump", "Saving Private Ryan", "Lord of the Rings trilogy",
                "Dark Knight trilogy", "Joker", "The Godfather", "Schindler's List", "Inception", "The Matrix",
                "The original Star Wars", "Goodfellas", "Interstellar", "The Prestige", "WALL.E", "Man of Steel",
                "Justice League: Snyder's cut", "Coco", "Toy Story series", "3 Idiots", "Inside Out", "Finding Nemo", "Mad Max series", "Drishyam"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.movie_layout, movieList);

        ListView listView = findViewById(R.id.movies_list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), movieList[position] + " tapped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}