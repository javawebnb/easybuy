package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.NewsBiz;
import cn.yh.easybuy.dao.NewsDao;
import cn.yh.easybuy.dao.impl.NewsDaoImpl;
import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.entity.Page;

public class NewsBizImpl implements NewsBiz{
	NewsDao nd=new NewsDaoImpl();
	@Override
	public News findNewsById(Integer id) {
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

	@Override
	public Page<News> findAllNews(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		Page<News> page=new Page<News>();
		Integer count = nd.getCount();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(count);
		List<News> list = nd.findAllNews(page);
		page.setPageList(list);
		return page;
	}

	

}
