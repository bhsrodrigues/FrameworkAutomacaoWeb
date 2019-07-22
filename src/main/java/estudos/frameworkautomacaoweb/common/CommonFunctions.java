package estudos.frameworkautomacaoweb.common;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class CommonFunctions {
	public static WebDriver driver;
	
	public static int screenshotIndex;
	
	public static String scenarioName;

	private static String folderName,folderPath;
	
	private static boolean firstTest = true;
	
	public static void firstExecution() {
		if (firstTest) {
			folderName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + "\\";
			firstTest = false;
		}
		folderPath = "screenshots\\"+ folderName;
		File file = new File(folderPath);
        if (!file.exists()) {
        	file.mkdirs();
        }
	}
	
	private String screenshotName(String scenario) {
		
		DecimalFormat zeroFormatter = new DecimalFormat("0000");
		Date dateobj = new Date();
		String day = new SimpleDateFormat("dd-MM-yyyy").format(dateobj);
		String hours = new SimpleDateFormat("HH.mm.ss").format(dateobj);
		String fullDate = day + " às " + hours;
		
		return zeroFormatter.format(screenshotIndex) +  " - " + scenario  + "_-_Em " + fullDate; 
		
	}
	
	private byte[] getImageData(String fullPath) throws Exception {
		BufferedImage bImage = ImageIO.read(new File(fullPath));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos);
		byte[] data = bos.toByteArray();
		return data;
	}
	

	
	@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] saveScreenshot(byte[] screenShot) {
	    return screenShot;
	}
	
	/***
	 * Método para captura de tela completa no momento do teste, mostrando data e hora.
	 * Caso esse método seja utilizado, não se deve mexer na máquina enquanto os testes estiverem em andamento (principalmente troca de janelas),
	 * uma vez que a captura será da tela com foco naquele momento
	 * @param addToReport Se imagem deverá ser adicionada ao report ou apenas gerada.
	 */
	public void takeScreenshotFullScreen(boolean addToReport) {
		try {
            Robot robot = new Robot();
            String format = "jpg";
            
            String fileName = folderPath + screenshotName(scenarioName) + "." + format;
           
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureRect = new Rectangle(0, 0, screenSize.width, screenSize.height);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
            screenshotIndex++;
            
            if (addToReport) {
            	saveScreenshot(getImageData(fileName));
            }
           
            
        } catch (AWTException ex) {
            System.err.println(ex);
        }catch (Exception ex) {
        	System.err.println(ex);
        } 
	}
	
	public void takeScreenshotPage()
	{		

		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String fullPath = folderPath + screenshotName(scenarioName) + ".png";
			screenshotIndex++;
			FileUtils.copyFile(src, new File(fullPath));
		}catch(Exception ex) {
			System.out.println("Não foi possível gerar o print da tela");
		}
				
	}

}
