package com.gl.unittesting.unittesting.business;

import com.gl.unittesting.unittesting.service.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	private SomeDataService someDataService;


	public int calculateSum(int[] datas) {

		return Arrays.stream(datas).reduce(Integer::sum).orElse(0);

		/*int sum = 0;
		for(int data:datas) {
			sum+=data;
		}
		return sum;*/
	}

	public int calculateSumUsingSomeDataService() {
		int[] datas = someDataService.retrieveAllData();
		return Arrays.stream(datas).reduce(Integer::sum).orElse(0);
		/*int sum = 0;
		for(int data:datas) {
			sum+=data;
		}

		return sum;*/
	}

}
