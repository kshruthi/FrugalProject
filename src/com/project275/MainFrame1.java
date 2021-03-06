package com.project275;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.project275.entity.Project;
import com.project275.entity.Task;
import com.project275.entity.TeamMember;
import com.project275.entity.User;
import com.project275.service.ProjectService;
import com.project275.service.UserService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 
 */
public class MainFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame1
     */
    public MainFrame1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        queryPanel = new javax.swing.JPanel();
        leftSidePanel = new javax.swing.JPanel();
        queryProjectButton = new javax.swing.JButton();
        createTaskButton = new javax.swing.JButton();
        queryMemberButton = new javax.swing.JButton();
        createProjectButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        editProjectButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        createUserButton = new javax.swing.JButton();
        query1Panel = new javax.swing.JPanel();
        queryProjectPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryProjectTable = new javax.swing.JTable();
        queryprojectSubmitButton = new javax.swing.JButton();
        queryProjectClearButton = new javax.swing.JButton();
        projectNametextField = new javax.swing.JTextField();
        projectNameTextField = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        membertable = new javax.swing.JTable();
        queryTeamPanel = new javax.swing.JPanel();
        memberNameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        queryTeamSubmitButton = new javax.swing.JButton();
        queryTeamClearButton = new javax.swing.JButton();
        memberNameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        queryPanel.setBackground(new java.awt.Color(255, 255, 255));

        leftSidePanel.setBackground(new java.awt.Color(255, 255, 255));

        queryProjectButton.setText("Qyery Projectr");
        queryProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryProjectButtonActionPerformed(evt);
            }
        });

        createTaskButton.setText("Ceate Task");
        createTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskButtonActionPerformed(evt);
            }
        });

        queryMemberButton.setText("Query Member");
        queryMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryMemberButtonActionPerformed(evt);
            }
        });

        createProjectButton.setText("Create Project");

        editTaskButton.setText("Edit Task");

        editProjectButton.setText("Edit project");

        editUserButton.setText("Edit User");

        createUserButton.setText("Create User");

        javax.swing.GroupLayout leftSidePanelLayout = new javax.swing.GroupLayout(leftSidePanel);
        leftSidePanel.setLayout(leftSidePanelLayout);
        leftSidePanelLayout.setHorizontalGroup(
            leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftSidePanelLayout.createSequentialGroup()
                .addGroup(leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(queryMemberButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(queryProjectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createTaskButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editTaskButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        leftSidePanelLayout.setVerticalGroup(
            leftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queryProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(queryMemberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        query1Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        query1Panel.setLayout(new java.awt.CardLayout());

        queryProjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Project Desc", "Project Status"
            }
        ));
        jScrollPane1.setViewportView(queryProjectTable);

        queryprojectSubmitButton.setText("Submit");
        
        queryprojectSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	queryprojectSubmitButton(evt);
            }
        });

        queryProjectClearButton.setText("Clear");

        projectNameTextField.setText("Project Name");

        membertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Team Members"
            }
        ));
        jScrollPane3.setViewportView(membertable);

        javax.swing.GroupLayout queryProjectPanelLayout = new javax.swing.GroupLayout(queryProjectPanel);
        queryProjectPanel.setLayout(queryProjectPanelLayout);
        queryProjectPanelLayout.setHorizontalGroup(
            queryProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryProjectPanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(queryProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(queryProjectPanelLayout.createSequentialGroup()
                        .addGroup(queryProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(queryProjectPanelLayout.createSequentialGroup()
                                .addComponent(projectNametextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(queryprojectSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(queryProjectClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        queryProjectPanelLayout.setVerticalGroup(
            queryProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryProjectPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(queryProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectNametextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryprojectSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryProjectClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        query1Panel.add(queryProjectPanel, "card2");

        memberNameLabel.setText("Member Name");

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Task Name", "Task Desc", "Start Date", "End Date", "Status"
            }
        ));
        jScrollPane2.setViewportView(taskTable);

        queryTeamSubmitButton.setText("Submit");
       
        queryTeamSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	queryteamSubmitButton(evt);
            }
        });
        
        

        queryTeamClearButton.setText("Clear");

        javax.swing.GroupLayout queryTeamPanelLayout = new javax.swing.GroupLayout(queryTeamPanel);
        queryTeamPanel.setLayout(queryTeamPanelLayout);
        queryTeamPanelLayout.setHorizontalGroup(
            queryTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryTeamPanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(queryTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(queryTeamPanelLayout.createSequentialGroup()
                        .addComponent(memberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(queryTeamSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(queryTeamClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        queryTeamPanelLayout.setVerticalGroup(
            queryTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryTeamPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(memberNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(queryTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryTeamSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryTeamClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        query1Panel.add(queryTeamPanel, "card2");

        javax.swing.GroupLayout queryPanelLayout = new javax.swing.GroupLayout(queryPanel);
        queryPanel.setLayout(queryPanelLayout);
        queryPanelLayout.setHorizontalGroup(
            queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(query1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        queryPanelLayout.setVerticalGroup(
            queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftSidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(query1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void queryMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        query1Panel.removeAll();
        query1Panel.repaint();
        query1Panel.removeAll();

        query1Panel.add(queryTeamPanel);
        query1Panel.repaint();
        query1Panel.revalidate();
    }                                                 

    private void createTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:

    }                                                

    private void queryProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        query1Panel.removeAll();
        query1Panel.repaint();
        query1Panel.removeAll();

        query1Panel.add(queryProjectPanel);
        query1Panel.repaint();
        query1Panel.revalidate();
    }   
    
    private void queryprojectSubmitButton(java.awt.event.ActionEvent evt) {                                                   
   	 String projectName = projectNametextField.getText();
        displayQueryByProjectNameResult(ProjectService.getProjectByProjectName(projectName));
       
   }  
    private void queryteamSubmitButton(java.awt.event.ActionEvent evt){
    	String memberName = memberNameTextField.getText();
    	displayQueryTaskByMemberNameResult(UserService.getUserByUserName(memberName));
    	
    }

    


	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton createProjectButton;
    private javax.swing.JButton createTaskButton;
    private javax.swing.JButton createUserButton;
    private javax.swing.JButton editProjectButton;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel leftSidePanel;
    private javax.swing.JLabel memberNameLabel;
    private javax.swing.JTextField memberNameTextField;
    private javax.swing.JTable membertable;
    private javax.swing.JLabel projectNameTextField;
    private javax.swing.JTextField projectNametextField;
    private javax.swing.JPanel query1Panel;
    private javax.swing.JButton queryMemberButton;
    private javax.swing.JPanel queryPanel;
    private javax.swing.JButton queryProjectButton;
    private javax.swing.JButton queryProjectClearButton;
    private javax.swing.JPanel queryProjectPanel;
    private javax.swing.JTable queryProjectTable;
    private javax.swing.JButton queryTeamClearButton;
    private javax.swing.JPanel queryTeamPanel;
    private javax.swing.JButton queryTeamSubmitButton;
    private javax.swing.JButton queryprojectSubmitButton;
    private javax.swing.JTable taskTable;
    // End of variables declaration    

	private void displayQueryTaskByMemberNameResult(User user) {
		// TODO Auto-generated method stub
		Vector<String> taskTableHeaders = new Vector<String>();
		Vector taskTableData = new Vector();
		taskTableHeaders.add("Task Name");
		taskTableHeaders.add("Task Description");
		taskTableHeaders.add("Start Date");
		taskTableHeaders.add("End Date");
		taskTableHeaders.add("Task Status");
		if( user != null){
			Set<Task> tasks = user.getTasks();
			for(Task task : tasks){
				Vector<Object> row = new Vector<Object>();
				row.add(task.getTaskName());
				row.add(task.getTaskDesc());
				row.add(task.getTaskStartDate());
				row.add(task.getTaskEndDate());
				row.add(task.getTaskStatus());
				taskTableData.add(row);
			}
		}
		
    taskTable.setModel(new DefaultTableModel(taskTableData,taskTableHeaders));
		
	}
    
    private void displayQueryByProjectNameResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Project Name");
        tableHeaders.add("Project Status");
        
        Vector<String> memberTableHeaders = new Vector<String>();
        Vector memberTableData = new Vector();
        memberTableHeaders.add("Member Name");
        if(resultList!= null && resultList.size() > 0) {
        	Project project = (Project) resultList.get(0);
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(project.getProjName());
            oneRow.add(project.getProjStatus());
            tableData.add(oneRow);
            if(project.getTeam() != null ){
            	Set<TeamMember>teamMemberSet = project.getTeam().getTeamMembers();
            	for(TeamMember teamMember : teamMemberSet){
            		 Vector<Object> row = new Vector<Object>();
            		 //User  user = UserService.getUserById(teamMember.getUser().);
            		 row.add(teamMember.getUser().getUserName());
            		 memberTableData.add(row);
            	
            }
        }
       
        queryProjectTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        membertable.setModel(new DefaultTableModel(memberTableData,memberTableHeaders));
        

    }
    }
}
