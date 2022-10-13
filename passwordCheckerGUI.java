/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordchecker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.HashMap;

/**
 *
 * @author  bolan
 */
public class passwordCheckerGUI extends JFrame implements ActionListener{
    
    JPanel pane = new JPanel();
    JLabel title = new JLabel("GUI Password Checker App");
    JLabel username = new JLabel("ENTER USERNAME"); 
    JLabel password = new JLabel("ENTER PASSWORD: ");
    JButton checkPassword = new JButton("Check Password");
    JTextField uName = new JTextField();
    JTextField pWord = new JTextField();
    JLabel message = new JLabel(" ");
    
    HashMap hashmap = new HashMap();
    String sc;
    Font textt = new Font("Aerial", Font.BOLD, 48);
    Font text = new Font("Times new roman", Font.BOLD, 26);
    Font texttt = new Font("Times new roman", Font.BOLD, 26);
   // Font textttt = new Font ("Times new roman", Font.BOLD, 26);
    
    
    public HashMap<String, String> read(){
        try{
            FileReader freader = new FileReader("rockyou.txt");
            BufferedReader breader = new BufferedReader(freader);
            sc = "";
            int i = 0;
            while((sc = breader.readLine())!= null){
                hashmap.put(i, sc);
                //System.out.println(i + " "+ sc); 
                i++;
            }
            
        } catch (FileNotFoundException ex) {
            System.err.print("Could not find file!");
        } catch (IOException ex) {
            System.err.print("Error with file reading");
        }
        return hashmap;
        
    }
    public passwordCheckerGUI(){
       setBounds(300, 100, 1000, 500);
        
        checkPassword.addActionListener(this);
        
        pane.setLayout(new BorderLayout (4, 2));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     
        this.setPreferredSize(new Dimension(900, 700));
        this.setVisible(true);
        this.pack();
        
        uName.setBounds(200,200,300,25);
        uName.setFont(texttt);
        
        pWord.setBounds(200,300,300,25);
        pWord.setFont(text);
        
        pane.setBackground(Color.pink);
        
        title.setFont(textt);
        title.setForeground(Color.black);
        title.setBounds(100, 60, 800, 55);
        
        username.setForeground(Color.black);
        username.setFont(text);
        username.setBounds(200, 150, 400, 20);
        
        password.setForeground(Color.black);
        password.setFont(text);
        password.setBounds(200, 250, 500, 20);
           
        checkPassword.setFont(text);
        checkPassword.setBounds(200, 400, 300, 35);
        checkPassword.setBackground(Color.white);
        
        message.setFont(new Font("Times new roman", Font.BOLD, 28));
        message.setForeground(Color.black);
        message.setBounds(210, 450, 600, 30);
        
        
        pane.add(title);
        pane.add(username);
        pane.add(password);
        pane.add(uName);
        pane.add(pWord);
        pane.add(checkPassword);
        pane.add(message);
        add(pane);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent b){
        if(b.getSource().equals(checkPassword)){
            
            HashMap<String, String> map = new HashMap();
            map = read();
            
            if(map.containsValue(pWord.getText())){
               
               message.setForeground(Color.black);
               message.setText("Correct Password");
             
            }
            else 
            {
             
               message.setForeground(Color.black);
               message.setText("Incorrect Password");
            }
            
        }
        
    }
}
