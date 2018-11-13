package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="emptab")
public class Employee {

	@Id
	@Column(name="eid")
	@GeneratedValue(generator="mygen")
	@GenericGenerator(name="mygen",strategy="increment")
	private Integer empId;
	@Column(name="ename")
	private String empName;
	@Column(name="epwd")
	private String empPwd;
	@Column(name="egen")
	private String empGen;
	@Column(name="addr")
	private String empAddr;
	@Column(name="cntry")
	private String empCntry;
	
	@ElementCollection
	@CollectionTable(name="emplangtab", //table name
		joinColumns=@JoinColumn(name="eid") //key column
	)
	@OrderColumn(name="pos") //index column
	@Column(name="lang") //element column
	private List<String> empLang;
	
	public Employee() {
		super();
	}
	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public String getEmpGen() {
		return empGen;
	}
	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpCntry() {
		return empCntry;
	}
	public void setEmpCntry(String empCntry) {
		this.empCntry = empCntry;
	}
	public List<String> getEmpLang() {
		return empLang;
	}
	public void setEmpLang(List<String> empLang) {
		this.empLang = empLang;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPwd=" + empPwd + ", empGen=" + empGen
				+ ", empAddr=" + empAddr + ", empCntry=" + empCntry + ", empLang=" + empLang + "]";
	}
	
}