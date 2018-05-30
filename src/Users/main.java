package Users;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		List<User> userL=new ArrayList<>();
		userL.add(new User("admin","admin"));
		userL.add(new User("tanja","tanjiric"));
	UserFunctionsSerialization us = new UserFunctionsSerialization();
	us.serialize(userL, "user.bin");

	}

}
