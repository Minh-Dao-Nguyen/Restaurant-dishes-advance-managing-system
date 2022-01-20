/*
September 20th 2020
 * This class retrieve 2dArray with specific table user ask for
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DataTable
{
    //name targed table from the user 
    private String targetTable;
    //data of the table asked
    private ArrayList<ArrayList<String>> data;
    //data of the table asked to be displayed in JTable
    private Object[][] dataTable;
    //for testing
    private static ArrayList testData;

    //Constructor 
    public DataTable()
    {
        //get the asked or targeted table 
        this.targetTable = "Main Table";
        //make array list of data of the table asked
        this.data = new ArrayList<>();
    }
    public DataTable(String targetTable)
    {
        //get the asked or targeted table 
        this.targetTable = targetTable;
        //make array list of data of the table asked
        this.data = new ArrayList<>();
    }
    //making the data for the Table 
    public void setDataTable()
    {
        //ArrayList to hold data from dishName table
        ArrayList<ArrayList<String>> dataDishName = new ArrayList<>();
        //ArrayList to hold data from dishType table
        ArrayList<ArrayList<String>> dataDishType = new ArrayList<>();
        //ArrayList to hold data from ingredient table
        ArrayList<ArrayList<String>> dataIngredient = new ArrayList<>();
        //ArrayList to hold data from Sauce table
        ArrayList<ArrayList<String>> dataSauce = new ArrayList<>();
        //Dish Name Table ArrayList
        DishName name = new DishName();
        name.setDishNameTable();
        dataDishName = name.getDishNameTable();
        //Dish Type Table ArrayList
        DishType type = new DishType();
        type.setDishTypeTable();
        dataDishType = type.getDishTypeTable();
        //Ingredient Table ArrayList
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientTable();
        dataIngredient = ingredient.getIngredientTable();
        //combine ingredient to be displayed in JTable
        dataIngredient = ingredient.CombineIngredient(dataIngredient);
        //Sauce table ArrayList
        Sauce sauce = new Sauce();
        sauce.setSauceTable();
        dataSauce = sauce.getSauceTable();
        //decalre variable number of table
        int tableCount;
        //Main Table selected
        if (this.targetTable.equals("Main Table"))
        {
            //declare number of table
            tableCount = 4;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishType);
            //set data for table 2
            tableObj.setDataTable2(dataDishName);
            //set data for table 3
            tableObj.setDataTable3(dataIngredient);
            //set data for table 4
            tableObj.setDataTable4(dataSauce);
            //set table count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            //get combined data
            this.data = tableObj.getDataCombine();
            //turn data to Object [] [] for JTable
            this.dataTable = to2dArray(this.data);
        }
        //Entree Table selected
        else if (this.targetTable.equals("Entree"))
        {
            //get specific dish type table
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //declare number of table
            tableCount = 4;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishType);
            //set data for table 2
            tableObj.setDataTable2(dataDishName);
            //set data for table 3
            tableObj.setDataTable3(dataIngredient);
            //set data for table 4
            tableObj.setDataTable4(dataSauce);
            //set Table count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            //get combined data
            this.data = tableObj.getDataCombine();
            //turn data to Object [] [] for JTable
            this.dataTable = to2dArray(this.data);
        }
        //Salad Table selected
        else if (this.targetTable.equals("Salad"))
        {
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //declare number of table
            tableCount = 4;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishType);
            //set data for table 2
            tableObj.setDataTable2(dataDishName);
            //set data for table 3
            tableObj.setDataTable3(dataIngredient);
            //set data for table 4
            tableObj.setDataTable4(dataSauce);
            //set table count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            //get combined data
            this.data = tableObj.getDataCombine();
            //turn data to Object [] [] for JTable
            this.dataTable = to2dArray(this.data);
        }
        //desert Table selected
        else if (this.targetTable.equals("Desert"))
        {
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //declare number of table
            tableCount = 4;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishType);
            //set data for table 2
            tableObj.setDataTable2(dataDishName);
            //set data for table 3
            tableObj.setDataTable3(dataIngredient);
            //set data for table 4
            tableObj.setDataTable4(dataSauce);
            //set table count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            //get combined data
            this.data = tableObj.getDataCombine();
            //turn data to Object [] [] for JTable
            this.dataTable = to2dArray(this.data);
        }
        //fruit Table selected
        else if (this.targetTable.equals("Fruit"))
        {
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //declare number of table
            tableCount = 4;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishType);
            //set data for table 2
            tableObj.setDataTable2(dataDishName);
            //set data for table 3
            tableObj.setDataTable3(dataIngredient);
            //set data for table 4
            tableObj.setDataTable4(dataSauce);
            //set table count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            this.dataTable = to2dArray(this.data);
        }
        //drink Table selected
        else if (this.targetTable.equals("Drink"))
        {
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //declare number of table
            tableCount = 4;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishType);
            //set data for table 2
            tableObj.setDataTable2(dataDishName);
            //set data for table 3
            tableObj.setDataTable3(dataIngredient);
            //set data for table 4
            tableObj.setDataTable4(dataSauce);
            //set table count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            //get combined data
            this.data = tableObj.getDataCombine();
            //turn data to Object [] [] for JTable
            this.dataTable = to2dArray(this.data);
        }
        //ingredient Table selected
        else if (this.targetTable.equals("Ingredient"))
        {
            //declare number of table
            tableCount = 2;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishName);
            //set data for table 2
            tableObj.setDataTable2(dataIngredient);
            //set table Count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            this.dataTable = to2dArray(this.data);
        }
        //sauce Table selected
        else if (this.targetTable.equals("Sauce"))
        {
            //declare number of table
            tableCount = 2;
            //Calling constrcutor of CombineTable class
            CombineTable tableObj = new CombineTable();
            //set data for table 1
            tableObj.setDataTable1(dataDishName);
            //set data for table 2
            tableObj.setDataTable2(dataSauce);
            //set table Count
            tableObj.setTableCount(tableCount);
            //Combine table
            tableObj.setDataCombine();
            //get combined data
            this.data = tableObj.getDataCombine();
            //turn data to Object [] [] for JTable
            this.dataTable = to2dArray(this.data);
        }
    }
    //get Data for Jtable method
    public Object[][] getDataTable()
    {
        return this.dataTable;
    }
    //turning  ArrayList<ArrayList<String>> to Object [] [] method
    private Object[][] to2dArray(ArrayList<ArrayList<String>> data)
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
    //Main method for testing
    public static void main(String args[])
    {
        //declaring targeted table
        String targetTable = "Entree";
        //calling constructor 
        DataTable objDataTable = new DataTable(targetTable);
        //make data 
        objDataTable.setDataTable();
        //get and print data 
        Object[][] printData = objDataTable.getDataTable();
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }
        System.out.println(testData);
    }

}
