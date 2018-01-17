package com.project.ninjagold.models;

import java.util.Date;
import java.util.Random;


public class Activity{
	private String location;
	private int gold;
	private String color;
	private String text;
	private Date date;
	
	public Activity(String location, int min, int max){
		this.location = location;
		this.date = new Date();
		randomize(min,max);
		generate();
	}

	public int range(int min, int max){
		Random r  = new Random();
		int rand = r.nextInt(max - min + 1) + min;
		return rand;
	}

	public void randomize(int min, int max){
		this.gold = range(min, max);
	}

	public void generate(){
		this.text = "You entered a ";
		if (this.gold > 0){
			this.text += this.location + " and earned " + this.gold + " gold (" + this.date+")";
			this.color = "green";
		}
		else {
			this.text += this.location + " and lost " + Math.abs(this.gold) + " gold (" + this.date+")";
			this.color = "red";
		}
	}

	public int getGold() {
		return this.gold;
	}

	public String getText() {
		return this.text;
	}

	public Date getDate() {
		return this.date;
	}

	public String getColor() {
		return this.color;
	}
}
