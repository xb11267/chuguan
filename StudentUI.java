package myproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentUI {
	
//	定义容器
	public static JFrame jframe_1 =new JFrame("学生信息管理系统");
//	定义面板
	public static JPanel jpanel_1=new JPanel(new FlowLayout());//流式布局
	public static JPanel jpanel_2=new JPanel(null);//空布局
//	设置文本区用于显示信息
	public static JTextArea j_1=new JTextArea();
	
	
	public static void main(String[] args) {
//		实例化
		StudentUI ui=new StudentUI();
//		调用方法
		ui.init_1();
	}
	
//	主界面
	public void init_1() {

//		窗口大小
		jframe_1.setSize(810,400);
//		空布局
		jframe_1.setLayout(null);
//		窗口不可调整
		jframe_1.setResizable(false);
//		关闭窗口则退出程序
		jframe_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		菜单栏
		JMenuBar bar=new JMenuBar();
//		一级菜单
		JMenu men_1=new JMenu("基本操作");
		JMenu men_2=new JMenu("排序");
//		子菜单
		JMenuItem item_1=new JMenuItem("添加学生");
		JMenuItem item_2=new JMenuItem("修改学生");
		JMenuItem item_3=new JMenuItem("删除学生");
		JMenuItem item_4=new JMenuItem("查询学生");
		JMenuItem item_7=new JMenuItem("保存");
		
		JMenuItem item_5=new JMenuItem("按总分降序");
		JMenuItem item_6=new JMenuItem("按某科目降序");
//		定义字体
		Font font=new Font("黑体",Font.PLAIN,15);
		
//		设置菜单字体
		men_1.setFont(font);
		men_2.setFont(font);
		item_1.setFont(font);
		item_2.setFont(font);
		item_3.setFont(font);
		item_4.setFont(font);
		item_5.setFont(font);
		item_6.setFont(font);
		item_7.setFont(font);
//		加入
		men_1.add(item_1);
		men_1.add(item_2);
		men_1.add(item_3);
		men_1.add(item_4);
		men_1.add(item_7);
		
		men_2.add(item_5);
		men_2.add(item_6);
		
		bar.add(men_1);
		bar.add(men_2);
		jframe_1.setJMenuBar(bar);
	
//		设置面板位置、大小、颜色
		jpanel_1.setBounds(0,0,200,400);
		jpanel_2.setBounds(210,0,600,400);
		jpanel_1.setBackground(Color.LIGHT_GRAY);
		jpanel_2.setBackground(Color.LIGHT_GRAY);
		jframe_1.add(jpanel_1);
		jframe_1.add(jpanel_2);
		

		//设置文本区不能编辑
		j_1.setEditable(false);
		//将j1作为可滚动面板sp的显示区域
		JScrollPane sp=new JScrollPane(j_1);
		sp.setSize(585,340);
		StudentUI.jpanel_2.add(sp);
		
//		窗口居中
		jframe_1.setLocationRelativeTo(null);
//		窗口显示
		jframe_1.setVisible(true);
		
//		注册 添加学生 按钮的监听
		item_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				调用方法
				StudentUI.init_2();
			}
		});
//		注册 修改学生 按钮的监听
		item_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_3();
			}
		});
//		注册 删除学生 按钮的监听
		item_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_4();
			}
		});
//		注册 查询学生 按钮的监听
		item_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_5();
			}
		});
//		按 总分降序按钮 的监听
		item_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_7();
			}
		});
//		按 某科降序按钮 的监听
		item_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String [] options = {"高等数学","线性代数","离散数学","英语"};
				String s=(String) JOptionPane.showInputDialog(null,"请输入你的选项：",
						"提示",JOptionPane.QUESTION_MESSAGE,null,options,null);
				if(s!=null) {
					StudentUI.init_8(s);
				}
			}
		});
//		保存 按钮的监听
		item_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentUI.init_9();
			}
		});
	}
	
//	添加学生界面
	public static void init_2() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
//		Font font=new Font("黑体",Font.PLAIN,15);

//		学科名
		String s[]=new String[StudentInformation.number];
		s[0]=" 学       号：";
		s[1]=" 姓       名：";
		s[2]="高等数学：";
		s[3]="线性代数：";
		s[4]="离散数学：";
		s[5]=" 英       语：";
		s[6]=" 总       分：";
		
