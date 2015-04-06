
/*public class currentBoard {
    public static String test="";
	public String movesMade(int a) {
		
		
		test += (new Integer(a)).toString();
		return test;
		
        }
        

}

*/
/*
 * SimpleBoard.java
 *
 * Created on December 5, 2003, 6:26 PM
 */

/**
 *
 * @author  Chen
 */
import java.io.IOException;
import java.util.*;

import javax.swing.JPanel;
public class currentBoard{
    public static int[][] loc;
    public static  int next_player;
    public int[] cols;
    public int m_x=0;
    public int m_y=0;
    public int winner = 0;
    public boolean out = true;
    public static String movelist;
    

    public currentBoard(){
       // b.next_Player= next_Player;
    	//next_player = 1;
       //loc = new int[6][7];
       //cols = new int[7];
       //winner=0;
       //clear();
/*       b.next_player = next_player;
       b.loc = loc;
       b.cols = cols;
       b.movelist = movelist;
       out = true;
       //System.out.println("movelist"+movelist);
*/    }
    
/*    public currentBoard(int[][] loc, int next_player, int[] cols, int m_x, int m_y, String movelist) {
        this.next_player = next_player;
        this.loc = loc;
        this.cols = cols;
        this.movelist = movelist;
        this.m_y= m_y;
        this.m_x= m_x;
        out = true;
    	System.out.println("tester");
	}*/

/*	public void ParseMove(String move_list) throws IOException {
        for (int i=0;i<move_list.length();i++) {
           int tm = Integer.parseInt((new Character(move_list.charAt(i))).toString());
           Move(tm,);
        }
        
    }*/
    public String getMoveList(){
    	return this.movelist;
    }
    public static void setMoveList(String move){
    	movelist=movelist+move;
    	
    }
    public static currentBoard Move(int x,int y, currentBoard b) throws IOException  {
    //	System.out.println(pos);
/*        if ( (pos<0) || (pos >6))
            System.out.println("invalid input\n\n");
        else{
            if ((cols[pos]==6) && out)
                System.out.println("Column full");
            else{*/
    		
            //m_y=y;
            //this.movelist+=(new Integer(y)).toString();
            setMoveList(new Integer(x).toString());
            b.m_x= 5-cols[y];
            b.cols[y]++; 
            System.out.println(this.movelist+"testing movelist");
            System.out.println(b.next_player+"next player 1");
            b.loc[b.m_x][b.m_y] = next_player;
            b.next_player = 3-b.next_player;
            System.out.println(b.next_player+"next player 2");
            view();

          //  }
        //}
/*        System.out.println("fuck");
        System.out.println(y+"pos");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");*/
        //System.out.println(currentBoard());
		return b;

        //Control test = new Control();
        //test.redDisk(500,500, test.panel, false);
        //possibleMoves.go(b);
        
    }
    
    public static int[][] view() {
        return loc;
    }
    public int[] viewcol(){
        return cols;
    }
    public void clear() {
        for (int i = 0; i< 6;i++)
            for (int j = 0; j<7; j++)
            {
                loc[i][j]=0;
            }
        for (int j = 0 ; j < 7; j++) cols[j] = 0;        
    }
    
    public int next() {return next_player;}
    public int[] ret_col(){return cols;}
    public boolean over() {
        String line_x="";
        String line_y="";
        String line_ld=(new Integer(loc[m_x][m_y])).toString();
        String line_rd=(new Integer(loc[m_x][m_y])).toString();
        String s = (new Integer(3-next_player)).toString();
        String sub = s+s+s+s;
        String match ="[012]*"+sub+"[012]*";
        for (int i=0; i<7; i++){
            int cell = loc[m_x][i];
            line_x+= (new Integer(cell)).toString();
        }
        for (int i=0; i<6; i++){
            int cell = loc[i][m_y];
            line_y+= (new Integer(cell)).toString();
        }
        
        int tempx=m_x;
        int tempy=m_y;
        while ( (tempx>0) && (tempy>0)){
            tempx--;tempy--;
            line_ld = (new Integer(loc[tempx][tempy])).toString() + line_ld;
        }
        
        tempx=m_x;tempy=m_y;
        while ( (tempx <5)&& (tempy <6)) {
            tempx++;tempy++;
            line_ld = line_ld+(new Integer(loc[tempx][tempy])).toString();
        }
        
        tempx=m_x;tempy=m_y;
        while ( (tempx>0) && (tempy<6)){
            tempx--;tempy++;
            line_rd = (new Integer(loc[tempx][tempy])).toString() + line_rd;
        }
        
        tempx=m_x;tempy=m_y;
        while ( (tempx <5)&& (tempy >0)) {
            tempx++;tempy--;
            line_rd = line_rd+(new Integer(loc[tempx][tempy])).toString();
        }
        
        /*System.out.println(line_x);
        System.out.println(line_y);
        System.out.println(line_ld);
        System.out.println(line_rd);
        System.out.println(sub);*/
        
        if  ( (line_x.matches(match)) ||
            (line_y.matches(match)) ||
            (line_ld.matches(match)) ||
            (line_rd.matches(match)) )
            {
              winner = 3 - next_player;
              /*if (out){
              System.out.print("\nPlayer ");
              System.out.print(new Integer(winner));
              System.out.println(" won!");}*/

              return true;
            } 
        
        
        int z=0;
        for (int i=0; i<6; i++)
            for (int j=0; j<7; j++)
              if (loc[i][j] == 0)  z = 1;
            
        if (z == 0)
        {
            /*if (out)
                System.out.println("Draw!");*/
            return true;
        }
            
        return false;
    }
    
    
    
    public String toString(){
        String ret = "   0 1 2 3 4 5 6\n";
        for (int i = 0; i < 6; i++){
            ret += (new Integer(i)).toString()+ ": ";
            for (int j = 0; j< 7; j++){
                ret+=(new Integer(loc[i][j])).toString();
                ret+=" ";
            }
            ret+="\n";
        }
      //  System.out.println(ret+"ret");
        return ret;
    }
}
