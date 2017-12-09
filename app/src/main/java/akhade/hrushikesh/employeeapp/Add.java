package akhade.hrushikesh.employeeapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Add extends AppCompatActivity {
    DBHelper mydb;
    Button add;
    EditText id, name, dept, mob;
    int ID;
    int Phone;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mydb=new DBHelper(this);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        dept = (EditText) findViewById(R.id.dept);
        mob = (EditText) findViewById(R.id.mob);
        add = (Button) findViewById(R.id.add);

        addData();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void addData() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    ID = Integer.parseInt(id.getText().toString());
                    Phone = Integer.parseInt(mob.getText().toString());
                } catch (NumberFormatException ex) { // handle your exception

                }
                String Name = name.getText().toString();
                String Dept = dept.getText().toString();



                boolean ins = mydb.insertData(ID, Name, Dept, Phone);
                if (ins == true) {
                    Toast.makeText(Add.this, "Record of " + Name + " Inserted ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Add.this, "Data  Not Inserted ", Toast.LENGTH_LONG).show();
                }

            }

        });
    }



}
