package com.example.prm392_project;

import android.widget.ImageView;

public class Laptop {
    private int id;
    private String name;
    private ImageView image;
    private String brand;
    private int price;
    private String cpu;
    private String ram;
    private String rom;
    private String gpu;
    private String screen;

    public Laptop(int id) {
        this.id = id;
    }

    public Laptop(int id, String name, ImageView image, String brand, int price, String cpu, String ram, String rom, String gpu, String screen) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.gpu = gpu;
        this.screen = screen;
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

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
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
