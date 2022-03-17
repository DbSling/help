package beans;

import lombok.Data;

@Data
public class Members extends Lessons{
	private String ctCode;
	private String meCode;
	private String meName;
	private String meBirth;
	private String meEmail;
	private String meNumber;
	private String meGender;
	private String mePw;
	private String meCaCode;
	private String meCaName;
	
	//Excercise, locker
	private String meExCode;
	private String meExName;
	private String meExUnit;
	private String Locker;	
	
	//Target
	private String daCode;
	private String exCode;
	private String peDate;
	private String stCode;
	

}
