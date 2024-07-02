package org.example;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.swing.Icon;


class MusicPlayer extends JFrame implements ActionListener {
    String music = "C://Users//HP//IdeaProjects//lesson18//src//main//resources//beepo oxer.wav";
    MP3Player mp3Player = new MP3Player();

    JButton play = new JButton("►");
    JButton stop = new JButton("||");
    JButton makeError = new JButton("make error");
    private boolean isPlaying;

    Color randomColor;
    MusicPlayer(){
        try {
            setSize(600,550);
            setLayout(null);
            setResizable(false);
            ui();
            setVisible(true);
        }catch (Exception e){
            createErrorboi();
        }

    }

    private void ui() {

        play.setBounds(30,450,50,50);
        play.setForeground(Color.BLACK);
        play.setBackground(new Color(9, 123, 5, 255));
        play.setBorder(BorderFactory.createLineBorder(Color.black,3,true));
        play.addActionListener(this);
        add(play);

        stop.setBounds(130,450,50,50);
        stop.setForeground(Color.BLACK);
        stop.setBackground(new Color(9, 123, 5, 255));
        stop.setBorder(BorderFactory.createLineBorder(Color.black,3,true));
        stop.addActionListener(this);
        add(stop);

        makeError.setBounds(230,450,150,50);
        makeError.setForeground(Color.BLACK);
        makeError.setBackground(new Color(9, 123, 5, 255));
        makeError.setBorder(BorderFactory.createLineBorder(Color.black,3,true));
        makeError.addActionListener(this);
        add(makeError);

        JLabel label = new JLabel("beepo oxer");
        label.setBounds(30,360,150,50);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createEmptyBorder());
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).equals(play)&&!isPlaying) {
            try {
                isPlaying = true;
                mp3Player.playMP3(music);
            }catch (Exception ex){
                createErrorboi();
            }
        } else if (((JButton)e.getSource()).equals(stop)&&isPlaying) {
            try {
                isPlaying = false;
                mp3Player.stopMP3(music);
            }catch (Exception ex){
                createErrorboi();
            }
        } else if (((JButton) e.getSource()).equals(makeError)) {
            try {
                throwerror();
            }catch (Exception ex){
                createErrorboi();
            }
        }
    }

    public static void throwerror() throws Exception{
        Exception exception = new Exception();
        throw exception;
    }

    public void createErrorboi(){
        JLabel errorBoi = new JLabel(":)Error<");
        errorBoi.setOpaque(true);
        errorBoi.setForeground(randomColorCreator());
        errorBoi.setBackground(randomColorCreator());
        errorBoi.setBounds((int) (Math.random()*getWidth()),(int) (Math.random()*getHeight()),(int) (Math.random()*getWidth()),(int) (Math.random()*getHeight()));
        errorBoi.setHorizontalTextPosition(0);
        add(errorBoi);
        repaint();
    }

    public Color randomColorCreator(){
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        randomColor = new Color(r,g,b);
        return randomColor;
    }
}
