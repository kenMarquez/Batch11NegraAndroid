package io.mariachi.artistsearchspotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.mariachi.artistsearchspotify.api.SpostifyArtistClient;
import io.mariachi.artistsearchspotify.models.RequestArtist;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getArtist("komander");
    }


    public void getArtist(String artistName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        SpostifyArtistClient cliente = retrofit.create(SpostifyArtistClient.class);

        cliente.getArtist(artistName).enqueue(new Callback<RequestArtist>() {
            @Override
            public void onResponse(Call<RequestArtist> call, Response<RequestArtist> response) {

            }

            @Override
            public void onFailure(Call<RequestArtist> call, Throwable t) {
                Log.e("myLog",t.getMessage());
            }
        });

    }


}
