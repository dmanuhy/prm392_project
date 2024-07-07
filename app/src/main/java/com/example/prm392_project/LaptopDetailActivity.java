package com.example.prm392_project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class LaptopDetailActivity extends AppCompatActivity {

    ActionBar actionBar;

    ImageView laptopDetailImage;

    TextView laptopDetailName;

    TextView laptopDetailPrice;

    TextView laptopDetailCPU;
    TextView laptopDetailRAM;
    TextView laptopDetailROM;
    TextView laptopDetailGPU;

    private void bindingView() {
        actionBar = getSupportActionBar();
        laptopDetailImage = findViewById(R.id.laptopDetailImage);
        laptopDetailName = findViewById(R.id.laptopDetailName);
        laptopDetailPrice = findViewById(R.id.laptopDetailPrice);
        laptopDetailCPU = findViewById(R.id.laptopDetailCPU);
        laptopDetailRAM = findViewById(R.id.laptopDetailRAM);
        laptopDetailROM = findViewById(R.id.laptopDetailROM);
        laptopDetailGPU = findViewById(R.id.laptopDetailGPU);
    }

    private void bindingAction() {
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0079e5"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_laptop_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();
        bindingAction();
        customizeActionBar();
        receiveIntent();
    }

    private void customizeActionBar() {
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Laptop EZ - Chắc Thế</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navbar, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void receiveIntent() {
        Intent i = getIntent();
        Laptop laptop = (Laptop) i.getSerializableExtra("laptopDetail");
        Glide.with(this).load(laptop.getImageUrl())
                .error(R.drawable.img_placeholder)
                .placeholder(R.drawable.img_placeholder)
                .into(laptopDetailImage);
        laptopDetailName.setText(laptop.getName());
        laptopDetailPrice.setText(String.valueOf(laptop.getPrice()));
        laptopDetailCPU.setText(laptop.getCpu());
        laptopDetailRAM.setText(laptop.getRam());
        laptopDetailROM.setText(laptop.getRom());
        laptopDetailGPU.setText(laptop.getGpu());
    }

}