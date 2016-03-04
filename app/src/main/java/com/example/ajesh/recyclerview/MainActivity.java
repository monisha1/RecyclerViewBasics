package com.example.ajesh.recyclerview;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.ColorUtils;
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
        MenuItem item = menu.findItem(R.id.idspinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setBackgroundColor(Color.parseColor("#ffffff"));
        String[] choose={"Add 10 item","Remove 10items"};
        SpinnerAdapter mSpinnerAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,choose);
        spinner.setAdapter(mSpinnerAdapter); // set the adapter to provide layout of rows and content
        spinner.setOnItemSelectedListener(itemSelectedListener); // set the listener, to perform actions based on item selection
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
    private AdapterView.OnItemSelectedListener itemSelectedListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position==0)
            {
                MyInformationClass myInformationClass=new MyInformationClass();
                List<MyInformationClass> list=new ArrayList<>(10);
                for(int i=0;i<10;i++)
                {
                    myInformationClass=new MyInformationClass();
                    myInformationClass.maintext="BulkListItem"+ String.valueOf(number);
                    myInformationClass.subtext="subtext";
                    list.add(myInformationClass);
                    number=number+1;
                }
                myRecycleAdapter.addlist(list);

            }
            if(position==1)
            {
                myRecycleAdapter.removeitemall();
                number=0;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

}
