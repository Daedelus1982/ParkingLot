package parking

data class Car(val reg:String, val color: String)

fun main() {
    var parking: MutableList<Car?>? = null
    do {
        val args = readln().split(" ")
        val command = args[0]
        println( when {
            command == "exit" -> ""
            command == "create" -> {
                val slots = args[1].toInt()
                parking = MutableList(slots) { null }
                "Created a parking lot with $slots spots."
            }
            parking == null -> "Sorry, a parking lot has not been created."
            command == "park" -> {
                val car = Car(args[1], args[2])
                val parkBay = parking.park(car)
                if (parkBay != -1)
                    "${car.color} car parked in spot $parkBay."
                else "Sorry, the parking lot is full."
            }
            command == "leave" -> {
                val spotEmpty = parking.leave(args[1].toInt())
                if (spotEmpty != -1)
                    "Spot $spotEmpty is free."
                else "There is no car in spot ${args[1]}."
            }
            command == "status" -> parking.status()
            else -> ""
        })
    } while (command != "exit")
}

fun MutableList<Car?>.park(requestingCar: Car): Int {
    for (i in indices) {
        if (get(i) == null) {
            set(i, requestingCar)
            return i + 1
        }
    }
    return -1
}

fun MutableList<Car?>.leave(spot: Int): Int {
    if (get(spot - 1) != null) {
        set(spot - 1, null)
        return spot
    }
    return -1
}

fun MutableList<Car?>.status(): String {
    if (filterNotNull().isEmpty()) return "Parking lot is empty."
    val lot = mapIndexed { index, car -> if (car != null) "${index + 1} ${car.reg} ${car.color}" else null}
        .filterNotNull()
    return lot.joinToString("\n")
}