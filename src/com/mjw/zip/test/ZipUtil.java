package com.mjw.zip.test;
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
 
 
/**
 * ͨ��Java��Zip���������ʵ��ѹ���ͽ�ѹ�ļ�
 * 
 * @author mjw
 * 
 */
public final class ZipUtil {
 
    private ZipUtil() {
        // empty
    }
 
    /**
     * ѹ���ļ�
     * 
     * @param filePath
     *            ��ѹ�����ļ�·��
     * @return ѹ������ļ�
     */
    public static File zip(String filePath) {
        File target = null;
        File source = new File(filePath);
        if (source.exists()) {
            // ѹ���ļ���=Դ�ļ���.zip
            String zipName = source.getName() + ".zip";
            @SuppressWarnings("unused")
			String parentPath = source.getParent();
            target = new File(source.getParent(), zipName);
            if (target.exists()) {
                target.delete(); // ɾ���ɵ��ļ�
            }
            FileOutputStream fos = null;
            ZipOutputStream zos = null;
            try {
                fos = new FileOutputStream(target);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // ��Ӷ�Ӧ���ļ�Entry
                addEntry("", source, zos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtil.closeQuietly(zos, fos);
            }
        }
        return target;
    }
 
    /**
     * ɨ������ļ�Entry
     * 
     * @param base
     *            ��·��
     * 
     * @param source
     *            Դ�ļ�
     * @param zos
     *            Zip�ļ������
     * @throws IOException
     */
    private static void addEntry(String base, File source, ZipOutputStream zos)
            throws IOException {
        // ��Ŀ¼�ּ������磺/aaa/bbb.txt
        String entry = base + source.getName();
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                // �ݹ��г�Ŀ¼�µ������ļ�������ļ�Entry
                addEntry(entry + "/", file, zos);
            }
        } else {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                byte[] buffer = new byte[1024 * 10];
                fis = new FileInputStream(source);
                bis = new BufferedInputStream(fis, buffer.length);
                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            } finally {
                IOUtil.closeQuietly(bis, fis);
            }
        }
    }
 
    /**
     * ��ѹ�ļ�
     * 
     * @param filePath
     *            ѹ���ļ�·��
     */
    public static void unzip(String filePath) {
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while ((entry = zis.getNextEntry()) != null
                        && !entry.isDirectory()) {
                    File target = new File(source.getParent(), entry.getName());
                    if (!target.getParentFile().exists()) {
                        // �����ļ���Ŀ¼
                        target.getParentFile().mkdirs();
                    }
                    // д���ļ�
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtil.closeQuietly(zis, bos);
            }
        }
    }
    
//    /**
//     * @author mjw
//     * @since 20160829
//     */
//    public static void getProperties(String[] agrs){
//    	
//    }
 
    public static void main(String[] args) {
    	//Add by mjw 20160829
//		int length = args.length;
//		String path = null;
//		if (length <= 0) {
//			System.out.println("������������,����Ϊnull�����������ã�");
//			System.exit(0);
//		} else {
//			path = args[0];
//		}
    	//Add by mjw 20160829
        String targetPath = "E:\\Win7��ֽ";
        String targetPath1 = "E:\\Test";
        File file = ZipUtil.zip(targetPath1);
        System.out.println(file);
        ZipUtil.unzip("Test.zip");
    }
}