package calculator.gui;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    @Test
    void testGui() {
        View v=new View();
        Assert.assertEquals(v.getButtons().length,21);
        Assert.assertEquals(v.getButtons()[0].getText(),"0");
        Assert.assertEquals(v.getButtons()[20].getText(),"C");
        Assert.assertEquals(v.getItem1().getText(),"Integer");
        Assert.assertEquals(v.getItem2().getText(),"Floating-Point");
        Assert.assertEquals(v.getRadio1().isSelected(),true);
        Assert.assertEquals(v.getRadio2().isSelected(),false);
        Assert.assertEquals(v.getTextField().isEditable(),false);
        Assert.assertEquals(v.getTextField1().isEditable(),false);

    }
}