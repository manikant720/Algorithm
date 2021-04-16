package test;

import com.bookstoremanager.Auth;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthTest {

    // Should return false on wrong credentials
    @Test
    public void testFalseLogin(){
        Auth auth = new Auth();
        boolean loggedIN = auth.checkLogin("a","a");
        assertEquals(false, loggedIN);
    }

    // Should return true on right credentials
    @Test
    public void testTrueLogin(){
        Auth auth = new Auth();
        boolean loggedIN = auth.checkLogin("admin","admin");
        assertEquals(true, loggedIN);
    }
}
