package sikuli;

import java.util.Set;
import java.util.concurrent.*;
import java.io.File;
import java.net.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import org.sikuli.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.TextRecognizer;

public class Android {
	static String path = "C:\\Users\\M4TTH3W\\eclipse-workspace\\TatwinCW3\\resources\\Android\\";//needs to be modified to match current res folder if downloaded from github
	static Pattern STARTAPP = new Pattern(path + "startapp.png");
	static Pattern TOAST = new Pattern(path + "toast.png");
	static Pattern TOASTSUCCESS = new Pattern(path + "toastsuccess.png");
	static Pattern BUTTON = new Pattern(path + "button.png");
	static Pattern NONO = new Pattern(path + "nono.png");
	static Pattern NONORES = new Pattern(path + "nonoresponse.png");
	static Pattern EXC = new Pattern(path + "unhandledexception.png");
	static Pattern APPCRASH = new Pattern(path + "appcrash.png");
	static Pattern CLOSE = new Pattern(path + "close.png");
	  public static void main(String[] args) throws FindFailed, InterruptedException {
		  Screen scr = new Screen(0);
		  //Test one - tries to find toast
		  try {
		  Match start = scr.find(STARTAPP);
		  scr.hover(start);
		  scr.click(start);
		  } catch (Exception e) {
			  System.out.println("Match not found");
			  e.printStackTrace();
		  }
		  //wait(2)
		  try {
		  Thread.sleep(2000);
		  Match toast = scr.find(TOAST);
		  toast.click();
		  Thread.sleep(1000);
		  } catch (Exception e) {
			  System.out.println("Match not found");
			  e.printStackTrace();
		  }
		  try {
		  Match toastsuccess = scr.find(TOASTSUCCESS);
		  System.out.println("Match found");
		  
		  } catch (Exception e) {
			  System.out.println("Match not found");
			  e.printStackTrace();
		  }
		  //test 2 - click nono and try to find a toast
		  try {
		  Match button = scr.find(BUTTON);
		  button.click();
		  } catch (Exception e) {
			  System.out.println("Match not found");
			  e.printStackTrace();
		  }
		  try {
			  Thread.sleep(1000);
		  Match nono = scr.find(NONO);
		  nono.click();
		  } catch (Exception e) {
			  System.out.println("Match not found");
			  e.printStackTrace();
		  }
		  try {
			  Thread.sleep(1000);
			  Match nonores = scr.find(NONORES);
			  System.out.println("Activity will continue");
			  } catch (Exception e) {
				  System.out.println("Match not found");
				  e.printStackTrace();
			  }
		  //test 3 - app throws unhandled expection and quits itself
		  try {
			  Match exception = scr.find(EXC);
			  exception.click();
			  Thread.sleep(1000);
			  exception.type("1");
			  Thread.sleep(1000);
		  } catch (Exception e) {
			  System.out.println("Match not found");
			  e.printStackTrace();
		  }
		  try {
			  Match appcrash = scr.find(APPCRASH);
			  System.out.println("App crashed with error output successfull");
			  Thread.sleep(1000);
			  Match closeapp = scr.find(CLOSE);
			  closeapp.click();
		  } catch (Exception e) {
			  System.out.println("App crashed, but no error outputed onto screen");
			  e.printStackTrace();
		  }
		  // test 4 - just to test ocr - done just for testing purpose - not part of excercise!
/*		  Thread.sleep(1000);
		  Match start1 = scr.find(STARTAPP);
		  start1.click();
		  Thread.sleep(1000);
	        File imageFile = new File("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata\\app.png");
	        ITesseract instance = new Tesseract();
	        try {
	            String result = instance.doOCR(imageFile);
	            System.out.println(result);
	        } catch (TesseractException e) {
	            System.err.println(e.getMessage());
	        }
*/

	  }

}
