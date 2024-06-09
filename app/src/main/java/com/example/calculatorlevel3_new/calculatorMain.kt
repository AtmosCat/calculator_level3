package com.example.calculator_hojeong

fun main() {
    // 이름 지정
    var calculatorName = "호정의 계산기 Lv3"

    // 입력값 받기
    println("연산을 진행할 첫 번째 값을 입력해주세요.")
    var num1 = readLine()!!.toInt()
    println("연산을 진행할 두 번째 값을 입력해주세요.")
    var num2 = readLine()!!.toInt()

    // 추가 입력값 num3로 받기
    var num3 = 0

    // 연산 타입 입력받기
    println("어떤 연산을 진행하실래요?(1(더하기)/2(빼기)/3(곱하기)/4(나누기) 중 입력)")
    var calculationOption = readLine()!!.toInt()

    // 수퍼 클래스
    val calc = Calculation(num1, num2, calculationOption)

    // 첫 연산 시 서브 클래스별 연산 결과
    var additionResult = AddOperation(num1, num2).calculate()
    var subtractionResult = SubtractOperation(num1, num2).calculate()
    var multiplicationResult = MultiplyOperation(num1, num2).calculate()
    var divisionResult = DivideOperation(num1, num2).calculate()
    var calculationResult = 0
    var moreCalculationOption : Int = 0

    if (calculationOption == 1){
        calculationResult = additionResult
        num3 = 0
    } else if (calculationOption == 2){
        calculationResult = subtractionResult
        num3 = 0
    } else if (calculationOption == 3){
        calculationResult = multiplicationResult
        num3 = 1
    } else if (calculationOption == 4){
        calculationResult = divisionResult
        num3 = 1
    } else {
        calculationResult = 99999999
        println("입력값이 잘못되었습니다.")
    }

    while (num3 != -1) {
        if (calculationOption == 1 || moreCalculationOption == 1) {
            println("더하기 연산을 수행합니다.")
            calculationResult += num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else if (calculationOption == 2 || moreCalculationOption == 2) {
            println("빼기 연산을 수행합니다.")
            calculationResult -= num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else if (calculationOption == 3 || moreCalculationOption == 3) {
            println("곱하기 연산을 수행합니다.")
            calculationResult *= num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else if (calculationOption == 4 || moreCalculationOption == 4) {
            println("나누기 연산을 수행합니다.")
            calculationResult /= num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else {
            println("옵션값이 잘못되었습니다.")
        }
    }
}

// 수퍼 클래스
open class Calculation(var num1: Int, var num2: Int, var operationOption: Int) {
    open fun calculate():Int {
     println("연산을 수행합니다.")
     return 0
    }
}

// 서브 클래스 - 더하기
class AddOperation(num1: Int, num2: Int) : Calculation(num1, num2, 1) {
    override fun calculate(): Int = num1 + num2
}

// 서브 클래스 - 빼기
class SubtractOperation(num1: Int, num2: Int) : Calculation(num1, num2, 2) {
    override fun calculate(): Int = num1 - num2
}

// 서브 클래스 - 곱하기
class MultiplyOperation(num1: Int, num2: Int) : Calculation(num1, num2, 3) {
    override fun calculate(): Int = num1 * num2
}

// 서브 클래스 - 나누기
class DivideOperation(num1: Int, num2: Int) : Calculation(num1, num2, 4) {
    override fun calculate(): Int = num1 / num2
}



