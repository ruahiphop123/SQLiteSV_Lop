package com.example.quanlisinhvien_lop_sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlisinhvien_lop_sqlite.R;
import com.example.quanlisinhvien_lop_sqlite.model.SinhVien;

import java.util.List;

public class SVAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> list;

    public SVAdapter(Context context, int layout, List<SinhVien> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView maSV, ten, maLop, diemTB;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.ten = view.findViewById(R.id.txtTen);
            holder.maSV = view.findViewById(R.id.txtMaSV);
            holder.maLop = view.findViewById(R.id.txtLop);
            holder.diemTB = view.findViewById(R.id.txtDTB);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        SinhVien sv = list.get(i);

        holder.ten.setText(sv.getTenSV());
        holder.maLop.setText(sv.getMaLopNo());
        holder.maSV.setText(sv.getMaSV());
        holder.diemTB.setText(String.valueOf(sv.getDiemTB()));

        return view;
    }
}
