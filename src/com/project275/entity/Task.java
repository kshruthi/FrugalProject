package com.project275.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.project275.service.UserService;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task", catalog = "test1")
public class Task implements java.io.Serializable {

	// Fields

	private Integer taskid;
	private Project project;
	private User user;
	private String taskName;
	private String taskDesc;
	private String dependency;
	private String taskStatus;
	private Integer taskProjectedCost;
	private Integer taskActualCost;
	private Date taskStartDate;
	private Date taskEndDate;
	private Date dateOfUpdate;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** full constructor */
	public Task(Project project, User user,String taskNmae, String taskDesc, String dependency,
			String taskStatus, Integer taskProjectedCost,
			Integer taskActualCost, Date taskStartDate, Date taskEndDate,
			Date dateOfUpdate) {
		this.project = project;
		this.user = user;
		this.taskName = taskNmae;
		this.taskDesc = taskDesc;
		this.dependency = dependency;
		this.taskStatus = taskStatus;
		this.taskProjectedCost = taskProjectedCost;
		this.taskActualCost = taskActualCost;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.dateOfUpdate = dateOfUpdate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "taskid", unique = true, nullable = false)
	public Integer getTaskid() {
		return this.taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public void setTaskName(String taskName){
		this.taskName = taskName;
	}
	
	@Column(name = "task_name", length = 50)
	public String getTaskName() {
		return this.taskName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectid")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "task_desc", length = 50)
	public String getTaskDesc() {
		return this.taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	@Column(name = "dependency", length = 50)
	public String getDependency() {
		return this.dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	@Column(name = "task_status", length = 50)
	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Column(name = "task_projected_cost")
	public Integer getTaskProjectedCost() {
		return this.taskProjectedCost;
	}

	public void setTaskProjectedCost(Integer taskProjectedCost) {
		this.taskProjectedCost = taskProjectedCost;
	}

	@Column(name = "task_actual_cost")
	public Integer getTaskActualCost() {
		return this.taskActualCost;
	}

	public void setTaskActualCost(Integer taskActualCost) {
		this.taskActualCost = taskActualCost;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "task_start_date", length = 10)
	public Date getTaskStartDate() {
		return this.taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "task_end_date", length = 10)
	public Date getTaskEndDate() {
		return this.taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_update", length = 10)
	public Date getDateOfUpdate() {
		return this.dateOfUpdate;
	}

	public void setDateOfUpdate(Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}
	// return number of columns in the table
	 public int getNumberOfColumns() {
	 return 9;
	 }
	 
	 // return the data in column i
	 public String getColumnData(int i) throws Exception {
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	 if (i == 0)
	 return getUser().getUserName();
	 else if (i == 1)
	 return getTaskName();
	 else if (i == 2) {
		 if(getTaskDesc() == null) {
			 return "";
		 }
		 return getTaskDesc();
	 }
	 
	 else if (i == 3)	{
		 if(getTaskProjectedCost() == null){
			 return Integer.toString(0);
		 }else{
			 return Integer.toString(getTaskProjectedCost());
		 }
	 }
	 else if(i == 4){
		 if(getTaskActualCost() == null){
			 return Integer.toString(0);
		 }else{
			 return Integer.toString(getTaskActualCost());
		 }
	 }
	
	 else if (i == 5){
		 if(getDependency() == null) {
			 return "";
		 }
		 return getDependency();
	 }
	 else if (i== 6){
		 Date startDate = getTaskStartDate();
		 if(startDate == null){
			 startDate = new Date();
		 }
		return df.format(startDate);
	 } else if (i == 7){
		 Date endDate = getTaskEndDate();
		 if(endDate == null){
			 endDate = new Date();
		 }
		return df.format(endDate); 
	 }
	 else if (i == 8){
		 if(getTaskStatus() == null){
			 return "";
		 }
		 return getTaskStatus();
	 }
	 else
		 throw new Exception("Error: invalid column index in courselist table"); 
	 }
	 
	 // return the name of column i
	 public String getColumnName(int i) throws Exception {
		 String colName = null;
		 if (i == 0) 
		 colName = "user_name";
		 else if (i == 1)
		 colName = "task_name";
		 else if (i == 2)
		 colName = "task_desc";
		 else if (i == 3)
		 colName = "task_projected_cost";
		 else if (i == 4)
		 colName = "task_actual_cost";
		 else if (i == 5)
			 colName = "dependency";
		 else if (i == 6)
			 colName = "task_start_date";
		 else if (i == 7)
			 colName = "task_end_date";
		 else if (i == 8)
			 colName = "task_status";
		 else
		 throw new Exception("Access to invalid column number in courselist table");
		 
		 return colName;
		 }
		 
		 // set data column i to value
		 public void setColumnData(int i, Object value) throws Exception {
		 if (i == 0) {
			 User user1 = UserService.getUserByUserName((String)value);
			 user  = user1;
		 }else if (i == 1) 
		 taskName = (String) value;
		 else if (i == 2) 
			 taskDesc = (String) value;
		 else if (i == 3)
			 taskProjectedCost = Integer.parseInt((String) value);
		 else if ( i ==4)
		  taskActualCost = Integer.parseInt((String) value);
		 else if (i == 5) 
			 dependency = (String) value;
		 else if (i == 6){
			 Date date1=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse((String)value);
			 taskStartDate=date1;
		 }else if (i == 7){
			 Date date2=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse((String)value);
			 taskEndDate=date2;
		 }
		 else if (i == 8) 
			 taskStatus = (String) value;
		 
		 
		 else
		 throw new Exception("Error: invalid column index in task table"); 
		 }
		 

}