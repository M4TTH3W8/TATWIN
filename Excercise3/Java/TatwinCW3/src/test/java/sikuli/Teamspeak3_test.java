package sikuli;

import java.util.List;

import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*
 * 		TEAMSPEAK 3 - 10 SIMPLE TESTS USING SIKULI 
 * 
 * 		TESTED WITH POLISH VERSION!
 * 
 * 1. User connects to a public test server using Connection tab
 * 2. User connects to a public test server using Bookmarks tab(and also disconnects from previous server)
 * 3. User sets nickname in Identities menu
 * 4. User tries to send a text message to whole server
 * 5. Test counts every online user visible currently on screen
 * 6. User enables Sound and Microphone mute, and then checks if his icon near nickname changed
 * 7. User checks if any of currently visited channels is moderated(requires special privileges)
 * 8. Test counts amount of currently visible private channels MAY BE 0 - fail!
 * 9. User displays window with connection informations.
 * 10. User disconnects from server and then quits program
 * 

 */


public class Teamspeak3_test {
	static String path = "C:\\Users\\M4TTH3W\\eclipse-workspace\\TatwinCW3\\resources\\Teamspeak3\\";//needs to be modified to match current res folder if downloaded from github
	static Pattern STARTAPP = new Pattern(path + "startapp.png");
	static Pattern OFFSET = new Pattern(path + "offset.png");
	static Pattern CONNECTICON = new Pattern(path + "connecticon.png");
	static Pattern CONNECTIONS = new Pattern(path + "connections.png");
	static Pattern CONNECT = new Pattern(path + "connect.png");
	static Pattern BOOKMARKS = new Pattern(path + "bookmarks.png");
	static Pattern TESTSERVER = new Pattern(path + "testserver.png");
	static Pattern TOOLS = new Pattern(path + "tools.png");
	static Pattern IDENTITY = new Pattern(path + "identity.png");
	static Pattern NICK = new Pattern(path + "nick.png");
	static Pattern OK = new Pattern(path + "ok.png");
	static Pattern CHAT = new Pattern(path + "chat.png");
	static Pattern NO = new Pattern(path + "no.png");
	static Pattern USER = new Pattern(path + "user.png");
	static Pattern MICROPHONE = new Pattern(path + "microphone.png");
	static Pattern SPEAKER = new Pattern(path + "speaker.png");
	static Pattern USERMUTED = new Pattern(path + "usermuted.png");
	static Pattern MODERATED = new Pattern(path + "moderated.png");
	static Pattern PRIVATE = new Pattern(path + "private.png");
	static Pattern TESTUSER = new Pattern(path + "testuser.png");
	static Pattern CONNECTIONINFO = new Pattern(path + "connectioninfo.png");
	static Pattern EXIT = new Pattern(path + "exit.png");

	public static void main(String[] args) throws FindFailed, InterruptedException {
		Screen scr = new Screen(0);
		//Test one 
		
		try {
			  Match start = scr.find(STARTAPP);
			  scr.click(start);
			  scr.type("teamspeak");
			  scr.type(Key.ENTER);
			  Thread.sleep(1500);
			  Match connections = scr.find(CONNECTIONS);
			  scr.click(connections);
			  Thread.sleep(500);
			  Match connecticon = scr.find(CONNECTICON);
			  scr.click(connecticon);
			  Thread.sleep(500);
			  scr.type("a", KeyModifier.CTRL);
			  scr.type(Key.BACKSPACE);
			  scr.type("voice.teamspeak.com");
			  Match connect = scr.find(CONNECT);
			  scr.click(connect);
			  Thread.sleep(4000);
			  } 
		catch (Exception e) {
				  System.out.println("Test one failed!");
				  e.printStackTrace();
			  }
		
		//Test two
		
		try {
			  Match bookmarks = scr.find(BOOKMARKS);
			  scr.click(bookmarks);
			  Thread.sleep(1000);
			  Match testserver = scr.find(TESTSERVER.targetOffset(0, 8));
			  scr.click(testserver);
			  Thread.sleep(4000);
			  } catch (Exception e) {
				  System.out.println("Test two failed!");
				  e.printStackTrace();
			  }

		//Test three
		 
		try {
			  Match tools = scr.find(TOOLS);
			  scr.click(tools);
			  Thread.sleep(1000);
			  Match identity = scr.find(IDENTITY);
			  scr.click(identity);
			  Thread.sleep(1000);
			  Match nick = scr.find(NICK.targetOffset(0, 20));
			  scr.click(nick);
			  Thread.sleep(1000);
			  scr.type("a", KeyModifier.CTRL);
			  scr.type(Key.BACKSPACE);
			  scr.type("atestid");
			  Match ok = scr.find(OK);
			  scr.click(ok);
			  Thread.sleep(4000);
			  } catch (Exception e) {
				  System.out.println("Test three failed!");
				  e.printStackTrace();
			  }
			  
		//Test four
		
		try {
		Match chat = scr.find(CHAT);
		  scr.click(chat);
		  scr.type("test" + Key.ENTER);
		  Thread.sleep(1000);
		Match no = scr.find(NO);
		scr.click(no);
		Thread.sleep(4000);
		  } catch (Exception e) {
			  System.out.println("Test four failed!");
			  e.printStackTrace();
		  }

		//Test five
		
		try {
			List<Match> user = scr.findAllList(USER);
			System.out.println(user);
			Thread.sleep(4000);
			  } catch (Exception e) {
				  System.out.println("Test five failed!");
				  e.printStackTrace();
			  }

		//Test six
		
		try {
		Match microphone = scr.find(MICROPHONE);
		scr.click(microphone);
		Match speaker = scr.find(SPEAKER);
		scr.click(speaker);
		Thread.sleep(1000);
		Match usermuted = scr.find(USERMUTED);
		Thread.sleep(4000);
			  } catch (Exception e) {
				  System.out.println("Test six failed!");
				  e.printStackTrace();
			  }

		//Test seven
		
		try {
			Match moderated = scr.find(MODERATED);
			System.out.println("Channel is moderated");
			Thread.sleep(4000);
				  } catch (Exception e) {
					  System.out.println("Test seven failed! - There are none moderated channels in your view!");
					  e.printStackTrace();
				  }

		//Test eight
		
		try {
			List<Match> private1 = scr.findAllList(PRIVATE);
			System.out.println(private1);
			Thread.sleep(4000);
				  } catch (Exception e) {
					  System.out.println("Test eight failed!");
					  e.printStackTrace();
				  }

		//Test nine
		
		try {
			Match testuser = scr.find(TESTUSER);
			scr.click(testuser);
			Thread.sleep(1000);
			Match connectioninfo = scr.find(CONNECTIONINFO);
			scr.click(connectioninfo);
			Thread.sleep(4000);
				  } catch (Exception e) {
					  System.out.println("Test nine failed!");
					  e.printStackTrace();
				  }

		//Test ten
		
		try {
			Thread.sleep(2000);
			Match exit = scr.find(EXIT);
			scr.click(exit);
			Match exit1 = scr.find(EXIT);
			scr.click(exit1);
				  } catch (Exception e) {
					  System.out.println("Test ten failed!");
					  e.printStackTrace();
				  }
	}
	
	
}
