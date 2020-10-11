package lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNum;
    private int salary;
    private int age;

    public Employee () {
        this("Trainee", "intern", "corporate@mail.com", "000 000 00-00", 1000, 18);
    }

    public Employee(String name, String position, String email, String phoneNum, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.age = age;
    };

    public void info() {
        System.out.printf("Employee %s \nPosition %s \nEmail %s \nPhone number %s \nSalary %d \nAge %d \n", name, position, email, phoneNum, salary, age);
    }

    public int getAge () {
      return age;
    };
}
