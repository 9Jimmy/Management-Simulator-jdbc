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

            if(i.equals("info")){
                commands.info();
            }
            else if(i.equals("help")){
                commands.help();
            }
            else if(i.equals("nc")){
                commands.createCompany();
            }
            else if(i.equals("dc")){
                commands.deleteCompany();
            }
            else if(i.equals("addE")){
                commands.addEmp();
            }
            else if(i.equals("showAll")){
                commands.showAll();
            }
            else if(i.equals("clist")){
                commands.clist();
            }
            else if(i.equals("dw")){
                commands.deleteW();
            }
            else if(i.equals("changeP")){
                commands.changeP();
            }
            else if(i.equals("changeS")){
                commands.changeS();
            }
            else if(i.equals("exit")){
                session = false;
            }
            else{
                System.out.printf("%nUnknown command \'%s\' enter \'help\' to check list of commands.", i);
            }
        }
    }
}
