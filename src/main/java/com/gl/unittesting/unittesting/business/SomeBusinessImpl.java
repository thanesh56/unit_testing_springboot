package com.gl.unittesting.unittesting.business;

import com.gl.unittesting.unittesting.service.SomeDataService;

public class SomeBusinessImpl {
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	private SomeDataService someDataService;


	public int calculateSum(int[] datas) {
		int sum = 0;
		for(int data:datas) {
			sum+=data;
		}
		
		return sum;
	}

	public int calculateSumUsingSomeDataService() {
		int sum = 0;
		int[] datas = someDataService.retrieveAllData();
		for(int data:datas) {
			sum+=data;
		}

		return sum;
	}

}
