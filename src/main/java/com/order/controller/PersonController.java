package com.order.controller;

import com.microsoft.applicationinsights.TelemetryClient;
import com.order.model.Person;
import com.order.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController extends BaseController{

    @Autowired
    PersonService personService;

    @Autowired
    TelemetryClient telemetryClient;

    @GetMapping("/persons/all")
    public List<Person> getAllPersons() {

        telemetryClient.trackEvent("getAllPerson called");
        return personService.getAll();

    }

}
