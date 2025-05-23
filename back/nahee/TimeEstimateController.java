package com.example.routine;

import java.time.LocalTime;

public class TimeEstimateController {

    private TimeEstimator estimator;

    public TimeEstimateController(TimeEstimator estimator) {
        this.estimator = estimator;
    }

    public String predictEndTime(UserInputRequest request) {
        UserInput input = request.toUserInput();
        LocalTime predicted = estimator.predict(input);
        return predicted.toString();  // 예: "20:15"
    }
}

