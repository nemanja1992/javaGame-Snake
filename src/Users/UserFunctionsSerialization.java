package Users;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class UserFunctionsSerialization {
	
	public void serialize(List<User> userL, String fileName) {
			try (ObjectOutputStream out= 
					new ObjectOutputStream(new FileOutputStream(fileName))) {
				out.writeObject(userL);
		} catch (IOException e) {
			System.out.println("A problem occurred during serialization");
			System.out.println(e.getMessage());
		}
	}
	public List<User> deserialize(String fileName){
		List<User> userL=null;
		try (ObjectInputStream in = 
					new ObjectInputStream(new FileInputStream(fileName))){
				userL = (List<User>) in.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.printf("A problem occurred deserializing %s%n", fileName);
			System.out.println(e.getMessage());
		}
		return userL;
	}
	
	
}
