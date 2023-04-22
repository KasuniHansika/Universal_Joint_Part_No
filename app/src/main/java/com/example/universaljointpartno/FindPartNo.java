package com.example.universaljointpartno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class FindPartNo extends AppCompatActivity {

    EditText cap_dia, yoke_lockup, part_no;
    ImageButton imageButton_search, imageButton_exist;
    myDbAdapter helper;

    DataSet dataset[] = {
            new DataSet(13, 37, "ST1337"),
            new DataSet(15, 38, "ST1538"),
            new DataSet(15, 39, "ST1539"),
            new DataSet(15, 40, "ST1540")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_part_no);

        cap_dia = (EditText) findViewById(R.id.editText_cap_dia);
        yoke_lockup = (EditText) findViewById(R.id.editText_yoke_lockup);
        part_no = (EditText) findViewById(R.id.editText_part_no);
        imageButton_search = (ImageButton) findViewById(R.id.imageButton_search);
        imageButton_exist = (ImageButton) findViewById(R.id.imageButton_exist);

        /*helper = new myDbAdapter(this);*/
        imageButton_search.setOnClickListener(view -> {
            double cap_dia_text = Double.parseDouble(cap_dia.getText().toString());
            double yoke_lockup_text = Double.parseDouble(yoke_lockup.getText().toString());


            System.out.println(cap_dia_text);
            System.out.println(yoke_lockup_text);

            for (DataSet dataSet : dataset) {
                if(dataSet.getCap() == cap_dia_text && dataSet.getYoke() == yoke_lockup_text){
                    part_no.setText(dataSet.getPart());
                    return;
                }else {
                    part_no.setText("Not Found");
                }
            }

        });

        imageButton_exist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are finishing activity.
                FindPartNo.this.finish();

                // on below line we are exiting our activity
                System.exit(0);
            }
        });
    }

    /*public void viewdata(View view)
    {
        String data = helper.getData();
        Message.message(this,data);
    }*/
}

class DataSet {
    private double cap;
    private double yoke;
    private String part;

    DataSet() {

    }

    DataSet(double cap, double yoke, String part) {
        this.cap = cap;
        this.yoke = yoke;
        this.part = part;
    }

    public void setCap(double cap) {
        this.cap = cap;
    }

    public void setYoke(double yoke) {
        this.yoke = yoke;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public double getCap() {
        return cap;
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "cap=" + cap +
                ", yoke=" + yoke +
                ", part=" + part +
                '}';
    }

    public double getYoke() {
        return yoke;
    }

    public String getPart() {
        return part;
    }
}