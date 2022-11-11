package com.example.quanlisinhvien_lop_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlisinhvien_lop_sqlite.model.SinhVien;

public class AddSinhVien extends AppCompatActivity {
    Button btThem;
    EditText txtMa,txtTen, txtLop, txtToan, txtTin, txtTA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        getSupportActionBar().hide();

        txtMa = findViewById(R.id.editTextTextPersonName);
        txtTen = findViewById(R.id.editTextTextPersonName2);
        txtLop = findViewById(R.id.editTextTextPersonName3);
        txtToan = findViewById(R.id.editTextTextPersonName4);
        txtTin = findViewById(R.id.editTextTextPersonName5);
        txtTA = findViewById(R.id.editTextTextPersonName6);

        btThem = findViewById(R.id.buttonThemSV);
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhLogin = new Intent();
                Bundle bundle = new Bundle();
                SinhVien newSV = new SinhVien();
                newSV.setMaSV(txtMa.getText().toString());
                newSV.setTenSV(txtTen.getText().toString());
                newSV.setMaLopNo(txtLop.getText().toString());
                newSV.setDiemToan(Double.valueOf(txtToan.getText().toString()));
                newSV.setDiemTin(Double.valueOf(txtTin.getText().toString()));
                newSV.setDiemTA(Double.valueOf(txtTA.getText().toString()));
                bundle.putSerializable("svnew",newSV);
                mhLogin.putExtra("bundle",bundle);
                setResult(RESULT_OK,mhLogin);
                finish();
            }
        });
    }
}