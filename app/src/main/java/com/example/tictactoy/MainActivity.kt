package com.example.tictactoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buclick(view: View) {
        val buSelected=view as Button

        var cellID=0
        when(buSelected.id){
            R.id.bu1->cellID=1
            R.id.bu2->cellID=2
            R.id.bu3->cellID=3
            R.id.bu4->cellID=4
            R.id.bu5->cellID=5
            R.id.bu6->cellID=6
            R.id.bu7->cellID=7
            R.id.bu8->cellID=8
            R.id.bu9->cellID=9
        }

//        Log.d("buclick: ",buSelected.id.toString())
//        Log.d("buclick: cellID:  ",cellID.toString())
        playGame(cellID,buSelected)
    }

    var actPlayer=1

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()

    fun playGame(cellID:Int , buSelected:Button){

        if(actPlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            actPlayer=2
            autoPlay()
//            try {
//
//            }catch (E:Exception){
//                var r=restartGame()
//                Toast.makeText(this,"Draw $r",Toast.LENGTH_SHORT).show()
//
//            }
        }else{
            buSelected.text="O"
            buSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellID)
            actPlayer=1
        }
        buSelected.isEnabled=false
        checkWinner()
    }
    fun checkWinner(){

        var winner=-1

        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }

        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }

        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }

        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }

        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //dig1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        //dig2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if(winner==1){
            player1Winscount+=1
            Toast.makeText(this, "Player 1 win the game",Toast.LENGTH_LONG).show()
            restartGame()
        }
        if(winner==2){
            player2Winscount+=1
            Toast.makeText(this, "Player 2 win the game",Toast.LENGTH_LONG).show()
            restartGame()
        }


    }
    fun autoPlay(){

        var emptyCells = ArrayList<Int>()

        for (cellID :Int in 1..9) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }
        if(emptyCells.size==0){
            restartGame()
        }

           try{

               val r= Random()
            val randIndex = r.nextInt(emptyCells.size)
        val cellID = emptyCells[randIndex]


        var buSelected:Button?
        buSelected=when(cellID){
            1->bu1
            2->bu2
            3->bu3
            4->bu4
            5->bu5
            6->bu6
            7->bu7
            8->bu8
            9->bu9
            else ->{bu1}
        }
        playGame(cellID,buSelected)}
           catch(E:IllegalArgumentException) {
                  restartGame()
           }
    }
    var player1Winscount=0
    var player2Winscount=0
fun restartGame(){
    actPlayer=1
    player1.clear()
    player2.clear()

    for(cellID in 1..9){

        var buSelected:Button?
        buSelected=when(cellID){
            1->bu1
            2->bu2
            3->bu3
            4->bu4
            5->bu5
            6->bu6
            7->bu7
            8->bu8
            9->bu9
            else ->{bu1}
        }
        buSelected!!.text=""
        buSelected!!.setBackgroundResource(R.color.white)
        buSelected!!.isEnabled=true
    }
    Toast.makeText(this,"Player1 : $player1Winscount,Player2 : $player2Winscount",Toast.LENGTH_LONG).show()
}
}

//private operator fun <E> ArrayList<E>.invoke(randIndex: E): Int {
//return 0:
//}

//}









