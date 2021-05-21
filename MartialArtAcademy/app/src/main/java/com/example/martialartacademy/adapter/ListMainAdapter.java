package com.example.martialartacademy.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.martialartacademy.R;
import com.example.martialartacademy.database.model.ModalityModel;
import com.example.martialartacademy.database.model.PlanModel;
import com.example.martialartacademy.database.model.StudentModel;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ListMainAdapter extends BaseAdapter {

    private Activity act;
    private ArrayList<StudentModel> studentlist;
    private ArrayList<ModalityModel> modalitylist;
    private ArrayList<PlanModel> planlist;

    public ListMainAdapter(final Activity act, final ArrayList<StudentModel> studentlist, final ArrayList<ModalityModel> modalitylist, final ArrayList<PlanModel> planlist ){
        this.act = act;
        this.studentlist = studentlist;
        this.modalitylist = modalitylist;
        this.planlist = planlist;
    }
    @Override
    public int getCount() {
        return studentlist.size();
    }

    public int getCountModalities() {
        return modalitylist.size();
    }
    @Override
    public Object getItem(int position) {
        return studentlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = act.getLayoutInflater().inflate(R.layout.activity_dashboard, parent, false);

        TextView studentquantitatyID = convertView.findViewById(R.id.studentquantitatyID);
        studentquantitatyID.setText("Quantidade de aluno : " + getCount() );

        TextView modalityquantitaty = convertView.findViewById(R.id.modalityquantitaty);
        modalityquantitaty.setText("Quantidade de cadastros : " + getCountModalities() );

        TextView Total = convertView.findViewById(R.id.Total);
        Total.setText("Total a receber : " + (planlist.get(position).getMonthlyvalue().multiply(new BigDecimal(getCount()))));

        return convertView;
    }
}
