package com.predictions.rollingwindow.gender.repository;

import com.predictions.rollingwindow.gender.model.Gender;

public interface GenderRepository {

    public void registerTopGender(Gender gender);

    public void registerLatestGender(String clientId, Gender gender);
}
