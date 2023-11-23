import Clases.*
import java.security.interfaces.DSAPublicKey


        val scaryMovie2 = scaryMovie.copy(name = "Scary Movie 2", duration = 83.8)
        println("Scary Movie 2 $scaryMovie2")
    }*/

    val saverGrade2 = fun(expected:Double, saved:Double): String{
        val percentage = saved /expected
        return when{
            percentage > 1 -> "Ahorrador Pro"
            percentage == 1.0 -> "Buen ahorrador"
            percentage < 1.0 && percentage >= 0.8 -> "Almost"
            else -> "aprendiz saver"
        }
    }
    println(saverGrade2(100.0,80.0))
}*/


fun getDiscount(price: Double, coupon: String, calculateDiscount: (Double, String) -> Double): Double {
    return calculateDiscount(price, coupon)
}

fun main() {
    val coupon = "PROMO2020"
    val precio = 100.0

    val discountCalculator: (Double, String) -> Double = { price, coupon ->
        when (coupon) {
            "NOIVA" -> price
            "HALFIVA" -> price + price * 0.16 / 2
            "MINUS100" -> price - 100
            "PROMO2020" -> when {
                price <= 1000 -> price - price * 0.12
                price <= 2000 -> price - price * 0.04
                price <= 4000 -> price * 0.16 / 2
                else -> price / 3
            }
            else -> price + price * 0.16
        }
    }

    val finalPrice = getDiscount(precio, coupon, discountCalculator)
    println("El precio final es: $finalPrice")
}