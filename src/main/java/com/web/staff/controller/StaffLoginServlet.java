package com.web.staff.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.core.util.CommonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.web.staff.model.entity.Staff;
import com.web.staff.model.service.StaffService;
import com.web.staff.model.service.impl.StaffServiceImpl;

@WebServlet("/ipet-back/login")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StaffService service;

	@Override
	public void init() throws ServletException {
		CommonUtil.printBean(getServletContext());
		service = CommonUtil.getBean(getServletContext(), StaffService.class);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		Staff staff = gson.fromJson(req.getReader(), Staff.class);
		if (staff == null) {
			staff = new Staff();
			staff.setMessage("查無此員工");
			staff.setSuccessful(false);
			turnToJson(resp, staff);
			return;
		}
//		StaffService staffSvc = new StaffServiceImpl();
		staff = service.login(staff);
		if (staff.isSuccessful()) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			final HttpSession session = req.getSession();
			session.setAttribute("loggedin", true);
			session.setAttribute("staff", staff);
			session.setAttribute("name", staff.getName());
			session.setAttribute("id", staff.getId());
		}
		turnToJson(resp, staff);
	}

	public static void turnToJson(HttpServletResponse res, Staff staff) {
		res.setContentType("application/json");
		Gson gson = new GsonBuilder().create();

		try (PrintWriter pw = res.getWriter()) {
			pw.print(gson.toJson(staff));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
