// $Id: $
package uk.co.littlestickyleaves.hello.j9plus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * TODO what it does
 * TODO what uses it
 *
 * @author RRushforth
 * @version $Id: $
 */
public class RetailDay {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("EEE dd-MM-yy");

        private LocalDate date;
        private int temperature;
        private double sales;

        public RetailDay(LocalDate date, int temperature, double sales) {
            this.date = date;
            this.temperature = temperature;
            this.sales = sales;
        }

        public LocalDate getDate() {
            return date;
        }

        public int getTemperature() {
            return temperature;
        }

        public double getSales() {
            return sales;
        }

    public boolean weekend() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY);
    }

    @Override
    public String toString() {
        return DATE_TIME_FORMATTER.format(date) +
                ", " + temperature + " degC, " + sales + "m";
    }

    public static List<RetailDay> sampleRetailDays() {
            LocalDate localDate = LocalDate.of(2018, Month.FEBRUARY, 10);
            return List.of(
                    new RetailDay(localDate, 10, 1.3),
                    new RetailDay(localDate.plusDays(1), 10, 1.5),
                    new RetailDay(localDate.plusDays(2), 11, 1.4),
                    new RetailDay(localDate.plusDays(3), 12, 1.3),
                    new RetailDay(localDate.plusDays(4), 11, 1.1),
                    new RetailDay(localDate.plusDays(5), 14, 1.0),
                    new RetailDay(localDate.plusDays(6), 14, 1.3),
                    new RetailDay(localDate.plusDays(7), 15, 1.8),
                    new RetailDay(localDate.plusDays(8), 13, 1.5),
                    new RetailDay(localDate.plusDays(9), 11, 1.7)
            );
        }


}
