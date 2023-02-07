package com.web.admin.model.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.admin.model.dao.AdminFuncDAO;
import com.web.admin.model.entity.AdminFunc;

@Repository
public class AdminFuncDAOImpl implements AdminFuncDAO {
	@PersistenceContext
	Session session;
	@Override
	public void update(AdminFunc adminFuncVO) {

		AdminFunc oldadminFuncVO = session.get(AdminFunc.class, adminFuncVO.getId());
		oldadminFuncVO.setId(adminFuncVO.getId());
		oldadminFuncVO.setName(adminFuncVO.getName());
		}
		
	@Override
	public List<AdminFunc> getAll() {
		String hql = "FROM AdminFunc";
		return session.createQuery(hql,AdminFunc.class).list();
	}

	@Override
	public AdminFunc getById(Integer adminID) {
		return session.get(AdminFunc.class, adminID);
	}

	@Override
	public Integer add(AdminFunc adminFuncVO) {
        session.persist(adminFuncVO);
        return adminFuncVO.getId();
	}

}
