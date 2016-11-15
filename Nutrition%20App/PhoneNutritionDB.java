package com.example.victoria.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Victoria on 11/14/2016.
 */

public class PhoneNutritionDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Nutrition";

    protected static final String Venues_Table = "Venues";
    static final String colVenuesID="venuesID";
    static final String colName="name";

    protected static final String MenuItem_Table = "MenuItem";
    static final String colMenuID="menuID";
    static final String colMenuItemName="menuItemName";
    static final String colVenueID="venueID";
    static final String colCategory="category";
    static final String colServingSize="servingSize";
    static final String colCalories="calories";
    static final String colSodium="sodium";
    static final String colProtein="protein";
    static final String colTotalFat="totalFat";
    static final String colSaturatedFat="saturatedFat";
    static final String colCholesterol="cholesterol";
    static final String colTotalCarb="totalCarbohydrates";
    static final String colDietaryFiber="dietaryFiber";
    static final String colSugar="sugar";
    static final String colPotassium="potassium";

    protected static final String MealEntry_Table = "MealEntry";
    static final String colMealEntryID="mealEntryID";
    static final String colMenuItem="menuItem";
    static final String colAmount="amount";

    protected static final String Meals_Table = "Meals";
    static final String colMealID="mealID";
    static final String colVenue="venue";
    static final String colDate="date";
    static final String colMealEntries="mealEntries";

    protected static final String UserProfile_Table = "UserProfile";
    static final String colUserID="userID";
    static final String colHeight="height";
    static final String colWeight="weight";
    static final String colGender="gender";
    static final String colAge="age";
    static final String colActivityLevel="activityLevel";
    static final String colUserMeals="userMeals";

    protected static final String DailyIntake_Table = "DailyIntake";
    static final String colDailyIntakeID="dailyIntakeID";
    static final String colNutrient="nutrient";
    static final String colIntakeAmount="intakeAmount";

    protected static final String CustomMeals_Table = "CustomMeals";
    static final String colCustomMealID="customMealID";
    static final String colCustomName="customName";
    static final String colCustomMealEntries="customMealEntries";


    public PhoneNutritionDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +Venues_Table+" ("+colVenuesID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colName+" TEXT NOT NULL)");

        db.execSQL("CREATE TABLE " +MenuItem_Table+" ("+colMenuID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colMenuItemName+" TEXT NOT NULL, "+colVenueID+ " INTEGER NOT NULL, "+colCategory+" TEXT NOT NULL, "+colServingSize+" INTEGER NOT NULL, " +
                colCalories+" INTEGER NOT NULL, "+colSodium+" INTEGER NOT NULL, "+colProtein+ " INTEGER NOT NULL, "+colTotalFat+ " INTEGER NOT NULL, " +
                colSaturatedFat+" INTEGER NOT NULL, "+colCholesterol+" INTEGER NOT NULL, "+colTotalCarb+" INTEGER NOT NULL, "+colDietaryFiber+" INTEGER NOT NULL, "
                +colSugar+" INTEGER NOT NULL, "+colPotassium+" INTEGER NOT NULL ,FOREIGN KEY ("+colVenueID+") REFERENCES" +
                Venues_Table+" ("+colVenuesID+"));");

        db.execSQL("CREATE TABLE " +MealEntry_Table+" ("+colMealEntryID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colMenuItem+" INTEGER NOT NULL, "+colAmount+ " INTEGER NOT NULL ,FOREIGN KEY ("+colMenuItem+") REFERENCES" +
                MenuItem_Table+" ("+colMenuID+"));");

        db.execSQL("CREATE TABLE " +Meals_Table+" ("+colMealID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colVenue+" TEXT NOT NULL, "+colDate+ " TEXT NOT NULL, " +colMealEntries+" INTEGER NOT NULL ,FOREIGN KEY ("+colMealEntries+") REFERENCES" +
                MealEntry_Table+" ("+colMealEntryID+"));");

        db.execSQL("CREATE TABLE " +UserProfile_Table+" ("+colUserID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colHeight+" INTEGER NOT NULL, "+colWeight+ " INTEGER NOT NULL, " +colGender+" INTEGER NOT NULL, "
                +colAge+" INTEGER NOT NULL, " +colActivityLevel+" INTEGER NOT NULL, " +colUserMeals+" INTEGER NOT NULL ,FOREIGN KEY ("+colUserMeals+") REFERENCES" +
                Meals_Table+" ("+colMealID+"));");

        db.execSQL("CREATE TABLE " +DailyIntake_Table+" ("+colDailyIntakeID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colNutrient+" TEXT NOT NULL, "+colIntakeAmount+" INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " +CustomMeals_Table+" ("+colCustomMealID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                colCustomName+" TEXT NOT NULL, "+colCustomMealEntries+" INTEGER NOT NULL ,FOREIGN KEY ("+colCustomMealEntries+") REFERENCES" +
        MealEntry_Table+" ("+colMealEntryID+"));");

        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(colVenuesID, 1);
        cv.put(colName, "Panda Express");
        db.insert(Venues_Table, colVenuesID, cv);
        cv.put(colVenuesID, 2);
        cv.put(colName, "McDonald's");
        db.insert(Venues_Table, colVenuesID, cv);
        db.close();




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Venues_Table);
        db.execSQL("DROP TABLE IF EXISTS "+MenuItem_Table);
        db.execSQL("DROP TABLE IF EXISTS "+MealEntry_Table);
        db.execSQL("DROP TABLE IF EXISTS "+Meals_Table);
        db.execSQL("DROP TABLE IF EXISTS "+UserProfile_Table);
        db.execSQL("DROP TABLE IF EXISTS "+DailyIntake_Table);
        db.execSQL("DROP TABLE IF EXISTS "+CustomMeals_Table);
        onCreate(db);


    }

    Cursor getAll() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("SELECT "+colName+" from "+Venues_Table,new String [] {});
        return cur;
    }

    public void Update() {

       //code
    }

    public void Delete() {

        //code
    }


}
