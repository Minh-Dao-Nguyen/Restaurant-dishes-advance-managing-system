/*
SepTember 25th 2020
This class return data that has meet a specific requirement from the user. 
 */
//package internalassesment;

import java.util.ArrayList;

public class SelectTableRatio
{
    private ArrayList<ArrayList<String>> unSelectedData;
    private ArrayList<ArrayList<String>> SelectedData;
    private int ratioColumn;
    private int columnCount;
    private double checkRatio; 

    public SelectTableRatio()
    {
        this.unSelectedData = new ArrayList<>();
        this.SelectedData = new ArrayList<>();
        this.ratioColumn = 0;
        this.columnCount = 0;
    }

    public double getCheckRatio()
    {
        return checkRatio;
    }

    public void setCheckRatio(double checkRatio)
    {
        this.checkRatio = checkRatio;
    }
    
    public ArrayList<ArrayList<String>> getUnSelctedData()
    {
        return unSelectedData;
    }

    public void setUnSelectedData(ArrayList<ArrayList<String>> unSelctedData)
    {
        this.unSelectedData = unSelctedData;
    }

    public ArrayList<ArrayList<String>> getSelectedData()
    {
        return SelectedData;
    }

    public int getRatioColumn()
    {
        return ratioColumn;
    }

    public void setRatioColumn(int ratioColumn)
    {
        this.ratioColumn = ratioColumn;
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public void setColumnCount(int columnCount)
    {
        this.columnCount = columnCount;
    }
    public void setSelectedData()
    {
        ArrayList<ArrayList<Double>> ratioHolder = new ArrayList<>();
        // Exctract ratio and dish ID column
        for (int i = 0; i < this.unSelectedData.size(); i++)
        {
            ArrayList<String> arrayUnSort = this.unSelectedData.get(i);
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
            for (int i = 0; i < this.unSelectedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unSelectedData.get(i);
                ArrayList<String> temp = new ArrayList<>();
                String dishID = arrayUnSort.get(0);
                String column1 = arrayUnSort.get(1);
                temp.add(dishID);
                temp.add(column1);
                dataHolder.add(temp);
            }
        }
        else if (this.columnCount == 4)
        {
            for (int i = 0; i < this.unSelectedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unSelectedData.get(i);
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
        else if (this.columnCount == 5)
        {
            for (int i = 0; i < this.unSelectedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unSelectedData.get(i);
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
        else if (this.columnCount == 6)
        {
            for (int i = 0; i < this.unSelectedData.size(); i++)
            {
                ArrayList<String> arrayUnSort = this.unSelectedData.get(i);
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

        //Selection DATA from ARRAY LISt
        Ratio objRatio = new Ratio();
        objRatio.setCheckRatio(this.checkRatio);
        objRatio.setDataChecked();
        ArrayList<ArrayList<Double>> doubleSelectedRatio = objRatio.getDataChecked();
        ArrayList<ArrayList<String>> selectedRatio = objRatio.intToStringArray(doubleSelectedRatio);
        
        //Combining Table back in order
        if (columnCount == 3)
        {
            for (int i = 0; i < selectedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = selectedRatio.get(i);
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
                        this.SelectedData.add(temp);
                    }
                }
            }
        }
        else if (columnCount == 4)
        {
            for (int i = 0; i < selectedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = selectedRatio.get(i);
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
                        this.SelectedData.add(temp);
                    }
                }
            }
            
        }
        else if (columnCount == 5)
        {
            for (int i = 0; i < selectedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = selectedRatio.get(i);
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
                        this.SelectedData.add(temp);
                    }
                }
            }
        }
        else if (columnCount == 6)
        {
            for (int i = 0; i < selectedRatio.size(); i++)
            {
                ArrayList<String> ratioDishID = selectedRatio.get(i);
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
                        this.SelectedData.add(temp);
                    }
                }
            }
        }
    }
    //main method for testing
    public static void main(String ags[])
    {
        CombineTable table = new CombineTable();
        //Dish Type Table ArrayList set data
        DishType type = new DishType();
        type.setDishTypeTable();
        ArrayList<ArrayList<String>> dataDishType = type.getDishTypeTable();
//        TypeTable entreeTable = new TypeTable("Entree");
//        entreeTable.setTypeTable();
//        dataDishType = entreeTable.getTypeTable();
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
        
        //Selecting Data
        SelectTableRatio objSelect = new SelectTableRatio();
        JavaDatabase objDB = new JavaDatabase();
        double checkRatio = 0.5;
        int columnCount = 6;
        int ratioColumn = 6; 
        objSelect.setRatioColumn(ratioColumn);
        objSelect.setColumnCount(columnCount);
        objSelect.setCheckRatio(checkRatio);
        objSelect.setUnSelectedData(table.getDataCombine());
        objSelect.setSelectedData();
        Object[] [] printData = objDB.to2dArray(objSelect.getSelectedData());
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }
    }

    
}
