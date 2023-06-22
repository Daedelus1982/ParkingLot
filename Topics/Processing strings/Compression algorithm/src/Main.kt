fun main() {
    val str = readln()
    var count = 0
    val out = mutableListOf<String>()
    for (i in 0 until str.length) {
        if (i == 0 || str[i] == str[i - 1]) count++
        else {
            out.add("${str[i - 1]}$count")
            count = 1
        }
    }
    out.add("${str[str.lastIndex]}$count")
    println(out.joinToString(""))
}