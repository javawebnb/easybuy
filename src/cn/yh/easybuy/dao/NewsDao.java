package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.News;

import cn.yh.easybuy.entity.Page;

public interface NewsDao {
	/**
	 * ������������
	 * @return
	 */
	List<News> findAllNews(Page<News> page);
	/**
	 * ͨ��ID��������
	 * @param id
	 * @return
	 */
	News findNewsById(Integer id);
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
	
	/**
	 * ������ŵ��ܼ�¼��
	 */
	Integer getCount();
}
