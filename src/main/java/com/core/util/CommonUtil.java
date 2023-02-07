package com.core.util;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CommonUtil {

	public static <P> P json2Pojo(HttpServletRequest request, Class<P> classOfPojo) {
		try (BufferedReader br = request.getReader()) {
			return Constants.GSON.fromJson(br, classOfPojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <P> void writePojo2Json(HttpServletResponse response, P pojo) {
		response.setContentType(Constants.JSON_MIME_TYPE);
		try (PrintWriter pw = response.getWriter()) {
			pw.print(Constants.GSON.toJson(pojo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> T getBean(ServletContext sc, Class<T> clazz) {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
		return context.getBean(clazz);
	}

	public static void printBean(ServletContext sc) {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
	}
}
