/*
This class sorted data in order according to their made and left over amount.
 */
//package internalassesment;

import java.util.ArrayList;

/**
 *
 * @author minhdaonguyen
 */
public class TableSorter
{

    private ArrayList<ArrayList<String>> unsortedData;
    private ArrayList<ArrayList<String>> sortedData;
    private int ratioColumn;
    private int columnCount;

    public TableSorter()
    {
        this.unsortedData = new ArrayList<>();
        this.sortedData = new ArrayList<>();
        this.ratioColumn = 0;
        this.columnCount = 0;
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public void setRatioColumn(int ratioColumn)
    {
        this.ratioColumn = ratioColumn;
    }

    public void setColumnCount(int columnCount)
    {
        this.columnCount = columnCount;
    }

    public int getRatioColumn()
    {
        return ratioColumn;
    }

    public ArrayList<ArrayList<String>> getUnsortedData()
    {
        return unsortedData;
    }

    public ArrayList<ArrayList<String>> getSortedData()
    {
        return sortedData;
    }

    public void setUnsortedData(ArrayList<ArrayList<String>> unsortedData)
    {
        this.unsortedData = unsortedData;
    }

    public void setSortedData()
    {
        ArrayList<ArrayList<Double>> ratioHolder = new ArrayList<>();
        // Exctract ratio and dish ID column
        for (int i = 0; i < this.unsortedData.size(); i++)
        {
            ArrayList<String> arrayUnSort = this.unsortedData.get(i);
            ArrayList<Double> temp = new ArrayList<>();
            double dishID = Double.parseDouble(arrayUnSort.get(0));
            double ratio = Double.parseDouble(arrayUnSort.get(this.ratioColumn - 1));

            temp.add(dishID);
            temp.add(ratio);
            ratioHolder.add(temp);
        }

        //Extract other column from array List
        ArrayList<ArrayList<String>> dataHolder = new ArrayList<>();
        if (this.columnCount == 3)
        {
            for (int i = 0; i < this.unsortedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unsortedData.get(i);
                ArrayList<String> temp = new ArrayList<>();
                String dishID = arrayUnSort.get(0);
                String column1 = arrayUnSort.get(1);
                temp.add(dishID);
                temp.add(column1);
                dataHolder.add(temp);
            }
        }
        //4 columns
        else if (this.columnCount == 4)
        {
            for (int i = 0; i < this.unsortedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unsortedData.get(i);
                ArrayList<String> temp = new ArrayList<>();
                String dishID = arrayUnSort.get(0);
                String column1 = arrayUnSort.get(1);
                String column2= arrayUnSort.get(2);
                temp.add(dishID);
                temp.add(column1);
                temp.add(column2);
                dataHolder.add(temp);
            }
            
        }
        //5 columns
        else if (this.columnCount == 5)
        {
            for (int i = 0; i < this.unsortedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unsortedData.get(i);
                ArrayList<String> temp = new ArrayList<>();
                String dishID = arrayUnSort.get(0);
                String column1 = arrayUnSort.get(1);
                String column2= arrayUnSort.get(2);
                String column3 = arrayUnSort.get(3);
                temp.add(dishID);
                temp.add(column1);
                temp.add(column2);
                temp.add(column3);
                dataHolder.add(temp);
            } 
        }
        //6 columns
        else if (this.columnCount == 6)
        {
            for (int i = 0; i < this.unsortedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unsortedData.get(i);
                ArrayList<String> temp = new ArrayList<>();
                String dishID = arrayUnSort.get(0);
                String column1 = arrayUnSort.get(1);
                String column2= arrayUnSort.get(2);
                String column3 = arrayUnSort.get(3);
                String column4 = arrayUnSort.get(4);
                temp.add(dishID);
                temp.add(column1);
                temp.add(column2);
                temp.add(column3);
                temp.add(column4);
                dataHolder.add(temp);
            } 
        }

        //Sorting Data
        DataSorter objSorter = new DataSorter();
        Ratio objRatio = new Ratio();
        objSorter.setUnsortedData(ratioHolder);
        objSorter.setSortedData();
        ArrayList<ArrayList<String>> sortedRatio = objRatio.intToStringArray(objSorter.getSortedData());
        
        //Combining Table back in order
        //3 columns
        if (columnCount == 3)
        {
            for (int i = 0; i < sortedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = sortedRatio.get(i);
                String dishID1 = ratioDishID.get(0);
                String ratio = ratioDishID.get(1);
                for (int y = 0; y < dataHolder.size(); y++)
                {
                    ArrayList<String> temp = new ArrayList<>();
                    ArrayList<String> unsortData = dataHolder.get(y);
                    String dishID2 = unsortData.get(0);
                    if (dishID1.equals(dishID2))
                    {
                        temp.add(dishID1);
                        temp.add(unsortData.get(1));
                        temp.add(ratio);
                        this.sortedData.add(temp);
                    }
                }
            }
        }
        //4 columns
        else if (columnCount == 4)
        {
            for (int i = 0; i < sortedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = sortedRatio.get(i);
                String dishID1 = ratioDishID.get(0);
                String ratio = ratioDishID.get(1);
                for (int y = 0; y < dataHolder.size(); y++)
                {
                    ArrayList<String> temp = new ArrayList<>();
                    ArrayList<String> unsortData = dataHolder.get(y);
                    String dishID2 = unsortData.get(0);
                    if (dishID1.equals(dishID2))
                    {
                        temp.add(dishID1);
                        temp.add(unsortData.get(1));
                        temp.add(unsortData.get(2));
                        temp.add(ratio);
                        this.sortedData.add(temp);
                    }
                }
            }
            
        }
        //5 columns
        else if (columnCount == 5)
        {
            for (int i = 0; i < sortedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = sortedRatio.get(i);
                String dishID1 = ratioDishID.get(0);
                String ratio = ratioDishID.get(1);
                for (int y = 0; y < dataHolder.size(); y++)
                {
                    ArrayList<String> temp = new ArrayList<>();
                    ArrayList<String> unsortData = dataHolder.get(y);
                    String dishID2 = unsortData.get(0);
                    if (dishID1.equals(dishID2))
                    {
                        temp.add(dishID1);
                        temp.add(unsortData.get(1));
                        temp.add(unsortData.get(2));
                        temp.add(unsortData.get(3));
                        temp.add(ratio);
                        this.sortedData.add(temp);
                    }
                }
            }
        }
        //6 columns
        else if (columnCount == 6)
        {
            for (int i = 0; i < sortedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = sortedRatio.get(i);
                String dishID1 = ratioDishID.get(0);
                String ratio = ratioDishID.get(1);
                for (int y = 0; y < dataHolder.size(); y++)
                {
                    ArrayList<String> temp = new ArrayList<>();
                    ArrayList<String> unsortData = dataHolder.get(y);
                    String dishID2 = unsortData.get(0);
                    if (dishID1.equals(dishID2))
                    {
                        temp.add(dishID1);
                        temp.add(unsortData.get(1));
                        temp.add(unsortData.get(2));
                        temp.add(unsortData.get(3));
                        temp.add(unsortData.get(4));
                        temp.add(ratio);
                        this.sortedData.add(temp);
                    }
                }
            }
        }
    }
    
    public static void main(String args[])
    {
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
        
        //SORTING TABLE
        JavaDatabase objDB = new JavaDatabase();
        TableSorter objTableSorter = new TableSorter();
        int columnCount = 6;
        int ratioColumn = 6; 
        objTableSorter.setRatioColumn(ratioColumn);
        objTableSorter.setColumnCount(columnCount);
        objTableSorter.setUnsortedData(table.getDataCombine());
        objTableSorter.setSortedData();
        Object[] [] printData = objDB.to2dArray(objTableSorter.getSortedData());
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }
    }

}
