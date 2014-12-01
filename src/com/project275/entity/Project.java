package com.project275.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project", catalog = "test1")
public class Project implements java.io.Serializable {

	// Fields

	private Integer projectid;
	private Team team;
	private String projName;
	private String projStatus;
	private String projPartner;
	private String projStoreName;
	private Date projDateDiscuss;
	private String projDesc;
	private Date projStartDate;
	private Date projEndDate;
	private Integer projProjectedCost;
	private Integer projActualCost;
	private String projOutcome;
	private Set<Task> tasks = new HashSet<Task>(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** full constructor */
	public Project(Team team, String projName, String projStatus,
			String projPartner, String projStoreName, Date projDateDiscuss,
			String projDesc, Date projStartDate, Date projEndDate,
			Integer projProjectedCost, Integer projActualCost,
			String projOutcome, Set<Task> tasks) {
		this.team = team;
		this.projName = projName;
		this.projStatus = projStatus;
		this.projPartner = projPartner;
		this.projStoreName = projStoreName;
		this.projDateDiscuss = projDateDiscuss;
		this.projDesc = projDesc;
		this.projStartDate = projStartDate;
		this.projEndDate = projEndDate;
		this.projProjectedCost = projProjectedCost;
		this.projActualCost = projActualCost;
		this.projOutcome = projOutcome;
		this.tasks = tasks;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "projectid", unique = true, nullable = false)
	public Integer getProjectid() {
		return this.projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "teamid")
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Column(name = "proj_name", length = 50)
	public String getProjName() {
		return this.projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	@Column(name = "proj_status", length = 50)
	public String getProjStatus() {
		return this.projStatus;
	}

	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

	@Column(name = "proj_partner", length = 50)
	public String getProjPartner() {
		return this.projPartner;
	}

	public void setProjPartner(String projPartner) {
		this.projPartner = projPartner;
	}

	@Column(name = "proj_store_name", length = 50)
	public String getProjStoreName() {
		return this.projStoreName;
	}

	public void setProjStoreName(String projStoreName) {
		this.projStoreName = projStoreName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_date_discuss", length = 10)
	public Date getProjDateDiscuss() {
		return this.projDateDiscuss;
	}

	public void setProjDateDiscuss(Date projDateDiscuss) {
		this.projDateDiscuss = projDateDiscuss;
	}

	@Column(name = "proj_desc", length = 200)
	public String getProjDesc() {
		return this.projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_start_date", length = 10)
	public Date getProjStartDate() {
		return this.projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_end_date", length = 10)
	public Date getProjEndDate() {
		return this.projEndDate;
	}

	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}

	@Column(name = "proj_projected_cost")
	public Integer getProjProjectedCost() {
		return this.projProjectedCost;
	}

	public void setProjProjectedCost(Integer projProjectedCost) {
		this.projProjectedCost = projProjectedCost;
	}

	@Column(name = "proj_actual_cost")
	public Integer getProjActualCost() {
		return this.projActualCost;
	}

	public void setProjActualCost(Integer projActualCost) {
		this.projActualCost = projActualCost;
	}

	@Column(name = "proj_outcome", length = 50)
	public String getProjOutcome() {
		return this.projOutcome;
	}

	public void setProjOutcome(String projOutcome) {
		this.projOutcome = projOutcome;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	public int getNumberOfColumns(){
		return 12;
	}
	public String getColumnData(int i) throws Exception{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		if(i==0){
			return Integer.toString(getProjectid());
		}else if(i==1){
			return getProjName();			
		}else if(i==2){
			return getProjStatus();
		}else if(i==3){
			return getProjPartner();			
		}else if(i==4){
			return getProjStoreName();			
		}else if(i==5){
			Date dateOfDiscuss=getProjDateDiscuss();
			return df.format(dateOfDiscuss);			
		}else if(i==6){
			return getProjDesc();
		}else if(i==7){
			Date startDate=getProjStartDate();
			return df.format(startDate);
		}else if(i==8){
			Date endDate=getProjEndDate();
			return df.format(endDate);
		}else if(i==9){
			return Integer.toString(getProjProjectedCost());
		}else if(i==10){
			return Integer.toString(getProjActualCost());	
		}else if(i==11){
			return getProjOutcome();
		}else if(i==12){
			return getTeam().getTeamName();
		}
		else{
			throw new Exception("Error: Invalid Column Index");
		}
	}
	
	public String getColumnName(int i) throws Exception{
		String colName=null;
		if(i==0){
			colName="projectid";
		}else if(i==1){
			colName="proj_name";
		}else if(i==2){
			colName="proj_status";
		}else if(i==3){
			colName="proj_partner";	
		}else if(i==4){
			colName="proj_store_name";	
		}else if(i==5){
			colName="proj_date_discuss";
		}else if(i==6){
			colName="proj_desc";
		}else if(i==7){
			colName="proj_start_date";
		}else if(i==8){
			colName="proj_end_date";
		}else if(i==9){
			colName="proj_projected_cost";
		}else if(i==10){
			colName="proj_actual_cost";
		}else if(i==11){
			colName="proj_outcome";
		}else if(i==12){
			colName="teamid";
		}else{
			throw new Exception("Error: Access to Invalid Column number");
		}
		return colName;
	}
	
	public void setColumnData(int i,Object value) throws Exception{
		if(i==0){
			projName=(String)value;
		}else if(i==1){
			projStatus=(String)value;
		}else if(i==2){
			projPartner=(String)value;
		}else if(i==3){
			projStoreName=(String)value;
		}else if(i==4){
			Date date1=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse((String)value);
			projDateDiscuss=date1;
		}else if(i==5){
			projDesc=(String)value;
		}else if(i==6){
			Date date2=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse((String)value);
			projStartDate=date2;
		}else if(i==7){
			Date date3=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse((String)value);
			projEndDate=date3;
		}else if(i==8){
			projProjectedCost=Integer.parseInt((String)value);
		}else if(i==9){
			projActualCost=Integer.parseInt((String)value);
		}else if(i==10){
			projOutcome=(String)value;
		}
		else{
			throw new Exception("Error: Access to Invalid Column number");
		}
	}

	

}