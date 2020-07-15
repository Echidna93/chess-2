import javax.swing.ImageIcon;

public class Knight extends Piece {
    static int KNIGHT_RANK = 3;
    public Knight(int[] vector, String color, ImageIcon image){
        super(vector, color, image, KNIGHT_RANK);
    }
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
                if((((Math.abs(startPosition[0] - endPosition[0]) == 2) && (Math.abs(startPosition[1] - endPosition[1]) == 1)) || ((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 2)))){
            return true;
        }
        return false;
    }
}