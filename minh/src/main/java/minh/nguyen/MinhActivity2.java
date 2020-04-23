package minh.nguyen;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.getbase.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MinhActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_minh2);
            Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(myToolbar);
            ActionBar lmao = getSupportActionBar();
            lmao.setTitle("Search & Filter");
            lmao.setDisplayHomeAsUpEnabled(true);
            final Spinner spinner = (Spinner)findViewById(R.id.spinner) ;
            List<String> list1 = new ArrayList<String>();
            list1.add("Audiology");
            list1.add("Ocular");
            list1.add("Olfactory");
            list1.add("Taste");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    //Toast.makeText(AddPatient.this, spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                    String i = spinner.getSelectedItem().toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub

                }
            });
            final Button button2 = findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final String input1 = spinner.getSelectedItem().toString();
                    Intent intent1 = new Intent(MinhActivity2.this, MinhActivity4.class);
                    intent1.putExtra("option1",input1);
                    startActivity(intent1);

                }
            });
            final Button button6 = findViewById(R.id.button6);
            button6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent6 = new Intent(MinhActivity2.this, MinhActivity.class);
                    startActivity(intent6);

                }
            });

        }

    /*public void onclick(View V){
        final String input1 = spinner.getSelectedItem().toString();
        Intent intent1 = new Intent(MinhActivity2.this, MinhActivity4.class);
        intent1.putExtra("option1",input1);
        startActivity(intent1);
        }*/

    public void onclick3(View V){
        final EditText something = (EditText) findViewById(R.id.editText);
        final String input = something.getText().toString();
        if (input.length() == 0) {
            something.requestFocus();
            something.setError("PLEASE PROVIDE PATIENT ID");
        } else{
        Intent intent = new Intent(MinhActivity2.this, MinhActivity3.class);
        intent.putExtra("option",input);
        startActivity(intent);}
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}