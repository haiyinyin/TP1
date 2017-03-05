package TD1;

import java.awt.Color;
import java.awt.Shape;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.awt.BasicStroke; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class QuickSort extends ApplicationFrame 
{
   public QuickSort( String applicationTitle, String chartTitle )
   {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createScatterPlot(
         chartTitle ,
         "ArraySize" ,
         "Time" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , false , false);
         
      Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
      
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      XYItemRenderer renderer = plot.getRenderer( );
     
      renderer.setSeriesPaint( 0 , Color.YELLOW );
      renderer.setSeriesShape(0, cross);

      plot.setDomainCrosshairVisible(true);
      plot.setRangeCrosshairVisible(true);
       
      setContentPane( chartPanel ); 
   }
  
   private XYDataset createDataset( )
   {  
	  
	   
     
      final XYSeries Quick = new XYSeries( "Quick" );
      
     
      for(int i = 50;i <= 50000; i += 100)
      {
      int[] tab=RandomData.generate1d(i, 0, 1000);

        long startTime_2=System.nanoTime();
	     sort(tab);
	     long endTime_2=System.nanoTime();
	     Quick.add(i,endTime_2-startTime_2);
	     
	     }               
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      
      dataset.addSeries( Quick);
     
      return dataset;
   }

   public static void swap(int[] data, int i, int j){  //selection sort 
		 int tmp= data[i]; 
		 data[i]= data[j]; 
		 data[j]= tmp; 
		 }
	public static int partition(int[] data, int begin, int end, int pivotIdx){ 
	
		swap(data, pivotIdx, --end); 
		pivotIdx= end; 
		int pivot= data[pivotIdx];  
		while(begin != end){ 
			if(data[begin] >= pivot){ 
				swap(data, begin, --end); 
				}else{  ++begin; 
				} 
			}  swap(data, pivotIdx, begin);  
			return begin;  
			}
	
	public static void sort(int[] data){ 
		sort(data, 0, data.length);
		}
	public static void sort(int[] data, int begin, int end){ 
		if((end-begin) < 2){ return; } 
		int m= partition(data, begin, end, (end+begin)/2); 
		sort(data, begin, m);
		sort(data, m+1, end); 
		}
	 public static void main( String[ ] args ) 
	   {
	      QuickSort chart = new QuickSort("O(n) Statistics", "QuickSort");
	      chart.pack( );          
	      RefineryUtilities.centerFrameOnScreen( chart );          
	      chart.setVisible( true ); 
	   }

}



	
	









