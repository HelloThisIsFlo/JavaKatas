package katas.bank.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class CalendarTest {

    @Test
    public void todayAsString_returnsTheCurrentDateAsString() {
        LocalDate today = LocalDate.of(2020, 2, 12);

        Calendar calendar = newCalendarWithMockedDate(today);

        assertEquals("12/02/2020", calendar.todayAsString());
    }

    private Calendar newCalendarWithMockedDate(LocalDate today) {
        return new Calendar() {
            @Override
            LocalDate today() {
                return today;
            }
        };
    }
}