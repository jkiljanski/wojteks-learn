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
		cowherdservice.createCowAndAddToCowlist("Czarna", "Hela");
		cowherdservice.createCowAndAddToCowlist("Czarna", "Mela");
		cowherdservice.createCowAndAddToCowlist("Biała", "Ryszard");
		cowherdservice.createCowAndAddToCowlist("Biała", "Henryk");
		cowherdservice.createCowAndAddToCowlist("Biała", "Andrzej");
		
		
		HashMap<Object, Integer> quantityHashmap = cowherdservice.getQuantityOfEachRace();
		Integer i = 2;
		Assert.assertEquals(quantityHashmap.get("Czarna"),i);
		
		System.out.println(quantityHashmap.entrySet());
}

	

}