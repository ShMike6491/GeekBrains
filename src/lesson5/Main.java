package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(),
                new Employee("Mike", "junior-dev", "mike@mail.com", "+7 222 453 23-45", 1500, 24),
                new Employee("Frank", "QA Engineer", "frank@gmail.com", "8 882 124 23-56", 2500, 28),
                new Employee("John", "Employer", "john2341@gmail.com", "8 547 674 56-56", 10000, 42),
                new Employee("Sara", "Front-end dev", "sara@gmail.com", "8 746 134 24-66", 2000, 26),
        };

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].info();
            }
        }
    }
}
