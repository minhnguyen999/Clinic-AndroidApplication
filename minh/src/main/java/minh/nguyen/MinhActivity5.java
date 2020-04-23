package minh.nguyen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MinhActivity5 extends AppCompatActivity {

    Databasehelper db;
    private RecyclerView recycleview5;
    private ArrayList<PatientInfo> patients;
    private ArrayList<PatientInfo> myList;
    private PageViewModel pageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minh5);
        ActionBar lmao = getSupportActionBar();
        lmao.setDisplayHomeAsUpEnabled(true);
        lmao.setTitle("Clinical Details");
        final String id = getIntent().getStringExtra("option2");
        db = new Databasehelper(this);
        Cursor res = db.getInfo2(id);
        //Cursor res2 = db.getInfo22(id);
        patients = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            PatientInfo patient2 = new PatientInfo();
            patient2.setID(res.getString(0));
            patient2.setFirstName(res.getString(1));
            patient2.setLastName(res.getString(2));
            patient2.setDepartment(res.getString(3));
            patient2.setGender(res.getString(4));
            patient2.setBloodPressure(res.getString(5));
            patient2.setRespiratoryRate(res.getString(6));
            patient2.setBloodOxygenLevel(res.getString(7));
            patients.add(patient2);
        }
        recycleview5 = (RecyclerView)findViewById(R.id.recycle5);
        RecyclerViewAdapter1 recyclerViewAdapter = new RecyclerViewAdapter1(this,patients);
        recycleview5.setLayoutManager(new LinearLayoutManager(this));
        recycleview5.setAdapter(recyclerViewAdapter);
        final Button deleted = findViewById(R.id.deleted);
        deleted.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int delete = db.deleteInfo(id);
                Toast.makeText(MinhActivity5.this, "Deleted", Toast.LENGTH_LONG).show();
                Intent intent5 = new Intent(MinhActivity5.this, MinhActivity.class);
                startActivity(intent5);
            }
        });
        /*
        TextView tv11 = (TextView)findViewById(R.id.textView11);
        tv11.setText(id);*/
    }

    /*public void onclick5(){
        TextView newid = (TextView)findViewById(R.id.patientID);
        //db = new Databasehelper(this);
        String newid1 = newid.getText().toString();
        Cursor res = db.getInfo2(newid1);
        patients = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            PatientInfo patient3 = new PatientInfo();
            patient3.setID(res.getString(0));
            patient3.setFirstName(res.getString(1));
            patient3.setLastName(res.getString(2));
            patient3.setDepartment(res.getString(3));
            patient3.setGender(res.getString(4));
            patient3.setBloodPressure(res.getString(5));
            patient3.setRespiratoryRate(res.getString(6));
            patient3.setBloodOxygenLevel(res.getString(7));
            patients.add(patient3);
        }
        recycleview5 = (RecyclerView)findViewById(R.id.recycle5);
        RecyclerViewAdapter1 recyclerViewAdapter = new RecyclerViewAdapter1(this,patients);
        recycleview5.setLayoutManager(new LinearLayoutManager(this));
        recycleview5.setAdapter(recyclerViewAdapter);
    }*/

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}