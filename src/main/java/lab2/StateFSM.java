package lab2;

public class StateFSM extends FSM{
    private State state;
    static Q0 q0;
    static Q1 q1;
    static Q2 q2;
//    static ERROR error;


    public StateFSM(){
        this.q0 = new Q0(this);
        this.q1 = new Q1(this);
        this.q2 = new Q2(this);
//        this.error = new ERROR(this);
        this.state = new Q0(this);
    }

    public void handleState(State state){
        this.state = state;
    }

    @Override
    States nextState(Events event) {
        if(event == null) return States.ERROR;
        if(event == Events.DIGIT) return this.state.Digit();
        if(event == Events.PERCENT) return this.state.Percent();
        if(event == Events.ASTERISK) return this.state.Asterisk();
        if(event == Events.LETTER) return this.state.Letter();
//        if(event == Events.SHARP) return this.state.Sharp();
//        return States.ERROR;
        return this.state.Sharp();
    }
}
