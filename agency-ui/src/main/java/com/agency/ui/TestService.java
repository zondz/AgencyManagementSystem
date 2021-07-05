package com.agency.ui;

import com.agency.service.ThoServiceRepository;
import com.agency.serviceimplement.ThoServiceRepositoryImplement;

public class TestService {
	ThoServiceRepository temp = new ThoServiceRepositoryImplement();
	public static void main(String[] args) {
		System.out.println("Running in test service");
		TestService temp = new TestService();
		System.out.println(temp.temp.getAllTho());
	}
	
}
