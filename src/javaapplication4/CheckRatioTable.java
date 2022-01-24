/*
September 25th 2020
 * This ratio retrieve 2d array data that pass the user demanding in term of ratio
 */
//package internalassesment;

import java.util.ArrayList;

//Constructor 
public class CheckRatioTable
{

    //Declaring the attributes 
    //data that the class will return 
    private ArrayList<ArrayList<String>> data;
    //Object[] [] data that the class will return for displaying on JTable
    private Object[][] dataTable;
    //the targeted table or type of table reuqested 
    private String targetTable;
    //the requirement or requested ratio 
    private double checkRatio;

    //Constructor 
    public CheckRatioTable()
    {
        this.data = new ArrayList<>();
    }

    //get Check ratio Method 
    public double getCheckRatio()
    {
        return checkRatio;
    }

    //set Check ratio Method 
    public void setCheckRatio(double checkRatio)
    {
        this.checkRatio = checkRatio;
    }

    //set Targeted Table Method 
    public void setTargetTable(String targetTable)
    {
        this.targetTable = targetTable;
    }

    //get data Method (ArrayList<ArrayList<String>> form)
    public ArrayList<ArrayList<String>> getData()
    {
        return data;
    }

    //get data for JTable (Object[] [] form )
    public Object[][] getDataTable()
    {
        return dataTable;
    }

    //get targeted table Method
    public String getTargetTable()
    {
        return targetTable;
    }

    //set Data for Table with checked ratio 
    public void setDataTable()
    {
        setData();
    }

