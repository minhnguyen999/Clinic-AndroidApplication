package minh.nguyen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;


public class AllPatient extends Fragment implements Serializable {
    Databasehelper db;
    private RecyclerView recycleview1;
    private ArrayList<PatientInfo> patients;
    private ArrayList<PatientInfo> myList;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;

    public static AllPatient newInstance() {

        return new AllPatient();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.all_minh, container, false);
        recycleview1 = (RecyclerView)  root.findViewById(R.id.recycle1);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),patients);
        recycleview1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleview1.setAdapter(recyclerViewAdapter);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        db = new Databasehelper(getActivity());
        Cursor res = db.getInfo();
        patients = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            PatientInfo patient1 = new PatientInfo();
            patient1.setID(res.getString(0));
            patient1.setFirstName(res.getString(1));
            patient1.setLastName(res.getString(2));
            patient1.setDepartment(res.getString(3));
            patients.add(patient1);
        }

    }

}