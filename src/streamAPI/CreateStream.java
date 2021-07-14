package streamAPI;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) throws IOException {

        // Stream из колекции
        // collection.stream
        // Fx.:

        Collection<String> collection1 = Arrays.asList("Tim", "Hanna", "Anastasia", "Dmitriy", "Sergey", "Alex");
        Stream<String> stream1 = collection1.stream();

        stream1
                .filter(a -> a.length() < 5)
                .forEach(System.out::println);

        // -------------------------------------------------------------------------------------------------------------

        // Stream из значений (Integer, String, Double и др.)
        // Stream.of(знач1, ..., значN)
        // Метод of возвр. Arrays.stream()
        // Fx.:

        Stream<Integer> intStream1 = Stream.of(1, 2, 3, 4);
        intStream1
                .filter(a -> a%2!=0)
                .forEach(System.out::println);

        // -------------------------------------------------------------------------------------------------------------

        // Arrays.stream(array)
        // Fx.:

        String[] arrayStr = new String[]{"12", "ASease", "Aawwf", "geee"};
        Stream<String> stream2 = Arrays.stream(arrayStr);
        stream2.filter(a -> a.indexOf('e') > 0)
                .forEach(System.out::println);

        // -------------------------------------------------------------------------------------------------------------

        // Files.steam(путь к файлу)
        // В файле каждая строка будет отдельым элементом
        // Fx.:

        Stream<String> stream3 = Files.lines(Paths.get("A:\\Java books\\111.txt"));
        stream3.forEach(System.out::println);

        // -------------------------------------------------------------------------------------------------------------

        // Еще раз про Stream.of()
        // Можно использовать IntStream, DoubleStream и тд.
        // Fx.:

        IntStream intStream2 = IntStream.of(1, 2,32, -312, -7);

        // -------------------------------------------------------------------------------------------------------------

        // Создание паралельного стрма
        // collection.parallelStream()
        // Fx.:

        Stream<String> stream4 = collection1.parallelStream();

        // -------------------------------------------------------------------------------------------------------------

        // Бесконечный стрим с помощью Stream.iterate
        //  Stream.iterate(выражение генерации)
        // Fx.:

        Stream<Integer> integerStream = Stream.iterate(1, a -> a++);
    }
}
