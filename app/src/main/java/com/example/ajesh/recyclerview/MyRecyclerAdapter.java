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


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {


    List<MyInformationClass> myinformation= Collections.emptyList();
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
    public void addlisttop(List<MyInformationClass> list)
    {
        for(int i=0;i<list.size();i++)
        {
            myinformation.add(i,list.get(i));
            notifyItemInserted(i);
        }
    }

}
