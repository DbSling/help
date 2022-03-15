package com.somebody.serviece.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.somebody.db.CommonMethod;
import com.somebody.db.MapperBon;
import com.somebody.db.MapperDong;
import com.somebody.db.MapperUone;
import com.somebody.db.MapperYoung;

import beans.Lessons;
import kr.co.icia.plzec.services.Encryption;
import kr.co.icia.plzec.services.ProjectUtils;

@Service
public class Lesson extends CommonMethod{
	@Autowired
	private MapperBon mb;
	@Autowired
	private MapperDong md;
	@Autowired
	private MapperYoung my;
	@Autowired
	private MapperUone mu;
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
	
	public Lesson() {
		mav = new ModelAndView();
	}
	
public ModelAndView backController(String sCode, Lessons ls) {
		
		switch (sCode) {
		case "L01":
			lessonMg(ls);
			 break;
		}
		return mav;
	}

	public void backController(String sCode, Lessons ls, Model md) {
	
		switch (sCode) {
		
		case "L02":
			searchLesson(ls,md);
			break;
		case "L03":
			getLsCaList(ls,md);
			break;
		case "L04":
			insLsPay(ls,md);
			break;
		case "L05":
			getMaxLesson(ls,md);
			break;
		case "L06":
			insLesson(ls,md);
			break;
		case "L07":
			modLesson(ls,md);
			break;
		case "L08":
			lsMemDetail(ls,md);
			break;
		case "L09":
			modLsSuccess(ls,md);
			break;
		case "L10":
			delLesson(ls,md);
			break;
		}
		
	}
	public void lessonMg(Lessons ls) {
		System.out.println(ls.getCtCode());
		this.mav.addObject("ctCode", ls.getCtCode());
		this.mav.setViewName("lessonMg");
		
	}

	public void searchLesson(Lessons ls, Model md) {
		
		
	}

	public void getLsCaList(Lessons ls, Model md) {
	
		
	}

	public void insLsPay(Lessons ls, Model md) {
		
		
	}

	public void getMaxLesson(Lessons ls, Model md) {
		
		
	}

	public void insLesson(Lessons ls, Model md) {
	
		
	}

	public void modLesson(Lessons ls, Model md) {
	
		
	}

	public void lsMemDetail(Lessons ls, Model md) {
		
		
	}
	public void modLsSuccess(Lessons ls, Model md) {
		
		
	}
	public void delLesson(Lessons ls, Model md) {
	
		
	}
}
