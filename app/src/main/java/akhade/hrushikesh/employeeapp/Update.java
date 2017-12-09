package akhade.hrushikesh.employeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    DBHelper mydb;
    EditText name,id,phone,dept;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mydb=new DBHelper(this);
        update=(Button)findViewById(R.id.update);
        id=(EditText)findViewById(R.id.ID);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.mob);
        dept=(EditText)findViewById(R.id.dept);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate=mydb.update(Integer.parseInt(id.getText().toString()),name.getText().toString(),dept.getText().toString(),Integer.parseInt(phone.getText().toString()));
                if (isUpdate == true) {
                    Toast.makeText(Update.this, "Record of  ID=" + id.getText().toString() + " is Updated ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Update.this, "Data  Not Updated ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
