package com.mjw.tool.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * ������Խ�ĳ���ļ����µ����ֺ�������ַ������ļ��滻Ϊ�µ�����
 * @author admin
 *
 */
@SuppressWarnings("rawtypes")
public class _fileUtil {
	
	public static void main(String[] args) {
		//		String path = "F:\\test";
		//		String[] files = {"a","b","c"};
		//		String suffixName = "(�޻���)";
		//		_fileUtil.multiFloder(path, files , suffixName );

		_fileUtil replacementChain = new _fileUtil();
		replacementChain.addRegulation(".txt", "(ת��֮���).txt");//���滻�ַ������滻����ַ���
		_fileUtil.multiRename(false,"E:\\Test", replacementChain);// ������
	}
	
	private Map map;
	public _fileUtil(){
		this.map=new HashMap();
	}
	public Map getMap() {
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public _fileUtil addRegulation(String oldStr, String newStr){
		this.map.put(oldStr, newStr);
		return this;
	}
	
	public static void multiFloder(String path, String[] files, String suffixName){
		String filename = "";
		for(int i = 0; i<files.length;i++){
			filename = (i+1)+"-"+files[i];
			File f = new File(path+"\\"+filename+suffixName);
			f.mkdirs();
			System.out.println("�����ļ��гɹ���");
		}
	}
	
	/**
	 * @param prefix �Ƿ���ǰ׺
	 * @param path ·��
	 * @param replacementChain ����
	 */
	public static void multiRename(Boolean prefix, String path,_fileUtil replacementChain){
		File file = new File(path);
		boolean isDirectory = file.isDirectory();
		if(!isDirectory){
			System.out.println(path+"����һ���ļ��У�");
			return;
		}
		String[] files = file.list();
		File f = null;
		String filename = "";
		String oldFileName = "";
		
		for(int i = 0; i<files.length;i++){
			oldFileName = files[i];
			filename = files[i];
			Map map = replacementChain.getMap();
			Iterator it = map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry = (Entry) it.next();
				filename = filename.replace((String)entry.getKey(), (String)entry.getValue());// �滻����
			}
			if(prefix){
				filename = (i+1)+"-"+filename;
			}
			f = new File(path+"\\"+oldFileName);
			if(f.isDirectory())
				multiRename(false,f.getAbsolutePath(),replacementChain);// �ݹ����
			f.renameTo(new File(path+"\\"+filename));
			System.out.println("�����޸�"+filename+"�ɹ���");
		}
	}
}