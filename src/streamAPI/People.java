package streamAPI;

public class People {
    private String name;
    private String sex;
    private Integer age;

    public People(String name, String sex, Integer age) {
        this.name = name;
        this.age = age;
        this.sex = sex;

    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

