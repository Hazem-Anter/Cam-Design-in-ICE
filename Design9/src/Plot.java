import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Plot {
	
	JFreeChart chart;
	double[] s;
	double[] v;
	double[] a;
	double[] j;
	double[] XCamProfile;
	double[] YCamProfile;
	DefaultCategoryDataset dataSet;
	
	Plot(double seta, double h, int camIndex){
		
		System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h);
			s = primativeCam.displacement();
			v = primativeCam.velocity();
			a= primativeCam.acceleration();
			j = primativeCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement", Integer.toString(i));
			dataSet.addValue(v[i], "velocity", Integer.toString(i));
			dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
			dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h);
			s = normalCam.displacement();
			v = normalCam.velocity();
			a= normalCam.acceleration();
			j = normalCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
				dataSet.addValue(s[i], "displacement", Integer.toString(i));
				dataSet.addValue(v[i], "velocity", Integer.toString(i));
				dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
				dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h);
			s = accurateCam.displacement();
			v = accurateCam.velocity();
			a= accurateCam.acceleration();
			j = accurateCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
				dataSet.addValue(s[i], "displacement", Integer.toString(i));
				dataSet.addValue(v[i], "velocity", Integer.toString(i));
				dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
				dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
			s = moreAccurateCam.displacement();
			v = moreAccurateCam.velocity();
			a= moreAccurateCam.acceleration();
			j = moreAccurateCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
				dataSet.addValue(s[i], "displacement", Integer.toString(i));
				dataSet.addValue(v[i], "velocity", Integer.toString(i));
				dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
				dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	Plot(double seta, double h, int camIndex, double baseCircle){
		
		System.out.println("full plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h,baseCircle);
			s = primativeCam.fullDisplacement();
			v = primativeCam.fullVelocity();
			a= primativeCam.fullAcceleration();
			j = primativeCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement", Integer.toString(i));
			dataSet.addValue(v[i], "velocity", Integer.toString(i));
			dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
			dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h,baseCircle);
			s = normalCam.fullDisplacement();
			v = normalCam.fullVelocity();
			a= normalCam.fullAcceleration();
			j = normalCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
				dataSet.addValue(s[i], "displacement", Integer.toString(i));
				dataSet.addValue(v[i], "velocity", Integer.toString(i));
				dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
				dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h,baseCircle);
			s = accurateCam.fullDisplacement();
			v = accurateCam.fullVelocity();
			a= accurateCam.fullAcceleration();
			j = accurateCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
				dataSet.addValue(s[i], "displacement", Integer.toString(i));
				dataSet.addValue(v[i], "velocity", Integer.toString(i));
				dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
				dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h,baseCircle);
			s = moreAccurateCam.fullDisplacement();
			v = moreAccurateCam.fullVelocity();
			a= moreAccurateCam.fullAcceleration();
			j = moreAccurateCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
				dataSet.addValue(s[i], "displacement", Integer.toString(i));
				dataSet.addValue(v[i], "velocity", Integer.toString(i));
				dataSet.addValue(a[i], "Acceleration", Integer.toString(i));
				dataSet.addValue(j[i], "Jerk", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "S-V-A-J", // Y-Axis Label  
			        dataSet,
			        PlotOrientation.VERTICAL,
			        true,
			        true,
			        false  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	
	public void displacementPlot(double seta, double h, int camIndex) {
		
		s = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h);
			s = primativeCam.displacement();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h);
			s = normalCam.displacement();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h);
			s = accurateCam.displacement();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
			s = moreAccurateCam.displacement();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	void velocityPlot(double seta, double h, int camIndex) {
		
		v = new double[(int)seta+1];
		
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h);
			v = primativeCam.velocity();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h);
			v = normalCam.velocity();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h);
			v = accurateCam.velocity();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
			v = moreAccurateCam.velocity();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	void accelerationPlot(double seta, double h, int camIndex) {
		
		a = new double[(int)seta+1];
		
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h);
			a = primativeCam.acceleration();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h);
			a = normalCam.acceleration();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h);
			a = accurateCam.acceleration();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
			a = moreAccurateCam.acceleration();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	void jerkPlot(double seta, double h, int camIndex) {
		
		j = new double[(int)seta+1];
	
		
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h);
			j = primativeCam.jerk();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h);
			j = normalCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h);
			j = accurateCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
			j = moreAccurateCam.jerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	
	// ################### FULL PLOT ###################################################################
	
	
	
	public void fullDisplacementPlot(double seta, double h, int camIndex, double baseCircle) {
		
		s = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h,baseCircle);
			s = primativeCam.fullDisplacement();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h,baseCircle);
			s = normalCam.fullDisplacement();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h,baseCircle);
			s = accurateCam.fullDisplacement();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h,baseCircle);
			s = moreAccurateCam.fullDisplacement();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(s[i], "displacement-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Displacement", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	void fullVelocityPlot(double seta, double h, int camIndex, double baseCircle) {
		
		v = new double[(int)seta+1];
		
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h,baseCircle);
			v = primativeCam.fullVelocity();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h,baseCircle);
			v = normalCam.fullVelocity();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h,baseCircle);
			v = accurateCam.fullVelocity();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h,baseCircle);
			v = moreAccurateCam.fullVelocity();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(v[i], "Velocity-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Velocity", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	void fullAccelerationPlot(double seta, double h, int camIndex, double baseCircle) {
		
		a = new double[(int)seta+1];
		
		
		dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h,baseCircle);
			a = primativeCam.fullAcceleration();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h,baseCircle);
			a = normalCam.fullAcceleration();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h,baseCircle);
			a = accurateCam.fullAcceleration();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h,baseCircle);
			a = moreAccurateCam.fullAcceleration();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(a[i], "Acceleration-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Acceleration", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	void fullJerkPlot(double seta, double h, int camIndex, double baseCircle) {
		
		j = new double[(int)seta+1];
	
		
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h,baseCircle);
			j = primativeCam.fullJerk();
		
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h,baseCircle);
			j = normalCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h,baseCircle);
			j = accurateCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h,baseCircle);
			j = moreAccurateCam.fullJerk();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(j[i], "Jerk-Duration", Integer.toString(i));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	// ###### CAM PROFILE ##########
	
	void camProfilePlot(double seta, double h, int camIndex, double baseCircle) {
		
		XCamProfile = new double[361];
		YCamProfile = new double[361];
	
		
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		if(camIndex==1) {
			PrimativeCam primativeCam = new PrimativeCam(seta,h,baseCircle);
			XCamProfile = primativeCam.XCamProfile();
			YCamProfile = primativeCam.YCamProfile();
		
			for(int i=0 ; i<=360 ; i++) {
			
			dataSet.addValue(YCamProfile[i], "Cam Profile", Double.toString(XCamProfile[i]));
			}
			chart = ChartFactory.createLineChart(  
			        "Primative Cam", // Chart title  
			        "X", // X-Axis Label  
			        "Y", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==2) {
			NormalCam normalCam = new NormalCam(seta,h,baseCircle);
			XCamProfile = normalCam.XCamProfile();
			YCamProfile = normalCam.YCamProfile();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(YCamProfile[i], "Cam Profile", Double.toString(XCamProfile[i]));
			}
			chart = ChartFactory.createLineChart(  
			        "Normal Cam", // Chart title  
			        "X", // X-Axis Label  
			        "Y", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==3) {
			AccurateCam accurateCam = new AccurateCam(seta,h,baseCircle);
			XCamProfile = accurateCam.XCamProfile();
			YCamProfile = accurateCam.YCamProfile();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(YCamProfile[i], "Cam Profile", Double.toString(XCamProfile[i]));
			}
			chart = ChartFactory.createLineChart(  
			        "Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		else if(camIndex==4) {
			MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h,baseCircle);
			XCamProfile = moreAccurateCam.XCamProfile();
			YCamProfile = moreAccurateCam.YCamProfile();
			
			for(int i=0 ; i<seta ; i++) {
			
			dataSet.addValue(YCamProfile[i], "Cam Profile", Double.toString(XCamProfile[i]));
			}
			chart = ChartFactory.createLineChart(  
			        "More Accurate Cam", // Chart title  
			        "Duration", // X-Axis Label  
			        "Jerk", // Y-Axis Label  
			        dataSet  
			        ); 
		}
		
		
		 
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
		
	}
	
	
	// ########################### All Cams ###################################
	
	void allCamsPlot(double seta, double h, int camIndex){
		displacementAllCamsPlot(seta, h, camIndex);
	}
	
	void displacementAllCamsPlot(double seta, double h, int camIndex){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h);
		NormalCam normalCam = new NormalCam(seta,h);
		AccurateCam accurateCam = new AccurateCam(seta,h);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
		
			
		s = primativeCam.displacement();
		v = normalCam.displacement();
		a= accurateCam.displacement();
		j = moreAccurateCam.displacement();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Displacement", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}
	
	void velocityAllCamsPlot(double seta, double h, int camIndex){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h);
		NormalCam normalCam = new NormalCam(seta,h);
		AccurateCam accurateCam = new AccurateCam(seta,h);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
		
			
		s = primativeCam.velocity();
		v = normalCam.velocity();
		a= accurateCam.velocity();
		j = moreAccurateCam.velocity();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Velocity", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}
	
	void accelerationAllCamsPlot(double seta, double h, int camIndex){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h);
		NormalCam normalCam = new NormalCam(seta,h);
		AccurateCam accurateCam = new AccurateCam(seta,h);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
		
			
		s = primativeCam.acceleration();
		v = normalCam.acceleration();
		a= accurateCam.acceleration();
		j = moreAccurateCam.acceleration();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Acceleration", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}	
	
	void jerkAllCamsPlot(double seta, double h, int camIndex){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h);
		NormalCam normalCam = new NormalCam(seta,h);
		AccurateCam accurateCam = new AccurateCam(seta,h);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
		
			
		s = primativeCam.jerk();
		v = normalCam.jerk();
		a= accurateCam.jerk();
		j = moreAccurateCam.jerk();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Jerk", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}		
	
	
	// ########################### Full All Cams ###################################
	
	void fullAllCamsPlot(double seta, double h, int camIndex,double baseCircle){
		displacementFullAllCamsPlot(seta, h, camIndex, baseCircle);
	}
	
	void displacementFullAllCamsPlot(double seta, double h, int camIndex,double baseCircle){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h, baseCircle);
		NormalCam normalCam = new NormalCam(seta,h, baseCircle);
		AccurateCam accurateCam = new AccurateCam(seta,h, baseCircle);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h, baseCircle);
		
			
		s = primativeCam.fullDisplacement();
		v = normalCam.fullDisplacement();
		a= accurateCam.fullDisplacement();
		j = moreAccurateCam.fullDisplacement();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Displacement", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}
	
	
	
	
	void velocityFullAllCamsPlot(double seta, double h, int camIndex,double baseCircle){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h, baseCircle);
		NormalCam normalCam = new NormalCam(seta,h, baseCircle);
		AccurateCam accurateCam = new AccurateCam(seta,h, baseCircle);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h, baseCircle);
		
			
		s = primativeCam.fullVelocity();
		v = normalCam.fullVelocity();
		a= accurateCam.fullVelocity();
		j = moreAccurateCam.fullVelocity();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Velocity", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}
	
	void accelerationFullAllCamsPlot(double seta, double h, int camIndex,double baseCircle){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h, baseCircle);
		NormalCam normalCam = new NormalCam(seta,h, baseCircle);
		AccurateCam accurateCam = new AccurateCam(seta,h, baseCircle);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h, baseCircle);
		
			
		s = primativeCam.fullAcceleration();
		v = normalCam.fullAcceleration();
		a= accurateCam.fullAcceleration();
		j = moreAccurateCam.fullAcceleration();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Acceleration", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}	
	
	void jerkFullAllCamsPlot(double seta, double h, int camIndex,double baseCircle){
		
		//System.out.println("half plot method : " + seta);
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		dataSet = new DefaultCategoryDataset();
		
		
		
		PrimativeCam primativeCam = new PrimativeCam(seta,h, baseCircle);
		NormalCam normalCam = new NormalCam(seta,h, baseCircle);
		AccurateCam accurateCam = new AccurateCam(seta,h, baseCircle);
		MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h, baseCircle);
		
			
		s = primativeCam.fullJerk();
		v = normalCam.fullJerk();
		a= accurateCam.fullJerk();
		j = moreAccurateCam.fullJerk();
		
		for(int i=0 ; i<seta ; i++) {
		
			dataSet.addValue(s[i], "Primative", Integer.toString(i));
			dataSet.addValue(v[i], "Normal", Integer.toString(i));
			dataSet.addValue(a[i], "Accurate", Integer.toString(i));
			dataSet.addValue(j[i], "More Accurate", Integer.toString(i));
		}
		
		chart = ChartFactory.createLineChart(  
		        "All Cams", // Chart title  
		        "Duration", // X-Axis Label  
		        "Jerk", // Y-Axis Label  
		        dataSet,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false  
		        ); 
		
		
		
		 ChartPanel chartPanel = new ChartPanel(chart);
		// chartPanel.setDomainZoomable(true);
		 chartPanel.setBounds(30,10,900,660);
		 //CamInterface.rightPanel.repaint();
		 CamInterface.rightPanel.add(chartPanel);
	}	





}

