package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;


public class Main {
    //public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//        User user1 = new User("Ivan", "Ivanov", (byte) 30);
//        User user2 = new User("Semen", "Semenov", (byte) 34);
//        User user3 = new User("Maria", "Voronova", (byte) 23);
//        User user4 = new User("Victor", "Sidorov", (byte) 42);
//
//        userService.createUsersTable();//создаем таблицу
//        System.out.println("В базу данных добавлены следующие пользователи: ");
//        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//        System.out.println(user1.getName() + " добавлен(а) в БД");
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//        System.out.println(user2.getName() + " добавлен(а) БД");
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
//        System.out.println(user3.getName() + " добавлен(а) БД");
//        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
//        System.out.println(user4.getName() + "добавлен(а) БД");
//        System.out.println();
//        System.out.println("Список всех пользователей: ");
//        List<User> allUsers = userService.getAllUsers();
//        allUsers.forEach(System.out::println);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        User user1 = new User("Ivan", "Ivanov", (byte) 30);
        User user2 = new User("Semen", "Semenov", (byte) 34);
        User user3 = new User("Maria", "Voronova", (byte) 23);
        User user4 = new User("Victor", "Sidorov", (byte) 42);

        userService.createUsersTable();//создаем таблицу
        System.out.println("В базу данных добавлены следующие пользователи: ");
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println(user1.getName() + " добавлен(а) в БД");
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println(user2.getName() + " добавлен(а) БД");
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println(user3.getName() + " добавлен(а) БД");
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println(user4.getName() + "добавлен(а) БД");
        System.out.println();
        System.out.println("Список всех пользователей: ");
        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}


