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
  return solveR(0);
}
public boolean solveRCount(int col,ArrayList<Integer>count){
  if(col==board.length){
    count.set(0,count.get(0)+1);
    System.out.println(count.get(0));
    return true;
  }
  for (int r=0;r<board.length;r++){

    if(addQueen(r,col)){
        if(solveR(col+1)){

        }

          removeQueen(r,col);

      }
  }
  return false;
}
public int countSolutions(){
  ArrayList<Integer>count=new ArrayList<Integer>();
  count.add(0);
  solveRCount(0,count);
  return count.get(0);
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
