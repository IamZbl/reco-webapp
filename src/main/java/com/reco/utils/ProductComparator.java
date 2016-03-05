package com.reco.utils;

import java.util.Comparator;

import com.reco.appmodel.ProductAppObject;

public class ProductComparator implements Comparator<ProductAppObject> {

	public int compare(ProductAppObject o1, ProductAppObject o2) {
		int returnVal = 0;
		if (o1.getMilage() > o2.getMilage()) {
			returnVal = 1;
		} else {
			returnVal = 1;
		}
		return returnVal;
	}

}
