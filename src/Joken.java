import java.util.Random;
import java.util.Scanner;

public record Joken(
    Player user,
    Player IA,
    int rounds
) {

    public void toPlay() {
        System.out.println("\n XXXXXX  SEJA BEM-VINDO(A), " + user.getName() + " XXXXXX\n");

        for(int i = 1; i<=rounds; i++){
        int choiceUser = choiceUser();
        if(choiceUser < 1 || choiceUser > 3) {
            System.out.println("JOGADA INVÁLIDA!!! (SELECIONE: 1, 2 OU 3)");
            System.out.println("PONTO PARA IA");
            IA.incrementScore();
        }
        int choiceIA = choiceIA();

        System.out.println(choiceUser + " X " + choiceIA);

        int result = choiceUser - choiceIA;
        winnerRound(result);

        }
    }
    public void finalResult(){
       int finalScoreUser = user.getScore();
       int finalScoreIA = IA.getScore();

        System.out.println("PLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getName() + " " + IA.getScore());

        if(finalScoreUser == finalScoreIA){
            System.out.println("**********************************");
            System.out.println();
            System.out.println("\t\t EMPATE");
            System.out.println();
            System.out.println("**********************************");

        } else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
            System.out.println("**********************************");
            System.out.println();
            System.out.println("\t\t VENCEDOR = " + finalWinner.toUpperCase());
            System.out.println();
            System.out.println("**********************************");
        }
    }
    private void winnerRound(int result){
        String winnerRound;
        if(result==0){
            winnerRound = "EMPATE!";
        } else {
            if(result == -1 || result == 2){
                IA.incrementScore();
                winnerRound = IA.getName();
            } else{
                user.incrementScore();
                winnerRound = user.getName();
            }
        }
    }
    private int choiceIA(){
        Random random = new Random();
        return random.nextInt(3)+ 1;
    }
    private int choiceUser(){
        Scanner read = new Scanner(System.in);

        System.out.println("1 - PEDRA");
        System.out.println("2 - PAPEL");
        System.out.println("3 - TESOURA");

        System.out.print("Informe sua Jogada: ");

        return read.nextInt();


    }

}
