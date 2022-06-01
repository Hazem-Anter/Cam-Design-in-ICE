import java.io.IOException;
import java.util.Scanner;

public class Input {
	
	
	
	public Input() {
		
		
		double seta;
		double h;
		
		try (Scanner scanner = new Scanner(System.in)) {
			ExcelFile excelFile = new ExcelFile();
			
			System.out.println("Choose a Cam :");
			System.out.println("1- Primative Cam.");
			System.out.println("2- Normal Cam.");
			System.out.println("3- Accurate Cam");
			System.out.println("4- More Accurate Cam.");
			int i = scanner.nextInt();
			switch(i) {
				case 1:
					System.out.print("Enter Duration : ");
					seta = scanner.nextDouble();
					System.out.println();
					System.out.print("Enter Valve Lift : ");
					h = scanner.nextDouble();
					PrimativeCam primativeCam = new PrimativeCam(seta,h);
					excelFile.excel(seta+1,primativeCam.displacement(),primativeCam.velocity(),primativeCam.acceleration(),primativeCam.jerk()  );
				break;
				case 2:
					System.out.print("Enter Duration : ");
					seta = scanner.nextDouble();
					System.out.println();
					System.out.print("Enter Valve Lift : ");
					h = scanner.nextDouble();
					NormalCam normalCam = new NormalCam(seta,h);
					excelFile.excel(seta+1,normalCam.displacement(),normalCam.velocity(),normalCam.acceleration(),normalCam.jerk()  );
				break;	
				case 3:
					System.out.print("Enter Duration : ");
					seta = scanner.nextDouble();
					System.out.println();
					System.out.print("Enter Valve Lift : ");
					h = scanner.nextDouble();
					AccurateCam accurateCam = new AccurateCam(seta,h);
					excelFile.excel( seta+1,accurateCam.displacement(),accurateCam.velocity(),accurateCam.acceleration(),accurateCam.jerk() );
				break;	
				case 4:
					System.out.print("Enter Duration : ");
					seta = scanner.nextDouble();
					System.out.println();
					System.out.print("Enter Valve Lift : ");
					h = scanner.nextDouble();
					MoreAccurateCam moreAccurateCam = new MoreAccurateCam(seta,h);
					excelFile.excel( seta+1 , moreAccurateCam.displacement(),moreAccurateCam.velocity(),moreAccurateCam.acceleration(),moreAccurateCam.jerk() );
				break;	
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
