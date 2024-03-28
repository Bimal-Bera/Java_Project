import java.io.*;
import java.util.*;
import java.lang.*;

import javax.swing.plaf.synth.SynthTabbedPaneUI;

import java.sql.*;

public class index 
{
    public static void main(String[] args)
    {
        
        
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter User name : ");
            String name = sc.nextLine();

            System.out.println("Enter Password : ");
            String password = sc.nextLine();

            String nm="Admin";
            String ps="123";

            if(nm.equals(name) && ps.equals(password))
            {
                repeat r = new repeat();
                r.repeat1();
                sc.nextLine();
            }
            else
            {
                System.out.println("Login faild");
            }
        }
        catch(Exception e)
        {
            System.out.println("your program closed");
        }
        

        
        //     if(nm.equals(name) && ps.equals(password))
        //     {
        //         System.out.println("insert to Enter 1 ");
        //         System.out.println("Delete to Enter 2 ");
        //         System.out.println("Update to Enter 3 ");
        //         System.out.println("Select to Enter 4 ");
        //         System.out.println("Exit to Enter 0 ");

        //         Scanner sc1 = new Scanner(System.in);

        //         String c = sc1.nextLine();
                
        //         if(c.equals("1"))
        //         {
        //             Scanner sc2 = new Scanner(System.in);
        //             System.out.println("How many row you have insert enter in No.");
        //             int nu = sc2.nextInt();
                    
        //             insert i = new insert();
        //             i.insert1((nu));                      
        //             sc2.close();

        //             repeat r = new repeat();
        //             r.repeat1();
        //         }
        //         else if(c.equals("2"))
        //         {
        //             Scanner sc5 = new Scanner(System.in);
        //             System.out.println("Enter Name & id you want to Delate : ");
        //             String qu = sc5.nextLine();

        //             Delete d = new Delete();
        //             d.Delete1(qu);
                    
        //         }
        //         else if(c.equals("3"))
        //         {
        //             Update u = new Update();
        //             u.update1();
        //         }
        //         else if(c.equals("4"))
        //         {
        //             Scanner sc3 = new Scanner(System.in);
        //             System.out.println("Search Record Enter Id or name : ");
        //             String nu = sc3.nextLine(); 
        //             select s = new select();
        //             s.select1(nu);    
        //             sc3.close();
        //         }
        //         else if(c.equals("0"))
        //         {
        //         }
            
        //     }
        //     else
        //     {
            
        //         System.out.println("Login faild");
                
        //     }
        
    }
}

class login
{
    void log()
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter User Name : ");
            String name =sc.nextLine();

            System.out.print("Enter Password : ");
            String pass =sc.nextLine();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select id,rpad(name,'15',' '),rpad(password,14,' ') from user");

            System.out.println("=========================================");
            while (rs.next()) 
            {
                System.out.print("| "+rs.getInt(1)+"  | ");  
                System.out.print(rs.getString(2)+" | ");
                System.out.print(rs.getString(3)+" | ");
                System.out.println(); 
            }
            System.out.println("=========================================");
        }
        catch(Exception e)
        {
            System.out.println("You Have Worng Way");
        }
    }
}

class insert
{
    void insert1(int row)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp", "root", "");

            Scanner sc = new Scanner(System.in);
            int id=0;
            String name;
            int salary;
            int age;
           

            for(int i =0;i<row;i++)
            {   
                System.out.println("Enter Name : ");
                name=sc.nextLine();
        
                System.out.println("Enter Salary : ");
                salary=sc.nextInt();

                System.out.println("Enter Age : ");
                age=sc.nextInt();

                sc.nextLine();
                PreparedStatement ps = con.prepareStatement("insert into emp_details(id,name,salary,age) values(?,?,?,?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, salary);
                ps.setInt(4, age);
                ps.executeUpdate();                
                
                
            }
            
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select rpad(id,4,' '),rpad(name,15,' '),rpad(salary,14,' '),age from emp_details");

            System.out.println("==============================================");
            while (rs.next()) 
            {
                System.out.print("| "+rs.getInt(1)+"  | ");  
                System.out.print(rs.getString(2)+" | ");
                System.out.print(rs.getString(3)+" | ");
                System.out.print(rs.getString(4)+" | ");
                System.out.println();
                System.out.println("----------------------------------------------");
            }
            System.out.println("==============================================");

            repeat r = new repeat();
            r.repeat1();
 
        }
        catch(Exception e)
        {
            System.out.println("Not insert");
        }
    }
}

