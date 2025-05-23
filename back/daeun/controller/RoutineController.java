package controller;

import model.*;
import service.RoutineRecommender;
import service.RoutineSaver;

import java.util.List;
import java.util.Map;

public class RoutineController {
    public static List<RoutineCard> recommend(UserInput input) {
        return RoutineRecommender.recommend(input);
    }

    public static void saveFinalRoutine(RoutineCard selected, Map<String, String> details) {
        RoutineSaver.save(selected, details);
    }
}