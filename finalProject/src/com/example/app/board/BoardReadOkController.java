package com.example.app.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.board.dao.BoardDAO;
import com.example.app.board.vo.BoardVO;
import com.example.app.file.dao.FileDAO;
import com.example.app.file.dto.FileDTO;

public class BoardReadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		boardRead.js에서 주소창으로 보내준  boardNumber를 사용
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		BoardDAO boardDAO = new BoardDAO();
//		select는 조인으로 값을 가져오기 떄문에 boardVO에 저장한다.
		BoardVO boardVO = boardDAO.select(boardNumber);
//		List로 반환하기 때문에 FileDTO로 타입을 정해서 가져온다.
		List<FileDTO> files = new FileDAO().select(boardNumber);
		
		
		boardDAO.updateReadCount(boardNumber);
		
		boardVO.setFiles(files);
		
		//board로 값을 넘겨준다.
		req.setAttribute("board", boardVO);
		
		
		req.getRequestDispatcher("/app/board/boardRead.jsp").forward(req, resp);
	
		
	}

}
