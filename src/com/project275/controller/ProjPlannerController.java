package com.project275.controller;


import com.project275.tablemodel.ProjPlannerTableModel;
import com.project275.MainFrame5;
import javax.sql.RowSet;
import javax.sql.RowSetListener;
import javax.sql.RowSetEvent;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;



/**
 * Updated controller
* Glue between the view (CourseListGUI) and the model (CourseListTableModel). 
* No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
* @author 
*/
public class ProjPlannerController implements ListSelectionListener, TableModelListener {
	private ProjPlannerTableModel tableModel;
	private MainFrame5 gui;
	
	
	public ProjPlannerController(MainFrame5 gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
    	tableModel = new ProjPlannerTableModel(); 
    	//tableModel.addTableModelListener(this);
	}
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		/*gui.setUserID( (String) tableModel.getValueAt(firstIndex, 0));
		gui.setUserName( (String) tableModel.getValueAt(firstIndex, 1));
		gui.setRole( (String) tableModel.getValueAt(firstIndex, 2));
		gui.setAdmin( (String) tableModel.getValueAt(firstIndex, 3));
		gui.setIsActive( (String) tableModel.getValueAt(firstIndex, 4));
		gui.setEmail( (String) tableModel.getValueAt(firstIndex, 5));
		gui.setPassword( (String) tableModel.getValueAt(firstIndex, 6));*/
	}
	
	public void cursorMoved(RowSetEvent event) {
		
	}
	
	public void rowSetChanged(RowSetEvent event) {
		
	}
	
	public void tableChanged(TableModelEvent e) {
		try {
				int firstIndex=e.getFirstRow();
		        /*tableModel = new ProjectTableModel(tableModel.getList(), tableModel.getEntityManager());
		        tableModel.addTableModelListener(this);
		        gui.updateTable();
		    
		        
		        gui.setUserID( (String) tableModel.getValueAt(firstIndex, 0));
				gui.setUserName( (String) tableModel.getValueAt(firstIndex, 1));
				gui.setRole( (String) tableModel.getValueAt(firstIndex, 2));
				gui.setAdmin( (String) tableModel.getValueAt(firstIndex, 3));
				gui.setIsActive( (String) tableModel.getValueAt(firstIndex, 4));
				gui.setEmail( (String) tableModel.getValueAt(firstIndex, 5));
				gui.setPassword( (String) tableModel.getValueAt(firstIndex, 6));
				*/
		} catch(Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}
	}

	public void addRow(String[] array) {
		tableModel.addRow(array);			
	}
	
	
	public void deleteRow(String[] array) {
		// TODO Auto-generated method stub
		
	}

	public void clearRow(String[] array) {
		// TODO Auto-generated method stub
		//tableModel.clearRow(array);	
		/*gui.setUserID("");
		gui.setUserName("");
		gui.setRole("");
		gui.setAdmin("");
		gui.setIsActive("");
		gui.setEmail("");
		gui.setPassword("");*/
	}

	public void fetchProject(String[] array) {
		// TODO Auto-generated method stub
		/*tableModel.fetchProject(array);	
		gui.setProjectID((String) tableModel.getValueAt(0, 0));
		gui.setProjectStatus((String) tableModel.getValueAt(0, 2));
		gui.setPartnerName((String) tableModel.getValueAt(0, 3));
		gui.setStoreName((String) tableModel.getValueAt(0, 4));
		gui.setDiscDate((String) tableModel.getValueAt(0, 5));
		gui.setProjectDesc((String) tableModel.getValueAt(0, 6));
		gui.setStartDate((String) tableModel.getValueAt(0, 7));
		gui.setEndDate((String) tableModel.getValueAt(0, 8));
		gui.setProjectedCost((String) tableModel.getValueAt(0, 9));
		gui.setActualCost((String) tableModel.getValueAt(0, 10));
		gui.setProjectOutcome((String) tableModel.getValueAt(0, 11));*/
	}

	public void updateRow(String[] array) {
		// TODO Auto-generated method stub
		tableModel.updateRow(array);		
	}
}