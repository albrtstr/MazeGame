/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import GameModel.Tempat;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author basisa02
 */
public class GameFrame extends JFrame {

    private TempatPanel tempatPanel;
    private JLabel commandLabel;
    private JTextField commandText;
    private JButton okButton;
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;

    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

    public GameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
        
        
        bacaKonfigurasiMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choose = new JFileChooser();
                int returnVal = choose.showOpenDialog(null);
                Tempat tempat = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tempat.bacaKonfigurasiFile(choose.getSelectedFile());
                }
                Tempat.batasKanan = 500;
                Tempat.batasBawah = 300;
                tempatPanel = new TempatPanel();
                tempatPanel.setTempat(tempat);
                init();
            }
        });

        
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        this.commandLabel = new JLabel("Perintah");
        southPanel.add(commandLabel);

        this.commandText = new JTextField(20);
        southPanel.add(commandText);

        this.okButton = new JButton("OK");
        southPanel.add(okButton);

        
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKanan();
            }
        });

        Container cp = this.getContentPane();
        if (tempatPanel != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void pindahKanan() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
        }
        getTempatPanel().repaint();
    }

}
