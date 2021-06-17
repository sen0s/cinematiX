public class IDandPasswords {
//	static HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords()
	{
		Database.allCredentials.put("Jack", "abc123");
//		logininfo.put("Maria", "123456");
//		logininfo.put("Panos", "abdcd");
	}
	
//	public HashMap getLoginInfo()
//	{
//		return logininfo;
//	}
	
	public void AddInfo(String a,String b){
		Database.allCredentials.put(a, b);
		// logininfo.put(a, b);
		// System.out.println(logininfo);
	}

}