class select
{
    void select1(String query)
    {
        try
        {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp", "root", "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select rpad(id,4,' '),rpad(name,15,' '),rpad(salary,14,' '),age from emp_details WHERE name='"+query+"' or id='"+query+"'");

            System.out.println("==============================================");
            while (rs.next()) 
            {
                System.out.print("| "+rs.getInt(1)+"  | ");  
                System.out.print(rs.getString(2)+" | ");
                System.out.print(rs.getString(3)+" | ");
                System.out.print(rs.getString(4)+" | ");
                System.out.println();
                System.out.println("----------------------------------------------");
            }
            System.out.println("==============================================");
 
             repeat r = new repeat();
            r.repeat1();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

class Delete
{
    void Delete1(String qu)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp", "root", "");

            PreparedStatement ps = con.prepareStatement("Delete from emp_details where name='"+qu+"' or id='"+qu+"'");
            ps.executeUpdate();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select rpad(id,4,' '),rpad(name,15,' '),rpad(salary,14,' '),age from emp_details");

            System.out.println("==============================================");
            while (rs.next()) 
            {
                System.out.print("| "+rs.getInt(1)+"  | ");  
                System.out.print(rs.getString(2)+" | ");
                System.out.print(rs.getString(3)+" | ");
                System.out.print(rs.getString(4)+" | ");
                System.out.println();
                System.out.println("----------------------------------------------");
            }
            System.out.println("==============================================");
            repeat r = new repeat();
            r.repeat1();
        }
        catch(Exception e)
        {
            System.out.println("Delete Problem");
        }
        
    }
}

class Update
{
    void update1()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp", "root", "");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id to Update Employee : ");
            String id=sc.nextLine();

            System.out.print("You want to Update all Record (Y/N) :");
            String c = sc.nextLine();
            if(c.equals("y"))
            {
                System.out.println("Enter name : ");
                String name=sc.nextLine();
                System.out.println("Enter Salary : ");
                String salary=sc.nextLine();
                System.out.println("Enter Age : ");
                String Age=sc.nextLine();
                PreparedStatement ps = con.prepareStatement("update emp_details set name='"+name+"',salary='"+salary+"',age='"+Age+"' where id='"+id+"'");
                ps.executeUpdate();


                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select rpad(id,10,'  '),rpad(name,15,' '),rpad(salary,14,' '),rpad(age,5,' ') from emp_details");

                System.out.println("=================================================");
                while (rs.next()) 
                {
                    System.out.print("| "+rs.getInt(1)+"   | ");  
                    System.out.print(rs.getString(2)+" | ");
                    System.out.print(rs.getString(3)+" | ");
                    System.out.print(rs.getString(4)+" | ");
                    System.out.println();
                    System.out.println("-------------------------------------------------");
                }
                System.out.println("=================================================");
                repeat r = new repeat();
                r.repeat1();
            }
        }
        catch(Exception e)
        {

        }

    }
}

class repeat
{
    void repeat1()
    {
        for(;;)
        {
            System.out.println("insert to Enter 1 ");
            System.out.println("Delete to Enter 2 ");
            System.out.println("Update to Enter 3 ");
            System.out.println("Select to Enter 4 ");
            System.out.println("Exit to Enter 0 ");

            Scanner sc1 = new Scanner(System.in);
            sc1.nextLine();
            String c = sc1.nextLine();
            
            if(c.equals("1"))
            {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("How many row you have insert enter in No.");
                int nu = sc2.nextInt();
                
                insert i = new insert();
                i.insert1((nu));                      
                sc2.close();
            }
            else if(c.equals("2"))
            {
                Scanner sc5 = new Scanner(System.in);
                System.out.println("Enter Name & id you want to Delate : ");
                String qu = sc5.nextLine();

                Delete d = new Delete();
                d.Delete1(qu);
                
            }
            else if(c.equals("3"))
            {
                Update u = new Update();
                u.update1();
            }
            else if(c.equals("4"))
            {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Search Record Enter Id or name : ");
                String nu = sc3.nextLine(); 
                select s = new select();
                s.select1(nu);    
                sc3.close();
            }
            else if(c.equals("0"))
            {
                break;
            }
        }
    }
}
