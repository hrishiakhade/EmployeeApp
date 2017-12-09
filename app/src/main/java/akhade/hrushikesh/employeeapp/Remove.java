package akhade.hrushikesh.employeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Remove extends AppCompatActivity {
    EditText id;
    Button remove;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        remove=(Button)findViewById(R.id.remove);
        id=(EditText)findViewById(R.id.ID);
        mydb=new DBHelper(this);


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int delete=mydb.deleteData(id.getText().toString());
                if(delete==0)
                {
                    Toast.makeText(Remove.this,"Not Deleted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Remove.this,"Deleted",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
