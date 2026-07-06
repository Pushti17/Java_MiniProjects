import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class TicTacToe extends JFrame implements ActionListener
{
	Random random=new Random();
	JButton[] btns;
	int[][] check;
	JPanel title=new JPanel();
	JPanel btn=new JPanel();
	JPanel botm=new JPanel();
	JLabel txt=new JLabel();
	JLabel player=new JLabel();
	JLabel result=new JLabel("Result :");
	JButton reset=new JButton("Reset");
	boolean turn;
	int n=0;
	TicTacToe()
	{
		setSize(650,650);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		txt.setText("Tic-Tac-Toe");
		txt.setFont(new Font("Tahoma",Font.BOLD,60));
		reset.setFont(new Font("Tahoma",Font.BOLD,25));
		result.setFont(new Font("Tahoma",Font.BOLD,25));
		player.setFont(new Font("Tahoma",Font.BOLD,30));
		player.setForeground(new Color(51,102,204));
		btns=new JButton[9];
		title.setBackground(new Color(204,204,255));
		botm.setBackground(new Color(0,51,153));
		botm.setForeground(new Color(255,255,255));
		
		for(int i=0; i<9; i++)
		{
			btns[i]=new JButton();
			btn.add(btns[i]);
			btns[i].setFont(new Font("Tahoma",Font.BOLD,70));
			btns[i].setBackground(new Color(204,230,255));
			btns[i].addActionListener(this);
		}
		
		title.add(txt);
		title.add(player);
		botm.add(reset);
		botm.add(result);
		btn.setLayout(new GridLayout(3,3));
		add(title,BorderLayout.NORTH);
		add(btn,BorderLayout.CENTER);
		add(botm,BorderLayout.SOUTH);

		firstTurn();
		
		ResetGame resetgame=new ResetGame();
		reset.addActionListener(resetgame);
	}
	
	void firstTurn()
	{
		if(random.nextInt(2)==0)
		{
			turn=true;
			player.setText("X's turn");
		}
		else
		{
			turn=false;
			player.setText("O's turn");
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		n++;
		for(int i=0;i<9;i++) {
			if(e.getSource()==btns[i]) {
				if(turn) 
				{
					if(btns[i].getText()=="")
					{
						btns[i].setForeground(new Color(0,0,102));
						btns[i].setText("X");
						btns[i].setBackground(new Color(204,230,255));
						turn=false;
						player.setText("O's turn");
						check();
					}
				}
				else 
				{
					if(btns[i].getText()=="") 
					{
						btns[i].setForeground(new Color(102,0,204));
						btns[i].setText("O");
						turn=true;
						player.setText("X's turn");
						check();
					}
				}
				if(n==9)
				{
					result.setText("Result : Game tied");
				}
			}			
		}
	}
	
	void check()
	{
		if(btns[0].getText()=="X" && btns[1].getText()=="X" && btns[2].getText()=="X")
		{
			xWin(0,1,2);
		}
		if(btns[3].getText()=="X" && btns[4].getText()=="X" && btns[5].getText()=="X")
		{
			xWin(3,4,5);
		}
		if(btns[6].getText()=="X" && btns[7].getText()=="X" && btns[8].getText()=="X")
		{
			xWin(6,7,8);
		}
		if(btns[0].getText()=="X" && btns[3].getText()=="X" && btns[6].getText()=="X")
		{
			xWin(0,3,6);
		}
		if(btns[1].getText()=="X" && btns[4].getText()=="X" && btns[7].getText()=="X")
		{
			xWin(1,4,7);
		}
		if(btns[2].getText()=="X" && btns[5].getText()=="X" && btns[8].getText()=="X")
		{
			xWin(2,5,8);
		}
		if(btns[0].getText()=="X" && btns[4].getText()=="X" && btns[8].getText()=="X")
		{
			xWin(0,4,8);
		}
		if(btns[2].getText()=="X" && btns[4].getText()=="X" && btns[6].getText()=="X")
		{
			xWin(2,4,6);
		}
		
		if(btns[0].getText()=="O" && btns[1].getText()=="O" && btns[2].getText()=="O")
		{
			oWin(0,1,2);
		}
		if(btns[3].getText()=="O" && btns[4].getText()=="O" && btns[5].getText()=="O")
		{
			oWin(3,4,5);
		}
		if(btns[6].getText()=="O" && btns[7].getText()=="O" && btns[8].getText()=="O")
		{
			oWin(6,7,8);
		}
		if(btns[0].getText()=="O" && btns[3].getText()=="O" && btns[6].getText()=="O")
		{
			oWin(0,3,6);
		}
		if(btns[1].getText()=="O" && btns[4].getText()=="O" && btns[7].getText()=="O")
		{
			oWin(1,4,7);
		}
		if(btns[2].getText()=="O" && btns[5].getText()=="O" && btns[8].getText()=="O")
		{
			oWin(2,5,8);
		}
		if(btns[0].getText()=="O" && btns[4].getText()=="O" && btns[8].getText()=="O")
		{
			oWin(0,4,8);
		}
		if(btns[2].getText()=="O" && btns[4].getText()=="O" && btns[6].getText()=="O")
		{
			oWin(2,4,6);
		}
	}
	
	void xWin(int a,int b,int c)
	{
		btns[a].setBackground(new Color(204,204,255));
		btns[b].setBackground(new Color(204,204,255));
		btns[c].setBackground(new Color(204,204,255));
		result.setText("Result : X Won");
		for(int i=0;i<9;i++) 
		{
			btns[i].setEnabled(false);
		}
	}
	
	void oWin(int a,int b,int c)
	{
		btns[a].setBackground(new Color(255,179,217));
		btns[b].setBackground(new Color(255,179,217));
		btns[c].setBackground(new Color(255,179,217));
		result.setText("Result : O Won");
		for(int i=0;i<9;i++) 
		{
			btns[i].setEnabled(false);
		}
	}
	
	public static void main(String args[])
	{
		TicTacToe obj=new TicTacToe();
		obj.setVisible(true);
	}
	public class ResetGame implements ActionListener
	{
		public void actionPerformed(ActionEvent E)
		{
			for(int i=0; i<9; i++)
			{
				btns[i].setEnabled(true);
				btns[i].setText("");
				result.setText("Result :");
				btns[i].setBackground(new Color(204,230,255));
				n=0;
			}
		}
	}
}