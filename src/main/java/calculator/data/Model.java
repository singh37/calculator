package calculator.data;

import javax.swing.*;

public class Model {
    public boolean on=false;
    public String previousScreen="";
    public String screen="";


    public enum Operator {
        empty,plus, minus,equal,sqrroot,square,recip,multiply,division
    }
    public Operator operatorEnum=Operator.empty;
    public String operatorString="";
    public boolean bFloat;
    public String getDescription(){
        String ret="";
        if(operatorEnum!=Operator.empty){
            ret=previousScreen+" "+operatorString+" "+screen;
        }else ret=screen;
        return ret;

    }

}
