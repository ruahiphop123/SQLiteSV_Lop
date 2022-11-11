package com.example.quanlisinhvien_lop_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.quanlisinhvien_lop_sqlite.Adapter.SVAdapter;
import com.example.quanlisinhvien_lop_sqlite.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class showSVTheoLop extends AppCompatActivity {
    private Spinner spinnerLop;
    private ListView listViewSVTheoLop;
    private SQLiteDatabase database;
    private List<SinhVien> sinhVienList;
    private SVAdapter adapter;
    private SinhVien sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_svtheo_lop);
        getSupportActionBar().hide();
        sinhVienList = new ArrayList<>();
        spinnerLop = findViewById(R.id.spinner2);
        database = openOrCreateDatabase("sinhvien.db", MODE_PRIVATE, null);
        ArrayAdapter<CharSequence> Aadapter = ArrayAdapter.createFromResource(this,R.array.spiner_lop,android.R.layout.simple_spinner_item);
        Aadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLop.setAdapter(Aadapter);
        spinnerLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    sv = null;
                    loadAllSV();
                }
                else
                {
                    sv = sinhVienList.get(i);
                    loadSVTheoLop(sv.getMaLopNo().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sv = null;
            }
        });
    }

    public void loadSVTheoLop(String maLop) {
        if (database != null) {
            Cursor cursor = database.query("SinhVien", null, "maLopNo = ?", new String[]{maLop}, null, null, null);
            cursor.moveToFirst();
            sinhVienList = new ArrayList<>();
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
            adapter = new SVAdapter(showSVTheoLop.this, R.layout.line_sinhvien, sinhVienList);
            listViewSVTheoLop = (ListView) findViewById(R.id.listSVTheoLop);
            listViewSVTheoLop.setAdapter(adapter);
        }
    }

    public void loadAllSV() {
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
            adapter = new SVAdapter(showSVTheoLop.this, R.layout.line_sinhvien, sinhVienList);
            listViewSVTheoLop = (ListView) findViewById(R.id.listSVTheoLop);
            listViewSVTheoLop.setAdapter(adapter);
        }
    }
}