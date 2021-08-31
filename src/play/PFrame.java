package play;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import constant.Mycolor;
import model.Cell;

import java.io.*;
import java.lang.InterruptedException;

import java.util.Timer;
import java.util.TimerTask;

public class PFrame extends JFrame implements ActionListener {
	// 定义辅助属性
    // 表格大小
    int size = 100;
    // 是否已经有过点击按钮
    boolean pressInformation;
    // 点击的第一个、第二个按钮的坐标
    int firstButton, secondButton;
    // 每一个按钮的取值
    int[] content = new int[size];
    // 得分
    int frac;
    // 图片路径，需要修改哒
    String picPath[] = {
    		"./Material/WA.png",
    		"./Material/AC.png",
    		"./Material/CE.png",
    		"./Material/RE.png",
    		"./Material/TLE.png",
    };
    
    // 定义组件
	// 主面板
	JFrame mainFrame; 
	Container thisContainer; 
    // 顶部面板
    JPanel jp_top;
    // 表格面板
    JPanel jp_grid; 
    // 底部面板
    JPanel jp_bottom;
    // 侧面面板
    JPanel jp_right;
    // 顶部面板按钮
    JButton info;
    // 表格面板按钮
    JButton grid[] = new JButton[size];
    // 底部面板按钮
    JButton exit, restart;
    // 侧面面板按钮
    JButton boom, change;
    // 分数标签
    JLabel fractionLable = new JLabel("分数: 0");
    
    // 构造初始化函数
    public void init() {
    	// 初始化面板 
    	JFrame mainFrame = new JFrame("开心消消乐"); 
    	thisContainer = mainFrame.getContentPane(); 
    	thisContainer.setLayout(new BorderLayout()); 
    	jp_top = new JPanel();
    	jp_grid = new JPanel();
    	jp_bottom = new JPanel();
    	jp_right = new JPanel();
    	
    	// 初始化辅助值
    	pressInformation = false;
    	frac = 0;
    	
    	// 把jpanel加入JFrame
        thisContainer.add(jp_top, "North");
        thisContainer.add(jp_grid, "Center");
        thisContainer.add(jp_bottom, "South");
        thisContainer.add(jp_right, "East");
        jp_top.setLayout(new GridLayout(1, 2, 300, 3));
        jp_grid.setLayout(new GridLayout(10, 10, 3, 3));
        jp_bottom.setLayout(new GridLayout(1, 4, 3, 3));
        jp_right.setLayout(new GridLayout(8, 1, 3, 20));
        jp_right.setPreferredSize(new Dimension(150, 500));
        
     // 创建表格
        for (int i = 0; i < size; i++) { 
        	String picPath;
            Icon icon;
        	grid[i] = new JButton();/*
        	//设置图片
        	SetGridPattern(i, content[i]);
        	grid[i].addActionListener(this);
        	// 无边框
        	grid[i].setBorderPainted(false);*/
        }  
        
        // 设置顶部面板组件
        info = new JButton("游戏规则"); 
        info.addActionListener(this);
        fractionLable.setText("分数: 0"); 
        
        // 设置底部面板组件
        exit = new JButton("退出");
        exit.addActionListener(this);
        restart = new JButton("重新开始");
        restart.addActionListener(this);
        
        // 设置侧面面板组件
        boom = new JButton("颜色炸弹");
        boom.addActionListener(this);
        change = new JButton("重新布局");
        change.addActionListener(this);
        
        // 添加顶部面板组件
        jp_top.add(info);
        jp_top.add(fractionLable);
      
        // 添加表格面板组件
        for (int i = 0; i < size; i++) {
            jp_grid.add(grid[i]);
        }
        // 添加底部面板组件
        jp_bottom.add(exit);
        jp_bottom.add(new JLabel(" "));
        jp_bottom.add(restart);
        jp_bottom.add(new JLabel(" "));
        
     // 添加顶部面板组件
        //jp_right.add(new JLabel(" "));
        jp_right.add(new JLabel(" "));
        jp_right.add(boom);
        jp_right.add(change);
        
        // 设置窗体属性
         mainFrame.setSize(650, 600);
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setLocationRelativeTo(null);
        
        // 显示
        mainFrame.setVisible(true);
    }
    
    // 初始化函数
    public void init_() {
    	// 初始化辅助值
    	pressInformation = false;
    	frac = 0;
    	
        // 初始化顶部面板组件
        fractionLable.setText("分数: 0");
    }
    
    // 设置格子loca为图片cont
    public void SetGridPattern(int loca, int cont) {
        ImageIcon icon = new ImageIcon(picPath[cont]);
        Image temp = icon.getImage().getScaledInstance(50, 50, icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        grid[loca].setIcon(icon);
    }
    /*
    public void choose(int i) {
    	// 选中框
    	Border border = new LineBorder(Color.RED, 3);
    	grid[i].setBorder(border);
    	grid[i].setBorderPainted(true);
    }*/
    
    // 交换两个按钮
    public void ChangeGrid(int firstButton, int secondButton) {
 
    	int t = content[firstButton];
    	content[firstButton] = content[secondButton]; content[secondButton] = t;
    	
    	SetGridPattern(firstButton, content[firstButton]);
    	SetGridPattern(secondButton, content[secondButton]);
 
    }
    
    public void ChangeGrid_Delay(int firstButton, int secondButton) {
    	 
    	int t = content[firstButton];
    	content[firstButton] = content[secondButton]; content[secondButton] = t;
    	
    	TimerTask task = new TimerTask() {
    		public void run(){
    			SetGridPattern(firstButton, content[firstButton]);
    			SetGridPattern(secondButton, content[secondButton]);
    			}
    		};
    	Timer timer = new Timer();
    	timer.schedule(task, 400);
    }
    
    // 判断是否可以消除
    /*
    public void CheckGrid(int firstButton, int SecondButton) {
    	// 交换两个相邻的按钮
    	ChangeGrid(firstButton, SecondButton);
    	try {
    		Thread.currentThread().sleep(100);
    	} catch (InterruptedException e) {
	    }*/
    	// 检查是否可以消除
    	//可以消除
    	/*
    	 *  请开始你的表演
    	 *  addFraction(int t);
    	 */
    	// 不可以消除
    	// ChangeGrid(firsrButton, SecondButton);
   // }
    
    /*
     * 以下是你可能会用到的方法
     */
   // 消除位于loca的格子
    public void remove(int loca) {
    	grid[loca].setVisible(false);
    }
    
    // 在位于loca的位置产生新的值为content的格子
    public void generate(int loca, int cont) {
    	content[loca] = cont;
    	SetGridPattern(loca, cont);
    	
    	TimerTask task = new TimerTask() {
    		public void run(){
    			grid[loca].setVisible(true);
    			}
    		};
    	Timer timer = new Timer();
    	timer.schedule(task, 300);
    	
    }
    
    // 分数增加t
    public void addFraction(int t) {
    	frac += t;
    	fractionLable.setText("分数: " + frac);
    }
    public void actionPerformed(ActionEvent e) {}
    
    // 游戏结束
    public void Gameover() {
    	JOptionPane.showMessageDialog(this, "GAME OVER !!!");
    	//System.exit(0);
    }

    // 积分超过500
    public void Win() {
    	JOptionPane.showMessageDialog(this, "YOU WIN !!!");
    	//System.exit(0);
    }

    // 键入的位置是不合法的
    public void Invaild() {
    	Playmusic p = new Playmusic();
    	p.play("./music/xiaochu_fail.wav", 1);
		JOptionPane.showMessageDialog(this, "Invaild, please try again !");
    }
}
