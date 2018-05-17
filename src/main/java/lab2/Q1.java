package lab2;

import static lab2.FSM.*;

class Q1 extends State {

    public Q1(StateFSM states) {
        super(states);
    }

    @Override
    public States Digit() {
        return States.q1;
    }

    @Override
    public States Percent() {
        states.handleState(StateFSM.q2);
        return States.q2;
    }

    @Override
    public States Asterisk() {
        states.handleState(StateFSM.q2);
        return States.q2;
    }

    @Override
    public States Letter() {
        states.handleState(StateFSM.q2);
        return States.q2;
    }

    @Override
    public States Sharp() {
//        states.handleState(StateFSM.error);
        return States.ERROR;
    }
}
