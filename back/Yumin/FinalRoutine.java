import java.util.Map;

public class FinalRoutine {
    private String date;
    private RoutineCard routine;
    private Map<String, String> selectedDetails;

    public FinalRoutine() {}

    public FinalRoutine(String date, RoutineCard routine, Map<String, String> selectedDetails) {
        this.date = date;
        this.routine = routine;
        this.selectedDetails = selectedDetails;
    }

    public String getDate() { return date; }
    public RoutineCard getRoutine() { return routine; }
    public Map<String, String> getSelectedDetails() { return selectedDetails; }

    public void setDate(String date) { this.date = date; }
    public void setRoutine(RoutineCard routine) { this.routine = routine; }
    public void setSelectedDetails(Map<String, String> selectedDetails) { this.selectedDetails = selectedDetails; }
}
