package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);



      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("Toyota Corolla", 123));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Range Rover", 465));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("BMW X6", 789));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Kia Rio", 147));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println();
      }

      User findUserByCar = userService.findUserByCar(new Car("Toyota Corolla", 123));
      System.out.println("Id = "+findUserByCar.getId());
      System.out.println("First Name = "+findUserByCar.getFirstName());
      System.out.println("Last Name = "+findUserByCar.getLastName());
      System.out.println("Email = "+findUserByCar.getEmail());
      System.out.println("Car model = "+findUserByCar.getCar().getModel());
      System.out.println("Car series = "+findUserByCar.getCar().getSeries());
      System.out.println();

      context.close();
   }
}
