package com.saven.helper;

import java.util.Comparator;

import com.saven.model.Restaurant;

public class sortByName implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant o1, Restaurant o2)
	{
		String name1= o1.getName();
		String name2= o2.getName();
		
		return name1.compareTo(name2);
			
	}

}

 
