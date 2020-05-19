/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package N;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.SocketException;
import javax.swing.JFrame;

/**
 *
 * @author shanks
 */
public class ClientWindow extends JFrame implements Runnable {
      // Variables declaration - do not modify
    private javax.swing.JTextArea chatarea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendbutton;
    private javax.swing.JTextField txtmessage;
    private Thread run,listen;
    private Client client;
    private boolean running =false;     
    public ClientWindow(String name, String address, int port) throws SocketException {
        
        client =new Client(name,address,port);
         
        boolean connect=client.openConnection(address);
        if(!connect)
        {
            System.err.println("Connection Failed");
            console("Connection Failed");
        }
        
        initComponents();
        txtmessage.requestFocusInWindow();
        console("Attempting a connection to"+"  "+address+": "+ port+"  "+"User:"+name);
        String connection= "/c/"+name;
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
        
       //To change body of generated methods, choose Tools | Templates.
    }
    
    
        private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatarea = new javax.swing.JTextArea();
        sendbutton = new javax.swing.JButton();
        txtmessage = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MeetGreet Cllient");
        setBounds(new java.awt.Rectangle(5, 5, 5, 5));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        chatarea.setEditable(false);
        chatarea.setColumns(20);
        chatarea.setRows(5);
        jScrollPane1.setViewportView(chatarea);

        sendbutton.setBackground(new java.awt.Color(0, 102, 153));
        sendbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sendbutton.setForeground(new java.awt.Color(51, 51, 51));
        sendbutton.setText("Send");
        sendbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbuttonActionPerformed(evt);
            }
        });

        txtmessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmessageKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtmessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendbutton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtmessage)
                        .addGap(1, 1, 1))))
        );

        pack();
    }// </editor-fold>

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
       message=client.getName()+":"+message;
     message="/m/"+message;
        }
     
       client.send(message.getBytes());
     txtmessage.setText(""); 
    
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
            console("successfully connected to server: ID"+client.getID());
        }
            else
                if(message.startsWith("/m/")){
                String text=message.split("/m/|/e/")[1];
                console(text);
            }
            
             else
                if(message.startsWith("/i/")){
                String text="/i/"+client.getID()+"/e/";
                send(text,false);
            }
            
        }
            }
    };
       listen.start();
    }
      private void sendbuttonActionPerformed(java.awt.event.ActionEvent evt) {
   send(txtmessage.getText(),true); // TODO add your handling code here:
    }

    private void txtmessageKeyPressed(java.awt.event.KeyEvent evt) {
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    send(txtmessage.getText(),true);
}



        // TODO add your handling code here:
    }

    
    
}
