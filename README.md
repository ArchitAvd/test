

import java.util.*;
import java.util.Scanner;


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
    int val,count;
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

    void generate(int difficulty)
    {
        
        Random r=new Random();
       

        if (difficulty==1)
        {
            count=18;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<2;j++)
                {
                    board[i][r.nextInt(9)]=0;
                }
            }
        }
        else if (difficulty==2)
        {
            count=36;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<4;j++)
                {
                    board[i][r.nextInt(9)]=0;
                }
            }
        }
        else{
            count=45;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<6;j++)
                {
                    board[i][r.nextInt(9)]=0;
                }
            }
        }
        

    }

    private void validate(int r, int c ,int val)
    {

        if(b[r-1][c-1]==val)
        {
            System.out.printf("\n\nCorrect!");
            board[r-1][c-1]=val;
        }
        else{
            System.out.println("\n\nIncorrect!\n Try Again");

        }

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

        for(int i=0;i<sudoku.count;i++)
        {
            System.out.println();
            sudoku.print(sudoku.board);
            System.out.println("\n Enter row, column number and value you want to update:");
            int row=sc.nextInt();
            int col=sc.nextInt();
            int value=sc.nextInt();
            sudoku.validate(row,col,value);
        }

        System.out.println("\n\n Congrats!! You've solved it!!")

    }

}

