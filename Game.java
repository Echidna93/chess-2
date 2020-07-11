import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import javax.xml.ws.Action;

import javafx.event.ActionEvent;


public class Game{

    static ArrayList<Square> initBoard() {
        final String[] letters = new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };
        Board board = new Board();
        String color;
        ArrayList<Square> squares = new ArrayList<Square>();
        int k;
        for (int i = 8; i >= 1; i--) {
            k = 0;
            for (int j = 1; j < 9; j++) {
                color = (((j + i) % 2) == 0) ? "BLACK" : "WHITE";
                board.setBackground(Color.GRAY);
                board.setVisible(true);
                final Square square = new Square(Utils.pointsToVector(i, j), color, letters[k] + i);
                board.add(square);

                // add latest square to squares list
                squares.add(square);

                k++;
            }
        }
        return squares;
    }
    public static void main(String[] args) {

        // grab arraylist containing all of the squares on the board
        // squares holds list of squares
        ArrayList<Square> squares = initBoard();
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        JFrame frame = new JFrame();
        Board board = new Board();
        frame.add(board);
        String path = Paths.get(".").normalize().toAbsolutePath().toString() + "\\imgs\\";
        System.out.println(path + "blackKing.png");
        System.out.println(squares.get(0).id);
        King king = new King(squares.get(1).getCoord(), "black", new ImageIcon(path + "\\blackKing.png"));
        pieces.add(king);
        System.out.println(king.getImage());
        squares.get(1).setIcon(king.getImage());
        squares.get(1).add(king);
        
        //ArrayList<Square> squares = new ArrayList<Square>();
        boolean isStillPlaying = true;
        // initialize board frame
        frame.setVisible(true);
        frame.setTitle("Chess");
        frame.setSize(450, 450);
        
        for(Square square : squares){
            board.add(square);
            square.addMouseListener(new MouseInputListener(){
                @Override
                public void mousePressed(MouseEvent e) {
                    // right mouse click
                    
                    if(e.getButton() == MouseEvent.BUTTON2){
                        square.setIsSelected(false);
                        return;
                    }
                    else{
                        for(Piece piece: pieces){
                            // check if piece is selected
                            if(piece.isSelected){
                                Square startSquare = (Square) piece.getParent();
                                if(piece.isLegalMove(startSquare.getCoord(), square.getCoord())){
                                    startSquare.remove(piece);
                                    startSquare.setIcon(null);
                                    startSquare.revalidate();
                                    square.add(piece);
                                    square.setIcon(piece.getImage());
                                }else{
                                    piece.setIsSelected(false);
                                    startSquare.setIsSelected(false);
                                    square.setIsSelected(false);
                                    System.out.println("illegal move!!");
                                }
                            } 
                        }
                    }
                }
    
                @Override
                public void mouseReleased(MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseEntered(MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseDragged(MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseMoved(MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
    
                }
            });
        }
    }
}