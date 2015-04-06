import java.io.IOException;

import javax.swing.JPanel;

public class possibleMoves{
	private JPanel panel;


	public possibleMoves(JPanel panel) {
        System.out.println("AgressivePlayer Initialized.");
        this.panel = panel;
    }
    
   // private boolean check_row(int r) { return ((r>=0) && (r <=5));}
   // private boolean check_col(int c) { return ((c>=0) && (c <=6));}
   // private boolean valid(int i, int j) {return ((check_row(i)) && (check_col(j)));}
    
    
//	public void setMove(int col) {
		
	//}
	 public void go() throws IOException {
	     	int bo[][] = new int [6][7];
	     	//int rowcount =0;
	     	//int colcount = 0;
	     	System.out.println("Test");
	     	int c[] = new int [7];
		 	int switcher[][] = Control.getCoordinates();
		 	for (int x = 0; x<7;x++){
		 		for (int y = 0; y<6; y++){
		 			bo[y][x] = switcher[x][Math.abs(y-5)];
		 		}
		 		
		 	}
	        System.out.println(switcher[0][0]+"c0");

		 	
		 	
		 	for(int i =0; i <6;i++){
		 		for(int j=0;j<7;j++){
			 		if (bo[i][j]==0 || bo[i][j]==0){
			 			c[i]=i;
			 		}

		 		}
		 	}
	        System.out.println(c[0]+"c0");
	        System.out.println(c[1]+"c1");
	        System.out.println(c[2]+"c2"); 
	        System.out.println(c[3]+"c3");
	        System.out.println(c[4]+"c4");
	        System.out.println(c[5]+"c5");
	        System.out.println(c[6]+"c6");
		 
	        int me = -1;
	        int oppo = 1;
	        
	        int[] h= new int[7];
	        for (int i = 0; i < 7; i++){
	        	h[i]=0;
	        }
	        
	        
	        for (int i=0; i<7; i++)
	        {
	          if (c[i]==6) h[i]=0; else{
	            int col = i;
	            int row = c[i];
	            
	            
	            if ((col>=3) 
	                && (bo[row][col-1] == me)
	                && (bo[row][col-2] == me)
	                && (bo[row][col-3] == me))
	                h[i]=h[i]+16;
	            //right
	            if ((col<=3) 
	                && (bo[row][col+1] == me)
	                && (bo[row][col+2] == me)
	                && (bo[row][col+3] == me))
	                h[i]=h[i]+16;
	            //check y direction
	            if ((row<=2) 
	                && (bo[row+1][col] == me)
	                && (bo[row+2][col] == me)
	                && (bo[row+3][col] == me))
	                h[i]=h[i]+16;
	            //check left diagonal
	            if ((col>=3) && (row<=2)
	                && (bo[row+1][col-1] == me)
	                && (bo[row+2][col-2] == me)
	                && (bo[row+3][col-3] == me))
	                h[i]=h[i]+16;
	            
	            if ((col<=3) && (row<=2)
	                && (bo[row+1][col+1] == me)
	                && (bo[row+2][col+2] == me)
	                && (bo[row+3][col+3] == me))
	                h[i]=h[i]+16;
	            
	            if ((col>=3) && (row>=3)
	                && (bo[row-1][col-1] == me)
	                && (bo[row-2][col-2] == me)
	                && (bo[row-3][col-3] == me))
	                h[i]=h[i]+16;
	            
	            if ((col<=3) && (row>=3)
	                && (bo[row-1][col+1] == me)
	                && (bo[row-2][col+2] == me)
	                && (bo[row-3][col+3] == me))
	                h[i]=h[i]+16;
	            
	            if ((col>=2) 
	                && (bo[row][col-1] == me)
	                && (bo[row][col-2] == me))
	                h[i]=h[i]+4;
	            //right
	            if ((col<=4) 
	                && (bo[row][col+1] == me)
	                && (bo[row][col+2] == me))
	                h[i]=h[i]+4;
	            //check y direction
	            if ((row<=3) 
	                && (bo[row+1][col] == me)
	                && (bo[row+2][col] == me))
	                h[i]=h[i]+4;
	            //check left diagonal
	            if ((col>=2) && (row<=3)
	                && (bo[row+1][col-1] == me)
	                && (bo[row+2][col-2] == me))
	                h[i]=h[i]+4;
	            
	            if ((col<=4) && (row<=3)
	                && (bo[row+1][col+1] == me)
	                && (bo[row+2][col+2] == me))
	                h[i]=h[i]+4;
	            
	            if ((col>=2) && (row>=2)
	                && (bo[row-1][col-1] == me)
	                && (bo[row-2][col-2] == me))
	                h[i]=h[i]+4;
	            
	            if ((col<=4) && (row>=2)
	                && (bo[row-1][col+1] == me)
	                && (bo[row-2][col+2] == me))
	                h[i]=h[i]+4;
	            
	            if ((col>=1) 
	                && (bo[row][col-1] == me))
	                h[i]=h[i]+2;
	            //right
	            
	            if ((col<=5) 
	                && (bo[row][col+1] == me))
	                h[i]=h[i]+2;
	            //check y direction
	            if ((row<=4) 
	                && (bo[row+1][col] == me))
	                h[i]=h[i]+2;
	            //check left diagonal
	            if ((col>=1) && (row<=4)
	                && (bo[row+1][col-1] == me))
	                h[i]=h[i]+2;
	            
	            if ((col<=5) && (row<=4)
	                && (bo[row+1][col+1] == me))
	                h[i]=h[i]+2;
	            
	            if ((col>=1) && (row>=1)
	                && (bo[row-1][col-1] == me))
	                h[i]=h[i]+2;
	            
	            if ((col<=5) && (row>=1)
	                && (bo[row-1][col+1] == me))
	                h[i]=h[i]+2;
	            
	            //check x direction.
	            //left
	            if ((col>=3) 
	                && (bo[row][col-1] == oppo)
	                && (bo[row][col-2] == oppo)
	                && (bo[row][col-3] == oppo))
	                h[i]=h[i]+8;
	            //right
	            if ((col<=3) 
	                && (bo[row][col+1] == oppo)
	                && (bo[row][col+2] == oppo)
	                && (bo[row][col+3] == oppo))
	                h[i]=h[i]+8;
	            //check y direction
	            if ((row<=2) 
	                && (bo[row+1][col] == oppo)
	                && (bo[row+2][col] == oppo)
	                && (bo[row+3][col] == oppo))
	                h[i]=h[i]+8;
	            //check left diagonal
	            if ((col>=3) && (row<=2)
	                && (bo[row+1][col-1] == oppo)
	                && (bo[row+2][col-2] == oppo)
	                && (bo[row+3][col-3] == oppo))
	                h[i]=h[i]+8;
	            
	            if ((col<=3) && (row<=2)
	                && (bo[row+1][col+1] == oppo)
	                && (bo[row+2][col+2] == oppo)
	                && (bo[row+3][col+3] == oppo))
	                h[i]=h[i]+8;
	            
	            if ((col>=3) && (row>=3)
	                && (bo[row-1][col-1] == oppo)
	                && (bo[row-2][col-2] == oppo)
	                && (bo[row-3][col-3] == oppo))
	                h[i]=h[i]+8;
	            
	            if ((col<=3) && (row>=3)
	                && (bo[row-1][col+1] == oppo)
	                && (bo[row-2][col+2] == oppo)
	                && (bo[row-3][col+3] == oppo))
	                h[i]=h[i]+8;
	            
	            if ((col>=2) 
	                && (bo[row][col-1] == oppo)
	                && (bo[row][col-2] == oppo))
	                h[i]=h[i]+4;
	            //right
	            if ((col<=4) 
	                && (bo[row][col+1] == oppo)
	                && (bo[row][col+2] == oppo))
	                h[i]=h[i]+4;
	            //check y direction
	            if ((row<=3) 
	                && (bo[row+1][col] == oppo)
	                && (bo[row+2][col] == oppo))
	                h[i]=h[i]+4;
	            //check left diagonal
	            if ((col>=2) && (row<=3)
	                && (bo[row+1][col-1] == oppo)
	                && (bo[row+2][col-2] == oppo))
	                h[i]=h[i]+4;
	            
	            if ((col<=4) && (row<=3)
	                && (bo[row+1][col+1] == oppo)
	                && (bo[row+2][col+2] == oppo))
	                h[i]=h[i]+4;
	            
	            if ((col>=2) && (row>=2)
	                && (bo[row-1][col-1] == oppo)
	                && (bo[row-2][col-2] == oppo))
	                h[i]=h[i]+4;
	            
	            if ((col<=4) && (row>=2)
	                && (bo[row-1][col+1] == oppo)
	                && (bo[row-2][col+2] == oppo))
	                h[i]=h[i]+4;
	            
	            if ((col>=1) 
	                && (bo[row][col-1] == oppo))
	                h[i]=h[i]+2;
	            //right
	            
	            if ((col<=5) 
	                && (bo[row][col+1] == oppo))
	                h[i]=h[i]+2;
	            //check y direction
	            if ((row<=4) 
	                && (bo[row+1][col] == oppo))
	                h[i]=h[i]+2;
	            //check left diagonal
	            if ((col>=1) && (row<=4)
	                && (bo[row+1][col-1] == oppo))
	                h[i]=h[i]+2;
	            
	            if ((col<=5) && (row<=4)
	                && (bo[row+1][col+1] == oppo))
	                h[i]=h[i]+2;
	            
	            if ((col>=1) && (row>=1)
	                && (bo[row-1][col-1] == oppo))
	                h[i]=h[i]+2;
	            
	            if ((col<=5) && (row>=1)
	                && (bo[row-1][col+1] == oppo))
	                h[i]=h[i]+2;            
	          }              
	        }
	        int max = 0;
	        int mm = 3;
	        int sum = 0;
	        for (int i=0; i<7; i++) {
	            if (h[i]>max) {max=h[i]; mm=i;}
	            sum= sum+h[i];
	        }
	        int[][] tester = Control.getCoordinates();
		 	for(int i =0; i <7;i++){
		 		for(int j=0;j<6;j++){
			 		if (tester[i][j]==1 || bo[i][j]==-1){
			 			c[i]=j-1;
			 		}

		 		}
		 	}
		 
	        if (sum==0) mm = (int) (Math.random()*7);
	        System.out.println(mm+"chosen move");
	        Control test = new Control();
	        test.redDisk(mm*99, c[mm]*95,this.panel, false);
	       // b.Move(mm,3,b);
	       // System.out.print(b + "21312321312");
	        

	    }

	    
}







