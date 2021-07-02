package com.agency.model.database;

public class Main {
	public static void main(String[] args) {
		Database db = Database.getInstance();
		System.out.println(db.getAllTho());
	}
}
