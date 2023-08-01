package com.example.app.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.reply.dao.ReplyDAO;
import com.example.app.reply.vo.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ReplyListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		ReplyDAO  replyDAO = new ReplyDAO();
		Gson gson = new Gson();
		
		JsonArray replies = new JsonArray();
		
		List<ReplyVO> replyList = replyDAO.selectAll(boardNumber);
		
//		for(ReplyVO reply : replyList) {
//			String replyJson = gson.toJson(reply);
//			
//			System.out.println(replyJson);
//			
////			문자열을 제이슨 타입으로 변환 시켜서 추가 해준다.
////			Json형식의 문자열을 json객체로 변환시켜 저장한다.
//				Json 형식으로 만들지 않으면 출력 될때 '\' 가 포함되어 나오기때문에 형식을 바꿔줘야 한다.
//			replies.add(JsonParser.parseString(replyJson));
//		}
		
		replyDAO.selectAll(boardNumber).stream()
		.map(gson::toJson)
		.map(JsonParser::parseString)
		.forEach(replies::add);
		
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(replies.toString());
		out.close();
	}

}





