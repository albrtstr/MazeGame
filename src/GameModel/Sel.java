/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import java.awt.Color;

/**
 *
 * @author basisa02
 */
public class Sel {

    private int posisiX;
    private int posisiY;
    private int lebar;
    private int tinggi;
    private char nilai;
    private Color warna;

    public Sel() {
    }

    public Sel(int posisiX, int posisiY, char nilai) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.nilai = nilai;
    }

    public Sel(int posisiX, int posisiY, char nilai, Color warna) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int posisiX, int posisiY, int lebar, int tinggi, char nilai, Color warna) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    public boolean isBatasKiri() {
        if (posisiY * lebar <= 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isBatasKanan() {
        if (posisiY * lebar + lebar < Tempat.batasKanan) {
            return false;
        } else {
            return true;
        }
    }

    public void geserKanan() {
        if (isBatasKanan() == false) {
            posisiY++;
        }
    }

    public void geserKiri() {
        if (isBatasKiri() == false) {
            posisiY--;
        }
    }

    public boolean isBatasAtas() {
        return false;
    }

    public boolean isBatasBawah() {
        return false;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    public Color getWarna() {
        return warna;
    }

    public void setWarna(Color warna) {
        this.warna = warna;
    }

}
