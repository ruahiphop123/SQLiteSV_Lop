package com.example.quanlisinhvien_lop_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.quanlisinhvien_lop_sqlite.Adapter.SVAdapter;
import com.example.quanlisinhvien_lop_sqlite.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class showListSV extends AppCompatActivity {
    SQLiteDatabase database;
    List<SinhVien> sinhVienList;
    SVAdapter adapter;
    ListView listViewSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_sv);
        getSupportActionBar().hide();

        sinhVienList = new ArrayList<>();
        updateUI();
    }

    public void updateUI() {
        database = openOrCreateDatabase("sinhvien.db", MODE_PRIVATE, null);
        if (database != null) {
            Cursor cursor = database.query("SinhVien", null, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                SinhVien data = new SinhVien();
                data.setsTT(cursor.getInt(0));
                data.setMaSV(cursor.getString(1));
                data.setTenSV(cursor.getString(2));
                data.setMaLopNo(cursor.getString(6));
                data.setDiemToan(cursor.getDouble(3));
                data.setDiemTin(cursor.getDouble(4));
                data.setDiemTA(cursor.getDouble(5));
                sinhVienList.add(data);
                cursor.moveToNext();
            }
            cursor.close();
            adapter = new SVAdapter(showListSV.this, R.layout.line_sinhvien, sinhVienList);
            listViewSV = (ListView) findViewById(R.id.listSV);
            listViewSV.setAdapter(adapter);
        }
    }
}