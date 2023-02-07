package com.web.admin.model.service;

import java.util.List;

import com.web.admin.model.entity.AdminFunc;

public interface AdminFuncService {

	List<AdminFunc> getAll();

	void addAdminFunc(AdminFunc adminFunc);

	void editAdminFunc(AdminFunc adminFunc);

	void getOne(Integer adminId);

}