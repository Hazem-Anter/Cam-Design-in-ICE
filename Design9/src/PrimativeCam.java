import java.text.DecimalFormat;

public class PrimativeCam {
	
	double seta;
	double fullSeta;
	double h;
	double baseCircle;
	double MxStp;
	double MnStp;
	double aMax;
	double aMin;
	double jMax=0;
	double jMin=0;
	double vMax=0;
	double vMin=0;
	double sMinus;
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
	int B1,B2,B3,B4,K1,K2,K3,K4;
	DecimalFormat dformat;
	
	PrimativeCam(double seta, double h){
		this.seta = seta;
		this.h = h;
	}
	PrimativeCam(double fullSeta, double h, double baseCircle ){
		this.baseCircle = baseCircle;
		this.seta = fullSeta/2;
		this.fullSeta = fullSeta;
		this.h = h;
	}
	
	
	public void bk() {
		
		aMax = 0;
		p = 0.15;
		aMin = 0;
		
		dformat = new DecimalFormat("0.00");
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		//  seta limits for each beta(B)
		B1 = (int)Math.ceil(seta/8);
		B2 = (int)Math.ceil((5*seta)/32);
		B3 = (int)Math.ceil(seta/8);
		B4 = (int)Math.ceil(seta-(B1+B2+B3));
		
		
		// Array index
		K1 = B1;	 // 0 : K1 --- 0 : 10    
		K2 = K1+B2;  // K1+2 : K2 --- 12 : 16   11 for /0 ... 12 13 14 15 16 ... 5
		K3 = K2+B3;  // K2+2 : K3 --- 18 : 20   17 for /0 ... 18 19 20 .... 3
		K4 = (int)seta;  // K3+2 : K4 --- 22 : 26
		
		//while(Double.parseDouble(dformat.format(x)) != h);
		 
	}
	
	public void check_SVAJ() {
		bk();
		
		do {
		
		accelerationEquations();
		velocityEquations();
		displacementEquations();
		jerkEquations();
		
			
		x = s[(int)seta] - s[0];
		
		if(v[0] < 0 ) {
			p += 0.01;
		}
		
		
		aMax += 0.000001;
		aMin = - p * aMax;
		
		/*
		if(x > h) {
			aMax += 0.0002;
			//v[0] += 0.0001;
		}
		else if (x<h ) {
			aMin -= 0.00002;
			
		}
		/*
		if(v[0] < 0) {
			
			aMax += 0.0001;
			aMin -= 0.00001;
		}*/
		
		
		}while(Double.parseDouble(dformat.format(x)) != h);
		
	}
	
	public void accelerationEquations() {
		
		
		//	    B1   &   K1
		for(int i=0 ; i <= K1 ; i++) { //0  10
			a[i] = 0; 
		}
		//	    B2   &   K2
		for(int i=K1+1 ; i <= K2 ; i++) { // 11 15
			a[i] = aMax;
		}
		//	    B3   &   K3		
		for(int i=K2+1 ; i<=K3 ; i++) { // 16  18
			a[i] = 0;
		}
		//	    B4   &   K4	
		for(int i=K3+1 ; i<=K4 ; i++) {   // 19  23
			a[i] = aMin;
		}
		
		
		
	}
	
