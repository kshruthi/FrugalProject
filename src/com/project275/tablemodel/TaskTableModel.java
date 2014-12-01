package com.project275.tablemodel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;

import com.project275.entity.Project;
import com.project275.entity.Task;
import com.project275.service.ProjectService;
import com.project275.service.TaskService;

import java.util.*;

/**
 * 
 * @author rgrover
 */
public class TaskTableModel extends AbstractTableModel {
	List<Task> taskResultList;
	// stores the model data in a List collection of type CourseList
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used
	//private static final String  = null;
																			// in
																			// persistence.xml
	private static EntityManagerFactory factory; // JPA
	private EntityManager manager; // JPA
	private Task task;// represents the entity courselist
	// This field contains additional information about the results
	private TaskService taskService;
	private int numcols, numrows; // number of rows and columns

	/*public TaskTableModel() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		task = new Task();
		taskService = new TaskService(manager);

		// read all the records from courselist
		Project project = ProjectService.getSingleProjectByProjectName("project1");
		taskResultList = new ArrayList<Task>();
		if(project != null) {
			for(Task task : project.getTasks()){
				
				taskResultList.add(task);
			}
		}
		taskResultList = taskService.readAll();
		// update the number of rows and columns in the model
		numrows = taskResultList.size();
		numcols = task.getNumberOfColumns();
	}*/

	public TaskTableModel(String projectName) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		task = new Task();
		taskService = new TaskService(manager);

		Project project = ProjectService.getSingleProjectByProjectName(projectName);
		// read all the records from courselist
		if(project != null) {
			taskResultList = new ArrayList<Task>();
			for(Task task : project.getTasks()){
				
				taskResultList.add(task);
			}
		}
		// update the number of rows and columns in the model
		numrows = taskResultList.size();
		numcols = task.getNumberOfColumns();
	}

	
	// returns a count of the number of rows
	public int getRowCount() {
		return numrows;
	}

	// returns a count of the number of columns
	public int getColumnCount() {
		return numcols;
	}

	// returns the data at the given row and column number
	public Object getValueAt(int row, int col) {
		try {
			return taskResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// table cells are not editable
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	}

	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	// returns the name of the column
	public String getColumnName(int col) {
		try {
			return task.getColumnName(col);
		} catch (Exception err) {
			return err.toString();
		}
	}

	// update the data in the given row and column to aValue
	public void setValueAt(Object aValue, int row, int col) {
		// data[rowIndex][columnIndex] = (String) aValue;
		try {
			Task element = taskResultList.get(row);
			element.setColumnData(col, aValue);
			fireTableCellUpdated(row, col);
		} catch (Exception err) {
			err.toString();
		}
	}

	public List<Task> getList() {
		return taskResultList;
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	// create a new table model using the existing data in list
	public  TaskTableModel(List<Task> list, EntityManager em) {
		taskResultList = list;
		numrows = taskResultList.size();
		task = new Task();
		numcols = task.getNumberOfColumns();
		manager = em;
		taskService = new TaskService(manager);
	}
	

	// In this method, a newly inserted row in the GUI is added to the table
	// model as well as the database table
	// The argument to this method is an array containing the data in the
	// textfields of the new row.
	public void addRow(String[] array,String projectName) {
		// data[rowIndex][columnIndex] = (String) aValue;
		// complete the code
		// code in the method addRow in CourseListTableModel
		String userName = array[0];
    	String taskName = array[1];
    	String taskDesc = array[2];
    	Integer taskProjectedCost = Integer.parseInt(array[3]);
    	Integer taskActualCost = Integer.parseInt(array[4]);
    	String dependency = array[5];
    	String taskStartDate =  array[6];
    	String taskEndDate = array[7];
    	String taskStatus = array[8];
		EntityTransaction userTransaction = manager.getTransaction();   
		userTransaction.begin();
		Task newRecord = taskService.createTask(projectName,userName, taskName, taskDesc, dependency, taskStatus, taskProjectedCost, taskActualCost, taskStartDate, taskEndDate);
		userTransaction.commit();    
		// set the current row to rowIndex     
		taskResultList.add(newRecord);     
		int row = taskResultList.size(); 
		int col = 0;      
		// update the data in the model to the entries in array    
		for (Object data : array) {   
			setValueAt((String) data, row-1, col++);    
			}              
		numrows++;
		 
	}
	
	public void updateRow(String[] array,int selectedRow) {
		// data[rowIndex][columnIndex] = (String) aValue;
		// complete the code
		// code in the method addRow in CourseListTableModel
		String userName = array[0];
    	String taskName = array[1];
    	String taskDesc = array[2];
    	Integer taskProjectedCost = Integer.parseInt(array[3]);
    	Integer taskActualCost = Integer.parseInt(array[4]);
    	String dependency = array[5];
    	String taskStartDate =  array[6];
    	String taskEndDate = array[7];
    	String taskStatus = array[8];
		EntityTransaction userTransaction = manager.getTransaction();   
		userTransaction.begin();
		
		taskService.updateTask(userName, taskName, taskDesc, dependency, taskStatus, taskProjectedCost, taskActualCost, taskStartDate, taskEndDate);
		userTransaction.commit();    
		// set the current row to rowIndex      
		int col = 0;      
		// update the data in the model to the entries in array    
		for (Object data : array) {   
			setValueAt((String) data, selectedRow, col++);    
		}              
		 
	}
	public void deleteRow(int row){
		String taskName = (String) this.getValueAt(row, 1);
		EntityTransaction userTransaction = manager.getTransaction();   
		userTransaction.begin();
		taskService.deleteTaskByTaskName(taskName);
		userTransaction.commit();
		taskResultList.remove(row);
		numrows--;
		fireTableRowsDeleted(row, row);
	}
	
	
}
