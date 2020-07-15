import javax.swing.ImageIcon;

public class Pawn extends Piece {
    static int PAWN_RANK = 1;
    public Pawn(int[] vector, String color, ImageIcon image){
        super(vector, color, image, PAWN_RANK);
    }
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        if((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 0) || ((Math.abs(startPosition[1] - endPosition[1]) == 1) && (Math.abs(startPosition[0] - endPosition[0]) == 0)) || ((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 1))){
            return true;
        }
        return false;
    }
}