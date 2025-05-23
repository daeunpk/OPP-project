package com.example.routine;

import java.util.List;

public class RoutineResponse {

    private List<RoutineCard> routines;

    public RoutineResponse(List<RoutineCard> routines) {
        this.routines = routines;
    }

    public List<RoutineCard> getRoutines() {
        return routines;
    }

    public void setRoutines(List<RoutineCard> routines) {
        this.routines = routines;
    }
}

