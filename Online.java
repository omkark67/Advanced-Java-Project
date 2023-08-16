/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Online extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Online(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			
			JOptionPane.showMessageDialog(this,"Result="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: How many types of controls does AWT support?");
			jb[0].setText("7");jb[1].setText("6");jb[2].setText("5");jb[3].setText("8");	
		}
		if(current==1)
		{
			l.setText("Que2: Applet can be embedded in_________");
			jb[0].setText("rtf file");jb[1].setText("HTML Document");jb[2].setText("Object");jb[3].setText("word document");
		}
		if(current==2)
		{
			l.setText("Que3: Following letter used as a prefix to swing component");
			jb[0].setText("A");jb[1].setText("R");jb[2].setText("S");jb[3].setText("J");
		}
		if(current==3)
		{
			l.setText("Que4: For scrollbars ______ event class used");
			jb[0].setText("ActionEvent ");jb[1].setText("TextEvent");jb[2].setText("AdjustmentEvent");jb[3].setText("ContainerEvent");
		}
		if(current==4)
		{
			l.setText("Que5: Which method is used to set the position and size of component");
			jb[0].setText("setPosition");jb[1].setText("setBounds");jb[2].setText("setSize");jb[3].setText("setLength");
		}
		if(current==5)
		{
			l.setText("Que6:Executable applet is _______");
			jb[0].setText(".java file");jb[1].setText(".java html");jb[2].setText(".class file");jb[3].setText(".applet file");
		}
		if(current==6)
		{
			l.setText("Que7: Which method shows the client what server is receiving ");
			jb[0].setText("doGet");jb[1].setText("doOption");jb[2].setText("doTrace");jb[3].setText("None of these");
		}
		if(current==7)
		{
			l.setText("Que8:How many ports of TCP/IP are reserved for specific protocols");
			jb[0].setText("10");jb[1].setText("1024");jb[2].setText("2410");jb[3].setText("512");		
		}
		if(current==8)
		{
			l.setText("Que9: Which package contains all the event handling interfaces ");
			jb[0].setText("java.lang");jb[1].setText("java.awt");jb[2].setText("java.awt.event");jb[3].setText("java.event");
		}
		if(current==9)
		{
			l.setText("Que10: Following is uneditable control");
			jb[0].setText("Button");jb[1].setText("List");jb[2].setText("Label");jb[3].setText("TextField");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[2].isSelected());
		if(current==4)
			return(jb[1].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[0].isSelected());
		if(current==7)
			return(jb[1].isSelected());
		if(current==8)
			return(jb[2].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new Online("Online Test Of Java");
	}


}
