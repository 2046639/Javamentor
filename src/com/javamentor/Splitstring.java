package com.javamentor;
public class Splitstring
{
    private static String a1;
    public String getA1() {
        return a1;
    }
    private static String a2;
    public String getA2() {
        return a2;
    }
    private static String arithmetic_operator;
    public String getArithmetic_operator() {
        return arithmetic_operator;
    }
    private static String romanORarab;
    public String getRomanORarab() {
        return romanORarab;
    }

    public void parsingRomanOrArabDigit (String text)
    {
        if (text.contains("+"))
            arithmetic_operator = "+";
        else if (text.contains("-"))
            arithmetic_operator = "-";
        else if (text.contains("*"))
            arithmetic_operator = "*";
        else if (text.contains("/"))
            arithmetic_operator = "/";
        // Если любой из римских знаков найден
        if ((text.contains("X")) || (text.contains("V")) || (text.contains("I")))
            romanORarab = "r";
        else
            romanORarab = "a";

        //Добавил экранирование в регулярку
        String sss = "\\";
        String regexstr = sss.concat(arithmetic_operator);
        String[] digits = text.split(regexstr);
        a1 = digits[0];
        a2 = digits[1];
    }
    public static void main(String[] args){

    }
}
/*
class Program {

    public static void main(String[] args) {
        String text = "X*I";
        Splitstring str = new Splitstring();
        str.parsingRomanOrArabDigit(text);
        System.out.println("str.getA1() = " + str.getA1());
        System.out.println("str.getA2() = " + str.getA2());
    }
}
*/
