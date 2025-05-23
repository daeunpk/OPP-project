package com.example.routine;

import java.util.Set;

public class RoutineRetryRequest {

    private UserInputRequest userInput;
    private Set<String> excludeNames;

    public RoutineRetryRequest(UserInputRequest userInput, Set<String> excludeNames) {
        this.userInput = userInput;
        this.excludeNames = excludeNames;
    }

    public UserInputRequest getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInputRequest userInput) {
        this.userInput = userInput;
    }

    public Set<String> getExcludeNames() {
        return excludeNames;
    }

    public void setExcludeNames(Set<String> excludeNames) {
        this.excludeNames = excludeNames;
    }
}

