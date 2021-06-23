package com.example.quizzy;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Categoryadapter extends RecyclerView.Adapter<Categoryadapter.Viewholder> {
    private List<Categorymodel> categorymodelList;

    public Categoryadapter(List<Categorymodel> categorymodelList) {
        this.categorymodelList = categorymodelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setdata(categorymodelList.get(position).getImageurl(),categorymodelList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return categorymodelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        private CircleImageView imageView;
        private TextView title;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.myimageview);
            title=itemView.findViewById(R.id.titleimage);
        }
        private void setdata(String url, final String title){
            Glide.with(itemView.getContext()).load(url).into(imageView);
            this.title.setText(title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),Setsactivity.class);
                    intent.putExtra("title",title);
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
