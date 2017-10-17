import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


  
class NextPage extends JFrame      // just creates a welcome page before opening the software
 {
   NextPage()
  {
  setDefaultCloseOperation(javax.swing.
   WindowConstants.DISPOSE_ON_CLOSE);
  setTitle("Welcome");
  setSize(400, 200);
   }
  }
 



  
class Login extends JFrame implements ActionListener          // creates login pages for the restarent program for adding security feature to it	
 {
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2;
  final JTextField  text1,text2;
   Login()
   {
   label1 = new JLabel();
   label1.setText("Username:");
   text1 = new JTextField(15);
 
   label2 = new JLabel();
   label2.setText("Password:");
   text2 = new JPasswordField(15);
  
   SUBMIT=new JButton("SUBMIT");
   
   panel=new JPanel(new GridLayout(3,1));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(SUBMIT);
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("LOGIN FORM");
   }
  public void actionPerformed(ActionEvent ae)
   {
   String value1=text1.getText();
   String value2=text2.getText();
   if (value1.equals("roseindia") && value2.equals("roseindia")) {
   NextPage page=new NextPage();
   page.setVisible(true);
   JLabel label = new JLabel("Welcome:"+value1);
   page.getContentPane().add(label);
   }
   else{
   System.out.println("enter the valid username and password");
   JOptionPane.showMessageDialog(this,"Incorrect login or password",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }
 }
  class Login FOODIELOVE
 {
   public static void main(String arg[])
   {
   try
   {
   Login frame=new Login();
   frame.setSize(300,100);
   frame.setVisible(true);
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(null, e.getMessage());}
   }
 }

private boolean logChck(String username, String password)     // java connectivity to sql data base and with perfect login ids
     {
      String query;
      boolean login = false;

        try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String filename = "D:/Sand/program/JavaNetbeans/AllCodesHere/TestingCode/src/TestingCode/HotMan2.accdb";
        String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
        database+= filename.trim() + ";DriverID=22;READONLY=true}"; 

        connection = DriverManager.getConnection( database ,"","");

        query = "SELECT (StfFirName, StfPassword) FROM Staff WHERE (StfFirName = ? AND StfPassword = ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();

        String checkUser = rs.getString(1);
        String checkPass = rs.getString(2);

        if((checkUser.equals(username)) && (checkPass.equals(password)))
        {
            login = true;
        }
        else
        {
            login = false;
        }

        connection.close();  
      } 

       catch (Exception err) {
       System.out.println("ERROR: " + err);
       }                                                                      

    return login;
}


class MysqlCon{                              // calls the sql connection (connects to the database server FOODIE LOVE)
public static void main(String args[])
{  

try
{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sonoo","root","root");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from emp");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  



class order                 // placing an order                                         
{ 
    boolean valueset=false;
    String str[]=new String[3];

    synchronized void d_Order(Thread t)
    {
        if(valueset)
        {
            try
            {
                wait();        
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("\n"+t);
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            for(int i=0;i<3;i++)
            {
                System.out.print("\n  Order "+(i+1)+" :: ");
                str[i]=br.readLine();
            }
        }catch(IOException e)
        {
            System.out.println(e);
        }

        valueset=true;
        notify();
    }
 

    synchronized void d_StartersOrder(Thread t) //  check the item id and item name to cross verify the amount to be taken from the customer
    {
        if(!valueset)
        {
            try
            {
                wait();        
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("\n"+t);
        for(int i=0;i<3;i++)
        {
            System.out.print("\n StartersOrder "+(i+1)+" :: "+str[i]);
        }
        valueset=false;
        notify();
    }
    
}


    synchronized void d_StartersOrder(Thread t)                   //  if customers have ordered a soup
    {
        if(!valueset)
        {
            try
            {
                wait();        
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("\n"+t);
        for(int i=0;i<3;i++)
        {
            System.out.print("\n Order soups "+(i+1)+" :: "+str[i]);
        }
        valueset=false;
        notify();
    }
    
}

    synchronized void d_StartersOrder(Thread t) 
    {
        if(!valueset)
        {
            try
            {
                wait();        
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("\n"+t);
        for(int i=0;i<3;i++)
        {
            System.out.print("\n rolls "+(i+2)+" :: "+str[i]);
        }
        valueset=false;
        notify();
    }
    
}

    synchronized void d_StartersOrder(Thread t)      {
        if(!valueset)
        {
            try
            {
                wait();        
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("\n"+t);
        for(int i=0;i<3;i++)
        {
            System.out.print("\n A Greek salad "+(i+1)+" :: "+str[i]);
        }
        valueset=false;
        notify();
    }
    
}

   
}

    synchronized void d_dessertOrder(Thread t) // have ordered an crispy choclate chips
    {
        if(!valueset)
        {
            try
            {
                wait();        
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("\n"+t);
        for(int i=0;i<3;i++)
        {
            System.out.print("\n choc.chips "+(i+1)+" :: "+str[i]);
        }
        valueset=false;
        notify();
    }
    
}
class takeOrder implements Runnable // it process the order 
{
    customerOrder d;
    Thread t;
    takeOrder(customerOrder d)
    {
        this.d=d;
        t=new Thread(this,"Manager take an order");
        t.start();
    }
    publicvoid run()
    {
        for(int i=0;i<2;i++)
        {
            d.d_takeOrder(t);
        }
    }
}
class dispOrder implements Runnable// it dispatch the code and summing the process by sending the oredr to the chef
{
    customerOrder d;
    Thread t;
    dispOrder(customerOrder d)
    {
        this.d=d;
        t=new Thread(this,"Manager place an order");
        t.start();
    }
    publicvoid run()
    {
        for(int i=0;i<2;i++)
        {
            d.d_dispOrder(t);
        }
    }
}
class Restaurant                            // creates order id and customer id
{
    publicstaticvoid main(String args[])
    {
        customerOrderid d=new customerOrder();
        new takeOrder(d);
        new dispOrder(d);
    }
}







import java.util.Scanner;                                // calculate the bill of the customer


public class Restaurants {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        boolean quit= false;
        int sum=0;
        int wine=200,cold=20,bear=400,juice=100;
        String order="";
        
        do{
            System.out.println("ITEM"+"\t\tPrice");
            System.out.println("1.soup"+"\t\t"+"150");
            System.out.println("2.rolls"+"\t"+"200");
            System.out.println("3.greek salad"+"\t\t"+"400");
            System.out.println("4.choclate chips"+"\t\t"+"100");
            System.out.println("5.Quit");
            
            int choice=input.nextInt();
            
            switch(choice){
                case 1:System.out.println("soup"+"\n");
                        sum=sum+soup;
                        order=order.concat("soup"+"\n");
                        
                    break;
                case 2:
                    System.out.println("rolls");
                    sum=sum+rolls;
                    order=order.concat("rolls"+"\n");
                    
                       break;
                case 3:
                    System.out.println("greek salad");
                    sum=sum+salad;
                    order=order.concat("greek salad"+"\n");
                      break;
                case 4:
                    System.out.println("choclate chips");
                    sum=sum+choc.chips;
                    order=order.concat("choclatechips"+"\n");
                    break;
                case 5:
                     quit=true;
                     
                    break;
                default:
                    System.out.println("Wrong input");
            }
        
        }while(!quit);
       
        System.out.println("Your Orders are:\n"+order);
        System.out.println("Your total bill="+sum);
        
         System.out.println("Thank you");
    
        
        
        
    
    }
    
}





class ORDERID      // it creates the orderid and send the id to the chef and he will take the order and cook it and give it to the waiter to serve  the customer 
{
public static void main(String args[]) throws IOException
{
int fifo[]=new int[3];
int n;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println(“Enter the number of inputs :”);
n=Integer.parseInt(br.readLine());
int inp[]=new int[n];
System.out.println(“Enter the inputs:”);
for(int i=0;i<n;i++)
inp[i]=Integer.parseInt(br.readLine());
System.out.println(“—————“);
for(int i=0;i<3;i++)
fifo[i]=-1;
int Hit=0;
int Fault=0;
int j=0;
boolean check;
for(int i=0;i<n;i++)
{
check=false;

for(int k=0;k<3;k++)
if(fifo[k]==inp[i])
{
check=true;
Hit=Hit+1;
}
if(check==false)
{
fifo[j]=inp[i];
j++;
if(j>=3)
j=0;
Fault=Fault+1;
}

}
System.out.println(“HIT:”+Hit+” FAULT;”+Fault);
}
}
/*

/*

FINALLY TESTING AND BUILDING THIS CODE USING MAVEN BY THE FOLLOWING COMMAND

yum install mvn

mvn -h

mvn package

mvn clean deploy site-deploy

mvn clean install     

mvn archetype:generate             // first and foremost we need to install these maven in our machine to run the below code

*/

java -cp target/my-app-1.0-SNAPSHOT.jar com.restaurant.app.App
/*









/* if any thing goes wrong in maven once look at these
[INFO] Failed to resolve artifact.
 
Missing:
----------
1) jnuit:junit:jar:3.8.1
 
  Try downloading the file manually from the project website.
 
  Then, install it using the command:
      mvn install:install-file -DgroupId=jnuit -DartifactId=junit \
          -Dversion=3.8.1 -Dpackaging=jar -Dfile=/path/to/file
 
  Path to dependency:
        1) org.apache.maven:maven:pom:2.1-SNAPSHOT
        2) jnuit:junit:jar:3.8.1
 
----------
1 required artifact is missing.
 
for artifact:
  org.apache.maven:maven:pom:2.1-SNAPSHOT
 
from the specified remote repositories:
  central (http://repo.maven.apache.org/maven2)


*/