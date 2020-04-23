package minh.nguyen;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddPatient extends AppCompatActivity {


    private Spinner spinner;
    EditText firstName;
    EditText lastName;
    Spinner department;
    RadioGroup radiogroup;
    RadioButton radiobutton;
    Databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1);
        getSupportActionBar().setTitle("Add Patient");
        db = new Databasehelper(this);
        firstName = findViewById(R.id.editText5);
        lastName = findViewById(R.id.editText3);
        department = findViewById(R.id.spinner);
        radiogroup = findViewById(R.id.radioGroup);
        int radioId = radiogroup.getCheckedRadioButtonId();
        List<String> list = new ArrayList<String>();
        list.add("Audiology");
        list.add("Ocular");
        list.add("Olfactory");
        list.add("Taste");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        department.setAdapter(adapter);
        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                //Toast.makeText(AddPatient.this, department.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void onclick(View V){
        final EditText something = (EditText) findViewById(R.id.editText5);
        final String input = something.getText().toString();
        final EditText something1 = (EditText) findViewById(R.id.editText3);
        final String input1 = something1.getText().toString();
        if (input.length() == 0) {
            something.requestFocus();
            something.setError("PLEASE PROVIDE RESULT");
        } else if (input1.length() == 0) {
            something1.requestFocus();
            something1.setError("PLEASE PROVIDE RESULT");
        } else {
        db.putInfo(firstName.getText().toString(),lastName.getText().toString(),department.getSelectedItem().toString(),radiobutton.getText().toString());
        Toast.makeText(this, "Patient added" , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddPatient.this, MinhActivity.class);
        startActivity(intent);}
    }



    public void genderOptions(View view)
    {
        int radio;
        radio = radiogroup.getCheckedRadioButtonId();
        radiobutton  = findViewById(radio);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_minh, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        switch (item.getItemId())
        {

            case android.R.id.home:
                Intent intentt = new Intent(this, MinhActivity.class);
                intentt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentt);
                return true;


        }
        return true;
    }

}
