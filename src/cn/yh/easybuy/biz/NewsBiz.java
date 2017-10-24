package cn.yh.easybuy.biz;

import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.entity.Page;

public interface NewsBiz {
	/**
	 * ������������
	 * @return
	 */
	Page<News> findAllNews(Integer pageIndex,Integer pageSize);
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
}
