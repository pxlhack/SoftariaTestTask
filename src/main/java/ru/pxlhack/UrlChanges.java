package ru.pxlhack;

import java.util.Set;

public class UrlChanges {
    private Set<String> disappearedPages;
    private Set<String> newPages;
    private Set<String> changedPages;

    public UrlChanges(Set<String> disappearedPages, Set<String> newPages, Set<String> changedPages) {
        this.disappearedPages = disappearedPages;
        this.newPages = newPages;
        this.changedPages = changedPages;
    }

    public Set<String> getDisappearedPages() {
        return disappearedPages;
    }

    public Set<String> getNewPages() {
        return newPages;
    }

    public Set<String> getChangedPages() {
        return changedPages;
    }
}
