package com.example.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());

		System.out.println(target);

		switch (target) {
		case "/board/boardListOk.bo":
			new BoardListOkController().execute(req,resp);
			break;
		case "/board/boardReadOk.bo":			
			new BoardReadOkController().execute(req,resp);
			break;
		case "/board/boardWrite.bo":
//			req.getRequestDispatcher("/app/board/boardWrite.jsp").forward(req, resp);
			new BoardWriteController().execute(req,resp);
			break;
		case "/board/boardWriteOk.bo":
			new BoardWriteOkController().execute(req,resp);
			break;
		case "/board/boardDeleteOk.bo":
			new BoardDeleteOkController().execute(req,resp);
			break;
		case "/board/boardUpdate.bo":
			new BoardUpdateController().execute(req,resp);
			break;
		case "/board/boardUpdateOk.bo":
			new BoardUpdateOkController().execute(req,resp);
			break;

		}
	}

}
