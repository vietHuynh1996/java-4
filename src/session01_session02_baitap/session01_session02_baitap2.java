/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01_session02_baitap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author nguyenducthao
 */
class Student {

    private String studentID, studentName, classID;
    private boolean sex;

    public Student() {
    }

    public Student(String studentID, String studentName, String classID, boolean sex) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.classID = classID;
        this.sex = sex;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentName=" + studentName + ", classID=" + classID + ", sex=" + sex + '}';
    }

}

public final class session01_session02_baitap2 extends javax.swing.JFrame {

    /**
     * Creates new form session01_session02_baitap2
     */
    static ArrayList<Student> arrListStudent;
    static ArrayList<String> arrListClassID;
    static int currentElement = 0;

    void initArrayListStudent() throws ClassNotFoundException, SQLException {
        arrListStudent = new ArrayList<>();
        Connection conn;
        Statement stmt;
        Class.forName(DBparameters.JDBC_DRIVER);
        conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
        stmt = conn.createStatement();
        String sql = "SELECT studentid, studentname, sex, classid FROM student";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                arrListStudent.add(new Student(rs.getString("studentid"), rs.getString("studentname"), rs.getString("classid"), rs.getBoolean("sex")));
            }
        }
        stmt.close();
        conn.close();
    }

    void initArrayListClassID() throws ClassNotFoundException, SQLException {
        arrListClassID = new ArrayList<>();
        Connection conn;
        Statement stmt;
        Class.forName(DBparameters.JDBC_DRIVER);
        conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
        stmt = conn.createStatement();
        String sql = "SELECT classid FROM class";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                arrListClassID.add(rs.getString("classid"));
            }
        }
        stmt.close();
        conn.close();
    }

    void initGUI() {
        txtID.setEditable(false);
        btnUpdate.setEnabled(true);
        btnInsert.setEnabled(true);
        btnDelete.setEnabled(true);
        txtName.setEditable(false);
        radioMale.setEnabled(false);
        radioFemale.setEnabled(false);
        cmbClass.setEnabled(false);
        btnFirst.setEnabled(false);
        btnNext.setEnabled(true);
        btnPrevious.setEnabled(false);
        btnLast.setEnabled(true);
        currentElement = 0;
        txtID.setText(arrListStudent.get(0).getStudentID());
        txtName.setText(arrListStudent.get(0).getStudentName());
        if (arrListStudent.get(0).isSex()) {
            radioMale.setSelected(true);
            radioFemale.setSelected(false);
        } else {
            radioMale.setSelected(false);
            radioFemale.setSelected(true);
        }
        cmbClass.removeAllItems();
        cmbClass.addItem(arrListStudent.get(0).getClassID());
        txtCount.setText((currentElement + 1) + "/" + arrListStudent.size());
    }

    public session01_session02_baitap2() throws ClassNotFoundException, SQLException {
        initComponents();
        initArrayListStudent();
        initArrayListClassID();
        initGUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox<>();
        txtCount = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager student");
        setResizable(false);

        jLabel1.setText("ID");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Sex");

        buttonGroup1.add(radioMale);
        radioMale.setText("Male");

        buttonGroup1.add(radioFemale);
        radioFemale.setText("Female");

        jLabel4.setText("Class");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });
        cmbClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbClassMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbClassMouseReleased(evt);
            }
        });
        cmbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassActionPerformed(evt);
            }
        });

        txtCount.setEditable(false);
        txtCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(radioMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioFemale)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(radioFemale)
                    .addComponent(jLabel4)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioMale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        currentElement = arrListStudent.size() - 1;
        txtID.setText(arrListStudent.get(currentElement).getStudentID());
        txtName.setText(arrListStudent.get(currentElement).getStudentName());
        if (arrListStudent.get(currentElement).isSex()) {
            radioMale.setSelected(true);
            radioFemale.setSelected(false);
        } else {
            radioMale.setSelected(false);
            radioFemale.setSelected(true);
        }
        cmbClass.removeAllItems();
        cmbClass.addItem(arrListStudent.get(currentElement).getClassID());
        txtCount.setText((currentElement + 1) + "/" + arrListStudent.size());
        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        currentElement = 0;
        txtID.setText(arrListStudent.get(currentElement).getStudentID());
        txtName.setText(arrListStudent.get(currentElement).getStudentName());
        if (arrListStudent.get(currentElement).isSex()) {
            radioMale.setSelected(true);
            radioFemale.setSelected(false);
        } else {
            radioMale.setSelected(false);
            radioFemale.setSelected(true);
        }
        cmbClass.removeAllItems();
        cmbClass.addItem(arrListStudent.get(currentElement).getClassID());
        txtCount.setText((currentElement + 1) + "/" + arrListStudent.size());
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        currentElement++;
        txtID.setText(arrListStudent.get(currentElement).getStudentID());
        txtName.setText(arrListStudent.get(currentElement).getStudentName());
        if (arrListStudent.get(currentElement).isSex()) {
            radioMale.setSelected(true);
            radioFemale.setSelected(false);
        } else {
            radioMale.setSelected(false);
            radioFemale.setSelected(true);
        }
        cmbClass.removeAllItems();
        cmbClass.addItem(arrListStudent.get(currentElement).getClassID());
        txtCount.setText((currentElement + 1) + "/" + arrListStudent.size());
        if (currentElement < arrListStudent.size() - 1) {
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        } else {
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        currentElement--;
        txtID.setText(arrListStudent.get(currentElement).getStudentID());
        txtName.setText(arrListStudent.get(currentElement).getStudentName());
        if (arrListStudent.get(currentElement).isSex()) {
            radioMale.setSelected(true);
            radioFemale.setSelected(false);
        } else {
            radioMale.setSelected(false);
            radioFemale.setSelected(true);
        }
        cmbClass.removeAllItems();
        cmbClass.addItem(arrListStudent.get(currentElement).getClassID());
        txtCount.setText((currentElement + 1) + "/" + arrListStudent.size());
        if (currentElement > 0) {
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        } else {
            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
//        System.out.println(currentElement);
        String currentStudentID = arrListStudent.get(currentElement).getStudentID();
        String currentClass = cmbClass.getSelectedItem().toString();
        if (btnUpdate.getText().equalsIgnoreCase("update")) {
            txtID.setEditable(true);
            txtID.requestFocus();
            btnInsert.setText("Cancel");
            btnDelete.setEnabled(false);
            txtName.setEditable(true);
            radioMale.setEnabled(true);
            radioFemale.setEnabled(true);
            cmbClass.removeAllItems();
            for (int i = 0; i < arrListClassID.size(); i++) {
                cmbClass.addItem(arrListClassID.get(i));
                if (currentClass.equalsIgnoreCase(arrListClassID.get(i))) {
                    cmbClass.setSelectedIndex(i);
                }
            }
            cmbClass.setEnabled(true);
            btnFirst.setEnabled(false);
            btnNext.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnLast.setEnabled(false);
            btnUpdate.setText("Save");
            return;
        }

        if (btnUpdate.getText().equalsIgnoreCase("save")) {
            if (txtID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input student ID!", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input student name!", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtID.getText().length() > 10) {
                JOptionPane.showMessageDialog(null, "Student ID is only 10 characters!", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (txtName.getText().length() > 50) {
                JOptionPane.showMessageDialog(null, "Student name is only 50 characters!", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (!currentStudentID.equalsIgnoreCase(txtID.getText())) {
                try {
                    Connection conn;
                    Class.forName(DBparameters.JDBC_DRIVER);
                    conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
                    String sql = "SELECT studentid FROM student where studentid like ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, txtID.getText());
                    int countRow = 0;
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            countRow++;
                        }
                    }
                    conn.close();
                    if (countRow > 0) {
                        JOptionPane.showMessageDialog(null, "Student ID " + txtID.getText() + " already exists. Can not update!", "Error", JOptionPane.INFORMATION_MESSAGE);
                        txtID.requestFocus();
                        return;
                    } else {
                        Class.forName(DBparameters.JDBC_DRIVER);
                        conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
                        sql = "update student set "
                                + "studentid=?"
                                + ", studentname=?"
                                + ", sex=?"
                                + ", classid=?"
                                + " where "
                                + "studentid=?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, txtID.getText());
                        pstmt.setString(2, txtName.getText());
                        if (radioMale.isSelected()) {
                            pstmt.setBoolean(3, true);
                        } else {
                            pstmt.setBoolean(3, false);
                        }
                        pstmt.setString(4, cmbClass.getSelectedItem().toString());
                        pstmt.setString(5, currentStudentID);
                        pstmt.executeUpdate();
                        pstmt.close();
                        conn.close();
                        initArrayListStudent();
                        initGUI();
                        JOptionPane.showMessageDialog(null, "Update new student successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Connection conn;
                try {
                    Class.forName(DBparameters.JDBC_DRIVER);
                    conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
                    String sql = "update student set "
                            + "studentid=?"
                            + ", studentname=?"
                            + ", sex=?"
                            + ", classid=?"
                            + " where "
                            + "studentid=?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, txtID.getText());
                    pstmt.setString(2, txtName.getText());
                    if (radioMale.isSelected()) {
                        pstmt.setBoolean(3, true);
                    } else {
                        pstmt.setBoolean(3, false);
                    }
                    pstmt.setString(4, cmbClass.getSelectedItem().toString());
                    pstmt.setString(5, currentStudentID);
                    pstmt.executeUpdate();
                    pstmt.close();
                    conn.close();
                    initArrayListStudent();
                    initGUI();
                    JOptionPane.showMessageDialog(null, "Update new student successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            btnUpdate.setText("Update");
            btnInsert.setText("Insert");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
//        System.out.println(cmbClass.getSelectedIndex());
    }//GEN-LAST:event_cmbClassItemStateChanged

    private void cmbClassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbClassMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClassMouseReleased

    private void cmbClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbClassMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClassMouseClicked

    private void cmbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassActionPerformed
        // TODO add your handling code here:
//        System.out.println(cmbClass.getSelectedItem());

    }//GEN-LAST:event_cmbClassActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        if (btnInsert.getText().equalsIgnoreCase("cancel")) {
            btnUpdate.setText("Update");
            btnInsert.setText("Insert");
            try {
                initArrayListClassID();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
            }
            initGUI();
            return;
        }
        if (btnInsert.getText().equalsIgnoreCase("insert")) {
            btnInsert.setText("Save");
            btnDelete.setText("Cancel");

            txtID.setEditable(true);
            txtID.requestFocus();
            btnUpdate.setEnabled(false);
            btnInsert.setEnabled(true);
            btnDelete.setEnabled(true);
            txtName.setEditable(true);
            btnDelete.setEnabled(true);
            radioMale.setEnabled(true);
            radioFemale.setEnabled(true);
            buttonGroup1.clearSelection();
            cmbClass.removeAllItems();
            for (int i = 0; i < arrListClassID.size(); i++) {
                cmbClass.addItem(arrListClassID.get(i));
            }
            cmbClass.setEnabled(true);
            btnFirst.setEnabled(false);
            btnNext.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnLast.setEnabled(false);
            return;
        }
        if (btnInsert.getText().equalsIgnoreCase("save")) {
            if (txtID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input student ID!", "Error", JOptionPane.INFORMATION_MESSAGE);
                txtID.requestFocus();
                return;
            }
            if (txtID.getText().length() > 10) {
                JOptionPane.showMessageDialog(null, "Student ID is only 10 characters!", "Error", JOptionPane.INFORMATION_MESSAGE);
                txtID.requestFocus();
                return;
            }
            if (txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input student name!", "Error", JOptionPane.INFORMATION_MESSAGE);
                txtName.requestFocus();
                return;
            }
            if (txtName.getText().length() > 50) {
                JOptionPane.showMessageDialog(null, "Student name is only 50 characters!", "Error", JOptionPane.INFORMATION_MESSAGE);
                txtName.requestFocus();
                return;
            }
            if ((!radioMale.isSelected()) && (!radioFemale.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please select sex of student!", "Error", JOptionPane.INFORMATION_MESSAGE);
                txtName.requestFocus();
                return;
            }
            Connection conn;
            try {
                Class.forName(DBparameters.JDBC_DRIVER);
                conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
                String sql = "SELECT studentid FROM student where studentid like ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtID.getText());
                int countRow = 0;
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        countRow++;
                    }
                }
                conn.close();
                if (countRow > 0) {
                    JOptionPane.showMessageDialog(null, "Student ID " + txtID.getText() + " already exists. Can not update!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    txtID.requestFocus();
                    return;
                } else {
                    Class.forName(DBparameters.JDBC_DRIVER);
                    conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
                    sql = "insert into student values (?,?,?,?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, txtID.getText());
                    pstmt.setString(2, txtName.getText());
                    if (radioMale.isSelected()) {
                        pstmt.setBoolean(3, true);
                    } else {
                        pstmt.setBoolean(3, false);
                    }
                    pstmt.setString(4, cmbClass.getSelectedItem().toString());
                    pstmt.executeUpdate();
                    pstmt.close();
                    conn.close();
                    initArrayListStudent();
                    initGUI();
                    JOptionPane.showMessageDialog(null, "Insert new student successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnInsert.setText("Insert");
            btnDelete.setText("Delete");
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (btnDelete.getText().equalsIgnoreCase("cancel")) {
            btnInsert.setText("Insert");
            btnDelete.setText("Delete");
            try {
                initArrayListClassID();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
            }
            initGUI();
            return;
        }
        if (btnDelete.getText().equalsIgnoreCase("delete")) {
            String str = "Are you sure you want to delete student whose student id is '"
                    + txtID.getText()
                    + "', name is '" + txtName.getText() + "'";
            if (radioMale.isSelected()) {
                str = str + ", sex is 'Male'";
            }
            if (radioFemale.isSelected()) {
                str = str + ", sex is 'Female'";
            }
            str = str + ", class ID is '" + cmbClass.getSelectedItem() + "'";
            int i = JOptionPane.showConfirmDialog(null, str, "Comfirm Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) {
                Connection conn;
                try {
                    Class.forName(DBparameters.JDBC_DRIVER);
                    conn = DriverManager.getConnection(DBparameters.DB_URL + DBparameters.DATABASENAME + DBparameters.USER + DBparameters.PASS);
                    String sql = "delete student where studentid like ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, txtID.getText());
                    pstmt.executeUpdate();
                        pstmt.close();
                        conn.close();
                        initArrayListStudent();
                        initGUI();
                        JOptionPane.showMessageDialog(null, "Delete an student successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String args[]) throws InstantiationException, IllegalAccessException {
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
            java.util.logging.Logger.getLogger(session01_session02_baitap2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(session01_session02_baitap2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(session01_session02_baitap2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(session01_session02_baitap2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new session01_session02_baitap2().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(session01_session02_baitap2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTextField txtCount;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
