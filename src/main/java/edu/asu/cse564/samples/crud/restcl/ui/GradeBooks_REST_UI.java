/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.samples.crud.restcl.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.asu.cse564.samples.crud.restcl.GradeBooks_CRUD_cl;
import edu.asu.cse564.samples.crud.jaxb.model.GradeBooksUIInp;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

/**
 *
 * @author fcalliss
 * @author Charan1312
 */
public class GradeBooks_REST_UI extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(GradeBooks_REST_UI.class);
    
    private GradeBooks_CRUD_cl gradeBooks_CRUD_rest_client;
    GradeBooksUIInp gradeBookUIInp ;//= new GradeBooksUIInp();
    
    //private URI resourceURI;

    /**
     * Creates new form gradeBooks_REST_UI
     */
    public GradeBooks_REST_UI() {
        LOG.info("Creating a GradeBooks_REST_UI object");
        
        initComponents();
        
        gradeBooks_CRUD_rest_client = new GradeBooks_CRUD_cl();
    }
    
    private String createAndSendPostBody(){
        
        //Appointment appointment = new Appointment();
        //GradeBooksUIInp gradeBookUIInp = new GradeBooksUIInp();
        gradeBookUIInp = new GradeBooksUIInp();
        if (!jTextField1.getText().equals("")){
            //appointment.setId(Integer.parseInt(jTextField1.getText())); //////////////////////////////
            gradeBookUIInp.setStudentId(Integer.parseInt(jTextField1.getText()));
        }
        if (!jTextField2.getText().equals("")){
            //appointment.setTitle(jTextField2.getText());  ///////////////////
            gradeBookUIInp.setName(jTextField2.getText());
        }
        
        if (!jTextField4.getText().equals("")){
            //appointment.setPriority(Integer.parseInt(jTextField4.getText()));     ////////////////////
            gradeBookUIInp.setGrade(Integer.parseInt(jTextField4.getText()));
        }
            
        /*
        if (!jTextField3.getText().equals("")){
            gradeBooks.setGrade(Integer.parseInt(jTextField3.getText()));
        }

        if (!jTextField5.getText().equals("")){
            gradeBooks.setGrade(Integer.parseInt(jTextField4.getText()));
        }

        if (!jTextField6.getText().equals("")){
            gradeBooks.setGrade(Integer.parseInt(jTextField4.getText()));
        }
        */
        
        if (!jTextField7.getText().equals("")){
            gradeBookUIInp.setGradeItemId(Integer.parseInt(jTextField7.getText()));
        }

        if (!jTextField8.getText().equals("")){
            gradeBookUIInp.setGradeBookId(Integer.parseInt(jTextField8.getText()));
        }

        if (!jTextField9.getText().equals("")){
            gradeBookUIInp.setFeedback(jTextField9.getText());
        }

        if (!jComboBox1.getSelectedItem().toString().equals("")){
            gradeBookUIInp.setComboText(jComboBox1.getSelectedItem().toString());
        }

        //String xmlString = Converter.convertFromObjectToXml(appointment, appointment.getClass());
        ObjectMapper mapper = new ObjectMapper();
        String JSONString = null;
        
        try {
            JSONString = mapper.writeValueAsString(gradeBookUIInp);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return JSONString;
    }
    
    private void populateForm(ClientResponse clientResponse){
        if (gradeBookUIInp.getGradeBookId() != 0)
            jTextField8.setText(Integer.toString(gradeBookUIInp.getGradeBookId()));
        if(gradeBookUIInp.getGradeItemId() != 0)
            jTextField7.setText(Integer.toString(gradeBookUIInp.getGradeItemId()));
        if(gradeBookUIInp.getStudentId() != 0)
            jTextField1.setText(Integer.toString(gradeBookUIInp.getStudentId()));
        jTextField2.setText(gradeBookUIInp.getName());
        if(gradeBookUIInp.getGrade() != 0)
            jTextField4.setText(Integer.toString(gradeBookUIInp.getGrade()));
        jTextField9.setText(gradeBookUIInp.getFeedback());
        //gradeBookUIInp;
        System.out.println("NO CONTENT RET CODE:" + clientResponse.getStatus());
        String entity="";
        jTextField6.setText("");
        jTextArea10.setText("");     //

        if(clientResponse.getStatus() != 204)
            entity = clientResponse.getEntity(String.class);
        jTextField3.setText(Integer.toString(clientResponse.getStatus()));
        if(clientResponse.getStatus() != 204)
            jTextField6.setText(clientResponse.getType().toString());
        if(clientResponse.getLocation() != null)
            jTextField5.setText(clientResponse.getLocation().toString());
        jTextArea10.setText(entity);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        
        String[] items = { "GradeBooks", "GradeBook", "Student" , "Assignment" , "Quiz" , "Mid Term" , "Lab" }; 
        
        jComboBox1 = new JComboBox(items);
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Action");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Create");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Read");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Update");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Delete");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("GradeBooks Menu");

        jLabel3.setText("Student Id");

        jLabel10.setText("GradeItem Id");
        jLabel11.setText("GradeBook / Student / GradeItem");
        jLabel12.setText("GradeBook Id");
        jLabel13.setText("Feedback");
        jLabel14.setText("Response Body");
        
        /*
        jComboBox1.setEditable(true);
        jComboBox1.addItem("GradeBooks");
        jComboBox1.addItem("GradeBook");
        jComboBox1.addItem("Student");
        jComboBox1.addItem("Assignment");
        jComboBox1.addItem("Quiz");
        jComboBox1.addItem("Mid Term");
        jComboBox1.addItem("Lab");
        */
        
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                jComboBox1ActionPerformed(event);
            } 
        });
        
        
        jLabel4.setText("Gradebook Title / Student Name / GradeItem Title");

        jLabel6.setText("Grade");

        jTextField1.setName("StudentIdField"); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setName("NameField"); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        //jTextField4.setToolTipText("dd/MM/yyyy HH:mm:ss");
        jTextField4.setName("GradeField"); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField7.setName("GradeItemField"); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setName("GradeBookField"); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField9.setName("FeedbackField"); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextArea10.setName("ResponseBodyField"); // NOI18N
        //jTextArea10.addActionListener(new java.awt.event.ActionListener() {
        //    public void actionPerformed(java.awt.event.ActionEvent evt) {
        //        jTextArea10ActionPerformed(evt);
        //    }
        //});

        
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("HTTP Status Code");

        jTextField3.setName("StatusCodeField"); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Location");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("HTTP Header Info / Response Body");

        jTextField5.setName("LocationField"); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Media Type");

        jTextField6.setName("MediaTypeField"); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        
        //JTextArea jtextArea10 = new JTextArea();
        
        JLabel lblResponseBody = new JLabel("Response Body");
        
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(49)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(237)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton2))
                                    .addGap(104)
                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jButton1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel13))
                                            .addGap(31)
                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))))
                                .addComponent(jRadioButton1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(43)
                                            .addComponent(jLabel7))
                                        .addComponent(lblResponseBody, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jTextField5, Alignment.TRAILING, 487, 487, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addGap(54)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField6, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                                        .addComponent(jTextArea10, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))))))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGap(41)
                            .addComponent(jButton1)
                            .addGap(18)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(jRadioButton2)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(jRadioButton3)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(jRadioButton4)))
                    .addGap(21)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28)
                            .addComponent(jTextArea10, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43)
                            .addComponent(lblResponseBody)))
                    .addContainerGap(63, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        LOG.info("Selecting radio button {}", jRadioButton1.getText());
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        LOG.info("Selecting radio button {}", jRadioButton2.getText());
    }//GEN-LAST:event_jRadioButton2ActionPerformed
      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jRadioButton1.isSelected()){

            if(jComboBox1.getSelectedItem().toString().equals("GradeBooks")) {

            } else if (jComboBox1.getSelectedItem().toString().equals("GradeBook")) {
                System.out.println("HERE::::::::::" + this.createAndSendPostBody());
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.createNewGradeBook(this.createAndSendPostBody());
                //resourceURI = clientResponse.getLocation();
                this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("Student")) {
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.createNewStudentInGradeBook(gbId, this.createAndSendPostBody());
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Assignment")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(jTextField8.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.createNewAssignmentForAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                } else {
                    if(jTextField7.getText().equals("") && jTextField1.getText().equals("")) {
                        clientResponse = gradeBooks_CRUD_rest_client.createNewAssignmentForAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                    } else {
                        if(!jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.createNewAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        } else {
                            clientResponse = gradeBooks_CRUD_rest_client.createNewAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        }
                    }
                }
                this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("Quiz")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(jTextField8.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.createNewQuizForAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                } else {
                    if(jTextField7.getText().equals("") && jTextField1.getText().equals("")) {
                        clientResponse = gradeBooks_CRUD_rest_client.createNewQuizForAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                    } else {
                        if(!jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.createNewQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        } else {
                            clientResponse = gradeBooks_CRUD_rest_client.createNewQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        }
                    }
                }
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Mid Term")) {
                
            } else if (jComboBox1.getSelectedItem().toString().equals("Lab")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(jTextField8.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.createNewLabForAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                } else {
                    if(jTextField7.getText().equals("") && jTextField1.getText().equals("")) {
                        clientResponse = gradeBooks_CRUD_rest_client.createNewLabForAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                    } else {
                        if(!jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.createNewLabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        } else {
                            clientResponse = gradeBooks_CRUD_rest_client.createNewLabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        }
                    }
                }
                this.populateForm(clientResponse);                 
            }
        } else if (jRadioButton2.isSelected()) {

            if(jComboBox1.getSelectedItem().toString().equals("GradeBooks")) {
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.readAllGradebooks(this.createAndSendPostBody());
                this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("GradeBook")) {
                System.out.println("GRADEBOOK :"+ jTextField8.getText()+"abc");
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                System.out.println("After setting GB ID: "+ gbId);
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.readAGradeBook(gbId ,this.createAndSendPostBody());
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Student")) {
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                ClientResponse clientResponse;
                if(jTextField1.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.readAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                } else {
                    int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                    clientResponse = gradeBooks_CRUD_rest_client.readAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("Assignment")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(jTextField8.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.readAllAssignmentForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                } else {
                    if(jTextField7.getText().equals("") && jTextField1.getText().equals("")) {
                        clientResponse = gradeBooks_CRUD_rest_client.readAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                    } else {
                        if(jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.readAllAssignmentForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                        } else if(!jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.readAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        } else {
                            clientResponse = gradeBooks_CRUD_rest_client.readAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        }
                    }
                }
                this.populateForm(clientResponse);
                
            } else if (jComboBox1.getSelectedItem().toString().equals("Quiz")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(jTextField8.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.readAllQuizForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                } else {
                    if(jTextField7.getText().equals("") && jTextField1.getText().equals("")) {
                        clientResponse = gradeBooks_CRUD_rest_client.readAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                    } else {
                        if(jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.readAllQuizForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                        } else if(!jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.readAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        } else {
                            clientResponse = gradeBooks_CRUD_rest_client.readAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        }
                    }
                }
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Mid Term")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                //int aId = jTextField7.getText() == null ? Integer.valueOf(jTextField7.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") ) {
                    clientResponse = gradeBooks_CRUD_rest_client.readMidTermForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.readMidTermForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                 
            } else if (jComboBox1.getSelectedItem().toString().equals("Lab")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(jTextField8.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.readAllLabForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                } else {
                    if(jTextField7.getText().equals("") && jTextField1.getText().equals("")) {
                        clientResponse = gradeBooks_CRUD_rest_client.readALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                    } else {
                        if(jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.readAllLabForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                        } else if(!jTextField7.getText().equals("") && !jTextField1.getText().equals("")) {
                            clientResponse = gradeBooks_CRUD_rest_client.readALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        } else {
                            clientResponse = gradeBooks_CRUD_rest_client.readALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                        }
                    }
                }
                this.populateForm(clientResponse);                 
            }
        } else if (jRadioButton3.isSelected()) {

            if(jComboBox1.getSelectedItem().toString().equals("GradeBooks")) {
                //ClientResponse clientResponse = gradeBooks_CRUD_rest_client.updateAppointment(this.createAndSendPostBody(), appointmentID);
                //this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("GradeBook")) {
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.updateAGradeBook(gbId ,this.createAndSendPostBody());
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Student")) {
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.updateAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                this.populateForm(clientResponse);
                
            } else if (jComboBox1.getSelectedItem().toString().equals("Assignment")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") && !jTextField7.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.updateGradeForAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.updateGradeForAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);               
            } else if (jComboBox1.getSelectedItem().toString().equals("Quiz")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") && !jTextField7.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.updateGradeForAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.updateGradeForAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                 
            } else if (jComboBox1.getSelectedItem().toString().equals("Mid Term")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                //int aId = jTextField7.getText() == null ? Integer.valueOf(jTextField7.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") ) {
                    clientResponse = gradeBooks_CRUD_rest_client.updateMidTermForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.updateMidTermForAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Lab")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") && !jTextField7.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.updateGradeForALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.updateGradeForALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                
            }
            
        } else if (jRadioButton4.isSelected()) {
            
            if(jComboBox1.getSelectedItem().toString().equals("GradeBooks")) {
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.deleteAllGradebooks(this.createAndSendPostBody());
                this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("GradeBook")) {
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                ClientResponse clientResponse = gradeBooks_CRUD_rest_client.deleteAGradeBook(gbId ,this.createAndSendPostBody());
                this.populateForm(clientResponse);                
                
            } else if (jComboBox1.getSelectedItem().toString().equals("Student")) {
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                ClientResponse clientResponse;
                if(jTextField1.getText() == null) {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteAllStudentsInGradeBook(gbId, this.createAndSendPostBody());
                } else {
                    int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                    clientResponse = gradeBooks_CRUD_rest_client.deleteAStudentInGradeBook(gbId, sId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);
            } else if (jComboBox1.getSelectedItem().toString().equals("Assignment")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") && !jTextField7.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                //} else if(jTextField8.getText() != null && jTextField1.getText() != null && jTextField7.getText() == null) {
                //    clientResponse = gradeBooks_CRUD_rest_client.deleteAllAssignmentsForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteAnAssignmentForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                
            } else if (jComboBox1.getSelectedItem().toString().equals("Quiz")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") && !jTextField7.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                //} else if(jTextField8.getText() != null && jTextField1.getText() != null && jTextField7.getText() == null) {
                //    clientResponse = gradeBooks_CRUD_rest_client.deleteAllQuizsForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteAQuizForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                 
            } else if (jComboBox1.getSelectedItem().toString().equals("Mid Term")) {
                
            } else if (jComboBox1.getSelectedItem().toString().equals("Lab")) {
                ClientResponse clientResponse;
                int gbId = !jTextField8.getText().equals("") ? Integer.valueOf(jTextField8.getText()) : 0;
                int aId = !jTextField7.getText().equals("") ? Integer.valueOf(jTextField7.getText()) : 0;
                int sId = !jTextField1.getText().equals("") ? Integer.valueOf(jTextField1.getText()) : 0;
                if(!jTextField8.getText().equals("") && !jTextField1.getText().equals("") && !jTextField7.getText().equals("")) {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                //} else if(jTextField8.getText() != null && jTextField1.getText() != null && jTextField7.getText() == null) {
                //    clientResponse = gradeBooks_CRUD_rest_client.deleteAllLabsForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                } else {
                    clientResponse = gradeBooks_CRUD_rest_client.deleteALabForAStudentInGradeBook(gbId, sId, aId, this.createAndSendPostBody());
                }
                this.populateForm(clientResponse);                
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        LOG.info("Selecting radio button {}", jRadioButton3.getText());
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        LOG.info("Selecting radio button {}", jRadioButton4.getText());
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

//    private void jTextArea10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBox1ActionPerformed(ActionEvent evt) {
        
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
            java.util.logging.Logger.getLogger(GradeBooks_REST_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeBooks_REST_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeBooks_REST_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeBooks_REST_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeBooks_REST_UI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;

    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextArea jTextArea10;
    
    private javax.swing.JComboBox jComboBox1;
}
    