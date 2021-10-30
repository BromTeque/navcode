import kotlin.math.ceil

fun calculateUnemploymentBenefits(income: List<Double>): Double {
    // Variables
    val grunnbelop: Int = 106399 //Grunnbeløp per year
    var dagpengegrunnlag: Double = 0.0
    var dagsats: Int = 0


    dagpengegrunnlag = grunnbelop.toDouble()
    for (y in income) {
        dagpengegrunnlag += income[income.indexOf(y)]
    }
    if (income.sum() > 3 * grunnbelop) {
        println("dagpenger!")
        println(income.sum())
    } else if (income[0] > 1.5 * grunnbelop) {
        println("dagpenger!")
        println(income[0])
    }
    if (income.sum() > 6 * grunnbelop) {
        println("for mye penger!")
    }
    print("Income last year: ")
    println(income[0])
    print("Average of income last 3 years: ")
    println((income.slice(0..2).sum())/3)
    if (dagpengegrunnlag > 6 * grunnbelop) {
        println("benefits too big")
        dagpengegrunnlag = 6 * grunnbelop.toDouble()
    }

    dagsats = ceil(dagpengegrunnlag / 260).toInt()
    print("dagsats: ")
    println(dagsats)


    return dagpengegrunnlag
}

fun main() {
    println("main")
    val result = calculateUnemploymentBenefits(listOf(500000.0, 450000.0, 400000.0))
    println(result)
}

//ASSUMPTIONS:
// Income is ALWAYS given least year, year before, year before...