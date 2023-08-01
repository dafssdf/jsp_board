package com.example.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.member.dao.MemberDAO;

public class BoardWriteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		HttpSession session = req.getSession();
		Integer memberNumber =(Integer)session.getAttribute("memberNumber");
		String path = null;
		
		//세션에 로그인이됐으면 memberNumber가 들어있고 없다면 로그인 페이지로, 있다면 write페이지로 이동 -> 아이디를 가져와서 boardwrite.jsp에 뿌려준다.
		if(memberNumber == null) {
			path = "/app/member/login.jsp";
		}else {
			path = "/app/board/boardWrite.jsp";
			req.setAttribute("memberId", memberDAO.getMemberId(memberNumber));
		}
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}

}
