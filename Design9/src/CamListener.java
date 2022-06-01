import java.awt.event.*;
import java.io.IOException;

import javax.swing.SwingUtilities;

public class CamListener implements ActionListener{

	double h;
	double seta;
	double FullSeta;
	int camIndex;
	double baseCircle;
	String type;
	Plot plot;
	Plot fullPlot;
	PrimativeCam primativeCam = new PrimativeCam(seta,h);
	NormalCam normalCam = new NormalCam(seta,h);
	AccurateCam accurateCam = new AccurateCam(seta,h);
	MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(CamInterface.halfCamRadio.isSelected()) {
			plot = new Plot(seta, h, camIndex);
			
			
			System.out.println("radio half working");
			
			h = Double.parseDouble(CamInterface.valveLiftText.getText());
			camIndex = CamInterface.camTypeBox.getSelectedIndex();
			
			ExcelFile excelFile = new ExcelFile();
			
			seta = Double.parseDouble(CamInterface.durationText.getText()) / 2;
		
			if(e.getSource() == CamInterface.saveButton) {
				
				switch(camIndex) {
					
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
				break;
				case 1:
					PrimativeCam primativeCam = new PrimativeCam(seta,h);
					try {
						excelFile.excel(seta+1,primativeCam.displacement(),primativeCam.velocity(),primativeCam.acceleration(),primativeCam.jerk()  );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				break;
				case 2:
					NormalCam normalCam = new NormalCam(seta,h);
					try {
						excelFile.excel(seta+1,normalCam.displacement(),normalCam.velocity(),normalCam.acceleration(),normalCam.jerk()  );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				break;	
				case 3:
					AccurateCam accurateCam = new AccurateCam(seta,h);
					try {
						excelFile.excel( seta+1,accurateCam.displacement(),accurateCam.velocity(),accurateCam.acceleration(),accurateCam.jerk() );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				break;	
				case 4:
					MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
					try {
						excelFile.excel( seta+1 , moreAccurateCam.displacement(),moreAccurateCam.velocity(),moreAccurateCam.acceleration(),moreAccurateCam.jerk() );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				break;
				
				
				}
				
				
			}
			
			
			else if(e.getSource() == CamInterface.plotButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				switch(camIndex) {
				
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
				break;
				case 1:
					new Plot(seta, h, camIndex);
					CamInterface.vMaxText.setText(Double.toString(primativeCam.maxVelocity()));
					CamInterface.vMinText.setText(Double.toString(primativeCam.minVelocity()));
					CamInterface.aMaxText.setText(Double.toString(primativeCam.maxAcceleration()));
					CamInterface.aMinText.setText(Double.toString(primativeCam.minAcceleration()));
					CamInterface.jMaxText.setText(Double.toString(primativeCam.maxJerk()));
					CamInterface.jMinText.setText(Double.toString(primativeCam.minJerk()));
					
				break;
				case 2:
					new Plot(seta, h, camIndex);
					/*CamInterface.vMaxText.setText(Double.toString(normalCam.maxVelocity()));
					CamInterface.vMinText.setText(Double.toString(normalCam.minVelocity()));
					CamInterface.aMaxText.setText(Double.toString(normalCam.maxAcceleration()));
					CamInterface.aMinText.setText(Double.toString(normalCam.minAcceleration()));
					CamInterface.jMaxText.setText(Double.toString(normalCam.maxJerk()));
					CamInterface.jMinText.setText(Double.toString(normalCam.minJerk()));*/
				break;
				case 3:
					new Plot(seta, h, camIndex);
				break;
				case 4:
					new Plot(seta, h, camIndex);
				break;
				
				}
			}
			else if(e.getSource() == CamInterface.displacementButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				
				
				switch(camIndex) {
				
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
				break;
				case 1:
					plot.displacementPlot(seta, h, camIndex);
				break;
				case 2:
					plot.displacementPlot(seta, h, camIndex);
				break;
				case 3:
					plot.displacementPlot(seta, h, camIndex);
				break;
				case 4:
					plot.displacementPlot(seta, h, camIndex);
				break;
				
				}
			}
			else if(e.getSource() == CamInterface.velocityButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				
				
				switch(camIndex) {
				
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
				break;
				case 1:
					plot.velocityPlot(seta, h, camIndex);
					
				break;
				case 2:
					plot.velocityPlot(seta, h, camIndex);
				break;
				case 3:
					plot.velocityPlot(seta, h, camIndex);
				break;
				case 4:
					plot.velocityPlot(seta, h, camIndex);
				break;
				
				}
			}
			else if(e.getSource() == CamInterface.accelerationButton) {
			
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				
				
				switch(camIndex) {
				
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
				break;
				case 1:
					plot.accelerationPlot(seta, h, camIndex);
				break;
				case 2:
					plot.accelerationPlot(seta, h, camIndex);
				break;
				case 3:
					plot.accelerationPlot(seta, h, camIndex);
				break;
				case 4:
					plot.accelerationPlot(seta, h, camIndex);
				break;
				
				}
			}
			else if(e.getSource() == CamInterface.jerkButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				
				
				switch(camIndex) {
				
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
				break;
				case 1:
					plot.jerkPlot(seta, h, camIndex);
				break;
				case 2:
					plot.jerkPlot(seta, h, camIndex);
				break;
				case 3:
					plot.jerkPlot(seta, h, camIndex);
				break;
				case 4:
					plot.jerkPlot(seta, h, camIndex);
				break;
				
				}
			}
			
			
			
		}
		
		// #####################################################################################################
		
		else if(CamInterface.fullCamRadio.isSelected()) {
			
			fullPlot = new Plot(seta, h, camIndex, baseCircle);
			
			System.out.println("radio full working");
			
			h = Double.parseDouble(CamInterface.valveLiftText.getText());
			camIndex = CamInterface.camTypeBox.getSelectedIndex();
			
			ExcelFile excelFile = new ExcelFile();
			
			seta = Double.parseDouble(CamInterface.durationText.getText());
			baseCircle = Double.parseDouble(CamInterface.baseCircleText.getText());
			
			if(e.getSource() == CamInterface.plotButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				switch(camIndex) {
				
				case 0:
					System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex,baseCircle);
				break;
				case 1:
					new Plot(seta, h, camIndex,baseCircle);
					
				break;
				case 2:
					new Plot(seta, h, camIndex,baseCircle);
					/*CamInterface.vMaxText.setText(Double.toString(normalCam.maxVelocity()));
					CamInterface.vMinText.setText(Double.toString(normalCam.minVelocity()));
					CamInterface.aMaxText.setText(Double.toString(normalCam.maxAcceleration()));
					CamInterface.aMinText.setText(Double.toString(normalCam.minAcceleration()));
					CamInterface.jMaxText.setText(Double.toString(normalCam.maxJerk()));
					CamInterface.jMinText.setText(Double.toString(normalCam.minJerk()));*/
				break;
				case 3:
					new Plot(seta, h, camIndex,baseCircle);
				break;
				case 4:
					new Plot(seta, h, camIndex,baseCircle);
				break;
				
				}
			}
			
			
		
		
		else if(e.getSource() == CamInterface.displacementButton) {
			
			CamInterface.rightPanel.removeAll();
			CamInterface.frame.remove(CamInterface.rightPanel);
			CamInterface.frame.add(CamInterface.rightPanel);
			SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
			
			switch(camIndex) {
			
			case 0:
				System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
			break;
			case 1:
				fullPlot.fullDisplacementPlot(seta, h, camIndex,baseCircle);
			break;
			case 2:
				fullPlot.fullDisplacementPlot(seta, h, camIndex,baseCircle);
			break;
			case 3:
				fullPlot.fullDisplacementPlot(seta, h, camIndex,baseCircle);
			break;
			case 4:
				fullPlot.fullDisplacementPlot(seta, h, camIndex,baseCircle);
			break;
			
			}
		}
		else if(e.getSource() == CamInterface.velocityButton) {
			
			CamInterface.rightPanel.removeAll();
			CamInterface.frame.remove(CamInterface.rightPanel);
			CamInterface.frame.add(CamInterface.rightPanel);
			SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
			
			switch(camIndex) {
			
			case 0:
				System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
			break;
			case 1:
				fullPlot.fullVelocityPlot(seta, h, camIndex,baseCircle);
				
			break;
			case 2:
				fullPlot.fullVelocityPlot(seta, h, camIndex,baseCircle);
			break;
			case 3:
				fullPlot.fullVelocityPlot(seta, h, camIndex,baseCircle);
			break;
			case 4:
				fullPlot.fullVelocityPlot(seta, h, camIndex,baseCircle);
			break;
			
			}
		}
		else if(e.getSource() == CamInterface.accelerationButton) {
		
			CamInterface.rightPanel.removeAll();
			CamInterface.frame.remove(CamInterface.rightPanel);
			CamInterface.frame.add(CamInterface.rightPanel);
			SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
			
			switch(camIndex) {
			
			case 0:
				System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
			break;
			case 1:
				fullPlot.fullAccelerationPlot(seta, h, camIndex,baseCircle);
			break;
			case 2:
				fullPlot.fullAccelerationPlot(seta, h, camIndex,baseCircle);
			break;
			case 3:
				fullPlot.fullAccelerationPlot(seta, h, camIndex,baseCircle);
			break;
			case 4:
				fullPlot.fullAccelerationPlot(seta, h, camIndex,baseCircle);
			break;
			
			}
		}
		else if(e.getSource() == CamInterface.jerkButton) {
			
			CamInterface.rightPanel.removeAll();
			CamInterface.frame.remove(CamInterface.rightPanel);
			CamInterface.frame.add(CamInterface.rightPanel);
			SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
			
			switch(camIndex) {
			
			case 0:
				System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
			break;
			case 1:
				fullPlot.fullJerkPlot(seta, h, camIndex,baseCircle);
			break;
			case 2:
				fullPlot.fullJerkPlot(seta, h, camIndex,baseCircle);
			break;
			case 3:
				fullPlot.fullJerkPlot(seta, h, camIndex,baseCircle);
			break;
			case 4:
				fullPlot.fullJerkPlot(seta, h, camIndex,baseCircle);
			break;
			
			}
		}
		
		else if(e.getSource() == CamInterface.camProfileButton) {
			
			CamInterface.rightPanel.removeAll();
			CamInterface.frame.remove(CamInterface.rightPanel);
			CamInterface.frame.add(CamInterface.rightPanel);
			SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
			
			switch(camIndex) {
			
			case 0:
				System.out.printf("%.1f, %.1f, %d,##",seta,h,camIndex);
			break;
			case 1:
				fullPlot.camProfilePlot(seta, h, camIndex,baseCircle);
			break;
			case 2:
				fullPlot.camProfilePlot(seta, h, camIndex,baseCircle);
			break;
			case 3:
				fullPlot.camProfilePlot(seta, h, camIndex,baseCircle);
			break;
			case 4:
				fullPlot.camProfilePlot(seta, h, camIndex,baseCircle);
			break;
			
			
		}
		}
		
			else {
			System.out.println("not working");
		}
		
		}

	// ####################################     Half All Cams       #################################### 	
		
		
		
		else if(CamInterface.allCamsRadio.isSelected()) {
			
			plot = new Plot(seta, h, camIndex);
			
			//System.out.println("radio full working");
			
			h = Double.parseDouble(CamInterface.valveLiftText.getText());
			camIndex = CamInterface.camTypeBox.getSelectedIndex();
			
			ExcelFile excelFile = new ExcelFile();
			
			seta = Double.parseDouble(CamInterface.durationText.getText()) / 2;
			baseCircle = Double.parseDouble(CamInterface.baseCircleText.getText());
			
			if(e.getSource() == CamInterface.plotButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
					plot.allCamsPlot(seta, h, camIndex);
				
			}
			
			else if(e.getSource() == CamInterface.displacementButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				plot.displacementAllCamsPlot(seta, h, camIndex);
				
				
			}
			else if(e.getSource() == CamInterface.velocityButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				plot.velocityAllCamsPlot(seta, h, camIndex);
				
				
			}
			else if(e.getSource() == CamInterface.accelerationButton) {
			
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				plot.accelerationAllCamsPlot(seta, h, camIndex);
				
				
			}
			else if(e.getSource() == CamInterface.jerkButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				plot.jerkAllCamsPlot(seta, h, camIndex);
				
				
			}
			
			
		else {
			System.out.println("not working");
		}
		
		}
		
		
		//###############################    Full All Cams    ##################################
		
		else if(CamInterface.fullAllCamsRadio.isSelected()) {
			
			fullPlot = new Plot(seta, h, camIndex, baseCircle);
			
			//System.out.println("radio full working");
			
			h = Double.parseDouble(CamInterface.valveLiftText.getText());
			camIndex = CamInterface.camTypeBox.getSelectedIndex();
			
			ExcelFile excelFile = new ExcelFile();
			
			seta = Double.parseDouble(CamInterface.durationText.getText());
			baseCircle = Double.parseDouble(CamInterface.baseCircleText.getText());
			
			if(e.getSource() == CamInterface.plotButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
			
			
				fullPlot.fullAllCamsPlot(seta, h, camIndex, baseCircle);
			}
			
			else if(e.getSource() == CamInterface.displacementButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				fullPlot.displacementFullAllCamsPlot(seta, h, camIndex, baseCircle);
				
			}
			else if(e.getSource() == CamInterface.velocityButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				
				fullPlot.velocityFullAllCamsPlot(seta, h, camIndex, baseCircle);
				
			}
			else if(e.getSource() == CamInterface.accelerationButton) {
			
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				
				fullPlot.accelerationFullAllCamsPlot(seta, h, camIndex, baseCircle);
				
			}
			else if(e.getSource() == CamInterface.jerkButton) {
				
				CamInterface.rightPanel.removeAll();
				CamInterface.frame.remove(CamInterface.rightPanel);
				CamInterface.frame.add(CamInterface.rightPanel);
				SwingUtilities.updateComponentTreeUI(CamInterface.frame);
				
				fullPlot.jerkFullAllCamsPlot(seta, h, camIndex, baseCircle);
				
				
			}
			
			
			
			
		else {
			System.out.println("not working");
		}
		
		}
	
	}
}

