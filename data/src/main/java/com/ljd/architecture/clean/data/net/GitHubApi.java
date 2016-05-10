package com.ljd.architecture.clean.data.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ljd on 5/4/16.
 */
public interface GitHubApi {

    @GET("repos/{owner}/{repo}/contributors")
    Observable<ResponseBody> contributors(@Path("owner") String owner,
                                          @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/contributors")
    Call<ResponseBody> contributorsCall(@Path("owner") String owner,
                                    @Path("repo") String repo);
}
