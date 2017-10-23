package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.News;

public interface NewsDao {
	/**
	 * ͨ��ID��������
	 * @param id
	 * @return
	 */
	List<News> findNewsById(Integer id);
	/**
	 * �������
	 * @param news
	 * @return
	 */
	Integer saveNews(News news);
	/**
	 * �޸�����
	 * @param news
	 * @return
	 */
	Integer updateNews(News news);
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	Integer delNews(Integer id);
}
