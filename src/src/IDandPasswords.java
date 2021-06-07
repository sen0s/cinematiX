package src;

import java.util.HashMap;

public class IDandPasswords {
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords()
	{
		logininfo.put("Jack", "abc123");
		logininfo.put("Maria", "123456");
		logininfo.put("Panos", "abdcd");
	}
	
	public HashMap getLoginInfo()
	{
		return logininfo;
	}

}