//		标签
		JLabel jlabel[]=new JLabel[StudentInformation.number];
//		文本框
		JTextField jtextfield[]=new JTextField[StudentInformation.number];
//		实例化
		for(int i=0;i<StudentInformation.number;i++) {
			jlabel[i]=new JLabel(s[i]);
//			jlabel[i].setFont(font);
			StudentUI.jpanel_1.add(jlabel[i]);
			jtextfield[i]=new JTextField(12);
			StudentUI.jpanel_1.add(jtextfield[i]);
		}
//		设置文本框默认值(总分自动计算,不可编辑)
		jtextfield[StudentInformation.number-1].setText("自动计算，无需输入");
		jtextfield[StudentInformation.number-1].setEditable(false);
//		按钮
		JButton jbutton_1=new JButton("提交");
		JButton jbutton_2=new JButton("清除");
//		加入按钮
		StudentUI.jpanel_1.add(jbutton_1);
		StudentUI.jpanel_1.add(jbutton_2);
//		注册监听
		StudentListen e_1=new StudentListen(jbutton_1, jbutton_2, jtextfield);
		jbutton_1.addActionListener(e_1);
		jbutton_2.addActionListener(e_1);
		
	}
	
//	修改 学生界面
	public static void init_3() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font=new Font("黑体",Font.PLAIN,15);
//		学科名
		String s[]=new String[StudentInformation.number];
		s[0]=" 学       号：";
		s[1]=" 姓       名：";
		s[2]="高等数学：";
		s[3]="线性代数：";
		s[4]="离散数学：";
		s[5]=" 英       语：";
		s[6]=" 总       分：";
		
//		标签
		JLabel jlabel[]=new JLabel[StudentInformation.number];
//		文本框
		JTextField jtextfield[]=new JTextField[StudentInformation.number];
//		按钮
		JButton jbutton_3=new JButton("修改");
		JButton jbutton_4=new JButton("清除");
		jbutton_3.setFont(font);
		jbutton_4.setFont(font);
		
//		实例化
		for(int i=0,j=0;i<StudentInformation.number;i++,j++) {
			jlabel[i]=new JLabel(s[i]);
//			jlabel[i].setFont(font);
			StudentUI.jpanel_1.add(jlabel[i]);
			jtextfield[i]=new JTextField(12);
			StudentUI.jpanel_1.add(jtextfield[i]);
//			j控制添加次数防止重复添加
			if(j==0) {
				JLabel L_1=new JLabel("学号不能被修改!");
				JLabel L_2=new JLabel("请在下面输入更新的信息：");
				StudentUI.jpanel_1.add(L_1);
				StudentUI.jpanel_1.add(L_2);
			}
		}
//		设置文本框默认值(总分自动计算,不可编辑)
		jtextfield[StudentInformation.number-1].setText("自动计算，无需输入");
		jtextfield[StudentInformation.number-1].setEditable(false);
		
		StudentUI.jpanel_1.add(jbutton_3);
		StudentUI.jpanel_1.add(jbutton_4);
//		注册监听
		StudentListen_1 e_1=new StudentListen_1(jbutton_3, jbutton_4, jtextfield);
		jbutton_3.addActionListener(e_1);
		jbutton_4.addActionListener(e_1);
	}
	
//	删除 学生界面
	public static void init_4() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font=new Font("黑体",Font.PLAIN,15);
//		标签
		JLabel jlabel_1=new JLabel(" 学       号：");
//		文本框
		JTextField jtextfield_1=new JTextField(10);
//		添加到面板
		StudentUI.jpanel_1.add(jlabel_1);
		StudentUI.jpanel_1.add(jtextfield_1);
		
//		按钮
		JButton jbutton_5=new JButton("删除");
		JButton jbutton_6=new JButton("清除");
		jbutton_5.setFont(font);
		jbutton_6.setFont(font);
		StudentUI.jpanel_1.add(jbutton_5);
		StudentUI.jpanel_1.add(jbutton_6);
		
//		注册监听
		StudentListen_2 e_2=new StudentListen_2(jbutton_5, jbutton_6, jtextfield_1);
		jbutton_5.addActionListener(e_2);
		jbutton_6.addActionListener(e_2);
	}
	
