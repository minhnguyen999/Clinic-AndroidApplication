package minh.nguyen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.Date;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "minh.db";
    public static final String TABLE_NAME = "patient_table";
    //public static final String TABLE_NAME1 = "test_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "DEPARTMENT";
    public static final String COL_5 = "GENDER";
    public static final String COL_6 = "BLOODPRESSURE";
    public static final String COL_7 = "RESPORATORYRATE";
    public static final String COL_8 = "BLOODOXYGENLEVEL";


    public Databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,LASTNAME TEXT, DEPARTMENT TEXT,GENDER TEXT,BLOODPRESSURE TEXT,RESPORATORYRATE TEXT,BLOODOXYGENLEVEL TEXT)");
        //sqLiteDatabase.execSQL("create table " + TABLE_NAME1 + "(ID INTEGER, BLOODPRESSURE TEXT,RESPORATORYRATE TEXT,BLOODOXYGENLEVEL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }


    public boolean putInfo(String firstname, String lastname, String department, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, firstname);
        contentValues.put(COL_3, lastname);
        contentValues.put(COL_4, department);
        contentValues.put(COL_5, gender);

        long res = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else
            return true;

    }

    /*public boolean putInfo1(String id,String bloodpressure, String resporatoryrate, String bloodoxygenlevel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_6, bloodpressure);
        contentValues.put(COL_7, resporatoryrate);
        contentValues.put(COL_8, bloodoxygenlevel);
        long res1 = sqLiteDatabase.insert(TABLE_NAME1, null, contentValues);
        if (res1 == -1) {
            return false;
        } else
            return true;

    }*/


    public boolean updateInfo(String id,String bloodpressure, String resporatoryrate, String bloodoxygenlevel )
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6, bloodpressure);
        contentValues.put(COL_7, resporatoryrate);
        contentValues.put(COL_8, bloodoxygenlevel);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?",new String[] {id});
        return true;


    }

    public Integer deleteInfo (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    public Cursor getInfo() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("Select * from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getInfo1() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res1 = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" WHERE " + COL_4  + " = ?;", new String[] {"Audiology"});
        return res1;
    }

    public Cursor getInfo2(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res1 = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" WHERE " + COL_1  + " = ?;", new String[] {id});
        return res1;
    }

    /*public Cursor getInfo22(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res1 = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME1+" WHERE " + COL_1  + " = ?;", new String[] {id});
        return res1;
    }*/

    public Cursor getInfo3(String department) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res1 = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" WHERE " + COL_4  + " = ?;", new String[] {department});
        return res1;
    }
}