/*
September 30th 2020
 * This frame calculate the line of regression from user input
 */
//package internalassesment;

import java.util.ArrayList;

/*
 y = mx+ b

x -axis : the avergae sum of ingredient dish 
y - axis : the ratio
 */
public class LineOfRegression
{

    private Double[] ySet;
    private Double[] xSet;
    private ArrayList<String> ingredientList;
    private ArrayList<ArrayList<String>> dataIngredient;
    private ArrayList<ArrayList<String>> dataDishName;
    private ArrayList<ArrayList<Double>> dataRatioInt;
    private String ingredientName;
    private double ingredientAvgSum;
    private double dishAvgSum;
    private double mSlope;
    private double bIntercept;
    private double sumationXY;
    private double sumationX;
    private double sumationY;
    private double sumationXsquared;
    private double sumationYsquared;

    public LineOfRegression()
    {
        this.dataDishName = new ArrayList<>();
        this.dataRatioInt = new ArrayList<>();
        this.ingredientList = new ArrayList<>();
        ingredientAvgSum = 0;
        dishAvgSum = 0;
        mSlope = 0;
        bIntercept = 0;
        sumationXY = 0;
        sumationX = 0;
        sumationY = 0;
        sumationXsquared = 0;
        sumationYsquared = 0;
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientTable();
        this.dataIngredient = ingredient.getIngredientTable();
        //get data from DishName Table 
        DishName name = new DishName();
        name.setDishNameTable();
        ArrayList<ArrayList<String>> dataDishNameTemp = name.getDishNameTable();
        //Get Dish Name and ID of Entree only 
        TypeTable entreeTable = new TypeTable("Entree");
        entreeTable.setTypeTable();
        ArrayList<ArrayList<String>> dataDishType = entreeTable.getTypeTable();
        //Combine Table
        int tableCount = 2;
        CombineTable tableObj = new CombineTable();
        tableObj.setTableCount(tableCount);
        tableObj.setDataTable1(dataDishType);
        tableObj.setDataTable2(dataDishNameTemp);
        //Get the data with Entree only 
        tableObj.setDataCombine();
        ArrayList<ArrayList<String>> data = tableObj.getDataCombine();
        //Etract dish name and dishID data only 
        for (int i = 0; i < data.size(); i++)
        {
            ArrayList<String> temp1 = data.get(i);
            String dishID = temp1.get(0);
            String dishName = temp1.get(2);
            ArrayList<String> temp2 = new ArrayList();
            temp2.add(dishID);
            temp2.add(dishName);
            dataDishName.add(temp2);
        }
        //Get ratio table with entree type only
        Ratio ratio = new Ratio();
        ratio.setData();
        ArrayList<ArrayList<Double>> intDataRatio = ratio.getData();
        ArrayList<ArrayList<String>> dataRatio = ratio.intToStringArray(intDataRatio);
        //Combine Table
        CombineTable tableObj2 = new CombineTable();
        tableObj2.setTableCount(tableCount);
        tableObj2.setDataTable1(dataDishType);
        tableObj2.setDataTable2(dataRatio);
        //Get the data with Entree only 
        tableObj2.setDataCombine();
        ArrayList<ArrayList<String>> data2 = tableObj2.getDataCombine();
        //Etract ratio and dishID data only 
        for (int i = 0; i < data2.size(); i++)
        {
            ArrayList<String> temp1 = data2.get(i);
            String dishIDtemp = temp1.get(0);
            String ratio1temp = temp1.get(2);
            //Turn into double
            double dishID = Double.parseDouble(dishIDtemp);
            double ratio1 = Double.parseDouble(ratio1temp);
            ArrayList<Double> temp2 = new ArrayList();
            temp2.add(dishID);
            temp2.add(ratio1);
            //Add to array list
            dataRatioInt.add(temp2);
        }

    }

    //Calculate line of regression
    public void setLineOfRegression()
    {
        //Limit the digit first to avoid getting infinity 
        this.sumationX = roundDouble(sumationX, 8);
        this.sumationX = roundDouble(sumationXY, 8);
        this.sumationX = roundDouble(sumationXsquared, 8);
        this.sumationX = roundDouble(sumationY, 8);

        //y = mx +b
        //calculate slope m
        this.mSlope = roundDouble(
                (((this.ingredientList.size()) * this.sumationXY) - (this.sumationX * this.sumationY))
                / ((this.ingredientList.size()) * this.sumationXsquared) - (this.sumationX * this.sumationX),
                4);
        //Calculate intercept b 
        this.bIntercept = roundDouble(((this.sumationY) - (this.mSlope * this.sumationX)) / (this.ingredientList.size()), 4);

    }

