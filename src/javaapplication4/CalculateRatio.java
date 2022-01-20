/*
Spetmeber 20th 2020
 * This class is used to calculate Ratio from the user
 */
//package internalassesment;


public class CalculateRatio
{
    //Declare attributes
    //Amount of food made
    private double foodMadeAmount;
    //Amount of food left
    private double foodLeftAmount; 
    //ratio of food left over food made
    private double ratio; 
    //Constructor
    public CalculateRatio(double foodMadeAmount, double foodLeftAmount)
    {
        //Assign Values
        this.foodMadeAmount = foodMadeAmount;
        this.foodLeftAmount = foodLeftAmount;
    }
    //set calculated Ratio
    public void setCalculateRatio ()
    {
        this.ratio = foodLeftAmount / foodMadeAmount;
    }
    //get calculated Ratio 
    public double getCalculateRatio()
    {
        return ratio;
    }
    //set the amount of food made
    public double getFoodMadeAmount()
    {
        return foodMadeAmount;
    }
    //get the amount of food left over
    public double getFoodLeftAmount()
    {
        return foodLeftAmount;
    }
    //set the amount of food made
    public void setFoodMadeAmount(double foodMadeAmount)
    {
        this.foodMadeAmount = foodMadeAmount;
    }
    //set the amount of food left over
    public void setFoodLeftAmount(double foodLeftAmount)
    {
        this.foodLeftAmount = foodLeftAmount;
    }

    //Main method for testing
    public static void main(String args[])
    {
        //declaring varaibles 
        //amount of food made
        double foodMade = 400;
        //amount of food left over
        double foodLeft = 100;
        //calling object 
        CalculateRatio objRatio = new CalculateRatio(foodMade, foodLeft);
        //calculated the ratio
        objRatio.setCalculateRatio();
        //get the calculated ratio 
        double ratio = objRatio.getCalculateRatio();
        //print value for tesing and checking
        System.out.println(ratio);
        
    }
}
