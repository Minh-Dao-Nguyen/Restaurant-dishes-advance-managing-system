/*
September 20th 2020
 * This class combine tables or Array List togther
*Note:
- The data for the first table has to be a processed data or selected data if there is any. 
- The data fot the first table will have the shortest data length. 
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CombineTable
{
    //declaring attributes 
    //data of combined data
    private ArrayList<ArrayList<String>> dataCombine;
    //data of table 1
    private ArrayList<ArrayList<String>> dataTable1;
    //data of table 2
    private ArrayList<ArrayList<String>> dataTable2;
    //data of table 3
    private ArrayList<ArrayList<String>> dataTable3;
    //data of table 4
    private ArrayList<ArrayList<String>> dataTable4;
    //data of table 5
    private ArrayList<ArrayList<String>> dataTable5;
    //number of table there are
    private int tableCount;

    //Constructor 
    public CombineTable()
    {
        //making the ArrayList
        //data of combined data
        this.dataCombine = new ArrayList<>();
        //data of table 1
        this.dataTable1 = new ArrayList<>();
        //data of table 2
        this.dataTable2 = new ArrayList<>();
        //data of table 3
        this.dataTable3 = new ArrayList<>();
        //data of table 4
        this.dataTable4 = new ArrayList<>();
        //data of table 5
        this.dataTable5 = new ArrayList<>();
    }
    //set data for data of table 1
    public void setDataTable1(ArrayList<ArrayList<String>> dataTable1)
    {
        this.dataTable1 = dataTable1;
    }
    //set data for data of table 2
    public void setDataTable2(ArrayList<ArrayList<String>> dataTable2)
    {
        this.dataTable2 = dataTable2;
    }
    //set data for data of table 3
    public void setDataTable3(ArrayList<ArrayList<String>> dataTable3)
    {
        this.dataTable3 = dataTable3;
    }
    //set data for data of table 4
    public void setDataTable4(ArrayList<ArrayList<String>> dataTable4)
    {
        this.dataTable4 = dataTable4;
    }
    //set data for data of table 5
    public void setDataTable5(ArrayList<ArrayList<String>> dataTable5)
    {
        this.dataTable5 = dataTable5;
    }
    //set the number of tables there are 
    public void setTableCount(int tableCount)
    {
        this.tableCount = tableCount;
    }
    //get data of combined table
    public ArrayList<ArrayList<String>> getDataCombine()
    {
        return dataCombine;
    }
    //get data of table 1
    public ArrayList<ArrayList<String>> getDataTable1()
    {
        return dataTable1;
    }
    //get data of table 1
    public ArrayList<ArrayList<String>> getDataTable2()
    {
        return dataTable2;
    }
    //get data of table 1
    public ArrayList<ArrayList<String>> getDataTable3()
    {
        return dataTable3;
    }
    //get data of table 1
    public ArrayList<ArrayList<String>> getDataTable4()
    {
        return dataTable4;
    }
    //get data of table 1
    public ArrayList<ArrayList<String>> getDataTable5()
    {
        return dataTable5;
    }
    //get data of table 1
    public int getTableCount()
    {
        return tableCount;
    }
    //making the comibined table
    public void setDataCombine()
    {
        // initialize data holder and Arraylist 
        //dish ID for tabel 1
        String dishID1;
        //dish ID for tabel 2
        String dishID2;
        //dish ID for tabel 3
        String dishID3;
        //dish ID for tabel 4
        String dishID4;
        //dish ID for tabel 5
        String dishID5;

        //Array List of Table 1
        ArrayList<ArrayList<String>> table1Temp = this.dataTable1;
        //Array List of Table 2
        ArrayList<ArrayList<String>> table2Temp = this.dataTable2;
        //Array List of Table 3
        ArrayList<ArrayList<String>> table3Temp = this.dataTable3;
        //Array List of Table 4
        ArrayList<ArrayList<String>> table4Temp = this.dataTable4;
        //Array List for Table 5
        ArrayList<ArrayList<String>> table5Temp = this.dataTable5;

        // Combinding Table
        //combinging 2 tables
        if (this.tableCount == 2)
        {
            for (int i = 0; i < table1Temp.size(); i++)
            {
                //declaring temporary Object to hold data 
                ArrayList<String> temp = new ArrayList();
                //get dish ID for table 1
                ArrayList<String> var1 = table1Temp.get(i);
                dishID1 = var1.get(0);
                //checking for the rest of the data of the second table
                for (int y = 0; y < table2Temp.size(); y++)
                {
                    //getting dish ID of second table
                    ArrayList<String> var2 = table2Temp.get(y);
                    dishID2 = var2.get(0);
                    //if they both table have a row with the same dish id in dishID column
                    if (dishID1.equals(dishID2))
                    {
                        //adding dish ID
                        temp.add(dishID1);
                        //adding column of table 1 
                        temp.add(var1.get(1));
                        //adding column of table 2
                        temp.add(var2.get(1));
                        //add to object to array list
                        this.dataCombine.add(temp);
                    }
                }
            }

        } 
        //combining 3 tables
        else if (this.tableCount == 3)
        {
            for (int i = 0; i < table1Temp.size(); i++)
            {
                //declaring temporary Object to hold data
                ArrayList<String> temp = new ArrayList();
                //get dish ID for table 1
                ArrayList<String> var1 = table1Temp.get(i);
                dishID1 = var1.get(0);
                //checking for the rest of the data of the second and third
                for (int y = 0; y < table2Temp.size(); y++)
                {
                    //get dish ID for table 2
                    ArrayList<String> var2 = table2Temp.get(y);
                    dishID2 = var2.get(0);
                    //get dish ID for table 3
                    ArrayList<String> var3 = table3Temp.get(y);
                    dishID3 = var3.get(0);
                    //if all three tables have a row with the same dish id in dishID column
                    if (dishID1.equals(dishID2) && dishID1.equals(dishID3))
                    {
                        //adding dish ID
                        temp.add(dishID1);
                        //adding column of table 1 
                        temp.add(var1.get(1));
                        //adding column of table 2
                        temp.add(var2.get(1));
                        //adding column of table 3 
                        temp.add(var3.get(1));
                        //add to object to array list
                        this.dataCombine.add(temp);
                    }
                }
            }

        } 
        //Combining 4 tables
        else if (this.tableCount == 4)
        {

            for (int i = 0; i < table1Temp.size(); i++)
            {
                //declaring temporary Object to hold data
                ArrayList<String> temp = new ArrayList();
                //get dish ID for table 1
                ArrayList<String> var1 = table1Temp.get(i);
                dishID1 = var1.get(0);
                //checking for the rest of the data of the second and third and fourth 
                for (int y = 0; y < table2Temp.size(); y++)
                {
                    //get dish ID for table 2
                    ArrayList<String> var2 = table2Temp.get(y);
                    dishID2 = var2.get(0);
                    //get dish ID for table 3
                    ArrayList<String> var3 = table3Temp.get(y);
                    dishID3 = var3.get(0);
                    //get dish ID for table 4
                    ArrayList<String> var4 = table4Temp.get(y);
                    dishID4 = var4.get(0);
                    //if all four tables have a row with the same dish id in dishID column
                    if (dishID1.equals(dishID2) && dishID1.equals(dishID3) && dishID1.equals(dishID4))
                    {
                        //adding dishID
                        temp.add(dishID1);
                        //adding column of table 1 
                        temp.add(var1.get(1));
                        //adding column of table 2 
                        temp.add(var2.get(1));
                        //adding column of table 3 
                        temp.add(var3.get(1));
                        //adding column of table 4 
                        temp.add(var4.get(1));
                        //adding to Array List
                        this.dataCombine.add(temp);
                    }
                }

            }

        } 
        //Combining 5 tables 
        else if (this.tableCount == 5)
        {
            for (int i = 0; i < table1Temp.size(); i++)
            {
                //declaring temporary Object to hold data
                ArrayList<String> temp = new ArrayList();
                //get dish ID for table 1
                ArrayList<String> var1 = table1Temp.get(i);
                dishID1 = var1.get(0);
                //checking for the rest of the data of the second and third and fourth and fifth 
                for (int y = 0; y < table2Temp.size(); y++)
                {
                    //get dish ID for table 2
                    ArrayList<String> var2 = table2Temp.get(y);
                    dishID2 = var2.get(0);
                    //get dish ID for table 3
                    ArrayList<String> var3 = table3Temp.get(y);
                    dishID3 = var3.get(0);
                    //get dish ID for table 4
                    ArrayList<String> var4 = table4Temp.get(y);
                    dishID4 = var4.get(0);
                    //get dish ID for table 5
                    ArrayList<String> var5 = table5Temp.get(y);
                    dishID5 = var5.get(0);
                    //if all five tables have a row with the same dish id in dishID column
                    if (dishID1.equals(dishID2) && dishID1.equals(dishID3) && dishID1.equals(dishID4)
                            && dishID1.equals(dishID5))
                    {
                        //adding dishID
                        temp.add(dishID1);
                        //adding column of table 1 
                        temp.add(var1.get(1));
                        //adding column of table 2 
                        temp.add(var2.get(1));
                        //adding column of table 3 
                        temp.add(var3.get(1));
                        //adding column of table 4 
                        temp.add(var4.get(1));
                        //adding column of table 5 
                        temp.add(var5.get(1));
                        //adding to Array List
                        this.dataCombine.add(temp);
                    }
                }
            }
        }
    }
    //Get data for Table (ArrayList<ArrayList<String>>)
    public ArrayList<ArrayList<String>> getTableData()
    {
        return this.dataCombine;
    }
    //Main method for testing
    public static void main(String args[])
    {
        //calling constuctor 
        CombineTable table = new CombineTable();
        //Dish Type Table ArrayList set data
        DishType type = new DishType();
        type.setDishTypeTable();
        ArrayList<ArrayList<String>> dataDishType = type.getDishTypeTable();
        TypeTable entreeTable = new TypeTable("Entree");
        entreeTable.setTypeTable();
        dataDishType = entreeTable.getTypeTable();
        table.setDataTable1(dataDishType);
        //Dish Name Table ArrayList set data
        DishName name = new DishName();
        name.setDishNameTable();
        ArrayList<ArrayList<String>> dataDishName = name.getDishNameTable();
        table.setDataTable2(dataDishName);
        //Ingredient Table ArrayList set data
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientTable();
        ArrayList<ArrayList<String>> dataIngredient = ingredient.getIngredientTable();
        dataIngredient = ingredient.CombineIngredient(dataIngredient);
        table.setDataTable3(dataIngredient);
        //Sauce table ArrayList set data
        Sauce sauce = new Sauce();
        sauce.setSauceTable();
        ArrayList<ArrayList<String>> dataSauce = sauce.getSauceTable();
        table.setDataTable4(dataSauce);
        //ratio table Array List set data
        Ratio ratio = new Ratio();
        ratio.setData();
        ArrayList<ArrayList<Double>> intDataRatio = ratio.getData();
        ArrayList<ArrayList<String>> dataRatio = ratio.intToStringArray(intDataRatio);
        table.setDataTable5(dataRatio);
        //set combine data
        int tableCount = 5;
        table.setTableCount(tableCount);
        table.setDataCombine();
        //Get data and print data
        ArrayList<ArrayList<String>> data = table.getTableData();
        JavaDatabase objDB = new JavaDatabase();
        Object[][] printData = objDB.to2dArray(data);
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }
    }
}
