package com.github.jiangxch.test.retrofitspring.remote.service;

import com.github.jiangxch.retrofitspring.annotation.RetrofitConfig;
import com.github.jiangxch.test.retrofitspring.remote.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

@RetrofitConfig("https://api.github.com")
public interface GitHubService {
  @GET("users/{user}/repos")
  List<Repo> listReposWithRetrofitSpring(@Path("user") String user);

  @GET("users/{user}/repos")
  Call<List<Repo>> listReposWithRetrofit2(@Path("user") String user);
}