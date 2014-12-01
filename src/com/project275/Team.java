package com.project275;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.*;

@Entity(name="team")
public class Team implements Serializable{
	@Column
	private String team_name;
	
	@Id
	@Column
	private int teamid;
	
	@Column
	private String team_desc;
	
	@Column
	private int userid;
	
	
	public int getTeamID(){
		return teamid;
	}
	
	public void setTeamID(int name){
		this.teamid=name;
	}
	
	public String getteam_name(){
		return team_name;
	}
	
	public void setTeamName(String name){
		this.team_name=name;
	}
	
	public String getTeamDesc(){
		return team_desc;
	}
	
	public void setTeamDesc(String name){
		this.team_desc=name;
	}
	
	public int getUserID(){
		return userid;
	}
	
	public void setUserID(int name){
		this.userid=name;
	}
	
	
	public int getNumberOfColumns(){
		return 12;
	}
	
	public String getColumnName(int i) throws Exception{
		String colName=null;
		if(i==0){
			colName="teamid";
		}else if(i==1){
			colName="team_name";
		}else if(i==2){
			colName="team_desc";
		}else if(i==3){
			colName="userid";	
		}else{
			throw new Exception("Error: Access to Invalid Column number");
		}
		return colName;
	}
	
	public void setColumnData(int i,Object value) throws Exception{
		if(i==0){
			teamid=(int)value;
		}else if(i==1){
			team_name=(String)value;
		}else if(i==2){
			team_desc=(String)value;
		}else if(i==3){
			userid=(int)value;
		}else{
			throw new Exception("Error: Access to Invalid Column number");
		}
	}
	
	public String toString(){
		return "Team[Team ID="+teamid+","
				+"Team Name="+team_name+","
				+"Team Desc="+team_desc+","
				+"User ID="+ userid+","
				
				+"]"
				;
	}
}
