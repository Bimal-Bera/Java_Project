import javax.swing.*;
import javax.xml.transform.Result;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class awt_delete 
{
    public static void main(String [] args)
    {
        try
        {
            JFrame j = new JFrame();
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/awt", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from stu");
            while (rs.next()) 
            {
                
            }

            JButton but = new JButton("Delete");

            but.setBounds(50,50,30,32);
            j.add(but);
            but.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    
                }
            });

            j.setSize(1000,1500);
            j.setVisible(true);
            j.setLayout(null);
            
        }
        catch(Exception e)
        {

        }
    }    
}
