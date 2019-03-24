package com.jimmy9.management_jdbc.backend;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

 class Commands {
    private static WCommands wCommands = new WCommands();
    private Scanner scanner = new Scanner(System.in);

     static void connection() throws SQLException {
        wCommands.conn();
    }

    void createCompany(){
        System.out.print("Company\'s name: ");
        String name = scanner.nextLine();
        wCommands.createCompany(name);
    }

    void deleteCompany(){
        System.out.print("Company\'s name: ");
        String name = scanner.nextLine();
        wCommands.deleteCompany(name);
    }

    void addEmp(){
        System.out.print("Company\'s name: ");
        String company = scanner.nextLine();
        System.out.print("First name: ");
        String fname = scanner.nextLine();
        System.out.print("Second name: ");
        String sname = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Salary: ");
        float salary = scanner.nextFloat();

        wCommands.addEmployee(company, fname, sname, position, age, salary);
    }

    void showAll(){
        System.out.print("Company\'s name: ");
        String company = scanner.nextLine();
        wCommands.showAll(company);
    }

    void clist(){
        wCommands.clist();
    }

    void deleteW(){
        try {
            System.out.print("Company\'s name: ");
            String company = scanner.nextLine();
            System.out.print("Id of employee: ");
            int id = scanner.nextInt();

            wCommands.deleteW(company, id);
        } catch (InputMismatchException | NullPointerException e){
            System.out.println("Can\'t delete employee.");
        }
    }

    void changeP(){
        System.out.print("Company\'s name: ");
        String company = scanner.nextLine();
        System.out.print("Id of employee: ");
        int id = scanner.nextInt();
        System.out.print("New position: ");
        String position = scanner.nextLine();

        wCommands.changeP(company, id, position);
    }

    void changeS(){
        System.out.print("Company\'s name: ");
        String company = scanner.nextLine();
        System.out.print("Id of employee: ");
        int id = scanner.nextInt();
        System.out.print("New salary: ");
        float salary = scanner.nextFloat();

        wCommands.changeS(company, id, salary);
    }

    void info(){
        System.out.println("\n\t░░░░░░░█▐▓▓░████▄▄▄█▀▄▓▓▓▌█\n" +
                "\t░░░░░▄█▌▀▄▓▓▄▄▄▄▀▀▀▄▓▓▓▓▓▌█\n" +
                "\t░░░▄█▀▀▄▓█▓▓▓▓▓▓▓▓▓▓▓▓▀░▓▌█\n" +
                "\t░░█▀▄▓▓▓███▓▓▓███▓▓▓▄░░▄▓▐█▌ \n" +
                "\t░█▌▓▓▓▀▀▓▓▓▓███▓▓▓▓▓▓▓▄▀▓▓▐█\n" +
                "\t▐█▐██▐░▄▓▓▓▓▓▀▄░▀▓▓▓▓▓▓▓▓▓▌█▌\n" +
                "\t█▌███▓▓▓▓▓▓▓▓▐░░▄▓▓███▓▓▓▄▀▐█\n" +
                "\t█▐█▓▀░░▀▓▓▓▓▓▓▓▓▓██████▓▓▓▓▐█ \n" +
                "\t▌▓▄▌▀░▀░▐▀█▄▓▓██████████▓▓▓▌█▌\n" +
                "\t▌▓▓▓▄▄▀▀▓▓▓▀▓▓▓▓▓▓▓▓█▓█▓█▓▓▌█▌ \n" +
                "\t█▐▓▓▓▓▓▓▄▄▄▓▓▓▓▓▓█▓█▓█▓█▓▓▓▐█\n");
        System.out.println("\tManagement-Simulator-jdbc_version\n\tCreated by 9Jimmy\n\t24.03.2019");
    }

    void help(){
        System.out.println("********************************************************");
        System.out.println("List of commands");
        System.out.println("********************************************************");
        System.out.println("1) nc - create new company");
        System.out.println("2) dc - delete company");
        System.out.println("3) addE - add new employee");
        System.out.println("4) showAll - show list of employees in selected company");
        System.out.println("5) clist - show list of companies");
        System.out.println("6) dw - delete selected employee");
        System.out.println("7) changeP - change position to selected employee");
        System.out.println("8) changeS - change salary to selected employee");
        System.out.println("9) exit - exit");
        System.out.println("********************************************************");
    }
}