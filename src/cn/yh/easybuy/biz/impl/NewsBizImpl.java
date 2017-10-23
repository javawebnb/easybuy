package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.NewsBiz;
import cn.yh.easybuy.dao.NewsDao;
import cn.yh.easybuy.dao.impl.NewsDaoImpl;
import cn.yh.easybuy.entity.News;

public class NewsBizImpl implements NewsBiz{
	NewsDao nd=new NewsDaoImpl();
	@Override
	public List<News> findNewsById(Integer id) {
		// TODO Auto-generated method stub
		
		return nd.findNewsById(id);
	}

	@Override
	public Integer saveNews(News news) {
		// TODO Auto-generated method stub
		return nd.saveNews(news);
	}

	@Override
	public Integer updateNews(News news) {
		// TODO Auto-generated method stub
		return nd.updateNews(news);
	}

	@Override
	public Integer delNews(Integer id) {
		// TODO Auto-generated method stub
		return nd.delNews(id);
	}

}
