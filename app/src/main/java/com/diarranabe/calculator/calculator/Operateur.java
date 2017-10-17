package com.diarranabe.calculator.calculator;

/**
 * Created by diarranabe on 20/09/2017.
 */

public class Operateur {

    public String operateur;
    public int position = 0;
    public static String[] symbols = {"+", "-", "*", "/", "%"};

    public Operateur(String operateur, int isSymbol) {
        this.operateur = operateur;
        this.position = isSymbol;
    }

    public static boolean isOperateur(String c) {
        for (int i = 0; i < symbols.length; i++) {
            if (c.equals(symbols[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsOperateur(String chaine) {
        for (int i = 0; i < chaine.length(); i++) {
            if (isOperateur("" + chaine.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String lastOperateur(String chaine) {
        String last = "";
        for (int i = 0; i < chaine.length(); i++) {
            if (isOperateur("" + chaine.charAt(i))) {
                last = "" + chaine.charAt(i);
            }
        }
        return last;
    }

    public static int lastOperateurIndex(String chaine) {
        int last = -1;
        for (int i = 0; i < chaine.length(); i++) {
            if (isOperateur("" + chaine.charAt(i))) {
                last = i;
            }
        }
        return last;
    }

    public String operation(String op1, String op2) {
        String res = "";
        int denom = 0;
        try {
            switch (this.operateur) {
                case "+":
                    return "" + (Integer.parseInt(op1) + Integer.parseInt(op2));
                case "-":
                    return "" + (Integer.parseInt(op1) - Integer.parseInt(op2));
                case "*":
                    return "" + (Integer.parseInt(op1) * Integer.parseInt(op2));
                case "/":
                    denom = Integer.parseInt(op2);
                    res = "";
                    try {
                        res = "" + (Integer.parseInt(op1) / denom);
                    } catch (ArithmeticException e) {
                        res = "#erreur(/0)";
                    }
                    return res;
                case "%":
                    denom = Integer.parseInt(op2);
                    try {
                        res = "" + (Integer.parseInt(op1) % denom);
                    } catch (ArithmeticException e) {
                        res = "#erreur(%0)";
                    }
                    return res;
            }
        } catch (RuntimeException e) {
            return "#erreurFatale";
        }
        return res;
    }
}
