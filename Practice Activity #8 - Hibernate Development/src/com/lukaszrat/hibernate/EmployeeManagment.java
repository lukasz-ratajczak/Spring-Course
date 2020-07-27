package com.lukaszrat.hibernate;

import com.lukaszrat.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagment {

    public static void main(String[] args) {

        int option = 0;
        int employeeId = 0;
        int run = 0;

        while (run == 0) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            try {
                session.beginTransaction();

                Scanner scannerOption = new Scanner(System.in);
                System.out.println("What you want to do? \n1)Add new employee\n2)Remove employee\n3)Find employee by his Id\n4)Find employees by company\n5)Exit");
                option = scannerOption.nextInt();


                if (option == 1) {
                    Employee employee = new Employee();

                    Scanner scannerFirstName = new Scanner(System.in);
                    System.out.println("Enter first name");
                    employee.setFirstName(scannerFirstName.nextLine());

                    Scanner scannerLastName = new Scanner(System.in);
                    System.out.println("Enter last name");
                    employee.setLastName(scannerLastName.nextLine());

                    Scanner scannerEmailName = new Scanner(System.in);
                    System.out.println("Enter company name");
                    employee.setCompany(scannerEmailName.nextLine());

                    System.out.println("Employee: " + employee + " >Saved<");
                    session.save(employee);

                } else if (option == 2) {
                    Scanner scannerId = new Scanner(System.in);
                    System.out.println("Enter ID for removal");
                    employeeId = scannerId.nextInt();

                    Employee employee = session.get(Employee.class, employeeId);
                    System.out.println("Employee: " + employee + " >Deleted<");
                    session.delete(employee);

                } else if (option == 3) {
                    Scanner scannerId = new Scanner(System.in);
                    System.out.println("Enter ID to search for employee");
                    employeeId = scannerId.nextInt();

                    Employee employee = session.get(Employee.class, employeeId);
                    System.out.println("Employee data" + employee);

                } else if (option == 4) {
                    List<Employee> employees;

                    Scanner scannerCompany = new Scanner(System.in);
                    System.out.println("Enter Company name to search for employees");
                    String data = scannerCompany.nextLine();

                    employees = session.createQuery("from Employee e where e.company='" + data + "'").list();

                    for (Employee temp : employees) {
                        System.out.println(temp);
                    }
                }else if (option == 5){
                    System.out.println("bye");
                    run = 1;
                } else {
                    System.out.println("You enter wrong number");
                }
                session.getTransaction().commit();

            } finally {
                factory.close();
            }

        }
    }
}
