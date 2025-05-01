package com.demoqa.suites;

import com.demoqa.base.BaseTest;
import com.demoqa.windows.SmallDialogModalWindow;
import com.demoqa.windows.LargeDialogModalWindow;
import org.testng.annotations.BeforeClass;

public class ModalPageBaseTest extends BaseTest {
    protected SmallDialogModalWindow smallDialogModalWindow;
    protected LargeDialogModalWindow largeDialogModalWindow;

    @BeforeClass
    public void setUpModalPage() {
        smallDialogModalWindow = new SmallDialogModalWindow(driver);
        largeDialogModalWindow = new LargeDialogModalWindow(driver);
    }
}