    // Calculate M slope
    public double getMSlope()
    {
        return this.mSlope;
    }

    //Calculate b intercept or y intercept
    public double getBIntercept()
    {
        return this.bIntercept;
    }

    //calculate dish average sum 
    public void setDishAvgSum()
    {
        for (int i = 0; i < ingredientList.size(); i++)
        {
            String ingredient = ingredientList.get(i);
            setIngredientName(ingredient);
            setIngredientAvg();
            double ratio = getIngredientAvg();
            this.dishAvgSum = ratio + this.dishAvgSum;
        }

    }

    //get dish average sum
    public double getDishAvgSum()
    {
        return this.dishAvgSum;
    }

    //get set of y value 
    public Double[] getYSet()
    {
        return ySet;
    }

    // make y set value
    public void setYSet()
    {
        try
        {
            ySet = new Double[dataDishName.size()];
            for (int i = 0; i < dataDishName.size(); i++)
            {
                ArrayList<String> dishTemp = dataDishName.get(i);
                String dishID1 = dishTemp.get(0);
                ArrayList<Double> ratiotemp = dataRatioInt.get(i);
                String dishID2 = Integer.toString((int) Math.round(ratiotemp.get(0)));
                if (dishID1.equals(dishID2))
                {
                    if (ratiotemp.get(1) != 1000.0)
                    {
                        this.ySet[i] = ratiotemp.get(1);
                    }
                }
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in y Set");
        }

    }

    //get set of x value
    public Double[] getXSet()
    {
        return xSet;
    }

    //make x set value
    public void setXSet()
    {
        boolean noRatio;
        try
        {
            //Dish Name Table ArrayList
            xSet = new Double[dataDishName.size()];
            for (int i = 0; i < dataDishName.size(); i++)
            {
                noRatio = false;
                ArrayList<String> ingredientList = new ArrayList<>();
                ArrayList<String> dishTemp = dataDishName.get(i);

                String dishID1 = dishTemp.get(0);
                //check to see if there is ratio
                for (int z = 0; z < dataRatioInt.size(); z++)
                {
                    ArrayList<Double> dishRatio = dataRatioInt.get(i);
                    String dishID2 = Integer.toString((int) Math.round(dishRatio.get(0)));
                    int ratioCheck = (int) Math.round(dishRatio.get(1));
                    if (dishID1.equals(dishID2) && ratioCheck == 1000)
                    {
                        noRatio = true;
                    }

                }
                //Scan make ingrdient List for that dish
                if (noRatio == false)
                {
                    for (int y = 0; y < dataIngredient.size(); y++)
                    {
                        ArrayList<String> ingredientTemp = dataIngredient.get(y);
                        String dishID3 = ingredientTemp.get(0);
                        if (dishID1.equals(dishID3))
                        {
                            ingredientList.add(ingredientTemp.get(1));
                        }
                    }
                }

                //Calculate dish average sum
                setIngredientList(ingredientList);

                setDishAvgSum();
                //add to data set x
                this.xSet[i] = getDishAvgSum();
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in X set");
        }
    }

    //get ingredient list 
    public ArrayList<String> getIngredientList()
    {
        return ingredientList;
    }

    //set ingredient list
    public void setIngredientList(ArrayList<String> ingredientList)
    {
        this.ingredientList = ingredientList;
    }

    //set ingredient name
    public void setIngredientName(String ingredientName)
    {
        this.ingredientName = ingredientName;
    }

    // calculate ingredient average 
    public void setIngredientAvg()
    {
        try
        {
            ArrayList<Double> ratioHolder = new ArrayList<>();
            for (int i = 0; i < dataIngredient.size(); i++)
            {
                ArrayList<String> arrayIngredient = dataIngredient.get(i);
                String dishID1 = arrayIngredient.get(0);
                String ingredient = arrayIngredient.get(1);
                if (ingredient.equals(this.ingredientName))
                {
                    for (int y = 0; y < dataRatioInt.size(); y++)
                    {
                        ArrayList<Double> arrayRatio = dataRatioInt.get(y);
                        String dishID2 = Integer.toString((int) Math.round(arrayRatio.get(0)));
                        double ratio = arrayRatio.get(1);
                        if (dishID1.equals(dishID2))
                        {
                            if (1000.0 != arrayRatio.get(1))
                            {
                                ratioHolder.add(ratio);
                                break;
                            }
                        }
                    }
                }
            }
            Double[] ratioSet = new Double[ratioHolder.size()];
            for (int i = 0; i < ratioHolder.size(); i++)
            {
                double ratio = ratioHolder.get(i);

                ratioSet[i] = ratio;

            }
            if (Double.isNaN(CalculateAvg(ratioSet)) == false)
            {
                this.ingredientAvgSum = CalculateAvg(ratioSet);
            }

        } catch (Exception exceptionObj)
        {
            System.out.println("Error in ingredient average");
        }
    }

    //get ingredient average
    public double getIngredientAvg()
    {
        return this.ingredientAvgSum;
    }

    public double CalculateAvg(Double[] dataSet)
    {
        double average = 0;
        double sum = 0;
        //Calculate sum
        for (int i = 0; i < dataSet.length; i++)
        {
            sum = dataSet[i] + sum;
        }
        //Calculate average
        average = (sum) / (int) (dataSet.length);
        //Return data
        return average;
    }

    //Calculate sumation of x*y
    public void setSumationXY(Double[] xSet, Double[] ySet)
    {
        try
        {
            Double[] xySet = new Double[xSet.length];
            //Caculate xy set
            for (int i = 0; i < ySet.length; i++)
            {
                double var1 = xSet[i];
                double var2 = ySet[i];
                xySet[i] = var1 * var2;
            }
            //Calculate sumation of xy set
            for (int i = 0; i < ySet.length; i++)
            {
                this.sumationXY = this.sumationXY + xySet[i];
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in sumation of x*y");
        }
    }

    //Calculate sumation of x
    public void setSumationX(Double[] xSet)
    {
        try
        {
            for (int i = 0; i < xSet.length; i++)
            {
                this.sumationX = xSet[i] + this.sumationX;
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in sumation of x");
        }
    }

    //Calculate sumation of y
    public void setSumationY(Double[] ySet)
    {
        try
        {
            for (int i = 0; i < ySet.length; i++)
            {
                this.sumationY = ySet[i] + this.sumationY;
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in sumation of y");
        }
    }

    //Calculate sumation of x^2  
    public void setSumationXsquared(Double[] xSet)
    {
        try
        {
            Double[] xSetsquared = new Double[xSet.length];
            for (int i = 0; i < xSet.length; i++)
            {
                xSetsquared[i] = xSet[i] * xSet[i];
            }
            for (int i = 0; i < xSetsquared.length; i++)
            {
                this.sumationXsquared = xSetsquared[i] + this.sumationXsquared;
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in sumation of x^2");
        }
    }

    //Calculate sumation of y^2
    public void setSumationYsquared(Double[] ySet)
    {
        try
        {

            Double[] ySetsquared = new Double[ySet.length];
            for (int i = 0; i < ySet.length; i++)
            {
                ySetsquared[i] = ySet[i] * ySet[i];
            }
            for (int i = 0; i < ySetsquared.length; i++)
            {
                this.sumationYsquared = ySetsquared[i] + this.sumationYsquared;
            }
        } catch (Exception exceptionObj)
        {
            System.out.println("Error in sumation of y^2");
        }
    }

    //Rounding method
    public double roundDouble(double value, int places)
    {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    //main method for testing
    public static void main(String args[])
    {
        LineOfRegression objRegression = new LineOfRegression();
        ArrayList<String> ingredientList = new ArrayList<>();
        ingredientList.add("Grilled Chicken");
        ingredientList.add("Fried Rice");
        ingredientList.add("Fried Carrot");
        ingredientList.add("Fried Cucumber");

        objRegression.setIngredientList(ingredientList);
        objRegression.setDishAvgSum();
        objRegression.setXSet();
        objRegression.setYSet();
        Double[] xSet = objRegression.getXSet();
        Double[] ySet = objRegression.getYSet();
        objRegression.setSumationXY(xSet, ySet);
        objRegression.setSumationX(xSet);
        objRegression.setSumationY(ySet);
        objRegression.setSumationXsquared(xSet);
        objRegression.setSumationYsquared(ySet);
        objRegression.setLineOfRegression();
    }

}
