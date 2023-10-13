/*
Spetember 21st 2020
 * This class includes all methods use to extract and manpulate data from Sauce table
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sauce
{
    private String sauce;
    private int dishID;
    private ArrayList<ArrayList<String>> data;
    public Sauce()
    {
        this.sauce = "";
        this.dishID = 0;
        this.data = new ArrayList<>();
    }

    public Sauce(int DishID, String sauce)
    {
        this.dishID = DishID;
        this.sauce = sauce;
    }

    public void setDishID(int dishID)
    {
        this.dishID = dishID;
    }

    public void setSauce(String sauce)
    {
        this.sauce = sauce;
    }

    public int getDishID()
    {
        return this.dishID;
    }

    public String getSauce()
    {
        return this.sauce;
    }

    public void setSauceTable()
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

            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT Sauce.DishID, Sauce.Sauce FROM Sauce");

            while (rs.next())
            {
                Sauce dish = new Sauce();
                dish.setDishID(rs.getInt(1));
                dish.setSauce(rs.getString(2));

                ArrayList<String> temp = new ArrayList<>();
                temp.add(Integer.toString(dish.getDishID()));
                temp.add(dish.getSauce());
                this.data.add(temp);

            }

        } catch (SQLException ex)
        {
            Logger.getLogger(DishName.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    public ArrayList<ArrayList<String>> getSauceTable()
    {
        return this.data;
    }

    public static void main(String args[])
    {
        Sauce A = new Sauce();
        A.setSauceTable();
        ArrayList<ArrayList<String>> Test = A.getSauceTable();
        System.out.println(Test);
    }
}
