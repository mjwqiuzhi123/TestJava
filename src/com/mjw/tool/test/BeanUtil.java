package com.mjw.tool.test;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BeanUtil {
	public static void main(String[] args) throws Exception{
		BeanUtil beanUtils = new BeanUtil();
		beanUtils.beanTool(String.class);
		//		beanUtilTest.beanTool(beanUtils, People.class);
		//		beanUtilTest.beanTool(beanUtils, Admin.class);
	}

	/**
	 * 根据bean生成相应的文件
	 * @param beanUtils
	 * @param c
	 * @throws Exception
	 */
	public void beanTool(Class c)throws Exception{
		//		BeanUtil.createBeanDao(c);
		//		BeanUtil.createBeanDaoImpl(c);
		BeanUtil.createBeanService(c);
		//		BeanUtil.createBeanServiceImpl(c);
	}



	//公共部分
	private static final String RT_1 = "\r\n";
	private static final String RT_2 = RT_1+RT_1;
	private static final String BLANK_1 =" ";
	private static final String BLANK_4 ="    ";
	private static final String BLANK_8 =BLANK_4 + BLANK_4;
	private static final String MY_COMPANY_DESKTOP = "C:\\Users\\admin\\Desktop\\";
	private static final String COMPANY_URL = "eshangshou";



	//注释部分
	private static final String ANNOTATION_AUTHOR_PARAMTER = "@author ";
	private static final String ANNOTATION_AUTHOR_NAME = "colorbin";
	private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
	private static final String ANNOTATION_DATE = "@date ";
	private static final String ANNOTATION = "/**"+RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_DATE +getDate()+RT_1+BLANK_1+"*/"+RT_1;


	//文件 地址
	//private static final String BEAN_PATH = "com/b510/base/bean";
	private static final String DAO_PATH = "com/b510/base/dao";
	private static final String DAO_IMPL_PATH = "com/b510/base/dao/impl";
//	private static final String SERVICE_PATH = "com/eshangshou/service";  //com\eshangshou\service
	private static final String SERVICE_IMPL_PATH = "com/b510/base/service/impl";



	//包名
	private static final String BEAN_URL = "com.b510.base.bean";
	private static final String DAO_URL = "com.b510.base.dao";
	private static final String DAO_IMPL_URL = "com.b510.base.dao.impl";
	private static final String SERVICE_URL = "com.eshangshou.service";
	private static final String SERVICE_IMPL_URL = "com.b510.base.service.impl";
	
	private static final String MAPPER_URL = "com."+COMPANY_URL+".mapper";
	private static final String POJO_URL = "com."+COMPANY_URL+".pojo";
	

	//基本类名称
	private static final String BASE_DAO_NAME = DAO_URL + ".BaseDao";
	private static final String ABSTRACT_BASE_DAO_IMPL_NAME = DAO_IMPL_URL + ".AbstractBaseDaoImpl";
	private static final String BASE_SERVICE_NAME = SERVICE_URL + ".BaseService";
	private static final String ABSTRACT_BASE_SERVICE_IMPL_NAME = SERVICE_IMPL_URL + ".AbstractBaseServiceImpl";


	/**
	 * 创建bean的Dao<br>
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanDao(Class c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + DAO_PATH
				+ "/" + getLastChar(cName) + "Dao.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package "+DAO_URL+";"+RT_2+ANNOTATION+"public interface " + 
				getLastChar(cName) + "Dao extends "+BASE_DAO_NAME+" <" + cName + "> {"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 创建bean的Dao的实现类
	 * @param c
	 * @throws Exception
	 */
	public void createBeanDaoImpl(Class c) throws Exception{
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + DAO_IMPL_PATH
				+ "/" + getLastChar(cName) + "DaoImpl.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package "+DAO_IMPL_URL+";"+RT_2+ANNOTATION+"public class " + 
				getLastChar(cName) + "DaoImpl extends "+ABSTRACT_BASE_DAO_IMPL_NAME+"<" + 
				cName + "> implements "+DAO_URL+"."+getLastChar(cName)+"Dao{"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}



	/**
	 * 创建bean的service
	 * @param c
	 * @throws Exception
	 */
	public static void createBeanService(Class c) throws Exception{
		String cName = c.getName();
		String fileNameDir =MY_COMPANY_DESKTOP + "/createCode";
		String fileName = fileNameDir + "/" + getLastChar(cName) + "Service.java";
		File f = new File(fileName);
		File f2 = new File(fileNameDir);
		if(!f.exists()){
			f2.mkdirs();
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f);
		fw.write("package "+SERVICE_URL+";"+RT_2+
				"import javax.annotation.Resource;"+RT_1+
				"import org.springframework.stereotype.Service;"+RT_1+
				"import "+MAPPER_URL+"."+getLastChar(cName)+"Mapper;"+RT_1+
				"import "+POJO_URL+"."+getLastChar(cName)+";"+RT_1+
				ANNOTATION+
				"@Service"+RT_1+
				"public class " + getLastChar(cName) + "Service { "+RT_2+
				BLANK_4+"@Resource" +RT_1+
				BLANK_4+"private "+getLastChar(cName)+"Mapper mapper;"+RT_2+
				BLANK_4+"public void insert("+getLastChar(cName)+" record){"+RT_1+BLANK_8+"mapper.insertSelective(record);"+RT_1+BLANK_4+"}"+RT_1+
				BLANK_4+"public void delete(Integer id){"+RT_1+BLANK_8+"mapper.deleteByPrimaryKey(id);"+RT_1+BLANK_4+"}"+RT_1+
				BLANK_4+"public void update("+getLastChar(cName)+" record){"+RT_1+BLANK_8+"mapper.updateByPrimaryKeySelective(record);"+RT_1+BLANK_4+"}"+RT_1+
				BLANK_4+"public "+getLastChar(cName)+" findById(Integer id){"+RT_1+BLANK_8+"mapper.selectByPrimaryKey(id);"+RT_1+BLANK_4+"}"+RT_1+
				"");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

	/**
	 * 创建bean的service的实现类
	 * @param c
	 * @throws Exception
	 */
	public void createBeanServiceImpl(Class c) throws Exception{
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_IMPL_PATH 
				+ "/" +getLastChar(cName)+"ServiceImpl.java";
		File f = new File(fileName);
		if(!f.exists()){
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f);
		fw.write("package "+SERVICE_IMPL_URL+";"+RT_2+ANNOTATION+"public class " 
				+ getLastChar(cName) + "ServiceImpl extends "+ABSTRACT_BASE_SERVICE_IMPL_NAME+"<"+ cName 
				+ "> implements "+SERVICE_URL+"."+getLastChar(cName)+"Service{"+RT_2+BLANK_4
				+"private "+DAO_URL+"."+getLastChar(cName)+"Dao "+getLowercaseChar(getLastChar(cName))
				+"Dao;"+RT_2+BLANK_4+"public void set"+getLastChar(cName)+"Dao("+DAO_URL+"."+getLastChar(cName)+"Dao "
				+getLowercaseChar(getLastChar(cName))+"Dao){"+RT_1+BLANK_8+"this."+getLowercaseChar(getLastChar(cName))+"Dao = "
				+getLowercaseChar(getLastChar(cName))+"Dao;"+RT_1+BLANK_4+"}"+RT_2+BLANK_4+"@Override"+RT_1+BLANK_4
				+"public "+DAO_URL+"."+"BaseDao<"+BEAN_URL+"."+getLastChar(cName)+"> getBaseDao(){"+RT_1+BLANK_8
				+"return "+getLowercaseChar(getLastChar(cName))+"Dao;"+RT_1+BLANK_4+"}"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}


	/**
	 * 获取路径的最后面字符串<br>
	 * 如：<br>
	 *     <code>str = "com.b510.base.bean.User"</code><br>
	 *     <code> return "User";<code>
	 * @param str
	 * @return
	 */
	public static String getLastChar(String str) {
		if ((str != null) && (str.length() > 0)) {
			int dot = str.lastIndexOf('.');
			if ((dot > -1) && (dot < (str.length() - 1))) {
				return str.substring(dot + 1);
			}
		}
		return str;
	}

	/**
	 * 把第一个字母变为小写<br>
	 * 如：<br>
	 *     <code>str = "UserDao";</code><br>
	 *     <code>return "userDao";</code>
	 * @param str
	 * @return
	 */
	public String getLowercaseChar(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
	}

	/**
	 * 显示信息
	 * @param info
	 */
	public static void showInfo(String info){
		System.out.println("创建文件："+ info+ "成功！");
	}

	/**
	 * 获取系统时间
	 * @return
	 */
	public static String getDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new Date());
	}
}