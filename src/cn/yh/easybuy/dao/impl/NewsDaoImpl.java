package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.NewsDao;
import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class NewsDaoImpl implements NewsDao{

	@Override
	public List<News> findNewsById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		NewsDao nd=session.getMapper(NewsDao.class);
		List<News> nlist=nd.findNewsById(id);
		session.close();
		return nlist;
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

}
