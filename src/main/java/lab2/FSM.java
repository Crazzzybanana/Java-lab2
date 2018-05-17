package lab2;

import static java.lang.Character.*;

abstract class FSM {
    public enum States{
        q0,
        q1,
        q2,
        q3,
        ERROR
    }

    public enum Events{
        SHARP,
        DIGIT,
        LETTER,
        ASTERISK,
        PERCENT
    }

    public States _currentState = States.q0;

    Events recognizeEvent(char ch){
        if(isDigit(ch)) return Events.DIGIT;
        if(isUpperCase(ch) && isAlphabetic(ch)) return Events.LETTER;
        if(compare(ch, '*') == 0) return  Events.ASTERISK;
        if(compare(ch, '%') == 0) return  Events.PERCENT;
        if(compare(ch, '#') == 0) return  Events.SHARP;
        return null;
    }

    public boolean scanString(String str){
        if(str == null || str.length() == 0) return false;
        for(int i = 0; i < str.length(); i++){
            if(_currentState == States.ERROR) return false;
            char c = str.charAt(i);
            _currentState = nextState(recognizeEvent(c));
        }
        if(_currentState == States.q3) return true;
        return false;
    }

    abstract States nextState(Events event);
}
