package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.News;

public interface NewsDao {
	/**
	 * 通过ID查找新闻
	 * @param id
	 * @return
	 */
	List<News> findNewsById(Integer id);
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
}
