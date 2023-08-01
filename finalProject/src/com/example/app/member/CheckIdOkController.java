package com.example.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.member.dao.MemberDAO;

public class CheckIdOkController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		
		
		memberDAO.checkId(req.getParameter("memberId"));
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//checkId는 true/false로 반환되기 때문에 삼항연산자로 처리
		out.print(memberDAO.checkId(req.getParameter("memberId")) ? "사용가능" : "중복된 아이디");
		out.close();
	}
}