/*import java.io.IOException;
import java.util.*;






public class possibleMoves{
   
	    private State current_state;
	    private int lookahead = 4;
	  

	    public boolean TerminalTest(State s){
	        if ((s.depth == lookahead) || (s.over()))
	            return true;
	        return false;
	    }
	    public int MinimaxDecision(State s){
	    	//State s = new State();
	        int v = 0;
	        if (s.next_player == 1){
	            v= MaxValue(s);
	        }
	        else{
	        	v = MinValue(s);
	        }

	        for (int i=0;i<s.suc.size();i++)
	        {
	            State cell = (State) s.suc.get(i);
	            if (cell.v==v) return cell.action;
	        }
	        //System.out.println("I don't know...");
	        return (int) (Math.random()*7);
	    }
	    
	    
	    private int MaxValue(State s){
	    	System.out.println("7");
            System.out.println(s.depth+"depth");
            System.out.println(s.over()+"over");
	        if (TerminalTest(s))
	        {
	            System.out.println(s.depth+"depth");
	            System.out.println(s.over()+"over");


	            int u = Utility(s);
	            System.out.println(u);

	            return u;
	        }
	        s.v = -500;
	        Vector suc=s.suc;
	        for (int i =0; i< suc.size(); i++){
	            State cell=(State) suc.get(i);
	            int temp = MinValue(cell);
	            if (temp>s.v)  {s.v=temp;}
	        }

	        return s.v;
	    }
	    private int MinValue(State s){
	    	System.out.println("6");
	        if (TerminalTest(s))
	        {
	            int u = Utility(s);
	            return u;
	        }
	        s.v = 500;
	        Vector suc = s.suc;
	        for (int i = 0; i< suc.size(); i++){
	            State cell=(State) suc.get(i);
	            int temp = MaxValue(cell);
	      
	            if (temp < s.v) s.v = temp;
	        }
	        return s.v;
	    }

	    
	  public int Utility(State s){
	        //System.out.println("Utility of State "+s.movelist);
	        System.out.println("dsffsdfs");
	        int me = current_state.next_player;
	        int oppo = 3-me;
	        if (s.over()){
	            if (s.winner == me)
	            {
	                s.v=100;
	                
	                return s.v;
	            }
	            if (s.winner == oppo)
	            {
	                s.v=-100;
	                return s.v;
	            }
	            if (s.winner == 0)
	            {
	                s.v=0;
	                return 0;
	            }
	        }

	      

	        
	        int h=0;
	        int row = s.m_x;
	        int col = s.m_y;
	    
	        if ((col>=3)
	        && (s.loc[row][col-1] == me)
	        && (s.loc[row][col-2] == me)
	        && (s.loc[row][col-3] == me))
	            h=h+16;
	        //right
	        if ((col<=3)
	        && (s.loc[row][col+1] == me)
	        && (s.loc[row][col+2] == me)
	        && (s.loc[row][col+3] == me))
	            h=h+16;
	        //check y direction
	        if ((row<=2)
	        && (s.loc[row+1][col] == me)
	        && (s.loc[row+2][col] == me)
	        && (s.loc[row+3][col] == me))
	            h=h+16;
	        //check left diagonal
	        if ((col>=3) && (row<=2)
	        && (s.loc[row+1][col-1] == me)
	        && (s.loc[row+2][col-2] == me)
	        && (s.loc[row+3][col-3] == me))
	            h=h+16;
	        
	        if ((col<=3) && (row<=2)
	        && (s.loc[row+1][col+1] == me)
	        && (s.loc[row+2][col+2] == me)
	        && (s.loc[row+3][col+3] == me))
	            h=h+16;
	        
	        if ((col>=3) && (row>=3)
	        && (s.loc[row-1][col-1] == me)
	        && (s.loc[row-2][col-2] == me)
	        && (s.loc[row-3][col-3] == me))
	            h=h+16;
	        
	        if ((col<=3) && (row>=3)
	        && (s.loc[row-1][col+1] == me)
	        && (s.loc[row-2][col+2] == me)
	        && (s.loc[row-3][col+3] == me))
	            h=h+16;
	        
	        if ((col>=2)
	        && (s.loc[row][col-1] == me)
	        && (s.loc[row][col-2] == me))
	            h=h+4;
	        //right
	        if ((col<=4)
	        && (s.loc[row][col+1] == me)
	        && (s.loc[row][col+2] == me))
	            h=h+4;
	        //check y direction
	        if ((row<=3)
	        && (s.loc[row+1][col] == me)
	        && (s.loc[row+2][col] == me))
	            h=h+4;
	        //check left diagonal
	        if ((col>=2) && (row<=3)
	        && (s.loc[row+1][col-1] == me)
	        && (s.loc[row+2][col-2] == me))
	            h=h+4;
	        
	        if ((col<=4) && (row<=3)
	        && (s.loc[row+1][col+1] == me)
	        && (s.loc[row+2][col+2] == me))
	            h=h+4;
	        
	        if ((col>=2) && (row>=2)
	        && (s.loc[row-1][col-1] == me)
	        && (s.loc[row-2][col-2] == me))
	            h=h+4;
	        
	        if ((col<=4) && (row>=2)
	        && (s.loc[row-1][col+1] == me)
	        && (s.loc[row-2][col+2] == me))
	            h=h+4;
	        
	        if ((col>=1)
	        && (s.loc[row][col-1] == me))
	            h=h+2;
	        //right
	        
	        if ((col<=5)
	        && (s.loc[row][col+1] == me))
	            h=h+2;
	        //check y direction
	        if ((row<=4)
	        && (s.loc[row+1][col] == me))
	            h=h+2;
	        //check left diagonal
	        if ((col>=1) && (row<=4)
	        && (s.loc[row+1][col-1] == me))
	            h=h+2;
	        
	        if ((col<=5) && (row<=4)
	        && (s.loc[row+1][col+1] == me))
	            h=h+2;
	        
	        if ((col>=1) && (row>=1)
	        && (s.loc[row-1][col-1] == me))
	            h=h+2;
	        
	        if ((col<=5) && (row>=1)
	        && (s.loc[row-1][col+1] == me))
	            h=h+2;
	        
	        //check x direction.
	        //left
	        if ((col>=3)
	        && (s.loc[row][col-1] == oppo)
	        && (s.loc[row][col-2] == oppo)
	        && (s.loc[row][col-3] == oppo))
	            h=h+8;
	        //right
	        if ((col<=3)
	        && (s.loc[row][col+1] == oppo)
	        && (s.loc[row][col+2] == oppo)
	        && (s.loc[row][col+3] == oppo))
	            h=h+8;
	        //check y direction
	        if ((row<=2)
	        && (s.loc[row+1][col] == oppo)
	        && (s.loc[row+2][col] == oppo)
	        && (s.loc[row+3][col] == oppo))
	            h=h+8;
	        //check left diagonal
	        if ((col>=3) && (row<=2)
	        && (s.loc[row+1][col-1] == oppo)
	        && (s.loc[row+2][col-2] == oppo)
	        && (s.loc[row+3][col-3] == oppo))
	            h=h+8;
	        
	        if ((col<=3) && (row<=2)
	        && (s.loc[row+1][col+1] == oppo)
	        && (s.loc[row+2][col+2] == oppo)
	        && (s.loc[row+3][col+3] == oppo))
	            h=h+8;
	        
	        if ((col>=3) && (row>=3)
	        && (s.loc[row-1][col-1] == oppo)
	        && (s.loc[row-2][col-2] == oppo)
	        && (s.loc[row-3][col-3] == oppo))
	            h=h+8;
	        
	        if ((col<=3) && (row>=3)
	        && (s.loc[row-1][col+1] == oppo)
	        && (s.loc[row-2][col+2] == oppo)
	        && (s.loc[row-3][col+3] == oppo))
	            h=h+8;
	        
	        if ((col>=2)
	        && (s.loc[row][col-1] == oppo)
	        && (s.loc[row][col-2] == oppo))
	            h=h+4;
	        //right
	        if ((col<=4)
	        && (s.loc[row][col+1] == oppo)
	        && (s.loc[row][col+2] == oppo))
	            h=h+4;
	        //check y direction
	        if ((row<=3)
	        && (s.loc[row+1][col] == oppo)
	        && (s.loc[row+2][col] == oppo))
	            h=h+4;
	        //check left diagonal
	        if ((col>=2) && (row<=3)
	        && (s.loc[row+1][col-1] == oppo)
	        && (s.loc[row+2][col-2] == oppo))
	            h=h+4;
	        
	        if ((col<=4) && (row<=3)
	        && (s.loc[row+1][col+1] == oppo)
	        && (s.loc[row+2][col+2] == oppo))
	            h=h+4;
	        
	        if ((col>=2) && (row>=2)
	        && (s.loc[row-1][col-1] == oppo)
	        && (s.loc[row-2][col-2] == oppo))
	            h=h+4;
	        
	        if ((col<=4) && (row>=2)
	        && (s.loc[row-1][col+1] == oppo)
	        && (s.loc[row-2][col+2] == oppo))
	            h=h+4;
	        
	        if ((col>=1)
	        && (s.loc[row][col-1] == oppo))
	            h=h+2;
	        //right
	        
	        if ((col<=5)
	        && (s.loc[row][col+1] == oppo))
	            h=h+2;
	        //check y direction
	        if ((row<=4)
	        && (s.loc[row+1][col] == oppo))
	            h=h+2;
	        //check left diagonal
	        if ((col>=1) && (row<=4)
	        && (s.loc[row+1][col-1] == oppo))
	            h=h+2;
	        
	        if ((col<=5) && (row<=4)
	        && (s.loc[row+1][col+1] == oppo))
	            h=h+2;
	        
	        if ((col>=1) && (row>=1)
	        && (s.loc[row-1][col-1] == oppo))
	            h=h+2;
	        
	        if ((col<=5) && (row>=1)
	        && (s.loc[row-1][col+1] == oppo))
	            h=h+2;       
	        
	        s.v = h;
	        return h;
	    }
		public possibleMoves() {
	        System.out.println("MinMaxPlayer Initialized.");
	        current_state = new State();
	        //MinimaxDecision();
	    }
	    public void go(currentBoard b) throws IOException {
	        State current_state = new State();

	        current_state.ParseMove(b.movelist);
	        System.out.println("MinMaxPlayer thinking...");
	        create_suc(current_state);
	        int m = MinimaxDecision(current_state);
	       // System.out.println(m);
	        //Control test = new Control();
	        //test.redDisk(m*95,0,Control.panel,false);
	        b.Move(m);
	        
	    }
	    private void create_suc(State s){
	        //System.out.print("Generate Successors down to level ");
	        //System.out.println(lookahead);
	        Vector chd = new Vector();
	       
	        for (int i=0; i<7; i++) {
	            State temp = new State();
	            temp.ParseMove(s.movelist);
	            if (temp.cols[i]!=6){
	                temp.Move(i);
	                temp.depth = s.depth+1;
	                temp.action = i;
	                temp.out=false;
	                chd.add(temp);
	                if (temp.depth<lookahead) create_suc(temp);            
	            }
	        }
	        s.suc=chd;
	    }
	  
	 public void grrr(){
		 State s = new State();
		 System.out.println("0");
		 System.out.println(s.v);
		 System.out.println(s.movelist);



		 MinimaxDecision(s);
		 System.out.println("1");
		 MaxValue(s);
		 System.out.println("2");

		 
	 }
	    


}
class State{
	public int[][] loc = new int [6][7];
    public int v = -1;
    public int depth = 0;
    public int action =0;
    public boolean out = false;
    public int m_x;
    public int m_y;
    public int[] cols;
    public  int next_player;
	String movelist;
    public int winner;
    public Vector suc=new Vector();
    State(){
        action = -1;
        winner=0;
        next_player=1;
        m_x=0;
        movelist="";
        m_y=0;
        v=0;
        //loc[6][7]=0;
        depth=0;
        clear();
        suc = new Vector();
        out = false;
    }
    public void Move(int pos) {
        if ( (pos<0) || (pos >6))
            System.out.println("invalid input\n\n");
        else{
            m_y=pos;
            movelist+=(new Integer(pos)).toString();
            m_x= 5-cols[pos];
            cols[pos]++; 
            loc[m_x][m_y] = next_player;
            next_player = 3-next_player;

            }
        }
    public void ParseMove(String move_list){
        for (int i=0;i<move_list.length();i++) {
           int tm = Integer.parseInt((new Character(move_list.charAt(i))).toString());
           Move(tm);
        }
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
        return ret;
    }

    public void clear() {
        for (int i = 0; i< 6;i++)
            for (int j = 0; j<7; j++)
            {
                loc[i][j]=0;
            }
        for (int j = 0 ; j < 7; j++) cols[j] = 0;        
    }
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

        
        if  ( (line_x.matches(match)) ||
            (line_y.matches(match)) ||
            (line_ld.matches(match)) ||
            (line_rd.matches(match)) )
            {
              winner = 3 - next_player;


              return true;
            } 
        
        
        int z=0;
        for (int i=0; i<6; i++)
            for (int j=0; j<7; j++)
              if (loc[i][j] == 0)  z = 1;
            
        if (z == 0)
        {

            return true;
        }
            
        return false;
    }
    
    
    
}*/