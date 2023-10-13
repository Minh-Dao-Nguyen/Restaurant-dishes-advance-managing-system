/*
 This class create Database for the project. This class also create the main table to store data.
 */
//package internalassesment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InstallDb
{

    public static void main(String[] args)
    {

        String dbName = "CUISINES";
        // Creating an object of DB class
        JavaDatabase objDb = new JavaDatabase();
        // Creating a new database
        objDb.createDb(dbName);
        Connection myDbConn = null;
        myDbConn = objDb.getDbConn();

        //GENERATED ALWAYS AS IDENTITY not null primary key
        // creating a new table
        //Name Table
        String NameTable = "CREATE TABLE DishName(DishID int , Dish_Name varchar(50)) ";
        //Type Table
        String TypeTable = "CREATE TABLE DishType(DishID int, Type varchar(50)) ";
        //IngredientTable
        String IngredientTable = "CREATE TABLE Ingredient(DishID int, Ingredient varchar(50)) ";
        //SauceTable
        String SauceTable = "CREATE TABLE Sauce(DishID int, Sauce varchar(50)) ";
        //Ratio Table
        String RatioTable = "CREATE TABLE DishRatio(DishID int, Ratio double) ";

        //Create Table
        objDb.createTable(NameTable, dbName);
        objDb.createTable(TypeTable, dbName);
        objDb.createTable(IngredientTable, dbName);
        objDb.createTable(SauceTable, dbName);
        objDb.createTable(RatioTable, dbName);

        //Pre entered Dish
        try
        {
            //Dish 1
            String dbQuery = "INSERT INTO DishName VALUES (1 , 'Chopped Steak')";
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
            ps.executeUpdate();
            String dbQuery1 = "INSERT INTO DishType VALUES (1 , 'Entree')";
            PreparedStatement ps1 = myDbConn.prepareStatement(dbQuery1);
            ps1.executeUpdate();
            // Ingredient 
            String dbQuery2 = "INSERT INTO Ingredient VALUES (1 , 'Grilled Steak')";
            PreparedStatement ps2 = myDbConn.prepareStatement(dbQuery2);
            ps2.executeUpdate();
            String dbQuery2a = "INSERT INTO Ingredient VALUES (1 , 'Mushroom')";
            PreparedStatement ps2a = myDbConn.prepareStatement(dbQuery2a);
            ps2a.executeUpdate();
            String dbQuery2b = "INSERT INTO Ingredient VALUES (1 , 'Salt and Pepper')";
            PreparedStatement ps2b = myDbConn.prepareStatement(dbQuery2b);
            ps2b.executeUpdate();
            String dbQuery2c = "INSERT INTO Ingredient VALUES (1 , 'Green Bean')";
            PreparedStatement ps2c = myDbConn.prepareStatement(dbQuery2c);
            ps2c.executeUpdate();
            //
            String dbQuery3 = "INSERT INTO Sauce VALUES (1 , 'Mushroom Gravy')";
            PreparedStatement ps3 = myDbConn.prepareStatement(dbQuery3);
            ps3.executeUpdate();
            String dbQuery4 = "INSERT INTO DishRatio VALUES (1 , 1000)";
            PreparedStatement ps4 = myDbConn.prepareStatement(dbQuery4);
            ps4.executeUpdate();
            
            //Dish 2 
            String dbQuery5 = "INSERT INTO DishName VALUES (2 , 'Sweet and Sour Pork')";
            PreparedStatement ps5 = myDbConn.prepareStatement(dbQuery5);
            ps5.executeUpdate();
            String dbQuery6 = "INSERT INTO DishType VALUES (2 , 'Entree')";
            PreparedStatement ps6 = myDbConn.prepareStatement(dbQuery6);
            ps6.executeUpdate();
            String dbQuery7 = "INSERT INTO Ingredient VALUES (2 , 'Grilled Pork')";
            PreparedStatement ps7 = myDbConn.prepareStatement(dbQuery7);
            ps7.executeUpdate();
            //
            String dbQuery8 = "INSERT INTO Sauce VALUES (2 , 'Sweet and Sour')";
            PreparedStatement ps8 = myDbConn.prepareStatement(dbQuery8);
            ps8.executeUpdate();
            String dbQuery9 = "INSERT INTO DishRatio VALUES (2 , 1000)";
            PreparedStatement ps9 = myDbConn.prepareStatement(dbQuery9);
            ps9.executeUpdate();
            
            //Dish 3
            String dbQuery10 = "INSERT INTO DishName VALUES (3 , 'Chicken Fried Steak')";
            PreparedStatement ps10 = myDbConn.prepareStatement(dbQuery10);
            ps10.executeUpdate();
            String dbQuery11 = "INSERT INTO DishType VALUES (3 , 'Entree')";
            PreparedStatement ps11 = myDbConn.prepareStatement(dbQuery11);
            ps11.executeUpdate();
            //Ingredient
            String dbQuery12 = "INSERT INTO Ingredient VALUES (3 , 'Fried Chicken')";
            PreparedStatement ps12 = myDbConn.prepareStatement(dbQuery12);
            ps12.executeUpdate();
            String dbQuery12a = "INSERT INTO Ingredient VALUES (3 , 'Green Bean')";
            PreparedStatement ps12a = myDbConn.prepareStatement(dbQuery12a);
            ps12a.executeUpdate();
             String dbQuery12b = "INSERT INTO Ingredient VALUES (3 , 'Baking Powder')";
            PreparedStatement ps12b = myDbConn.prepareStatement(dbQuery12b);
            ps12b.executeUpdate();
            //
            String dbQuery13 = "INSERT INTO Sauce VALUES (3 , 'Milk Gravy')";
            PreparedStatement ps13 = myDbConn.prepareStatement(dbQuery13);
            ps13.executeUpdate();
            String dbQuery14 = "INSERT INTO DishRatio VALUES (3 , 1000)";
            PreparedStatement ps14 = myDbConn.prepareStatement(dbQuery14);
            ps14.executeUpdate();
            
            //Dish 4
            String dbQuery15 = "INSERT INTO DishName VALUES (4 , 'Chicken Lo Mein')";
            PreparedStatement ps15 = myDbConn.prepareStatement(dbQuery15);
            ps15.executeUpdate();
            String dbQuery16 = "INSERT INTO DishType VALUES (4 , 'Entree')";
            PreparedStatement ps16 = myDbConn.prepareStatement(dbQuery16);
            ps16.executeUpdate();
            //Ingredient 
            String dbQuery17 = "INSERT INTO Ingredient VALUES (4 , 'Fried Chicken')";
            PreparedStatement ps17 = myDbConn.prepareStatement(dbQuery17);
            ps17.executeUpdate();
            String dbQuery17a = "INSERT INTO Ingredient VALUES (4 , 'Fried Carrot')";
            PreparedStatement ps17a = myDbConn.prepareStatement(dbQuery17a);
            ps17a.executeUpdate();
            String dbQuery17b = "INSERT INTO Ingredient VALUES (4 , 'Fried Cucumber')";
            PreparedStatement ps17b = myDbConn.prepareStatement(dbQuery17b);
            ps17b.executeUpdate();
            String dbQuery17c = "INSERT INTO Ingredient VALUES (4 , 'Tagliatelle')";
            PreparedStatement ps17c = myDbConn.prepareStatement(dbQuery17c);
            ps17c.executeUpdate();
            //
            String dbQuery18 = "INSERT INTO Sauce VALUES (4 , 'Soy Sauce')";
            PreparedStatement ps18 = myDbConn.prepareStatement(dbQuery18);
            ps18.executeUpdate();
            String dbQuery19 = "INSERT INTO DishRatio VALUES (4 , 1000)";
            PreparedStatement ps19 = myDbConn.prepareStatement(dbQuery19);
            ps19.executeUpdate();
            
            //Dish 5
            String dbQuery20 = "INSERT INTO DishName VALUES (5 , 'Beef Lo Mein')";
            PreparedStatement ps20 = myDbConn.prepareStatement(dbQuery20);
            ps20.executeUpdate();
            String dbQuery21 = "INSERT INTO DishType VALUES (5 , 'Entree')";
            PreparedStatement ps21 = myDbConn.prepareStatement(dbQuery21);
            ps21.executeUpdate();
            //Ingredient
            String dbQuery22 = "INSERT INTO Ingredient VALUES (5 , 'Fried Beef')";
            PreparedStatement ps22 = myDbConn.prepareStatement(dbQuery22);
            ps22.executeUpdate();
            String dbQuery22a = "INSERT INTO Ingredient VALUES (5 , 'Fried Carrot')";
            PreparedStatement ps22a = myDbConn.prepareStatement(dbQuery22a);
            ps22a.executeUpdate();
            String dbQuery22b = "INSERT INTO Ingredient VALUES (5 , 'Fried Cucumber')";
            PreparedStatement ps22b = myDbConn.prepareStatement(dbQuery22b);
            ps22b.executeUpdate();
            String dbQuery22c = "INSERT INTO Ingredient VALUES (5 , 'Tagliatelle')";
            PreparedStatement ps22c = myDbConn.prepareStatement(dbQuery22c);
            ps22c.executeUpdate();
            //
            String dbQuery23 = "INSERT INTO Sauce VALUES (5 , 'Soy Sauce')";
            PreparedStatement ps23 = myDbConn.prepareStatement(dbQuery23);
            ps23.executeUpdate();
            String dbQuery24 = "INSERT INTO DishRatio VALUES (5 , 1000)";
            PreparedStatement ps24 = myDbConn.prepareStatement(dbQuery24);
            ps24.executeUpdate();

            //Dish 6 
            String dbQuery25 = "INSERT INTO DishName VALUES (6 , 'Char Siu Bao')";
            PreparedStatement ps25 = myDbConn.prepareStatement(dbQuery25);
            ps25.executeUpdate();
            String dbQuery26 = "INSERT INTO DishType VALUES (6 , 'Entree')";
            PreparedStatement ps26 = myDbConn.prepareStatement(dbQuery26);
            ps26.executeUpdate();
            //Ingredient
            String dbQuery27 = "INSERT INTO Ingredient VALUES (6 , 'Grilled Pork')";
            PreparedStatement ps27 = myDbConn.prepareStatement(dbQuery27);
            ps27.executeUpdate();
            String dbQuery27a = "INSERT INTO Ingredient VALUES (6 , 'Carbage')";
            PreparedStatement ps27a = myDbConn.prepareStatement(dbQuery27a);
            ps27a.executeUpdate();
            String dbQuery27b = "INSERT INTO Ingredient VALUES (6 , 'Cucumber')";
            PreparedStatement ps27b = myDbConn.prepareStatement(dbQuery27b);
            ps27b.executeUpdate();
            String dbQuery27c = "INSERT INTO Ingredient VALUES (6 , 'Steam Bun')";
            PreparedStatement ps27c = myDbConn.prepareStatement(dbQuery27c);
            ps27c.executeUpdate();
            //
            String dbQuery28 = "INSERT INTO Sauce VALUES (6 , 'Hot Sauce')";
            PreparedStatement ps28 = myDbConn.prepareStatement(dbQuery28);
            ps28.executeUpdate();
            String dbQuery29 = "INSERT INTO DishRatio VALUES (6 , 1000)";
            PreparedStatement ps29 = myDbConn.prepareStatement(dbQuery29);
            ps29.executeUpdate();
            
            //Dish 7 
            String dbQuery30 = "INSERT INTO DishName VALUES (7 , 'Grilled Pesto Chicken')";
            PreparedStatement ps30 = myDbConn.prepareStatement(dbQuery30);
            ps30.executeUpdate();
            String dbQuery31 = "INSERT INTO DishType VALUES (7 , 'Entree')";
            PreparedStatement ps31 = myDbConn.prepareStatement(dbQuery31);
            ps31.executeUpdate();
            //Ingredient
            String dbQuery32 = "INSERT INTO Ingredient VALUES (7 , 'Grilled Chicken')";
            PreparedStatement ps32 = myDbConn.prepareStatement(dbQuery32);
            ps32.executeUpdate();
            String dbQuery32a = "INSERT INTO Ingredient VALUES (7 , 'Salt and Pepper')";
            PreparedStatement ps32a = myDbConn.prepareStatement(dbQuery32a);
            ps32a.executeUpdate();
            //
            String dbQuery33 = "INSERT INTO Sauce VALUES (7 , 'Pesto')";
            PreparedStatement ps33 = myDbConn.prepareStatement(dbQuery33);
            ps33.executeUpdate();
            String dbQuery34 = "INSERT INTO DishRatio VALUES (7 , 1000)";
            PreparedStatement ps34 = myDbConn.prepareStatement(dbQuery34);
            ps34.executeUpdate();

            //Dish 8
            String dbQuery35 = "INSERT INTO DishName VALUES (8 , 'Special Fried Rice')";
            PreparedStatement ps35 = myDbConn.prepareStatement(dbQuery35);
            ps35.executeUpdate();
            String dbQuery36 = "INSERT INTO DishType VALUES (8 , 'Entree')";
            PreparedStatement ps36 = myDbConn.prepareStatement(dbQuery36);
            ps36.executeUpdate();
            //Ingredient
            String dbQuery37 = "INSERT INTO Ingredient VALUES (8 , 'Shrimps')";
            PreparedStatement ps37 = myDbConn.prepareStatement(dbQuery37);
            ps37.executeUpdate();
            String dbQuery37a = "INSERT INTO Ingredient VALUES (8 , 'Sausages')";
            PreparedStatement ps37a = myDbConn.prepareStatement(dbQuery37a);
            ps37a.executeUpdate();
            String dbQuery37b = "INSERT INTO Ingredient VALUES (8 , 'Mussels')";
            PreparedStatement ps37b = myDbConn.prepareStatement(dbQuery37b);
            ps37b.executeUpdate();
            //
            String dbQuery38 = "INSERT INTO Sauce VALUES (8 , 'Marinade sauce')";
            PreparedStatement ps38 = myDbConn.prepareStatement(dbQuery38);
            ps38.executeUpdate();
            String dbQuery39 = "INSERT INTO DishRatio VALUES (8 , 1000)";
            PreparedStatement ps39 = myDbConn.prepareStatement(dbQuery39);
            ps39.executeUpdate();
            
            //Dish 9
            String dbQuery40 = "INSERT INTO DishName VALUES (9 , 'Pad Thai')";
            PreparedStatement ps40 = myDbConn.prepareStatement(dbQuery40);
            ps40.executeUpdate();
            String dbQuery41 = "INSERT INTO DishType VALUES (9 , 'Entree')";
            PreparedStatement ps41 = myDbConn.prepareStatement(dbQuery41);
            ps41.executeUpdate();
            //Ingredient
            String dbQuery42 = "INSERT INTO Ingredient VALUES (9 , 'Udon Noddle')";
            PreparedStatement ps42 = myDbConn.prepareStatement(dbQuery42);
            ps42.executeUpdate();
            String dbQuery42a = "INSERT INTO Ingredient VALUES (9 , 'Shrimps')";
            PreparedStatement ps42a = myDbConn.prepareStatement(dbQuery42a);
            ps42a.executeUpdate();
            String dbQuery42b = "INSERT INTO Ingredient VALUES (9 , 'Vegetables')";
            PreparedStatement ps42b = myDbConn.prepareStatement(dbQuery42b);
            ps42b.executeUpdate();
            //
            String dbQuery43 = "INSERT INTO Sauce VALUES (9 , 'Marinade sauce')";
            PreparedStatement ps43 = myDbConn.prepareStatement(dbQuery43);
            ps43.executeUpdate();
            String dbQuery44 = "INSERT INTO DishRatio VALUES (9 , 1000)";
            PreparedStatement ps44 = myDbConn.prepareStatement(dbQuery44);
            ps44.executeUpdate();

            //Dish 10
            String dbQuery45 = "INSERT INTO DishName VALUES (10 , 'Pho')";
            PreparedStatement ps45 = myDbConn.prepareStatement(dbQuery45);
            ps45.executeUpdate();
            String dbQuery46 = "INSERT INTO DishType VALUES (10 , 'Entree')";
            PreparedStatement ps46 = myDbConn.prepareStatement(dbQuery46);
            ps46.executeUpdate();
            //Ingredient
            String dbQuery47 = "INSERT INTO Ingredient VALUES (10 , 'Pho Broth')";
            PreparedStatement ps47 = myDbConn.prepareStatement(dbQuery47);
            ps47.executeUpdate();
            String dbQuery47a = "INSERT INTO Ingredient VALUES (10 , 'Shrimps')";
            PreparedStatement ps47a = myDbConn.prepareStatement(dbQuery47a);
            ps47a.executeUpdate();
            String dbQuery47b = "INSERT INTO Ingredient VALUES (10 , 'Boild Eggs')";
            PreparedStatement ps47b = myDbConn.prepareStatement(dbQuery47b);
            ps47b.executeUpdate();
            //
            String dbQuery48 = "INSERT INTO Sauce VALUES (10 , 'No sauce')";
            PreparedStatement ps48 = myDbConn.prepareStatement(dbQuery48);
            ps48.executeUpdate();
            String dbQuery49 = "INSERT INTO DishRatio VALUES (10 , 1000)";
            PreparedStatement ps49 = myDbConn.prepareStatement(dbQuery49);
            ps49.executeUpdate();
            
            //Dish 11
            String dbQuery50 = "INSERT INTO DishName VALUES (11 , 'Garden Sald')";
            PreparedStatement ps50 = myDbConn.prepareStatement(dbQuery50);
            ps50.executeUpdate();
            String dbQuery51 = "INSERT INTO DishType VALUES (11 , 'Salad')";
            PreparedStatement ps51 = myDbConn.prepareStatement(dbQuery51);
            ps51.executeUpdate();
            //Ingredient
            String dbQuery52 = "INSERT INTO Ingredient VALUES (11 , 'Spinach')";
            PreparedStatement ps52 = myDbConn.prepareStatement(dbQuery52);
            ps52.executeUpdate();
            String dbQuery52a = "INSERT INTO Ingredient VALUES (11 , 'Lettuces')";
            PreparedStatement ps52a = myDbConn.prepareStatement(dbQuery52a);
            ps52a.executeUpdate();
            String dbQuery52b = "INSERT INTO Ingredient VALUES (11 , 'Cucumber')";
            PreparedStatement ps52b = myDbConn.prepareStatement(dbQuery52b);
            ps52b.executeUpdate();
            String dbQuery52c = "INSERT INTO Ingredient VALUES (11 , 'Tomatoe')";
            PreparedStatement ps52c = myDbConn.prepareStatement(dbQuery52c);
            ps52c.executeUpdate();
            //
            String dbQuery53 = "INSERT INTO Sauce VALUES (11 , 'Italian Dressing')";
            PreparedStatement ps53 = myDbConn.prepareStatement(dbQuery53);
            ps53.executeUpdate();
            String dbQuery54 = "INSERT INTO DishRatio VALUES (11 , 1000)";
            PreparedStatement ps54 = myDbConn.prepareStatement(dbQuery54);
            ps54.executeUpdate();

            //Dish 12
            String dbQuery55 = "INSERT INTO DishName VALUES (12 , 'Chicken Sald')";
            PreparedStatement ps55 = myDbConn.prepareStatement(dbQuery55);
            ps55.executeUpdate();
            String dbQuery56 = "INSERT INTO DishType VALUES (12 , 'Salad')";
            PreparedStatement ps56 = myDbConn.prepareStatement(dbQuery56);
            ps56.executeUpdate();
            //Ingredient
            String dbQuery57 = "INSERT INTO Ingredient VALUES (12 , 'Spinach')";
            PreparedStatement ps57 = myDbConn.prepareStatement(dbQuery57);
            ps57.executeUpdate();
            String dbQuery57a = "INSERT INTO Ingredient VALUES (12 , 'Lettuces')";
            PreparedStatement ps57a = myDbConn.prepareStatement(dbQuery57a);
            ps57a.executeUpdate();
            String dbQuery57b = "INSERT INTO Ingredient VALUES (12 , 'Chicken')";
            PreparedStatement ps57b = myDbConn.prepareStatement(dbQuery57b);
            ps57b.executeUpdate();
            String dbQuery57c = "INSERT INTO Ingredient VALUES (12 , 'Cheese')";
            PreparedStatement ps57c = myDbConn.prepareStatement(dbQuery57c);
            ps57c.executeUpdate();
            //
            String dbQuery58 = "INSERT INTO Sauce VALUES (12 , 'Italian Dressing')";
            PreparedStatement ps58 = myDbConn.prepareStatement(dbQuery58);
            ps58.executeUpdate();
            String dbQuery59 = "INSERT INTO DishRatio VALUES (12 , 1000)";
            PreparedStatement ps59 = myDbConn.prepareStatement(dbQuery59);
            ps59.executeUpdate();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(InstallDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
