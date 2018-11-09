package com.example.springbootasyn;

import com.example.springbootasyn.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Created by suneee on 2018/6/15.
 */
@Service
public class GitHubLookupService {

    private final static Logger log = LoggerFactory.getLogger(GitHubLookupService.class);

    private RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public Future<User> findUser(String user) throws  Exception {
        log.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<>(results);
    }
}
