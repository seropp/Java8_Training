package test;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<People> animals = new LinkedList<>();
        animals.add(new People(40, "Dima", 2670, true));
        animals.add(new People(24, "Sergey", 1670, false));
        animals.add(new People(10, "Alexandra", 870, false));
        animals.add(new People(30, "Kate", 1070, true));

//        printE(animals,People::cAge);
        printE(animals, People::getName, People::cAge);
    }

        private static void printE(LinkedList<People> x, NamesCheck namesCheck, ChekAge chekAge){
            for (People ae : x) {
                if((namesCheck.nameChecking(ae).length() < 5) && (chekAge.checkAge(ae) > 30)){
                    System.out.println(ae.getName()+"   ");
                }
            }
        }


}
@FunctionalInterface
interface ChekAge {
    int checkAge(People p);
}

@FunctionalInterface
interface NamesCheck {
    String nameChecking(People p);
}
