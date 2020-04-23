package minh.nguyen;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

import static android.widget.Toast.LENGTH_SHORT;

public class AddTest extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView date ;
    private DatePickerDialog.OnDateSetListener mDateListener;
    Spinner spinner1;
    SpinnerAdapter adapter;
    EditText bloodpressure;
    EditText resporatoryrate;
    EditText bloodoxygenlevel;
    RadioGroup radiogroup2;
    RadioButton radiobutton2;
    String selected;
    ArrayList<String> patients = new ArrayList<String>();
    ArrayList<String> ids = new ArrayList<String>();
    Databasehelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        getSupportActionBar().setTitle("Add Test");
        db = new Databasehelper(this);
        resporatoryrate = findViewById(R.id.editText10);
        bloodoxygenlevel = findViewById(R.id.editText11);
        radiogroup2 = findViewById(R.id.radioGroup2);
        int radioId = radiogroup2.getCheckedRadioButtonId();
        spinner1 = findViewById(R.id.spinner1);
        Cursor res = db.getInfo();
        while(res.moveToNext()){
            PatientInfo patientInfo = new PatientInfo();
            patientInfo.setID(res.getString(0));
            patientInfo.setFirstName(res.getString(1));
            patientInfo.setLastName(res.getString(2));
            patients.add(patientInfo.toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,patients);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //int omg = spinner1.getSelectedItemPosition()+1;
                //final String lmao = Integer.toString(omg);
                final String some = spinner1.getSelectedItem().toString();
                final String some1 = String.valueOf(some.charAt(1));
                //Toast.makeText(AddTest.this, spinner1.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                final Button button3 = findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        final EditText something = (EditText) findViewById(R.id.editText10);
                        final String input = something.getText().toString();
                        final EditText something1 = (EditText) findViewById(R.id.editText11);
                        final String input1 = something1.getText().toString();
                        if (input.length() == 0) {
                            something.requestFocus();
                            something.setError("PLEASE PROVIDE RESULT");
                        } else if (input1.length() == 0) {
                            something1.requestFocus();
                            something1.setError("PLEASE PROVIDE RESULT");
                        } else {
                            db.updateInfo(some1,radiobutton2.getText().toString(), resporatoryrate.getText().toString(),bloodoxygenlevel.getText().toString());
                            //db.putInfo1(String.valueOf(last),radiobutton2.getText().toString(), resporatoryrate.getText().toString(),bloodoxygenlevel.getText().toString());
                            //Toast.makeText(this, "Test added" , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddTest.this, MinhActivity.class);
                            startActivity(intent);}
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        date = (TextView) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    public void bloodOptions(View view)
    {
        int radio1;
        radio1 = radiogroup2.getCheckedRadioButtonId();
        radiobutton2  = findViewById(radio1);

    }

    /*public void onclick1(View V){
        final EditText something = (EditText) findViewById(R.id.editText);
        final String input = something.getText().toString();
        final EditText something1 = (EditText) findViewById(R.id.editText4);
        final String input1 = something1.getText().toString();
        if (input.length() == 0) {
            something.requestFocus();
            something.setError("PLEASE PROVIDE RESULT");
        } else if (input1.length() == 0) {
            something1.requestFocus();
            something1.setError("PLEASE PROVIDE RESULT");
        } else {
        db.putInfo1(spinner1.getSelectedItem().toString(),radiobutton2.getText().toString(), resporatoryrate.getText().toString(),bloodoxygenlevel.getText().toString());
        Toast.makeText(this, "Test added" , LENGTH_SHORT).show();
        Intent intent = new Intent(AddTest.this, MinhActivity.class);
        startActivity(intent);}
    }*/


    public void showDatePickerDialog(){
        DatePickerDialog date2 = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        date2.show();
    }


    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date1 =  month + "/" + dayOfMonth + "/" + year;
        date.setText(date1);
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
                Intent intent2 = new Intent(this, MinhActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                return true;


        }
        return true;
    }
}
