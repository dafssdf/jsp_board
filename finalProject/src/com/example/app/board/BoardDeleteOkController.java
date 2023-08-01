package com.example.app.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.example.app.Execute;
import com.example.app.board.dao.BoardDAO;
import com.example.app.file.dao.FileDAO;
import com.example.app.file.dto.FileDTO;

public class BoardDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		
//		DB에서 삭제하기 전에 실제 파일을 지워줘야하기 때문에 미리 지워준다.
		String uploadPath = req.getSession().getServletContext().getRealPath("/")+"upload/";
		List<FileDTO> files = fileDAO.select(boardNumber);
		
		
//		람다식
		files.stream().map(file -> file.getFileSystemName())
		.map(name -> new File(uploadPath, name))
		.filter(tmp ->tmp.exists())
		.forEach(tmp -> tmp.delete());
		
//		for(FileDTO file : files) {
//			File temp = new File(uploadPath,file.getFileSystemName());
//			
////			존재하지 않으면 오류가 나기 때문에 exists로 존재 여부를 true/false로 받아서 삭제를 실행해준다.
//			if(temp.exists()) {
//				temp.delete();				
//			}
//		}
		
		fileDAO.delete(boardNumber);
		boardDAO.delete(boardNumber);
		
		resp.sendRedirect("/board/boardListOk.bo");
	}

}






