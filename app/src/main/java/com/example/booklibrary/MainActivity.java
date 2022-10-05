package com.example.booklibrary;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import com.example.booklibrary.Adaptors.BookAdaptor;
import com.example.booklibrary.Models.BookModel;
import com.example.booklibrary.Services.NetworkBroadcast;
import com.example.booklibrary.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        broadcastReceiver=new NetworkBroadcast();
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        ArrayList<BookModel> list=new ArrayList<>();
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
//        list.add(new BookModel(R.drawable.india_2020,"Nobel"));
//        list.add(new BookModel(R.drawable.dramatic_decade, "Nobel"));
        BookAdaptor adaptor=new BookAdaptor(list,MainActivity.this);
        binding.recyleView.setAdapter(adaptor);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        binding.recyleView.setLayoutManager(gridLayoutManager);
//        Log.d("Rahul", "onDataChange: "+list.size());
        list.clear();
        FirebaseDatabase.getInstance().getReference().child("books")
                .addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("Rahul", "onDataChange: ");
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    Log.d("Rahul", "onDataChange: "+list.size());
                    BookModel model=snapshot1.getValue(BookModel.class);
                    list.add(model);

                }
                adaptor.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}