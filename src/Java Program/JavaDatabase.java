/*
This class contains methods to establish connection between database and java application as well as
methods to create table, converting array to 2d array, get data from database, update, delete, generate ID 
and get ID.

 */
//package internalassesment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class JavaDatabase
{

    private String dbName;
    private Connection dbConn;
    private ArrayList<ArrayList<String>> data;
    private int dishID;

    // construct for creating new db
    public JavaDatabase()
    {
        dbName = "";
        dbConn = null;
        data = null;
        dishID = 0;

    }

    //construct for existing DB
    public JavaDatabase(String dbName)
    {
        setDbName(dbName);
        setDbConn(); // Creates Connection from java to DB
        data = null;
        dishID = 0;
    }

    public String getDbName()
    {
        return dbName;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public Connection getDbConn()
    {
        return dbConn;
    }

    public void setDbConn()
    {
        String connectionURL = "jdbc:derby:" + this.dbName;
        this.dbConn = null;
        try
        {
            //find the derby friver (must be included in lib)
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //use driver manager to create connection to db from JAVA
            this.dbConn = DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException ex)
        {
            System.out.println("Class For Name not found, check Library");
            ex.printStackTrace(System.err);
        } catch (SQLException se)
        {
            System.out.println("Database not created, Check your SQL or db connection");
            se.printStackTrace(System.err);
        }
    }

    //returns the contents of a db table
    public ArrayList<ArrayList<String>> getData(String tableName,
            String[] tableHeaders)
    {
        int columnCount = tableHeaders.length;
        Statement s = null;
        ResultSet rs = null;
        String dbQuery = "SELECT * FROM " + tableName;
        this.data = new ArrayList<>();

        //read the data
        try
        {
            // send the query and receive data
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);

            // read the data using rs and store in Arraylist data
            while (rs.next())
            {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 0; i < columnCount; i++)
                {
                    row.add(rs.getString(tableHeaders[i]));
                }
                this.data.add(row);
            }
        } catch (SQLException se)
        {
            System.out.println("SQL Erroe: Not able to get data");
            se.printStackTrace(System.err);
        }
        return data;
    }

    public void setData(ArrayList<ArrayList<String>> data)
    {
        this.data = data;
    }

    public void createTable(String newTable, String dbName)
    {
        //print the sql stmt for debugging
        System.out.println(newTable);
        //set this objects dbname and db connection
        setDbName(dbName);
        setDbConn();
        //create sql statement to create table
        Statement s;
        try
        {
            //blank s statement using existing connection
            s = this.dbConn.createStatement();
            //execue sql (create table) using s statement
            s.execute(newTable);
            System.out.println("New table created");
        } catch (SQLException se)
        {
            System.out.println("Database not created, Check your SQL connection");
            se.printStackTrace(System.err);
        }
    }

    //create db and db connection
    public void createDb(String newDbName)
    {
        setDbName(newDbName);
        String connectionURL = "jdbc:derby:" + this.dbName + ";create=true";
        this.dbConn = null;
        try
        {
            //find driver 
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //create db and create connection
            this.dbConn = DriverManager.getConnection(connectionURL);
            System.out.println("New Database " + this.dbName + " created!");
        } catch (ClassNotFoundException ex)
        {
            System.out.println("Class For Name not found, check Library");
            ex.printStackTrace(System.err);
        } catch (SQLException se)
        {
            System.out.println("Database not created, Check your SQL or db connection");
            se.printStackTrace(System.err);
        }
    }

    // convert 2d ArrayList to 2d array for jtable
    public Object[][] to2dArray(ArrayList<ArrayList<String>> data)
    {
        int columnCount = data.get(0).size();
        Object[][] dataList = new Object[data.size()][columnCount];
        for (int i = 0; i < data.size(); i++)
        {
            ArrayList<String> row = data.get(i);
            for (int j = 0; j < columnCount; j++)
            {
                dataList[i][j] = row.get(j);
            }
        }
        return dataList;
    }

    //Method to get the last number of dish ID in table in Database
    public int getLatestID()
    {
        try
        {
            ArrayList<ArrayList<String>> dataDishName = new ArrayList<>();
            //get data from Dish Name Table ArrayList
            DishName name = new DishName();
            name.setDishNameTable();
            dataDishName = name.getDishNameTable();
            //indentify the last row
            int lastRow = dataDishName.size() - 1;
            //get the dishID of the last row 
            ArrayList<String> lastRowString = dataDishName.get(lastRow);
            dishID = Integer.parseInt(lastRowString.get(0));
        } catch (Exception exceptionObj)
        {
            System.out.println("Error getting the lastest ID  (JavaDatabse class)");
        }
        return dishID;
    }

    //Method to generate new Dish ID that is unique 
    public int generateID()
    {
        String tableName = "DishName";
        dishID = getLatestID();
        ++dishID;
        return dishID;
    }

    //Method to insert data into Table in DataBase
    public void insertData(String tableName, int IDNumber, String columnName, String insert)
    {
        try
        {
            String dbQuery1 = "INSERT INTO " + tableName + " VALUES (?,?)";
            PreparedStatement ps = dbConn.prepareStatement(dbQuery1);
            ps.setInt(1, IDNumber);
            ps.setString(2, insert);
            ps.executeUpdate();

        } catch (SQLException ex)
        {
            System.out.println("Error inserting data (JavaDatabse class)");
        }
    }

    //Method to insert data into Table in DataBase
    public void insertData(String tableName, int IDNumber, String columnName, double insert)
    {
        try
        {
            String dbQuery1 = "INSERT INTO " + tableName + " VALUES (?,?)";
            PreparedStatement ps = dbConn.prepareStatement(dbQuery1);
            ps.setInt(1, IDNumber);
            ps.setDouble(2, insert);
            ps.executeUpdate();

        } catch (SQLException ex)
        {
            System.out.println("Error inserting data (JavaDatabse class)");
        }
    }

    //Method to Update Table in DataBase
    public void update(String tableName, int IDNumber, String columnName, String change)
    {
        try
        {
            String dbQuery1 = "UPDATE " + tableName + " SET " + columnName + " = " + "'" + change + "'"
                    + " WHERE DishID = " + IDNumber;
            PreparedStatement ps1 = dbConn.prepareStatement(dbQuery1);
            ps1.executeUpdate();

        } catch (SQLException ex)
        {
            System.out.println("Error inserting data (JavaDatabse class)");
        }
    }

    //Method to Update Table in DataBase
    public void update(String tableName, int IDNumber, String columnName, int change)
    {
        try
        {
            String dbQuery1 = "UPDATE " + tableName + " SET " + columnName + " = " + change
                    + " WHERE DishID = " + IDNumber;
            PreparedStatement ps1 = dbConn.prepareStatement(dbQuery1);
            ps1.executeUpdate();

        } catch (SQLException ex)
        {
            System.out.println("Error inserting data (JavaDatabse class)");
        }
    }

    public void delete(int IDNumber)
    {

        try
        {
            //Delete Dish from DishName table
            String dbQuery1 = "DELETE FROM DishName WHERE DishID = " + IDNumber;
            PreparedStatement ps1 = dbConn.prepareStatement(dbQuery1);
            ps1.executeUpdate();
            //Delete Dish from DishType table
            String dbQuery2 = "DELETE FROM DishType WHERE DishID = " + IDNumber;
            PreparedStatement ps2 = dbConn.prepareStatement(dbQuery2);
            ps2.executeUpdate();
            //Delete Dish from Ingredient table
            String dbQuery3 = "DELETE FROM Ingredient WHERE DishID = " + IDNumber;
            PreparedStatement ps3 = dbConn.prepareStatement(dbQuery3);
            ps3.executeUpdate();
            //Delete Dish from Sauce table
            String dbQuery4 = "DELETE FROM Sauce WHERE DishID = " + IDNumber;
            PreparedStatement ps4 = dbConn.prepareStatement(dbQuery4);
            ps4.executeUpdate();
            //Delete Dish from DishRatio table
            String dbQuery5 = "DELETE FROM DishRatio WHERE DishID = " + IDNumber;
            PreparedStatement ps5 = dbConn.prepareStatement(dbQuery5);
            ps5.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("Error deleteing data (JavaDatabse class)");
        }
    }

    public static void main(String[] args)
    {
        String dbName = "CUISINES";
        String[] columnName =
        {
            "Dish_Name"
        };
        //create object for db class
        JavaDatabase objDb = new JavaDatabase(dbName);
        Connection myDbConn = null;
        String dishName = "Steam rice";
        myDbConn = objDb.getDbConn();
        String dbQuery1 = "INSERT INTO DishName (Dish_Name) VALUES (?)";
        /*try
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setString(1, dishName);
            ps.executeUpdate();
            System.out.println("Data inserted sucessfully");
        } catch (SQLException se)
        {
            System.out.println("Error inserting data");
            se.printStackTrace(System.err);
        } */
        String[] columnName1 =
        {
            "DishID",
            "Dish_Name"
        };
        ArrayList<ArrayList<String>> myData
                = objDb.getData("DishName", columnName1);
        System.out.println(myData);

        //pass 2d ArrayList into 2d array (for jtable)
        Object[][] testData = objDb.to2dArray(myData);

        //display2d array using terminal (for debugging)
        for (int i = 0; i < testData.length; i++)
        {
            for (int j = 0; j < testData[i].length; j++)
            {
                System.out.println(testData[i][j]);
            }
        }

    }

}
