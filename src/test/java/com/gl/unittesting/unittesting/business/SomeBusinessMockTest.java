package com.gl.unittesting.unittesting.business;

import com.gl.unittesting.unittesting.service.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {
	
	@Test
	public void test_basic() {
	SomeBusinessImpl sumBusinessImpl = 	new SomeBusinessImpl();
		assertEquals(4, sumBusinessImpl.calculateSum(new int[] {2,2}),()->"Somthing went wrong");
	}

	@Test
	public void calculateSumUsingSomeDataService_basic() {
		SomeBusinessImpl sumBusinessImpl = 	new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);	//mocking the dataService interface
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{2,2});//here when retrieveAllData() is called then only setting value for returning

		sumBusinessImpl.setSomeDataService(dataServiceMock);
		assertEquals(4,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}

	@Test
	public void calculateSumUsingSomeDataService_empty() {
		SomeBusinessImpl sumBusinessImpl = 	new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);	//mocking the dataService interface
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});//here when retrieveAllData() is called then only setting value for returning

		sumBusinessImpl.setSomeDataService(dataServiceMock);
		assertEquals(0,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}

	@Test
	public void calculateSumUsingSomeDataService_oneValue() {
		SomeBusinessImpl sumBusinessImpl = 	new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);	//mocking the dataService interface
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});//here when retrieveAllData() is called then only setting value for returning

		sumBusinessImpl.setSomeDataService(dataServiceMock);
		assertEquals(5,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}


}
