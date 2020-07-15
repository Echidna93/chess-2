import javax.swing.ImageIcon;

public class Bishop extends Piece{
    static int BISHOP_RANK = 3;
    public Bishop(int[] vector, String color, ImageIcon image){
        super(vector, color, image, BISHOP_RANK);
    }       
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        if((Math.abs(startPosition[0] - endPosition[0]) == Math.abs(startPosition[1] - endPosition[1]))){
            return true;
        }
        return false;
    }
}