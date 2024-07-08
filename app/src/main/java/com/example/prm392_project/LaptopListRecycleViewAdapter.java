package com.example.prm392_project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import com.bumptech.glide.Glide;

public class LaptopListRecycleViewAdapter extends RecyclerView.Adapter<LaptopListRecycleViewAdapter.VH> {

    private NumberFormat numberFormat = new DecimalFormat("#,###");

    private List<Laptop> data;

    private Context context;

    public LaptopListRecycleViewAdapter(List<Laptop> data) {
        this.data = data;
    }

    int count = 0;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        count++;
        Log.d("manh.debug", "Count = " + count);
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.laptop_item, parent, false);
        return new VH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Laptop laptop = data.get(position);
        holder.setData(laptop);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, LaptopDetailActivity.class);
                i.putExtra("laptopDetail", laptop);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }

    protected class VH extends RecyclerView.ViewHolder {
        private ImageView laptopItemImg;
        private TextView laptopItemName;
        private ImageView laptopItemBrand;
        private TextView laptopItemPrice;

        public VH(@NonNull View itemView) {
            super(itemView);
            bindingView();
            bindingAction();
        }

        private void bindingView() {
            laptopItemImg = itemView.findViewById(R.id.laptopItemImg);
            laptopItemName = itemView.findViewById(R.id.laptopItemName);
            laptopItemBrand = itemView.findViewById(R.id.laptopItemBrand);
            laptopItemPrice = itemView.findViewById(R.id.laptopItemPrice);
        }

        private void bindingAction() {
            itemView.setOnClickListener(this::onItemViewClick);
        }

        private void onItemViewClick(View view) {
            //Toast.makeText(context, tvWord.getText().toString() + "---" + tvDefinition.getText().toString(), Toast.LENGTH_SHORT).show();
//            String title = tvTitle.getText().toString();
//            Drawable ic = icon.getDrawable();
        }

        private void onTvWordClick(View view) {
//            Toast.makeText(context, tvWord.getText().toString(), Toast.LENGTH_SHORT).show();
        }


        public void setData(Laptop laptop) {
            Glide.with(context).load(laptop.getImageUrl())
                    .error(R.drawable.img_placeholder)
                    .placeholder(R.drawable.img_placeholder)
                    .into(laptopItemImg);
            laptopItemName.setText(laptop.getName());
            switch (laptop.getBrand().toLowerCase()) {
                rce(R.drawable.brand_dell);
                break;
            }

            laptopItemPrice.setText(numberFormat.format(laptop.getPrice()) + " đ");
        }
    }

}
