package com.example.ajesh.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ajesh on 11/1/2015.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {


    List<MyInformationClass> myinformation= Collections.emptyList();
    List<MyInformationClass> myinformationtoadd= Collections.emptyList();

    public MyRecyclerAdapter(List<MyInformationClass> myinfo) {
        this.myinformation=myinfo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowlayout, parent, false);

        MyViewHolder holder=new MyViewHolder(view);
     return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.Maintext.setText(myinformation.get(position).maintext);
        holder.Subtext.setText(myinformation.get(position).subtext);
       // holder.imagethumb.setImageResource(myinformation.get(position).imgthumbid);
    }

    @Override
    public int getItemCount() {
        return myinformation.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Maintext;
        TextView Subtext;
        ImageView imagethumb;

        public MyViewHolder(View itemView) {
            super(itemView);
             Maintext=(TextView)itemView.findViewById(R.id.txtmaintext);
             Subtext=(TextView)itemView.findViewById(R.id.txtsubtext);
             imagethumb=(ImageView)itemView.findViewById(R.id.imgthumb);
        }
    }
    public void additembottom(MyInformationClass object)
    {

        myinformation.add(object);
        //if the list is {a,b,c},and we inserted c, then we should notify the adapter that the position
        // we inserted is c,ie the last position which is size of list(3)-1;
        notifyItemInserted(myinformation.size()-1);
    }
    public void additemtop(MyInformationClass object)
    {
        myinformation.add(0,object);
        //if the list is {a,b,c},and we inserted c, then we should notify the adapter that the position
        // we inserted is c,ie the last position which is size of list(3)-1;
        notifyItemInserted(0);
    }
    public void removeitembottom()
    {
        if(!myinformation.isEmpty()) {

            notifyItemRemoved(myinformation.size() - 1);
            myinformation.remove(myinformation.size() - 1);
        }
    }
    public void removeitemall()
    {
        if(!myinformation.isEmpty()) {
            //granular removal,instead of removing all the items at once,its removed one by one
            int sizedata=myinformation.size();
            for(int i=0;i<sizedata;i++) {
                myinformation.remove(0);
                notifyItemRemoved(0);
            }
        }
    }
    public void addlist(List<MyInformationClass> list)
    {

        this.myinformationtoadd=list;
        for(MyInformationClass singleobject:myinformationtoadd)
        {
            myinformation.add(singleobject);
            notifyItemInserted(myinformation.size()-1);
        }
        myinformationtoadd.clear();

    }

}
