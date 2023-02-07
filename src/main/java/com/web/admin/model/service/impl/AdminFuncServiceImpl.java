package com.web.admin.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.admin.model.dao.AdminFuncDAO;
import com.web.admin.model.dao.impl.*;
import com.web.admin.model.entity.AdminFunc;
import com.web.admin.model.service.AdminFuncService;

@Service
public class AdminFuncServiceImpl implements AdminFuncService {

	@Autowired
	private AdminFuncDAO dao;

	@Override
	public List<AdminFunc> getAll() {
		return dao.getAll();
	}

	@Transactional
	@Override
	public void addAdminFunc(AdminFunc adminFunc) {
		dao.add(adminFunc);
	}
	@Transactional
	@Override
	public void editAdminFunc(AdminFunc adminFunc) {
		dao.update(adminFunc);
	}

	@Override
	public void getOne(Integer adminId) {
        dao.getById(adminId);
	}
}