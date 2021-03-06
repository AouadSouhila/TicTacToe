package com.example.tictactoe;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameLogic {

    private int[][] gameBoard;
    private String[] playerNames= {"player 1", "player 2"};
    private Button playAgainBtn;
    private Button homeBtn;
    private TextView playerTurn;
    private int[] winType = {-1,-1,-1};
    //------------------------------ var -----------------------------
    public void setPlayAgainBtn(Button playAgainBtn) {
        this.playAgainBtn = playAgainBtn; }
    //---------------------------------------------------------------------
    public void setHomeBtn(Button homeBtn) {
        this.homeBtn = homeBtn; }
    //---------------------------------------------------------------------
    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn; }
    //---------------------------------------------------------------------
    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames; }
    //---------------------------------------------------------------------
    private  int player = 1;
    //---------------------------------------------------------------------
    gameLogic() {

        gameBoard = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }
    //---------------------------------------------------------------------
    public boolean updateGameBoard(int r, int c){

        if(gameBoard[r-1][c-1] == 0){
            gameBoard[r-1][c-1] = player;
            if (player == 1)
            {playerTurn.setText((playerNames[1] + "'s Turn"));}
            else {playerTurn.setText((playerNames[0] + "'s Turn"));}
            return true;
        }

        else return false;
    }
    //---------------------------------------------------------------------
    public void resetGame(){
        gameBoard = new int[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++){
                gameBoard[r][c] = 0;
            }
        }
        player = 1;
        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0] + "'s Turn"));
    }
    //---------------------------------------------------------------------
    public boolean winnerCheck(){
        boolean isWinner = false;
        //-----type 1
        for (int r = 0; r < 3; r++) {
            if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != 0){
                winType = new int[]{r,0,1};
                isWinner = true;
            }
        }
        //-----type 2
        for (int c = 0; c < 3; c++) {
            if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] && gameBoard[0][c] != 0){
                winType = new int[]{0,c,2};
                isWinner = true;
            }
        }
        //-----type 3
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != 0){
            winType = new int[]{0,2,3};
            isWinner = true;
        }
        //-----type 4
        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[2][0] != 0){
            winType = new int[]{2,2,4};
            isWinner = true;
        }
        int boardFilled = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++){
                if(gameBoard[r][c] != 0) boardFilled++; }
        }

        if(isWinner){
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1]+ "  Won!!!!"));
            return true; }
        else if(boardFilled == 9){
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurn.setText("TIE GAME!!!!");
            return true; }
        return false; }

    //---------------------------------------------------------------------
    public int[][] getGameBoard(){
        return  gameBoard; }

    public void setPlayer(int player) {
        this.player = player; }

    public int getPlayer() {
        return player; }

    public int[] getWinType() {
        return winType;
    }
}
