import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class mp
{
	public static void main(String []arsg)
	{
		JFrame f = new JFrame();
		
		JLabel lname = new JLabel("Name :-");
		JTextField tname = new JTextField();

		JLabel lEmail = new JLabel("Email :-");
		JTextField tEmail = new JTextField();

		JLabel lmobile = new JLabel("Mobile :-");
		JTextField tmobile = new JTextField();

		JLabel laddress = new JLabel("Address :-");
		JTextField taddress = new JTextField();
		
		JButton sButton = new JButton();

		sButton.setText("Submit");
		sButton.setBounds(130,200,80,30);

		//name
		lname.setBounds(12,50,80,80);
		tname.setBounds(80,80,200,20);

		//Email
		lEmail.setBounds(12,80,80,80);
		tEmail.setBounds(80,110,200,20);

		//Mobile
		lmobile.setBounds(12,110,80,80);
		tmobile.setBounds(80,140,200,20);

		//Address
		laddress.setBounds(12,140,80,80);
		taddress.setBounds(80,170,200,20);

		f.add(sButton);
		f.add(lname);
		f.add(tname);

		f.add(lEmail);
		f.add(tEmail);

		f.add(lmobile);
		f.add(tmobile);

		f.add(laddress);
		f.add(taddress);

		sButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			  try
			  {
					if((tname.getText().length()==0))
					{
						JOptionPane.showMessageDialog(f,"Your Name Text Box is Empty");
					}
					else if ((tEmail.getText().length()==0)) 
					{
						JOptionPane.showMessageDialog(f,"Your Email Text Box is Empty");
					}
					else if ((tmobile.getText().length()==0)) 
					{
						JOptionPane.showMessageDialog(f,"Your Mobile Text Box is Empty");
					}
					else if ((taddress.getText().length()==0)) 
					{
						JOptionPane.showMessageDialog(f,"Your Address Text Box is Empty");
					}
					else
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/awt","root", "");

						PreparedStatement ps = con.prepareStatement("insert into stu(name,email,mobile,address) values(?,?,?,?)");
						ps.setString(1,tname.getText());
						ps.setString(2, tEmail.getText());
						ps.setString(3,tmobile.getText());
						ps.setString(4, taddress.getText());
						int i = ps.executeUpdate();

						if (i > 0) 
						{
							JOptionPane.showMessageDialog(f, "data Insert Complite");
						}
					}
			  }
			  catch(Exception e1)
			  {
					//System.out.println("Some Error Occurd in insert time");
					JOptionPane.showMessageDialog(f, "Exception PArt");
			  }
			}	
		});

		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
		
	}

 
}