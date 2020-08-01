import javax.swing.ImageIcon;

public class Pawn extends Piece {
    static int PAWN_RANK = 1;
    // keep track of whether or not pawn is attacking target square
    public boolean isAttacking = false;
    public Pawn(int[] vector, String color, ImageIcon image){
        super(vector, color, image, PAWN_RANK);
    }
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        if((this.numMoves == 0) && ((startPosition[1] == endPosition[1]) && (Math.abs(startPosition[0]-endPosition[0]) <= 2))){
            return true;
        }
        else if((this.numMoves >= 1) && (((startPosition[1] == endPosition[1]) && (Math.abs(startPosition[0]-endPosition[0]) == 1)))){
            return true;
        }
        // if pawn is attacking
        else if((getIsAttacking()) && ((Math.abs(startPosition[0]-endPosition[0]) == 1) && (Math.abs(startPosition[1]-endPosition[1]) == 1))){
            return true;
        }
        return false;
 
    }

}