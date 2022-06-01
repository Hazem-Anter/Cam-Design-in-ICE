import java.text.DecimalFormat;

public class NormalCam {
	
	double seta;
	double fullSeta;
	double h;
	double baseCircle;
	double MxStp;
	double MnStp;
	double aMax ; 
	double aMin;
	double vMax;
	double vMid;
	double sMinus;
	double y;
	double x;
	double p;
	double s[];
	double v[];
	double a[];
	double j[];
	double fs[];
	double fv[];
	double fa[];
	double fj[];
	double XCamProf[];
	double YCamProf[];
	int B1,B2,B3,B4,B5,B6,B7,K1,K2,K3,K4,K5,K6,K7;
	DecimalFormat dformat;
	int i;
	
	NormalCam(double seta, double h){
		this.seta = seta;
		this.h = h;
	}
	NormalCam(double fullSeta, double h, double baseCircle ){
		this.baseCircle = baseCircle;
		this.seta = fullSeta/2;
		this.fullSeta = fullSeta;
		this.h = h;
	}
	
	

	public void bk() {
		
		aMax = 0;
		p = 0.15;
		aMin = 0;
		
		i = 0;
		//sMinus=0;
		dformat = new DecimalFormat("0.00");
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		//  seta limits for each beta(B)
		B1 = (int)Math.ceil(seta/8);
		B2 = (int)Math.ceil(seta/16);
		B3 = (int)Math.ceil(seta/32);
		B4 = (int)Math.ceil(seta/16);
		B5 = (int)Math.ceil(seta/8);
		B6 = (int)Math.ceil(seta/16);
		B7 = (int)(seta-(B1+B2+B3+B4+B5+B6));
		
		// Array index
		K1 = B1;	 // 0 : K1 --- 0 : 10    
		K2 = K1+B2;  // K1+2 : K2 --- 12 : 16   11 for /0 ... 12 13 14 15 16 ... 5
		K3 = K2+B3;  // K2+2 : K3 --- 18 : 20   17 for /0 ... 18 19 20 .... 3
		K4 = K3+B4;  // K3+2 : K4 --- 22 : 26
		K5 = K4+B5;  // k4+2 : K5 --- 28 : 37
		K6 = K5+B6;  // K5+2 : K6 --- 39 : 43
		K7 = (int)seta;   // K5+2 : seta  --- 45 : 90
		
		
		
		
		  /*                              //seta=80
		System.out.println("B1 "+ B1);  //B1=10
		System.out.println("B2 "+ B2);  //B2=5
		System.out.println("B3 "+ B3);  //B3=3
		System.out.println("B4 "+ B4);  //B4=5
		System.out.println("B5 "+ B5);  //B5=10
		System.out.println("B6 "+ B6);  //B6=5
		System.out.println("B7 "+ B7);  //B7=42
		System.out.println("K1 "+ K1);  //K1=10
		System.out.println("K2 "+ K2);  //K2=15
		System.out.println("K3 "+ K3);  //K3=18
		System.out.println("K4 "+ K4);  //K4=23
		System.out.println("K5 "+ K5);  //K5=33
		System.out.println("K6 "+ K6);  //K6=38
		System.out.println("K7 "+ K7);  //K7=80*/
	}
	
	public void check_SVAJ() {
		bk();
		
		do {
			
			MxStp = aMax/B2;
			MnStp = aMin/B6;
			
			
		accelerationEquations();
		velocityEquations();
		displacementEquations();
		jerkEquations();
		
		/*
		for(int i=1 ; i<(int)seta  ; i++) {
			sMinus = Math.min(s[i] , sMinus);
		}*/
		x = s[(int)seta] - s[0];
		/*
		for (int i=0 ; i<(int)seta ;i++) {
			y = s[i];
			if(y<0)
				continue;
		}*/
		
		if(v[0] < 0 ) {
			p += 0.01;
		}
		
		aMax += 0.000001;
		aMin = - p * aMax;
		/*
		if(x>h ) {
			aMax += 0.0002;
		}
		else if (x<h ) {
			
			aMin -= 0.00002;
		}
		/*else if (sMinus<0) {
			
			jMax += 0.0001;
		}*/
		
		/*
		if (v[0] <= 0 && Double.parseDouble(dformat.format(x)) != h) {
			
			for(int i=0 ; i<(int)seta  ; i++) {
				vMax = Math.max(v[i] , vMax);
			}
			
			vMid = (vMax - v[K8])/2 ;
			
		}*/
		
		
		}while(Double.parseDouble(dformat.format(x)) != h || v[0] < 0);
	
		
	}
	
