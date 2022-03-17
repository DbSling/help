package com.somebody.serviece.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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

import beans.Members;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Member extends CommonMethod{

	@Autowired
	private MapperYoung my;
	private ModelAndView mav;
	@Autowired
	private ProjectUtils pu;
	@Autowired
	private Encryption enc;
	@Autowired
	private DataSourceTransactionManager tx;

	private TransactionStatus txStatus;

	private DefaultTransactionDefinition txdef;

	String page = null;

	public Member() {
		mav = new ModelAndView();
	}
	
	public ModelAndView backController(String sCode, Members me) {
		switch (sCode) {
		//관리자페이지 접근
		case "M01":
			goMePage(me);
			break;
		}
		return mav;
	}

	public void backController(String sCode, Members me, Model md) {

		switch (sCode) {
		//관리자페이지 접근
		case "M02":
			meMg(me, md);
			break;
		case "M03":
			searchMeMg(me);
			break;
		case "M04":
			meDetail(me);
			break;
		case "M05":
			getCaList(me);
			break;
		case "M06":
			addMember(me);
			break;
		case "M07":
			modMe(me);
			break;
		case "M09":
			insInbody(me);
			break;


			//회원페이지 접근
		case "C01":
			infoLine(me);
			break;
		case "C02":
			meDtInfo(me);
			break;
		case "C03":
			meInbodyMg(me);
			break;
		case "C04":
			insTaState(me);
			break;
		case "C05":
			meHealthMg(me);
			break;
		case "C06":
			meFoodMg(me);
			break;
		case "C07":
			meLessonMg(me);
			break;
		case "C08":
			getLessonList(me);
			break;
		case "C09":
			searchLsMg(me);
			break;
		case "C10":
			insMeLesson(me);
			break;
		case "C11":
			delMeLesson(me);
			break;
		case "C12":
			meConfig(me);
			break;

		case "C15":
			modMeMg(me);
			break;
		case "C17":
			delMe(me);
			break;

		}
	}

	public void goMePage(Members me) {
		this.mav.addObject("ctCode", me.getCtCode());
		mav.setViewName("meMg");

	}

	public void meInbodyMg(Members me) {

	}

	public void meDtInfo(Members me) {

	}

	public void meMg(Members me, Model md) {
		List<Members> meList = new ArrayList<Members>();
		tranconfig(TransactionDefinition.PROPAGATION_REQUIRED, TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		meList = this.my.meList(me);
		tranend(true);
	}

	public void searchMeMg(Members me) {

	}

	public void meDetail(Members me) {

	}

	public void getCaList(Members me) {

	}

	public void addMember(Members me) {

	}

	public void modMe(Members me) {

	}

	public void insInbody(Members me) {

	}

	public void insTaState(Members me) {

	}

	public void meHealthMg(Members me) {

	}

	public void meFoodMg(Members me) {

	}

	public void meLessonMg(Members me) {

	}

	public void getLessonList(Members me) {

	}

	public void searchLsMg(Members me) {

	}

	public void insMeLesson(Members me) {

	}

	public void delMeLesson(Members me) {

	}

	public void meConfig(Members me) {

	}



	public void modMeMg(Members me) {

	}

	public void delMe(Members me) {

	}

	public void infoLine(Members me) {

	}



}
