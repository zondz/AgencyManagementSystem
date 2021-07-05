package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.Tho;
import com.agency.model.database.Database;
import com.agency.service.ThoServiceRepository;

public class ThoServiceRepositoryImplement implements ThoServiceRepository{
	Database database = Database.getInstance();

	public List<Tho> getAllTho() {
		// TODO Auto-generated method stub
		return database.getAllTho();
	}
	
	public static void main(String[] args) {
		ThoServiceRepository temp = new ThoServiceRepositoryImplement();
		System.out.println(temp.getAllTho());
	}

}