	public void accelerationEquations() {
		
		
		//	    B1   &   K1
		for(int i=0 ; i <= K1 ; i++) { //0  10
			a[i] = 0; 
		}
		//	    B2   &   K2
		for(int i=K1+1,z=1 ; i <= K2 && z<=B2 ; i++,z++) { // 11 15
			a[i] = MxStp*z;
		}
		//	    B3   &   K3		
		for(int i=K2+1 ; i<=K3 ; i++) { // 16  18
			a[i] = aMax;
		}
		//	    B4   &   K4	
		for(int i=K3+1,z=1 ; i<=K4 && z<=B4 ; i++,z++) {   // 19  23
			a[i] = aMax - (MxStp*z) ;
		}
		//	    B5   &   K5	
		for(int i=K4+1 ; i <= K5 ; i++) {    //24   33
			a[i] = 0;
		}
		//	    B6   &   K6	
		for(int i=K5+1,z=1 ; i<=K6 && z<=B6 ; i++,z++) {   //34   38
			a[i] = MnStp*z;
		}
		//	    B7   &   K7	
		for(int i=K6+1 ; i <= K7 ; i++) {   // 39    80
			a[i] = aMin ;
		}
		
		
		
	}
	
	public void velocityEquations() {
		
		
		//end of beta7 ( the end point )
		v[K7] = 0;  //index(i) = 80 & beta = 42
		//end of beta6 and beginning of beta7
		v[K6] = v[K7] - (aMin * B7); // K6=38 , B7=42
		//end of beta5 and beginning of beta6
		v[K5] = v[K6] - ((MnStp/2)*(B6*B6)); // K5 = 33 , B6 = 5
		//end of beta4 and beginning of beta5
		v[K4] = v[K5];  // K4 = 23 , B4 = 5
		//end of beta3 and beginning of beta4
		v[K3] = v[K4] +((MxStp/2)*(B4*B4)) - (aMax*B4);  // K3 = 18 , B3 = 3
		//end of beta2 and beginning of beta3
		v[K2] = v[K3] - (aMax*B3);  // K2 = 15 , B2 = 5
		//end of beta1 and beginning of beta2
		v[K1] = v[K2] - ((MxStp/2)*(B2*B2));  // K1 = 10 , B1 = 10
		//beginning of beta1 ( the start point )
		v[0] = v[K1];  // K=0 , B=0
		
		//	    B1   &   K1
		for(int i=0 ; i < K1 ; i++) { //K = 79  39 , z(beta) = 41  0
			v[i] = v[0] ;
		}
		//	    B2   &   K2	
		for(int i=K1+1,z=1 ; i < K2 && z<B2 ; i++,z++) { // k = 38  34 , z = 4  0
			v[i] = ((MxStp/2)*(z*z)) + v[K1];
		}
		//	    B3   &   K3	
		for(int i=K2+1,z=1 ; i<K3 && z<B3 ; i++,z++) { // k = 33  24 , z = 9  0
			v[i] = (aMax*z) + v[K2];
		}
		//	    B4   &   K4		
		for(int i=K3+1,z=1 ; i<K4 && z<B4 ; i++,z++) {   // k = 23  19 , z = 4  0
			v[i] = (aMax*z) - ((MxStp/2)*(z*z)) + v[K3] ;
		}
		//	    B5  &   K5		
		for(int i=K4+1 ; i < K5 ; i++) {    // k = 18  16 , z = 2  0
			
			v[i] = v[K4]; 
		}
		//	    B6   &   K6		
		for(int i=K5+1,z=1 ; i<K6 && z<B6 ; i++,z++) {   // k = 15  11 , z = 4  0
			
			v[i] = ((MnStp/2)*(z*z)) + v[K5];
		}
		//	    B7   &   K7		
		for(int i=K6+1,z=1 ; i < K7 && z<B7 ; i++,z++) {   // k = 10  0 , z = 9  0
			v[i] = (aMin * z) + v[K6]; // z= 41 40 39 38 37 36 ....... 0 , i= 80 79 78 77 76 75 .... 39 (39:80)
		}
		
		
		
	}
	
