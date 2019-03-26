package com.jimmy9.management_jdbc.backend;

import java.sql.SQLException;
import java.util.Scanner;

public class Interf {
    private Commands commands = new Commands();
    private Scanner input = new Scanner(System.in);

    public void start() {
        try {
            Commands.connection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("<<<<<<<<<<<<<<<<<<Management-Simulator-JDBC>>>>>>>>>>>>>>>>>>>\n\n\n");
        System.out.print("\nEnter 'help' to check commands\n");
        System.out.print("Enter 'info' to check information about app");

        boolean session = true;

        while (session) {
            System.out.print("\n\n>>>");
            String i = input.nextLine();

            switch (i){
                case "info":
                    commands.info();
                    break;
                case "help":
                    commands.help();
                    break;
                case "nc":
                    commands.createCompany();
                    break;
                case "dc":
                    commands.deleteCompany();
                    break;
                case "addE":
                    commands.addEmp();
                    break;
                case "showAll":
                    commands.showAll();
                    break;
                case "clist":
                    commands.clist();
                    break;
                case "dw":
                    commands.deleteW();
                    break;
                case "changeP":
                    commands.changeP();
                    break;
                case "changeS":
                    commands.changeS();
                    break;
                case "exit":
                    session = false;
                    break;
                    default:
                        System.out.printf("%nUnknown command \'%s\' enter \'help\'" +
                                " to check list of commands.", i);
            }
        }
    }
}