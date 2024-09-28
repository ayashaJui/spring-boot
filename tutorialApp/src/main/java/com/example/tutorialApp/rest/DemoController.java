package com.example.tutorialApp.rest;

import com.example.tutorialApp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
//    private Coach anotherCoach;

    // constructor injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach coachName
//                          @Qualifier("cricketCoach") Coach anotherCoachName
    ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = coachName;
//        anotherCoach = anotherCoachName;
    }
//    public DemoController(@Qualifier("cricketCoach") Coach coachName) {
//        myCoach = coachName;
//    }

    // setter injection
//    @Autowired
//    public void setMyCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
//    }
}
