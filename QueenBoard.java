import java.util.Arrays;
import java.util.ArrayList;
public class QueenBoard {
  private int[][] board;
  private int c;
  private int index;
  public QueenBoard (int size) {
	  c=0;
	  index=0;
	  board= new int[size][size];
	  for(int i=0; i<size;i++) {
		  for(int c=0;c<size;c++) {
			  board[i][c]=0;
		  }
	  }
  }


  private boolean addQueen(int c, int index) {  // index is the row where parsing starts

      for(int i=this.index;i<board.length;i++) { // here i is parsing through rows
    	  if(board[i][c]==0) {// if a position is found
    		  board[i][c]=1;
    		 int r=i;
    		  for(int row=0;row<board.length;row++) { // changes the avaibility of the columns by parsing through rows
    			  if(row==r) {

    			  }
    			  else {
    			  board[row][c]--;
    			  }
    		  }
    		  for(int col=0;col<board.length;col++) { // changes the avaibility of rows(y axis) by parsing through columns
    			  if(col==c) {

    			  }
    			  else {
    			  board[r][col]--;
    			  }
    			}
    	 	  for(int incre=1;c+incre<board.length && r+incre<board.length;incre++) {  // changes the avaibility of diagonals(rihgt and down)
    			  board[r+incre][c+incre]--;
    		  }
              for(int incre=1;c-incre>=0 && r-incre>=0;incre++) {// diagonals(left and up)
    			  board[r-incre][c-incre]--;

    		  }
              for(int incre=1;r-incre>=0 && c+incre<board.length;incre++) {// diagonals(right and up)
        		  board[r-incre][c+incre]--;
        	  }
              for(int incre=1;r+incre<board.length&& c-incre>=0;incre++) { // diagonals(left and down)
        		  board[r+incre][c-incre]--;
        	  }
             this.index=0;// changes index to 0 so parsing can begin fromt the top row
    		 return true;
           }// the if statement ends here
      }// the loop ends here

      return false;
  }
  private  boolean removeQueen(int c,int index)  {// here remove sets the index(row) to the position of the previous queen+ 1
  for(int i=0;i<board.length;i++) { // here i is parsing through rows
	  if(board[i][c]==1) {// if a queen is found
		  board[i][c]=0;
		  this.index=i+1;
		 int r=i;
		  for(int row=0;row<board.length;row++) { // changes the avaibility of the columns by parsing through rows
			  if(row==r) {

			  }
			  else {
			  board[row][c]++;
			  }
		  }
		  for(int col=0;col<board.length;col++) { // changes the avaibility of rows(y axis) by parsing through columns
			  if(col==c) {

			  }
			  else {
			  board[r][col]++;
			  }
			}
	 	  for(int incre=1;c+incre<board.length && r+incre<board.length;incre++) {  // changes the avaibility of diagonals(rihgt and down)
			  board[r+incre][c+incre]++;
		  }
          for(int incre=1;c-incre>=0 && r-incre>=0;incre++) {// diagonals(left and up)
			  board[r-incre][c-incre]++;

		  }
          for(int incre=1;r-incre>=0 && c+incre<board.length;incre++) {// diagonals(right and up)
    		  board[r-incre][c+incre]++;
    	  }
          for(int incre=1;r+incre<board.length&& c-incre>=0;incre++) { // diagonals(left and down)
    		  board[r+incre][c-incre]++;
    	  }
		 return true;
       }   // the if statement ends here
  }        // the loop ends here

  return false;
}


	public boolean solveR() {
		if(this.c<0) {
			this.c=0;
			this.index=0;
			return false;
		}
		else if(solveR(this.c,this.index)) {
			this.c=0;
			this.index=0;
			return true;
		}
		else {
			return solveR();
		}

	}
	public int countSolutions() {
		this.c=0;
		this.index=0;
		return solveRCount(this.c,this.index,0);
	}
	   private int solveRCount(int c,int index,int count) {

		   if(c==board.length) {
			   count++;
			   this.c--;
			   removeQueen(c-1,this.index);
			   return solveRCount(this.c,this.index,count);
		   }
		   else {
			   if(addQueen(c,index)) {
				   this.c++;

				   return solveRCount(this.c,this.index,count);
			   }
			   else {
				   this.c--;
				   if(this.c<0) {  // stops indexout of range exception
					   return count;
				   }
				   else {
				   removeQueen(c-1,index);
				   return solveRCount(this.c,this.index,count);

				   }
			   }
		   }
	   }

   private boolean solveR(int c,int index) {

	   if(c==board.length) {
		   return true;
	   }
	   else {
		   if(addQueen(c,index)) {
			   this.c++;

			   return solveR(c+1,index);
		   }
		   else {
			   this.c--;
			   if(this.c<0) {  // stops indexout of range exception
				   return false;
			   }
			   else {
			   removeQueen(c-1,index);

			   return false;
			   }
		   }
	   }
   }
  public String toString() {
	String result="";
	for(int i=0;i<board.length;i++) {
		for(int r=0;r<board.length;r++) {
			if(board[i][r]==1) {
				result+="Q ";
			}
			else {
				result+="_ ";
			}
		}
		result+="\n";
	}
	return result;

   }


}
