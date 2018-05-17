package lab2;

import static lab2.FSM.*;

class Q2 extends State {

    public Q2(StateFSM states) {
        super(states);
    }

    @Override
    public States Digit() {
//        states.handleState(StateFSM.error);
        return States.ERROR;
    }

    @Override
    public States Percent() {
//        states.handleState(StateFSM.error);
        return States.ERROR;
    }

    @Override
    public States Asterisk() {
//        states.handleState(StateFSM.error);
        return States.ERROR;
    }

    @Override
    public States Letter() {
        return States.q2;
    }

    @Override
    public States Sharp() {
        return States.q3;
    }
}
