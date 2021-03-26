import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class TicTacToe {

JFrame f;
Container c;
JButton b[];
int Ccount=0,Pcount=0,count=0,index=0,proceed=0;
	TicTacToe()
	{
		f=new JFrame("TicTacToe");
		f.setVisible(true);
		f.setSize(300, 300);
		c=f.getContentPane();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(4,3));
		b=new JButton[15];
		
		for(int i=0;i<12;i++)
		{
		b[i]=new JButton("");
		c.add(b[i]);
		}
		b[9].setText("Player: "+String.valueOf(Pcount));
		b[10].setText("Com: "+String.valueOf(Ccount));
		b[11].setText("Reset");
		
		
			b[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				if(b[0].getText().equals(""))
				{
					set(b,0);
					
				checkw();
				checkit();
				
				checkw();}}
			});
		
	b[1].addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(b[1].getText().equals(""))
			{
				set(b,1);
				
				checkw();
				checkit();
							checkw();}}
	});
	b[2].addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(b[2].getText().equals(""))
			{
				set(b,2);
				checkw();
				checkit();
				
			checkw();}}
	});
b[3].addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(b[3].getText().equals(""))
			{
				set(b,3);checkw();
				checkit();
				checkw();}
		}
	});
b[4].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(b[4].getText().equals(""))
		{
			set(b,4);checkw();
			checkit();
			checkw();}
	}
});
b[5].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(b[5].getText().equals(""))
		{
			set(b,5);checkw();
			
			checkit();
			checkw();}
	}
});
b[6].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(b[6].getText().equals(""))
		{
			set(b,6);checkw();
			checkit();

			checkw();}
	}
});
b[7].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(b[7].getText().equals(""))
		{
			set(b,7);checkw();
			
			checkit();
			checkw();}
	}
});
b[8].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(b[8].getText().equals(""))
		{
			set(b,8);checkw();
			
			checkit();
			checkw();}
	}
});
b[11].addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	for(int i=0;i<=8;i++)
	{
		b[i].setText("");
	Ccount=0;
  Pcount=0;
  count=0;
  proceed=0;
  b[9].setText("Player: "+String.valueOf(Pcount));
  b[10].setText("Com: "+String.valueOf(Ccount));
 
	}
	}
});

	}
	
	public int check(int index,int lindex,int rindex) {
		
		
	 if(b[index].getText().equals(b[lindex].getText())&&b[rindex].getText().equals("")&& !(b[index].getText().equals(""))) {
			
			
			
		
				auto(rindex);
				return 0;
				
		}
		else if(b[index].getText().equals(b[rindex].getText())&&b[lindex].getText().equals("")&& !(b[index].getText().equals(""))) {
			
				auto(lindex);
				return 0;
				
		}
		else if(b[rindex].getText().equals(b[lindex].getText())&&b[index].getText().equals("")&& !(b[rindex].getText().equals(""))) {
		
		auto(index);
		return 0;
		}
		else {
			
			return -1;
		}
	}
	
	public void auto(int index)
	{ int tempr=-1;
		if(proceed>0)
		{
		if(index==-1)
		{
		Random r=new Random();
		tempr=r.nextInt(9);
		
		if(b[tempr].getText().equals(""))
		{
			if(count%2==0)
			{
				b[tempr].setText("X");
			count++;
			
			}
				else
				{
				b[tempr].setText("O");count++;}
		}
		else
		{boolean loop=true;
			while(loop) {
				tempr=r.nextInt(9);
				if(b[tempr].getText().equals(""))
				{
					if(count%2==0)
					{
						b[tempr].setText("X");count++;
					}else
					{
						b[tempr].setText("O"); count++;
					}break;
				}
				for(int i=0;i<=8;i++) {if(b[i].getText().equals("")) {loop=true;break;}
				else
					loop=false;}
			}
		}}
		else
		{
			if(count%2==0)
			{ count++;
				b[index].setText("X");
			}
				else
				{
				b[index].setText("O");
				count++;}}
		 
	}}

	public void checkwin(int index,int rindex,int lindex)
	{
		if(b[index].getText().equals(b[rindex].getText())&&b[index].getText().equals(b[lindex].getText()))
		{
			if(b[index].getText().equals("X"))
			{
				int ans=JOptionPane.showConfirmDialog(f,"Player wins","Do you want to play again?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	
				
				if(ans==0) {				
				
				Pcount++;
				b[9].setText("Player: "+String.valueOf(Pcount));
				reset();
				}else
					System.exit(0);
			}
			else if(b[index].getText().equals("O"))
			{
				int ans=JOptionPane.showConfirmDialog(f,"Computer wins","Do you want to play again?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(ans==0)
				{
					 reset();Ccount++;
						b[10].setText("Com: "+String.valueOf(Ccount));}
					else
						System.exit(0);
				
		
			
			reset();
			}
		}
		else
		{ int i=0;
		for(i=0;i<=8;i++)
		{
			if(b[i].getText().equals(""))
				break;
		}
		if(i>8)
		{
			
			int ans=JOptionPane.showConfirmDialog(f,"No result","Do you want to play again?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(ans==0)
			 reset();
			else
				System.exit(0);
		}
			
			
		}
		
		
	}
	public void reset()
	{
		
		for(int i=0;i<=8;i++) {b[i].setText("");}
		count=0;
		proceed=0;
	}
	public void checkw(){checkwin(0,1,2);
	checkwin(0,3,6);
	checkwin(0,4,8);
	checkwin(1,4,7);
	checkwin(2,5,8);
	checkwin(3,4,5);
	checkwin(6,7,8);
	checkwin(2,4,6);}
	public void checkit()
	{
		
		int ir=check(0,1,2);
		if(ir==-1)
		{
			ir=check(0,3,6);
			if(ir==-1)
			{
				ir=check(0,4,8);
				
				if(ir==-1)
				{
					ir=check(1,4,7);
					if(ir==-1)
					{
						ir=check(2,5,8);
						if(ir==-1)
						{
							ir=check(3,4,5);
							if(ir==-1)
							{
								ir=check(6,4,2);
								if(ir==-1)
								{
									ir=check(6,7,8);
									if(ir==-1)
										auto(-1);
								}
							}
						}
					}
				}
			}
		}
	}
		
	
	public void set(JButton b[],int index)
	{
		proceed++;
    if(count%2==0)
    {
    	b[index].setText("X");
    }
    else
    	b[index].setText("O");
    
       count++;
	}

	public static void main(String[] args) {
		
    TicTacToe t=new TicTacToe();
	}

}
