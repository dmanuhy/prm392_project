package com.example.prm392_project;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LaptopListActivity extends AppCompatActivity {

    private List<Laptop> laptopList;

    private RecyclerView laptopListRcv;

    private void bindingView() {
        laptopListRcv = findViewById(R.id.laptopListRcv);
    }

    private void bindingAction() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_laptop_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bindingView();
        bindingAction();
        loadAllLaptop();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LaptopListRecycleViewAdapter laptopListAdapter = new LaptopListRecycleViewAdapter(laptopList);
        laptopListRcv.setAdapter(laptopListAdapter);
        laptopListRcv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void loadAllLaptop() {
        laptopList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.laptop_fake);
            laptopList.add(new Laptop(i + 1, "Laptop MSI Katana 15", iv, "MSI", 16000000, "Intel Core i7-13200th", "16GB", "512GB", "RTX 4050", "15 inch"));
        }
    }

}