import javax.swing.ImageIcon;

public class Queen extends Piece {
    static int QUEEN_RANK = 9;
    public Queen(int[] vector, String color, ImageIcon image){
        super(vector, color, image, QUEEN_RANK);
    }
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        if((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 0) || ((Math.abs(startPosition[1] - endPosition[1]) == 1) && (Math.abs(startPosition[0] - endPosition[0]) == 0)) || ((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 1))){
            return true;
        }
        return false;
    }
}