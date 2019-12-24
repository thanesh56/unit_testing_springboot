package com.gl.unittesting.unittesting.business;

import com.gl.unittesting.unittesting.service.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[]{4};
	}
}


public class SomeBusinessImplTest {
	
	@Test
	public void test_basic() {
	SomeBusinessImpl sumBusinessImpl = 	new SomeBusinessImpl();
		assertEquals(4, sumBusinessImpl.calculateSum(new int[] {2,2}),()->"Somthing went wrong");
	}

	@Test
	public void calculateSumUsingSomeDataService() {
		SomeBusinessImpl sumBusinessImpl = 	new SomeBusinessImpl();
		sumBusinessImpl.setSomeDataService(new SomeDataServiceStub());
		assertEquals(4,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}


}
