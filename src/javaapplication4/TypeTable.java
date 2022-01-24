/*
Spetember 25th 2020
 * This class retirved specific type table that user ask.
 */
//package internalassesment;

import java.util.ArrayList;


public class TypeTable
{

    private String dishType;
    private ArrayList<ArrayList<String>> data;
    private ArrayList<ArrayList<String>> dishTypedata;
    public TypeTable(String dishType)
    {
        this.dishType = dishType;
        this.data = new ArrayList<>();
        this.dishTypedata = new ArrayList<>();
    }

    public void setTypeTable()
    {
       
        //Dish Type Table ArrayList set data
        DishType type = new DishType();
        type.setDishTypeTable();
        this.data = type.getDishTypeTable();

        if (this.dishType == "Entree")
        {
            String dishType;
            for (int i = 0; i < this.data.size(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<String> dataTemp = this.data.get(i);
                dishType = dataTemp.get(1);
                if (dishType.equals("Entree"))
                {
                    temp.add(dataTemp.get(0));
                    temp.add(dataTemp.get(1));

                    this.dishTypedata.add(temp);
                }
            }
        }
        else if (this.dishType == "Salad")
        {
            String dishType;
            for (int i = 0; i < this.data.size(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<String> dataTemp = this.data.get(i);
                dishType = dataTemp.get(1);
                if (dishType.equals("Salad"))
                {
                    temp.add(dataTemp.get(0));
                    temp.add(dataTemp.get(1));

                    this.dishTypedata.add(temp);
                }
            }
        }
        else if (this.dishType == "Desert")
        {
            String dishType;
            for (int i = 0; i < this.data.size(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<String> dataTemp = this.data.get(i);
                dishType = dataTemp.get(1);
                if (dishType.equals("Desert"))
                {
                    temp.add(dataTemp.get(0));
                    temp.add(dataTemp.get(1));

                    this.dishTypedata.add(temp);
                }
            }
        }
        else if (this.dishType == "Side")
        {
            String dishType;
            for (int i = 0; i < this.data.size(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<String> dataTemp = this.data.get(i);
                dishType = dataTemp.get(1);
                if (dishType.equals("Side"))
                        
                {
                    temp.add(dataTemp.get(0));
                    temp.add(dataTemp.get(1));

                    this.dishTypedata.add(temp);
                }
            }
        }
        else if (this.dishType == "Drink")
        {
            String dishType;
            for (int i = 0; i < this.data.size(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<String> dataTemp = this.data.get(i);
                dishType = dataTemp.get(1);
                if (dishType.equals("Drink"))
                {
                    temp.add(dataTemp.get(0));
                    temp.add(dataTemp.get(1));

                    this.dishTypedata.add(temp);
                }
            }
        }
        else  if (this.dishType == "Fruit")
        {
            String dishType;
            for (int i = 0; i < this.data.size(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<String> dataTemp = this.data.get(i);
                dishType = dataTemp.get(1);
                if (dishType.equals("Fruit"))
                {
                    temp.add(dataTemp.get(0));
                    temp.add(dataTemp.get(1));

                    this.dishTypedata.add(temp);
                }
            }
        }
    }
    public ArrayList<ArrayList<String>> getTypeTable()
    {
        return this.dishTypedata;
    }
    public static void main(String args[])
    {
        TypeTable entreeTable = new TypeTable("Entree");
        entreeTable.setTypeTable();
        ArrayList<ArrayList<String>> test = entreeTable.getTypeTable();
        JavaDatabase objDB = new JavaDatabase();
        Object[][] printData = objDB.to2dArray(test);
        for (int i = 0; i < printData.length; i++)
        {
            for (int j = 0; j < printData[i].length; j++)
            {
                System.out.println(printData[i][j]);
            }
        }
    }
}
