package com.predictions.rollingwindow.gender.queue.impl;

import com.predictions.rollingwindow.gender.model.Gender;
import com.predictions.rollingwindow.gender.queue.Consumer;
import com.predictions.rollingwindow.gender.repository.GenderRepository;
import com.predictions.rollingwindow.gender.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;

public class KafkaConsumer implements Consumer {

    @Autowired
    GenderService genderService;

    @Override
    public void registerGender(String clientId, Gender gender) {
        genderService.registerGenderForClientId(clientId, gender);
    }
}
