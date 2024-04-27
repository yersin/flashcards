package kz.yersin.flashcards.infrastructure.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Locale;
import java.util.Objects;

public class PresentationUtils {

    public static final PresentationUtils INSTANCE = new PresentationUtils();

    private static final String RESTRICTED_STRING_TAIL = "...";

    public String defaultString(String... strings) {
        for (String str : strings) {
            if (Objects.nonNull(str)) {
                return str;
            }
        }
        return null;
    }

    @SuppressWarnings(value = "unused")
    public String restrictStringLength(String s, int n) {
        if (Objects.isNull(s)) {
            return null;
        }

        if (s.length() > n) {
            return s.substring(0, n - RESTRICTED_STRING_TAIL.length()) + RESTRICTED_STRING_TAIL;
        } else {
            return s;
        }
    }

    @SuppressWarnings(value = "unused")
    public String temporalFormat(final Temporal temporal, final String pattern) {
        var formatter = DateTimeFormatter.ofPattern(pattern, Locale.ROOT);
        return formatter.format(temporal);
    }

    public LocalDateTime localDateTimeNow() {
        return LocalDateTime.now();
    }
}
