package com.predictions.rollingwindow.gender.queue;

import com.predictions.rollingwindow.gender.model.Gender;

public interface Consumer {

    public void registerGender(String clientId, Gender gender);
}
