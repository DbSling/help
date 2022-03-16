package com.somebody.serviece.auth;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.somebody.db.CommonMethod;
import com.somebody.db.MapperBon;
import com.somebody.db.MapperDong;
import com.somebody.db.MapperUone;
import com.somebody.db.MapperYoung;

import beans.Centers;
import beans.Members;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Authenticaion extends CommonMethod {

	@Autowired
	private MapperYoung my;
	@Autowired
	private MapperBon mb;
	@Autowired
	private MapperDong md;
	@Autowired
	private MapperUone mo;


	private ModelAndView mav;
	@Autowired
	private ProjectUtils pu;
	@Autowired
	private Encryption enc;
	@Autowired
	HttpSession session;

	String page = null;
	boolean tran = false;

	public Authenticaion() {
		mav = new ModelAndView();
	}

	public void backController(String sCode, Centers ct) {

		switch (sCode) {

		case "A03":
			ctLogin(ct);
			break;
		case "A04":
			logOut(ct);
			break;
		case "A05":
			sendEmailForm(ct);
			break;
		case "A06":
			modPw(ct);
			break;
		case "J01":
			ctJoinForm(ct);
			break;


		case "P04":
			getSelectCenter(ct);
			break;
		}

	}

	public void backController2(String sCode, Members me) {

		switch (sCode) {
		case "A02":
			meLogin(me);
			break;
		case "C14":
			checkMePw(me);
			break;
		}
	}


	public void backController2(String sCode, Model md) {
		switch (sCode) {
		case "C01":
			checkMeEmailNum(md);
			break;

		case "C02":
			checkCtCode(md);
			break;
		}
	}

	public ModelAndView backController(String sCode, Members me) {

		switch (sCode) {
		case "J01":
			goJoinPage();
			break;
		case "J03":
			meJoin(me);
			break;
		}
		return mav;
	}

	public ModelAndView backController2(String sCode, Centers ct) {
		switch (sCode) {
		case "J02":
			ctJoin(ct);
			break;
		}
		return mav;
	}

	private void goJoinPage() {
		tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		mav.addObject("maxMeCode", this.my.maxCode());
		mav.setViewName("join");
		tranend(true);
	}

	private void checkMeEmailNum(Model md) {
		tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		md.addAttribute("checkMeEmailNum",this.my.checkMeEmailNum());
		tranend(true);
	}


	private void checkCtCode(Model md) {
		tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		md.addAttribute("checkCtCode",this.my.checkCtCode());
		tranend(true);
	}


	public void checkMePw(Members me) {


	}

	public void meLogin(Members me) {

	}

	public void ctLogin(Centers ct) {
		this.tranconfig(TransactionDefinition.PROPAGATION_REQUIRED,TransactionDefinition.ISOLATION_READ_COMMITTED,false);
		if(this.convertToBoolean(this.mb.is(ct))) {
			tran = true;
		}
		this.tranend(tran);
	}

	public void logOut(Centers ct) {

	}

	public void sendEmailForm(Centers ct) {

	}

	public void modPw(Centers ct) {

	}

	public void ctJoinForm(Centers ct) {

	}

	public void ctJoin(Centers ct) {
		page= "join";
		String msg= "가입실패~!";
		this.tranconfig(TransactionDefinition.PROPAGATION_REQUIRED,TransactionDefinition.ISOLATION_READ_COMMITTED,false);
		ct.setSfPw(this.enc.encode(ct.getSfPw()));
		if(convertToBoolean(this.my.ctJoin(ct))) {
			if(convertToBoolean(this.my.firstSfJoin(ct))) {
				page = "login";
				tran = true;
				msg = "가입성공~!";
			}
		}
		this.tranend(tran);
		mav.addObject("msg", msg);
		mav.setViewName(page);
	}

	public void meJoin(Members me) {
		page= "join";
		String msg= "가입실패~!";
		this.tranconfig(TransactionDefinition.PROPAGATION_REQUIRED,TransactionDefinition.ISOLATION_READ_COMMITTED,false);
		me.setMePw(this.enc.encode(me.getMePw()));
		if(convertToBoolean(this.my.meJoin(me))) {
			page = "login";
			tran = true;
			msg = "가입성공~!";
		}
		this.tranend(tran);
		mav.addObject("msg", msg);
		mav.setViewName(page);
	}

	public void getSelectCenter(Centers ct) {

	}

}
