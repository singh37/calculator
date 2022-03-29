package calculator.data;

import javax.swing.*;
import java.awt.*;

public class TextFieldData {
    private int x;
    private int y;
    private int width;
    private int height;
    private String content;
    private int fontSize;
    private boolean editable;
    private boolean left;
    private Color front;
    private Color back;

    public TextFieldData(int x, int y, int width, int height, String content, int fontSize,boolean editable,boolean left, Color front, Color back) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.content = content;
        this.fontSize = fontSize;
        this.front = front;
        this.back = back;
        this.editable=editable;
        this.left=left;
    }

    public JTextField getTextField(){
        JTextField textField = new JTextField(content);
        if(left)textField.setHorizontalAlignment(SwingConstants.LEFT);
        else textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(editable);
        if(front!=null)
            textField.setForeground(front);
        if(back!=null)
            textField.setBackground(back);
        textField.setBounds(x, y, width, height);
        Font font=new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        textField.setFont(font);
        return textField;
    }
}
