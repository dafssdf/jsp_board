package com.example.app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;

public class DownloadController implements Execute{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileSystemName = req.getParameter("fileSystemName");
		String fileOriginName = req.getParameter("fileOriginName");
		String uploadPath = req.getSession().getServletContext().getRealPath("/")+"upload/";
		
		InputStream in = null;
		OutputStream out = null;
		
		File file = new File(uploadPath , fileSystemName);
		
		byte[] buffer = new byte[1024];
		
//		클라이언트에게 보내는 응답이 이전과 다르게 파일(이진) 데이터이므로 컨텐트 타입을 다르게 설정한다.
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Length", file.length() + "");
		resp.setHeader("Content-Disposition", "attachment; filename=" + fileOriginName);
		
		in = new FileInputStream(file);
		out = resp.getOutputStream();
		
		int readCnt = 0;
		
//		한 바이트를 가져와서 -1이 아닐때 까지 반복해 buffer가 1kb 일때 가져오고 마지막까지 다 가져와서 반복 시켜라
		while((readCnt = in.read(buffer)) != -1) {
			out.write(buffer, 0 , readCnt);
		}
		
//		이동처리 따로 없다
		
	}
}
