	public void displacementEquations() {
		
		
		//end of beta7 ( the end point )
		s[K7] = h;  //index(i) = 80 & beta = 42
		//end of beta6 and beginning of beta7
		s[K6] = s[K7] - ((aMin/2) * (B7*B7)) - (v[K6]*B7); // K6=38 , B7=5
		//end of beta5 and beginning of beta6
		s[K5] = s[K6] - ((MnStp/6)*(B6*B6*B6)) - (v[K5]*B6); // K5 = 33 , B6 = 5
		//end of beta4 and beginning of beta5
		s[K4] = s[K5] - (v[K4]*B5);  // K4 = 23 , B4 = 5
		//end of beta3 and beginning of beta4
		s[K3] = s[K4] - ((aMax/2)*(B4*B4)) + ((MxStp/6)*(B4*B4*B4)) - (v[K3]*B4);  // K3 = 18 , B3 = 3
		//end of beta2 and beginning of beta3
		s[K2] = s[K3] - ((aMax/2)*(B3*B3)) - (v[K2]*B3);  // K2 = 15 , B2 = 5
		//end of beta1 and beginning of beta2
		s[K1] = s[K2] - ((MxStp/6)*(B2*B2*B2)) - (v[K1]*B2);  // K1 = 10 , B1 = 10
		//beginning of beta1 ( the start point )
		s[0] = s[K1] - (v[0]*B1);  // K=0 , B=0
		
		//    B1   &   K1
		for(int i=1,z=1 ; i<K1 && z<B1 ; i++,z++) { //K = 79  39 , z(beta) = 41  0
			s[i] = (v[0]*z) + s[0] ;  //?????????????
		}
		//    B2   &   K2
		for(int i=K1+1,z=1 ; i<K2 && z<B2 ; i++,z++) { // k = 38  34 , z = 4  0
			s[i] = ((MxStp/6)*(z*z*z)) + (v[K1]*z) + s[K1];
		}
		//    B3  &   K3
		for(int i=K2+1,z=1 ; i<K3 && z<B3 ; i++,z++) { // k = 33  24 , z = 9  0
			s[i] = ((aMax/2)*(z*z)) + (v[K2]*z) + s[K2];
		}
		//    B4   &   K4
		for(int i=K3+1,z=1 ; i<K4 && z<B4 ; i++,z++) {   // k = 23  19 , z = 4  0
			s[i] = ((aMax/2)*(z*z)) - ((MxStp/6)*(z*z*z)) + (v[K3]*z) + s[K3] ;
		}
		//    B5   &   K5
		for(int i=K4+1,z=1 ; i<K5 && z<B5 ; i++,z++) {    // k = 18  16 , z = 2  0
			s[i] = (v[K4]*z) + s[K4];
		}
		//    B6   &   K6
		for(int i=K5+1,z=1 ; i<K6 && z<B6 ; i++,z++) {   // k = 15  11 , z = 4  0
			s[i] = ((MnStp/6)*(z*z*z)) + (v[K5]*z) + s[K5];
		}
		//    B7   &   K7
		for(int i=K6+1,z=1 ; i < K7 && z<B7 ; i++,z++) {  // k = 10  0 , z = 9  0
			s[i] = ((aMin/2)*(z*z)) + (v[K6]*z) + s[K6] ;
		}
		
	}
	
	
	
	public void jerkEquations() {
		
		
		for(int i=0 ; i <= K1 ; i++) { //0  10
			j[i] = 0; 
		}
		for(int i=K1+1,z=1 ; i <= K2 && z<=B2 ; i++,z++) { // 11 15
			
			j[i] = MxStp;
			
		}
		for(int i=K2+1 ; i<=K3 ; i++) { // 16  18
			j[i] = 0;
		}
		for(int i=K3+1,z=1 ; i<=K4 && z<=B4 ; i++,z++) {   // 19  23
			
			j[i] = -MxStp ;
			
		}
		for(int i=K4+1 ; i <= K5 ; i++) {    //24   33
			j[i] = 0;
		}
		for(int i=K5+1,z=1 ; i<=K6 && z<=B6 ; i++,z++) {   //34   38
			
			j[i] = MnStp;
			
		}
		for(int i=K6+1 ; i <= K7 ; i++) {   // 39    80
			j[i] = 0 ;
		}
		
	}
	
	public double[] jerk() {
		check_SVAJ();
		/*System.out.println("aMax : " + aMax);
		System.out.println("aMin : " + aMin);
		System.out.println("v[0] : " + v[0]);
		System.out.println("x : " + x);
	*/
		return j;
	}

	public double[] acceleration() {
		check_SVAJ();
		
		return a;
	}


