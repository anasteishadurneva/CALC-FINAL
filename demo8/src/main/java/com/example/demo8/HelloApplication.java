package com.example.demo8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Main result = new Main();
            System.out.println("Привет,это калькулятор, вот вот я решу твой пример, но для начала введи 1, чтобы приступить");
            String primer = input.nextLine();
            String answer = result.calc(primer);
            System.out.println("Ответ:\n " + answer);
        }

        public static String calc(String input) {
            Scanner in = new Scanner(System.in);
            out.print("введите пример: ");
            String primer = in.nextLine();
            primer = primer.replaceAll("\\s+", "");
            String a = "";
            String b = "";
            int itog = 0;
            String itogRim = "";
            int arabChet = 0;
            int rimChet = 0;
            int A = 0;
            int B = 0;
            int p = 0;
            char[] mas;
            String result ="";
            // ПРОВЕРКА
            for (int i = 0; i < primer.length(); i++) {
                for (char c : mas = primer.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        if ("(!@#$%^&)_=<>?.,|~".indexOf(primer.charAt(i)) > 0) {
                            out.println("ошибка, недопустимые знаки");
                        }
                    }
                }
            }
            program:
            {
                int pluse = primer.indexOf("+");
                int min = primer.indexOf("-");
                int ym = primer.indexOf("*");
                int del = primer.indexOf("/");

                if (pluse >= 0 || min >= 0 || ym >= 0 || del >= 0) {
                    if (pluse >= 0) {
                        p = pluse;
                    }
                    if (min >= 0) {
                        p = min;
                    }
                    if (ym >= 0) {
                        p = ym;
                    }
                    if (del >= 0) {
                        p = del;
                    }
                    for (int i = 0; i < p; i++) {
                        a = a + primer.charAt(0);
                        primer = primer.substring(1);
                    }
                    primer = primer.substring(1);
                    b = primer;
                    on:
                    {
                        for (char c : mas = a.toCharArray()) {
                            if (Character.isDigit(c)) {
                                arabChet = arabChet + 1;
                                A = Integer.parseInt(a);
                                if (A > 10 || A < 0) {
                                    out.println("ошибка,число больше 10 или меньше 0");
                                    break program;
                                }
                                break on;
                            }
                            if (!Character.isDigit(c)) {
                                rimChet = rimChet + 1;
                                if ("IV".equals(a)) {
                                    A = 4;
                                    break on;
                                } else if ("IX".equals(a)) {
                                    A = 9;
                                    break on;
                                } else if (c == 'X') {
                                    A = A + 10;
                                } else if (c == 'V') {
                                    A = A + 5;
                                } else if (c == 'I') {
                                    A = A + 1;
                                } else {
                                    out.println("ошибка не правильный символ, или число должно быть в пределах [0;10] или [I;X] ");
                                    break program;
                                }
                            }
                        }

                    }
                    off:
                    {
                        for (char c : mas = b.toCharArray()) {

                            if (Character.isDigit(c)) {
                                arabChet = arabChet + 1;
                                if (arabChet < 2) {
                                    out.println("ошибка, несоответствие типов");
                                    break program;
                                }
                                B = Integer.parseInt(b);
                                if (B > 10) {
                                    out.println("ошибка,число больше 10");
                                    break program;
                                }
                                break off;
                            }

                            if (!Character.isDigit(c)) {
                                rimChet = rimChet + 1;
                                if (rimChet < 2) {
                                    out.println("ошибка, несоответствие типов");
                                    break program;
                                }
                                if ("IV".equals(b)) {
                                    B = 4;
                                    break off;
                                } else if ("IX".equals(b)) {
                                    B = 9;
                                    break off;
                                } else if (c == 'X') {
                                    B = B + 10;
                                } else if (c == 'V') {
                                    B = B + 5;
                                } else if (c == 'I') {
                                    B = B + 1;
                                } else {
                                    out.println("ошибка не правильный символ, или число должно быть в пределах [0;10] или [I;X] ");
                                    break program;
                                }
                            }
                        }
                    }
                    if (pluse >= 0) {
                        itog = A + B;
                    }
                    if (min >= 0) {
                        itog = A - B;
                    }
                    if (ym >= 0) {
                        itog = A * B;
                    }
                    if (del >= 0) {
                        itog = A / B;
                    }
                    if (arabChet >= 2) {
                        result= String.valueOf(itog);
                    }
                }
                if (rimChet >= 2) {
                    if (itog <= 0) {
                        out.println("ошибка, римские числа не могут быть 0 или отрицательными");
                        break program;
                    }
                    if (itog % 10 >= 0) {
                        if (itog % 10 == 1) {
                            itogRim = itogRim + "I";
                        }
                        if (itog % 10 == 2) {
                            itogRim = itogRim + "II";
                        }
                        if (itog % 10 == 3) {
                            itogRim = itogRim + "III";
                        }
                        if (itog % 10 == 4) {
                            itogRim = itogRim + "IV";
                        }
                        if (itog % 10 == 5) {
                            itogRim = itogRim + "V";
                        }
                        if (itog % 10 == 6) {
                            itogRim = itogRim + "VI";
                        }
                        if (itog % 10 == 7) {
                            itogRim = itogRim + "VII";
                        }
                        if (itog % 10 == 8) {
                            itogRim = itogRim + "VIII";
                        }
                        if (itog % 10 == 9) {
                            itogRim = itogRim + "IX";
                        }

                    }
                    itog = itog / 10;
                    if (itog % 10 >= 0) {
                        if (itog % 10 == 1) {
                            itogRim = "X" + itogRim;
                        }
                        if (itog % 10 == 2) {
                            itogRim = "XX" + itogRim;
                        }
                        if (itog % 10 == 3) {
                            itogRim = "XXX" + itogRim;
                        }
                        if (itog % 10 == 4) {
                            itogRim = "XL" + itogRim;
                        }
                        if (itog % 10 == 5) {
                            itogRim = "L" + itogRim;
                        }
                        if (itog % 10 == 6) {
                            itogRim = "LX" + itogRim;
                        }
                        if (itog % 10 == 7) {
                            itogRim = "LXX" + itogRim;
                        }
                        if (itog % 10 == 8) {
                            itogRim = "LXXX" + itogRim;
                        }
                        if (itog % 10 == 9) {
                            itogRim = "XC" + itogRim;
                        }
                        if (itog / 10 == 1) {
                            itogRim = "C";
                        }
                    }
                    result=itogRim;
                }
            }
            return result;
        }
    }
}