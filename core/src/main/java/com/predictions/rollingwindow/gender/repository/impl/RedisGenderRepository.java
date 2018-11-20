package com.predictions.rollingwindow.gender.repository.impl;

import com.predictions.rollingwindow.gender.model.Gender;
import com.predictions.rollingwindow.gender.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisGenderRepository implements GenderRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    ValueOperations<String, Object> ops = redisTemplate.opsForValue();

    @Override
    public void registerTopGender(Gender gender) {
        ops.increment(gender.getName(), 1);
    }

    @Override
    public void registerLatestGender(String clientId, Gender gender) {
        ops.set(clientId, gender.getName());
    }
}
