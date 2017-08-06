package yk;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

public class Time {
	public int dateInterval = 1;//����ȷ��ʱ����  
	ChartPanel frame1;
	
	public void TimeSeriesChart(){
		
		XYDataset xydataset = createDataset();  
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("��Ʊ����ͳ�ƹ����Ʊ��", "ʱ��", "��ƱƱ��",xydataset, true, true, true);  
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();  
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();  
        dateaxis.setDateFormatOverride(new SimpleDateFormat("hh:mm"));  
        
        dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, dateInterval)); 
        
        xyplot.setDomainAxis(dateaxis);
        frame1=new ChartPanel(jfreechart,true);  
        dateaxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
        dateaxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
        ValueAxis rangeAxis=xyplot.getRangeAxis();//��ȡ��״  
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
        jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
        jfreechart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
	}
	
	private static XYDataset createDataset() {//������ݼ��е�࣬�����������  
		Day day = new Day();
		TimeSeries hp_produce = new TimeSeries("��ͨ��Ʊ������",org.jfree.data.time.Hour.class); //Hour.class  Month.class
        hp_produce.add(new Hour(1,day), 181.80000000000001D);  
        hp_produce.add(new Hour(2,day), 167.30000000000001D);  
        hp_produce.add(new Hour(3,day), 153.80000000000001D);  
        hp_produce.add(new Hour(4,day), 167.59999999999999D);  
        hp_produce.add(new Hour(5,day), 158.80000000000001D);  
        hp_produce.add(new Hour(6,day), 148.30000000000001D);  
        hp_produce.add(new Hour(7,day), 153.90000000000001D);  
        hp_produce.add(new Hour(8,day), 142.69999999999999D);  
        hp_produce.add(new Hour(9,day), 123.2D);  
        hp_produce.add(new Hour(10,day), 131.80000000000001D);  
        hp_produce.add(new Hour(11,day), 139.59999999999999D);  
        hp_produce.add(new Hour(12,day), 142.90000000000001D);  
        hp_produce.add(new Hour(13,day), 138.69999999999999D);  
        hp_produce.add(new Hour(14,day), 137.30000000000001D);  
        hp_produce.add(new Hour(15,day), 143.90000000000001D);  
        hp_produce.add(new Hour(16,day), 139.80000000000001D);  
        hp_produce.add(new Hour(17,day), 137D);  
        hp_produce.add(new Hour(18,day), 132.80000000000001D); 
        hp_produce.add(new Hour(19,day), 138.69999999999999D);  
        hp_produce.add(new Hour(20,day), 137.30000000000001D);  
        hp_produce.add(new Hour(21,day), 123.90000000000001D);
        hp_produce.add(new Hour(22,day), 149.80000000434201D);  
        hp_produce.add(new Hour(23,day), 146.59999999999999D);
        hp_produce.add(new Hour(24,day), 153.90000000000001D);
        TimeSeries hp_statistics = new TimeSeries("��ͨ��Ʊͳ�ƿ�",org.jfree.data.time.Hour.class);  
        hp_statistics.add(new Hour(1,day), 129.59999999999999D);  
        hp_statistics.add(new Hour(2,day), 123.2D);  
        hp_statistics.add(new Hour(3,day), 117.2D);  
        hp_statistics.add(new Hour(4,day), 124.09999999999999D);  
        hp_statistics.add(new Hour(5,day), 122.59999999999999D);  
        hp_statistics.add(new Hour(6,day), 119.2D);  
        hp_statistics.add(new Hour(8, day), 116.5D);  
        hp_statistics.add(new Hour(9, day), 112.7D);  
        hp_statistics.add(new Hour(10, day), 101.5D);  
        hp_statistics.add(new Hour(11, day), 106.09999999999999D);  
        hp_statistics.add(new Hour(12, day), 110.3D);  
        hp_statistics.add(new Hour(13, day), 111.7D);  
        hp_statistics.add(new Hour(14, day), 111D);  
        hp_statistics.add(new Hour(15, day), 109.59999999999999D);  
        hp_statistics.add(new Hour(16, day), 113.2D);  
        hp_statistics.add(new Hour(17, day), 111.59999999999999D);  
        hp_statistics.add(new Hour(18, day), 108.8D);  
        hp_statistics.add(new Hour(19, day), 101.59999999999999D);  
        hp_statistics.add(new Hour(20,day), 142.69999999999999D);  
        hp_statistics.add(new Hour(21,day), 123.2D);  
        hp_statistics.add(new Hour(22,day), 131.80000000000001D);  
        hp_statistics.add(new Hour(23,day), 139.59999999999999D);  
        hp_statistics.add(new Hour(24,day), 142.90000000000001D);  
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();  
        timeseriescollection.addSeries(hp_produce);  
        timeseriescollection.addSeries(hp_statistics);  
        return timeseriescollection;  
    }  
	
	private static JFreeChart createChart(XYDataset paramXYDataset)
	  {
	    JFreeChart localJFreeChart = ChartFactory.createXYLineChart("Line Chart Demo 2", "X", "Y", paramXYDataset, PlotOrientation.VERTICAL, true, true, false);
	    localJFreeChart.setBackgroundPaint(Color.white);
	    XYPlot localXYPlot = (XYPlot)localJFreeChart.getPlot();
	    localXYPlot.setBackgroundPaint(Color.lightGray);
	    localXYPlot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
	    localXYPlot.setDomainGridlinePaint(Color.white);
	    localXYPlot.setRangeGridlinePaint(Color.white);
	    XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
	    localXYLineAndShapeRenderer.setBaseShapesVisible(true);
	    localXYLineAndShapeRenderer.setBaseShapesFilled(true);
	    NumberAxis localNumberAxis = (NumberAxis)localXYPlot.getRangeAxis();
	    localNumberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	    return localJFreeChart;
	  }
	 
	  public static JPanel createDemoPanel()
	  {
	    JFreeChart localJFreeChart = createChart(createDataset());
	    return new ChartPanel(localJFreeChart);
	  }
	 
	  public static void main(String[] paramArrayOfString)
	  {
		  JFrame frame=new JFrame("Java����ͳ��ͼ");  
		  frame.setLayout(new GridLayout(2,2,10,10)); 
		  frame.add(new Time().getChartPanel());    //�������ͼ  
//		  RefineryUtilities.centerFrameOnScreen(frame);
		  frame.setBounds(50, 50, 800, 600);  
		  frame.setVisible(true); 
//		  frame.pack();

	  }
	
	 public ChartPanel getChartPanel(){  
         return frame1;             
     }  

}
