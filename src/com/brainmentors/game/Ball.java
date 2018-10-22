package com.brainmentors.game;

import java.awt.Color;
import java.awt.Graphics;

import com.brainmentors.utils.GameConstants;
import com.brainmentors.utils.RandomFunction;

public class Ball implements GameConstants{
	private int x;
	private int y;
	private int w;
	private int h;
	private int xspeed;
	private int yspeed;
	private Color color;
	private static RandomFunction r;
	private static RandomFunction xrandom;
	private static RandomFunction yrandom;
	private static final int Fix_speed=10;
	private boolean isVisible=true;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getXspeed() {
		return xspeed;
	}
	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}
	public int getYspeed() {
		return yspeed;
	}
	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public static RandomFunction getR() {
		return r;
	}
	public static void setR(RandomFunction r) {
		Ball.r = r;
	}
	public static RandomFunction getXrandom() {
		return xrandom;
	}
	public static void setXrandom(RandomFunction xrandom) {
		Ball.xrandom = xrandom;
	}
	public static RandomFunction getYrandom() {
		return yrandom;
	}
	public static void setYrandom(RandomFunction yrandom) {
		Ball.yrandom = yrandom;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public static int getColor_counter() {
		return color_counter;
	}
	public static void setColor_counter(int color_counter) {
		Ball.color_counter = color_counter;
	}
	public static int getFixSpeed() {
		return Fix_speed;
	}
	
	static{
		xrandom=new RandomFunction(GAME_WIDTH);
		yrandom=new RandomFunction(GAME_HEIGHT);
		r=new RandomFunction(Fix_speed);
		color_counter=1;
	}
	private static int color_counter;
	public Color preparecolor(){
		Color color=Color.YELLOW;
	switch(color_counter){	
	case 1: color=Color.RED;
		break;
		case 2: color=Color.GREEN;
		break;
		case 3: color=Color.CYAN;
		break;
		case 4: color=Color.ORANGE;
		break;
		case 5: color=Color.BLUE;
		case 6: color=Color.MAGENTA;
		break;
		case 7: color=Color.WHITE;
		break;
	}
	if (color_counter>7){
		color_counter=0;
	}
	color_counter++;
	return color;
	}
	public Ball(){
	x=xrandom.getRandomNumber();
	System.out.println(x);
	y=yrandom.getRandomNumber();
	System.out.println(y);
	xspeed=yspeed=r.getRandomNumber();
	w=h=50;
	color=preparecolor();
	}
	public void move(){
		x+=xspeed;
		y+=yspeed;
	}
	public void changedirection(){
	if(x>=(GAME_WIDTH-w)){
		xspeed=-r.getRandomNumber();
	}
	else
		if(x<=0){
			xspeed=r.getRandomNumber();
		}
		else 
			if(y>=(GAME_HEIGHT)-h){
				yspeed=-r.getRandomNumber();	
			}
			else
				if(y<=0){
					yspeed=r.getRandomNumber();
				}
	}
	public void drawBall(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, w, h);
	}

}
