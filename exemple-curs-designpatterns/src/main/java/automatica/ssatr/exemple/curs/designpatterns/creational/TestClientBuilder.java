/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.exemple.curs.designpatterns.creational;

/**
 *
 * @author mihai
 */
class User {
    private String email;
    private String firstName;
    private String lastName;
    private int age;

    public User(UserBuilder builder) {
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    public User(String email, String firstName, String lastName, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    static class UserBuilder {
        private String email;
        private String firstName;
        private String lastName;
        private int age;

        public UserBuilder(String email) {
            this.email = email;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

public class TestClientBuilder {
    public static void main(String[] args) {
        User u0 = new User.UserBuilder("mi@yahoo.com").build();

        User u1 = new User.UserBuilder("mi@yahoo.com")
                .firstName("Ioan")
                .build();

        User u2 = new User.UserBuilder("mi@yahoo.com")
                .firstName("Ioan")
                .lastName("Morar")
                .build();

        User u3 = new User.UserBuilder("mi@yahoo.com")
                .age(36)
                .firstName("Ioan")
                .lastName("Morar")
                .build();

        System.out.println(u0);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }
}