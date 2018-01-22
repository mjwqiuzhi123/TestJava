package com.mjw.tool.test;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 该类可以将某个文件夹下的名字含有相关字符串的文件替换为新的名称
 * @author admin
 *
 */
@SuppressWarnings("rawtypes")
public class _fileUtil {
	
	public static void main(String[] args) {
		//		String path = "F:\\test";
		//		String[] files = {"a","b","c"};
		//		String suffixName = "(艳辉网)";
		//		_fileUtil.multiFloder(path, files , suffixName );

		_fileUtil replacementChain = new _fileUtil();
		replacementChain.addRegulation(".txt", "(转换之后的).txt");//被替换字符串，替换后的字符串
		_fileUtil.multiRename(false,"E:\\Test", replacementChain);// 主方法
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
			System.out.println("创建文件夹成功！");
		}
	}
	
	/**
	 * @param prefix 是否有前缀
	 * @param path 路径
	 * @param replacementChain 规则
	 */
	public static void multiRename(Boolean prefix, String path,_fileUtil replacementChain){
		File file = new File(path);
		boolean isDirectory = file.isDirectory();
		if(!isDirectory){
			System.out.println(path+"不是一个文件夹！");
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
				filename = filename.replace((String)entry.getKey(), (String)entry.getValue());// 替换名称
			}
			if(prefix){
				filename = (i+1)+"-"+filename;
			}
			f = new File(path+"\\"+oldFileName);
			if(f.isDirectory())
				multiRename(false,f.getAbsolutePath(),replacementChain);// 递归操作
			f.renameTo(new File(path+"\\"+filename));
			System.out.println("批量修改"+filename+"成功！");
		}
	}
}