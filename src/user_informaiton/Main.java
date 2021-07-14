package user_informaiton;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = User::new;
        User user1 = dataBase.create("Dan", "1231222");
        System.out.printf("Name: %s%nPassword %s" , user1.getName(), user1.getPassword());
    }
}
