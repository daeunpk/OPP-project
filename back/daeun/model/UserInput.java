package model;

import model.Mood;
import model.Energy;

public class UserInput {
    public Mood mood;
    public Energy energy;
    public boolean wantPeople;
    public boolean autoEstimate;
    public int taskCount;
    public int taskIntensity;
    public int meetingCount;
    public int bossMood;
    public String manualEndTime;

    public UserInput(Mood mood, Energy energy, boolean wantPeople, boolean autoEstimate) {
        this.mood = mood;
        this.energy = energy;
        this.wantPeople = wantPeople;
        this.autoEstimate = autoEstimate;
    }
}
