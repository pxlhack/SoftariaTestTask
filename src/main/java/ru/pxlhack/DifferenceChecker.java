package ru.pxlhack;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DifferenceChecker {

    public UrlChanges getChanges(Map<String, String> todaysWebsiteState,
                                 Map<String, String> yesterdaysWebsiteState) {

        Set<String> disappearedPages = new HashSet<>();
        Set<String> newPages = new HashSet<>();
        Set<String> changedPages = new HashSet<>();


        return UrlChanges.builder()
                .disappearedPages(disappearedPages)
                .newPages(newPages)
                .changedPages(changedPages)
                .build();
    }

}
