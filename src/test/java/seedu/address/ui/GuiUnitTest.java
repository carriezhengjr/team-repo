package seedu.address.ui;

import java.util.Optional;

import org.junit.jupiter.api.extension.RegisterExtension;

import guitests.GuiRobot;
import guitests.exceptions.NodeNotFoundException;
import javafx.scene.Node;
import seedu.address.ui.testutil.UiPartExtension;

//@@author carriezhengjr-reused
//Reused from https://github.com/se-edu/addressbook-level4/blob/master/src/test/java/seedu/address/ui/GuiUnitTest.java

/**
 * A GUI unit test class for AddressBook.
 */
public abstract class GuiUnitTest {

    @RegisterExtension
    public final UiPartExtension uiPartExtension = new UiPartExtension();

    protected final GuiRobot guiRobot = new GuiRobot();

    /**
     * Retrieves the {@code query} node owned by the {@code rootNode}.
     *
     * @param query name of the CSS selector of the node to retrieve.
     * @throws NodeNotFoundException if no such node exists.
     */
    protected <T extends Node> T getChildNode(Node rootNode, String query) {
        Optional<T> node = guiRobot.from(rootNode).lookup(query).tryQuery();
        return node.orElseThrow(NodeNotFoundException::new);
    }
}
