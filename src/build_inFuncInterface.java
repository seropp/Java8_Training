
import test.People;

import java.util.Random;
import java.util.function.*;

public class build_inFuncInterface {

    public static void main(String[] args) {

    // ----------------------------------------------------------------------


        // 1. Predicate
        // Predicate<T> predicate = T x -> x==0;
        // В качестве T можем переавать все что угодно
        // Передаем 1 значение на выходе получаем boolean (проходит какая-то проверка)
        // МЕТОД: test()
        // Ex.:
        // Predicate<String> stringPredicate = a -> a.length() < 5;
        // System.out.println(stringPredicate.test("mother"));
        // Predicate<Integer[]> integerPredicate = a -> a.length%2==0;
        // System.out.println(integerPredicate.test(new Integer[4]));

    // ----------------------------------------------------------------------

        // 2. Consumer 
        // Принимает 1 значение <T> возвращает void
        // МЕТОД: accept()
        // Ex.:
        Consumer<Integer> integerConsumer = a -> {
            if (a > 4) System.out.println(a);
            else System.out.println(a * 100);
        };
        integerConsumer.accept(5);
        integerConsumer.accept(3);
        People p = new People(25, "Sergey", 1500, false);
        Consumer<People> peopleConsumer = a -> System.out.println(a.getName());
        peopleConsumer.accept(p);

    // ----------------------------------------------------------------------


        // 3. Function<T, R>
        // Осуществляет переход от типа T к типу R. При этом логику перехода пишем мы
        // МЕТОД: apply()
        // Ex.:
        // Integer -> String
        Function<Integer, String> integerStringFunction = a -> a + "";
        System.out.println(integerStringFunction.apply(233));
        // String -> Integer
        Function<String, Integer> stringIntegerFunction = a -> Integer.parseInt(a);
        // или же c сылкой на метод
        Function<String, Integer> stringIntegerFunction1 = Integer::parseInt;
        System.out.println(stringIntegerFunction.apply("34221") / 21);

    // ----------------------------------------------------------------------


        // 4. Supplier<T>
        // Supplier не принимает ни каких аргументов, но возвращает <T>
        // МЕТОД: get()
        // Ex.:
        Random random = new Random();
        int a = random.nextInt(4);
        Supplier<Integer> integerSupplier = () -> {
            if (a % 2 == 0) return a;
            return 123;
        };
        System.out.println(integerSupplier.get());

    // ----------------------------------------------------------------------

        // 5. UnaryOperator
        // помогает проводить унарныые операции над объектом T
        // МЕТОД: apply()
        // Ex.:
        UnaryOperator<Double> sqrt = Math::sqrt;
        // или UnaryOperator<Double> sqrt = a -> Math.sqrt(a);
        double x = sqrt.apply(324.2);

    // ----------------------------------------------------------------------


        // 6. BinaryOperator<T>
        // позволяет производить бинарные операции над t и u (2 параметра метода apply())
        // МЕТОД: apply()
        // Ex.:
        BinaryOperator<Double> pow = (z, y) -> Math.pow(z, y);
        // или через ссылку на метод BinaryOperator<Double> pow = Math::pow;
        System.out.println(pow.apply(34.0,54.0));
    }
}
