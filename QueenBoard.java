import java.util.Arrays;
import java.util.ArrayList;
public class QueenBoard {
  private int[][] board;

  public QueenBoard (int size) {

	  board= new int[size][size];
	  for(int i=0; i<size;i++) {
		  for(int c=0;c<size;c++) {
			  board[i][c]=0;
		  }
	  }
  }


public boolean addQueen(int r,int col){
  if(board[r][col]==0){
    board[r][col]=1;
    for(int incre=1;col+incre<board.length && r+incre<board.length;incre++) {  // changes the avaibility of diagonals(rihgt and down)
      board[r+incre][col+incre]--;
    }
    for(int incre=1;r-incre>=0 && col+incre<board.length;incre++) {// diagonals(right and up)
    board[r-incre][col+incre]--;
    }
    for(int c=0;c<board.length;c++) { // changes the avaibility of the columns by parsing through rows
      if(col==c) {

      }
      else {
      board[r][c]--;
      }
    }
  return true;
  }return false;
}
public boolean removeQueen(int r,int col){

  board[r][col]=0;
  for(int incre=1;col+incre<board.length && r+incre<board.length;incre++) {  // changes the avaibility of diagonals(rihgt and down)
    board[r+incre][col+incre]++;
  }
  for(int incre=1;r-incre>=0 && col+incre<board.length;incre++) {// diagonals(right and up)
  board[r-incre][col+incre]++;
  }
  for(int c=0;c<board.length;c++) { // changes the avaibility of the columns by parsing through rows
    if(col==c) {

    }
    else {
    board[r][c]++;
    }
  }
  return true;
}
public boolean solveR(int col){
  if(col==board.length){
    return true;
  }
  for (int r=0;r<board.length;r++){

    if(addQueen(r,col)){
        if(solveR(col+1)){
          return true;
        }

          removeQueen(r,col);

      }
  }
  return false;
}
public boolean solveR(){
	for(int i=0;i<board.length;i++) {
		for(int col=0;col<board.length;col++) {
			if(board[i][col]!=0) {
				throw new IllegalStateException("board has to be filled with 0 in the beginning");
			}
		}
	}
  return solveR(0);
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
public int countSolutions(int col,int count) {
	if(col==board.length) {
		//.out.println("reached first if");
		return 1;
	}
	for(int row=0;row<board.length;row++) {
		if(addQueen(row,col)) {
			count+=countSolutions(col+1,0);
		
			removeQueen(row,col);
		}
	}
	//System.out.println("reached end of loop");
	return count;
}
public int countSolutions(){
	for(int i=0;i<board.length;i++) {
		for(int col=0;col<board.length;col++) {
			if(board[i][col]!=0) {
				throw new IllegalStateException("board has to be filled with 0 in the beginning");
			}
		}
	}
	return countSolutions(0,0);
}
}
