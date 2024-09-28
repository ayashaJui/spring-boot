package com.example.tutorialApp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

//    define init method
//    @PostConstruct
//    public void doStartUpStuff(){
//        System.out.println("In DoStartUpStuff: " + getClass().getSimpleName());
//    }
//    define destroy method
//    @PreDestroy
//    public void doCleanUpStuff(){
//        System.out.println("In DoCleanUpStuff: " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Get daily workout fast bowling!!";
    }
}
