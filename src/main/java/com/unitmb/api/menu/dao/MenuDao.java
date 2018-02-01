package com.unitmb.api.menu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.unitmb.api.internal.dao.UnitMBApiDao;
import com.unitmb.api.menu.model.Menu;

@Repository
public class MenuDao extends UnitMBApiDao {
	
	public int updateMenuName(String menuId, String menuName) {
		return jdbcTemplate.update("UPDATE Menu SET menuName= ? WHERE menuId= ?", menuName, menuId);
	}
	
	/**
	 * 保存
	 * @param menu
	 * @return
	 */
	public int insert(Menu menu) {
		return jdbcTemplate.update("INSERT INTO Menu(menuName, parentMenuId) VALUES(?, ?)", menu.getMenuName(), menu.getParentMenuId());
	}

	/**
	 * 获取所有的菜单
	 * @return
	 */
	public List<Map<String, Object>> getAllMenu(){
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList("select * from Menu order by menuId ");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
}
