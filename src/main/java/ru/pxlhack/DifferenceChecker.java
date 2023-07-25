package ru.pxlhack;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DifferenceChecker {

    public UrlChanges getChanges(Map<String, String> todaysWebsiteState,
                                 Map<String, String> yesterdaysWebsiteState) {

        Set<String> disappearedPages = findDisappearedPages(todaysWebsiteState, yesterdaysWebsiteState);
        Set<String> newPages = findNewPages(yesterdaysWebsiteState, todaysWebsiteState);
        Set<String> changedPages = findChangedPages(todaysWebsiteState, yesterdaysWebsiteState);

        return UrlChanges.builder()
                .disappearedPages(disappearedPages)
                .newPages(newPages)
                .changedPages(changedPages)
                .build();
    }

    public static Set<String> findDisappearedPages(Map<String, String> todaysWebsiteState,
                                                   Map<String, String> yesterdaysWebsiteState) {
        return findKeysMissingInSecondMap(todaysWebsiteState, yesterdaysWebsiteState);
    }

    public static Set<String> findNewPages(Map<String, String> todaysWebsiteState,
                                           Map<String, String> yesterdaysWebsiteState) {
        return findKeysMissingInSecondMap(yesterdaysWebsiteState, todaysWebsiteState);
    }

    public static Set<String> findKeysMissingInSecondMap(Map<String, String> map1, Map<String, String> map2) {
        Set<String> missingKeys = new HashSet<>();

        for (String key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                missingKeys.add(key);
            }
        }

        return missingKeys;
    }

    public static Set<String> findChangedPages(Map<String, String> todaysWebsiteState,
                                               Map<String, String> yesterdaysWebsiteState) {

        Set<String> changedPagesKeys = new HashSet<>();

        for (String key : todaysWebsiteState.keySet()) {
            if (yesterdaysWebsiteState.containsKey(key) && !todaysWebsiteState.get(key).equals(yesterdaysWebsiteState.get(key))) {
                changedPagesKeys.add(key);
            }
        }

        return changedPagesKeys;
    }

}
