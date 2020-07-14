/**
 * <p> Board represents the container that holds the squares.
 * 
 * @author Alexander Jack
 */

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

// class board is used to simulate chess board
// class board will be composed of squares
public class Board extends JPanel{
    public static int BOARD_HEIGHT = 8;
    public static int BOARD_WIDTH = 8;
    
    //GridLayout layout;
    public Board(){
        
        setLayout(new GridLayout(0,8));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        //setSize(400,400);
    } 
    int getBoardWidth(){
        return BOARD_WIDTH;
    }
    int getBoardHeight(){
        return BOARD_HEIGHT;
    }
}
    
