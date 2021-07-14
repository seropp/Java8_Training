package test;

public class People {
    private int age;
    private String name;
    private int salary;
    private boolean married;

    public People(int Nage, String Nname, int Nsalary, boolean Nmarried) {
        age = Nage;
        name = Nname;
        salary = Nsalary;
        married = Nmarried;
    }
    public int cAge(){
            return age;
    }
    public boolean isMarried(){
        return married;
    }
    public String getName(){
        return name; 
    }
}
