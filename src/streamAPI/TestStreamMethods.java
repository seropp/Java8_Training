package streamAPI;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamMethods {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 23, 343, 2, 1, -345, 23, 345};
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(4);
        integerList.add(3);
        integerList.add(-3);
        integerList.add(-12);
        integerList.add(41);


// ---------------------------------------------------------------------------------------------------------------------
        // filter() distinct() toArray()
        // Fx.:


        System.out.println("\n\nМассив после обработки через filter() и distinct(). Создали новый массив через toArray() ");
        IntStream intStream = IntStream.of(arr);
        int[] newArr = intStream
                .filter(p -> p > 1)
                .distinct()
                .toArray();
        System.out.println("Полученный массив: "+ Arrays.toString(newArr));



// ---------------------------------------------------------------------------------------------------------------------
        // skip()  limit() collect(Collectors.toList())
        // Fx.:


        System.out.println("\n\nИспользуем skip() и limit() на исхоный массив");
        integerList.forEach(p-> System.out.print(p+" "));
        System.out.println("\nА также создадим из полученых эллементов коллекцию List.");
        List<Integer> newIntegerList = integerList.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Полученный List: ");
        newIntegerList.forEach(p-> System.out.print(p+" "));


// ---------------------------------------------------------------------------------------------------------------------
        // Исользуем  map() и peek()
        /*
        mapToInt, mapToDouble,mapToLong
        Аналоги map, но возвращает числовой стрим (то есть стрим из числовых примитивов)*/
        // peek() НЕ ИЗМЕНЯЕТ ОБЪЕКТ!!!!!!!!!!!!
        // Fx.:

        System.out.println("\n\n\nСозадим список из элементов String");
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("f1");
        stringArrayList.add("e-1");
        stringArrayList.add("g312");
        stringArrayList.add("t2");
        stringArrayList.add("j1");
        stringArrayList.forEach(p-> System.out.print(p+" "));
        System.out.println("""


                Попробуем устранить буквы в элементах и создать новый лист
                Используем map() и map() т.к. peek() не изменяет объект!!!""");

        List<Integer> newList1 = stringArrayList.stream()
                .map(p -> p.substring(1))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Получившийся список: ");
        newList1.forEach(p-> System.out.print(p+" "));
        System.out.println();

        System.out.println("""
                
                НО вот добовлять что-то во время печати с помощью peek() мы можем!
                Преобразуем элементы исходного списка в верхний регистр и добавим каждому \"*\"
                """);
        Object[] strings = stringArrayList.stream()
                .map(String::toUpperCase)
                .peek(p-> System.out.print(p+"*"+"_"))
                .toArray();
        System.out.println(Arrays.toString(strings));

// ---------------------------------------------------------------------------------------------------------------------
        // sorted peek
        System.out.println("""
                
                Создадим список на основе класса People из 6 элементов 
                попробуем отсортировать в разных вариантах
                1. По возрасту  для сортировки по числам достаточно отсортировать сам список, а не стрим 
               
                =>        peopleArrayList.sort(Comparator.comparingInt(People::getAge));
                ИЛИ через Lambda
                =>        peopleArrayList.sort(People a, People b) -> a.getAge() - b.getAge)
                  
                
                2. По Именам    Чтобы Отсортировать имена с разным регистром первой буквы, можем использовать peek()
                
                3. По полу
                
                4. По полу причем каждый пол тоже отсортирован по именам
                """);
       List<People> peopleArrayList = new ArrayList<>();
        peopleArrayList.add(new People("Вася", "MEN", 32));
        peopleArrayList.add(new People("Катя", "WOMEN", 44));
        peopleArrayList.add(new People("Михаил", "MEN", 19));
        peopleArrayList.add(new People("анастасия", "WOMEN", 29));
        peopleArrayList.add(new People("евгения", "WOMEN", 52));
        peopleArrayList.add(new People("Сергей", "MEN", 25));

        // ПО ИМЕНИ
        List<People> peopleList0 =
                peopleArrayList.stream()
                .peek(p -> p.setName(p.getName().substring(0,1).toUpperCase() + p.getName().substring(1).toLowerCase()))
                .sorted((o1,o2) -> +o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        peopleList0.forEach(p -> System.out.printf("\nИмя:%s Возраст%d", p.getName(), p.getAge() ));


        // ПО ВОЗРАСТУ
        peopleArrayList.sort(Comparator.comparingInt(People::getAge));
        peopleArrayList.forEach(p -> System.out.printf("\nИмя:%s Возраст%d", p.getName(), p.getAge() ));

        // СНАЧАЛА ПО ПОЛУ, ПОТОМ ПО ВОЗРАСТУ


        // Терминальные методы
        // findFirst() - Возвращает первый элемент из стрима (возвращает Optional)
        // findAny() - Возвращает любой подходящий элемент из стрима (возвращает Optional)
        // count() - Возвращает количество элементов в стриме
        // Полезнее для файлов
        // anyMatch() - Возвращает true, если условие выполняется хотя бы для одного элемента
        // noneMatch() - Возвращает true, если условие не выполняется ни для одного элемента
        // allMatch() - Возвращает true, если условие выполняется для всех элементов
        // min() - Возвращает минимальный элемент, в качестве условия использует компаратор
        // max() - Возвращает максимальный элемент, в качестве условия использует компаратор
        // reduce() - Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат



        // sum() - Возвращает сумму всех чисел
        // average() - Возвращает среднее арифметическое всех чисел
        // mapToObj() - Преобразует числовой стрим обратно в объектный

        long count = stringArrayList.stream()
                .filter(a -> a.length()< 4)
                .count();
        System.out.println("\ntest count "+count);

        long max = Arrays.stream(arr)
                .max().getAsInt();
        int min = Arrays.stream(arr)
                .min().getAsInt();

        System.out.println("\ntest max "+ max+"   min "+min);

        int sum = Arrays.stream(arr)
                .sum();
        System.out.println("\nsum " + sum);

    }

}
