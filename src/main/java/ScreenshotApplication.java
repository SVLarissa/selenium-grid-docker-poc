import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ScreenshotApplication {

  RemoteWebDriver driver;

  public ScreenshotApplication() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    driver.manage().window().maximize();
  }

  public void takeScreenshot(String url, String filename) throws IOException {
    driver.navigate().to(url);
    Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
    ImageIO.write(screenshot.getImage(), "PNG", new File(filename + ".png"));
  }
}
