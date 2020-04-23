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

import java.util.ArrayList;

public class MinhActivity4 extends AppCompatActivity {

    Databasehelper db;
    private RecyclerView recycleview4;
    private ArrayList<PatientInfo> patients;
    private ArrayList<PatientInfo> myList;
    private PageViewModel pageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minh4);
        ActionBar lmao = getSupportActionBar();
        lmao.setDisplayHomeAsUpEnabled(true);
        lmao.setTitle("Department Browsed Patients");
        final String id = getIntent().getStringExtra("option1");
        db = new Databasehelper(this);
        Cursor res = db.getInfo3(id);
        patients = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            PatientInfo patient1 = new PatientInfo();
            patient1.setID(res.getString(0));
            patient1.setFirstName(res.getString(1));
            patient1.setLastName(res.getString(2));
            patient1.setDepartment(res.getString(3));
            patients.add(patient1);
        }
        recycleview4 = (RecyclerView)findViewById(R.id.recycle4);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,patients);
        recycleview4.setLayoutManager(new LinearLayoutManager(this));
        recycleview4.setAdapter(recyclerViewAdapter);
        final Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent7 = new Intent(MinhActivity4.this, MinhActivity2.class);
                startActivity(intent7);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}