package cow.farm.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WojteksArrayListTest {

	private WojteksArrayList objectUnderTest;

	private WojteksArrayList aBigObjectUnderTest;

	@BeforeMethod
	public void setUp() {

		objectUnderTest = new WojteksArrayList();

		// extract method
		aBigObjectUnderTest = new WojteksArrayList() {
			{
				int i = 0;
				while (i < 100) {
					add("token");
					i++;
				}
			}
		};

	}

	@Test
	public void shouldHaveSize0OnNoOp() {
		// given

		// when
		int size = objectUnderTest.size();
		// then
		Assert.assertEquals(size, 0);
	}

	@Test
	public void shouldHaveSize1AfterAddingOne() {
		// given
		objectUnderTest.add("krowa");
		// when
		int size = objectUnderTest.size();
		// then
		Assert.assertEquals(size, 1);
	}

	@Test
	public void shouldReturnOneInsertedObject() {
		// given
		String insertedObject = "krowa";
		objectUnderTest.add(insertedObject);

		// when
		Object returnedObject = objectUnderTest.get(0);

		// then
		Assert.assertEquals(returnedObject, insertedObject);
	}

	@Test
	public void changesSizeWhenExpected() {
		// given
		String insertedObject = "krowa";
		objectUnderTest.add(insertedObject);
		objectUnderTest.add(insertedObject);
		objectUnderTest.add(insertedObject);
		// when
		objectUnderTest.remove(2);

		// then
		Assert.assertEquals(objectUnderTest.size(), 2);

	}

	// TODO name
	@Test
	public void checkTheRemoveMethod() {
		// given
		String anObject = "cośtam";
		objectUnderTest.add(anObject);
		//FIXME fixed values
		int expectedSize = objectUnderTest.size() - 1;
		// when
		Object returnedObject = objectUnderTest.remove(0);
		// then
		Assert.assertEquals(anObject, returnedObject);
		Assert.assertEquals(objectUnderTest.size(), expectedSize);
	}

	@Test
	public void checkIndexOf() {
		//given
		objectUnderTest.add(23);
		objectUnderTest.add(10, 15);
		//when
		objectUnderTest.printMe();
		//then
		Assert.assertEquals(objectUnderTest.indexOf(23), 0);
		Assert.assertEquals(objectUnderTest.indexOf(15), 10);

	}

	@Test
	public void checkTheIterator() {
		// given
		Iterator iterator = objectUnderTest.iterator();
		objectUnderTest.add(2);
		objectUnderTest.add(3);
		objectUnderTest.add(5);
		int index0Obj = 2;
		int index1Obj = 3;
		int index2Obj = 5;
		// when
		Object actualIndex0Object = iterator.next();
		Object actualIndex1Object = iterator.next();
		Object actualIndex2Object = iterator.next();
		// then
		Assert.assertEquals(actualIndex0Object, index0Obj);
		Assert.assertEquals(actualIndex1Object, index1Obj);
		Assert.assertEquals(actualIndex2Object, index2Obj);

	}

	@Test
	public void checkContainsMethod() {
		// given
		//FIXME small letter variable name
		aBigObjectUnderTest.add(23);
		// when
		boolean actualResult = aBigObjectUnderTest.contains(23);
		// then
		//FIXME inline expected
		Assert.assertEquals(actualResult, true);
	}

	@Test
	public void checkAddAll() {
		// given
		objectUnderTest.add("some random string");
		objectUnderTest.add("some random string");
		objectUnderTest.add("some random string");
		int expectedSize = objectUnderTest.size() + aBigObjectUnderTest.size();

		// when

		objectUnderTest.addAll(aBigObjectUnderTest);

		// then

		Assert.assertEquals(objectUnderTest.size(), expectedSize);

	}

	//FIXME should...
	@Test
	public void checkAddingWith2Params() {
		// given:

		// when:

		objectUnderTest.add(1, "ja");
		objectUnderTest.add(2, "ty");
		objectUnderTest.add(3, "on");
		objectUnderTest.add(4, "my");
		objectUnderTest.add(5, "wy");
		objectUnderTest.add(6, "oni");
		objectUnderTest.add(7, 1);
		objectUnderTest.add(8, 2);

		// then::

		Assert.assertEquals(objectUnderTest.get(1), "ja");
		Assert.assertEquals(objectUnderTest.get(2), "ty");
		Assert.assertEquals(objectUnderTest.get(3), "on");
		Assert.assertEquals(objectUnderTest.get(4), "my");
		Assert.assertEquals(objectUnderTest.size(), 9);

	}

	@Test
	public void checkAddAllWith2Params() {
		// given:
		objectUnderTest.add(1);
		objectUnderTest.add(2);
		objectUnderTest.add(3);
		objectUnderTest.add(4);
		int expectedSizeAfterOperation = aBigObjectUnderTest.size()
				+ objectUnderTest.size();
		// when:
		aBigObjectUnderTest.addAll(22, objectUnderTest);
		// then:
		Assert.assertEquals(aBigObjectUnderTest.size(),
				expectedSizeAfterOperation);
		Assert.assertEquals(aBigObjectUnderTest.indexOf(1), 22);
		Assert.assertEquals(aBigObjectUnderTest.indexOf(2), 23);
		Assert.assertEquals(aBigObjectUnderTest.indexOf(3), 24);
		Assert.assertEquals(aBigObjectUnderTest.indexOf(4), 25);
		aBigObjectUnderTest.printMe();

	}

	@Test
	public void checkToArray() {
		// given:
		int a = aBigObjectUnderTest.size();
		int b = aBigObjectUnderTest.toArray().length;
		// result:
		Assert.assertEquals(a, b);
	}

	@Test
	public void shouldIncreaseArraySize() {
		//TODO finish me
		// use INITIAL_SIZE to fill up the array
		// then add one element and check if eleven elements are in order
		for (int i = 0; i < WojteksArrayList.INITIAL_SIZE; i++) {
			objectUnderTest.add(i);
		}
		System.out.println("SHOULD INCREASE ARRAY SIZE");
		objectUnderTest.printMe();
		List o = objectUnderTest;
		//when
		objectUnderTest.add("nowy element");
		objectUnderTest.printMe();
		//then		
		WojteksArrayList a = (WojteksArrayList) objectUnderTest.subList(0, 11);
		a.printMe();
		boolean equals = Arrays.equals(a.toArray(), o.toArray());
		boolean equalsAlternative = Arrays.equals(a.toArray(), Arrays.copyOfRange(objectUnderTest.toArray(), 0, 11));
		Assert.assertEquals(equalsAlternative, true);

	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenIndexIsNegative() {
		objectUnderTest.get(-1);

	}

	@Test
	public void shouldCheckSublistMethod() {
		objectUnderTest.add(1);
		objectUnderTest.add(2);
		objectUnderTest.add(3);
		objectUnderTest.add(4);
		objectUnderTest.add(5);
		objectUnderTest.add(6);
		objectUnderTest.add(7);
		objectUnderTest.add(8);
		//when
		WojteksArrayList a = (WojteksArrayList) objectUnderTest.subList(3, 7);

		//then
		Assert.assertEquals(a.get(0), 4);
		Assert.assertEquals(a.get(1), 5);
		Assert.assertEquals(a.get(2), 6);
		objectUnderTest.printMe();
	}

	@Test
	public void shouldCheckTheRemoveAllMethod() {
		objectUnderTest.add(1);
		objectUnderTest.add(2);
		objectUnderTest.add(3);
		WojteksArrayList b = new WojteksArrayList();
		b.add(2);
		b.add(3);
		b.add(1);
		objectUnderTest.removeAll(b);
		objectUnderTest.printMe();

	}

	@Test
	public void shouldRetainAllElementsInCollection() {
		//given:
		objectUnderTest.add(1);
		objectUnderTest.add(1);
		objectUnderTest.add(2);
		objectUnderTest.add(2);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.addAll(aBigObjectUnderTest);

		System.out.println("RETAIN ALL");
		objectUnderTest.printMe();

		WojteksArrayList aCollection = new WojteksArrayList();
		aCollection.add(2);
		//when:

		objectUnderTest.retainAll(aCollection);

		objectUnderTest.printMe();

		//then:
		Assert.assertEquals(!objectUnderTest.contains(1) && !objectUnderTest.contains(3), true);

	}

	@Test
	public void shouldCleanUpAllNulls() {
		objectUnderTest.add(1);
		objectUnderTest.add(1);
		objectUnderTest.add(2);
		objectUnderTest.add(2);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.add(3);
		objectUnderTest.addAll(aBigObjectUnderTest);

		WojteksArrayList aCollection = new WojteksArrayList();
		aCollection.add(2);
		//when:

		objectUnderTest.retainAll(aCollection);
		objectUnderTest.cleanUp();
		System.out.println("CLEAN UP CHECK");
		objectUnderTest.printMe();

		Assert.assertEquals(objectUnderTest.contains(null), false);

	}

}