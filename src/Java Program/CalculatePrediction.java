/*
November 1st 2020
 * This class used to calculate the predicted ratio using methods of line of regression class
 */
//package internalassesment;

import java.util.ArrayList;

public class CalculatePrediction
{

    //Declareing attributes
    //Declareing ingredients
    private String ingredient;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;
    private String ingredient6;
    private String ingredient7;
    private String ingredient8;
    private String ingredient9;
    private double predictedRatio;
    //Number of ingredients there are
    private int ingredientCount;
    // Array List used to store ingredients
    private ArrayList<String> ingredientList;

    //Constructor 
    public CalculatePrediction()
    {
        this.ingredientList = new ArrayList<>();
    }

    //get first Ingredient Method
    public String getIngredient()
    {
        return ingredient;
    }

    //set first Ingredient Method
    public void setIngredient(String ingredient)
    {
        this.ingredient = ingredient;
    }

    //get second Ingredient Method
    public String getIngredient1()
    {
        return ingredient1;
    }

    //set second Ingredient Method
    public void setIngredient1(String ingredient1)
    {
        this.ingredient1 = ingredient1;
    }

    //get third Ingredient Method
    public String getIngredient2()
    {
        return ingredient2;
    }

    //set third Ingredient Method
    public void setIngredient2(String ingredient2)
    {
        this.ingredient2 = ingredient2;
    }

    //get fourth Ingredient Method
    public String getIngredient3()
    {
        return ingredient3;
    }

    //set fourth Ingredient Method
    public void setIngredient3(String ingredient3)
    {
        this.ingredient3 = ingredient3;
    }

    //get fith Ingredient Method
    public String getIngredient4()
    {
        return ingredient4;
    }

    //set fith Ingredient Method
    public void setIngredient4(String ingredient4)
    {
        this.ingredient4 = ingredient4;
    }

    //get sixth Ingredient Method
    public String getIngredient5()
    {
        return ingredient5;
    }

    //set sixth Ingredient Method
    public void setIngredient5(String ingredient5)
    {
        this.ingredient5 = ingredient5;
    }

    //get seventh Ingredient Method
    public String getIngredient6()
    {
        return ingredient6;
    }

    //set seventh Ingredient Method
    public void setIngredient6(String ingredient6)
    {
        this.ingredient6 = ingredient6;
    }

    //get eighth Ingredient Method
    public String getIngredient7()
    {
        return ingredient7;
    }

    //set eighth Ingredient Method
    public void setIngredient7(String ingredient7)
    {
        this.ingredient7 = ingredient7;
    }

    //get ninth Ingredient Method
    public String getIngredient8()
    {
        return ingredient8;
    }

    //set ninth Ingredient Method
    public void setIngredient8(String ingredient8)
    {
        this.ingredient8 = ingredient8;
    }

    //get tenth Ingredient Method
    public String getIngredient9()
    {
        return ingredient9;
    }

    //set tenth Ingredient Method
    public void setIngredient9(String ingredient9)
    {
        this.ingredient9 = ingredient9;
    }

    //get number of ingredients Method
    public int getIngredientCount()
    {
        return ingredientCount;
    }

    //set number of ingredients Method
    public void setIngredientCount(int ingredientCount)
    {
        this.ingredientCount = ingredientCount;
    }

