package akhade.hrushikesh.employeeapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;


public class ViewRecords extends AppCompatActivity {
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);
        mydb=new DBHelper(this);



                    Cursor cr=mydb.viewAll();
                    int rs=cr.getCount();
                    StringBuffer values=new StringBuffer();
                    if(rs==-1)
                    {

                        showMessage("Error "," No Records ");
                    }
                    else
                    {

                        while(cr.moveToNext())
                        {
                            values.append(" Emp_ID : "+cr.getString(0) +"\n Name : "+cr.getString(1)+"\n Department : "+cr.getString(2)+"\n Mobile  No. : "+cr.getString(3)+"\n\n");

                        }
                        showMessage("Data",values.toString());
                    }


                }
    public void showMessage(String title,String message)
    {

        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setCancelable(true);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.show();

    }


    }

