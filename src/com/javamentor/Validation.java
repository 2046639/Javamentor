/*Проверка правильности ввода
допустимые символы ввода:
римские цифры V,I,X,
арифметические знаки +,-,/,*,
арабские цифры 0,1,2,3,4,5,6,7,8,9
пробел ' '
  */
package com.javamentor;
import java.util.Scanner;

public class Validation {

    static String stringValidation (){
        try {
            //Ввод с клавиатуры
            Scanner sc = new Scanner(System.in);
            String instring = sc.nextLine();
            //Удалил пробелы  и табуляцию
            instring = instring.replaceAll("\\s", "");
            //Вывод в консоль
            System.out.println("Ваш ввод: " + instring);
            if (instring.length() < 3)
                throw new Exception("Ошибка ввода: слишком короткая строка");

            // Проверка: выражение не начинается и не заканчивается на +, -, *, /
            if (firstSignIsDetected(instring).equals("Detected"))
                throw new Exception("Знак арифметической операции первый или последний в строке");
            else {
                //Преобразование строки в массив
                char[] instringArray = instring.toCharArray();
                int romancount = 0; int arabcount = 0; int mathsign = 0;
                for (char t : instringArray) {
                    // Если количество римских букв в строке и кличество знаков арифметик = длине строки,
                    //то эта строка римская, если наоборот то арабская. Если не совпадает, то есть запрещенные символы
                    if ( t == '+' || t == '-' || t == '/' || t == '*' ) mathsign++ ;
                    if ( t == 'V' || t == 'I' || t == 'X' ) romancount++ ;
                    if ( t == '0' || t == '1' || t == '2' || t == '3' || t == '4' ||
                            t == '5' || t == '6' || t == '7' || t == '8' || t == '9'  ) arabcount++ ;
                }
                if( ( ((mathsign + romancount) == instring.length() && (mathsign == 1)) == false) &&
                        ( ((mathsign + arabcount) == instring.length() && (mathsign == 1)) == false ) )
                    throw new Exception("Допустим ввод только 1 арифметического знака между арабскими или римскими цифрами");
            }
            // Парсинг ввода на переменные и арифметичиский знак
            Splitstring str = new Splitstring();
            str.parsingRomanOrArabDigit(instring);
            return "good";
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return "ошибка валидации";
        }
    }

    public static void main(String[] args) {
        stringValidation();
    }

    public static String firstSignIsDetected(String str) {
        if ((str.startsWith("+")) || (str.endsWith("+")) ||
                (str.startsWith("-")) || (str.endsWith("-")) ||
                (str.startsWith("*")) || (str.endsWith("*")) ||
                (str.startsWith("/")) || (str.endsWith("/")))
            return "Detected";
        else return "notDetected";
    }
}