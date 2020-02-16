package com.github.jiangxch.retrofitboot.test.autoconfigure;

import com.github.jiangxch.retrofitboot.test.autoconfigure.remote.service.GitHubService;
import com.github.jiangxch.retrofitboot.test.autoconfigure.remote.model.Repo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author: sanjin
 * @date: 2020/2/15 下午7:42
 */
@SpringBootApplication
public class AutoconfigureTest  implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(
                AutoconfigureTest.class,
                args
        );
    }

    @Autowired(required = false)
    private GitHubService gitHubService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("spring boot test");
        List<Repo> res = gitHubService.listReposWithRetrofitSpring("jiangxiaochuan");
        System.out.println(res);
    }
}
