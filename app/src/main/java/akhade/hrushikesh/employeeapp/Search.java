package akhade.hrushikesh.employeeapp;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {
    DBHelper mydb;
    EditText editText;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mydb=new DBHelper(this);
        search=(Button)findViewById(R.id.search);
        editText=(EditText)findViewById(R.id.searchText);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cr=mydb.search(editText.getText().toString());
                int rs=cr.getCount();
                StringBuffer values=new StringBuffer();
                if(rs==-1)
                {

                    showMessage("Error "," No Record ");
                }
                else
                {

                    if(cr.moveToNext())
                    {
                        values.append(" Emp_ID : "+cr.getString(0) +"\n Name : "+cr.getString(1)+"\n Department : "+cr.getString(2)+"\n Mobile  No. : "+cr.getString(3)+"\n\n");

                    }
                    showMessage("Data",values.toString());
                }
            }
        });
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