    //set Data for Table with checked ratio 
    public void setData()
    {
        //Calling object 
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
        //convert to data Ratio ArrayList<ArrayList<String>>
        ArrayList<ArrayList<String>> dataRatio = ratio.intToStringArray(intDataRatio);
        //declare table count
        int tableCount;
        //Main Table
        if (this.targetTable.equals("Main Table"))
        {
            try
            {
                //set table to count to 5 
                tableCount = 5;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 
                tableObj.setDataTable1(dataDishType);
                //setting data of table 2 (dishName data )
                tableObj.setDataTable2(dataDishName);
                //setting data of table 3 (ingredients data )
                tableObj.setDataTable3(dataIngredient);
                //setting data of table 4 (sauce data )
                tableObj.setDataTable4(dataSauce);
                //setting data of table 5 (ratio data )
                tableObj.setDataTable5(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 6;
                //Declare the location of the ratio column
                int ratioColumn = 6;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data 
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for main Table (CheckRatioTable class) ");
            }
        } //Entree Table
        else if (this.targetTable.equals("Entree"))
        {
            try
            {
                //get specific dish type table
                TypeTable entreeTable = new TypeTable(this.targetTable);
                entreeTable.setTypeTable();
                dataDishType = entreeTable.getTypeTable();
                //Combine Table
                tableCount = 5;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (specific type of data )
                tableObj.setDataTable1(dataDishType);
                //setting data of table 2 (dishName data )
                tableObj.setDataTable2(dataDishName);
                //setting data of table 3 (ingredients data )
                tableObj.setDataTable3(dataIngredient);
                //setting data of table 4 (sauce data )
                tableObj.setDataTable4(dataSauce);
                //setting data of table 5 (ratio data )
                tableObj.setDataTable5(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 6;
                //Declare the location of the ratio column
                int ratioColumn = 6;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data 
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for entree Table (CheckRatioTable class) ");
            }
        }
        //Salad Table
        if (this.targetTable.equals("Salad"))
        {
            try
            {
                //get specific dish type table
                TypeTable entreeTable = new TypeTable(this.targetTable);
                entreeTable.setTypeTable();
                dataDishType = entreeTable.getTypeTable();
                //Combine Table
                tableCount = 5;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (specific type of data )
                tableObj.setDataTable1(dataDishType);
                //setting data of table 2 (dishName data )
                tableObj.setDataTable2(dataDishName);
                //setting data of table 3 (ingredients data )
                tableObj.setDataTable3(dataIngredient);
                //setting data of table 4 (sauce data )
                tableObj.setDataTable4(dataSauce);
                //setting data of table 5 (ratio data )
                tableObj.setDataTable5(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 6;
                //Declare the location of the ratio column
                int ratioColumn = 6;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data 
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for salad Table (CheckRatioTable class) ");
            }
        } //Desert Table
        else if (this.targetTable.equals("Desert"))
        {
            try
            {
                //get specific dish type table
                TypeTable entreeTable = new TypeTable(this.targetTable);
                entreeTable.setTypeTable();
                dataDishType = entreeTable.getTypeTable();
                //Combine Table
                tableCount = 5;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (specific type of data )
                tableObj.setDataTable1(dataDishType);
                //setting data of table 2 (dishName data )
                tableObj.setDataTable2(dataDishName);
                //setting data of table 3 (ingredients data )
                tableObj.setDataTable3(dataIngredient);
                //setting data of table 4 (sauce data )
                tableObj.setDataTable4(dataSauce);
                //setting data of table 5 (ratio data )
                tableObj.setDataTable5(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 6;
                //Declare the location of the ratio column
                int ratioColumn = 6;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data 
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for desert Table (CheckRatioTable class) ");
            }
        } //Fruit Table
        else if (this.targetTable.equals("Fruit"))
        {
            try
            {
                //get specific dish type table
                TypeTable entreeTable = new TypeTable(this.targetTable);
                entreeTable.setTypeTable();
                dataDishType = entreeTable.getTypeTable();
                //Combine Table
                tableCount = 5;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (specific type of data )
                tableObj.setDataTable1(dataDishType);
                //setting data of table 2 (dishName data )
                tableObj.setDataTable2(dataDishName);
                //setting data of table 3 (ingredients data )
                tableObj.setDataTable3(dataIngredient);
                //setting data of table 4 (sauce data )
                tableObj.setDataTable4(dataSauce);
                //setting data of table 5 (ratio data )
                tableObj.setDataTable5(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 6;
                //Declare the location of the ratio column
                int ratioColumn = 6;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data 
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for fruit Table (CheckRatioTable class) ");
            }
        } //Drink Table
        else if (this.targetTable.equals("Drink"))
        {
            try
            {
                //get specific dish type table
                TypeTable entreeTable = new TypeTable(this.targetTable);
                entreeTable.setTypeTable();
                dataDishType = entreeTable.getTypeTable();
                //Combine Table
                tableCount = 5;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (specific type of data )
                tableObj.setDataTable1(dataDishType);
                //setting data of table 2 (dishName data )
                tableObj.setDataTable2(dataDishName);
                //setting data of table 3 (ingredients data )
                tableObj.setDataTable3(dataIngredient);
                //setting data of table 4 (sauce data )
                tableObj.setDataTable4(dataSauce);
                //setting data of table 5 (ratio data )
                tableObj.setDataTable5(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 6;
                //Declare the location of the ratio column
                int ratioColumn = 6;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data 
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for drink Table (CheckRatioTable class) ");
            }
        }
        //Ingredient Table
        if (this.targetTable.equals("Ingredient"))
        {
            try
            {
                //declare number of table
                tableCount = 3;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (dishName data )
                tableObj.setDataTable1(dataDishName);
                //setting data of table 2 (ingredient data )
                tableObj.setDataTable2(dataIngredient);
                //setting data of table 3 (ratio data )
                tableObj.setDataTable3(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 4;
                //Declare the location of the ratio column
                int ratioColumn = 4;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio 
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for ingredient Table (CheckRatioTable class) ");
            }

        } //Sauce Table
        else if (this.targetTable.equals("Sauce"))
        {
            try
            {
                //declare number of table
                tableCount = 3;
                //calling combine table class
                CombineTable tableObj = new CombineTable();
                //setting data of table 1 (dishName data )
                tableObj.setDataTable1(dataDishName);
                //setting data of table 2 (ingredient data )
                tableObj.setDataTable2(dataSauce);
                //setting data of table 3 (ratio data )
                tableObj.setDataTable3(dataRatio);
                //making data of combined data
                tableObj.setTableCount(tableCount);
                tableObj.setDataCombine();
                //get combined data Table
                this.data = tableObj.getDataCombine();
                //calling slection ratio class
                SelectTableRatio objSelect = new SelectTableRatio();
                //declare number of column
                int columnCount = 4;
                //Declare the location of the ratio column
                int ratioColumn = 4;
                //set the location of the ratio column
                objSelect.setRatioColumn(ratioColumn);
                //set the number of columns
                objSelect.setColumnCount(columnCount);
                //extract data that meet the checked ratio
                objSelect.setCheckRatio(this.checkRatio);
                objSelect.setUnSelectedData(this.data);
                objSelect.setSelectedData();
                //get the processed data
                this.data = objSelect.getSelectedData();
                //turn data into Object [] []
                this.dataTable = to2dArray(this.data);
            } //System print out error for tesing purpose and indetify where is the error
            catch (Exception exceptionObj)
            {
                System.out.println("Error in making data for sauce Table (CheckRatioTable class) ");
            }
        }

    }

    //Turn ArrayList<ArrayList<String>> to Object[][] method 
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
        //set targeted table
        String targetTable = "Main Table";
        //set targeted ratio
        double checkRatio = 0.0;
        //calling constructor
        CheckRatioTable objSelect = new CheckRatioTable();
        //set targeted table
        objSelect.setTargetTable(targetTable);
        //set checked table
        objSelect.setCheckRatio(checkRatio);
        //set the data
        objSelect.setData();
        //turn data to Object[][] to print
        Object[][] printData = objSelect.getDataTable();
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
