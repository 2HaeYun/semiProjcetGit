package com.javaclass.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.AccountDAO;
import com.javaclass.domain.AccountVO;
import com.javaclass.domain.MyPageOrderModifyVO;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private AccountDAO accountDAOImpl;

	public void insertAccount(AccountVO vo) {
		accountDAOImpl.insertAccount(vo);
	}

	public AccountVO loginCheck(AccountVO vo) {
		return accountDAOImpl.loginCheck(vo);
	}

	// 관리자 어드민 로그인조건파악
	public AccountVO adminLogin(AccountVO vo) {
		return accountDAOImpl.adminLogin(vo);
	}

	public void updateAccount(AccountVO vo) {
		accountDAOImpl.updateAccount(vo);
	}

	public AccountVO myHomePageView(String account_Id) {
		return accountDAOImpl.myHomePageView(account_Id);
	}

	public AccountVO myHomePageUpdate(String account_Id) {
		return accountDAOImpl.myHomePageUpdate(account_Id);
	}

	public List<AccountVO> accountList(AccountVO vo) {
		return accountDAOImpl.accountList(vo);
	};

	public AccountVO idCheck(AccountVO vo) {
		return accountDAOImpl.idCheck(vo);
	}

	public boolean checkPassword(String account_Id, String account_Password) {
		return accountDAOImpl.checkPassword(account_Id, account_Password);
	}

	public void deleteAccount(AccountVO vo) {
		accountDAOImpl.deleteAccount(vo);
	}

	//아이디 찾기
	/*
	 * public String idConfirm(String account_Name, String account_Tel){
	 * accountDAOImpl = SqlSessionTemplate.getMapper(accountDAOImpl.class);
	 * 
	 * String result = "";
	 * 
	 * try { result = accountDAOImpl.idConfirm(account_Name, account_Tel); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */
	
	//비밀번호 찾기
	public String userFindPw(AccountVO vo) throws Exception {
		return accountDAOImpl.userFindPw(vo);
	}
	
	//마이홈 주문 목록 불러오기
	public List<MyPageOrderModifyVO> adminOrderList(MyPageOrderModifyVO mvo){
		return accountDAOImpl.adminOrderList(mvo);
	}
}

