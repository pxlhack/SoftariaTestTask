package ru.pxlhack;

import java.util.Map;
import java.util.Set;

public class MailCreator {

    private final DifferenceChecker differenceChecker;

    public MailCreator() {
        this.differenceChecker = new DifferenceChecker();
    }

    public String create(Map<String, String> todaysWebsiteState,
                         Map<String, String> yesterdaysWebsiteState) {
        UrlChanges changes = differenceChecker.getChanges(todaysWebsiteState, yesterdaysWebsiteState);

        return getMessage(changes);
    }

    private String getMessage(UrlChanges changes) {
        Set<String> disappearedPages = changes.getDisappearedPages();
        Set<String> newPages = changes.getNewPages();
        Set<String> changedPages = changes.getChangedPages();

        String disappearedPagesString = String.join(", ", disappearedPages);
        String newPagesString = String.join(", ", newPages);
        String changedPagesString = String.join(", ", changedPages);

        return String.format("Здравствуйте, дорогая и.о. секретаря\n" +
                        "\n" +
                        "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n" +
                        "\n" +
                        "Исчезли следующие страницы: %s\n" +
                        "Появились следующие новые страницы %s\n" +
                        "Изменились следующие страницы %s",
                disappearedPagesString,
                newPagesString,
                changedPagesString);
    }
}
