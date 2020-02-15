package com.github.jiangxch.retrofitboot.test.autoconfigure.remote.service;

import com.github.sanjin.annotation.RetrofitConfig;
import com.github.jiangxch.retrofitboot.test.autoconfigure.remote.model.Repo;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


@RetrofitConfig("https://api.github.com")
public interface GitHubService {
  @GET("users/{user}/repos")
  List<Repo> listReposWithRetrofitSpring(@Path("user") String user);
}