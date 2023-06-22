fun main() {
    val str = readln()
    println(str.reversed().replaceRange(1, str.lastIndex, str.substring(1, str.lastIndex)))
}