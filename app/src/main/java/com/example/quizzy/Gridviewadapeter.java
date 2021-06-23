package com.example.quizzy;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Gridviewadapeter extends BaseAdapter {

    private int sets=0;

    public Gridviewadapeter(int sets) {
        this.sets = sets;
    }

    @Override
    public int getCount() {
        return sets;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        View view;
        if(convertView==null){

            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.setiem,parent,false);

        }
        else{
            view=convertView;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(parent.getContext(),Questionactivity.class);
                parent.getContext().startActivity(intent);
            }
        });

        ((TextView)view.findViewById(R.id.settextview)).setText(String.valueOf(position+1));
        return view;
    }
}
