package com.mjw.socket.test;  
  
import java.net.*;  
import java.io.*;  
  
/** 
 * һ���򵥵�Socketʵ�ֵ�HTTP��Ӧ��������<br> 
 * ֻ������ϤHTTPЭ���Ŀ�ģ����Կ�������������������ݸ�ʽ�� 
 *  
 * @author  */  
public class MyWebServer {  
  public static void main(String[] args) {  
    Socket socket = null;  
    try {  
      // ����һ������8000�˿ڵķ�����Socket  
      ServerSocket s = new ServerSocket(8000, 3);  
      System.out.println("MyWebServer�ȴ����������������\n");  
      while (true) {  
        socket = s.accept();  
        System.out.println("�����ѽ������˿ںţ�" + socket.getPort());  
        new MyWebServerThread(socket).start();  
      }  
    } catch (IOException e) {  
      e.printStackTrace();  
    }  
  }  
}  
  
class MyWebServerThread extends Thread {  
  private Socket socket;  
  
  MyWebServerThread(Socket socket) {  
    this.socket = socket;  
  }  
  
  @Override  
  public void run() {  
    try {  
      InputStreamReader is = new InputStreamReader(socket.getInputStream());  
      char[] bs = new char[2048];  
      PrintStream out;  
      out = new PrintStream(socket.getOutputStream());  
      StringBuilder msg = new StringBuilder();  
      // ���10���뻹û�����ݣ�����ͬû���µ������ˡ�  
      // ��Ϊ��Keep-Alive��Ե�ʣ���������ܲ������Ͽ����ӵġ�  
      // ʵ��Ӧ�ã������Э���һ����GET���� POSTȷ����  
      socket.setSoTimeout(10);  
      //  
      // �˴������������ݲ�����Ӧ�Ĵ���  
      //  
      int len = -1;  
      try {  
        while ((len = is.read(bs)) != -1) {  
          msg.append(bs, 0, len);  
          msg.append("\n");  
        }  
      } catch (Exception ex) {  
        // ex.printStackTrace();  
      }  
      // �������ɷ�����ֱ�����ɵ���ҳ����  
      // 1������������������Ӧͷ��Ϣ  
      out.println("HTTP/1.1 200 OK");  
      out.println("Content-Type:text/html;charset:GBK");  
      out.println();  
      // 2�������ҳ��Ϣ  
      out  
          .println("<HTML><BODY>"  
              + "<center>"  
              + "<H1>HTTPЭ����Է�����,��ǰʱ�䣺"  
              + new java.util.Date()  
              + "</h1>"  
              + "<form method='get'>username:<input type='text' name='username'/>password:<input type='text' name='password'/><input type='submit' value='GET����'/></form><br/>"  
              + "<form method='post'>username:<input type='text' name='username'/>password:<input type='text' name='password'/><input type='submit' value='POST����'/></form><br/>"  
              + "<form method='post'  enctype='multipart/form-data'>phototitle:<input type='text' name='phototitle'/>photo:<input type='file' name='photo'/><input type='submit' value='Upload����'/></form>"  
              + "</center>���ύ����������:<pre>" + msg.toString() + "</pre></BODY></HTML>");  
      out.flush();  
      out.close();  
      is.close();  
      System.out.println("close");  
      // �ر�����  
      socket.close();  
    } catch (IOException e) {  
      e.printStackTrace();  
    }  
  }  
}  