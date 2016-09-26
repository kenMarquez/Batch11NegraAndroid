package io.mariachi.artistsearchspotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.mariachi.artistsearchspotify.api.SpostifyArtistClient;
import io.mariachi.artistsearchspotify.models.Artist;
import io.mariachi.artistsearchspotify.models.Image;
import io.mariachi.artistsearchspotify.models.Item;
import io.mariachi.artistsearchspotify.models.RequestArtist;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView ivArtist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivArtist = (ImageView) findViewById(R.id.img_artist);


        getArtist("rodrigo rojas");

    }


    public void getArtist(final String artistName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        SpostifyArtistClient cliente = retrofit.create(SpostifyArtistClient.class);

        cliente.getArtist(artistName).enqueue(new Callback<RequestArtist>() {
            @Override
            public void onResponse(Call<RequestArtist> call, Response<RequestArtist> response) {
                //Obtienes el item root
                RequestArtist requestArtist = response.body();

                Artist artists = requestArtist.getArtists();

                List<Item> items = artists.getItems();

                Item item = items.get(0);

                List<Image> images = item.getImages();

                Image image = images.get(0);

                String url = image.getUrl();

                Log.d("myLog", url);
                Picasso.with(getApplicationContext()).load(url).into(ivArtist);
            }


            @Override
            public void onFailure(Call<RequestArtist> call, Throwable t) {
                Log.e("myLog", t.getMessage());
            }
        });

    }


}
