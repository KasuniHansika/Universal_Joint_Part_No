package com.example.universaljointpartno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.Connection;

public class UniversalJointList extends AppCompatActivity {

    ImageButton btnDimension;
    TextView edtDimension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_joint_list);
    }

}