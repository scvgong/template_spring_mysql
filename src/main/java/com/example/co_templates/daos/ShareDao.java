package com.example.co_templates.daos;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;  
@Component 
public class ShareDao{  
	@Autowired  
	private SqlSessionTemplate sqlSession;  

	public Object getList(String sqlMapId, Object dataMap) {
        sqlMapId = "Home.selectByQUESTIONS_UID";
		Object result = sqlSession.selectList(sqlMapId, dataMap);

		return result;
	}
}