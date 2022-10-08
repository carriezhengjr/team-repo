package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;

import javafx.stage.Stage;

//@@author carriezhengjr-reused
//Reused from https://github.com/se-edu/addressbook-level4/blob/master/src/test/java/
// seedu/address/ui/HelpWindowTest.java
// with minor modifications.

/**
 * Test class for HelpWindow.
 */
public class HelpWindowTest extends GuiUnitTest {

    private HelpWindow helpWindow;

    @BeforeEach
    public void setUp() throws Exception {
        guiRobot.interact(() -> helpWindow = new HelpWindow());
        FxToolkit.registerStage(helpWindow::getRoot);
    }

    /**
     * Tests the behaviour of help window when it is opened.
     */
    @Test
    public void isShowing_helpWindowIsShowing_returnsTrue() {
        guiRobot.interact(helpWindow::show);
        assertTrue(helpWindow.isShowing());
    }

    /**
     * Tests the behaviour of help window when it is not opened.
     */
    @Test
    public void isShowing_helpWindowIsHiding_returnsFalse() {
        assertFalse(helpWindow.isShowing());
    }

    /**
     * Tests the behaviour of help window when it is hidden.
     */
    @Test
    public void isHiding_helpWindowHidden_returnsTrue() {
        guiRobot.interact(helpWindow::hide);
        assertTrue(helpWindow.isHiding());
    }

    /**
     * Tests the behaviour of help window in focus and not in focus.
     * When there is a focus on another stage, the focus on the help window should be removed.
     * When the focus is set on the help window again, it should be focused.
     */
    @Test
    public void focus_helpWindowNotFocused_focused() {
        guiRobot.interact(helpWindow::show);

        guiRobot.interact(() -> {
            Stage temporaryStage = new Stage();
            temporaryStage.show();
            temporaryStage.requestFocus();
        });
        assertFalse(helpWindow.getRoot().isFocused());

        guiRobot.interact(helpWindow::focus);
        assertTrue(helpWindow.getRoot().isFocused());
    }
}
