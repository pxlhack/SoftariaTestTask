package ru.pxlhack;

import java.util.HashSet;
import java.util.Set;

public class UrlChanges {
    private Set<String> disappearedPages;
    private Set<String> newPages;
    private Set<String> changedPages;

    public UrlChanges(Set<String> disappearedPages, Set<String> newPages, Set<String> changedPages) {
        this.disappearedPages = new HashSet<>(disappearedPages);
        this.newPages = new HashSet<>(newPages);
        this.changedPages = new HashSet<>(changedPages);
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

    public static UrlChangesBuilder builder() {
        return new UrlChangesBuilder();
    }

    public static class UrlChangesBuilder {
        Set<String> disappearedPages;
        Set<String> newPages;
        Set<String> changedPages;

        UrlChangesBuilder() {
        }

        public UrlChangesBuilder disappearedPages(Set<String> disappearedPages) {
            this.disappearedPages = disappearedPages;
            return this;
        }

        public UrlChangesBuilder newPages(Set<String> newPages) {
            this.newPages = newPages;
            return this;
        }

        public UrlChangesBuilder changedPages(Set<String> changedPages) {
            this.changedPages = changedPages;
            return this;
        }


        public UrlChanges build() {
            return new UrlChanges(disappearedPages, newPages, changedPages);
        }
    }
}
