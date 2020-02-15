package com.github.jiangxch.test.retrofitspring;


import com.github.jiangxch.retrofitspring.convert.GsonConverterFactory;
import com.github.jiangxch.test.retrofitspring.remote.model.Repo;
import com.github.jiangxch.test.retrofitspring.remote.service.GitHubService;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * @author: sanjin
 * @date: 2020/2/13 上午10:56
 */
public class RetrofitSpringTest extends BaseTest {
    @Autowired(required = false)
    private GitHubService gitHubService;

    @Test
    public void testRetrofit2() throws IOException {
        Gson gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> res = service.listReposWithRetrofit2("octocat");
        Response<List<Repo>> execute = res.execute();
        System.out.println(execute.body());
    }

    @Test
    public void githubServiceTest() {
        System.out.println(gitHubService.listReposWithRetrofitSpring("octocat"));
    }
}
