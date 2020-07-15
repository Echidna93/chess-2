import javax.swing.ImageIcon;

public class Castle extends Piece {
    static int CASTLE_RANK = 5;
    public Castle(int[] vector, String color, ImageIcon image){
        super(vector, color, image, CASTLE_RANK);
    }
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        if((Math.abs(startPosition[0] - endPosition[0]) == 0) || (Math.abs(startPosition[1] - endPosition[1]) == 0)){
            return true;
        }
        return false;
    }
}