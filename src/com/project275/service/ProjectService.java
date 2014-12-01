package com.project275.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import com.project275.entity.Project;
import com.project275.util.PersistenceUtil;


public class ProjectService {
	private static String QUERY_BASED_ON_PROJECT_NAME = "from Project p where p.projName = '";
	private EntityManager manager;
	public ProjectService(EntityManager manager){
		this.manager=manager;
	}
	public Project createProject(String projName,String projStatus,String partner,
			String store,String dateOfDiscuss,String projDesc,String projStartDt,
			String projEndDt,int projectedCost,int actualCost,String projOutcome){
		Project proj=new Project();
		proj.setProjName(projName);
		proj.setProjStatus(projStatus);
		proj.setProjPartner(partner);
		proj.setProjStoreName(store);
		Date date1;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(dateOfDiscuss);
			proj.setProjDateDiscuss(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		proj.setProjDesc(projDesc);
		Date date2;
		try {
			date2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(projStartDt);
			proj.setProjStartDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date date3;
		try {
			date3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(projEndDt);
			proj.setProjEndDate(date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		proj.setProjProjectedCost(projectedCost);
		proj.setProjActualCost(actualCost);
		proj.setProjOutcome(projOutcome);
		manager.persist(proj);
		return proj;
	}
	public Project readCourse(int projectID){
		Project proj=manager.find(Project.class, projectID);
		return proj;
	}
	public List<Project> readAll(){
		TypedQuery<Project> query = manager.createQuery("SELECT e FROM Project e",Project.class);
		List<Project> result=query.getResultList();
		return result;
	}
	public List<Project> fetchProjectDetails(String projName) {
		// TODO Auto-generated method stub
		System.out.println("projName is "+projName);
		//Query q = manager.createQuery("SELECT e FROM task e");
		TypedQuery<Project> query = manager.createQuery("SELECT e FROM Project e WHERE e.proj_name = :cname", Project.class);
		query.setParameter("cname", projName); // used named parameter cnum
		List<Project> result = query.getResultList();
		System.out.println(result);
		return result;
	}
	
public Project updateProject(int iProjectID,String projName,String projStatus,String partner,
	String store,String dateOfDiscuss,String projDesc,String projStartDt,
	String projEndDt,int projectedCost,int actualCost,String projOutcome){
		System.out.println("inside updateProject>>"+iProjectID);
		Project proj=manager.find(Project.class, iProjectID);
		if(proj!=null){
			proj.setProjStatus(projStatus);
			proj.setProjPartner(partner);
			proj.setProjStoreName(store);
			Date date1;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(dateOfDiscuss);
				proj.setProjDateDiscuss(date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			proj.setProjDesc(projDesc);
			Date date2;
			try {
				date2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(projStartDt);
				proj.setProjStartDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Date date3;
			try {
				date3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(projEndDt);
				proj.setProjEndDate(date3);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			proj.setProjProjectedCost(projectedCost);
			proj.setProjActualCost(actualCost);
			proj.setProjOutcome(projOutcome);
			
		}
		//return course;
		return proj;
		
	}
	
	/*public void deleteCourse(int userID){
		UserList user = manager.find(UserList.class, userID);
		if(user!=null){
			manager.remove(user);
		}
	}*/
	public static List<Object> getProjectByProjectName(String projectName) {
		String  queryStr = QUERY_BASED_ON_PROJECT_NAME + projectName +  "'";
		Query query= PersistenceUtil.getEntityManager().createQuery(queryStr);
		List<Object> result = query.getResultList();
		return result;
	}
	
	public static Project getSingleProjectByProjectName(String projectName) {
		String  queryStr = QUERY_BASED_ON_PROJECT_NAME + projectName +  "'";
		Query query= PersistenceUtil.getEntityManager().createQuery(queryStr);
		Project result = null;
		if(query.getResultList() .size() > 0) {
		 result = (Project)query.getResultList().get(0);
		}
		return result;
	}
}

