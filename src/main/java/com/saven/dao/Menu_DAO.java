package com.saven.dao;

import java.util.List;

import com.saven.model.Menu;

public interface Menu_DAO {
	
	public void addMenu(Menu menu, int  restaurantId);
	public Menu getMenu(int id);
	public void updateMenu(Menu menu);
	public void deleteMenu(int id);
	public List<Menu> getAllMenu(int restaurantId);

}
