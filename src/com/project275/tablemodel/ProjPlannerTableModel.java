package com.project275.tablemodel;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.AbstractTableModel;

import com.project275.entity.Project;
import com.project275.service.ProjectService;


public class ProjPlannerTableModel extends AbstractTableModel{

	List<Project> projPlannerResultList;
	private static final String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Project project;
	private ProjectService projectService;
	private int numcols,numrows;
	
	//CachedRowSet userListRowSet; // contains data
    //ResultSetMetaData metadata;     // Additional information about the data
    //Connection connection;

	public ProjPlannerTableModel(){
				System.out.println("inside ProjPlannerTableModel");
		factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager=factory.createEntityManager();
		project=new Project();
		projectService=new ProjectService(manager);
		
		projPlannerResultList= projectService.readAll();
		numrows=projPlannerResultList.size();
		numcols=project.getNumberOfColumns();
	}
	
  

	public int getRowCount() 
	{
		return numrows;
	}
	
	public int getColumnCount()
	{
		return numcols;
	}
	
	public Object getValueAt(int row,int col)
	{
		try {
			return projPlannerResultList.get(row).getColumnData(col);
			
		  } catch (Exception e) {
		          return "";
		  }
	}
	
	public boolean isCellEditable(int rowIndex,int colIndex)
	{
		return false;
	}
	
	public Class<?> getColumnClass(int col)
	{
		return getValueAt(0,col).getClass();
	}
	
	public String getColumnName(int col)
	{
		
		try {
			return project.getColumnName(col);
		} catch (Exception err) {
             return err.toString();
        }             

	}
	
	public void setValueAt(Object aValue,int row,int col)
	{
		System.out.println("inside setValueAt projPlannerResultList >>>>"+projPlannerResultList);
		try {
			Project element = projPlannerResultList.get(row);
			element.setColumnData(col, aValue);
			fireTableCellUpdated(row,col);
		} catch(Exception err) {
			err.getMessage();
			err.printStackTrace();
		}

	}
	public void deleteValueAt(Object aValue,int row,int col)
	{
		System.out.println("inside deleteValueAt projPlannerResultList >>>>"+projPlannerResultList);
		try {
			Project element = projPlannerResultList.get(row);
			element.setColumnData(col, aValue);
			fireTableRowsDeleted(row,col);
		} catch(Exception err) {
			err.getMessage();
			err.printStackTrace();
		}

	}
	public List<Project> getList(){
		return projPlannerResultList;
	}
	public EntityManager getEntityManager(){
		return manager;
	}
	
	public ProjPlannerTableModel(List<Project> list, EntityManager em)  {
    	try {
    		manager=em;
    		projectService=new ProjectService(manager);
    		projPlannerResultList=projectService.readAll();
    		numrows=projPlannerResultList.size();
    		project=new Project();
    		numcols=project.getNumberOfColumns();
    		//manager=em;
    		//userListService=new UserListService(manager);
	       
    	} catch(Exception exp) {
    		exp.printStackTrace();
    	}
    }

	public void addRow(Object[] array){
		System.out.print("inside addRow");
		try {
			EntityTransaction userTransaction =manager.getTransaction();
			userTransaction.begin();
			
			Project newRecord=projectService.createProject((String)array[0],(String)array[1],(String)array[2],
					(String)array[3],(String)array[4],(String)array[5],(String)array[6],
					(String)array[7],Integer.parseInt((String)array[8]),Integer.parseInt((String)array[9]),(String)array[0]);
			
			userTransaction.commit();
			projPlannerResultList.add(newRecord);
			int row=projPlannerResultList.size();
			int col=0;
			for(Object data : array){
				setValueAt((String)data,row-1,col++);
			}
			numrows++;
			} catch(Exception err) {
				err.getMessage();
				err.printStackTrace();
			}

	}
	/*public RowSet getRowSet() {
		return (RowSet) userListResultList;
	}*/

public void updateRow(String[] array) {
		System.out.print("inside updateRow");
		try {
			EntityTransaction userTransaction =manager.getTransaction();
			userTransaction.begin();
			//Integer.parseInt((String)array[11])
			Project updateRecord=projectService.updateProject(Integer.parseInt((String)array[11]),(String)array[0],(String)array[1],(String)array[2],
					(String)array[3],(String)array[4],(String)array[5],(String)array[6],
					(String)array[7],Integer.parseInt((String)array[8]),Integer.parseInt((String)array[9]),(String)array[0]);
			
			userTransaction.commit();
			projPlannerResultList.add(updateRecord);
			int row=projPlannerResultList.size();
			int col=0;
			for(int i=0;i<=10;i++){
				Object data=array[i];
				setValueAt((String)data,row-1,col++);
			}
			numrows++;
			} catch(Exception err) {
				err.getMessage();
				err.printStackTrace();
			}
	}



	public void fetchProject(String[] array) {
		// TODO Auto-generated method stub
		try {
			EntityTransaction userTransaction =manager.getTransaction();
			userTransaction.begin();
			
			List<Project> projPlannerResultList=projectService.fetchProjectDetails((String)array[0]);
			
			userTransaction.commit();
			
			int row=projPlannerResultList.size();
			int col=0;
			for(Object data : array){
				getValueAt(row-1,col++);
			}
			numrows++;
			} catch(Exception err) {
				err.getMessage();
				err.printStackTrace();
			}
	}


	/*public void deleteRow(String[] array) {
		// TODO Auto-generated method stub
		System.out.print("inside deleteRow");
		try {
			EntityTransaction userTransaction =manager.getTransaction();
			userTransaction.begin();
			//projectService.deleteCourse(Integer.parseInt((String)array[0]));
			userTransaction.commit();
			//userListResultList.add(newRecord);
			int row=projPlannerResultList.size();
			int col=0;
			for(Object data : array){
				deleteValueAt((String)data,row-1,col++);
			}
			numrows++;
			} catch(Exception err) {
				err.getMessage();
				err.printStackTrace();
			}
	}*/


}