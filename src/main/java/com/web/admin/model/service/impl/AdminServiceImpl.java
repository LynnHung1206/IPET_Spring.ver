package com.web.admin.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.admin.model.dao.AdminDAO;
import com.web.admin.model.dao.impl.AdminDAOImpl;
import com.web.admin.model.entity.Admin;
import com.web.admin.model.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO dao;


	@Override
	public Admin addAdminOnStaff(Integer adminId, Integer staffId) {

		Admin admin = new Admin();
		admin.setAdminID(adminId);
		admin.setStaffID(staffId);
		dao.add(admin);

		return admin;
	}

	@Override
	public List<Admin> getAll() {
		return dao.getAll();
	}

	@Override
	public Admin getOneAdmin(Admin.PK staffId) {
		return dao.getById(staffId);
	}

	@Override
	public Admin getOneAdminByInt(Integer staffId) {
		return ((AdminDAOImpl) dao).getOneAdminByInt(staffId);
	}

	@Override
	public List<Admin.PK> getPk(Integer staffId) {
		return ((AdminDAOImpl) dao).getPk(staffId);
	}
	
	@Override
	public void update(Admin admin) {
		dao.update(admin);
	}
	

}
