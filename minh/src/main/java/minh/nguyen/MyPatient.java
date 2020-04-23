package minh.nguyen;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPatient extends Fragment {
    Databasehelper db;
    private RecyclerView recycleview2;
    private ArrayList<PatientInfo> patients;
    private static final String TAG = "SpeedDial";
    private PageViewModel pageViewModel;
    public MyPatient() {
    }

    public static MyPatient newInstance() {
        return new MyPatient();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
        db = new Databasehelper(getActivity());
        Cursor res1 = db.getInfo1();
        patients = new ArrayList<>();

        StringBuffer buffer = new StringBuffer();
        while(res1.moveToNext()){
            PatientInfo patient1 = new PatientInfo();
            patient1.setID(res1.getString(0));
            patient1.setFirstName(res1.getString(1));
            patient1.setLastName(res1.getString(2));
            patient1.setDepartment(res1.getString(3));
            patients.add(patient1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.my_minh, container, false);
        recycleview2 = (RecyclerView)  root.findViewById(R.id.recycle2);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),patients);
        recycleview2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleview2.setAdapter(recyclerViewAdapter);
        return root;
    }
}