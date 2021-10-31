import kotlin.math.ceil

fun calculateUnemploymentBenefits(income: List<Double>) {
    // Variables
    val grunnbelop = 104716 //Grunnbeløp per year

    // Eligibility Calculation
    if ((income.sum() > 3 * grunnbelop) || (income[0] > 1.5 * grunnbelop)) {
        // Dagpenger Formula and over 6G check
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
    print("Test: eksempel: ")
    calculateUnemploymentBenefits(listOf(500000.0, 450000.0, 400000.0))
    print("Test: dagpengegrunnlag er over 6G: ")
    calculateUnemploymentBenefits(listOf(800000.0, 770000.0, 730000.0))
    print("Test: inntekt er under 3G: ")
    calculateUnemploymentBenefits(listOf(100000.0, 90000.0, 110000.0))
    print("Test: inntekt er under 1.5G: ")
    calculateUnemploymentBenefits(listOf(111000.0, 0.0, 15000.0))
}