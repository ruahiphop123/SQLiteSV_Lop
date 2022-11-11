package com.example.quanlisinhvien_lop_sqlite;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quanlisinhvien_lop_sqlite.model.SinhVien;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    String msg;
    Button btToDS, btToDSTheoLop, btToAddSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        doDeleteDatabase();
        getDatabase();

        btToDS = findViewById(R.id.buttonToList);
        btToDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,showListSV.class);
                startActivity(intent);
            }
        });

        btToDSTheoLop = findViewById(R.id.buttonToDSLop);
        btToDSTheoLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,showSVTheoLop.class);
                startActivity(intent);
            }
        });

        btToAddSV = findViewById(R.id.buttonToAdd);
        btToAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddSinhVien.class);
                startActivity(intent);
            }
        });
    }

    public boolean isTableExists(SQLiteDatabase database, String tableName) {
        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public void doDeleteDatabase(){
        if(deleteDatabase("sinhvien.db")==true)
        {
            msg = "Delete database 'sinhvien.db' is successful";
        }
        else
        {
            msg = "Delete database 'sinhvien.db' is failed";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void doCreateLopTable(){
        String sql = "create table Lop(maLop TEXT primary key, tenLop TEXT, gVCN Text)";
        database.execSQL(sql);
    }

    public void doCreateSinhVienTable(){
        String sql = "create table SinhVien(sTT TEXT primary key, maSV TEXT, tenSV TEXT,  diemToan INTEGER, diemTin INTEGER, diemTA INTEGER, maLopNo TEXT)";
        database.execSQL(sql);
    }

    public void doInsertRecord() {
        ContentValues values = new ContentValues();
        values.put("maLop", "20T1");
        values.put("tenLop", "Công nghệ thông tin 1");
        values.put("gvcn", "Thầy Phát");
        if (database.insert("Lop", null, values) == -1) {
            msg = "Failed to insert Lop";
        }
        values.put("maLop", "20T2");
        values.put("tenLop", "Công nghệ thông tin 2");
        values.put("gvcn", "Cô Hoài");
        database.insert("Lop",null,values);
        values.put("maLop", "20DH3");
        values.put("tenLop", "Đồ Hoạ 3");
        values.put("gvcn", "Giáo viên 3");
        database.insert("Lop",null,values);
        values.put("maLop", "20CNS1");
        values.put("tenLop", "Công nghệ số 1");
        values.put("gvcn", "Thầy Tuân");
        database.insert("Lop",null,values);

        ContentValues values1 = new ContentValues();
        values1.put("sTT", "SV1");
        values1.put("maSV", "2050531200131");
        values1.put("tenSV", "Nguyễn Trí Đức");
        values1.put("diemToan", 9);
        values1.put("diemTin", 10);
        values1.put("diemTA",10);
        values1.put("maLopNo", "20T1");
        database.insert("SinhVien", null,values1);


        values1.put("sTT", "SV2");
        values1.put("maSV", "2050531200151");
        values1.put("tenSV", "Nguyễn Hải Long");
        values1.put("diemToan", 8);
        values1.put("diemTin", 5);
        values1.put("diemTA",9);
        values1.put("maLopNo", "20T1");
        database.insert("SinhVien", null,values1);

        values1.put("sTT", "SV3");
        values1.put("maSV", "2050531200234");
        values1.put("tenSV", "Nguyễn Văn Phước");
        values1.put("diemToan", 9);
        values1.put("diemTin", 8);
        values1.put("diemTA",4);
        values1.put("maLopNo", "20T2");
        database.insert("SinhVien", null,values1);

        values1.put("sTT", "SV4");
        values1.put("maSV", "2050531200311");
        values1.put("tenSV", "Huỳnh Văn An");
        values1.put("diemToan", 9);
        values1.put("diemTin", 10);
        values1.put("diemTA",5);
        values1.put("maLopNo", "20CNS1");
        database.insert("SinhVien", null,values1);

        values1.put("sTT", "SV5");
        values1.put("maSV", "2050531200191");
        values1.put("tenSV", "Nguyễn Hải Ly");
        values1.put("diemToan", 8);
        values1.put("diemTin", 7);
        values1.put("diemTA",9);
        values1.put("maLopNo", "20T1");
        database.insert("SinhVien", null,values1);

        values1.put("sTT", "SV6");
        values1.put("maSV", "2050531200111");
        values1.put("tenSV", "Nguyễn Văn An");
        values1.put("diemToan", 10);
        values1.put("diemTin", 5);
        values1.put("diemTA",9);
        values1.put("maLopNo", "20T2");
        database.insert("SinhVien", null,values1);

        values1.put("sTT", "SV7");
        values1.put("maSV", "2050531200177");
        values1.put("tenSV", "Nguyễn Vũ Linh");
        values1.put("diemToan", 8);
        values1.put("diemTin", 3);
        values1.put("diemTA",3);
        values1.put("maLopNo", "20CNS1");
        database.insert("SinhVien", null,values1);

        values1.put("sTT", "SV8");
        values1.put("maSV", "2050531200132");
        values1.put("tenSV", "Nguyễn Dương Lâm");
        values1.put("diemToan", 10);
        values1.put("diemTin", 10);
        values1.put("diemTA",9);
        values1.put("maLopNo", "20T1");
        database.insert("SinhVien", null,values1);
    }

    public SQLiteDatabase getDatabase()
    {
        database = openOrCreateDatabase("sinhvien.db", MODE_PRIVATE, null);
        try
        {
            if(database!=null)
            {
                if(isTableExists(database,"Lop"))
                    return database;
                doCreateLopTable();
                doCreateSinhVienTable();
                doInsertRecord();
                Toast.makeText(this, "Tạo", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
        return database;
    }

    private ActivityResultLauncher<Intent> getResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        Bundle dataBundle = data.getBundleExtra("bundle");
                        SinhVien newSV = (SinhVien) dataBundle.getSerializable("svnew");
                        ContentValues values = new ContentValues();
                        values.put("sTT", 9);
                        values.put("maSV", newSV.getMaSV());
                        values.put("tenSV", newSV.getTenSV());
                        values.put("diemToan", newSV.getDiemToan());
                        values.put("diemTin", newSV.getDiemTin());
                        values.put("diemTA", newSV.getDiemTA());
                        values.put("maLopNo", newSV.getMaLopNo());
                        database.insert("SinhVien", null,values);
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED){
                        Toast.makeText(MainActivity.this,"Bạn chưa thêm",Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );
}