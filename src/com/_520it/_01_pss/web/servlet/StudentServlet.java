package com._520it._01_pss.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it._01_pss.dao.IStudentDAO;
import com._520it._01_pss.dao.impl.StudentDAOImpl;
import com._520it._01_pss.domain.Student;
import com._520it._01_pss.util.StringUtils;

@WebServlet("/student")
public class StudentServlet extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Student> list = dao.listAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd=req.getParameter("cmd");
		if ("delete".equals(cmd)) {
			delete(req, resp);
		}else if ("edit".equals(cmd)) {
			edit(req, resp);
			
		}else if ("saveOrUpdate".equals(cmd)) {
			saveOrUpdate(req, resp);
		}else {
			list(req, resp);
		}
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		if (StringUtils.hasLength(id)) {
			dao.delete(Long.valueOf(id));
		}
		resp.sendRedirect("/student");
	}
	protected void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id =req.getParameter("id");
		if (StringUtils.hasLength(id)) {
			
			Student stu = dao.get(Long.valueOf(id));
			req.setAttribute("stu", stu);
		}
	
		req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
	}
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String id = req.getParameter("id");
		Student student = new Student();
		student.setName(name);
		if (StringUtils.hasLength(age)) {
			student.setAge(Integer.valueOf(age));
		}
		if (StringUtils.hasLength(id)) {
			//编辑
			student.setId(Long.valueOf(id));
			dao.update(student);
		}else {
			//保存
			dao.save(student);
		}
		
		resp.sendRedirect(req.getContextPath() +"/student");
		//req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
	}
}
