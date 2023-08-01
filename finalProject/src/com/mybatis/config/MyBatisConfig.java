package com.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
//	우리는 sqlSession을 만들기 위해서 세션팩토리가 필요하다
	private static SqlSessionFactory sqlSessionFactory;
	
//	팩토리는 딱 한번만 프로그램이 시작될 때 만들면 된다.
//	그러므로 static 초기화 블럭으로 생서해준다.
	static {
		try {
//			설정파일의 경로를 저장한다.
			String resource = "./com/mybatis/config/config.xml";
			
//			ibatis 임포트 -> ibatis는 mybaits의 예전버전 이름이다. 즉 똑같다는 것
//			Resources 클래스를 이용하여 리소스를 읽어들여  Reader객체로 만든다.
			Reader reader = Resources.getResourceAsReader(resource);
			
//			sql세션팩토리빌더에게 펙토리를 지어달라고 한다. build()
//			공장을 짓기 위해서 설계도가 필요하다.
//			설계도가 설정값을 저장하고 있는 reader이다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			System.out.println("MyBatisConfig.java 초기화 문제 발생!!!");
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
}












