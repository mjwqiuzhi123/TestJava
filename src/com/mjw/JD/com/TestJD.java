package com.mjw.JD.com;

import java.io.IOException;

public class TestJD {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testTry();
	}
	
	public static void testSwit(int type){
		switch (type) {
//		default:  
//            System.out.println(4);
//            break;
        case 1:  
            System.out.println(1);
            break;
        case 2:  
            System.out.println(2); 
            break;
        case 3:  
            System.out.println(3);
            break;
        default:  
            System.out.println(4); 
        }
		System.out.println("end");
	}
	
	@SuppressWarnings("finally")
	public static void testException() throws Exception{
		try{  
            throw new Exception("1");  
        }catch (IOException e){  
            throw new Exception("2");  
        }catch (Exception e) {  
            throw new Exception("3");  
        }
		finally {  
            throw new Exception("4");
			//System.out.println("i am  final");
        } 
	}
	
	public static void testTry() throws Exception{
		try{
			throw new Exception("1"); 
		}
//		catch(Exception e){
//			throw new Exception("2"); 
//		}
		finally {
			System.out.println("finally");
			throw new Exception("2"); 
		}
	}
}
