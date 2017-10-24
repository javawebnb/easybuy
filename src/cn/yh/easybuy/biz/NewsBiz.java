package cn.yh.easybuy.biz;

import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.entity.Page;

public interface NewsBiz {
	/**
	 * 查找所有新闻
	 * @return
	 */
	Page<News> findAllNews(Integer pageIndex,Integer pageSize);
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
}
