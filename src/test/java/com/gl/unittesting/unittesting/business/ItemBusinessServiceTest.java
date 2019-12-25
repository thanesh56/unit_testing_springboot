package com.gl.unittesting.unittesting.business;

import com.gl.unittesting.unittesting.model.Item;
import com.gl.unittesting.unittesting.repository.ItemRepository;
import com.gl.unittesting.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)//for junit4
@ExtendWith(SpringExtension.class)
public class ItemBusinessServiceTest {

	@InjectMocks ItemBusinessService itemBusinessService;

	//this @Mock annotation automatically call the setter method of that Object variable
	@Mock
	ItemRepository itemRepository;	//mocking the dataService interface


	@Test
	@DisplayName("Testing calculateSumUsingSomeDataService_basic() method")
	public void retrieveAllItem_basic() {

		when(itemRepository.findAll()).thenReturn(
				Arrays.asList(
					new Item(2,"Pull Ball",500,11),
					new Item(3,"Push Ball",5000,11)
				)
		);		//here when retrieveAll() is called then only setting value for returning


		List<Item> items = itemBusinessService.retrieveAllItem();
		assertEquals(5500,items.get(0).getValue(),()->"Somthing went wrong");
		assertEquals(55000,items.get(1).getValue(),()->"Somthing went wrong");
	}



}
