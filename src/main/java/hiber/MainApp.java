package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

        Car car1 = new Car("Porsche", 212);
        Car car2 = new Car("Opel", 900);
        Car car3 = new Car("Honda", 1000);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(car1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setCar(car2);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setCar(car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car = " + user.getCar());
//            System.out.println();
//        }

        System.out.println(userService.getUserByCarModelAndSeries("Opel", 900));

        context.close();
    }
}
