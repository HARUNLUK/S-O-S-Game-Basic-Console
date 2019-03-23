package sosgame;

import java.util.Scanner;

public class Sosgame {

    static byte playerOnePoint = 0, playerTwoPoint = 0;
    static String tictactoe[][] = new String[9][15];
    static boolean[][] CrossKeeper = new boolean[tictactoe.length - 2][tictactoe[0].length - 2];
    static boolean[][] LineKeeper = new boolean[tictactoe.length][tictactoe[0].length - 2];
    static boolean[][] ColumnKeeper = new boolean[tictactoe.length - 2][tictactoe[0].length];
    static boolean[][] CrossKeeperTwo = new boolean[tictactoe.length - 2][tictactoe[0].length-2];
    static String Language;
    static boolean tr, eng;

    static void ticTacToeDraw(String array[][]) {
        byte indexOne = 0, indexTwo = 0;
        System.out.print("  | ");
        for (int i = 1; i < array[0].length + 1; i++) {
            if (i > 9) {
                System.out.print(+i + "| ");
            } else {
                System.out.print(+i + " | ");
            }
        }
        System.out.println();
        byte lineCount = 1;
        for (int i = 0; i < array.length * 2 + 1; i++) {
            if (i % 2 == 1) {
                if (lineCount > 9) {
                    System.out.print(lineCount);
                    lineCount++;
                } else {
                    System.out.print(" " + lineCount);
                    lineCount++;
                }
            }
            for (int j = 0; j < array[0].length * 2 + 1; j++) {
                if (i % 2 == 1) {
                    if (j % 2 == 1) {
                        System.out.print(" " + array[indexOne][indexTwo] + " ");
                        indexTwo++;
                    } else {
                        System.out.print("|");
                    }
                    if (i == (array.length * 2) / 2 - 1 && j == array[0].length * 2) {
                        System.out.print("            Birinci Oyuncu Puan : " + playerOnePoint);
                    }
                    if (i == (array.length * 2) / 2 + 1 && j == array[0].length * 2) {
                        System.out.print("            İkinci Oyuncu Puan  : " + playerTwoPoint);
                    }
                } else {
                    System.out.print("--");
                    if (i == (array.length * 2) / 2 - 1 && j == array[0].length * 2) {
                        System.out.print("            Birinci Oyuncu Puan : " + playerOnePoint);
                    }
                    if (i == (array.length * 2) / 2 + 1 && j == array[0].length * 2) {
                        System.out.print("            İkinci Oyuncu Puan  : " + playerTwoPoint);
                    }
                }
            }
            indexTwo = 0;
            if (i % 2 == 1) {
                indexOne++;
            }
            System.out.println();
        }
    }

