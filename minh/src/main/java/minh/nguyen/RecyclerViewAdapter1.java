package minh.nguyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.MyViewHolder> {



    Context mContext;
    List<PatientInfo> mData;


    public RecyclerViewAdapter1(Context mContext, List<PatientInfo> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.layout_format1,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_id.setText(mData.get(position).getID());
        holder.tv_firstname.setText(mData.get(position).getFirstName());
        holder.tv_lastname.setText(mData.get(position).getLastName());
        holder.tv_department.setText(mData.get(position).getDepartment());
        holder.tv_gender.setText(mData.get(position).getGender());
        holder.tv_bloodpressure.setText(mData.get(position).getBloodPressure());
        holder.tv_respiratoryrate.setText(mData.get(position).getRespiratoryRate());
        holder.tv_bloodoxygenlevel.setText(mData.get(position).getBloodOxygenLevel());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_id;
        private TextView tv_firstname;
        private TextView tv_department;
        private TextView tv_lastname;
        private TextView tv_gender;
        private TextView tv_bloodpressure;
        private TextView tv_respiratoryrate;
        private TextView tv_bloodoxygenlevel;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = (TextView) itemView.findViewById(R.id.patientID);
            tv_firstname = (TextView) itemView.findViewById(R.id.firstname);
            tv_lastname =  (TextView) itemView.findViewById(R.id.lastname);
            tv_department = (TextView) itemView.findViewById(R.id.department);
            tv_gender = (TextView) itemView.findViewById(R.id.gender);
            tv_bloodpressure = (TextView) itemView.findViewById(R.id.bloodpressure);
            tv_respiratoryrate =  (TextView) itemView.findViewById(R.id.respiratoryrate);
            tv_bloodoxygenlevel = (TextView) itemView.findViewById(R.id.bloodoxygenlevel);


        }
    }

}