    //set the ingredient List
    public void setIngredientList()
    {
        //if there are 1 ingredient
        if (ingredientCount == 1)
        {
            ingredientList.add(this.ingredient);
        } //if there are 2 ingredients
        else if (ingredientCount == 2)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
        } //if there are 3 ingredients
        else if (ingredientCount == 3)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
        } //if there are 4 ingredients
        else if (ingredientCount == 4)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
        } //if there are 5 ingredients
        else if (ingredientCount == 5)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
            ingredientList.add(this.ingredient4);
        } //if there are 6 ingredients
        else if (ingredientCount == 6)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
            ingredientList.add(this.ingredient4);
            ingredientList.add(this.ingredient5);
        } //if there are 7 ingredients
        else if (ingredientCount == 7)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
            ingredientList.add(this.ingredient4);
            ingredientList.add(this.ingredient5);
            ingredientList.add(this.ingredient6);
        } //if there are 8 ingredients
        else if (ingredientCount == 8)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
            ingredientList.add(this.ingredient4);
            ingredientList.add(this.ingredient5);
            ingredientList.add(this.ingredient6);
            ingredientList.add(this.ingredient7);
        } //if there are 9 ingredients
        else if (ingredientCount == 9)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
            ingredientList.add(this.ingredient4);
            ingredientList.add(this.ingredient5);
            ingredientList.add(this.ingredient6);
            ingredientList.add(this.ingredient7);
            ingredientList.add(this.ingredient8);
        } //if there are 10 ingredients
        else if (ingredientCount == 10)
        {
            ingredientList.add(this.ingredient);
            ingredientList.add(this.ingredient1);
            ingredientList.add(this.ingredient2);
            ingredientList.add(this.ingredient3);
            ingredientList.add(this.ingredient4);
            ingredientList.add(this.ingredient5);
            ingredientList.add(this.ingredient6);
            ingredientList.add(this.ingredient7);
            ingredientList.add(this.ingredient8);
            ingredientList.add(this.ingredient9);
        }
    }

    //get ingredient list method 
    public ArrayList<String> getIngredientList()
    {
        return this.ingredientList;
    }

    //Method to use Line of regression class to predict ratio outcome using entered ingredient
    public void setPredictedRatio()
    {
        try
        {
            //Declare object for LineOfRegression class
            LineOfRegression objRegression = new LineOfRegression();
            //Set ingredients list
            objRegression.setIngredientList(this.ingredientList);
            //calculate dish avergae 
            objRegression.setDishAvgSum();
            //Making data set X
            objRegression.setXSet();
            //Making data set Y
            objRegression.setYSet();
            //Getting data set X and Y
            Double[] xSet = objRegression.getXSet();
            Double[] ySet = objRegression.getYSet();
            //Calculate sumation of X*Y
            objRegression.setSumationXY(xSet, ySet);
            //Calculate sumation of X
            objRegression.setSumationX(xSet);
            //Calculate sumation of Y
            objRegression.setSumationY(ySet);
            //Calculate sumation of X^2
            objRegression.setSumationXsquared(xSet);
            //Calculate sumation of Y^2
            objRegression.setSumationYsquared(ySet);
            //Calculate the m slope and b intercept 
            objRegression.setLineOfRegression();
            //get the slope and the intercept of the line of regression as well as the x value (dish average)
            //m slope
            double slopeM = objRegression.getMSlope();
            //x value
            double dishAvgSum = objRegression.roundDouble(objRegression.getDishAvgSum(), 4);
            // b intercept
            double bIntercept = objRegression.getBIntercept();
            //calculate the predicted ratio (y value) 
            this.predictedRatio = (slopeM * dishAvgSum) + bIntercept;
            //y = mx +b
            //for testing purpose
//            System.out.println(slopeM);
//            System.out.println(dishAvgSum);
//            System.out.println(bIntercept);
        } catch (Exception exceptionObj)
        {
            SystemError objError = new SystemError("Something went wrong in the systen, please contact developer");
        }
    }
    //get predicted ratio method
    public double getPredictedRatio()
    {
        return this.predictedRatio;
    }

    //Method for testing
    public static void main(String args[])
    {
        CalculatePrediction objPredict = new CalculatePrediction();
        //Inputting ingredients
        objPredict.setIngredient("Grilled Chicken");
        objPredict.setIngredient2("Fried Rice");
        objPredict.setIngredient3("Fried Carrot");
        objPredict.setIngredient4("Fried Cucumber");
        objPredict.setIngredientCount(5);
        objPredict.setPredictedRatio();
        System.out.println(objPredict.getPredictedRatio());

    }
}
