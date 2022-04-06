package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.AccountVO;

@Repository("accountDAOImpl")
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void insertAccount(AccountVO vo) {
		sqlSession.insert("accountMapper.insertAccount", vo);
		//"": mapper의 별칭
	}
	
	public AccountVO loginCheck(AccountVO vo) {
		return sqlSession.selectOne("accountMapper.loginCheck", vo);
	}
	
	public void updateAccount(AccountVO vo) {
		sqlSession.update("accountMapper.updateAccount", vo);
	}
	
	public AccountVO myHomePageView(String account_Id) {
		return sqlSession.selectOne("accountMapper.myHomePageView", account_Id);
	}
	
	public AccountVO myHomePageUpdate(String account_Id) {
		return sqlSession.selectOne("accountMapper.myHomePageUpdate", account_Id);
	}
	
	public List<AccountVO> accountList(AccountVO vo){
		return sqlSession.selectList("accountMapper.accountList", vo);
	};
	
	public AccountVO idCheck(AccountVO vo) {
		return sqlSession.selectOne("accountMapper.idCheck", vo);
	}
	
	public boolean checkPassword(String account_Id, String account_Password) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("account_Id", account_Id);
		map.put("account_Password", account_Password);
		int count = sqlSession.selectOne("accountMapper.checkPassword", map);
		if(count == 1) result = true;
		return result;
		
	}

	public void deleteAccount(AccountVO vo) {
		sqlSession.selectOne("accountMapper.deleteAccount", vo);
	}
}
