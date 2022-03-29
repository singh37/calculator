
import calculator.data.Model;
import calculator.gui.View;

import javax.swing.*;
import java.awt.*;

public class Controller {
    calculator.data.Model model;
    View view;
    public Controller(View view,Model model){
        this.model=model;
        this.view=view;
    }
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                View v = new View();
                Model m = new Model();
                Controller controller = new Controller(v, m);
                controller.begin(true);
            }
        });
    }
    void initActions(){
        for(int i=0;i<21;++i)
            view.getButtons()[i].addActionListener(e -> ButtonPressed(((JButton)e.getSource()).getText()));
        view.getItem1().addActionListener(e->ChangeToInteger());
        view.getItem2().addActionListener(e->ChangeToFloat());
        view.getRadio1().addActionListener(e->On());
        view.getRadio2().addActionListener(e->Off());
    }

    private void Off() {
        model.on=(false);
        reset();
        updateScreen();
    }
    private void On() {
        model.on=(true);
        reset();
        updateScreen();
    }
    void updateScreen(){
        if(!model.on)
        {

            view.getTextField().setText("");
            view.getTextField1().setText("");

            return;
        }

        if(model.screen==""){
            if(model.previousScreen!="")
                view.getTextField().setText(model.previousScreen);
            else view.getTextField().setText("0");
        }
        else
            view.getTextField().setText(model.screen);
        view.getTextField1().setText(model.getDescription());
    }

    public void ChangeToFloat() {
        model.bFloat=(true);
        reset();
        view.getItem2().setSelected(true);
        view.getItem1().setSelected(false);
        updateScreen();
    }

    public void ChangeToInteger() {
        model.bFloat=(false);
        reset();
        view.getItem1().setSelected(true);
        view.getItem2().setSelected(false);
        updateScreen();
    }

    public void ButtonPressed(String btn) {
        switch (btn){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                try {
                    addNumber(btn);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(view,e.getMessage());
                }
                break;
            case "+":
            case "-":
            case "x":
            case "/":
            case "=":
            case "x\u00B2":
            case "1/x":
            case "\u221A":
                try {
                    runOperator(btn);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(view,e.getMessage());
                }
            case "C":
            case "DEL":
                runClear(btn);
                break;
        }
        updateScreen();
    }

    public void begin(boolean showWindow) {
        initActions();

        this.view.getContentPane().setLayout(null);
        this.view.getContentPane().setBackground(new Color(3,2,3));
        this.view.setTitle("Calculator");
        this.view.setSize(345, 563);
        this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        model.on=(true);
        updateScreen();
        if(showWindow)this.view.setVisible(true);
    }
    public void addNumber(String btn) {
        Model m=model;
        if(btn=="0" && m.screen.equals("0")) return;
        if(m.screen.equals("0"))m.screen="";
        if(btn!=".")
            m.screen=m.screen+btn;
        else if(m.bFloat && !m.screen.contains("."))
        {
            if(m.screen.equals(""))m.screen="0";
            m.screen=m.screen+btn;
        }
    }

    public void runOperator(String btn) throws Exception {
        Model m=model;
        if(m.previousScreen.equals("Infinity"))m.previousScreen="";
        if(m.screen.equals("Infinity"))m.previousScreen="";
        if(m.operatorEnum!= Model.Operator.empty){
            if(m.screen!="") doPreviuosOperation();
        }

        switch (btn){
            case  "=":
                if(m.screen=="")return;
                m.operatorEnum= Model.Operator.empty;
                m.operatorString="";
                m.previousScreen=m.screen;
                m.screen="";
                return;
            case "x\u00B2":
            {
                m.operatorEnum= Model.Operator.empty;
                m.operatorString="";
                float val=0;
                String current=m.screen;
                if(current=="") current=m.previousScreen;
                if(current!=""){
                    val=Float.valueOf(current)*Float.valueOf(current);
                }
                m.screen="";
                if(m.bFloat)
                    m.previousScreen=""+val;
                else
                    m.previousScreen=""+(int)val;
                return;
            }
            case "1/x":
            {
                m.operatorEnum= Model.Operator.empty;
                m.operatorString="";
                float val=0;
                String current=m.screen;
                if(current=="") current=m.previousScreen;
                if(current!=""){
                    if(Float.valueOf(current)==0)
                        throw new Exception("Divide By Zero");
                    val=1/Float.valueOf(current);
                }else throw new Exception("Divide By Zero");
                m.screen="";
                if(m.bFloat)
                    m.previousScreen=""+val;
                else
                    m.previousScreen=""+(int)val;
                return;
            }
            case "\u221A":
            {
                m.operatorEnum= Model.Operator.empty;
                m.operatorString="";
                float val=0;
                String current=m.screen;
                if(current=="") current=m.previousScreen;
                if(current!=""){
                    if(Float.valueOf(current)<0)
                        throw new Exception("Root of negative number");
                    val=(float)Math.sqrt(Float.valueOf(current));
                }
                m.screen="";
                if(m.bFloat)
                    m.previousScreen=""+val;
                else
                    m.previousScreen=""+(int)val;
                return;


            }

            case "+":
                m.operatorEnum= Model.Operator.plus;
                m.operatorString="+";
                if(m.screen!="")m.previousScreen=m.screen;
                m.screen="";
                break;
            case "-":
                m.operatorEnum= Model.Operator.minus;
                m.operatorString="-";
                if(m.screen!="")m.previousScreen=m.screen;
                m.screen="";
                break;
            case "x":
                m.operatorEnum= Model.Operator.multiply;
                m.operatorString="x";
                if(m.screen!="")m.previousScreen=m.screen;
                m.screen="";
                break;
            case "/":
                m.operatorEnum= Model.Operator.division;
                m.operatorString="/";
                if(m.screen!="")m.previousScreen=m.screen;
                m.screen="";
                break;
        }
    }
    public void reset(){
        Model m=model;
        m.screen="";
        m.previousScreen="";
        m.operatorEnum= Model.Operator.empty;
        m.operatorString="";
    }
    private void doPreviuosOperation() throws  Exception{
        Model m=model;

        if(m.operatorEnum== Model.Operator.plus){
            if(m.previousScreen=="")return;
            float leftOperand=Float.valueOf(m.previousScreen);
            float rightOperand=Float.valueOf(m.screen);
            if(m.bFloat)
                m.screen=""+(leftOperand+rightOperand);
            else
                m.screen=""+((int)(leftOperand+rightOperand));
            m.operatorEnum= Model.Operator.empty;
            m.operatorString="";
            m.previousScreen="";

        }
        if(m.operatorEnum== Model.Operator.minus){
            if(m.previousScreen=="")return;
            float leftOperand=Float.valueOf(m.previousScreen);
            float rightOperand=Float.valueOf(m.screen);
            if(m.bFloat)
                m.screen=""+(leftOperand-rightOperand);
            else
                m.screen=""+((int)(leftOperand-rightOperand));

            m.operatorEnum= Model.Operator.empty;
            m.operatorString="";
            m.previousScreen="";
        }
        if(m.operatorEnum== Model.Operator.division){
            if(m.previousScreen=="")return;
            float leftOperand=Float.valueOf(m.previousScreen);
            float rightOperand=Float.valueOf(m.screen);
            if(m.bFloat)
                m.screen=""+(leftOperand/rightOperand);
            else
                m.screen=""+((int)(leftOperand/rightOperand));
            m.operatorEnum= Model.Operator.empty;
            m.operatorString="";
            m.previousScreen="";
        }
        if(m.operatorEnum== Model.Operator.multiply){
            if(m.previousScreen=="")return;
            float leftOperand=Float.valueOf(m.previousScreen);
            float rightOperand=Float.valueOf(m.screen);
            if(m.bFloat)
                m.screen=""+(leftOperand*rightOperand);
            else
                m.screen=""+((int)(leftOperand*rightOperand));

            m.operatorEnum= Model.Operator.empty;
            m.operatorString="";
            m.previousScreen="";
        }
    }

    public void runClear(String btn) {
        if(btn=="C")
            reset();
        else model.screen="";
    }

}

