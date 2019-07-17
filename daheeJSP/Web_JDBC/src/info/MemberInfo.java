package info;

public class MemberInfo {

	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private int sal;
	private int deptno;
	
	public MemberInfo() {
		
	}
	
	public MemberInfo(int empno, String ename, String job, String mgr, int sal, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public String getJob() {
		return job;
	}

	public String getMgr() {
		return mgr;
	}

	public int getSal() {
		return sal;
	}

	public int getDeptno() {
		return deptno;
	}

	
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "MemberInfo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal
				+ ", deptno=" + deptno + "]";
	}

	
}
	
	
	
