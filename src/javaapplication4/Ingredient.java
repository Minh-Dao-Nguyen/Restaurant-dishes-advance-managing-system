/*
September 24th 2020
 * This class includes all methods use to extract and manpulate data from ingredientTable
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ingredient
{

    private String ingredient;
    private int dishID;
    private ArrayList<ArrayList<String>> data;
    private ArrayList<ArrayList<String>> combineData;
    private ArrayList<ArrayList<String>> allIngredientName;

    public Ingredient()
    {
        this.ingredient = "";
        this.dishID = 0;
        this.data = new ArrayList<>();
        this.combineData = new ArrayList<>();
        this.allIngredientName = new ArrayList<>();
    }

    public Ingredient(int DishID, String ingredient)
    {
        this.dishID = DishID;
        this.ingredient = ingredient;
    }

    public void setDishID(int dishID)
    {
        this.dishID = dishID;
    }

    public void setIngredient(String ingredient)
    {
        this.ingredient = ingredient;
    }

    public int getDishID()
    {
        return this.dishID;
    }

    public String getIngredient()
    {
        return this.ingredient;
    }

    public void setIngredientTable()
    {
        //established connection with Database using JavaDatabaseclass
        JavaDatabase objDB = new JavaDatabase("CUISINES");
        objDB.setDbConn();
        Connection dbConn = objDB.getDbConn();
        Statement st;
        ResultSet rs;

        try
        {

            st = dbConn.createStatement();
            rs = st.executeQuery("SELECT * FROM Ingredient");

            while (rs.next())
            {
                Ingredient dish = new Ingredient();
                dish.setDishID(rs.getInt(1));
                dish.setIngredient(rs.getString(2));

                ArrayList<String> temp = new ArrayList<>();
                temp.add(Integer.toString(dish.getDishID()));
                temp.add(dish.getIngredient());
                this.data.add(temp);

            }

        } catch (SQLException ex)
        {
            Logger.getLogger(DishName.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ArrayList<String>> getIngredientTable()
    {
        return this.data;
    }

    public ArrayList<ArrayList<String>> CombineIngredient(ArrayList<ArrayList<String>> data)
    {
        String check = "";
        boolean repeat = false;
        boolean singleData = false;
        int lastIndex = this.data.size() - 1;

        for (int i = 0; i < this.data.size(); i++)
        {
            singleData = false;
            ArrayList<String> temp = new ArrayList<>();
            ArrayList<String> var1 = data.get(i);
            String dishID1 = var1.get(0);
            String ingredient = var1.get(1);
            String combine = var1.get(1);
            for (int y = +i; y < this.data.size(); y++)
            {
                ArrayList<String> var2 = data.get(y);
                repeat = false;
                for (int z = 0; z < this.combineData.size(); z++)
                {
                    ArrayList<String> var4 = this.combineData.get(z);
                    if (var2.get(0).equals(var4.get(0)))
                    {
                        repeat = true;
                        break;
                    }
                }
                if (repeat == true)
                {
                    break;
                } else if (var1.get(0).equals(var2.get(0)) && i != lastIndex)
                {
                    combine = combine + ", " + var2.get(1);
                    check = var2.get(1);
                } else
                {
                    singleData = true;
                }
            }
            if (!ingredient.equals(check) && repeat == false)
            {
                temp.add(dishID1);
                temp.add(combine);
                this.combineData.add(temp);
            } else if (singleData == true)
            {
                ArrayList<String> var5 = data.get(i);
                String dishID = var5.get(0);
                String single = var5.get(1);
                temp.add(dishID);
                temp.add(single);
                this.combineData.add(temp);
            } else if (i == lastIndex && repeat == false)
            {
                    temp.add(dishID1);
                    temp.add(combine);
                    this.combineData.add(temp);
            }
        }

        return this.combineData;
    }

    public ArrayList<ArrayList<String>> getAllIngredientName()
    {
        boolean repeat;
        for (int i = 0; i < this.data.size(); i++)
        {
            ArrayList<String> temp = new ArrayList<>();
            ArrayList<String> var1 = data.get(i);
            String ingredientName = var1.get(1);
            repeat = false;
            for (int z = 0; z < this.allIngredientName.size(); z++)
            {
                ArrayList<String> var2 = this.allIngredientName.get(z);
                if (ingredientName.equals(var2.get(0)))
                {
                    repeat = true;
                    break;
                }
            }
            if (repeat == true)
            {
                //Do nothing because the data already existed
            }
            if (ingredientName.equals(""))
            {
                //Do nothing because there are no ingredient for this dish
            } else
            {
                temp.add(ingredientName);
                this.allIngredientName.add(temp);
            }

        }
        return this.allIngredientName;
    }

    public static void main(String args[])
    {
        Ingredient ingredeintOBJ = new Ingredient();
        ingredeintOBJ.setIngredientTable();
        ArrayList<ArrayList<String>> Test = ingredeintOBJ.getIngredientTable();
        ArrayList<ArrayList<String>> Test2 = ingredeintOBJ.CombineIngredient(Test);
        JavaDatabase objDB = new JavaDatabase();
        Object[][] data1 = objDB.to2dArray(Test);
        Object[][] data2 = objDB.to2dArray(Test2);

        for (int i = 0; i < data1.length; i++)
        {
            for (int j = 0; j < data1[i].length; j++)
            {
                System.out.println(data1[i][j]);
            }
        }
        for (int i = 0; i < data2.length; i++)
        {
            for (int j = 0; j < data2[i].length; j++)
            {
                System.out.println(data2[i][j]);
            }
        }

    }
}
