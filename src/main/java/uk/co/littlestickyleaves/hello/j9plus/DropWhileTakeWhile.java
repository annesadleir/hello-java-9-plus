// $Id: $
package uk.co.littlestickyleaves.hello.j9plus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO what it does
 * TODO what uses it
 *
 * @author RRushforth
 * @version $Id: $
 */
public class DropWhileTakeWhile {

    private static final LocalDate START = LocalDate.of(2018, Month.NOVEMBER, 10);

    public static void main(String[] args) {
        DropWhileTakeWhile dropWhileTakeWhile = new DropWhileTakeWhile();
        dropWhileTakeWhile.go();
    }

    private void go() {
        List<RetailDay> retailDays = RetailDay.sampleRetailDays();

        System.out.println("Drop values until there's a weekend day of 14 degrees or above");
        retailDays.stream()
                .dropWhile(retailDay -> retailDay.getTemperature() < 14 || !retailDay.weekend())
                .forEach(System.out::println);

        System.out.println("\nTake values while temperature is less than 14 degrees");
        retailDays.stream()
                .takeWhile(retailDay -> retailDay.getTemperature() < 14)
                .forEach(System.out::println);
    }








}
