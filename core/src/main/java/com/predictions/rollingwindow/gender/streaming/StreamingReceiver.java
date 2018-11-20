package com.predictions.rollingwindow.gender.streaming;

import com.predictions.rollingwindow.gender.repository.GenderRepository;
import jdk.incubator.http.internal.frame.DataFrame;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.beans.factory.annotation.Autowired;

public class StreamingReceiver {

    @Autowired
    JavaStreamingContext jssc;

    @Autowired
    GenderRepository genderRepository;

    public void receiver() throws InterruptedException {

        JavaReceiverInputDStream<String> genders = jssc.socketTextStream("localhost", 9999);

        genders.foreachRDD( rdd -> {
            genderRepository.registerTopGender(null);
        });

        jssc.start();
        jssc.awaitTermination();
    }
}
