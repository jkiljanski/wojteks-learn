package com.farm;

import cow.farm.utils.SpecialArrayList;

public class CowHerdService {

	public CowHerdService() {
		// TODO Auto-generated constructor stub
	}
	private SpecialArrayList<Cow> cowlist = new SpecialArrayList<Cow>();
	
	public Cow createCowAndAddToCowlist(String name, String race) {
		Cow aCow = new Cow ();
		aCow.setName(name);
		aCow.setRace(race);
		cowlist.add(aCow);		
		return aCow;
		}

	
	

}