//	查询 学生界面
	public static void init_5() {
//		清空组件
		StudentUI.jpanel_1.removeAll();
//		刷新面板
		StudentUI.jpanel_1.updateUI();
//		字体
		Font font=new Font("黑体",Font.PLAIN,15);
//		学科名
		String s[]=new String[StudentInformation.number];
		s[0]=" 学       号：";
		s[1]=" 姓       名：";
		s[2]="高等数学：";
		s[3]="线性代数：";
		s[4]="离散数学：";
		s[5]=" 英       语：";
		s[6]=" 总       分：";
		
//		标签
		JLabel jlabel[]=new JLabel[StudentInformation.number];
//		文本框
		JTextField jtextfield[]=new JTextField[StudentInformation.number];
//		按钮
		JButton jbutton_8=new JButton("查询");
		JButton jbutton_9=new JButton("清除");
		JButton jbutton_10=new JButton("输出全部");
		jbutton_8.setFont(font);
		jbutton_9.setFont(font);
		jbutton_10.setFont(font);
		
//		实例化
		for(int i=0,j=0;i<StudentInformation.number;i++,j++) {
			jlabel[i]=new JLabel(s[i]);
//			jlabel[i].setFont(font);
			StudentUI.jpanel_1.add(jlabel[i]);
			jtextfield[i]=new JTextField(12);
			StudentUI.jpanel_1.add(jtextfield[i]);
//			j控制按钮的添加次数防止重复添加
			if(j==0) {
				StudentUI.jpanel_1.add(jbutton_8);
				StudentUI.jpanel_1.add(jbutton_9);
			}
//			设置文本框不可编辑
			else {
				jtextfield[i].setEditable(false);
			}
		}
		StudentUI.jpanel_1.add(jbutton_10);
		
//		注册监听
		StudentListen_3 e_3=new StudentListen_3(jbutton_8, jbutton_9,jbutton_10, jtextfield);
		jbutton_8.addActionListener(e_3);
		jbutton_9.addActionListener(e_3);
		jbutton_10.addActionListener(e_3);
	}
	
//	输出全部学生界面
	public static void init_6(JTextField jtextfield[]) {
		
		//设置容器
		JFrame j=new JFrame("所有学生信息");
		j.setSize(615,335);
		j.setLayout(null);
		//窗口不能调整
		j.setResizable(false);
		
		
		//设置文本区用于显示所有学生信息
		JTextArea j_2=new JTextArea("文本区可以滑动！！！\n\n关闭当前窗口，再次点击查询所有学生按钮可以刷新！！！\n\n\n");
		//设置文本区不能编辑
		j_2.setEditable(false);
		//将j1作为可滚动面板sp的显示区域
		JScrollPane sp=new JScrollPane(j_2);
		sp.setLocation(0,0);
		sp.setSize(600,300);
		j.add(sp);
		
		//学生当前总人数
		j_2.append("学生当前总人数为："+StudentInformation.all_student.size()+"\n\n");
	
		String s[]=new String[StudentInformation.number];
		s[0]=" 学       号：";
		s[1]=" 姓       名：";
		s[2]="高等数学：";
		s[3]="线性代数：";
		s[4]="离散数学：";
		s[5]=" 英       语：";
		s[6]=" 总       分：";
//		将信息添加到滚动文本区
		for(int i=0;i<StudentInformation.all_student.size();i++) {
			j_2.append(s[0]+StudentInformation.all_student.get(i).get_Id()+"    ");
			j_2.append(s[1]+StudentInformation.all_student.get(i).get_Name()+"    ");
			j_2.append(s[2]+StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"    ");
			j_2.append(s[3]+StudentInformation.all_student.get(i).get_Linear_Algebra()+"    ");
			j_2.append(s[4]+StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"    ");
			j_2.append(s[5]+StudentInformation.all_student.get(i).get_English()+"    ");
			j_2.append(s[6]+StudentInformation.all_student.get(i).get_Total()+"\n");
		}
//		居中显示
		j.setLocationRelativeTo(null);
//		显示窗口
		j.setVisible(true);	
	}
	
