package seedu.address.ui.testutil;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testfx.api.FxToolkit;

//@@author carriezhengjr-reused
//Reused from https://github.com/se-edu/addressbook-level4/blob/master/src/test/java/
// seedu/address/ui/testutil/StageExtension.java

/**
 * Properly sets up and tears down a JavaFx stage for our testing purposes.
 */
public class StageExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        FxToolkit.registerPrimaryStage();
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        FxToolkit.cleanupStages();
    }
}

