package com.javamentor;
import static com.javamentor.Validation.*;

public class Main {

    static  String Calculator() {

        Splitstring s = new Splitstring();

        String[] romanDigit = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanDecim = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        int val1 = 0;
        int val2 = 0;
        int valsum = 0;
        if (s.getRomanORarab().equals("a")) {
            val1 = Integer.parseInt(s.getA1());
            val2 = Integer.parseInt(s.getA2());
        }
        if (s.getRomanORarab().equals("r")) {
            for (int i = 1; i < romanDigit.length; i++) {
                if (s.getA1().equals(romanDigit[i])) val1 = i;
                if (s.getA2().equals(romanDigit[i])) val2 = i;
            }
        }

        if ((val1 < 1) || (val1 > 10) || (val2 < 1) || (val2 > 10)) {
            return "выход за диапазон";
        }

        switch (s.getArithmetic_operator()) {
            case "+":
                valsum = val1 + val2;
                break;
            case "-":
                valsum = val1 - val2;
                break;
            case "*":
                valsum = val1 * val2;
                break;
            case "/":
                valsum = val1 / val2;
                break;
        }
        //Если ввод римскими цифрами
        if (s.getRomanORarab().equals("r")) {
            String romdigit;
            //       romdigit = romanDecim[valsum / 10]  + romanDigit[Math.abs(valsum - (valsum /10) * 10)];
            romdigit = romanDecim[valsum / 10]  + romanDigit[Math.abs(valsum % 10)];
            if (valsum < 0) romdigit = "-" + romdigit;
            if (valsum == 0) romdigit = "ноль";
            return romdigit;
        }
        //Если ввод арабскими цифрами
        return Integer.toString(valsum);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Введите 2 целых числа от 1 до 10 римские или арабские. Разрешены операторы + - * /. Пример: X-V, 10+9");
            if (stringValidation().equals("ошибка валидации")) throw new Exception("Ошибка ввода: Недопустимые символы");
            if (Calculator().equals("выход за диапазон")) throw new Exception("Ошибка ввода: выход за диапазон от 1 до 10");
            System.out.println("Ответ: " + Calculator());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}


