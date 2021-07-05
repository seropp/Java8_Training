package lambda;

import helper.HelpClass;

import java.util.Random;

public class LambdaIntro {
    public static void main(String[] args) {

        // №1
        // Примеры лямбда выражений

        ISum s = (a, b) -> a+b;
        ISum x = (a, b) -> a-b;


        // №2
        // Также в лямда мы можем помещать "Многострочную логику"
        // однако Мы должны будем использовать {} и return
        // For example:

        ISum three = (a, b) -> {
            if (a == 0) return 0;
            return a*b;
        };
//        System.out.println(three.sum(3,3));

        // №3
        // мы можем указать типы a и b
        // ISum three = (int a, int b) -> (a+b-10);
        // Но тогда должны указыать у КАДОГО входящего агрумента

        // №4
        // Лямбда с передачей одного аргумента
        // скобки (а) не обязательны
        // Когда мы имеем ело с 1 аргументом и хотим использовать стат метод другого класса, мы можем
        // использовать ::    (что является ссылкой на метод)
        // йэто будет интерпретироваться компилятором, а не JVM во время выполнения
        // for example
        ISqrt sqrt0 = a -> Math.sqrt(a);
        ISqrt sqrt = Math::sqrt;
        ISqrt sqrt1 = (a) -> Math.pow(a, 3);
        //Test
        // В другом пакете лежит класс HelpClass, который содержит метод helper
        // этот метод является статическим и публичным
        // принимает int и возвращает int (x*10), как и ФУНКЦИОНАЛЬНЫЙ интерфейс Mult с методом
        // multiplication.  Прописываем логику лямбда (наследуется от Mult и имеет ссылку на статич метод)
        // с аналогичным интерфейсу возвр и приним типами
        // далее получаем число  через объект, который только что создали
        Mult mult = HelpClass::help;
        System.out.println(mult.multiplication(5));
    }

    Random x = new Random();

    @FunctionalInterface
    public interface ISum {         // Функциональный интерфейс
        public int sum(int a, int b);           // Один не реализованный метод

    }
    @FunctionalInterface
    public interface ISqrt {         // Функциональный интерфейс
        public double sum(double a);           // Один не реализованный метод
    }
    @FunctionalInterface
    public interface Mult {
        public int multiplication(int a);
    }

}

