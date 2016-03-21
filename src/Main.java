import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
private static String trump;
    public static void main(String[] args) {

        Main m = new Main();

        ArrayList<String> p1 = new ArrayList<String>();
        ArrayList<String> p2 = new ArrayList<String>();
        ArrayList<String> p3 = new ArrayList<String>();
        ArrayList<String> p4 = new ArrayList<String>();


        String[] cards = {
                "s7", "s8", "s9", "s10", "s11", "s12", "s13", "s14"
                , "d7", "d8", "d9", "d10", "d11", "d12", "d13", "d14"
                , "c7", "c8", "c9", "c10", "c11", "c12", "c13", "c14"
                , "h7", "h8", "h9", "h10", "h11", "h12", "h13", "h14"
        };

        ArrayList<String> deck = new ArrayList<String>();

        for (int i = 0; i < 32; i++) {
            deck.add(cards[i]);
        }

        m.divideCards(p1, deck);
        m.divideCards(p2, deck);
        m.divideCards(p3, deck);
        m.divideCards(p4, deck);


        System.out.println("\n-----------------P1's deck-----------------------");
        m.printArray(p1);
        System.out.println("\n\n-----------------P2's deck------------------------");
        m.printArray(p2);
        System.out.println("\n\n-----------------P3's deck------------------------");
        m.printArray(p3);
        System.out.println("\n\n-----------------P4's deck------------------------");
        m.printArray(p4);

        System.out.println("");

        m.play(p1,p2,p3,p4);

    }

    public String selectCard(ArrayList<String> arr) {
        Random rdm = new Random();
        int index;
        String card = "";
        int arrLength = arr.size();
        index = rdm.nextInt(arrLength);
        card = arr.get(index);
        arr.remove(index);

        return card;
    }

    public void divideCards(ArrayList<String> p, ArrayList<String> deck) {
        for (int i = 0; i < 8; i++) {
            p.add(i, selectCard(deck));
        }
    }

    public void printArray(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    public void play(ArrayList<String> p1, ArrayList<String> p2, ArrayList<String> p3, ArrayList<String> p4) {

        ArrayList<String> table = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        int win =0;

        System.out.print("(P1)Enter trump : ");
        trump = sc.next();

        for (int i = 0; i <8 ; i++) {
            System.out.println("Round "+(i+1));
            pickCard(p1,table);
            printArray(table);
            pickCard(p2,table);
            printArray(table);
            pickCard(p3,table);
            printArray(table);
            pickCard(p4,table);
            printArray(table);

            System.out.println("\n-----------------P1's deck-----------------------");
            printArray(p1);
            System.out.println("\n\n-----------------P2's deck------------------------");
            printArray(p2);
            System.out.println("\n\n-----------------P3's deck------------------------");
            printArray(p3);
            System.out.println("\n\n-----------------P4's deck------------------------");
            printArray(p4);
            decideTrump(table);
            System.out.println("");

            table.removeAll(table);
        }


        sc.close();

    }

    public boolean searchCard(String card,ArrayList<String> deck){

        for (int i = 0; i < deck.size() ; i++) {
            if(deck.contains(card)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public String pickCard(ArrayList<String> deck,ArrayList<String> table){
        Scanner sc = new Scanner(System.in);

        System.out.print("Pick a card : ");
        String card = sc.next();
        if(searchCard(card,deck)){
            table.add(card);
            deck.remove(card);
            return card;
        }else{
            System.out.println("Don't cheat mother fucker! No such card in the deck");
        }

        return null;
    }

    public static void decideTrump (ArrayList<String> table) {
        int max=0;
        ArrayList<String> trumpArr = new ArrayList<String>();
//        int [] noTrumpArr=new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).contains(trump)) {
                if (max<table.get(1).charAt(i)){
               max=(int)(table.get(1).charAt(i));
//                table.remove(i);

            }
                System.out.print(max);

//            String[] trumpCards = trumpArr.toArray(new String[trumpArr.size()]);
//            if (trumpArr.size() > 1) {
//                ArrayList<Integer> trumpValue = new ArrayList<Integer>();
//                for (int j = 0; j < trumpArr.size(); j++) {
//                    trumpCards[j].charAt(1)
//                }
//            }
//
//        }
    }



}
    }
}
