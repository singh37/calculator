package calculator.data;

import javax.swing.*;
import java.awt.*;

public class ButtonData {
    private int x;
    private int y;
    private int width;
    private int height;
    private String content;
    private int fontSize;
    private Color front;
    private Color back;

    public ButtonData(int x, int y, int width, int height, String content, int fontSize, Color front, Color back) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.content = content;
        this.fontSize = fontSize;
        this.front = front;
        this.back = back;
    }

    public JButton getButton(){
        JButton button = new JButton(content);
        if(front!=null)
            button.setForeground(front);
        if(back!=null)
            button.setBackground(back);
        button.setBounds(x, y, width, height);
        Font font=new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        button.setFont(font);
        return button;
    }
}
