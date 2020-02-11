package BankKataJava.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calendar {

    private static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    public String todayAsString() {
        return DD_MM_YYYY.format(today());
    }

    LocalDate today() {
        return LocalDate.now();
    }
}
