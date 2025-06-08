package com.demoqa.suites;

import com.demoqa.base.BaseTest;
import com.demoqa.windows.NewTabWindow;
import org.testng.annotations.BeforeClass;

public class BrowserWindowsBaseTest extends BaseTest {
    protected NewTabWindow newTabWindow;

    @BeforeClass(description = "Initialize window POMs")
    public void initializePom() {
        newTabWindow = new NewTabWindow(driver);
    }
}
