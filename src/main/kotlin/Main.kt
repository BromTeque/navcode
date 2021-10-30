import kotlin.math.ceil

fun calculateUnemploymentBenefits(income: List<Double>) {
    // Variables
    val grunnbelop = 106399 //Grunnbeløp per year

    // Eligibility Calculation
    if ((income.sum() > 3 * grunnbelop) || (income[0] > 1.5 * grunnbelop)) {
        var dagpengegrunnlag = maxOf(income[0], (income.slice(0..2).sum())/3)                                 // Dagpengegrunnlag Formula
        if (dagpengegrunnlag > 6 * grunnbelop) {
            dagpengegrunnlag = 6 * grunnbelop.toDouble()
        }
        val dagsats = ceil(dagpengegrunnlag / 260).toInt()                                                           // Dagsats Formula
        println("Eligible for dagpenger with a rate of $dagsats")
        return
    } else {
        println("Not eligible for dagpenger.")
        return
    }
}

fun main() {
    calculateUnemploymentBenefits(listOf(500000.0, 450000.0, 400000.0))                                                 // Example
    calculateUnemploymentBenefits(listOf(800000.0, 750000.0, 700000.0))                                                 // Above 6G
    calculateUnemploymentBenefits(listOf(100000.0, 100000.0, 100000.0))                                                 // Below 3G
    calculateUnemploymentBenefits(listOf(111000.0, 0.0, 0.0))                                                           // Below 1.5G
}