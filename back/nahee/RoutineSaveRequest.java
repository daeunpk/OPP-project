package com.example.routine;

import java.util.List;

public class RoutineSaveRequest {

    private String date;
    private RoutineCard routineCard;
    private List<String> selectedItems;

    public RoutineSaveRequest(String date, RoutineCard routineCard, List<String> selectedItems) {
        this.date = date;
        this.routineCard = routineCard;
        this.selectedItems = selectedItems;
    }

    public FinalRoutine toFinalRoutine() {
        return new FinalRoutine(date, routineCard, selectedItems);
    }

    public String getDate() {
        return date;
    }

    public RoutineCard getRoutineCard() {
        return routineCard;
    }

    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRoutineCard(RoutineCard routineCard) {
        this.routineCard = routineCard;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }
}

