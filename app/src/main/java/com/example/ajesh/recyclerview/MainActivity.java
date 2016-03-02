package com.example.ajesh.recyclerview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    private MyRecyclerAdapter myRecycleAdapter;
    List<MyInformationClass>myDataset=new ArrayList<>();
    MyInformationClass data1,data2,data3;
    Spinner spinner;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recyclermenu, menu);
        MenuItem item = menu.findItem(R.id.idspinner);
        spinner = (Spinner) MenuItemCompat.getActionView(item);
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerarray, android.R.layout.simple_spinner_dropdown_item); //  create the adapter from a StringArray
// set the adapter to provide layout of rows and content
        spinner.setAdapter(mSpinnerAdapter);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
