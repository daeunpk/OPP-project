package com.example.routine;

import java.util.List;
import java.util.Set;

public class RoutineController {

    private RoutineRecommender recommender;
    private RoutineSaver saver;

    public RoutineController(RoutineRecommender recommender, RoutineSaver saver) {
        this.recommender = recommender;
        this.saver = saver;
    }

    public RoutineResponse recommendRoutine(UserInputRequest request) {
        UserInput input = request.toUserInput();
        List<RoutineCard> routines = recommender.recommend(input);
        return new RoutineResponse(routines);
    }

    public RoutineResponse retryRoutine(RoutineRetryRequest retryRequest) {
        UserInput input = retryRequest.getUserInput().toUserInput();
        Set<String> exclude = retryRequest.getExcludeNames();
        List<RoutineCard> filtered = recommender.retryRecommend(input, exclude);
        return new RoutineResponse(filtered);
    }

    public String saveRoutine(RoutineSaveRequest request) {
        FinalRoutine routine = request.toFinalRoutine();
        saver.save(routine);
        return "저장 완료!";
    }
}

