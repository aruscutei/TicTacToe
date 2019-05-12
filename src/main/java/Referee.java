import java.util.Random;

public class Referee {
    private Playable pX;
    private Playable p0;
    private Playboard board;

    public Referee(Playboard board,
                   Playable a, Playable b) {
        this.board = board;
        Random r = new Random();
        if (r.nextBoolean()) {
            this.pX = a;
            a.setSymbol(Symbol.SYMBOL_X);
            this.p0 = b;
            b.setSymbol(Symbol.SYMBOL_0);
        } else {
            this.pX = b;
            b.setSymbol(Symbol.SYMBOL_X);
            this.p0 = a;
            a.setSymbol(Symbol.SYMBOL_0);
        }

    }

    public Symbol start() {

        Playable currentPlayer = pX;

        while (board.isFilled() == false && board.getWinner() == Symbol.SYMBOL_EMPTY) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(board);

            System.out.println(currentPlayer + "este la rand");
            int[] coord = currentPlayer.getCoord();
            //Arbitrul valideaza mutarea cu respect fata de incapsulare
            // - nu se uita in matrice
            //in loc sa se uite abuziv in matrice, acesta intreaba matricea daca este libera casuta
            if (board.isEmpty(coord)) {

                board.fill(coord, currentPlayer.getSymbol());
                System.out.println(board);

                if (currentPlayer == pX)
                    currentPlayer = p0;
                else currentPlayer = pX;

            }
        }
        if (board.getWinner() == Symbol.SYMBOL_0 || board.getWinner() == Symbol.SYMBOL_X) {
            System.out.println("The winner is " + currentPlayer);
        } else
            System.out.println("It is a tie");

return board.getWinner();
    }
}
