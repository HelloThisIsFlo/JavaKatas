package BankKataJava.utils;

import BankKataJava.utils.Calendar;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

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