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

public class XYLineChart_AWT extends ApplicationFrame 
{
   public XYLineChart_AWT( String applicationTitle, String chartTitle )
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
      renderer.setSeriesPaint( 4 , Color.BLACK );
      renderer.setSeriesPaint( 3 , Color.RED );
      renderer.setSeriesPaint( 2 , Color.GREEN );
      renderer.setSeriesPaint( 1 , Color.BLUE );
      renderer.setSeriesPaint( 0 , Color.YELLOW );
      renderer.setSeriesShape(0, cross);

      plot.setDomainCrosshairVisible(true);
      plot.setRangeCrosshairVisible(true);
       
      setContentPane( chartPanel ); 
   }
  
   private XYDataset createDataset( )
   {  
	  
	   ThreadMXBean bean =ManagementFactory.getThreadMXBean();
      final XYSeries minimum = new XYSeries( "minimum" );
      final XYSeries Bubble = new XYSeries( "Bubble" );
      final XYSeries Selection = new XYSeries( "Selection" );
      final XYSeries Merge = new XYSeries( "Merge" );
      final XYSeries Quick = new XYSeries( "Quick" );
      for(int i = 1;i <= 1000; i += 10)
      {
      int[] tab=RandomData.generate1d(i, 0, 1000);
      
         long startTime_1=System.nanoTime();//Here is the first sort to find the minimum element 
	    int a= min.minimum(tab);
	     long endTime_1=System.nanoTime();
	     minimum.add(i, endTime_1-startTime_1);
	     
      
      
      
        long startTime_2=System.nanoTime();
	     BubbleSort.sort(tab);
	     long endTime_2=System.nanoTime();
	     Bubble.add(i,endTime_2-startTime_2);
	     
      
         long startTime_3=System.nanoTime();
	     SelectionSort.sort(tab);
	     long endTime_3=System.nanoTime();
	     Selection.add(i,endTime_3-startTime_3);
	     
	     long startTime_4=System.nanoTime();
	     MergeSort.sort(tab);
	     long endTime_4=System.nanoTime();
	     Merge.add(i,endTime_4-startTime_4);   
	     
	     
	
	     
	     long startTime_5=System.nanoTime();
	     QuickSort.sort(tab);
	     long endTime_5=System.nanoTime();
	     Quick.add(i,endTime_5-startTime_5);
	       
	     }
	    
	     //when you use eclipse, you can right click your mouse and choose source->form to make a better form for codes
	     
	
      
      
              
          
            
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( minimum );
      dataset.addSeries( Bubble);
      dataset.addSeries(Selection);
      dataset.addSeries(Merge);
      dataset.addSeries(Quick);
      return dataset;
   }

   public static void main( String[ ] args ) 
   {
      XYLineChart_AWT chart = new XYLineChart_AWT("O(n) Statistics", "CompareSort");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
}
