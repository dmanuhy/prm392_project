package com.example.prm392_project;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LaptopListActivity extends AppCompatActivity {

    ActionBar actionBar;

    private List<Laptop> laptopList;

    private RecyclerView laptopListRcv;

    private void bindingView() {
        laptopListRcv = findViewById(R.id.laptopListRcv);
        actionBar = getSupportActionBar();
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
        setContentView(R.layout.activity_laptop_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bindingView();
        bindingAction();
        customizeActionBar();
        loadAllLaptop();
        initRecyclerView();
    }

    private void customizeActionBar() {
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Laptop EZ</font>"));
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

    private void initRecyclerView() {
        LaptopListRecycleViewAdapter laptopListAdapter = new LaptopListRecycleViewAdapter(laptopList);
        laptopListRcv.setAdapter(laptopListAdapter);
        laptopListRcv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void loadAllLaptop() {
        laptopList = new ArrayList<>();
        laptopList.add(new Laptop(1, "Laptop Asus Vivobook Go 15", "https://cdn.tgdd.vn/Products/Images/44/311178/asus-vivobook-go-15-e1504fa-r5-nj776w-thumb-600x600.jpg", "ASUS", 12490000, "Ryzen 5, 7520U", "16 GB, LPDDR5", "512GB SSD", "Radeon", "15.6 inch"));
        laptopList.add(new Laptop(2, "Laptop HP 15", "https://cdn.tgdd.vn/Products/Images/44/326050/hp-15-fd0303tu-i3-a2nl4pa-thumb-1-600x600.jpg", "HP", 11190000, "i3, 1315U", "8 GB", "512GB SSD", "Intel UDH", "15.6 inch"));
        laptopList.add(new Laptop(3, "Laptop Acer Aspire 3", "https://cdn.tgdd.vn/Products/Images/44/321436/acer-aspire-a315-44p-r9w8-r7-nxksjsv002-thumb-600x600.jpg", "ACER", 11990000, "Ryzen 7, 5700U", "8 GB", "512GB SSD", "Radeon", "15.6 inch"));
        laptopList.add(new Laptop(4, "Laptop Lenovo Ideapad Slim 3", "https://cdn.tgdd.vn/Products/Images/44/313333/lenovo-ideapad-slim-3-15iah8-i5-83er00evn-thumb-600x600.jpg", "LENOVO", 14390000, "i5, 12450H", "16 GB", "512GB SSD", "Intel UHD", "15.6 inch"));
        laptopList.add(new Laptop(5, "Laptop Asus TUF Gaming A15", "https://cdn.tgdd.vn/Products/Images/44/322269/asus-tuf-gaming-a15-fa506nf-r5-hn012w-thumb-600x600.jpg", "ASUS", 17990000, "Ryzen 5, 7535HS", "16 GB, LPDDR5", "512GB SSD", "RTX 2050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(6, "Laptop Acer Gaming Aspire 5", "https://cdn.tgdd.vn/Products/Images/44/314630/acer-aspire-5-a515-58gm-51lb-i5-nxkq4sv002-170923-015941-600x600.jpg", "ACER", 18490000, "i5, 13420H", "16 GB, LPDDR5", "512GB SSD", "RTX 2050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(7, "Laptop HP Gaming VICTUS 15", "https://cdn.tgdd.vn/Products/Images/44/321467/hp-victus-15-fb1022ax-r5-94f19pa-thumb-1-600x600.jpg", "HP", 18490000, "Ryzen 5, 7520U", "16 GB, LPDDR5", "512GB SSD", "RTX2050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(8, "Laptop MSI Gaming GF63", "https://cdn.tgdd.vn/Products/Images/44/308697/msi-gaming-gf63-thin-12ve-i5-460vn-thumb-600x600.png", "MSI", 17990000, "i5, 12450H", "8 GB", "512GB SSD", "RTX 4050 6GB", "15.6 inch"));
        laptopList.add(new Laptop(9, "Laptop Apple MacBook Air 13", "https://cdn.tgdd.vn/Products/Images/44/322612/macbook-air-13-inch-m3-2024-050324-020626-600x600.jpg", "MacBook", 27690000, "Apple M3", "8 GB", "256GB SSD", "8 nhân GPU", "13.6 inch"));
        laptopList.add(new Laptop(10, "Laptop MSI Gaming Cyborg 15", "https://cdn.tgdd.vn/Products/Images/44/325795/msi-cyborg-15-a12ve-i7-240vn-thumb-600x600.jpg", "MSI", 22490000, "i7, 12650H", "16 GB, LPDDR5", "512GB SSD", "RTX 4060 6GB", "15.6 inch"));
        laptopList.add(new Laptop(11, "Laptop Dell Inspiron 15 3520", "https://cdn.tgdd.vn/Products/Images/44/321192/dell-inspiron-15-3520-i5-25p231-250424-020344-600x600.jpg", "DELL", 16490000, "i5, 1235U", "16 GB, LPDDR5", "512GB SSD", "Intel Iris Xe", "15.6 inch"));
        laptopList.add(new Laptop(12, "Laptop Dell Inspiron 15 3530", "https://cdn.tgdd.vn/Products/Images/44/325247/dell-inspiron-15-3530-i7-p16wd-thumb-600x600.jpg", "DELL", 21990000, "i7, 1355U", "16 GB, LPDDR5", "1TB SSD", "Intel Iris Xe", "15.6 inch"));
        laptopList.add(new Laptop(13, "laptop Asus Vivobook 15 OLED", "https://cdn.tgdd.vn/Products/Images/44/325477/asus-asus-vivobook-15-oled-a1505za-i5-ma415w-thumb-600x600.jpg", "ASUS", 17490000, "Ryzen 5, 7520U", "16 GB, LPDDR5", "512GB SSD", "Radeon", "15.6 inch"));
        laptopList.add(new Laptop(14, "Laptop Dell Vostro 15 3520", "https://cdn.tgdd.vn/Products/Images/44/303835/dell-vostro-15-3520-i5-5m2tt2-thumb-laptop-600x600.jpg", "DELL", 15490000, "Ryzen 5, 7520U", "16 GB, LPDDR5", "512GB SSD", "Radeon", "15.6 inch"));
        laptopList.add(new Laptop(15, "Laptop Apple MacBook Pro 14", "https://cdn.tgdd.vn/Products/Images/44/318231/apple-macbook-pro-14-inch-m3-pro-2023-12-core-311023-095219-600x600.jpg", "MacBook", 79690000, "Apple M3 Max", "36 GB", "1TB SSD", "30 nhân GPU", "14.2 inch"));
        laptopList.add(new Laptop(16, "Laptop Lenovo Ideapad 1 15ALC7", "https://cdn.tgdd.vn/Products/Images/44/313627/lenovo-ideapad-1-15alc7-r7-82r400c1vn-thumb-1-600x600.jpg", "LENOVO", 12690000, "Ryzen 7, 7520U", "16 GB, LPDDR5", "512GB SSD", "Radeon", "15.6 inch"));
        laptopList.add(new Laptop(17, "Laptop Lenovo Ideapad Gaming 3", "https://cdn.tgdd.vn/Products/Images/44/313667/lenovo-ideapad-gaming-3-15ach6-r5-82k2027pvn-600x600.png", "LENOVO", 15990000, "Ryzen 5, 7520U", "16 GB, LPDDR5", "512GB SSD", "RTX2050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(18, "Laptop MSI Gaming Katana A15 AI", "https://cdn.tgdd.vn/Products/Images/44/322949/msi-gaming-katana-a15-ai-b8vf-r7-419vn-thumb-600x600.jpg", "MSI", 29990000, "Ryzen 7, 8845HS", "16 GB, LPDDR5", "512GB SSD", "RTX 4060 8GB", "15.6 inch"));
        laptopList.add(new Laptop(19, "Laptop MSI Gaming Katana GF66", "https://cdn.tgdd.vn/Products/Images/44/310607/msi-gaming-gf66-12uck-i7-804vn-thumb-600x600.jpg", "MSI", 18990000, "i7, 12650H", "8 GB, LPDDR5", "512GB SSD", "RTX 3050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(20, "Laptop HP 240 G8", "https://cdn.tgdd.vn/Products/Images/44/318165/hp-240-g8-i3-6l1a2pa-glr-thumb-600x600.jpg", "HP", 9490000, "i3, 1115G4", "8 GB, LPDDR5", "512GB SSD", "Intel UHD", "15.6 inch"));

    }
}