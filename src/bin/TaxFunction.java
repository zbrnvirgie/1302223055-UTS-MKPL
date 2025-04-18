package bin;

public class TaxFunction {

    private static final int PENGHASILAN_TIDAK_KENA_PAJAK = 54000000;
    private static final int TAMBAHAN_PENGHASILAN_TIDAK_KENA_PAJAK_MENIKAH = 4500000;
    private static final int TAMBAHAN_PENGHASILAN_TIDAK_KENA_PAJAK_ANAK = 1500000;
    private static final double TARIF_PAJAK = 0.05;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            System.err.println("Jumlah bulan bekerja lebih dari 12 per tahun");
            return 0;
        }

        int annualSalary = monthlySalary * numberOfMonthWorking;
        int annualOtherIncome = otherMonthlyIncome * numberOfMonthWorking;
        int totalIncome = annualSalary + annualOtherIncome - deductible;

        int nonTaxableIncome = PENGHASILAN_TIDAK_KENA_PAJAK;
        if (isMarried) {
            nonTaxableIncome += TAMBAHAN_PENGHASILAN_TIDAK_KENA_PAJAK_MENIKAH;
        }
        nonTaxableIncome += Math.min(numberOfChildren, 3) * TAMBAHAN_PENGHASILAN_TIDAK_KENA_PAJAK_ANAK;

 
        int taxableIncome = totalIncome - nonTaxableIncome;
        int tax = (int) Math.round(TARIF_PAJAK * Math.max(taxableIncome, 0));

        return tax;
    }
}
