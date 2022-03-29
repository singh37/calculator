
import calculator.data.Model;
import calculator.gui.View;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Test
    void testController() throws Exception {
        View v = new View();
        Model m = new Model();
        Controller controller = new Controller(v, m);
        controller.begin(false);
        controller.ChangeToInteger();
        controller.ButtonPressed("1");
        controller.ButtonPressed("+");
        controller.ButtonPressed("1");
        controller.ButtonPressed("0");
        controller.ButtonPressed("=");
        Assert.assertEquals(v.getTextField().getText(),"11");


    }
    @Test
    void testController1() throws Exception {
        View v = new View();
        Model m = new Model();
        Controller controller = new Controller(v, m);
        controller.begin(false);
        controller.ChangeToInteger();
        controller.ButtonPressed("4");
        controller.ButtonPressed("x");
        controller.ButtonPressed("5");
        controller.ButtonPressed("=");
        Assert.assertEquals(v.getTextField().getText(),"20");
    }
    @Test
    void testController2() throws Exception {
        View v = new View();
        Model m = new Model();
        Controller controller = new Controller(v, m);
        controller.begin(false);
        controller.ChangeToFloat();
        controller.ButtonPressed("4");
        controller.ButtonPressed("x\u00B2");
        Assert.assertEquals(v.getTextField().getText(),"16.0");
    }
}