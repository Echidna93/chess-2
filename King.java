import javax.swing.ImageIcon;
public class King extends Piece{
    public King(int[] vector, String color, ImageIcon image){
        super(vector, color, image);
    }
    @Override
    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        if((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 0) || ((Math.abs(startPosition[1] - endPosition[1]) == 1) && (Math.abs(startPosition[0] - endPosition[0]) == 0)) || ((Math.abs(startPosition[0] - endPosition[0]) == 1) && (Math.abs(startPosition[1] - endPosition[1]) == 1))){
            return true;
        }
        return false;
    }
}