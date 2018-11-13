/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author basisa02
 */
public class Tempat {

    private int tinggi;
    private int lebar;
    private ArrayList<Sel> daftarSel = new ArrayList<>();
    private String isi;

    public static int batasKanan;
    public static int batasBawah;

    public void bacaKonfigurasiFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String hasilBaca = "";
            int dataInt;
            int posisiX = 0;
            int posisiY = 0;
            int t = 50;
            int l = 50;

            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt != '\n') {
                    if ((char) dataInt == '#') {
                        hasilBaca += (char) dataInt;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataInt);
                        sel.setPosisiX(posisiX);
                        sel.setPosisiY(posisiY);
                        sel.setLebar(l);
                        sel.setTinggi(t);
                        sel.setWarna(Color.RED);
                        this.addSel(sel);
                        posisiY++;
                        
                    } else if ((char) dataInt == '.') {
                        hasilBaca += (char) dataInt;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataInt);
                        sel.setPosisiX(posisiX);
                        sel.setPosisiY(posisiY);
                        sel.setLebar(l);
                        sel.setTinggi(t);
                        sel.setWarna(Color.BLACK);
                        this.addSel(sel);
                        posisiY++;
                        
                    } else if ((char) dataInt == '@') {
                        hasilBaca += (char) dataInt;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataInt);
                        sel.setPosisiX(posisiX);
                        sel.setPosisiY(posisiY);
                        sel.setLebar(l);
                        sel.setTinggi(t);
                        sel.setWarna(Color.BLUE);
                        this.addSel(sel);
                        posisiY++;
                        
                    } else if ((char) dataInt == 'O') {
                        hasilBaca += (char) dataInt;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataInt);
                        sel.setPosisiX(posisiX);
                        sel.setPosisiY(posisiY);
                        sel.setLebar(l);
                        sel.setTinggi(t);
                        sel.setWarna(Color.GREEN);
                        this.addSel(sel);
                        posisiY++;
                    }
                    
                } else {
                    hasilBaca += (char) dataInt;
                    posisiX++;
                    posisiY = 0;
                }
            }
            this.setIsi(hasilBaca);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSel(Sel sel) {
        daftarSel.add(sel);
    }

    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

}
