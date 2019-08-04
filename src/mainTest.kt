val table = arrayOf(
    arrayOf(' ', '1', '2', '3'),
    arrayOf('1', '-', '-', '-'),
    arrayOf('2', '-', '-', '-'),
    arrayOf('3', '-', '-', '-')
)
var turn = 'x'
var win = '-'

fun showTable(){
    for (row in table){
        for (col in row){
            print("$col ")
        }
        println()
    }
}

fun showTurn(){
    println("$turn turn")
}

fun showWin(){
    println("$win Win!")
}

fun inputRC(){
    try {
        print("please input numbers row col:")
        val input = readLine()
        val rcList: List<String>? = input?.split(" ")
        if(rcList?.size != 2){
            // new input
            print("Error: ")
            inputRC()
        } else {
            val rowInt = rcList[0].toInt()
            val colInt = rcList[1].toInt()
            if(rowInt !in 1..3 || colInt !in 1..3){
                // new input
                print("Error: ")
                inputRC()
            } else {
                for (i in table.indices){
                    for (j in table[i].indices){
                        if (i == rowInt && j == colInt){
                            if(!table[i][j].equals('-')){
                                // new input
                                print("Error: ")
                                inputRC()
                            } else {
                                table[i][j] = turn
                                if (turn == 'x'){
                                    turn = 'o'
                                } else {
                                    turn = 'x'
                                }
                            }

                        }
                    }
                }
            }
        }
    } catch (t: Throwable){
        // new input
        print("Error: ${t.message} ")
        inputRC()
    }

}

fun checkWin(): Boolean{
    if (table[1][1].equals('x') && table[1][2].equals('x') && table[1][3].equals('x')
        || table[2][1].equals('x') && table[2][2].equals('x') && table[2][3].equals('x')
        || table[3][1].equals('x') && table[3][2].equals('x') && table[3][3].equals('x')
        || table[1][1].equals('x') && table[2][1].equals('x') && table[3][1].equals('x')
        || table[1][2].equals('x') && table[2][2].equals('x') && table[3][2].equals('x')
        || table[1][3].equals('x') && table[2][3].equals('x') && table[3][3].equals('x')
        || table[1][1].equals('x') && table[2][2].equals('x') && table[3][3].equals('x')
        || table[1][3].equals('x') && table[2][2].equals('x') && table[3][1].equals('x')){
        win = 'x'
        return true
    }
    if (table[1][1].equals('o') && table[1][2].equals('o') && table[1][3].equals('o')
        || table[2][1].equals('o') && table[2][2].equals('o') && table[2][3].equals('o')
        || table[3][1].equals('o') && table[3][2].equals('o') && table[3][3].equals('o')
        || table[1][1].equals('o') && table[2][1].equals('o') && table[3][1].equals('o')
        || table[1][2].equals('o') && table[2][2].equals('o') && table[3][2].equals('o')
        || table[1][3].equals('o') && table[2][3].equals('o') && table[3][3].equals('o')
        || table[1][1].equals('o') && table[2][2].equals('o') && table[3][3].equals('o')
        || table[1][3].equals('o') && table[2][2].equals('o') && table[3][1].equals('o')){
        win = 'o'
        return true
    }
    return false
}

fun main() {
    println("Welcome to OX Game")
    for(i in 1..9){
        showTable()
        showTurn()
        inputRC()
        if(checkWin() == true){
            showWin()
            break
        }
        if (i == 9){
            println("Draw!")
        }
    }
}