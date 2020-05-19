/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package N;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.SocketException;
import java.util.Arrays;
import javax.swing.JFrame;



public class AwesomeClientWindow extends JFrame implements Runnable {

   private Thread run,listen;
    private Client client;
    private boolean running =false;   
   int xx,xy,flag=0;
    
    
    public AwesomeClientWindow(String name, String address, int port)throws SocketException {
        
        
        
          client =new Client(name,address,port);
         
        boolean connect=client.openConnection(address);
        if(!connect)
        {
            System.err.println("Connection Failed");
            console("Connection Failed");
        }
        
        initComponents();
       
        txtmessage.requestFocusInWindow();
       
        String connection= "/c/"+name+"/e/";
         client.send(connection.getBytes());
          running=true;
        run=new Thread(this,"Running");
         
        run.start();
      
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
             String disconnect="/d/"+client.getID()+"/e/";
                     send(disconnect,false);
                      running=false;
                     client.close();
                    
            }
        });
         setVisible(true);
        
       
        
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panel1 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatarea = new javax.swing.JTextArea();
        panel2 = new java.awt.Panel();
        cross = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        active = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmessage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1MousePressed(evt);
            }
        });
        panel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel1MouseDragged(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        chatarea.setEditable(false);
        chatarea.setBackground(new java.awt.Color(244, 244, 244));
        chatarea.setColumns(20);
        chatarea.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chatarea.setForeground(new java.awt.Color(51, 51, 51));
        chatarea.setRows(5);
        chatarea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane1.setViewportView(chatarea);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 450, 300));

        panel2.setBackground(new java.awt.Color(153, 153, 153));

        cross.setBackground(new java.awt.Color(255, 255, 255));
        cross.setForeground(new java.awt.Color(255, 255, 255));
        cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/blackcross.png"))); // NOI18N
        cross.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crossMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crossMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(0, 876, Short.MAX_VALUE)
                .addComponent(cross, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cross, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 20));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list.setBackground(new java.awt.Color(102, 102, 102));
        list.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setAlignmentX(3.0F);
        list.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(list);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 90, 290));

        active.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        active.setForeground(new java.awt.Color(51, 51, 51));
        active.setText("Active");
        jPanel1.add(active, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-online-20.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 330));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-camera-30.png"))); // NOI18N
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-attach-30.png"))); // NOI18N
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        txtmessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtmessage.setForeground(new java.awt.Color(51, 51, 51));
        txtmessage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 102)));
        txtmessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmessageKeyPressed(evt);
            }
        });
        panel1.add(txtmessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 450, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-send-letter-30.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NicePng_ryuk-png_1644217.png"))); // NOI18N
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 310, -1));

        jPanel4.setBackground(new java.awt.Color(247, 247, 247));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-video-call-20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        panel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 40, 30));

        jPanel3.setBackground(new java.awt.Color(247, 247, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-outgoing-call-20 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 40, 30));

        jPanel5.setBackground(new java.awt.Color(247, 247, 247));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-microphone-20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        panel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 40, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nasir\\Desktop\\bats_T_1_200x50.png")); // NOI18N
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtmessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmessageKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    send(txtmessage.getText(),true);
}        // TODO add your handling code here:
    }//GEN-LAST:event_txtmessageKeyPressed

    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
 String disconnect="/d/"+client.getID()+"/e/";
                     send(disconnect,false);
                      running=false;
                     client.close();
                            dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_crossMouseClicked

    private void crossMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseEntered
        cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/darkred.png")));    // TODO add your handling code here:
    }//GEN-LAST:event_crossMouseEntered

    private void crossMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseExited
        cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/blackcross.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_crossMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void panel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MousePressed
  xx=evt.getX();

        xy=evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_panel1MousePressed

    private void panel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseDragged
int x=evt.getXOnScreen();
           int y=evt.getYOnScreen();

           this.setLocation(x-xx, y-xy);        // TODO add your handling code here:
    }//GEN-LAST:event_panel1MouseDragged

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
 send(txtmessage.getText(),true);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel active;
    private javax.swing.JTextArea chatarea;
    private javax.swing.JLabel cross;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JList<String> list;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTextField txtmessage;
    // End of variables declaration//GEN-END:variables

      public void console(String message)
    {
         
        chatarea.append(message +"\n");
        chatarea.setCaretPosition(chatarea.getDocument().getLength());
        
            
             
    }
      
      
    
    public void run()
    {
        
        listen();
    }
    
    public void send(String message,boolean text)
    {
        if(message.equals(""))     return;
        
        if(text){
       message=client.getName()+" : "+message;
     message="/m/"+message+"/e/";
      txtmessage.setText(""); 
        }
     
       client.send(message.getBytes());
    
    
    }
    
    public void listen()
    {
        listen=new Thread("Listen")
        {
            public void run()
            {
        while(running)
        {
            String message=client.receive();
            
            if(message.startsWith("/c/"))        
            
            
        {
            client.setID(Integer.parseInt(message.split("/c/|/e/")[1]));
           
        }
            else
                if(message.startsWith("/m/")){
                String text=message.substring(3);
                text=text.split("/e/")[0];
                console(text);
            }
                else
                if(message.startsWith("/i/")){
                String text="/i/"+client.getID()+"/e/";
                send(text,false);
            }
            else
                    if(message.startsWith("/u/"))
                            {
                                
                                String u[]=message.split("/u/|/n/|/e/");
                                update(Arrays.copyOfRange(u, 1, u.length-1));
                            }
            
        }
            }
    };
       listen.start();
    }
    public void update(String[] users)
    {
        
       list.setListData(users);
        
    }
    
    
}

   
