package com.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.exception.APINotRespondingException;
import com.order.exception.InvalidResponseException;
import com.order.exception.NoDataFoundException;
import com.order.model.Person;
import com.order.util.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonServiceImpl implements PersonService {


    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    RestUtil restUtil;

    @Autowired
    ObjectMapper objectMapper;

    @Value("${personurl}")
    String personUrl;

    @Override
    public List<Person> getAll() {

        List<Person> people = fetchRecords();
        if (people.size() < 5 && people.size() > 2) {
            logger.info("fetched from db" + people);
            throw new NoDataFoundException("Size is lt 5 & gt 2 "+people.size()+"");
        }
        //logging to trackException
        if(people.size() >= 5 && people.size() < 8){
            logger.error("throwing API Exception");
            throw new APINotRespondingException("size is gt 5 & lt 8"+people.size());
        }
        return people;
    }

    private int getRandomCount(int bound) {
        Random random = new Random();
        return random.nextInt(bound);

    }


    private List<Person> fetchRecords() {
        List<Person> personList;
        String response = restUtil.makeHttpCall(personUrl);
        try {
            Person[] people = objectMapper.readValue(response, Person[].class);
            personList = Arrays.asList(people);
        } catch (JsonProcessingException e) {
            throw new InvalidResponseException("Json received is invalid");
        }
        return personList;
    }


}
