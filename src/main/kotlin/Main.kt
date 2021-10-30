import kotlin.math.ceil

fun calculateUnemploymentBenefits(income: List<Double>) {
    // Variables
    val grunnbelop = 106399 //Grunnbeløp per year

    // Eligibility Calculation
    if ((income.sum() > 3 * grunnbelop) || (income[0] > 1.5 * grunnbelop)) {
        // Dagpenger Formula and 6G check
        var dagpengegrunnlag = maxOf(income[0], (income.slice(0..2).sum())/3)
        if (dagpengegrunnlag > 6 * grunnbelop) {
            dagpengegrunnlag = 6 * grunnbelop.toDouble()
        }
        // Dagsats Formula
        val dagsats = ceil(dagpengegrunnlag / 260).toInt()
        println("Kvalifisert for dagpenger med en dagsats på $dagsats kr")
        return
    } else {
        println("Ikke kvalifisert for dagpenger.")
        return
    }
}

fun main() {
    print("Eksempel: ")
    calculateUnemploymentBenefits(listOf(500000.0, 450000.0, 400000.0))
    print("Over 6G: ")
    calculateUnemploymentBenefits(listOf(800000.0, 750000.0, 700000.0))
    print("Under 3G: ")
    calculateUnemploymentBenefits(listOf(100000.0, 100000.0, 100000.0))
    print("Under 1.5G: ")
    calculateUnemploymentBenefits(listOf(111000.0, 0.0, 0.0))
}