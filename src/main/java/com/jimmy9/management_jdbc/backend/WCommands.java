package com.jimmy9.management_jdbc.backend;

import java.sql.*;

class WCommands {

    private static String dbName = "9jManagementJDBC";
    private static Connection connection;

    static {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/?user=root&password=root");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
        }
    }

    private static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Creating statement failed.");
        }
    }

    private static ResultSet resSet(String company){
        try {
            return statement.executeQuery("SELECT * FROM " + company);
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }
        return null;
    }

     void conn() throws SQLException{
        try {
            statement.executeUpdate("CREATE DATABASE " + dbName);

        } catch (SQLException e) {
            statement.execute("USE " + dbName);
        }
    }

     void createCompany(String company){
        try {
            statement.execute("USE " + dbName);
            statement.execute("create table " + company + "\n" +
                    "(\n" +
                    "\tid int auto_increment,\n" +
                    "\tfname VARCHAR(45) null,\n" +
                    "\tsname VARCHAR(45) null,\n" +
                    "\tposit VARCHAR(45) null,\n" +
                    "\tage int(100) null,\n" +
                    "\tsalary int null,\n" +
                    "\tconstraint table_name_pk\n" +
                    "\t\tprimary key (id)\n" +
                    ");");
            System.out.printf("Company with name \'%s\' successfully created.%n", company);

        } catch (SQLException e) {
            System.out.printf("Company with name \'%s\' already exists!%n", company);
        }
    }

     void deleteCompany(String company){
        try {
            statement.execute("USE " + dbName);
            statement.execute("DROP TABLE " + company);
            System.out.printf("Company \'%s\' successfully deleted.%n", company);

        } catch (SQLException e) {
            System.out.printf("There is no company named %s.%n", company);
        }
    }

     void addEmployee(String company, String fname, String sname, String position, int age, float salary){
        try {
            statement.execute("USE " + dbName);
            String cm = "INSERT INTO " + company + "(fname, sname, posit, age, salary) " +
                    "VALUES(\'" + fname + "\', \'" + sname + "\', \'" + position + "\', \'" + age + "\', \'" +
                    salary + "\')";
            statement.addBatch(cm);
            statement.executeBatch();
            statement.clearBatch();
            System.out.println("Employee added successfully.");

        } catch (SQLException e) {
            System.out.println("Adding employee failed.");
        }
    }

     void showAll(String company){
        try {
            statement.execute("USE " + dbName);
            ResultSet r = resSet(company);
            System.out.printf("%s%n", company);

            while (r.next()) {
                Employee employee = new Employee();

                employee.setId(r.getInt("id"));
                employee.setFname(r.getString("fname"));
                employee.setSname(r.getString("sname"));
                employee.setPosition(r.getString("posit"));
                employee.setAge(r.getInt("age"));
                employee.setSalary(r.getFloat("salary"));

                System.out.print(employee);
                System.out.println("-------------------------------------------------------------------------------");
            }
        } catch (SQLException | NullPointerException e) {
            System.out.printf("Can't show list of employees in company %s.%n", company);
        }
    }

     void clist(){
        try {
            statement.execute("USE " + dbName);
            ResultSet r = statement.executeQuery("SHOW TABLES");
            System.out.println("List of companies:");

            while(r.next()){
                Cmp cmp = new Cmp();

                cmp.setName(r.getString("Tables_in_9jmanagementjdbc"));

                System.out.print(cmp);
            }

        } catch (SQLException e) {
            System.out.println("Can't show list of companies.");
        }
    }

     void deleteW(String company, int id){
        try {
            statement.execute("USE " + dbName);
            statement.execute("DELETE FROM " + company + " WHERE id = " + id);
            System.out.printf("Employee in company %s with id %d successfully deleted.%n", company, id);

        } catch (SQLException e) {
            System.out.print("Something went wrong.");
        }
    }

     void changeP(String company, int id, String position){
        try {
            statement.execute("USE " + dbName);
            String cm = "UPDATE " + company + " SET posit = \'" + position + "\' WHERE id=" + id;
            statement.executeUpdate(cm);

        } catch (SQLException e) {
            System.out.println("Can\'t change position of employee. Try again.");
        }
    }

     void changeS(String company, int id, float salary){
        try {
            statement.execute("USE " + dbName);
            String cm = "UPDATE " + company + " SET salary = " + salary + " WHERE id=" + id;
            statement.executeUpdate(cm);

        } catch (SQLException e) {
            System.out.println("Can\'t change salary of employee. Try again.");
        }
    }

    void exit(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void dropDb(){
        try{
            String cm = "DROP database " + dbName;
            statement.execute(cm);
            exit();
            System.out.println("Database deleted successfully.");
        } catch (SQLException e){
            System.out.println("Deleting database failed.");
        }
    }
}