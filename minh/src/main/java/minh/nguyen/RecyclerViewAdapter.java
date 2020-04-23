package minh.nguyen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {



    Context mContext;
    List<PatientInfo> mData;


    public RecyclerViewAdapter(Context mContext, List<PatientInfo> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.layout_format,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_id.setText(mData.get(position).getID());
        holder.tv_firstname.setText(mData.get(position).getFirstName());
        holder.tv_lastname.setText(mData.get(position).getLastName());
        holder.tv_department.setText(mData.get(position).getDepartment());

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



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = (TextView) itemView.findViewById(R.id.patientID);
            tv_firstname = (TextView) itemView.findViewById(R.id.firstname);
            tv_lastname =  (TextView) itemView.findViewById(R.id.lastname);
            tv_department = (TextView) itemView.findViewById(R.id.department);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String idnew = tv_id.getText().toString();
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MinhActivity5.class);
                    intent.putExtra("option2",idnew);
                    context.startActivity(intent);
                }
            });
        }
    }

}
