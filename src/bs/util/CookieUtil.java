package bs.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public static String getCookieValue(Cookie[] cookies, String cookieName) {
		String cookieValue = "";

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookieName.equals(cookie.getName())) {
					cookieValue = cookie.getValue();
				}
			}
		}
		return cookieValue;
	}

	public static void createCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie("invoiceCookie", cookieName); // add to cookies
		System.out.println("cookie value is: " + cookie.getValue());
		cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		cookie.setPath("/");	
		response.addCookie(cookie);
	}
	
	
}
