package io.mariachi.artistsearchspotify.api;

import io.mariachi.artistsearchspotify.models.Artist;
import io.mariachi.artistsearchspotify.models.RequestArtist;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ken on 23/09/16.
 */

public interface SpostifyArtistClient {

//    @GET("/v1/search?type=ar&limit=5")
//    Call<ResponseBody> getArtist(@Query("q") String artistName);

    @GET("/v1/search?type=artist")
    Call<RequestArtist> getArtist(@Query("q") String artistName);



}
