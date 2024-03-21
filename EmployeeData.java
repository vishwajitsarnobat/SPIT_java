import java.util.Scanner;

class Employee {
    private String name; 
    private String id;
    private int age;

    Employee(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    String giveName() {
        return name;
    }

    String giveId() {
        return id;
    }

    int giveAge() {
        return age;
    }
}

class SalariedEmployee extends Employee {
    double empSalary;

    SalariedEmployee(String name, String id, int age, double empSalary) {
        super(name, id, age);
        this.empSalary = empSalary;
    }

    void display() {
        System.out.println("Name: " + giveName());
        System.out.println("ID: " + giveId());
        System.out.println("Age: " + giveAge());
        System.out.println("Salary: " + empSalary);
    }
}

class EmployeeData {
    static Scanner input = new Scanner(System.in);

    static void readData(SalariedEmployee[] employeeList, int ctr) {
        for (int i = 0; i < ctr; i++) {
            employeeList[i].display();
        }

        System.out.println("\n");
        execute(employeeList, ctr);
    }

    static void takeData(SalariedEmployee[] employeeList, int ctr) {
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Enter id: ");
        String id = input.next();
        System.out.print("Enter age: ");
        int age = input.nextInt();
        System.out.print("Enter Salary: ");
        double salary = input.nextDouble();
        System.out.println("Is the employee permanent or on contract? \n 1. Permanent \n 2. On contract");
        System.out.print("Your choice: ");
        int option = input.nextInt();
        System.out.println();

        if (option == 1) {
            employeeList[ctr] = new SalariedEmployee(name, id, age, (salary + 2000));
        } else if (option == 2) {
            employeeList[ctr] = new SalariedEmployee(name, id, age, salary);
        } else {
            System.out.println("Please enter a valid input");
            execute(employeeList, ctr); 
            return; 
        }

        System.out.println("Data updated successfully... \n");
        execute(employeeList, ctr + 1); 
    }

    static void findMax(SalariedEmployee[] employeeList, int ctr) {
        int maxIndex = 0;
        double maxSalary = employeeList[0].empSalary;
        for (int i = 1; i < ctr; i++) {
            if (employeeList[i].empSalary > maxSalary) {
                maxIndex = i;
                maxSalary = employeeList[i].empSalary;
            }
        }
        employeeList[maxIndex].display();
    }

    static void execute(SalariedEmployee[] employeeList, int ctr) {
        System.out.println(" 1. Enter data. \n 2. View data. \n 3. Employee data with max salary \n 4. Exit");
        System.out.print("Your choice: ");
        int opt = input.nextInt();
        System.out.println();
        
        switch(opt) {
            case 1: 
                takeData(employeeList, ctr);
                break;

            case 2:
                readData(employeeList, ctr);
                break;

            case 3:
                findMax(employeeList, ctr);
                break;

            case 4:
                System.out.println("See you soon :)");
                break;

            default:
                System.out.println("Invalid option. Please enter a number between 1 and 4.");
                execute(employeeList, ctr);
        }
    }

    public static void main(String[] args) {
        System.out.println("NOTE: YOU CAN STORE DATA FOR UP TO 5 EMPLOYEES");
        
        SalariedEmployee[] employeeList = new SalariedEmployee[5];
        int ctr = 0;

        execute(employeeList, ctr);        
    }
}
