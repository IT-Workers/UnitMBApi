package com.unitmb.api.menu.model;

import java.io.Serializable;

import com.unitmb.api.internal.model.UnitMBApiModel;

public class Menu extends UnitMBApiModel implements Serializable{

	/**
	 * @author Sun yan
	 * 菜单
	 */
	private static final long serialVersionUID = -1082186018784845861L;
	
	private int menuId;
	
	private String menuName;
	
	private int parentMenuId;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	
	
}
