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

     private static String company, fname, sname, position;
     private static int id;
     private float salary;

     private void checkStrField(String f){
         String a = scanner.nextLine();
         while (a.equals("") || a == null || a.length()<1) {
             System.out.println("Can\'t be empty. Try again");
             System.out.print("-> ");
             a = scanner.nextLine();
         }
         switch (f){
             case "company" : company = a;   break;
             case "fname"   : fname = a;     break;
             case "sname"   : sname = a;     break;
             case "position": position = a;  break;
         }
     }

    void createCompany(){
        System.out.print("Company\'s name: ");
        checkStrField("company");
        wCommands.createCompany(company);
    }

    void deleteCompany(){
        System.out.print("Company\'s name: ");
        checkStrField("company");
        wCommands.deleteCompany(company);
    }

    void addEmp(){
        System.out.print("Company\'s name: ");
        checkStrField("company");
        System.out.print("First name: ");
        checkStrField("fname");
        System.out.print("Last name: ");
        checkStrField("sname");
        System.out.print("Position: ");
        checkStrField("position");
        try {
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Salary: ");
            salary = scanner.nextFloat();

            wCommands.addEmployee(company, fname, sname, position, age, salary);
        } catch (InputMismatchException e){
            System.out.println("Incorrect age or salary. Try again.");
        }
    }

    void showAll(){
        System.out.print("Company\'s name: ");
        checkStrField("company");
        wCommands.showAll(company);
    }

    void clist(){
        wCommands.clist();
    }

     void deleteW(){
         try {
             System.out.print("Company\'s name: ");
             checkStrField("company");
             try {
                 System.out.print("Id of employee: ");
                 id = scanner.nextInt();

                 wCommands.deleteW(company, id);

             } catch (InputMismatchException e){
                 System.out.println("Incorrect id. Try again.");
             }

         } catch (InputMismatchException | NullPointerException e){
             System.out.println("Can\'t delete employee.");
         }
     }

    void changeP(){
        System.out.print("Company\'s name: ");
        checkStrField("company");
        try {
            System.out.print("Id of employee: ");
            id = scanner.nextInt();
            System.out.print("New position: ");
            checkStrField("position");

            wCommands.changeP(company, id, position);
        } catch (InputMismatchException e){
            System.out.println("Incorrect id. Try again.");
        }
    }

    void changeS(){
        System.out.print("Company\'s name: ");
        checkStrField("company");
        try {
            System.out.print("Id of employee: ");
            id = scanner.nextInt();
            System.out.print("New salary: ");
            salary = scanner.nextFloat();

            wCommands.changeS(company, id, salary);
        } catch (InputMismatchException e){
            System.out.println("Incorrect id or salary. Try again.");
        }
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
        System.out.println("********************************************************\n" +
        "List of commands\n"                                                            +
        "********************************************************\n"                    +
        "1) nc - create new company\n"                                                  +
        "2) dc - delete company\n"                                                      +
        "3) addE - add new employee\n"                                                  +
        "4) showAll - show list of employees in selected company\n"                     +
        "5) clist - show list of companies\n"                                           +
        "6) dw - delete selected employee\n"                                            +
        "7) changeP - change position to selected employee\n"                           +
        "8) changeS - change salary to selected employee\n"                             +
        "9) exit - exit\n"                                                              +
        "10) ddb - delete database and exit\n"                                          +
        "********************************************************\n");
    }

    void exit(){
         wCommands.exit();
    }

    void dropDb(){
         wCommands.dropDb();
    }
}