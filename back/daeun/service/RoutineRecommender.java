package service;

import data.FakeDatabase;
import model.*;
import java.util.*;

public class RoutineRecommender {
    public static List<RoutineCard> recommend(UserInput input) {
        List<RoutineCard> all = FakeDatabase.getAllRoutines();
        List<RoutineCard> result = new ArrayList<>();

        if (!input.wantPeople) result.add(all.get(0));
        else if (input.energy == Energy.HIGH) result.add(all.get(2));
        else result.add(all.get(1));

        while (result.size() < 3) {
            RoutineCard r = all.get(new Random().nextInt(all.size()));
            if (!result.contains(r)) result.add(r);
        }
        return result;
    }

    public static RoutineCard randomRoutine() {
        List<RoutineCard> list = FakeDatabase.getAllRoutines();
        return list.get(new Random().nextInt(list.size()));
    }

    public static List<RoutineDetail> getDetails() {
        return FakeDatabase.getRoutineDetails();
    }
}