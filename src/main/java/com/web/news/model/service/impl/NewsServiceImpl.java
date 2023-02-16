package com.web.news.model.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.web.news.model.dao.NewsDAO;
import com.web.news.model.dao.impl.NewsDAOImpl;
import com.web.news.model.entity.News;
import com.web.news.model.service.NewsService;

public class NewsServiceImpl implements NewsService {

	private NewsDAO dao;
	
	public NewsServiceImpl() {
		dao = new NewsDAOImpl();
	}
	@Transactional
	@Override
	public Integer add(News news) {
		return dao.add(news);
	}
	@Transactional
	@Override
	public void update(News news) {
		dao.update(news);
	}
	@Transactional
	@Override
	public void delete(Integer newsID) {
		dao.delete(newsID);
	}
	@Override
	public News getByID(Integer newsID) {
		return dao.getById(newsID);
	}
	@Override
	public List<News> getAll(){
		return dao.getAll();
	}
	
}
