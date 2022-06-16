fun main() {
    val sec = 270001
    val countMinutes = sec / 60 // Пересчет времени в минуты
    val countHours = sec / 3600 // Пересчет времени в часы
    val time = agoToText(sec, countHours, countMinutes)
    println(time)
}

fun agoToText(sec: Int, countHours: Int, countMinutes: Int): String {
    val heWas: String // определение переменной по времени нахождения
    val minutes = secInMinutes(countMinutes)
    val hours = secInHours(countHours)

    when {
        sec <= 60 -> heWas = "Был только что"
        sec < 3600 && sec > 60 -> heWas = "Был $countMinutes " + minutes + " назад"
        sec > 3600 && sec <= 24 * 60 * 60 -> heWas = "Был $countHours" + hours + " назад"
        sec > 24 * 60 * 60 && sec <= 2 * 24 * 60 * 60 -> heWas = "Был сегодня"
        sec > 2 * 24 * 60 * 60 && sec <= 3 * 24 * 60 * 60 -> heWas = "Был вчера"
        else -> heWas = "Был давно"
    }
    return heWas
}

fun secInMinutes(countMinutes: Int): String { // формирование слова минута
    val min: String
    val oneMin = " минуту назад"
    val twoMin = " минуты назад"
    val fiveMin = " минут назад"

    when {
        countMinutes % 10 == 1 && countMinutes % 100 != 11 -> min = oneMin
        countMinutes % 10 == 2 || countMinutes % 10 == 3 || countMinutes % 10 == 4 -> min = twoMin
        else -> min = fiveMin
    }
    return min
}

fun secInHours(countHours: Int): String { // формирование слова час
    val hour: String
    val oneHour = " час"
    val twoHour = " часа"
    val fiveHour = " часов"

    when {
        countHours % 10 == 1 && countHours % 100 != 11 -> hour = oneHour
        (countHours % 10 == 2 && countHours % 100 != 12) || (countHours % 10 == 3 && countHours % 100 != 13)
                || (countHours % 10 == 4 && countHours % 100 != 14) -> hour = twoHour
        else -> hour = fiveHour
    }
    return hour
}