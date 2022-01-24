/*
September 20th 2020
 * This class includes all methods use to extract and manpulate data from DishType Table
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DishType
{
    //the type of the dish 
    private String dishType;
    //the dish ID of the dish 
    private int dishID;
    //the data of Dish Type table
    private ArrayList<ArrayList<String>> data;

    //Constructor
    public DishType()
    {
        String dishType = "";
        this.dishID = 0;
        this.data = new ArrayList<>();
    }
    public DishType(int DishID, String dishType)
    {
        this.dishID = DishID;
        this.dishType = dishType;
    }
    //set the dish ID of the dish 
    public void setDishID(int dishID)
    {
        this.dishID = dishID;
    }
    //set the dish type of the dish 
    public void setDishType(String dishType)
    {
        this.dishType = dishType;
    }
    //get the dish ID of the dish 
    public int getDishID()
    {
        return this.dishID;
    }
    //get teh dish type of the dish 
    public String getDishType()
    {
        return this.dishType;
    }
    //retreiving the data of dish Type table
    public void setDishTypeTable()
    {
        //established connection with Database using JavaDatabaseclass
        JavaDatabase objDB = new JavaDatabase("CUISINES");
        objDB.setDbConn();
        Connection dbConn = objDB.getDbConn();
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        Statement st;
        ResultSet rs;
        try
        {
            //making query 
            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM DishType");
            //transfering data to ArrayList
            while (rs.next())
            {
                //setting the data 
                DishType dish = new DishType();
                dish.setDishID(rs.getInt(1));
                dish.setDishType(rs.getString(2));
                //transfer data to array list
                ArrayList<String> temp = new ArrayList<>();
                temp.add(Integer.toString(dish.getDishID()));
                temp.add(dish.getDishType());
                this.data.add(temp);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DishName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //get the data of Dish Type table
    public ArrayList<ArrayList<String>> getDishTypeTable()
    {
                return this.data;
    }
    //main method for testing
    public static void main(String args[])
    {
        //calling constructor
        DishType dishTypeobj = new DishType();
        //set and get data
        dishTypeobj.setDishTypeTable();
        ArrayList<ArrayList<String>> Test = dishTypeobj.getDishTypeTable();
        //print data
        System.out.println(Test);
    }

}
