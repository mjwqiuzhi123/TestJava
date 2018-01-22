package com.mjw.tool.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * �����ļ���ftp������
 */
import org.apache.commons.net.ftp.FTPClient;

public class _ftpUtil {

    private static String ftpIp = "192.168.1.88";// ftp��������ַ
    private static String ftpUser = "admin";// �˻�
    private static String ftpPass = "neusoft";// ����
    
    public static void main(String[] args) throws IOException {
    	List<File> fileList = new ArrayList<File>();
    	File f = new File("D:\\456.xlsx");
    	fileList.add(f);
    	uploadFile(fileList);
	}
    
    public _ftpUtil(String ip,int port,String user,String pwd){
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }
    public static boolean uploadFile(List<File> fileList) throws IOException {
    	_ftpUtil ftpUtil = new _ftpUtil(ftpIp,21,ftpUser,ftpPass);
    	System.out.println("��ʼ����ftp������");
        boolean result = ftpUtil.uploadFile("",fileList);// ftp�������ĸ�Ŀ¼����ʹ""����"/"
        if(result)
        	System.out.println("�ϴ��ɹ�");
        else
        	System.out.println("�ϴ�ʧ��");
        return result;
    }


    private boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //����FTP������
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
				boolean exist = ftpClient.changeWorkingDirectory(remotePath);
                if(exist){
	                ftpClient.setBufferSize(1024);
	                ftpClient.setControlEncoding("UTF-8");
	                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
	                ftpClient.enterLocalPassiveMode();
	                for(File fileItem : fileList){
	                    fis = new FileInputStream(fileItem);
	                    ftpClient.storeFile(fileItem.getName(),fis);
	                }
                }
                else {
                	System.out.println("ftp������Ŀ¼�����ڣ�");
                	return false;
                }

            } catch (IOException e) {
            	System.out.println("�ϴ��ļ��쳣");
                uploaded = false;
                e.printStackTrace();
            } finally {
            	if(fis != null)
            		fis.close();
            	if(ftpClient != null)
            		ftpClient.disconnect();
            }
        }
        return uploaded;
    }



    private boolean connectServer(String ip,int port,String user,String pwd){

        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user,pwd);
            //isSuccess = true;
        } catch (IOException e) {
        	System.out.println("����FTP�������쳣");
        }
        return isSuccess;
    }

    private String ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}