/*
Spetember 20th 2020
 * This class includes all methods use to extract and manpulate data from DishName table
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DishName
{
    //The name of the dish
    private String DishName;
    //Dish ID
    private int DishID;
    //The data of the dishName table
    private ArrayList<ArrayList<String>> data;
    
    //constructor 
    public DishName()
    {
        this.DishName = "";
        this.DishID = 0;
        this.data = new ArrayList ();
    }

    public DishName(int DishID, String DishName)
    {
        this.DishID = DishID;
        this.DishName = DishName;
    }
    //set dishID of the dish 
    public void setDishID(int dishID)
    {
        this.DishID = dishID;
    }
    //set the name of the dish
    public void setDishName(String dishName)
    {
        this.DishName = dishName;
    }
    //get the dish ID
    public int getDishID()
    {
        return this.DishID;
    }
    //get the name of the dish
    public String getDishName()
    {
        return this.DishName;
    }
    //retireving the data from dishName in database 
    public void setDishNameTable()
    {
        //established connection with Database using JavaDatabaseclass
        JavaDatabase objDB = new JavaDatabase("CUISINES");
        objDB.setDbConn();
        Connection dbConn = objDB.getDbConn();
        //get data 
        Statement st;
        ResultSet rs;
        try
        {
            //make Query 
            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM DishName");
            //extracting data to ArrayList 
            while (rs.next())
            {
                //Calling constructor 
                DishName dish = new DishName();
                dish.setDishID(rs.getInt(1));
                dish.setDishName(rs.getString(2));
                //add data to ArrayList
                ArrayList<String> temp = new ArrayList<>();
                temp.add(Integer.toString(dish.getDishID()));
                temp.add(dish.getDishName());
                this.data.add(temp);

            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DishName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //get data of the DishName table
    public ArrayList<ArrayList<String>> getDishNameTable()
    {
        return this.data;
    }
    //main method for testing
    public static void main(String args[])
    {
        //calling constructot
        DishName A = new DishName();
        //set and get data
        A.setDishNameTable();
        ArrayList<ArrayList<String>> Test = A.getDishNameTable();
        //print data 
        System.out.println(Test);
    }
}
