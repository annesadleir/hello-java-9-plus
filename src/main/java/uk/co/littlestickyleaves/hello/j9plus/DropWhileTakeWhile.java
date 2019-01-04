// $Id: $
package uk.co.littlestickyleaves.hello.j9plus;

import java.util.List;

/**
 * Examples of the new dropWhile and takeWhile functions on streams
 */
public class DropWhileTakeWhile {


    public static void main(String[] args) {
        DropWhileTakeWhile dropWhileTakeWhile = new DropWhileTakeWhile();
        dropWhileTakeWhile.go();
    }

    private void go() {
        List<RetailDay> retailDays = RetailDay.sampleRetailDays();
        System.out.println("Here are the starting values");
        retailDays.forEach(System.out::println);

        System.out.println("\nDrop values until there's a weekend day of 14 degrees or above");
        retailDays.stream()
                .dropWhile(retailDay -> retailDay.getTemperature() < 14 || !retailDay.weekend())
                .forEach(System.out::println);

        System.out.println("\nTake values while temperature is less than 14 degrees");
        retailDays.stream()
                .takeWhile(retailDay -> retailDay.getTemperature() < 14)
                .forEach(System.out::println);
    }








}
