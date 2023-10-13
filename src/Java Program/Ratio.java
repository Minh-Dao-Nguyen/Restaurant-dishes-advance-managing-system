/*
September 21st 2020
 * This class includes all methods use to extract and manpulate data from Ratio table
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ratio
{
    //The ratio of the dish 
    private double ratio;
    //The dish Id of the dish 
    private double dishID;
    //the raw data (double type) from dish Ratio table
    private ArrayList<ArrayList<Double>> data;
    //the data converted to String from dishRatio table
    private ArrayList<ArrayList<String>> dataTable;
    //the targeted ratio 
    private double checkRatio;
    //the data with targeted ratio
    private ArrayList<ArrayList<Double>> dataChecked;

    //Constructor
    public Ratio()
    {
        this.ratio = 0.0;
        this.dishID = 0.0;
        this.data = new ArrayList<>();
        this.dataTable = new ArrayList<>();
        this.dataChecked = new ArrayList<>();
        this.checkRatio = 0.0;
    }
    //get the data of the dishRatio table 
    public ArrayList<ArrayList<String>> getDataTable()
    {
        return dataTable;
    }
    //get the requested ratio 
    public double getCheckRatio()
    {
        return checkRatio;
    }
    //set the requested ratio 
    public void setCheckRatio(double checkRatio)
    {
        this.checkRatio = checkRatio;
    }
    //get the data that has satisfoed the requested ratio 
    public ArrayList<ArrayList<Double>> getDataChecked()
    {
        return dataChecked;
    }
    //set the ratio for the dish 
    public void setRatio(Double ratio)
    {
        this.ratio = ratio;
    }
    //set the dish ID of the dish 
    public void setDishID(Double dishID)
    {
        this.dishID = dishID;
    }
    //get the ratio of the dish
    public double getRatio()
    {
        return ratio;
    }
    //get the dishID of the dish 
    public double getDishID()
    {
        return dishID;
    }
    //retreiving data of dishRatio table from the database 
    public void setData()
    {
        //established connection with Database using JavaDatabaseclass
        JavaDatabase objDB = new JavaDatabase("CUISINES");
        objDB.setDbConn();
        Connection dbConn = objDB.getDbConn();
        Statement st;
        ResultSet rs;
        try
        {
            //making query 
            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM DishRatio");
            //transfering data to ArrayList
            while (rs.next())
            {
                //setting dishID and ratio for the dish 
                Ratio dish = new Ratio();
                dish.setDishID(rs.getDouble(1));
                dish.setRatio(rs.getDouble(2));
                //Transfering data to ArrayList
                ArrayList<Double> temp = new ArrayList<>();
                temp.add(dish.getDishID());
                temp.add(dish.getRatio());
                this.data.add(temp);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DishName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //get the data of dishRatio table
    public ArrayList<ArrayList<Double>> getData()
    {
        return this.data;
    }
    //converting ArrayList<ArrayList<Double>> to ArrayList<ArrayList<String>> method
    public ArrayList<ArrayList<String>> intToStringArray(ArrayList<ArrayList<Double>> data)
    {
        //loops to through all data in the ArrayList
        for (int i = 0; i < data.size(); i++)
        {
            //calling a temporary object
            ArrayList<String> tempString = new ArrayList<>();
            ArrayList<Double> tempInt = data.get(i);
            //get the dish ID 
            Double doubleDishID = tempInt.get(0);
            //Rounding the dishID to ocnvert it to integer
            int intDishID = (int) Math.round(doubleDishID);
            //convert dishId to String
            String dishID = Integer.toString(intDishID);
            //Convert ratio from double to String 
            String ratio = Double.toString(tempInt.get(1));
            //adding dishID and ratio to Object 
            tempString.add(dishID);
            tempString.add(ratio);
            //adding Object to ArrayList
            this.dataTable.add(tempString);
        }
        return this.dataTable;
    }

    public void setDataChecked()
    {
        //established connection to database through JavaDatabase class
        JavaDatabase objDB = new JavaDatabase("CUISINES");
        objDB.setDbConn();
        Connection dbConn = objDB.getDbConn();
        Statement st;
        ResultSet rs;

        try
        {
            //transfering data to ArrayList
            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM DishRatio");
            //transfering data to ArrayList
            while (rs.next())
            {
                //setting dishID and ratio for the dish 
                Ratio dish = new Ratio();
                dish.setDishID(rs.getDouble(1));
                dish.setRatio(rs.getDouble(2));
                //Transfering data to ArrayList
                ArrayList<Double> temp = new ArrayList<>();
                temp.add(dish.getDishID());
                temp.add(dish.getRatio());
                this.data.add(temp);
            }
            //extracting dish that has a ratio that has passed the checked ratio along with its dishID
            for(int i = 0; i < this.data.size(); i++)
            {
                //Calling temporary object to store data
                ArrayList<Double> temp = new ArrayList<>();
                ArrayList<Double> arrayTemp = this.data.get(i);
                //dish ID
                double dishID = arrayTemp.get(0);
                //ratio
                double ratio = arrayTemp.get(1);
                /*if the ratio passed the checked/requested ratio, 
                hence the ratio is smaller or equal the than check ratio*/
                if (ratio <= this.checkRatio)
                {
                    //add passing requirement data to ArrayList 
                    temp.add(dishID);
                    temp.add(ratio);
                    this.dataChecked.add(temp);
                }
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DishName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Main method for testing
    public static void main(String args[])
    {
        //Calling constructor 
        Ratio objRatio = new Ratio();
        //set and get data
        objRatio.setData();
        JavaDatabase objDB = new JavaDatabase();
        ArrayList<ArrayList<Double>> testInt = objRatio.getData();
        ArrayList<ArrayList<String>> testString = objRatio.intToStringArray(testInt);
        //print data 
        Object[][] printData = objDB.to2dArray(testString);
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }
        //Check Ratio testing 
//        double checkRatio = 0.5;
//        objRatio.setCheckRatio(checkRatio);
//        objRatio.setDataChecked();
//        ArrayList<ArrayList<Double>> testInt1 = objRatio.getDataChecked();
//        ArrayList<ArrayList<String>> testString1 = objRatio.intToStringArray(testInt1);
//        Object[][] printData1 = objDB.to2dArray(testString1);
//        for (int i = 0; i < printData1.length; i++)
//        {
//            for (int j = 0; j < printData1[i].length; j++)
//            {
//                System.out.println(printData1[i][j]);
//            }
//        }

    }

}
