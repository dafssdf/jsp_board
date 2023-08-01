package com.example.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.reply.dao.ReplyDAO;

public class ReplyDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//여기도 게시물과 fk 로 연관 되어있어서 댓글 삭제 사진삭제 후 게시판을 삭제하면 같이 삭제 된다.
		int replyNumber = Integer.parseInt(req.getParameter("replyNumber"));
		new ReplyDAO().delete(replyNumber);
		
	}

}
