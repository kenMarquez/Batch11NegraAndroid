package io.mariachi.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.mariachi.retrofitexample.models.Pokemon;
import okhttp3.ResponseBody;
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
//        setupRetrofit();
        getPokemon();
    }

    private void setupRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GitHubService service = retrofit.create(GitHubService.class);

        service.listRepos("kenMarquez").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("myLog", "status: " + response.code());

                try {
                    String body = response.body().string();


                    JSONArray jsonArray = new JSONArray(body);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String id = jsonObject.getString("id");


//                    Log.i("myLog", jsonObject.toString(4));
                    Log.i("myLog", id);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void getPokemon() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GitHubService service = retrofit.create(GitHubService.class);

        service.getPokemon("1").enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();

                Log.i("myLog", pokemon.getName());
                Log.i("myLog", pokemon.getHeight() + "");
                Log.i("myLog", pokemon.getId() + "");
                Log.i("myLog", pokemon.getSpecies().getName());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("myLog", t.getMessage());
            }
        });


    }


}























