package Test;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Animals> animals = new LinkedList<>();
        animals.add(new Animals(40, "Dima", 2670, true));
        animals.add(new Animals(24, "Sergey", 1670, false));
        animals.add(new Animals(10, "Alexandra", 870, false));
        animals.add(new Animals(33, "Kate", 1070, true));

        printE(animals, Animals::cAge);
    }

        private static void printE(LinkedList<Animals> x, ChekAge a){
            for (Animals ae : x) {
                if(a.checkAge(ae)){
                    System.out.println(ae.getName()+"   ");
                }
            }
        }


}
