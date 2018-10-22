package com.brainmentors.game;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

import com.brainmentors.utils.GameConstants;

public class GameIntro extends JWindow implements GameConstants{ 
JLabel label= new JLabel();
JProgressBar progressbar= new JProgressBar();
private Timer timer;
private int progressVal;
private void Animation(){
	timer= new Timer(50,(e)->{
		if(progressVal>100){
		timer.stop();
		GameFrame gameframe= new GameFrame(GameFrame.asknoofballs());
		GameIntro.this.setVisible(false);
		GameIntro.this.dispose();
		}
		progressbar.setValue(progressVal);
		progressVal++;
	});
	timer.start();
}
 public GameIntro(){
	 progressbar.setStringPainted(true);
	 setBackground(Color.RED);
	 setSize(500,300);
	 setLocationRelativeTo(null);
	 ImageIcon img= new ImageIcon(GameIntro.class.getResource("UnderConstructionGif.gif"));
	// Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	 
	 //setName("Ball-Collision");
	 //get this image in the centre window.jpg
	 //create a cancel operation when asking no of balls
	 
	 label.setIcon(img);
	 //label.setPreferredSize();
	 add(label,BorderLayout.CENTER);
	 add(progressbar,BorderLayout.NORTH);
	 setVisible(true);
 }
public static void main(String args[]){
	GameIntro intro= new GameIntro();
	intro.Animation();
}
}
