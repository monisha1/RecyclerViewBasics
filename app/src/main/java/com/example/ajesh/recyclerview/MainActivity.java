package com.example.ajesh.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    private MyRecyclerAdapter myRecycleAdapter;
    List<MyInformationClass>myDataset=new ArrayList<>();
    int number=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerViewlayout);
        myRecyclerView.setHasFixedSize(true);

        //layoutmanager for the recyclerview
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        // specify an adapter which connects with the recyclerview
        myRecycleAdapter = new MyRecyclerAdapter(myDataset);
        myRecyclerView.setAdapter(myRecycleAdapter);

        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyInformationClass itemtoadd=new MyInformationClass();
                itemtoadd.maintext="Item"+ String.valueOf(number);
                itemtoadd.subtext="subtext";
                myRecycleAdapter.additembottom(itemtoadd);
                number=number+1;

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recyclermenu, menu);
           return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.iddelete:
                if(number>0) {
                    myRecycleAdapter.removeitembottom();
                    number =number-1;
                }else
                {
                    Snackbar.make(myRecyclerView,"No item to Remove",Snackbar.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
