import java.awt.Color;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
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

    /**
     * Matches a square to exisiting list of squares by ID
     * 
     * @param squares (required) squares ArrayList of Square objects
     * @param id (required) id of square to match
     * 
     * <p> note that returns default square of id null if square id happens to not be found in the list 
     * 
     * @author Alexander Jack
     * 
     */

    static Square getSquareById(ArrayList<Square> squares, String id){
        for(Square square: squares){
            if(id.equals(square.getId()))
                return square;
        }
        return new Square();
    }

/**
 * 
 * @param args
*/

static void setPieces(ArrayList<Square> squares, String path) {
    String[] initialPositions = new String[] { "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "b7", "c7", "d7",
            "e7", "f7", "g7", "h7", "a1", "b2", "c2", "d2", "e2", "f2", "g2", "h2", "a1", "b1", "c1", "d1", "e1", "f1",
            "g1", "h1" };
}

/**
 * Initializes an arraylist of type Piece, correlating to each piece on the
 * board
 * 
 * <p>
 * take in path of directory img, which houses the piece pngs
 * 
 * @return ArrayList<Piece>
 */

ArrayList<Piece> getPieces(Path path) {
    // initialize new array of strings of size 32; one per chess piece
    String[] pieceName = new String[] { "blackPawn", "blackCastle", "blackKnight", "blackBishop", "blackQueen",
            "blackKing", "whitePawn", "whiteCastle", "whiteKnight", "whiteBishop", "WhiteQueen", "whiteKing" };
    return pieces;
}

public static void main(String[] args) {

    // grab arraylist containing all of the squares on the board
    // squares holds list of squares
    ArrayList<Square> squares = initBoard();
    ArrayList<Piece> pieces = new ArrayList<Piece>();

    JFrame frame = new JFrame();

    MenuBar menuBar = new MenuBar();
    frame.setJMenuBar(menuBar);

    Board board = new Board();
    frame.add(board);
    String path = Paths.get(".").normalize().toAbsolutePath().toString() + "\\imgs\\";
    System.out.println(path + "blackKing.png");
    System.out.println(squares.get(0).id);

    
    Square a1 = new Square();
    a1 = getSquareById(squares, "a1");
    Queen blackQueen = new Queen(a1.getCoord(), "black", new ImageIcon(path + "\\blackQueen.png"));
    a1.setIcon(blackQueen.getImage());
    a1.add(blackQueen);

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
                                    piece.incNumMoves();
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