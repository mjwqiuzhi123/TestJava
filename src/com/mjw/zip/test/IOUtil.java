package com.mjw.zip.test;
 
import java.io.Closeable;
import java.io.IOException;
 
/**
 * IO��������
 * 
 * @author mjw
 * @since 20160829
 */
public class IOUtil {
    /**
     * �ر�һ������������
     * 
     * @param closeables
     *            �ɹرյ��������б�
     * @throws IOException
     */
    public static void close(Closeable... closeables) throws IOException {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }
 
    /**
     * �ر�һ������������
     * 
     * @param closeables
     *            �ɹرյ��������б�
     */
    public static void closeQuietly(Closeable... closeables) {
        try {
            close(closeables);
        } catch (IOException e) {
            // do nothing
        }
    }
 
}