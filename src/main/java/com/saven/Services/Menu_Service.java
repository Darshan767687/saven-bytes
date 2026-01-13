package com.saven.Services;

import java.util.List;

import com.saven.DAOImpl.Menu_impl;
import com.saven.model.Menu;

public class Menu_Service {
	
	
	public List<Menu> getAllMenu(int restaurantId)
	{
		Menu_impl impl= new Menu_impl();
		return impl.getAllMenu( restaurantId);
	}

}
