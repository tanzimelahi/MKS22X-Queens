import java.util.Arrays;
import java.util.ArrayList;
public class QueenBoards {
  private int[][] board;

  public QueenBoards (int size) {

	  board= new int[size][size];
	  for(int i=0; i<size;i++) {
		  for(int c=0;c<size;c++) {
			  board[i][c]=0;
		  }
	  }
  }


private boolean addQueen(int r,int col){
  if(board[r][col]==0){
    board[r][col]=1;
    for(int incre=1;col+incre<board.length && r+incre<board.length;incre++) {  // changes the avaibility of diagonals(rihgt and down)
      board[r+incre][col+incre]--;
    }
    for(int incre=1;r-incre>=0 && col+incre<board.length;incre++) {// diagonals(right and up)
    board[r-incre][col+incre]--;
    }
  return true;
  }return false;
}
private boolean removeQueen(int r,int col){
  board[r][col]=0;
  for(int incre=1;col+incre<board.length && r+incre<board.length;incre++) {  // changes the avaibility of diagonals(rihgt and down)
    board[r+incre][col+incre]++;
  }
  for(int incre=1;r-incre>=0 && col+incre<board.length;incre++) {// diagonals(right and up)
  board[r-incre][col+incre]++;
  }
  return true;
}
public boolean solveR(int col){
  if(col==board.length){
    return true;
  }
  for (int r=0;r<board.length;r++){
    if(addQueen(r,col)){
      return solveR(col+1);
    }
    removeQueen(r,col);
  }
  return false;
}
}
