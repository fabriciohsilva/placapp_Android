package br.com.fabriciohsilva.placapp


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var goalAway = 0
    var goalHome = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tvHome.text = intent.getStringExtra("home")
        tvAway.text = intent.getStringExtra("away")

        if (savedInstanceState != null) {
            goalHome = savedInstanceState.getInt("goalHome")
            goalAway = savedInstanceState.getInt("goalAway")
        }//end if (savedInstanceState != null)

        tvGoalHome.text = goalHome.toString()
        tvGoalAway.text = goalAway.toString()

        btGoalHome.setOnClickListener {
            goalHome++
            tvGoalHome.text = goalHome.toString()
        }//end btGoalHome.setOnClickListener

        btGoalAway.setOnClickListener {
            goalAway++
            tvGoalAway.text = goalAway.toString()
        }//end btGoalAway.setOnClickListener

    }//end override fun onCreate

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("goalHome", goalHome)
        outState?.putInt("goalAway", goalAway)

    }//end override fun onSaveInstanceState

}//end class GameActivity
