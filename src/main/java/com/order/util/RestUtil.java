package com.order.util;

import org.slf4j.MDC;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestUtil {

    RestTemplate restTemplate;


    public RestUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String makeHttpCall(String url) {
        ResponseEntity<String> response = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("trackingId", MDC.get("trackingId"));
        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }


}
