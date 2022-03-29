package calculator.gui;

import calculator.data.ButtonData;
import calculator.data.RadioData;
import calculator.data.TextFieldData;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class View extends JFrame {
    private JButton[] buttons;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JTextField textField;
    private JTextField textField1;
    private JCheckBoxMenuItem item1;

    public JButton[] getButtons() {
        return buttons;
    }

    public JRadioButton getRadio1() {
        return radio1;
    }

    public JRadioButton getRadio2() {
        return radio2;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JCheckBoxMenuItem getItem1() {
        return item1;
    }

    public JCheckBoxMenuItem getItem2() {
        return item2;
    }

    private JCheckBoxMenuItem item2;   public View(){
        initComponents();
    }
    void initComponents(){

        buttons=new JButton[21];
        ButtonGroup radioGroup = new ButtonGroup();
        ArrayList<ButtonData> bts=new ArrayList<ButtonData>();
        int posy=30;
        bts.add(new ButtonData(11, 471-posy, 149, 46,"0",23,null,null));
        bts.add(new ButtonData(11, 402-posy, 69, 46,"1",23,null,null));
        bts.add(new ButtonData(92, 402-posy, 69, 46,"2",23,null,null));
        bts.add(new ButtonData(172, 402-posy, 69, 46,"3",23,null,null));
        bts.add(new ButtonData(11, 333-posy, 69, 46,"4",23,null,null));
        bts.add(new ButtonData(92, 333-posy, 69, 46,"5",23,null,null));
        bts.add(new ButtonData(172, 333-posy, 69, 46,"6",23,null,null));
        bts.add(new ButtonData(11, 264-posy, 69, 46,"7",23,null,null));
        bts.add(new ButtonData(92, 264-posy, 69, 46,"8",23,null,null));
        bts.add(new ButtonData(172, 264-posy, 69, 46,"9",23,null,null));
        bts.add(new ButtonData(172, 471-posy, 69, 46,".",23,null,null));
        bts.add(new ButtonData(253, 402-posy, 69, 115,"=",23,null,Color.yellow));
        bts.add(new ButtonData(253, 126-posy, 69, 46,"/",23,null,Color.yellow));
        bts.add(new ButtonData(11, 195-posy, 69, 46,"\u221A",18,null,null));
        bts.add(new ButtonData(253, 264-posy, 69, 46,"x",23,null,Color.yellow));
        bts.add(new ButtonData(253, 195-posy, 69, 46,"-",23,null,Color.yellow));
        bts.add(new ButtonData(253, 333-posy, 69, 46,"+",23,null,Color.yellow));
        bts.add(new ButtonData(92, 195-posy, 69, 46,"x\u00B2",18,null,null));
        bts.add(new ButtonData(172, 195-posy, 69, 46,"1/x",14,null,null));
        bts.add(new ButtonData(172, 126-posy, 69, 46,"DEL",12,null,Color.red));
        bts.add(new ButtonData(92, 126-posy, 69, 46,"C",12,null, Color.red));
        int i=0;
        for(ButtonData b : bts){
            buttons[i]=b.getButton();
            add(buttons[i]);
            ++i;
        }
        RadioData rddata1=new RadioData(11, 109-posy+5, 69, 46,"On",10,true,new Color(255,255,255),new Color(3,2,3));
        RadioData rddata2=new RadioData(11, 138-posy+5, 69, 46,"Off",10,false,new Color(255,255,255),new Color(3,2,3));
        TextFieldData textfData=new TextFieldData(11, 46-posy+20, 310, 46,"",23,false,false,null,null);
        TextFieldData textfData1=new TextFieldData(11, 46-posy-10, 310, 20,"",16,false,true,new Color(231, 189, 64),new Color(3,2,3));
        radio1 = rddata1.getRadio();
        radio2 = rddata2.getRadio();
        add(radio1);
        add(radio2);
        setResizable(false);
        textField = textfData.getTextField();


        textField1 = textfData1.getTextField();

        textField1.setBorder(new LineBorder(Color.BLACK, 0));
        add(textField);
        add(textField1);
        radioGroup.add(radio1);
        radioGroup.add(radio2);
        JMenuBar mBar = new JMenuBar();
        JMenu menu=new JMenu("Calculator type");
        mBar.add(menu);
        item1 = new JCheckBoxMenuItem  ("Integer");
        item1.setSelected(true);
        item2 = new JCheckBoxMenuItem  ("Floating-Point");
        menu.add(item1);
        menu.add(item2);
        setJMenuBar(mBar);

    }
}

