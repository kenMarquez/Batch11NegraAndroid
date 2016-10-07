package ken.mx.spotifyplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import ken.mx.spotifyplayer.api.SpotifyApi;
import ken.mx.spotifyplayer.models.Track;
import ken.mx.spotifyplayer.models.spotify.Item;
import ken.mx.spotifyplayer.models.spotify.Tracks;
import ken.mx.spotifyplayer.models.spotify.TracksResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRecyclerView;
    private List<Track> trackList = new ArrayList<>();
    private EditText inputSearch;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        inputSearch = (EditText) findViewById(R.id.input_search);
        btnSearch = (Button) findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String query = inputSearch.getText().toString();
                if (query != null && !query.isEmpty()) {
                    getTracks(query);
                }

            }
        });
    }

    private void settingRecyclerView(List<Item> items) {

        //configuraciones del recyclerview
        rvRecyclerView = (RecyclerView) findViewById(R.id.rv_tracks);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvRecyclerView.setHasFixedSize(true);


        TrackAdapter trackAdapter = new TrackAdapter(items, this);
        rvRecyclerView.setAdapter(trackAdapter);


    }

    public void getTracks(String query) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com");

        Retrofit retrofit = builder
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpotifyApi service = retrofit.create(SpotifyApi.class);

        service.getTracks(query).enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
//                TracksResponse tracksResponse = response.body();
//                Tracks tracks = tracksResponse.getTracks();
//                List<Item> items1 = tracks.getItems();

                List<Item> items = response.body().getTracks().getItems();

                settingRecyclerView(items);
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                Log.i("myLog", t.getMessage());
            }
        });


    }
}