//	按总分降序排序界面
	public static void init_7() {
//		清空文本区
		StudentUI.j_1.setText("");
//		暂时存储信息
		StudentInformation student=new StudentInformation();
//		冒泡排序法
		for(int i=0;i<StudentInformation.all_student.size()-1;i++) {
			for(int j=0;j<StudentInformation.all_student.size()-1;j++) {
				if(StudentInformation.all_student.get(j).get_Total()<
				StudentInformation.all_student.get(j+1).get_Total()) {
					student =StudentInformation.all_student.get(j);
					StudentInformation.all_student.set(j, StudentInformation.all_student.get(j+1));
					StudentInformation.all_student.set(j+1, student);
				}
			}
		}
		
		String s[]=new String[StudentInformation.number];
		s[0]=" 学       号：";
		s[1]=" 姓       名：";
		s[2]="高等数学：";
		s[3]="线性代数：";
		s[4]="离散数学：";
		s[5]=" 英       语：";
		s[6]=" 总       分：";
		
//		将结果展现在文本区
		for(int i=0;i<StudentInformation.all_student.size();i++) {
//			添加信息
			j_1.append(s[0]+StudentInformation.all_student.get(i).get_Id()+"    ");
			j_1.append(s[1]+StudentInformation.all_student.get(i).get_Name()+"    ");
			j_1.append(s[2]+StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"    ");
			j_1.append(s[3]+StudentInformation.all_student.get(i).get_Linear_Algebra()+"    ");
			j_1.append(s[4]+StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"    ");
			j_1.append(s[5]+StudentInformation.all_student.get(i).get_English()+"    ");
			j_1.append(s[6]+StudentInformation.all_student.get(i).get_Total()+"\n");
		}
	}
	
//	按某科降序排序界面
	public static void init_8(String str) {
//		清空文本区
		StudentUI.j_1.setText("");
//		暂时存储信息
		StudentInformation student=new StudentInformation();
		
		String s[]=new String[StudentInformation.number];
		s[0]=" 学       号：";
		s[1]=" 姓       名：";
		s[2]="高等数学：";
		s[3]="线性代数：";
		s[4]="离散数学：";
		s[5]=" 英       语：";
		s[6]=" 总       分：";
		
		if(str.equals("高等数学")) {
//			冒泡排序法
			for(int i=0;i<StudentInformation.all_student.size()-1;i++) {
				for(int j=0;j<StudentInformation.all_student.size()-1;j++) {
					if(StudentInformation.all_student.get(j).get_Advanced_Mathematics()<
					StudentInformation.all_student.get(j+1).get_Advanced_Mathematics()) {
						student =StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j+1));
						StudentInformation.all_student.set(j+1, student);
					}
				}
			}
//			将结果展现在文本区
			for(int i=0;i<StudentInformation.all_student.size();i++) {
//				添加信息
				j_1.append(s[0]+StudentInformation.all_student.get(i).get_Id()+"    ");
				j_1.append(s[1]+StudentInformation.all_student.get(i).get_Name()+"    ");
				j_1.append(s[2]+StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"    ");
				j_1.append(s[3]+StudentInformation.all_student.get(i).get_Linear_Algebra()+"    ");
				j_1.append(s[4]+StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"    ");
				j_1.append(s[5]+StudentInformation.all_student.get(i).get_English()+"    ");
				j_1.append(s[6]+StudentInformation.all_student.get(i).get_Total()+"\n");
			}
		}else if(str.equals("线性代数")) {
//			冒泡排序法
			for(int i=0;i<StudentInformation.all_student.size()-1;i++) {
				for(int j=0;j<StudentInformation.all_student.size()-1;j++) {
					if(StudentInformation.all_student.get(j).get_Linear_Algebra()<
					StudentInformation.all_student.get(j+1).get_Linear_Algebra()) {
						student =StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j+1));
						StudentInformation.all_student.set(j+1, student);
					}
				}
			}
//			将结果展现在文本区
			for(int i=0;i<StudentInformation.all_student.size();i++) {
//				添加信息
				j_1.append(s[0]+StudentInformation.all_student.get(i).get_Id()+"    ");
				j_1.append(s[1]+StudentInformation.all_student.get(i).get_Name()+"    ");
				j_1.append(s[2]+StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"    ");
				j_1.append(s[3]+StudentInformation.all_student.get(i).get_Linear_Algebra()+"    ");
				j_1.append(s[4]+StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"    ");
				j_1.append(s[5]+StudentInformation.all_student.get(i).get_English()+"    ");
				j_1.append(s[6]+StudentInformation.all_student.get(i).get_Total()+"\n");
			}
		}else if(str.equals("离散数学")) {
//			冒泡排序法
			for(int i=0;i<StudentInformation.all_student.size()-1;i++) {
				for(int j=0;j<StudentInformation.all_student.size()-1;j++) {
					if(StudentInformation.all_student.get(j).get_Discrete_Mathematics()<
					StudentInformation.all_student.get(j+1).get_Discrete_Mathematics()) {
						student =StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j+1));
						StudentInformation.all_student.set(j+1, student);
					}
				}
			}
