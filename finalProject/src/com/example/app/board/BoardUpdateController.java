package com.example.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.board.dao.BoardDAO;

public class BoardUpdateController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		BoardDAO boardDAO = new BoardDAO();
		
//		jsp 파일에서 사용하기 위해 board를 넘겨준다.
		req.setAttribute("board", boardDAO.select(boardNumber));
		
		req.getRequestDispatcher("/app/board/boardUpdate.jsp").forward(req, resp);
	}

}
