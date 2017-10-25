package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.News;

import cn.yh.easybuy.entity.Page;

public interface NewsDao {
	/**
	 * 查找所有新闻
	 * @return
	 */
	List<News> findAllNews(Page<News> page);
	/**
	 * 通过ID查找新闻
	 * @param id
	 * @return
	 */
	News findNewsById(Integer id);
	/**
	 * 添加新闻
	 * @param news
	 * @return
	 */
	Integer saveNews(News news);
	/**
	 * 修改新闻
	 * @param news
	 * @return
	 */
	Integer updateNews(News news);
	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	Integer delNews(Integer id);
	
	/**
	 * 获得新闻的总记录数
	 */
	Integer getCount();
}