//			将结果展现在文本区
			for(int i=0;i<StudentInformation.all_student.size();i++) {
//				添加信息
				j_1.append(s[0]+StudentInformation.all_student.get(i).get_Id()+"    ");
				j_1.append(s[1]+StudentInformation.all_student.get(i).get_Name()+"    ");
				j_1.append(s[2]+StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"    ");
				j_1.append(s[3]+StudentInformation.all_student.get(i).get_Linear_Algebra()+"    ");
				j_1.append(s[4]+StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"    ");
				j_1.append(s[5]+StudentInformation.all_student.get(i).get_English()+"    ");
				j_1.append(s[6]+StudentInformation.all_student.get(i).get_Total()+"\n");
			}
		}else if(str.equals("英语")) {
//			冒泡排序法
			for(int i=0;i<StudentInformation.all_student.size()-1;i++) {
				for(int j=0;j<StudentInformation.all_student.size()-1;j++) {
					if(StudentInformation.all_student.get(j).get_English()<
					StudentInformation.all_student.get(j+1).get_English()) {
						student =StudentInformation.all_student.get(j);
						StudentInformation.all_student.set(j, StudentInformation.all_student.get(j+1));
						StudentInformation.all_student.set(j+1, student);
					}
				}
			}
//			将结果展现在文本区
			for(int i=0;i<StudentInformation.all_student.size();i++) {
//				添加信息
				j_1.append(s[0]+StudentInformation.all_student.get(i).get_Id()+"    ");
				j_1.append(s[1]+StudentInformation.all_student.get(i).get_Name()+"    ");
				j_1.append(s[2]+StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"    ");
				j_1.append(s[3]+StudentInformation.all_student.get(i).get_Linear_Algebra()+"    ");
				j_1.append(s[4]+StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"    ");
				j_1.append(s[5]+StudentInformation.all_student.get(i).get_English()+"    ");
				j_1.append(s[6]+StudentInformation.all_student.get(i).get_Total()+"\n");
			}
		}
	}
	
//	保存学生信息
	public static void init_9() {
		//建立输出
		FileOutputStream out=null;
		try {
			//设置路径文件名,true为 添加方式
			out =new FileOutputStream("D:\\studentMessage_1.txt",true);
			String student;
			String explain="本次保存信息如下：\n";
			byte buf[] =explain.getBytes();
			out.write(buf);
			for(int i=StudentInformation.all_student.size()-1;i>=0;i--) {
				//创建缓冲区,写入数据
				student =" 学       号："+ StudentInformation.all_student.get(i).get_Id()+"   ";
				byte buffer[] =student.getBytes();
				out.write(buffer);
				
				student =" 姓       名："+ StudentInformation.all_student.get(i).get_Name()+"   ";
				byte buffer1[] = student.getBytes();
				out.write(buffer1);
			
				student ="高等数学："+ StudentInformation.all_student.get(i).get_Advanced_Mathematics()+"   ";
				byte buffer2[] = student.getBytes();
				out.write(buffer2);
			
				student ="线性代数："+ StudentInformation.all_student.get(i).get_Linear_Algebra()+"   ";
				byte buffer3[] = student.getBytes();
				out.write(buffer3);
			
				student ="离散数学："+ StudentInformation.all_student.get(i).get_Discrete_Mathematics()+"   ";
				byte buffer4[] = student.getBytes();
				out.write(buffer4);
			
				student =" 英       语："+ StudentInformation.all_student.get(i).get_English()+"   ";
				byte buffer5[] = student.getBytes();
				out.write(buffer5);
				
				student =" 总       分："+ StudentInformation.all_student.get(i).get_Total()+"   ";
				byte buffer6[] = student.getBytes();
				out.write(buffer6);
				//换行
				out.write('\n');
			}
			//换行
			out.write('\n');
			out.write('\n');
			JOptionPane.showMessageDialog(null, "保存成功！！！\n保存路径为：D:\\\\studentMessage_1.txt",
					"提示",JOptionPane.PLAIN_MESSAGE);
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(out!=null) 
				out.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

