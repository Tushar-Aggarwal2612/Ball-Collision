package com.brainmentors.game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.brainmentors.utils.GameConstants;

import jaco.mp3.player.MP3Player;

public class GameFrame extends JFrame implements GameConstants {
	MP3Player song;
	private void playsound(){
	song=new MP3Player(GameFrame.class.getResource(MUSIC));
	song.play();
	song.setRepeat(true);
	}
	public GameFrame(int noofballs){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setTitle(GAME_NAME);
		setResizable(false);
		Board board= new Board(noofballs);
		add(board);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				askforClose();
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		playsound();
	}
	private void askforClose(){
		int choice=JOptionPane.showConfirmDialog(this, "Do you want to leave this game","BALL-COLLISION",JOptionPane.YES_NO_OPTION);
		if(choice==JOptionPane.YES_OPTION){
			song.stop();
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		}
		else{
			return;
		}
	}
	public static int asknoofballs(){
	String balls=JOptionPane.showInputDialog("Enter the number of balls:");
	//if(JOptionPane.CANCEL_OPTION){
	//}
	return Integer.parseInt(balls);
	
	
	}
public static void main(String args[]){
	GameFrame frame=new GameFrame(asknoofballs());
}
}
