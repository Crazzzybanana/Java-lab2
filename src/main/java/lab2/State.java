package lab2;

import static lab2.FSM.*;

public abstract class State {
    StateFSM states;

    public State(StateFSM states){
        this.states = states;
    }

    public abstract States Digit();
    public abstract States Percent();
    public abstract States Asterisk();
    public abstract States Letter();
    public abstract States Sharp();
}
