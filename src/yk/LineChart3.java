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
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

@WebServlet("/LineChart3")
public class LineChart3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ������ͳ��
		TimeSeries timeSeries=new TimeSeries("A��վ������ͳ��", org.jfree.data.time.Hour.class);
		// �������
		timeSeries.add(new Hour(1,new Day()), 100);
		timeSeries.add(new Hour(2,new Day()), 90);
		timeSeries.add(new Hour(3,new Day()), 85);
		timeSeries.add(new Hour(4,new Day()), 60);
		timeSeries.add(new Hour(5,new Day()), 30);
		timeSeries.add(new Hour(6,new Day()), 29);
		timeSeries.add(new Hour(7,new Day()), 45);
		timeSeries.add(new Hour(8,new Day()), 140);
		timeSeries.add(new Hour(9,new Day()), 280);
		timeSeries.add(new Hour(10,new Day()), 500);
		timeSeries.add(new Hour(11,new Day()), 430);
		timeSeries.add(new Hour(12,new Day()), 370);
		timeSeries.add(new Hour(13,new Day()), 350);
		timeSeries.add(new Hour(14,new Day()), 360);
		timeSeries.add(new Hour(15,new Day()), 410);
		timeSeries.add(new Hour(16,new Day()), 330);
		timeSeries.add(new Hour(17,new Day()), 410);
		timeSeries.add(new Hour(18,new Day()), 490);
		timeSeries.add(new Hour(19,new Day()), 570);
		timeSeries.add(new Hour(20,new Day()), 660);
		timeSeries.add(new Hour(21,new Day()), 720);
		timeSeries.add(new Hour(22,new Day()), 410);
		timeSeries.add(new Hour(23,new Day()), 300);
		timeSeries.add(new Hour(24,new Day()), 180);
		
		TimeSeries timeSeries2=new TimeSeries("B��վ������ͳ��", org.jfree.data.time.Hour.class);
		// �������
		timeSeries2.add(new Hour(1,new Day()), 320);
		timeSeries2.add(new Hour(2,new Day()), 180);
		timeSeries2.add(new Hour(3,new Day()), 95);
		timeSeries2.add(new Hour(4,new Day()), 30);
		timeSeries2.add(new Hour(5,new Day()), 21);
		timeSeries2.add(new Hour(6,new Day()), 100);
		timeSeries2.add(new Hour(7,new Day()), 130);
		timeSeries2.add(new Hour(8,new Day()), 190);
		timeSeries2.add(new Hour(9,new Day()), 350);
		timeSeries2.add(new Hour(10,new Day()), 480);
		timeSeries2.add(new Hour(11,new Day()), 560);
		timeSeries2.add(new Hour(12,new Day()), 450);
		timeSeries2.add(new Hour(13,new Day()), 430);
		timeSeries2.add(new Hour(14,new Day()), 300);
		timeSeries2.add(new Hour(15,new Day()), 200);
		timeSeries2.add(new Hour(16,new Day()), 340);
		timeSeries2.add(new Hour(17,new Day()), 400);
		timeSeries2.add(new Hour(18,new Day()), 460);
		timeSeries2.add(new Hour(19,new Day()), 510);
		timeSeries2.add(new Hour(20,new Day()), 600);
		timeSeries2.add(new Hour(21,new Day()), 650);
		timeSeries2.add(new Hour(22,new Day()), 690);
		timeSeries2.add(new Hour(23,new Day()), 590);
		timeSeries2.add(new Hour(24,new Day()), 410);
		
		// ����ʱ�����еļ���
		TimeSeriesCollection lineDayset=new TimeSeriesCollection();
		lineDayset.addSeries(timeSeries);
		lineDayset.addSeries(timeSeries2);
		
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart("������ͳ��ʱ������ͼ", "ʱ", "������", lineDayset, true, true, true);
                            
		//����������
		chart.setTitle(new TextTitle("A��B��վ�ķ������Ա�ͳ��ͼ", new Font("����", Font.ITALIC, 15))); 
		//�����ӱ���
		TextTitle subtitle = new TextTitle("2017��6��1��", new Font("����", Font.BOLD, 12));
		chart.addSubtitle(subtitle); 
		chart.setAntiAlias(true); 
		
		//����ʱ����ķ�Χ
		XYPlot plot = (XYPlot) chart.getPlot(); 
		DateAxis dateaxis = (DateAxis)plot.getDomainAxis();
		dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("hh"));
		dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR,1)); //����ʱ����Ϊ1Сʱ
		
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
            ChartUtilities.writeChartAsJPEG(fos_jpg,1,chart,700,600,null); 
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
        request.getRequestDispatcher("/index3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
