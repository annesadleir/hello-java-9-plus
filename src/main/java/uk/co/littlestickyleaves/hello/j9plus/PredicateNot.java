// $Id: $
package uk.co.littlestickyleaves.hello.j9plus;

import java.util.List;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

/**
 * TODO what it does
 * TODO what uses it
 *
 * @author RRushforth
 * @version $Id: $
 */
public class PredicateNot {

    public static void main(String[] args) {
        List<String> lines = List.of("Hello", "", "Dolly");

        // original
        // because it's a negative, the filter has to be a lambda not a method reference
        lines.stream()
                .filter(s -> !s.isBlank())
                .forEach(System.out::println);

        // new
        // the filter is a method reference wrapped in Predicate.not
        lines.stream()
                .filter(Predicate.not(String::isBlank))
                .forEach(System.out::println);

        // static import makes it more readable
        lines.stream()
                .filter(not(String::isBlank))
                .forEach(System.out::println);
    }

}
