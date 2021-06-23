package com.example.quizzy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myref=database.getReference();

   private RecyclerView recyclerView;
   private   List<Categorymodel> list;
    Categoryadapter categoryadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);
Toolbar toolbar=findViewById(R.id.mytooll);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



     recyclerView=findViewById(R.id.recycleviewmy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

   list =new ArrayList<Categorymodel>();
     list.add(new Categorymodel("","category"));
        list.add(new Categorymodel("","category"));
        list.add(new Categorymodel("","category"));
        list.add(new Categorymodel("","category"));



 categoryadapter=new Categoryadapter(list);

        recyclerView.setAdapter(categoryadapter);


  /* myref.child("Categories").addListenerForSingleValueEvent(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           Toast.makeText(CategoryActivity.this, dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();

          for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
              list.add(dataSnapshot1.getValue(Categorymodel.class));
          }
         categoryadapter.notifyDataSetChanged();


       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {
         *//*  Toast.makeText(CategoryActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();*//*

       }
   });*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
