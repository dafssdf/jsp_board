package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;

public class LogoutController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		로그아웃 이므로 저장된 세션을 삭제 하고 로그인 화면으로 이동한다.
		req.getSession().invalidate();
		
		resp.sendRedirect("/member/login.me");
	}

}
