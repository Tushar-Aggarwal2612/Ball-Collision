package com.brainmentors.game;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.utils.GameConstants;
import com.brainmentors.utils.RandomFunction;


public class Board extends JPanel implements GameConstants{
	private Timer timer;
	private int score;
	Ball balls[];
	public Board(int noofballs){
		balls= new Ball[noofballs];
		prepareBalls();
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setBackground(Color.BLACK);
	   gameloop();
	}
	private void prepareBalls(){
		for(int i=0;i<balls.length;i++){
			Ball ball= new Ball();
			balls[i]=ball;
		}
		
	}
	private void gameloop(){
		timer=new Timer(50,(e)->{
			this.repaint();
		});
		timer.start();
	}
	final int FIX_SPEED=35;
	int x=100;
	int xspeed=5;
	RandomFunction r= new RandomFunction(FIX_SPEED);
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	drawballs(g);
	printscore(g);
	GameOver(g);
	}
	
	private void drawballs(Graphics g){
		for(Ball ball: balls){
			if(ball.isVisible()){
			ball.drawBall(g);
		   ball.move();
		   ball.changedirection();
		   traverseballs();
		}
		}
	}
	private void printscore(Graphics g){
		g.setColor(Color.RED);
		g.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC, 35));
		g.drawString("SCORE"+score, 100, 50);
	}
	private void traverseballs(){
		for(int i=0;i<balls.length-1;i++) {
			for(int j=i+1;j<balls.length;j++ ) {
				if(balls[i].isVisible() && balls[j].isVisible()) {
					 if(isCollision(balls[i],balls[j])) {
					score++;
						 balls[i].setVisible(false);
						 balls[j].setVisible(false);
					 }
				}
			}
		}
	}
	private boolean isCollision(Ball firstBall, Ball secondBall) {
		int xDistance= Math.abs(firstBall.getX()-secondBall.getX());
		int yDistance= Math.abs(firstBall.getY()-secondBall.getY());
	return xDistance<=firstBall.getW() && yDistance<=firstBall.getH();
	}
	boolean isVisible=true;
	int printCounter=0;
	private void GameOver(Graphics g) {
		boolean isGameover=true;
		for(Ball ball : balls) {
			if(ball.isVisible()) {
				isGameover=false;
				break;
			}
		}
		if(isGameover) {
			if(printCounter>=5) {
				String message=isVisible?"GAME-OVER":"";
				g.setFont(new Font("Arial",Font.ITALIC,45));
				g.setColor(Color.RED);
				g.drawString(message, ((GAME_WIDTH/2)-100), (GAME_HEIGHT/2));
				isVisible=!isVisible;
				printCounter=0;
			}
		printCounter++;
		}
	}

}
