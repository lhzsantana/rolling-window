package com.predictions.rollingwindow.gender.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.context.annotation.Bean;

public class SparkConfig {

    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf();
        sparkConf.set("spark.app.name", "SparkReceiver"); //The name of application. This will appear in the UI and in log data.
        //conf.set("spark.ui.port", "7077");    //Port for application's dashboard, which shows memory and workload data.
        sparkConf.set("dynamicAllocation.enabled","false");  //Which scales the number of executors registered with this application up and down based on the workload
        //conf.set("spark.cassandra.connection.host", "localhost"); //Cassandra Host Adddress/IP
        sparkConf.set("spark.serializer","org.apache.spark.serializer.KryoSerializer");  //For serializing objects that will be sent over the network or need to be cached in serialized form.
        sparkConf.set("spark.driver.allowMultipleContexts", "true");
        sparkConf.setMaster("local[4]");

        return sparkConf;
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    public JavaStreamingContext javaStreamingContext(){
        return new JavaStreamingContext(sparkConf(), new Duration(2000));
    }
}
