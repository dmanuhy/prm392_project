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
imptends AppCompatActivity {

    ActionBar actionBar;

    ImageView brandHp;
    ImageView brandAcer;
    ImageView brandAsus;
    ImageView brandDell;
    ImageView brandLenovo;
    ImageView brandMsi;
    ImageView brandMac;

    private List<Laptop> laptopList;

    private List<Laptop> filtered;

    private RecyclerView laptopListRcv;

    private void bindingView() {
        laptopListRcv = findViewById(R.id.laptopListRcv);
        actionBar = getSupportActionBar();

        brandHp = findViewById(R.id.brand_hp);
        brandAcer = findViewById(R.id.brand_acer);
        brandAsus = findViewById(R.id.brand_asus);
        brandMsi = findViewById(R.id.brand_msi);
        brandLenovo = findViewById(R.id.brand_leveno);
        brandDell = findViewByI{

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.t, systemBars.top, systemBars.right, systemBars.bottom);
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
"Laptop Acer Aspire 3", "https://cdn.tgdd.vn/Products/Images/44/321436/acer-aspire-a315-44p-r9w8-r7-nxksjsv002-thumb-600x600.jpg", "ACER", 11990000, "Ryzen 7, 5700U", "8 GB", "512GB SSD", "Radeon", "15.6 inch"));
        laptopList.add(new Laptop(4, "Laptop Lenovo Ideapad Slim 3", "https://cdn.tgdd.vn/Products/Images/44/313333/lenovo-ideapad-slim-3-15iah8-i5-83er00evn-thumb-600x600.jpg", "LENOVO", 14390000, "i5, 12450H", "16 GB", "512GB SSD", "Intel UHD", "15.6 inch"));
        laptopList.add(new Laptop(5, "Laptop Asus TUF Gaming A15", "https://cdn.tgdd.vn/Products/Images/44/322269/asus-tuf-gaming-a15-fa506nf-r5-hn012w-thumb-600x600.jpg", "ASUS", 17990000, "Ryzen 5, 7535HS", "16 GB, LPDDR5", "512GB SSD", "RTX 2050 4GB", "15.6 inch"));
        laptopList.add("Laptop Lenovo Ideapad Gaming 3", "https://cdn.tgdd.vn/Products/Images/44/313667/lenovo-ideapad-gaming-3-15ach6-r5-82k2027pvn-600x600.png", "LENOVO", 15990000, "Ryzen 5, 7520U", "16 GB, LPDDR5", "512GB SSD", "RTX2050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(18, "Laptop MSI Gaming Katana A15 AI", "https://cdn.tgdd.vn/Products/Images/44/322949/msi-gaming-katana-a15-ai-b8vf-r7-419vn-thumb-600x600.jpg", "MSI", 29990000, "Ryzen 7, 8845HS", "16 GB, LPDDR5", "512GB SSD", "RTX 4060 8GB", "15.6 inch"));
        laptopList.add(new Laptop(19, "Laptop MSI Gaming Katana GF66", "https://cdn.tgdd.vn/Products/Images/44/310607/msi-gaming-gf66-12uck-i7-804vn-thumb-600x600.jpg", "MSI", 18990000, "i7, 12650H", "8 GB, LPDDR5", "512GB SSD", "RTX 3050 4GB", "15.6 inch"));
        laptopList.add(new Laptop(20, "Laptop HP 240 G8", "https://cdn.tgdd.vn/Products/Images/44/318165/hp-240-g8-i3-6l1a2pa-glr-thumb-600x600.jpg", "HP", 9490000, "i3, 1115G4", "8 GB, LPDDR5", "512GB SSD", "Intel UHD", "15.6 inch"));
    }
}