package com.web.staff.model.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.staff.model.dao.StaffDAO;
import com.web.staff.model.entity.Staff;
import com.web.staff.model.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDAO dao;
	
	int id = 0;

	@Transactional
	@Override
	public int addStaff(Staff staff) {
		id = dao.add(staff);
		return id;
	}
	@Transactional
	@Override
	public Staff updateStaff(Staff staffVO) {
		return dao.update(staffVO);
	}
	@Override
	public Staff getStaff(int id) {
		Staff staffVO = dao.getById(id);
		return staffVO;
	}
	@Override
	public List<Staff> getAll() {
		return dao.getAll();
	}
	@Override
	public boolean findAc(String ac) {
		return dao.getAc(ac);
	}
	@Transactional
	@Override
	public Staff login(Staff staff) {
		String account = staff.getAc();
		String password = staff.getPw();
		if(account == null || account.isEmpty()) {
			staff.setMessage("請輸入帳號");
			staff.setSuccessful(false);
			return staff;
		}
		
		
		if(password == null || password.isEmpty()) {
			staff.setMessage("請輸入密碼");
			staff.setSuccessful(false);
			return staff;
		}
		
		staff = dao.getByAcAndPw(staff);
		if(staff == null) {
			staff = new Staff();
			staff.setMessage("帳號或是密碼錯誤");
			staff.setSuccessful(false);
			return staff;
		}
		staff.setMessage("登入成功");
		staff.setSuccessful(true);
		return staff;
	}
	@Transactional
	@Override
	public Integer acAcactive(String ac) {
		return dao.acActive(ac);
	}
}
