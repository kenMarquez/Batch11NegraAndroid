package io.mariachi.retrofitexample;

import io.mariachi.retrofitexample.models.Pokemon;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ken on 22/09/16.
 */

public interface GitHubService {

    @GET("users/{user}/repos")
    Call<ResponseBody> listRepos(@Path("user") String user);

    @GET("/api/v2/pokemon/{pokemonId}")
    Call<Pokemon> getPokemon(@Path("pokemonId") String id);



}
