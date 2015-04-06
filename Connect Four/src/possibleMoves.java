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
	public void AI() throws IOException {
		int bo[][] = new int [6][7];
		int c[] = new int [7];
		int switcher[][] = Control.getCoordinates();


		for (int x=0;x<6;x++){
			for (int y = 0; y<7; y++){
				bo[Math.abs(x-5)][y] = switcher[y][Math.abs(x-5)];
			}
		}

		int counter = 0;
		for(int i =0; i <7;i++){
			for(int j=0;j<6;j++){
				if (bo[j][i]!=1 &&bo[j][i]!=-1){
					counter++;
					c[i]=5-j;
				}
			}
			if(counter ==0){
				c[i]=6;
				counter = 0;
			}
			else{
				counter=0;
			}
			}


		int me = -1;
		int oppo = 1;

		int[] h= new int[7];
		for (int i = 0; i < 7; i++) h[i]=0;


		for (int i=0; i<7; i++)
		{
			if (c[i]==6) h[i]=0; else{
				int col = i;
				int row = 5-c[i];
				System.out.println(row+"row");

				if ((col>=3)
		                && (bo[row][col-1] == oppo)
		                && (bo[row][col-2] == oppo)
		                && (bo[row][col-3] == oppo)){
		                h[i]=h[i]+8;
		            }
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
		                && (bo[row][col-1] == oppo)){
		                h[i]=h[i]+2;

		            }
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

		System.out.println(sum+"sum");
		int[] f = new int [7];
		for(int i =0; i <7;i++){
			for(int j=0;j<6;j++){
				if (bo[j][i]!=1 &&bo[j][i]!=-1){
					f[i]=j;
				}

			}
			if(f[i]!=1&&f[i]!=2&&f[i]!=3&&f[i]!=4&&f[i]!=5){
				f[i]=0;
			}
		}
		

		if (sum==0) mm = (int) (Math.random()*7);
		System.out.println(mm+"chosen move");
		Control test = new Control();
		test.redDisk(mm*99, f[mm]*95,this.panel, false);
		Control.check_disk[mm][f[mm]]=true;



	}


}







