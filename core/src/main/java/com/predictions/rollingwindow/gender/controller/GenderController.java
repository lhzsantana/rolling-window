package com.predictions.rollingwindow.gender.controller;

import com.predictions.rollingwindow.gender.model.Gender;
import com.predictions.rollingwindow.gender.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderController {

    @Autowired
    GenderService genderService;

    @RequestMapping("/genders")
    public Gender getGender(String clientId){
        return genderService.getGenderForClientId(clientId);
    }
}
