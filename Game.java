
/**
 * <p>Represents the mechanics of the game
 *  
 * @author Alexander Jack
 */

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
                color = (((j + i) % 2) == 0) ? "GREY" : "WHITE";
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
     * @param source
     * @param target
     * @return
     */

    static boolean isAttacking(Square source, Square target){
        if(target.isOccupied){
            return true;
        }
        return false;
    }


/**
 * 
 * @param args
*/
/*
static void setPieces(ArrayList<Square> squares, String path) {
    String[] initialPositions = new String[] {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "b7", "c7", "d7",
            "e7", "f7", "g7", "h7", "a1", "b2", "c2", "d2", "e2", "f2", "g2", "h2", "a1", "b1", "c1", "d1", "e1", "f1",
            "g1", "h1" };

    for(int i = 0; i < initialPositions.length; i ++){
        // black pawns
        if(initialPositions[i].contains("7")){
            Square s = getSquareById(squares, initialPositions[i]);
            String pieceName = "blackPawn" + initialPositions[i];
            Square  = 
        }
    }
    
}
*/

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

static Piece getPieceByComponentList(Square square){
    Component[] components = square.getComponents();
    for(Component component: components){
        System.out.println("this is the component: " + component);
        if(component instanceof Piece){
            return (Piece) component;
        }
    }
    return null;
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
    
    // set pieces 

    // white pieces
    String path = Paths.get(".").normalize().toAbsolutePath().toString() + "\\imgs\\";

    Square a1 = getSquareById(squares, "a1");
    Square b1 = getSquareById(squares, "b1");
    Square c1 = getSquareById(squares, "c1");
    Square d1 = getSquareById(squares, "d1");
    Square e1 = getSquareById(squares, "e1");
    Square f1 = getSquareById(squares, "f1");
    Square g1 = getSquareById(squares, "g1");
    Square h1 = getSquareById(squares, "h1");

    // white pawns
    Square a2 = getSquareById(squares, "a2");
    Square b2 = getSquareById(squares, "b2");
    Square c2 = getSquareById(squares, "c2");
    Square d2 = getSquareById(squares, "d2");
    Square e2 = getSquareById(squares, "e2");
    Square f2 = getSquareById(squares, "f2");
    Square g2 = getSquareById(squares, "g2");
    Square h2 = getSquareById(squares, "h2");
    
    // black pawns
    Square a7 = getSquareById(squares, "a7");
    Square b7 = getSquareById(squares, "b7");
    Square c7 = getSquareById(squares, "c7");
    Square d7 = getSquareById(squares, "d7");
    Square e7 = getSquareById(squares, "e7");
    Square f7 = getSquareById(squares, "f7");
    Square g7 = getSquareById(squares, "g7");
    Square h7 = getSquareById(squares, "h7");
    
    // black pieces
    Square a8 = getSquareById(squares, "a8");
    Square b8 = getSquareById(squares, "b8");
    Square c8 = getSquareById(squares, "c8");
    Square d8 = getSquareById(squares, "d8");
    Square e8 = getSquareById(squares, "e8");
    Square f8 = getSquareById(squares, "f8");
    Square g8 = getSquareById(squares, "g8");
    Square h8 = getSquareById(squares, "h8");
    
    // instantiate black pieces
    Queen blackQueen = new Queen(f7.getCoord(), "black", new ImageIcon(path + "\\blackQueen.png"));
    King blackKing = new King(squares.get(1).getCoord(), "black", new ImageIcon(path + "\\blackKing.png"));
    Pawn blackPawna7 = new Pawn(a7.getCoord(), "black", new ImageIcon(path + "\\blackPawn.png"));
    Castle blackCastlea8 = new Castle(a8.getCoord(), "black", new ImageIcon(path + "\\blackCastle.png"));
    Knight blackKnightd8 = new Knight(d8.getCoord(), "black", new ImageIcon(path + "\\blackKnight.png"));
    Bishop blackBishoph8 = new Bishop(h8.getCoord(), "black", new ImageIcon(path + "\\blackBishop.png"));


    // add black piece class to square
    a8.add(blackCastlea8);
    a8.setIsOccupied(true);    
    a7.add(blackPawna7);
    a7.setIsOccupied(true);
    h8.add(blackBishoph8);
    h8.setIsOccupied(true);
    d8.add(blackKnightd8);
    a2.setIsOccupied(true);
    a1.add(blackQueen);
    a1.setIsOccupied(true);
    f7.add(blackPawna7);
    f7.setIsOccupied(true);
    squares.get(1).add(blackKing);
        
    // set the images
    squares.get(1).setIcon(blackKing.getImage());
    a1.setIcon(blackQueen.getImage());
    d8.setIcon(blackKnightd8.getImage());
    a7.setIcon(blackPawna7.getImage());
    a8.setIcon(blackCastlea8.getImage());
    h8.setIcon(blackBishoph8.getImage());
    a7.setIcon(blackPawna7.getImage());

    // add pieces to pieces array
    pieces.add(blackQueen);
    pieces.add(blackKing);
    pieces.add(blackPawna7);
    pieces.add(blackCastlea8);
    pieces.add(blackKnightd8);
    pieces.add(blackBishoph8);
    pieces.add(blackPawna7);

    // instantiate white pieces
    Queen whiteQueen = new Queen(d1.getCoord(), "white", new ImageIcon(path + "\\whiteQueen.png"));
    King whiteKing = new King(e1.getCoord(), "white", new ImageIcon(path + "\\whiteKing.png"));
    Pawn whitePawne2 = new Pawn(e2.getCoord(), "white", new ImageIcon(path + "\\whitePawn.png"));
    Castle whiteCastlea1 = new Castle(a1.getCoord(), "white", new ImageIcon(path + "\\whiteCastle.png"));
    Knight whiteKnightb1 = new Knight(b1.getCoord(), "white", new ImageIcon(path + "\\whiteKnight.png"));
    Bishop whiteBishopc1 = new Bishop(c1.getCoord(), "white", new ImageIcon(path + "\\whiteBishop.png"));
        
    // set the images
    e1.setIcon(whiteKing.getImage());
    d1.setIcon(whiteQueen.getImage());
    b1.setIcon(whiteKnightb1.getImage());
    e2.setIcon(whitePawne2.getImage());
    a1.setIcon(whiteCastlea1.getImage());
    c1.setIcon(whiteBishopc1.getImage());
    
    // add piece class to square
    c1.add(whiteBishopc1);
    c1.setIsOccupied(true);
    a1.add(whiteCastlea1);
    a1.setIsOccupied(true);
    e2.add(whitePawne2);
    e2.setIsOccupied(true);
    b1.add(whiteKnightb1);
    b1.setIsOccupied(true);
    d1.add(whiteQueen);
    d1.setIsOccupied(true);
    e1.add(whiteKing);
    e1.setIsOccupied(true);

    // add pieces to pieces array
    pieces.add(whiteBishopc1);
    pieces.add(whiteCastlea1);
    pieces.add(whiteKnightb1);
    pieces.add(whiteQueen);
    pieces.add(whiteKing);
    pieces.add(whitePawne2);

    // for the end condition of the game
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
                            // check if move is legal
                            if(piece.isLegalMove(startSquare.getCoord(), square.getCoord())){
                                // if is attacking another piece
                                if(isAttacking(startSquare, square)){
                                    System.out.println("in attack block");
                                    // check if piece is same color
                                    System.out.println("attacking piece color : " + piece.color);
                                    System.out.println("attacked piece color : " + getPieceByComponentList(square));
                                    
                                    if(piece.color.equals(getPieceByComponentList(square).color)){
                                        piece.setIsSelected(false);
                                        startSquare.setIsSelected(false);
                                        square.setIsSelected(false);
                                        System.out.println("illegal move: piece same color!!\n\n\n");
                                        break;
                                    }
                                    //square.remove(getPieceByIcon(pieces, (ImageIcon) square.getIcon()));
                                    //square.remove(getPieceByIcon(pieces, (ImageIcon) square.getIcon()));
                                }
                                // move piece obj  
                                startSquare.remove(piece);
                                startSquare.setIsOccupied(false);
                                square.add(piece);
                                square.setIsOccupied(true);
                                // increase number of moves
                                piece.incNumMoves();
                                
                                // move ui
                                square.add(piece);
                                startSquare.revalidate();
                                startSquare.setIcon(null);
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