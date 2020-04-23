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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MinhActivity3 extends AppCompatActivity {

    Databasehelper db;
    private RecyclerView recycleview3;
    private ArrayList<PatientInfo> patients;
    private ArrayList<PatientInfo> myList;
    private PageViewModel pageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minh3);
        ActionBar lmao = getSupportActionBar();
        lmao.setDisplayHomeAsUpEnabled(true);
        lmao.setTitle("ID Browsed Patient ");
        final String id = getIntent().getStringExtra("option");
        db = new Databasehelper(this);
        Cursor res = db.getInfo2(id);
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
            recycleview3 = (RecyclerView)findViewById(R.id.recycle3);
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,patients);
            recycleview3.setLayoutManager(new LinearLayoutManager(this));
            recycleview3.setAdapter(recyclerViewAdapter);
            final Button button4 = findViewById(R.id.button4);
            button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int res1 = db.deleteInfo(id);
                Toast.makeText(MinhActivity3.this, "Deleted", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(MinhActivity3.this, MinhActivity2.class);
                startActivity(intent3);
            }
        });
        final Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent5 = new Intent(MinhActivity3.this, MinhActivity5.class);
                intent5.putExtra("option2",id);
                startActivity(intent5);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
