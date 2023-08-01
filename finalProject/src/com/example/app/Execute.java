package com.example.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스를 사용해서 Execute를 모두 같은 양식으로 사용하기 위해 인터페이스를 사용한다.
public interface Execute {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
