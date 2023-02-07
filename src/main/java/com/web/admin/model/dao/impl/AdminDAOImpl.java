package com.web.admin.model.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.web.admin.model.dao.AdminDAO;
import com.web.admin.model.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceContext
	Session session;
	@Override
	public void update(Admin admin) {
		String hql = "UPDATE Admin SET adminID = :adminid WHERE  staffID = :staffid";
		 session.createQuery(hql).setParameter("staffid", admin.getStaffID())
				.setParameter("adminid", admin.getAdminID()).executeUpdate();
	}

	@Override
	public List<Admin> getAll() {
		String hql = "FROM Admin";
		return session.createQuery(hql, Admin.class).list();
	}

	@Override
	public Admin getById(Admin.PK staffId) {
		return session.get(Admin.class, staffId);
	}

	@Override
	public Admin.PK add(Admin admin) {
		session.persist(admin);
		Admin.PK pk = new Admin.PK();
		pk.adminID = admin.getAdminID();
		pk.staffID = admin.getStaffID();
		return pk;
	}

	public Admin getOneAdminByInt(Integer staffId) {
		String hql = "FROM Admin WHERE staffID = :staffid ";

		return session.createQuery(hql, Admin.class).setParameter("staffid", staffId).getSingleResult();
	}

	public List<Admin.PK> getPk(Integer staffId) {
		String hql = "FROM Admin WHERE staffID = :staffid ";
		return session.createQuery(hql, Admin.PK.class).setParameter("staffid", staffId).getResultList();
	}

}
