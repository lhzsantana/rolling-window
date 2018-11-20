package com.predictions.rollingwindow.gender.service;

import com.predictions.rollingwindow.gender.model.Gender;

public interface GenderService {

    public Gender getGenderForClientId(String clientId);

    public void registerGenderForClientId(String clientId, Gender gender);
}
