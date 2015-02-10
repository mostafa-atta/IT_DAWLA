package com.example.sqlite;

public class User {
	private int id;
	private String name;
	
	public User(int i, String s){
		id = i;
		name = s;
	}
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
}
