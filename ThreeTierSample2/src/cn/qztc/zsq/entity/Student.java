package cn.qztc.zsq.entity;

public class Student {
	private int studentNo; // 学号



	private String studentName; // 姓名

	private int studentAge; // 年龄

	private String gradeName; // 年级
	public Student() {
		super();
	}
	public int getStudentNo() {
		return studentNo;
	}
	
	public Student(int studentNo, String studentName, int studentAge, String gradeName) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.gradeName = gradeName;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", gradeName=" + gradeName + "]";
	}

}
