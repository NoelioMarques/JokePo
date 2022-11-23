import java.util.Scanner;

public class Main {
    public static Joken startGame() {
        System.out.println("XXXXX  JO_KEN_PO  XXXXX");
        Scanner read = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String playerName = read.next().toUpperCase();

        Player user = new Player(playerName);
        Player IA = new Player("IA");

        System.out.print(playerName + ", Informe quantos rounds: ");
        int rounds = read.nextInt();

        return new Joken(user, IA, rounds);

    }

    public static void main(String[] args) {
        Joken joken = startGame();
        joken.toPlay();
        joken.finalResult();

    }

}