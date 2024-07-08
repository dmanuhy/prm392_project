package com.example.prm392_project;

import android.widget.ImageView;

import java.io.Serializable;

public class Laptop implements Serializable {
    private int id;
    private String name;
    private String imageUrl;
    pri
    public Laptop() {
    }

    public Laptop(int id, String name, String imageUrl, String brand, int price, String cpu, String ram, String rom, String gpu, String screen) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.gpu = gpu;
        this.screen = screen;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

}
