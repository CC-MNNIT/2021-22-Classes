package co.nishchal.listadaptertestdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    ArrayList<Movie> movieArrayList;
    Context context;

    MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public int getCount() {
        return movieArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.movie_layout, parent, false);
        }

        // get current movie to be displayed
        Movie currentItem = (Movie) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = convertView.findViewById(R.id.movie_name);
        TextView textViewItemDescription = convertView.findViewById(R.id.movie_rank);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getName());
        textViewItemDescription.setText(currentItem.getRank() + "");

        MaterialCardView movieCardView = convertView.findViewById(R.id.movie_card);
        movieCardView.setOnClickListener(v -> {
            Toast.makeText(context, movieArrayList.get(position).getName() + " tapped", Toast.LENGTH_LONG).show();
        });

        // returns the view for the current row
        return convertView;
    }
}
