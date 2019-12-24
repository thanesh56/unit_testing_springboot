package com.gl.unittesting.unittesting.business;

import com.gl.unittesting.unittesting.service.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//@RunWith(SpringJUnit4ClassRunner.class)//for junit4
@ExtendWith(SpringExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl sumBusinessImpl;

	@Mock	//this @Mock annotation automatically call the setter method of that Object variable
	SomeDataService dataServiceMock;	//mocking the dataService interface

	/*@BeforeEach		//it is automatically called by @Mock annotation
	void beforeEach(){
		sumBusinessImpl.setSomeDataService(dataServiceMock);
	}*/


	@Test
	@DisplayName("Testing calculateSumUsingSomeDataService_basic() method")
	public void calculateSumUsingSomeDataService_basic() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{2,2});//here when retrieveAllData() is called then only setting value for returning

		assertEquals(4,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}

	@Test
	@DisplayName("Testing calculateSumUsingSomeDataService_empty() method")
	public void calculateSumUsingSomeDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});//here when retrieveAllData() is called then only setting value for returning

		assertEquals(0,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}

	@Test
	@DisplayName("Testing calculateSumUsingSomeDataService_oneValue()method")
	public void calculateSumUsingSomeDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});//here when retrieveAllData() is called then only setting value for returning

		assertEquals(5,sumBusinessImpl.calculateSumUsingSomeDataService(),()->"Somthing went wrong");
	}


}
