package lab2;

public class TransTableFSM extends FSM {
    final States [][] StateTable = {
            {States.ERROR, States.ERROR, States.q3},
            {States.q1,    States.q1,    States.ERROR},
            {States.ERROR, States.q2,    States.q2},
            {States.ERROR, States.q2,    States.ERROR},
            {States.ERROR, States.q2,    States.ERROR}
    };

    @Override
    States nextState(Events event) {
        if(event == null) return States.ERROR;
        return StateTable[event.ordinal()][_currentState.ordinal()];
    }
}
