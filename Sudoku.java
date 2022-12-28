

import java.util.*;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;


public class Sudoku
{
    int board[][]={
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}   };
    int val,count=0,rem;
    int board1[][]=new int[8][8];
    int back[][]=new int[45][2];
    int b[][] ={
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}   };

    Sudoku()
    {
        
    }

    void backtrack(int r, int c, int val)
    {
        back[count][0]=(r*10)+c;
        back[count][1]=val;
        board[r-1][c-1]=val;
        count++;
    }

    void undo()
    {
        int c=back[count-1][0]%10;
        int r=(int)back[count-1][0]/10;
        board[r-1][c-1]=0;
        count--;
    }
    void generate(int difficulty)
    {
        
        Random r=new Random();
       

        if (difficulty==1)
        {
            rem=9;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<1;j++)
                {
                    board[i][r.nextInt(9)]=0;
                }
            }
        }
        else if (difficulty==2)
        {
            rem=36;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<4;j++)
                {
                    board[i][r.nextInt(9)]=0;
                }
            }
        }
        else{
            rem=45;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<6;j++)
                {
                    board[i][r.nextInt(9)]=0;
                }
            }
        }
        

    }

    private void validate()
    {

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if (board[i][j]==b[i][j])
                    continue;
                else
                {
                    System.out.println("Its Wrong!!");
                    System.exit(0);
                }
                
            }
        }
        System.out.println("\n\n Congratulations. You've solved it!!");

    }

    private void print(int printme[][])
    {
        System.out.println("     1   2   3     4   5   6     7   8   9 ");
        System.out.println(" ---------------------------------------------");
        for (int i=0;i<9;i++)
        {
            System.out.print((i+1)+" | ");
            for(int j=0;j<9;j++)
            {
                if(printme[i][j]==0)
                    System.out.print(" x");
                else
                    System.out.print(" "+printme[i][j]);
                if((j+1)%3==0)
                {
                    System.out.print("  | ");
                }
                else
                    System.out.print(" |");
            }
            if((i+1)%3==0)
                System.out.print("\n  ---------------------------------------------");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Sudoku sudoku=new Sudoku();
        Scanner sc=new Scanner(System.in);
        System.out.println("-------Sudoku-----");
        System.out.println("Select the difficulty");
        System.out.println("1.Easy\n2.Medium\n3.Hard");
        int difficulty=sc.nextInt();
        sudoku.generate(difficulty);
        sudoku.print(sudoku.b);

        for(int i=0;i<sudoku.rem;i++)
        {
            System.out.println();
            sudoku.print(sudoku.board);
            System.out.println("\n Enter row, column number and value you want to update or press 0 for undo");
            int row=sc.nextInt();
            if(row==0)
            {
                sudoku.undo();
                continue;
            }
            int col=sc.nextInt();
            int value=sc.nextInt();
            sudoku.backtrack(row,col,value);
        }
        System.out.println("Press 1 to submit");
        int v=sc.nextInt();
        if(v==1)
            sudoku.validate();


    }

}
