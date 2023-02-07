package com.web.staff.model.dao.impl;

import java.util.*;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.staff.model.dao.StaffDAO;
import com.web.staff.model.entity.Staff;

@Repository
public class StaffDAOImpl implements StaffDAO {

	@PersistenceContext
	private Session session;
	
	@Override
	public Staff update(Staff staff) {
//		Session session = getSession();
		Staff oldstaffVO = session.get(Staff.class, staff.getId());
		oldstaffVO.setName(staff.getName());
		oldstaffVO.setUid(staff.getUid());
		oldstaffVO.setBth(staff.getBth());
		oldstaffVO.setSex(staff.getSex());
		oldstaffVO.setEmail(staff.getEmail());
		oldstaffVO.setPhone(staff.getPhone());
		oldstaffVO.setTel(staff.getTel());
		oldstaffVO.setAdd(staff.getAdd());
		oldstaffVO.setAc(staff.getAc());
		oldstaffVO.setPw(staff.getPw());
		oldstaffVO.setStatus(staff.getStatus());
		oldstaffVO.setPosi(staff.getPosi());
		oldstaffVO.setId(staff.getId());
		return staff;
	}

	@Override
	public List<Staff> getAll() {
		String hql = "FROM Staff";
		return session.createQuery(hql, Staff.class).list();
	}

	@Override
	public Staff getById(Integer id) {
//		Session session = getSession();
		return session.get(Staff.class, id);
	}

	@Override
	public Integer add(Staff staff) {
//		Session session = getSession();
		session.persist(staff);
		return staff.getId();
	}

	public List<Staff> getStaffByPosi(String posi) {
//		Session session = getSession();
		String hql = "FROM Staff WHERE posi = :posi";

		return session.createQuery(hql, Staff.class).setParameter("posi", posi).list();
	}

	@Override
	public Staff getByAcAndPw(Staff staff) {
		try {
//		Session session = getSession();
		String hql = "FROM Staff WHERE ac = :ac AND pw = :pw";
		return session.createQuery(hql,Staff.class)
				.setParameter("ac", staff.getAc())
				.setParameter("pw", staff.getPw()).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public boolean getAc(String ac) {
		try {
//		Session session = getSession();
		String hql = "FROM Staff WHERE ac = :ac";
		session.createQuery(hql,Staff.class)
		.setParameter("ac", ac).getSingleResult();
		return false;
		}catch(NoResultException e) {
			return true;
		}
	}

	@Override
	public Integer acActive(String ac) {
//		Session session = getSession();
		String hql = "FROM Staff WHERE ac = :ac";
		Staff staff = session.createQuery(hql,Staff.class)
				.setParameter("ac", ac).getSingleResult();
		return staff.getStatus();						 
	}
}
