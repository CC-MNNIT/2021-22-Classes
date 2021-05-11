package co.nishchal.listadaptertestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] movieList = {"Shawshank Redeption", "Forrest Gump", "Saving Private Ryan", "Lord of the Rings trilogy",
                "Dark Knight trilogy", "Joker", "The Godfather", "Schindler's List", "Inception", "The Matrix",
                "The original Star Wars", "Goodfellas", "Interstellar", "The Prestige", "WALL.E", "Man of Steel",
                "Justice League: Snyder's cut", "Coco", "Toy Story series", "3 Idiots", "Inside Out", "Finding Nemo",
                "Mad Max series", "Drishyam"};
        ArrayList<Movie> list = new ArrayList<>(movieList.length);
        for(int i = 0; i < movieList.length; ++i) {
            list.add(new Movie(movieList[i], i + 1));
        }

        MovieAdapter movieAdapter = new MovieAdapter(this, list);

        ListView listView = findViewById(R.id.movies_list);
        listView.setAdapter(movieAdapter);
    }
}