	public void velocityEquations() {
		
		
		v[K4] = 0;  // K4 = 23 , B4 = 5
		//end of beta3 and beginning of beta4
		v[K3] = v[K4] - (aMin*B4);  // K3 = 18 , B3 = 3
		//end of beta2 and beginning of beta3
		v[K2] = v[K3] ;  // K2 = 15 , B2 = 5
		//end of beta1 and beginning of beta2
		v[K1] = v[K2] - (aMax*B2);  // K1 = 10 , B1 = 10
		//beginning of beta1 ( the start point )
		v[0] = v[K1];  // K=0 , B=0
		
		//	    B1   &   K1
		for(int i=0 ; i < K1 ; i++) { //K = 79  39 , z(beta) = 41  0
			v[i] = v[0] ;
		}
		//	    B2   &   K2	
		for(int i=K1+1,z=1 ; i < K2 && z<B2 ; i++,z++) { // k = 38  34 , z = 4  0
			v[i] = (aMax*z) + v[K1];
		}
		//	    B3   &   K3	
		for(int i=K2+1 ; i<K3 ; i++) { // k = 33  24 , z = 9  0
			v[i] = v[K2];
		}
		//	    B4   &   K4		
		for(int i=K3+1,z=1 ; i<K4 && z<B4 ; i++,z++) {   // k = 23  19 , z = 4  0
			v[i] = (aMin*z) + v[K3] ;
		}
		
		
		
	}
	
	public void displacementEquations() {
		
		
		s[K4] = h;  // K4 = 23 , B4 = 5
		//end of beta3 and beginning of beta4
		s[K3] = s[K4] - ((aMin/2)*(B4*B4)) - (v[K3]*B4);  // K3 = 18 , B3 = 3
		//end of beta2 and beginning of beta3
		s[K2] = s[K3] - (v[K2]*B3);  // K2 = 15 , B2 = 5
		//end of beta1 and beginning of beta2
		s[K1] = s[K2] - ((aMax/2)*(B2*B2)) - (v[K1]*B2);  // K1 = 10 , B1 = 10
		//beginning of beta1 ( the start point )
		s[0] = s[K1] - (v[0]*B1);  // K=0 , B=0
		
		//    B1   &   K1
		for(int i=1,z=1 ; i<K1 && z<B1 ; i++,z++) { //K = 79  39 , z(beta) = 41  0
			s[i] = (v[0]*z) + s[0] ; 
		}
		//    B2   &   K2
		for(int i=K1+1,z=1 ; i<K2 && z<B2 ; i++,z++) { // k = 38  34 , z = 4  0
			s[i] = ((aMax/2)*(z*z)) + (v[K1]*z) + s[K1];
		}
		//    B3  &   K3
		for(int i=K2+1,z=1 ; i<K3 && z<B3 ; i++,z++) { // k = 33  24 , z = 9  0
			s[i] = (v[K2]*z) + s[K2];
		}
		//    B4   &   K4
		for(int i=K3+1,z=1 ; i<K4 && z<B4 ; i++,z++) {   // k = 23  19 , z = 4  0
			s[i] = ((aMin/2)*(z*z)) + (v[K3]*z) + s[K3] ;
		}
		
	}
	
	
	
	public void jerkEquations() {
		
		
		for(int i=0 ; i <= K1 ; i++) { //0  10
			j[i] = 0; 
		}
		for(int i=K1+1 ; i <= K2  ; i++) { // 11 15
			
			j[i] = 0;
			
		}
		for(int i=K2+1 ; i<=K3 ; i++) { // 16  18
			j[i] = 0;
		}
		for(int i=K3+1 ; i<=K4 ; i++) {   // 19  23
			
			j[i] = 0;
		}
		
	}	

	public double[] acceleration() {
		check_SVAJ();
		/*
		System.out.println("aMax : " + aMax);
		System.out.println("aMin : " + aMin);
		System.out.println("v[0] : " + v[0]);
		System.out.println("x : " + x);
		*/
		return a;
	}
	
	public double[] velocity() {
		check_SVAJ();
		
		return v;
	}
	
	public double[] displacement() {
		check_SVAJ();
		
		return s;
	}
	
	public double[] jerk() {
		check_SVAJ();
		
		return j;
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
		
		
		
		return jMax;
	}
	public double minJerk() {
		check_SVAJ();
		
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
		
		for(int i=0 ; i<(int)seta ; i++) {
			vMax = Math.max(vMax, v[i]);
		}
		
		return vMax;
	}
	public double minVelocity() {
		check_SVAJ();
		
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
