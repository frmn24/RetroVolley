//package com.example.logindanregistervolleymysql;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.widget.LinearLayout;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CardViewCust extends AppCompatActivity {
//    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;
//    AdapterData adapterData;
//    List<String> listData;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_card_view_cust);
//
//        recyclerView = findViewById(R.id.rvData);
//        listData = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            listData.add("data ke " + i);
//        }
//
//        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        adapterData = new AdapterData(this, listData);
//        recyclerView.setAdapter(adapterData);
//        adapterData.notifyDataSetChanged();
//        // Tidak perlu memanggil adapterData.notifyDataSetChanged() di sini
//    }
//}