package ru.pxlhack;

import java.util.Map;

public class MailCreator {

    private final DifferenceChecker differenceChecker;

    public MailCreator() {
        this.differenceChecker = new DifferenceChecker();
    }

    public String create(Map<String, String> todaysWebsiteState,
                         Map<String, String> yesterdaysWebsiteState) {
        UrlChanges changes = differenceChecker.getChanges(todaysWebsiteState, yesterdaysWebsiteState);

        return null;
    }
}
