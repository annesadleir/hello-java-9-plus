package uk.co.littlestickyleaves.hello.j9plus;

import java.util.List;
import java.util.Optional;

/**
 * Some new methods on Optional
 */
public class OptionalOr {

    public static final List<Optional<String>> stringOptionals = List.of(Optional.of("Hello"),
            Optional.empty(), Optional.of("Badger"), Optional.empty());

    public static int missingValueCount = 0;

    public static void main(String[] args) {
        OptionalOr optionalOr = new OptionalOr();
        optionalOr.demoIfPresentOrElse();
        optionalOr.demoOr();
        optionalOr.demoOptionalStream();
    }

    private void demoIfPresentOrElse() {
        missingValueCount = 0;
        stringOptionals.forEach(
                opt -> opt.ifPresentOrElse(
                        str -> System.out.println("There is a value: " + str),
                        () -> missingValueCount++));

        System.out.println("Handled " + missingValueCount + " missing values");

    }

    // .or()
    private void demoOr() {
        missingValueCount = 0;
        stringOptionals.stream()
                .map(
                        opt -> opt.or(() -> {
                            missingValueCount++;
                            return Optional.of("Default");
                        })
                )
                .map(optstr -> optstr.orElse("Impossible"))
                .forEach(System.out::println);

        System.out.println("Handled " + missingValueCount + " missing values");
    }

    // Optional.stream()
    // streamOfOptionals.filter(Optional::isPresent).map(Optional::get)
    // can become
    // streamofOptionals.flatMap(Optional::stream)
    private void demoOptionalStream() {
        // previously
        stringOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

        // now
        stringOptionals.stream()
                .flatMap(Optional::stream)
                .forEach(System.out::println);


    }
}
