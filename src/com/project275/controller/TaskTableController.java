package com.project275.controller;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import com.project275.MainFrame5;
import com.project275.tablemodel.TaskTableModel;



public class TaskTableController implements ListSelectionListener, TableModelListener{

	     private TaskTableModel tableModel;
	     private MainFrame5 gui;
	     
	     public TaskTableController(MainFrame5 gui,String projectName)
	     {
	    	 this.gui = gui;
	    	 
	    	 tableModel = new TaskTableModel(projectName);
	    	 tableModel.addTableModelListener(this);
	    	 //tableModel.removeTableModelListener(this);

	     }
	     
	    /* public TaskTableController(MainFrame2 gui,String projectName){
	    	 this.gui = gui;
	    	 tableModel = new TaskTableModel(projectName);
	    	 tableModel.addTableModelListener(this);
	     }*/
	     
	     public TableModel getTableModel()
	     {
	    	 return tableModel;
	     }
	     
	     public void valueChanged(ListSelectionEvent e)
	     {
	    	 ListSelectionModel selectModel = (ListSelectionModel)e.getSource();
	    	 
	    	 int firstIndex = selectModel.getMinSelectionIndex();
	    	 
	         gui.setUserNameTextField((String)tableModel.getValueAt(firstIndex, 0));
	         gui.setTaskNameTextField((String)tableModel.getValueAt(firstIndex, 1));
	         gui.setTaskDescriptionTextField((String)tableModel.getValueAt(firstIndex, 2));
	         gui.setProjectedCostTextField((String)tableModel.getValueAt(firstIndex, 3));
	         gui.setActualCostTextField((String)tableModel.getValueAt(firstIndex, 4));
	         gui.setDependencyTextField((String)tableModel.getValueAt(firstIndex, 5));
	         gui.setStartDateTextField((String)tableModel.getValueAt(firstIndex, 6));
	         gui.setEndDateTextField((String)tableModel.getValueAt(firstIndex, 7));
	         gui.setStatusTextField((String)tableModel.getValueAt(firstIndex, 8)); 
	         
	     }
	     public void tableChanged(TableModelEvent e) {  
	    	 try {  
	    		 // get the index of the inserted row 
	    		 //tableModel.getRowSet().moveToCurrentRow(); 
	    		 int firstIndex =  e.getFirstRow();         
	    		 // create a new table model with the new data      
	    		 tableModel = new TaskTableModel(tableModel.getList(), tableModel.getEntityManager()); 
	    		 tableModel.addTableModelListener(this);   
	    		 // update the JTable with the data  
	    		 gui.updateTable();            
	    		 // read the data in each column using getValueAt and display it on corresponding textfield  
	    		 gui.setUserNameTextField((String)tableModel.getValueAt(firstIndex, 0));
		         gui.setTaskNameTextField((String)tableModel.getValueAt(firstIndex, 1));
		         gui.setTaskDescriptionTextField((String)tableModel.getValueAt(firstIndex, 2));
		         gui.setProjectedCostTextField((String)tableModel.getValueAt(firstIndex, 3));
		         gui.setActualCostTextField((String)tableModel.getValueAt(firstIndex, 4));
		         gui.setDependencyTextField((String)tableModel.getValueAt(firstIndex, 5));
		         gui.setStartDateTextField((String)tableModel.getValueAt(firstIndex, 6));
		         gui.setEndDateTextField((String)tableModel.getValueAt(firstIndex, 7));
		         gui.setStatusTextField((String)tableModel.getValueAt(firstIndex, 8)); 
   } 
	    	 catch(Exception exp) {  
	    		 exp.getMessage(); 
	    		 exp.printStackTrace();
	    	 }
	     }
	     
	     public void addRow(String[] array,String projectName)
	     {
	    	 
	    	 tableModel.addRow(array,projectName); 
	     }
	   
	    public void deleteRow(int row) {
	    	
	    	tableModel.deleteRow(row);
	    }
	    
	    public void updateRow(String[] array,int selectedRow)
	     {
	    	 
	    	 tableModel.updateRow(array,selectedRow); 
	     }
	     
}