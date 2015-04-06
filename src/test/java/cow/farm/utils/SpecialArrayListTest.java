package cow.farm.utils;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cow.farm.CowHerdService;


	public class SpecialArrayListTest {
		CowHerdService cowherdservice = new CowHerdService();

//		private void setUp() {
//
//		}
	
	@Test
	public void shouldReturnTheQuantityOfCowsByRace() {
		//given:
		cowherdservice.createCowAndAddToCowlist("Czarna");
		cowherdservice.createCowAndAddToCowlist("Czarna");
		cowherdservice.createCowAndAddToCowlist("Biała");
		cowherdservice.createCowAndAddToCowlist("Biała");
		
		HashMap<Object, Integer> quantityHashmap = cowherdservice.getTheCowlist().getQuantityOfEachRace();
		Integer i = 2;
		Assert.assertEquals(quantityHashmap.get("Czarna"),i);
		
}

	
	
}