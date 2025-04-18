package bin;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private LocalDate joinDate; ////tambahan
	
	private int monthWorkingInYear;
	private boolean isForeigner;
	private boolean gender;
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<Child> children; //// tambahan
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
					int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinDate = LocalDate.of(yearJoined, monthJoined, dayJoined);
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		children = new LinkedList<>();
	}
	
	public void setMonthlySalary(int grade) {
		if (grade == 1) {
			monthlySalary = 3000000;
		} else if (grade == 2) {
			monthlySalary = 5000000;
		} else if (grade == 3) {
			monthlySalary = 7000000;
		}
		if (isForeigner) {
			monthlySalary *= 1.5;
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		children.add(new Child(childName, childIdNumber));
	}
	
	public int getAnnualIncomeTax() {
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == joinDate.getYear()) {
			monthWorkingInYear = date.getMonthValue() - joinDate.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(
			monthlySalary,
			otherMonthlyIncome,
			monthWorkingInYear,
			annualDeductible,
			spouseIdNumber.equals(""),
			children.size()
		);
	}
}