	public double[] velocity() {
		check_SVAJ();
		
		/*
		System.out.println("vMax : " + vMax);
		System.out.println("vMid : " + vMid);
		*/
		return v;
	}


	public double[] displacement() {
		check_SVAJ();
		//System.out.println("sMinus : " + sMinus);
		
		return s;
	}	
	
	
	// ##### Full	
		public double[] fullAcceleration() {
			acceleration();
			
			fa = new double[(int)fullSeta+1];
			
			for(int i=0 ; i<=(int)seta ; i++) {
				fa[i] = a[i];
			}
			for(int i=(int)seta+1,l = (int)seta-1 ; i<=(int)fullSeta && l>=0 ; i++,l--) {
				
				fa[i] = a[l];
			}
			
			return fa;
		}
		
		public double[] fullVelocity() {
			velocity();
			
			fv = new double[(int)fullSeta+1];
			
			for(int i=0 ; i<=(int)seta ; i++) {
				fv[i] = v[i];
			}
			for(int i=(int)seta+1,l = (int)seta-1 ; i<=(int)fullSeta && l>=0 ; i++,l--) {
				
				fv[i] = v[l];
			}
			
			return fv;
		}
		
		public double[] fullDisplacement() {
			displacement();
			
			fs = new double[(int)fullSeta+1];
			
			System.out.println("full displacement : " + fullSeta);
			System.out.println("full displacement : " + seta);
			
			for(int i=0 ; i<=(int)seta ; i++) {
				
				fs[i] = s[i];
			}
			
			for(int i=(int)seta+1,l = (int)seta-1 ; i<=(int)fullSeta && l>=0 ; i++,l--) {
				
				fs[i] = s[l];
				
			}
			//System.out.println(fs[81]);
			
			return fs;
		}
		
		public double[] fullJerk() {
			jerk();
			
			fj = new double[(int)fullSeta+1];
			
			for(int i=0 ; i<=(int)seta ; i++) {
				fj[i] = j[i];
			}
			for(int i=(int)seta+1,l = (int)seta-1 ; i<=(int)fullSeta && l>=0 ; i++,l--) {
				
				fj[i] = j[l];
			}
			
			return fj;
		}
		
		// #####
	
	
	
	public double maxJerk() {
		check_SVAJ();
		double jMax = 0;
		
		for(int i=0 ; i<(int)seta ; i++) {
			jMax = Math.max(jMax, j[i]);
		}
		
		return jMax;
	}
	public double minJerk() {
		check_SVAJ();
		double jMin = 0;
		
		for(int i=0 ; i<(int)seta ; i++) {
			jMin = Math.min(jMin, j[i]);
		}
		
		return jMin;
		}
	public double maxAcceleration() {
		check_SVAJ();
		
		return aMax;
	}
	public double minAcceleration() {
		check_SVAJ();
		
		return aMin;
	}
	public double maxVelocity() {
		check_SVAJ();
		double vMax = 0;
		
		for(int i=0 ; i<(int)seta ; i++) {
			vMax = Math.max(vMax, v[i]);
		}
		
		return vMax;
	}
	public double minVelocity() {
		check_SVAJ();
		double vMin = 0;
		
		for(int i=0 ; i<(int)seta ; i++) {
			vMin = Math.min(vMin, v[i]);
		}
		
		return vMin;
	}	
	
	
	// ################ CAM PROFILE 
	
		public double[] XCamProfile() {
			fullDisplacement();
			
			XCamProf = new double[361];
			
			for(int i=0 ; i<= fullSeta ; i++) {
				
				XCamProf[i] = ( baseCircle + fs[i] ) * Math.cos(i * (Math.PI / 180));
			}
			
			for(int i= (int)fullSeta+1 ; i<= (360 - fullSeta) ; i++) {
				
				XCamProf[i] = baseCircle  * Math.cos(i* (Math.PI / 180));
			}
			
			
			return XCamProf;
		}
		
		public double[] YCamProfile() {
			fullDisplacement();
			
			YCamProf = new double[361];
			
			for(int i=0 ; i<= fullSeta ; i++) {
				
				YCamProf[i] = ( baseCircle + fs[i] ) * Math.sin(i* (Math.PI / 180));
			}
			
			for(int i= (int)fullSeta+1 ; i<= (360 - fullSeta) ; i++) {
				
				YCamProf[i] = baseCircle  * Math.sin(i* (Math.PI / 180));
			}
			
			
			return YCamProf;
		}

}
