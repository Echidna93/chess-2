import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class square will hold each individual cell on the chess board
public class Square extends JButton implements ActionListener{
    protected int[] coord = new int[2];
    protected String color;
    protected String id;
    protected boolean isOccupied = false;
    boolean isSelected = false;
    Square(int[] vector, String color, String id){
        this.coord = vector;
        this.color = color;
        setColor(color);
        this.id = id;
        // add on onclick listener to test to make sure things are named properly, might delete later
        addActionListener(this);
    }
    // setcolor called for initialization of board
    void setColor(String color){
        if(color == "BLACK"){
            setBackground(Color.BLACK);
        }
        else{
            setBackground(Color.WHITE);
        }
    }
    // returns coordinate array
    int[] getCoord(){
        return this.coord;
    }

    // setIsOcuppied, sets flag if imageicon (piece) is present on square
    void setIsOccupied(boolean isCurrentlyOccupied){
        isOccupied = isCurrentlyOccupied;
    }

    // getIsOccupied, grabs returns the isOccupied flag
    boolean getIsOccupied(){
        return this.isOccupied;
    }

    void setIsSelected(boolean selection){
        this.isSelected = selection;
    }

    boolean getIsSelected(){
        return this.isSelected;
    }

    // onclick button displays its id
    @Override
    public void actionPerformed(final ActionEvent e) {
        setIsSelected(true);
        System.out.println("this is the id : " + id);   
    }

}