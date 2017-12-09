package akhade.hrushikesh.employeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {


    public static final String databasename="Hrushi.db";
    public static final String tablename="Employee";
    public static final String col1="Emp_ID";
    public static final String col2="NAME";
    public static final String col3="Department";
    public static final String col4="Phone";

    public DBHelper(Context context) {

        super(context, databasename, null, 1);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Employee(Emp_ID Integer  primary key,NAME TEXT,Department Text,Phone Integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+tablename);

        onCreate(db);

    }

    public boolean insertData(int Emp_id,String Name,String Department,int Phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,Emp_id);
        contentValues.put(col2,Name);
        contentValues.put(col3,Department);
        contentValues.put(col4,Phone);

        long r=db.insert(tablename,null,contentValues);
        if(r==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public Cursor viewAll()
    {
        SQLiteDatabase db=this.getWritableDatabase();


        Cursor cursor=db.rawQuery("select * from "+tablename,null);


        return cursor;
    }
    public int deleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(tablename,"Emp_ID=?",new String[]{id});
    }

    public Cursor search(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+tablename+" where Emp_ID=?",new String[]{id});
        return cursor;
    }


    public  boolean update(int Emp_id,String Name,String dept,int Phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,Emp_id);
        contentValues.put(col2,Name);
        contentValues.put(col3,dept);
        contentValues.put(col4,Phone);
        long r=db.update(tablename,contentValues,"Emp_ID="+Emp_id,null);

        if(r==-1)
        {

            return false;
        }
        else
        {
            return true;
        }
    }
}
