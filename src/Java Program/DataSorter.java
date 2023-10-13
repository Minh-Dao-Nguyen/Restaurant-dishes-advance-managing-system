/*
September 28th 2020
 * This class sorts out data in order of lowest to highest
 */
//package internalassesment;

import java.util.ArrayList;


public class DataSorter
{

    //data of the unsorted data 
    private ArrayList<ArrayList<Double>> unsortedData;
    //data of the sorted data 
    private ArrayList<ArrayList<Double>> sortedData;

    //Constructor
    public DataSorter()
    {
        //making the ArrayList
        //data of the unsorted data 
        this.unsortedData = new ArrayList<>();
        //data of the sorted data 
        this.sortedData = new ArrayList<>();
    }
    //get unsorted Data
    public ArrayList<ArrayList<Double>> getUnsortedData()
    {
        return unsortedData;
    }
    //set unsorted Data
    public void setUnsortedData(ArrayList<ArrayList<Double>> unsortedData)
    {
        this.unsortedData = unsortedData;
    }
    //get unsorted Data
    public ArrayList<ArrayList<Double>> getSortedData()
    {
        return sortedData;
    }
    //Sorting the unsorted data 
    public void setSortedData()
    {
        //Array for dish ID
        Double[] arID = new Double[this.unsortedData.size()];
        //Array for ratio 
        Double[] arRatio = new Double[this.unsortedData.size()];
        //transfering the data in ArraList to Array for sorting
        for (int i = 0; i < this.unsortedData.size(); i++)
        {
            //temporary object to get data
            ArrayList<Double> tempData = this.unsortedData.get(i);
            //dish ID
            arID[i] = tempData.get(0);
            //Ratio
            arRatio[i] = tempData.get(1);
        }
        //Selection Sort (for Ratio)
        for (int i = 0; i < arRatio.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < arRatio.length; j++)
            {
                if (arRatio[j] < arRatio[min])
                {
                    min = j;
                }
            }
            //Swapping the order of the ratio in Array 
            double temp = arRatio[min];
            arRatio[min] = arRatio[i];
            arRatio[i] = temp;
            //Swapping the order of the dish ID in Array matching with the ratio 
            double temp1 = arID[min];
            arID[min] = arID[i];
            arID[i] = temp1;
        }
        //Transfering data from Array back to ArrayList
        for (int i = 0; i < this.unsortedData.size(); i++)
        {
            //temporary object to hold data
            ArrayList<Double> tempData = new ArrayList<>();
            //DishID
            tempData.add(arID[i]);
            //Ratio
            tempData.add(arRatio[i]);
            //adding to ArrayList ( sorted data)
            this.sortedData.add(tempData);
        }

    }
    
    //Main method for testing
    public static void main(String args[])
    {
        //calling constructor 
        DataSorter objSorter = new DataSorter();
        //calling constructor of ratio class
        Ratio objRatio = new Ratio();
        //calling constructor of JavaDatabase class
        JavaDatabase objDB = new JavaDatabase();
        //getting ratio data
        objRatio.setData();
        ArrayList<ArrayList<Double>> testInt = objRatio.getData();
        //setting unsorted dara and sort the data 
        objSorter.setUnsortedData(testInt);
        objSorter.setSortedData();
        //print data for testing
        ArrayList<ArrayList<Double>> intTest = objSorter.getSortedData();
        ArrayList<ArrayList<String>> testData = objRatio.intToStringArray(intTest);
        Object[][] printData = objDB.to2dArray(testData);
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }

    }
}
