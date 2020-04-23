package tuanminh.nguyen.ui.home;
//Tuan Minh Nguyen N01250520
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import tuanminh.nguyen.R;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private String n="Android";
    private String m="Off";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_minh, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        RadioGroup radioGroup = (RadioGroup) root.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch(checkedId) {
                    case R.id.radioButton:
                        Toast.makeText(getActivity(),"Android",Toast.LENGTH_SHORT).show();
                        // Fragment 2
                        n="Android";
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getActivity(), "IOS" , Toast.LENGTH_SHORT).show();
                        n="IOS";
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(getActivity(),"Windows",Toast.LENGTH_SHORT).show();
                        n="Windows";
                        // Fragment 2
                        break;
                }
            }
        });
        final Switch switch1 = (Switch)root.findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switch1.isChecked()==true){
                    Toast.makeText(getActivity(), "On", Toast.LENGTH_LONG).show();
                    m = "On";
                }
                else{
                    Toast.makeText(getActivity(), "Off", Toast.LENGTH_LONG).show();
                    m = "Off";
                }
            }
        });
        Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),n+" selected +"+" Switch "+m+" + Minh",Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}