package com.brainmentors.utils;

import java.util.Random;

public class RandomFunction {
  private Random random;
  private int range;
  public RandomFunction(int randomrange){
	  this.range=randomrange;
	  random=new Random(randomrange);  
  }
  public int getRandomNumber(){
	  int result=random.nextInt(range);
	  return result==0?1:result;
  }
}
