fun main() {
    val str = readln()
    var vowels = 0
    var consonants = 0
    var inserts = 0
    for (ch in str) {
        if (isVowel(ch)) {
            vowels++
            consonants = 0
        } else {
            consonants++
            vowels = 0
        }
        if (vowels == 3) {
            inserts++
            vowels = 1
            consonants = 0
        } else if (consonants == 3){
            inserts++
            vowels = 0
            consonants = 1
        }
    }
    println(inserts)
}

fun isVowel(ch: Char): Boolean = when (ch) { 'a', 'e', 'i', 'o', 'u', 'y' -> true else -> false }