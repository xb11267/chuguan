package myproject;

import java.util.ArrayList;

//定义学生类
public class StudentInformation {
	
//	存储学生总人数
	public static ArrayList<StudentInformation> all_student=new ArrayList<StudentInformation>();
//	学科数量,包括学号和姓名
	public static int number=7;
	
	private  String id;//学号
	private  String name;//姓名
	private  int advanced_Mathematics;//高等数学
	private  int linear_Algebra;//线性代数
	private  int discrete_Mathematics;//离散数学
	private  int English;//英语
	private  int Total;//总分
	
	//用于实例化
	public StudentInformation() {}
	
	public StudentInformation(String id,String name,
			int advanced_Mathematics,int linear_algebra,
			int discrete_mathematics,int English,int Total) {
		
		this.id=id;
		this.name=name;
		this.advanced_Mathematics=advanced_Mathematics;
		this.linear_Algebra=linear_algebra;
		this.discrete_Mathematics=discrete_mathematics;
		this.English=English;
		this.Total=Total;
	}
	
	//获得数据
	public String get_Id() {
		return id;
	}
	public String get_Name() {
		return name;
	}
	public int get_Advanced_Mathematics() {
		return advanced_Mathematics;
	}
	public int get_Linear_Algebra() {
		return linear_Algebra;
	}
	public int get_Discrete_Mathematics() {
		return discrete_Mathematics;
	}
	public int get_English() {
		return English;
	}
	public int get_Total() {
		return Total;
	}
	
	//修改数据
	public void set_Id(String id) {
		this.id=id;
	}
	public void set_Name(String name) {
		this.name=name;
	}
	public void set_Advanced_Mathematics(int advanced_Mathematics) {
		this.advanced_Mathematics=advanced_Mathematics;
	}
	public void set_Linear_Algebra(int linear_Algebra) {
		this.linear_Algebra=linear_Algebra;
	}
	public void set_Discrete_Mathematics(int discrete_Mathematics) {
		this.discrete_Mathematics=discrete_Mathematics;
	}
	public void set_English(int English) {
		this.English=English;
	}
	public void set_Total(int Total) {
		this.Total=Total;
	}
	
}