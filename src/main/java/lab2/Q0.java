package lab2;

import static lab2.FSM.*;

class Q0 extends State {
    public Q0(StateFSM states) {
        super(states);
    }

    @Override
    public States Digit() {
        states.handleState(StateFSM.q1);
        return States.q1;
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
//        states.handleState(StateFSM.error);
        return States.ERROR;
    }

    @Override
    public States Sharp() {
//        states.handleState(StateFSM.error);
        return States.ERROR;
    }
}
