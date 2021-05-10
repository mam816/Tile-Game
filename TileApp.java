/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileapp;

import java.util.Arrays;
import java.util.Scanner;


public class TileApp {

    int[][] gameBoard = {
    {1, 3, 8, 12},
    {10, 2, 0, 11},
    {6, 7, 13, 9},
    {4, 14, 15, 5}};
    
    int[][] gameSolution = {
       {1, 2, 3, 4},
       {5, 6, 7, 8},
       {9, 10, 11, 12},
       {13, 14, 15, 0}};

    
    public static void main(String[] args) {
        new TileApp();
    }
    
    public TileApp() {
       
    boolean gameOver = false;
    while (!gameOver) 
    {
     printGameOnScreen();
     int chosenTile = getUserSelectedTile();
     int[] tileLocationOnTheBoard = getTileLocation(chosenTile);
     int[] emptyLocationOnTheBoard = getTileLocation(0);
     if(canTileBeMoved(tileLocationOnTheBoard, emptyLocationOnTheBoard)) 
     {
      moveTile(tileLocationOnTheBoard, emptyLocationOnTheBoard);
      if(isGameSolved()) 
         {
          printCongratsMessage();
          gameOver = true;
         }
     
    }
 printGameOnScreen(); 
    }
    }
    
  private void printGameOnScreen() {
  
      for(int y = 0; y < gameBoard.length;y++)
      {
          for(int z = 0; z < gameBoard[y].length;z++)
          {
              System.out.print(gameBoard[y][z]+"\t");
          }
          System.out.println();
      }
      System.out.print("\n");
  }
   
  private int getUserSelectedTile() {
      
  Scanner keyboard = new Scanner(System.in);
  while(true) 
  {
     try
     {
         System.out.println("Please enter the number of the tile you\nwould like to move. Please choose a number between 1 and 15 ");
         int tileChoice = Integer.parseInt(keyboard.nextLine());
         if(tileChoice> 15 || tileChoice<1){
             System.out.println("Invalid tile n30umber, please try again.");
             return getUserSelectedTile();
         }
         return tileChoice;
     } 
     catch (Exception e) 
     {
              
        System.out.println("Please reenter your selected tile number");
         
       // this line is just to clear the scanner buffer if needed
       // try to keep or remove the following line and see what
      // happens when you enter a bad tile number (such as k2)
      
        return getUserSelectedTile();
        }
  }
 
 }
  
  
 private int[] getTileLocation(int x){
     for(int y = 0; y < gameBoard.length;y++)
      {
          for(int z = 0; z < gameBoard[y].length;z++)
          {
             if(gameBoard[y][z] ==  x)
             {
                 int number1 = y;
                 int number2 = z;
                 return new int[] {number1,number2};
             }
          }
      } 
    return null;
  }
   
  private boolean canTileBeMoved(int[] a , int [] b){  
    if((a[0] == b[0] - 1) && (a[1] == b[1])) 
    {
       return true;
    }
    else if((a[0] == b[0] + 1) && (a[1] == b[1]))
    {
        return true;
    }
    else if((a[0] == b[0]) && (a[1] == b[1] - 1))
    {
      return true;       
    }
    else if((a[0] == b[0]) && (a[1] == b[1] + 1))
    {
        return true;
    }
    else
    {
        return false;
    }
}   
    
   private boolean moveTile(int [] c, int [] d){
       int temp = gameBoard[c[0]][c[1]];
       gameBoard[c[0]][c[1]] = gameBoard[d[0]][d[1]];
       gameBoard[d[0]][d[1]]= temp;
       return true;
   }
    
  private boolean isGameSolved(){
      for(int y = 0; y < gameBoard.length;y++)
      {
          for(int z = 0; z < gameBoard[y].length;z++)
          {
              if(gameBoard == gameSolution)
              {
                  return true;
              }
          }
      }
      return false;
  }
  
  private void printCongratsMessage() {
      
      System.out.println("Congratulations!You have solved the puzzle and completed the tile game.\nPlease come back and play again soon!");
  }
  
 }
