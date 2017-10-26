package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.NewsDao;
import cn.yh.easybuy.entity.News;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class NewsDaoImpl implements NewsDao{
	
	@Override
	public List<News> findAllNews(Page<News> page) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		List<News> nlist=nd.findAllNews(page);
		session.close();
		return nlist;
	}

	@Override
	public News findNewsById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		News news=nd.findNewsById(id);
		session.close();
		return news;
	}

	@Override
	public Integer saveNews(News news) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		int i=nd.saveNews(news);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Integer updateNews(News news) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		int i=nd.updateNews(news);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Integer delNews(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		int i=nd.delNews(id);
		session.commit();
		session.close();
		return i;
	}
	/**
	 * 获得新闻的总记录数
	 */
	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = 0;
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		count = nd.getCount();
		return count;
	}

}
