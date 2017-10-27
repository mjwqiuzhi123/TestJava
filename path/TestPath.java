import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		path();
	}
	
	public static void path(){
		Properties p = new Properties();
		File f = new File("path1/path1.properties");
		FileInputStream fs;
		try {
			fs = new FileInputStream(f);
			p.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f.getAbsolutePath());
	}

}
