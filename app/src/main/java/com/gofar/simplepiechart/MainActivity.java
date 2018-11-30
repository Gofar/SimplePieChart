package com.gofar.simplepiechart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gofar.library.PieChartItemData;
import com.gofar.library.PieChartView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PieChartView pieChartView = findViewById(R.id.pie_chart);

        List<PieChartItemData> dataList = new ArrayList<>();
        PieChartItemData data1 = new PieChartItemData();
        data1.setTitle("data1");
        data1.setColor(Color.CYAN);
        data1.setSize(40);
        data1.setStartAngle(0);
        data1.setSweepAngle(40);
        PieChartItemData data2 = new PieChartItemData();
        data2.setTitle("data2");
        data2.setColor(Color.YELLOW);
        data2.setSize(80);
        data2.setStartAngle(40);
        data2.setSweepAngle(80);
        PieChartItemData data3 = new PieChartItemData();
        data3.setTitle("data3");
        data3.setColor(Color.GREEN);
        data3.setSize(30);
        data3.setStartAngle(120);
        data3.setSweepAngle(30);
        PieChartItemData data4 = new PieChartItemData();
        data4.setTitle("data4");
        data4.setColor(Color.MAGENTA);
        data4.setSize(120);
        data4.setStartAngle(150);
        data4.setSweepAngle(120);
        PieChartItemData data5 = new PieChartItemData();
        data5.setTitle("data5");
        data5.setColor(Color.RED);
        data5.setSize(90);
        data5.setStartAngle(270);
        data5.setSweepAngle(90);
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);
        dataList.add(data5);

        pieChartView.setOutBorderColor(Color.parseColor("#a58bdf"));
        pieChartView.setData(dataList);
    }
}
