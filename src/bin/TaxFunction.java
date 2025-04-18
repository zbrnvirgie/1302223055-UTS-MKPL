package bin;

public class TaxFunction {
    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
   
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
       
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }
        
        int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        
        int taxFreeIncome = 54000000;
        if (isMarried) {
            taxFreeIncome += 4500000;
            taxFreeIncome += (numberOfChildren * 1500000); 
        }
        
        int tax = (int) Math.round(0.05 * (annualIncome - deductible - taxFreeIncome));
        
        return (tax < 0) ? 0 : tax;
    }
}