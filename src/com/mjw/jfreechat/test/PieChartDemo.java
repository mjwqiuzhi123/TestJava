package com.mjw.jfreechat.test;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 * ������ʾ��ͼ������
 */
public class PieChartDemo {
    public static void main(String[] args) throws IOException {
        DefaultPieDataset data = getDataSet();
        JFreeChart chart = ChartFactory.createPieChart3D("ˮ������ͼ", // ͼ�����
                data, // ���ݼ�
                true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
                false, // �Ƿ����ɹ���
                false // �Ƿ����� URL ����
                );

        //��������
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelFont(new Font("����", Font.PLAIN, 20));
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("����", Font.PLAIN, 20));
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));

        // дͼ������ļ���������״ͼ����Դ��
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("D:\\Pie3DChart.jpg");
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300,
                    null);
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * ��ȡһ����ʾ�õļ����ݼ�����
     * 
     * @return
     */
    private static DefaultPieDataset getDataSet() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("ƻ��", 100);
        dataset.setValue("����", 200);
        dataset.setValue("����", 300);
        dataset.setValue("�㽶", 400);
        dataset.setValue("��֦", 500);
        return dataset;
    }
}