package com.project275.service;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.TypedQuery;

import com.project275.entity.Project;
import com.project275.entity.Task;
import com.project275.entity.User;
import com.project275.util.PersistenceUtil;

public class TaskService {
	
	private static String FIND_TASK_BY_TASKNAME = "select model from Task model where model.taskName='";
	private EntityManager manager;

	public TaskService(EntityManager manager) {
		this.manager = manager;
	}

	// method to create a new record
	public Task createTask(String projectName,String userName, String taskName,
			String taskDesc , String dependency, String taskStatus,Integer taskProjectedCost,Integer taskActualCost,
			String taskStartDate, String taskEndDate) {
		User user = UserService.getUserByUserName(userName);
		Project project = ProjectService.getSingleProjectByProjectName(projectName);
		Task  task = new Task();
		
		task.setProject(project);
		task.setUser(user);
		
		task.setTaskName(taskName);
		task.setTaskDesc(taskDesc);
		task.setDependency(dependency);
		task.setTaskStatus(taskStatus);
		task.setTaskProjectedCost(taskProjectedCost);
		task.setTaskActualCost(taskActualCost);
		Date date1;
		try {
			date1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(taskStartDate);
			task.setTaskStartDate(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2;
		try {
			date2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(taskEndDate);
			task.setTaskEndDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		manager.persist(task);
		return task;
	}

	// method to read a record
	public Task readTask(String TaskName) {
		Task task = manager.find(Task.class, TaskName);
		return task;
	}

	// method to read all records
	public List<Task> readAll() {
		Query q = manager.createQuery("SELECT e FROM task e");
		//TypedQuery<CourseList> query = (TypedQuery<CourseList>) manager.createQuery("SELECT e FROM courselist e");
        List<Task> result = q.getResultList();
		return result;
	}

	// method to update a record
	public Task updateTask(String userName, String taskName,String taskDesc, String dependency,
			String taskStatus,int taskProjectedCost,int taskActualCost, String taskStartDate, String taskEndDate) {
		Task task = findTaskByTaskName(taskName);
		User user = UserService.getUserByUserName(userName);
		if (task != null) {
			task.setUser(user);
			task.setTaskName(taskName);
			task.setTaskDesc(taskDesc);
			task.setDependency(dependency);
			task.setTaskStatus(taskStatus);
			task.setTaskProjectedCost(taskProjectedCost);
			task.setTaskActualCost(taskActualCost);
			Date date1;
			try {
				date1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(taskStartDate);
				task.setTaskStartDate(date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date date2;
			try {
				date2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(taskEndDate);
				task.setTaskEndDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		manager.merge(task);
		return task;
	}
	
	
	public Task findTaskByTaskName(String taskName) {
		Query query = manager.createQuery(FIND_TASK_BY_TASKNAME+ taskName + "'");
		Task task = (Task) query.getResultList().get(0);
		if (task != null) {
			return task;
			
		}
		return null;
	
	}

	// method to delete a record
	public void deleteTask(String taskName) {
		Task task = manager.find(Task.class, taskName);
		if (task != null) {
			manager.remove(task);
			
		}
	
	}
	
	public void deleteTaskByTaskName(String taskName) {
		Query query = manager.createQuery(FIND_TASK_BY_TASKNAME+ taskName + "'");
		Task task = (Task) query.getResultList().get(0);
		if (task != null) {
			manager.remove(task);
			
		}
	
	}
	/*public static Task createTask1(String userName, String taskName,
			String taskDesc , String dependency, String taskStatus,Integer taskProjectedCost,Integer taskActualCost,
			String taskStartDate, String taskEndDate) {
		User user = UserService.getUserByUserName(userName);
		Task  task = new Task();
		
		task.setUser(user);
		
		task.setTaskName(taskName);
		task.setTaskDesc(taskDesc);
		task.setDependency(dependency);
		task.setTaskStatus(taskStatus);
		task.setTaskProjectedCost(taskProjectedCost);
		task.setTaskActualCost(taskActualCost);
		Date date1;
		try {
			date1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(taskStartDate);
			task.setTaskStartDate(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2;
		try {
			date2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(taskEndDate);
			task.setTaskEndDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PersistenceUtil.getEntityManager().persist(task);
		return task;
	}*/

}