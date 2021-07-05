package Test;

public class Animals {
    private int age;
    private String name;
    private int salary;
    private boolean married;

    public Animals(int Nage, String Nname, int Nsalary, boolean Nmarried) {
        age = Nage;
        name = Nname;
        salary = Nsalary;
        married = Nmarried;
    }
    public boolean cAge(){
            return age>20;
    }
    public boolean isMarried(){
        return married;
    }
    public String getName(){
        return name; 
    }
}
