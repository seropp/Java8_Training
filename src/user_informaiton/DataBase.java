package user_informaiton;

@FunctionalInterface
public interface DataBase {
    User create(String name, String password);
}
