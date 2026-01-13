package com.saven.helper;

import java.util.Comparator;

import com.saven.model.Restaurant;

public class sortByRating implements Comparator<Restaurant>
{

	@Override
	public int compare(Restaurant o1, Restaurant o2) {

		Integer rating1=o1.getRating();
		Integer rating2=o2.getRating();
		
		
		return rating1.compareTo(rating2);
	}
	
}
