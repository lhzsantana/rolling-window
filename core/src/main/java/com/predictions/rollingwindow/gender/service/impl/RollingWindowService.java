package com.predictions.rollingwindow.gender.service.impl;

import com.predictions.rollingwindow.gender.model.Gender;
import com.predictions.rollingwindow.gender.service.GenderService;
import org.springframework.stereotype.Service;

@Service
public class RollingWindowService  implements GenderService {

    @Override
    public Gender getGenderForClientId(String clientId) {
        return null;
    }

    @Override
    public void registerGenderForClientId(String clientId, Gender gender) {

    }
}
