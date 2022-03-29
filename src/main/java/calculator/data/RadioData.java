package calculator.data;

import javax.swing.*;
import java.awt.*;

public class RadioData {
    private int x;
    private int y;
    private int width;
    private int height;
    private String content;
    private int fontSize;
    private boolean selected;
    private Color front;
    private Color back;


    public RadioData(int x, int y, int width, int height, String content, int fontSize, boolean selected, Color front, Color back) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.content = content;
        this.fontSize = fontSize;
        this.selected=selected;
        this.front = front;
        this.back = back;
    }

    public JRadioButton getRadio(){
        JRadioButton radio = new JRadioButton(content);
        radio.setSelected(selected);
        if(front!=null)
            radio.setForeground(front);
        if(back!=null)
            radio.setBackground(back);
        radio.setBounds(x, y, width, height);
        Font font=new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        radio.setFont(font);
        return radio;
    }
}
