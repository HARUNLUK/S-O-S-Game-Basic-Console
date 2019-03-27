package sosgame;

import java.util.Scanner;

public class Sosgame {

    static byte playerOnePoint = 0, playerTwoPoint = 0;
    static String sosMatrix[][] = new String[9][15];
    static boolean[][] CrossKeeper = new boolean[sosMatrix.length - 2][sosMatrix[0].length - 2];
    static boolean[][] LineKeeper = new boolean[sosMatrix.length][sosMatrix[0].length - 2];
    static boolean[][] ColumnKeeper = new boolean[sosMatrix.length - 2][sosMatrix[0].length];
    static boolean[][] CrossKeeperTwo = new boolean[sosMatrix.length - 2][sosMatrix[0].length - 2];
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
                        if (tr) {
                            System.out.print("            Birinci OYUNCU PUAN : " + playerOnePoint);
                        } else {
                            System.out.print("            PLAYER ONE'S POİNT : " + playerOnePoint);
                        }
                    }
                    if (i == (array.length * 2) / 2 + 1 && j == array[0].length * 2) {
                        if (tr) {
                            System.out.print("            İKİNCİ OYUNCU PUAN : " + playerTwoPoint);
                        } else {
                            System.out.print("            PLAYER TWO'S POİNT : " + playerTwoPoint);
                        }
                    }
                } else {
                    System.out.print("--");
                    if (i == (array.length * 2) / 2 - 1 && j == array[0].length * 2) {
                        if (tr) {
                            System.out.print("            Birinci OYUNCU PUAN : " + playerOnePoint);
                        } else {
                            System.out.print("            PLAYER ONE'S POİNT : " + playerOnePoint);
                        }
                    }
                    if (i == (array.length * 2) / 2 + 1 && j == array[0].length * 2) {
                        if (tr) {
                            System.out.print("            İKİNCİ OYUNCU PUAN : " + playerTwoPoint);
                        } else {
                            System.out.print("            PLAYER TWO'S POİNT : " + playerTwoPoint);
                        }
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

    static boolean whoWinPlayerOne(String xArray[][]) {
        boolean pointUp = false;
        for (byte i = 0; i < sosMatrix.length; i++) {
            for (byte j = 0; j < sosMatrix[0].length - 2; j++) {
                if (LineKeeper[i][j]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i][j + 1].equalsIgnoreCase("o") && sosMatrix[i][j + 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerOnePoint++;
                        LineKeeper[i][j] = true;

                    }
                }
            }
        }
        for (byte i = 0; i < sosMatrix.length - 2; i++) {
            for (byte j = 0; j < sosMatrix[0].length; j++) {
                if (ColumnKeeper[i][j]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i + 1][j].equalsIgnoreCase("o") && sosMatrix[i + 2][j].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerOnePoint++;
                        ColumnKeeper[i][j] = true;
                    }
                }
            }
        }
        for (byte i = 0; i < sosMatrix.length - 2; i++) {
            for (byte j = 0; j < sosMatrix[0].length - 2; j++) {
                if (CrossKeeper[i][j]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i + 1][j + 1].equalsIgnoreCase("o") && sosMatrix[i + 2][j + 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerOnePoint++;
                        CrossKeeper[i][j] = true;
                    }
                }
            }
        }
        for (byte i = 0; i < sosMatrix.length - 2; i++) {
            for (byte j = 2; j < sosMatrix[0].length; j++) {
                if (CrossKeeperTwo[i][j - 2]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i + 1][j - 1].equalsIgnoreCase("o") && sosMatrix[i + 2][j - 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerOnePoint++;
                        CrossKeeperTwo[i][j - 2] = true;
                    }
                }
            }
        }
        return pointUp;
    }

    static boolean whoWinPlayerTwo(String xArray[][]) {
        boolean pointUp = false;
        for (byte i = 0; i < sosMatrix.length; i++) {
            for (byte j = 0; j < sosMatrix[0].length - 2; j++) {
                if (LineKeeper[i][j]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i][j + 1].equalsIgnoreCase("o") && sosMatrix[i][j + 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerTwoPoint++;
                        LineKeeper[i][j] = true;

                    }
                }
            }
        }
        for (byte i = 0; i < sosMatrix.length - 2; i++) {
            for (byte j = 0; j < sosMatrix[0].length; j++) {
                if (ColumnKeeper[i][j]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i + 1][j].equalsIgnoreCase("o") && sosMatrix[i + 2][j].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerTwoPoint++;
                        ColumnKeeper[i][j] = true;
                    }
                }
            }
        }
        for (byte i = 0; i < sosMatrix.length - 2; i++) {
            for (byte j = 0; j < sosMatrix[0].length - 2; j++) {
                if (CrossKeeper[i][j]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i + 1][j + 1].equalsIgnoreCase("o") && sosMatrix[i + 2][j + 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerTwoPoint++;
                        CrossKeeper[i][j] = true;
                    }
                }
            }
        }
        for (byte i = 0; i < sosMatrix.length - 2; i++) {
            for (byte j = 2; j < sosMatrix[0].length; j++) {
                if (CrossKeeperTwo[i][j - 2]) {
                    continue;
                } else {
                    if (sosMatrix[i][j].equalsIgnoreCase("s") && sosMatrix[i + 1][j - 1].equalsIgnoreCase("o") && sosMatrix[i + 2][j - 2].equalsIgnoreCase("s")) {
                        pointUp = true;
                        playerTwoPoint++;
                        CrossKeeperTwo[i][j - 2] = true;
                    }
                }
            }
        }
        return pointUp;
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < sosMatrix.length; i++) {
            for (int j = 0; j < sosMatrix[i].length; j++) {
                sosMatrix[i][j] = ".";
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
            System.out.println("PLAYER ENTERS WHERE THE COORDİNATE AND THE SYMBOL THEY WANTS IN ORDER");
            System.out.println("WHO MAKES S O S AS VERTİCAL , HORIZONAL OR CROSS EARNS THE POINT");
            System.out.println("WHO ONE IN ORDER CAN ENTER COORDİNATE AND SYMBOL");
            System.out.println("EXAMPLE : \n1 2 \nS \nVEYA \n3 4 \nO");
        }
        int coordinateOne, coordinateTwo;
        String symbolOne = "", symbolTwo = "";
        ticTacToeDraw(sosMatrix);
        for (int i = 0; i < sosMatrix.length * sosMatrix[0].length; i++) {
            if (i % 2 == 0) {
                if (tr) {
                    System.out.println("SIRA BİRİNCİ OYUNUCUDA");
                } else {
                    System.out.println("PLAYER ONE'TURN");
                }
                coordinateOne = input.nextInt() - 1;
                while (coordinateOne > sosMatrix.length - 1 || coordinateOne < 0) {
                    if (tr) {
                        System.out.println("1 ile " + sosMatrix.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + sosMatrix.length);
                    }
                    coordinateOne = input.nextInt() - 1;
                }
                coordinateTwo = input.nextInt() - 1;
                while (coordinateTwo > sosMatrix[0].length - 1 || coordinateTwo < 0) {
                    if (tr) {
                        System.out.println("1 ile " + sosMatrix.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + sosMatrix[0].length);
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
                if (sosMatrix[coordinateOne][coordinateTwo].equalsIgnoreCase("s") || sosMatrix[coordinateOne][coordinateTwo].equalsIgnoreCase("O")) {
                    if (tr) {
                        System.out.println("DENEDİĞİNİZ KOORDİNAT DOLU LÜTFEN BAŞKA KOORDİNAT DENEYİNİZ");
                    } else {
                        System.out.println("THE COORDİNATE YOU TRİED İS FULL PLEASE TRY ANOTHER COORDİNATE");
                    }
                    i--;
                } else {
                    sosMatrix[coordinateOne][coordinateTwo] = symbolOne;
                    if (whoWinPlayerOne(sosMatrix)) {
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
                while (coordinateOne > sosMatrix.length - 1 || coordinateOne < 0) {
                    if (tr) {
                        System.out.println("1 ile " + sosMatrix.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + sosMatrix.length);
                    }
                    coordinateOne = input.nextInt() - 1;
                }
                coordinateTwo = input.nextInt() - 1;
                while (coordinateTwo > sosMatrix[0].length - 1 || coordinateTwo < 0) {
                    if (tr) {
                        System.out.println("1 ile " + sosMatrix.length + " arası giriniz");
                    } else {
                        System.out.println("PLEASE ENTER A NUMBER BETWEEN 1 AND " + sosMatrix[0].length);
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
                if (sosMatrix[coordinateOne][coordinateTwo].equalsIgnoreCase("S") || sosMatrix[coordinateOne][coordinateTwo].equalsIgnoreCase("O")) {
                    if (tr) {
                        System.out.println("BU KOORDİNAT DOLU LÜTFEN BAŞKA KOORDİNAT DENEYİNİZ");
                    } else {
                        System.out.println("THİS COORDİNATE İS FULL PLEASE TRY ANOTHER COORDİNATE");
                    }
                    i--;
                } else {
                    sosMatrix[coordinateOne][coordinateTwo] = symbolTwo;
                    if (whoWinPlayerTwo(sosMatrix)) {
                        if (tr) {
                            System.out.println("S O S OLDU DEVAM");
                        } else {
                            System.out.println("MAKED S O S KEEP GOİNG");
                        }
                        i--;
                    }
                }
            }
            ticTacToeDraw(sosMatrix);
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
