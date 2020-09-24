import java.io.IOException;

public class TestSeleniumScreenshot {

  @org.junit.Test
  public void takeScreenshotOfGoogle() throws IOException {
    ScreenshotApplication screenshotApplication = new ScreenshotApplication();
    screenshotApplication.takeScreenshot("https://google.com", "/tmp/goog");
  }
}
