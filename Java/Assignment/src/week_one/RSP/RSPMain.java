package week_one.RSP;

public class RSPMain {
    public static void main(String[] args) {
        RSP player1 = new RSP();
        RSP player2 = new RSP();

        RSP.Play(player1.Choice(), player2.Choice());
    }
}
