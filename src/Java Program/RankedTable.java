/*
Spetember 25th 2020
 * This class retrieved ranked table
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class RankedTable
{

    private ArrayList<ArrayList<String>> data;
    private Object[][] dataTable;
    private String targetTable;

    // construct for creating new db
    public RankedTable()
    {
        this.data = new ArrayList<>();
    }

    public void setTargetTable(String targetTable)
    {
        this.targetTable = targetTable;
    }

    public ArrayList<ArrayList<String>> getData()
    {
        return data;
    }

    public Object[][] getDataTable()
    {
        return dataTable;
    }

    public String getTargetTable()
    {
        return targetTable;
    }

    public void setDataTable()
    {
        setData();
    }

    public void setData()
    {
        TableSorter objTableSorter = new TableSorter();
        //Dish Type Table ArrayList set data
        DishType type = new DishType();
        type.setDishTypeTable();
        ArrayList<ArrayList<String>> dataDishType = type.getDishTypeTable();
        //Dish Name Table ArrayList set data
        DishName name = new DishName();
        name.setDishNameTable();
        ArrayList<ArrayList<String>> dataDishName = name.getDishNameTable();
        //Ingredient Table ArrayList set data
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientTable();
        ArrayList<ArrayList<String>> dataIngredient = ingredient.getIngredientTable();
        dataIngredient = ingredient.CombineIngredient(dataIngredient);
        //Sauce table ArrayList set data
        Sauce sauce = new Sauce();
        sauce.setSauceTable();
        ArrayList<ArrayList<String>> dataSauce = sauce.getSauceTable();
        //ratio table Array List set data
        Ratio ratio = new Ratio();
        ratio.setData();
        ArrayList<ArrayList<Double>> intDataRatio = ratio.getData();
        ArrayList<ArrayList<String>> dataRatio = ratio.intToStringArray(intDataRatio);
        int tableCount;
        //Main table
        if (this.targetTable.equals("Main Table"))
        {
            int columnCount = 6;
            int ratioColumn = 6;
            tableCount = 5;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishType);
            tableObj.setDataTable2(dataDishName);
            tableObj.setDataTable3(dataIngredient);
            tableObj.setDataTable4(dataSauce);
            tableObj.setDataTable5(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Entree Table
        if (this.targetTable.equals("Entree"))
        {
            int columnCount = 6;
            int ratioColumn = 6;
            //get specific dish type table
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //Combine Table
            tableCount = 5;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishType);
            tableObj.setDataTable2(dataDishName);
            tableObj.setDataTable3(dataIngredient);
            tableObj.setDataTable4(dataSauce);
            tableObj.setDataTable5(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Salad Table
        if (this.targetTable.equals("Salad"))
        {
            int columnCount = 6;
            int ratioColumn = 6;
            //get specific dish type table
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //Combine Table
            tableCount = 5;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishType);
            tableObj.setDataTable2(dataDishName);
            tableObj.setDataTable3(dataIngredient);
            tableObj.setDataTable4(dataSauce);
            tableObj.setDataTable5(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Desert Table
        if (this.targetTable.equals("Desert"))
        {
            int columnCount = 6;
            int ratioColumn = 6;
            //get specific dish type table
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //Combine Table
            tableCount = 5;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishName);
            tableObj.setDataTable2(dataDishType);
            tableObj.setDataTable3(dataIngredient);
            tableObj.setDataTable4(dataSauce);
            tableObj.setDataTable5(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Fruit Table
        if (this.targetTable.equals("Fruit"))
        {
            int columnCount = 6;
            int ratioColumn = 6;
            //get specific dish type table
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //Combine Table
            tableCount = 5;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishName);
            tableObj.setDataTable2(dataDishType);
            tableObj.setDataTable3(dataIngredient);
            tableObj.setDataTable4(dataSauce);
            tableObj.setDataTable5(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Drink Table
        if (this.targetTable.equals("Drink"))
        {
            int columnCount = 6;
            int ratioColumn = 6;
            //get specific dish type table
            TypeTable entreeTable = new TypeTable(this.targetTable);
            entreeTable.setTypeTable();
            dataDishType = entreeTable.getTypeTable();
            //Combine Table
            tableCount = 5;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishName);
            tableObj.setDataTable2(dataDishType);
            tableObj.setDataTable3(dataIngredient);
            tableObj.setDataTable4(dataSauce);
            tableObj.setDataTable5(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Ingredient Table
        if (this.targetTable.equals("Ingredient"))
        {
            int columnCount = 4;
            int ratioColumn = 4;
            tableCount = 3;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishName);
            tableObj.setDataTable2(dataIngredient);
            tableObj.setDataTable3(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }
        //Sauce Table
        if (this.targetTable.equals("Sauce"))
        {
            int columnCount = 4;
            int ratioColumn = 4;
            tableCount = 3;
            CombineTable tableObj = new CombineTable();
            tableObj.setDataTable1(dataDishName);
            tableObj.setDataTable2(dataSauce);
            tableObj.setDataTable3(dataRatio);
            tableObj.setTableCount(tableCount);
            tableObj.setDataCombine();
            this.data = tableObj.getDataCombine();
            //Sorting Table
            objTableSorter.setRatioColumn(ratioColumn);
            objTableSorter.setColumnCount(columnCount);
            objTableSorter.setUnsortedData(this.data);
            objTableSorter.setSortedData();
            this.data = objTableSorter.getSortedData();
            this.dataTable = to2dArray(this.data);
        }

    }

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

    public ArrayList<ArrayList<String>> getrankedTable()
    {
        return this.data;
    }
    //Main Method for testing
    public static void main(String args[])
    {
        String targetTable = "Ingredient";
        RankedTable objRank = new RankedTable();
        objRank.setTargetTable(targetTable);
        objRank.setData();
        Object[][] printData = objRank.getDataTable();
        //Print Data
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }

    }
}
