package com.example.ajesh.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    private RecyclerView.Adapter myRecycleAdapter;
    List<MyInformationClass>myDataset=new ArrayList<>();
    MyInformationClass data1,data2,data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerViewlayout);
        myRecyclerView.setHasFixedSize(true);



        data1=new MyInformationClass();
        data2=new MyInformationClass();
        data3=new MyInformationClass();

        data1.maintext="test";
        data1.subtext="first";

        data2.maintext="test2";
        data2.subtext="second";

        data3.maintext="test3";
        data3.subtext="third";

        myDataset.add(data1);
        myDataset.add(data2);
        myDataset.add(data3);

        //layoutmanager for the recyclerview
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        // specify an adapter which connects with the recyclerview
        myRecycleAdapter = new MyRecyclerAdapter(myDataset);
        myRecyclerView.setAdapter(myRecycleAdapter);
    }
}
