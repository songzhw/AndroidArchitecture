package ca.six.archi.demo.hsm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var parents: Array<IState> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

object UserState {
    var state = LoggedOut
}

interface IState {
    val parents: ArrayList<IState>
        get() = arrayListOf()
}

object LoggedOut : IState

object LoggedIn : IState

// = = = = = = = = = = =
object AbnormalUser : IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn)
}

object InsecureUser : IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn, AbnormalUser)
}

object LockedUser : IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn, AbnormalUser)
}

// = = = = = = = = = = =
object DepositUser: IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn)
}

object InvestUser: IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn)
}

object DepositRegularUser: IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn, DepositUser)
}

object DepositVipUser: IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn, DepositUser)
}

object InvestRegularUser: IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn, InvestUser)
}

object InvestVipUser: IState {
    override val parents: ArrayList<IState>
        get() = arrayListOf(LoggedIn, InvestUser)
}