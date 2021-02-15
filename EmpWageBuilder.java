package empwage;
//Store the total wage along with daily wage

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

interface IComputeWageOfEmployee {  

	public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth);
	public void computeEmpWage();
}

class CompanyEmployeeWage {  

	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;

	public CompanyEmployeeWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maximumHoursPerMonth = maximumHoursPerMonth;
	}
	public void setTotalEmpWage(int totalWage) {

		this.totalWage=totalWage;
	}
	public String toString() {

		return "Total Employee Wage for "+company+" is "+totalWage;
	}
}

public class EmpWageBuilder implements IComputeWageOfEmployee {

	public static final int isFullTime=1;
	public static final int isPartTime=2;
	private ArrayList<CompanyEmployeeWage> empList;
	private LinkedList<Integer>dailyWage;
	public EmpWageBuilder() {

		empList = new ArrayList<>();
		dailyWage = new LinkedList<>();
	}
	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {

		CompanyEmployeeWage empWage=new CompanyEmployeeWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
	}

	@Override
	public void computeEmpWage() {
 
         		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEmpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}

	HashMap<String,LinkedList> companyDailyWage = new HashMap<>();

	private  int computeEmpWage(CompanyEmployeeWage companyEmpWage) {

             int empHours = 0, totalEmpHours = 0, totalWorkingDays = 1;
             while(totalEmpHours <= companyEmpWage.maximumHoursPerMonth && totalWorkingDays <= companyEmpWage.numOfWorkingDays){
             int check = (int) (Math.floor(Math.random()* 10 ) % 3 );
             switch(check){
             case isPartTime:
                     empHours = 4;
                     break;
             case isFullTime:
                     empHours = 8;
                     break;
             default :
                     empHours = 0;
             }
             totalEmpHours += empHours;
             totalWorkingDays +=1;
             dailyWage.add(empHours * companyEmpWage.empRatePerHour);
             
             }
		 companyDailyWage.put(companyEmpWage.company, dailyWage);
		 System.out.println("Daily Wage for the " + companyEmpWage.company + " is :"+dailyWage);
		 dailyWage.clear();
		 return (totalEmpHours * companyEmpWage.empRatePerHour);		  
	    }
	
	public static void main(String args[]) {

		EmpWageBuilder employeeWageBuilder = new EmpWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("Amazon", 150, 20, 180);
		employeeWageBuilder.addCompanyEmpWage("Microsoft", 500, 24, 200);
		employeeWageBuilder.addCompanyEmpWage("Flipkart", 200, 26, 230);
		employeeWageBuilder.addCompanyEmpWage("Wipro", 120, 28, 250);
		employeeWageBuilder.addCompanyEmpWage("Accenture", 500, 22, 200);
		employeeWageBuilder.computeEmpWage();
	}
	
}
