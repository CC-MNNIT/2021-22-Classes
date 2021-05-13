package co.nishchal.jsondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LruCache;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textview.MaterialTextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameEditText = findViewById(R.id.username);
        Button fetchBtn = findViewById(R.id.fetchBtn);
        MaterialTextView nameTxt = findViewById(R.id.name);
        NetworkImageView pfpImage = findViewById(R.id.pfp);

        fetchBtn.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://api.github.com/users/" + username;

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    response -> {
                        try {
                            JSONObject user = new JSONObject(response);
                            String fullName = user.getString("name");
                            nameTxt.setText(fullName);
                            pfpImage.setImageUrl(user.getString("avatar_url"), new ImageLoader(queue, new ImageLoader.ImageCache() {
                                private final LruCache<String, Bitmap> mCache = new LruCache<>(10);

                                @Override
                                public Bitmap getBitmap(String url1) {
                                    return mCache.get(url1);
                                }

                                @Override
                                public void putBitmap(String url1, Bitmap bitmap) {
                                    mCache.put(url1, bitmap);
                                }
                            }));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }, error -> Toast.makeText(getApplicationContext(), "That didn't work!", Toast.LENGTH_SHORT).show());

            queue.add(stringRequest);

        });
    }
}