    static boolean whoWin(String xArray[][]) {
        boolean pointUp = false;
        for (byte i = 0; i < tictactoe.length; i++) {
            for (byte j = 0; j < tictactoe[0].length - 2; j++) {
                if (LineKeeper[i][j]) {
                    continue;
                } else {
                    if (tictactoe[i][j].equalsIgnoreCase("s") && tictactoe[i][j + 1].equalsIgnoreCase("o") && tictactoe[i][j + 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        LineKeeper[i][j] = true;

                    }
                }
            }
        }
        for (byte i = 0; i < tictactoe.length - 2; i++) {
            for (byte j = 0; j < tictactoe[0].length; j++) {
                if (ColumnKeeper[i][j]) {
                    continue;
                } else {
                    if (tictactoe[i][j].equalsIgnoreCase("s") && tictactoe[i + 1][j].equalsIgnoreCase("o") && tictactoe[i + 2][j].equalsIgnoreCase("s")) {
                        pointUp = true;
                        ColumnKeeper[i][j] = true;
                    }
                }
            }
        }
        for (byte i = 0; i < tictactoe.length - 2; i++) {
            for (byte j = 0; j < tictactoe[0].length - 2; j++) {
                if (CrossKeeper[i][j]) {
                    continue;
                } else {
                    if (tictactoe[i][j].equalsIgnoreCase("s") && tictactoe[i + 1][j + 1].equalsIgnoreCase("o") && tictactoe[i + 2][j + 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        CrossKeeper[i][j] = true;
                    }
                }
            }
        }
        for (byte i = 0; i < tictactoe.length-2; i++) {
            for (byte j = 2; j < tictactoe[0].length; j++) {
                if (CrossKeeperTwo[i][j-2]) {
                    continue;
                } else {
                    if (tictactoe[i][j].equalsIgnoreCase("s") && tictactoe[i + 1][j -1].equalsIgnoreCase("o") && tictactoe[i + 2][j-2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        CrossKeeperTwo[i][j-2] = true;
                    }
                }
            }
        }
        return pointUp;
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < tictactoe.length; i++) {
            for (int j = 0; j < tictactoe[i].length; j++) {
                tictactoe[i][j] = ".";
            }
        }

        System.out.println("ENG/TR");
        Language = input.nextLine();
        while ((Language.equalsIgnoreCase("TR") || Language.equalsIgnoreCase("ENG")) == false) {
            System.out.println("YANLIŞ KOMUT / WRONG COMMAND");
            Language = input.nextLine();
        }
        if (Language.equalsIgnoreCase("TR")) {
            tr = true;
        }
        if (Language.equalsIgnoreCase("ENG")) {
            eng = true;
        }
        if (tr) {
            System.out.println("BU BİR S-O-S OYUNUDUR");
            System.out.println("SIRAYLA OYUNCULAR GİRMEK İSTEDİĞİ KOORDİNATA GİRMEK İSTEDİĞİ SEMBOLÜ GİRER");
            System.out.println("S O S 'u DİKEY , YATAY yada ÇAPRAZ YAPAN PUAN KAZANIR");
            System.out.println("SIRASI GELEN KOORDİNAT VE SEMBOL GİREBİLİR");
            System.out.println("ÖRNEK : \n1 2 \nS \nVEYA \n3 4 \nO");
        } else {
            System.out.println("THİS İS A S-0-S GAME");
            System.out.println("PLAYER ENTERs THE COORDİNATE AND THE SYMBOL THEY WANTS IN ORDER");
            System.out.println("WHO MAKES S O S AS VERTİCAL , HORIZONAL OR CROSS EARNS THE POINT");
            System.out.println("ONE WHO HAS THE TURN CAN ENTER A CORDİNATE AND A SYMBOL");
            System.out.println("EXAMPLE : \n1 2 \nS \nVEYA \n3 4 \nO");
        }
        int coordinateOne, coordinateTwo;
        String symbolOne = "", symbolTwo = "";
        ticTacToeDraw(tictactoe);
        for (int i = 0; i < tictactoe.length * tictactoe[0].length; i++) {
            if (i % 2 == 0) {
                if (tr) {
                    System.out.println("SIRA BİRİNCİ OYUNUCUDA");
                } else {
                    System.out.println("PLAYER ONE'TURN");
                }
                coordinateOne = input.nextInt() - 1;
                while (coordinateOne > tictactoe.length - 1 || coordinateOne < 0) {
                    if (tr) {
                        System.out.println("1 ile " + tictactoe.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + tictactoe.length);
                    }
                    coordinateOne = input.nextInt() - 1;
                }
                coordinateTwo = input.nextInt() - 1;
                while (coordinateTwo > tictactoe[0].length - 1 || coordinateTwo < 0) {
                    if (tr) {
                        System.out.println("1 ile " + tictactoe.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + tictactoe[0].length);
                    }
                    coordinateTwo = input.nextInt() - 1;
                }
                symbolOne = input.nextLine();
                while ((symbolOne.equalsIgnoreCase("S") || symbolOne.equalsIgnoreCase("O")) == false) {
                    if (tr) {
                        System.out.println("SEMBOL GİRİNİZ");
                    } else {
                        System.out.println("ENTER THE SYMBOL");
                    }
                    symbolOne = input.nextLine();
                }
                if (tictactoe[coordinateOne][coordinateTwo].equalsIgnoreCase("s") || tictactoe[coordinateOne][coordinateTwo].equalsIgnoreCase("O")) {
                    if (tr) {
                        System.out.println("DENEDİĞİNİZ KOORDİNAT DOLU LÜTFEN BAŞKA KOORDİNAT DENEYİNİZ");
                    } else {
                        System.out.println("THE COORDİNATE YOU TRİED İS FULL PLEASE TRY ANOTHER COORDİNATE");
                    }
                    i--;
                } else {
                    tictactoe[coordinateOne][coordinateTwo] = symbolOne;
                    if (whoWin(tictactoe)) {
                        playerOnePoint++;
                        if (tr) {
                            System.out.println("S O S OLDU DEVAM");
                        } else {
                            System.out.println("MAKED S O S KEEP GOİNG");
                        }
                        i--;
                    }
                }
            } else {
                if (tr) {
                    System.out.println("SIRA İKİNCİ OYUNUCUDA");
                } else {
                    System.out.println("PLAYER TWO'TURN");
                }
                coordinateOne = input.nextInt() - 1;
                while (coordinateOne > tictactoe.length - 1 || coordinateOne < 0) {
                    if (tr) {
                        System.out.println("1 ile " + tictactoe.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + tictactoe.length);
                    }
                    coordinateOne = input.nextInt() - 1;
                }
                coordinateTwo = input.nextInt() - 1;
                while (coordinateTwo > tictactoe[0].length - 1 || coordinateTwo < 0) {
                    if (tr) {
                        System.out.println("1 ile " + tictactoe.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + tictactoe[0].length);
                    }
                    coordinateTwo = input.nextInt() - 1;
                }
                symbolTwo = input.nextLine();
                while ((symbolTwo.equalsIgnoreCase("S") || symbolTwo.equalsIgnoreCase("O")) == false) {
                    if (tr) {
                        System.out.println("SEMBOL GİRİNİZ");
                    } else {
                        System.out.println("ENTER SYMBOL");
                    }
                    symbolTwo = input.nextLine();
                }
                if (tictactoe[coordinateOne][coordinateTwo].equalsIgnoreCase("S") || tictactoe[coordinateOne][coordinateTwo].equalsIgnoreCase("O")) {
                    if (tr) {
                        System.out.println("BU KOORDİNAT DOLU LÜTFEN BAŞKA KOORDİNAT DENEYİNİZ");
                    } else {
                        System.out.println("THİS COORDİNATE İS FULL PLEASE TRY ANOTHER COORDİNATE");
                    }
                    i--;
                } else {
                    tictactoe[coordinateOne][coordinateTwo] = input.nextLine();
                    if (whoWin(tictactoe)) {
                        playerTwoPoint++;
                        if (tr) {
                            System.out.println("S O S OLDU DEVAM");
                        } else {
                            System.out.println("MAKED S O S KEEP GOİNG");
                        }
                        i--;
                    }
                }
            }
            ticTacToeDraw(tictactoe);
        }
        if (playerOnePoint > playerTwoPoint) {
            if (tr) {
                System.out.println("BİRİNCİ OYUNUCU KAZANDI");
            } else {
                System.out.println("PLAYER ONE İS WON");
            }
        } else {
            if (tr) {
                System.out.println("İKİNCİ OYUNUCU KAZANDI");
            } else {
                System.out.println("PLAYER TWO İS WON");
            }
        }
    }
}
