package lab2;

public class SwitchFSM extends FSM {
    @Override
    States nextState(Events event) {
        if(event == null) return States.ERROR;
        switch (event) {
            case DIGIT:
                switch (_currentState){
                    case q0: return States.q1;
                    case q1: return States.q1;
                    default: return States.ERROR;
                }
            case PERCENT:
                switch (_currentState){
                    case q1: return States.q2;
                    default: return States.ERROR;
                }
            case ASTERISK:
                switch (_currentState){
                    case q1: return States.q2;
                    default: return States.ERROR;
                }
            case LETTER:
                switch (_currentState){
                    case q1: return States.q2;
                    case q2: return  States.q2;
                    default: return States.ERROR;
                }
//            case SHARP:
//                switch (_currentState){
//                    case q2: return States.q3;
//                    default: return States.ERROR;
//                }
//                default: return States.ERROR;
                default:
                    switch (_currentState){
                        case q2: return States.q3;
                        default: return States.ERROR;
                }
        }
    }
}
