package yk;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

@WebServlet("/LineChart")
public class LineChart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ������ͳ��
		TimeSeries timeSeries=new TimeSeries("ĳ��վ������ͳ��", Month.class);
		// ��������
		timeSeries.add(new Month(1,2013), 100);
		timeSeries.add(new Month(2,2013), 200);
		timeSeries.add(new Month(3,2013), 300);
		timeSeries.add(new Month(4,2013), 400);
		timeSeries.add(new Month(5,2013), 560);
		timeSeries.add(new Month(6,2013), 600);
		timeSeries.add(new Month(7,2013), 750);
		timeSeries.add(new Month(8,2013), 890);
		timeSeries.add(new Month(9,2013), 120);
		timeSeries.add(new Month(10,2013), 400);
		timeSeries.add(new Month(11,2013), 1200);
		timeSeries.add(new Month(12,2013), 1600);
		
		// ����ʱ�����еļ���
		TimeSeriesCollection lineDataset=new TimeSeriesCollection();
		lineDataset.addSeries(timeSeries);
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart("������ͳ��ʱ������ͼ", "�·�", "������", lineDataset, true, true, true);
                            
		//����������
		chart.setTitle(new TextTitle("ĳ��վ������ͳ��", new Font("����", Font.ITALIC, 15))); 
		//�����ӱ���
		TextTitle subtitle = new TextTitle("2013���", new Font("����", Font.BOLD, 12));
		chart.addSubtitle(subtitle); 
		chart.setAntiAlias(true); 
		
		//����ʱ����ķ�Χ��
		XYPlot plot = (XYPlot) chart.getPlot(); 
		DateAxis dateaxis = (DateAxis)plot.getDomainAxis();
		dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("M��"));
		dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH,1)); 
		
		//���������Ƿ���ʾ���ݵ�
		XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer)plot.getRenderer();
		xylinerenderer.setBaseShapesVisible(true); 
		
		//����������ʾ�����ݵ��ֵ
		XYItemRenderer xyitem = plot.getRenderer(); 
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12)); 
		plot.setRenderer(xyitem);
		
		
        FileOutputStream fos_jpg = null; 
        long currentTimeMillis = System.currentTimeMillis();
        try {
        	//��ͼƬ����������f��
//	        fos_jpg = new FileOutputStream("f:\\"+System.currentTimeMillis()+".jpg"); 
        	//��ͼƬ������Tomcat������WebRoot�µ�imgĿ¼��
            fos_jpg = new FileOutputStream(request.getSession().getServletContext().getRealPath("/")+currentTimeMillis+".jpeg");
            ChartUtilities.writeChartAsJPEG(fos_jpg,1,chart,400,300,null); 
        } catch (Exception e) {
        	System.out.println("error");
		} finally { 
            try { 
                fos_jpg.close(); 
            } catch (Exception e) {
            	System.out.println("error");
            } 
        } 
        String filename = currentTimeMillis+".jpeg";
        request.setAttribute("filename", filename);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}