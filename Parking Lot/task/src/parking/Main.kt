package parking

data class Car(val reg:String, val color: String)

fun main() {
    val parking = MutableList<Car?>(20) {null}
    do {
        val args = readln().split(" ")
        val command = args[0]
        if (command == "park") {
            val car = Car(args[1], args[2])
            val parkBay = parking.park(car)
            println(
                if (parkBay != -1)
                    "${car.color} car parked in spot $parkBay."
                else "Sorry, the parking lot is full.")
        } else if (command == "leave") {
            val spotEmpty = parking.leave(args[1].toInt())
            println(
                if (spotEmpty != -1)
                    "Spot $spotEmpty is free."
                else "There is no car in spot ${args[1]}.")
        }
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