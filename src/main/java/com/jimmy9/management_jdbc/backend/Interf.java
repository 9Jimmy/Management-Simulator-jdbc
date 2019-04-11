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

            switch (i.toUpperCase()){
                case "INFO":
                    commands.info();
                    break;
                case "HELP":
                    commands.help();
                    break;
                case "NC":
                    commands.createCompany();
                    break;
                case "DC":
                    commands.deleteCompany();
                    break;
                case "ADDE":
                    commands.addEmp();
                    break;
                case "SHOWALL":
                    commands.showAll();
                    break;
                case "CLIST":
                    commands.clist();
                    break;
                case "DW":
                    commands.deleteW();
                    break;
                case "CHANGEP":
                    commands.changeP();
                    break;
                case "CHANGES":
                    commands.changeS();
                    break;
                case "EXIT":
                    session = false;
                    commands.exit();
                    break;
                case "DDB":
                    session = false;
                    commands.dropDb();
                    default:
                        System.out.printf("%nUnknown command \'%s\' enter \'help\'" +
                                " to check list of commands.", i);
            }
        }
    }
}