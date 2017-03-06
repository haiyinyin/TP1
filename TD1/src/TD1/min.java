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

public class min extends ApplicationFrame 
{
   public min( String applicationTitle, String chartTitle )
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
	  //there should't be too much line feed.(by haiyin)
   
     
      final XYSeries Minimum = new XYSeries( "Minimum" );
      
     
      for(int i = 50;i <= 50000; i += 100)
      {
      int[] tab=RandomData.generate1d(i, 0, 1000);

        long startTime_2=System.nanoTime();
	     minimum(tab);
	     long endTime_2=System.nanoTime(); //variable name not clear (by haiyin)
	     Minimum.add(i,endTime_2-startTime_2);
	     
	     }               
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      
      dataset.addSeries( Minimum);
     
      return dataset;
   }

   public static int minimum(int[]res){        //here is the function to find the minimum element.
	   int min = res[0];
	   for(int j=0;j<res.length;j++){
	    	 if(min>res[j]){
	    		 min=res[j];
	    	 }
	   }
	   return min;
   }
	
	 public static void main( String[ ] args ) 
	   {
	      min chart = new min("O(n) Statistics", "Minimum");
	      chart.pack( );          
	      RefineryUtilities.centerFrameOnScreen( chart );          
	      chart.setVisible( true ); 
	   }

}



	
	






