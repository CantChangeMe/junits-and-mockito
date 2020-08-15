package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.contains;

public class HamcrestTest {
    @Test
    public void testHamCrestLibrary(){

        List<Integer> list = List.of(1,2,3);
       // assertThat(list, Matchers.contains(1,2,3));
        assertThat(list, Matchers.containsInAnyOrder(1,3,2));
    }

    @Test
    public void testOptionsForAllowToGetAllowedOperations(){
        RestTemplate restTemplate = new RestTemplate();
        Set<HttpMethod> methods = new LinkedHashSet<>();// = restTemplate.optionsForAllow("https://jsonplaceholder.typicode.com/posts");
        methods.add(HttpMethod.GET);
        methods.add(HttpMethod.POST);
        methods.add(HttpMethod.PUT);
        methods.add(HttpMethod.DELETE);
        System.out.println("vgfgf "+methods);
        HttpMethod[] supportedMethods
                = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        assertThat(methods,contains(supportedMethods));


    }
}
