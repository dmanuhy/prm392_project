package com.example.prm392_project;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaptopDetailActivity extends AppCompatActivity {

    private NumberFormat numberFormat;

    ActionBar actionBar;

    private SharedPreferences.Editor editor;

    private SharedPreferences sharedPref;
DetailImage;

    TextView laptopDetailName;

    TextView laptopDetailPrice;

    TextView laptopDetailCPU;
    TextView laptopDetailRAM;
    TextView laptopDetailROM;
    TextView laptopDetailGPU;

    private void bindingView() {
        actionBar = getSupportActionBar();
        numberFormat = new DecimalFormat("#,###");

        sharedPref = getSharedPreferences("CART", MODE_PRIVATE);
        editor = sharedPref.edit();

        addToCart = findViewById(R.id.btnAddToCart);
        buyNow = findViewById(R.id.btnBuyNow);
        call = findViewById(R.id.btnCall);

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
        addToCart.setOnClickListener(this::handleAddToCart);
        call.setOnClickListener(this::handleCall);
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

    private void handleAddToCart(View view) {
        Toast.makeText(this, "Đã thêm sản phẩm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
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

    public void receiveIntent() {
        Intent i = getIntent();
        Laptop laptop = (Laptop) i.getSerializableExtra("laptopDetail");
        Glide.with(this).load(laptop.getImageUrl())
                .error(R.drawable.img_placeholder)
                .placeholder(R.drawable.img_placeholder)
                .into(laptopDetailImage);
        laptopDetailName.setText(laptop.getName());
        laptopDetailPrice.setText(numberFormat.format(laptop.getPrice()) + " đ");
        laptopDetailCPU.setText(laptop.getCpu());
        laptopDetailRAM.setText(laptop.getRam());
        laptopDetailROM.setText(laptop.getRom());
        laptopDetailGPU.setText(laptop.getGpu());
    }

    private void handleCall(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                // Show a custom dialog explaining why the permission is needed
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Phone Call Permission");
                builder.setMessage("We need access to make phone calls for our app. Please grant the permission.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Request the permission again
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.show();
            } else {
                // Request the permission directly
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        } else {
            // Permission already granted, proceed with making the phone call
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0987654321"));
            startActivity(i);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, proceed with making the phone call
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0987654321"));
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Phone Call Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
            break;
        }
    }

}