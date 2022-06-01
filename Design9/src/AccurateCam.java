import java.text.DecimalFormat;

public class AccurateCam {
	
	double seta;
	double fullSeta;
	double h;
	double baseCircle;
	double MxStp;
	double MnStp;
	double jMax ; 
	double jMin;
	double vMax;
	double vMid;
	double sMinus;
	double y;
	double x;
	double p;
	double s[];
	double sa[];
	double sn[];
	double v[];
	double a[];
	double j[];
	double fs[];
	double fv[];
	double fa[];
	double fj[];
	double XCamProf[];
	double YCamProf[];
	int B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,K1,K2,K3,K4,K5,K6,K7,K8,K9,K10;
	DecimalFormat dformat;
	int i;
	
	AccurateCam(double seta, double h){
		this.seta = seta;
		this.h = h;
	}
	AccurateCam(double fullSeta, double h, double baseCircle ){
		this.baseCircle = baseCircle;
		this.seta = fullSeta/2;
		this.fullSeta = fullSeta;
		this.h = h;
	}
	
	
	public void bk() {
		
		jMax = 0;
		p = 0.15;
		jMin = 0;
		i = 0;
		//sMinus=0;
		dformat = new DecimalFormat("0.00");
		
		s = new double[(int)seta+1];
		v = new double[(int)seta+1];
		a = new double[(int)seta+1];
		j = new double[(int)seta+1];
		
		//  seta limits for each beta(B)
		B1 = (int)Math.ceil(seta/8);
		B2 = (int)Math.ceil(seta/32);
		B3 = (int)Math.ceil(seta/32);
		B4 = (int)Math.ceil(seta/32);
		B5 = (int)Math.ceil(seta/32);
		B6 = (int)Math.ceil(seta/32);
		B7 = (int)Math.ceil(seta/8);
		B8 = (int)Math.ceil(seta/32);
		B9 = (int)Math.ceil(seta/32);
		B10 = (int)(seta-(B1+B2+B3+B4+B5+B6+B7+B8+B9));
		
		
		// Array index
		K1 = B1;	    
		K2 = K1+B2; 
		K3 = K2+B3;  
		K4 = K3+B4;  
		K5 = K4+B5;
		K6 = K5+B6;
		K7 = K6+B7;
		K8 = K7+B8;
		K9 = K8+B9;
		K10 = (int)seta;  
		  
		
		  /*                             //seta=80
		System.out.println("B1 "+ B1);  
		System.out.println("B2 "+ B2);  
		System.out.println("B3 "+ B3);  
		System.out.println("B4 "+ B4);  
		System.out.println("B5 "+ B5);  
		System.out.println("B6 "+ B6);  
		System.out.println("B7 "+ B7);
		System.out.println("B8 "+ B8);
		System.out.println("B9 "+ B9);
		System.out.println("B10 "+ B10);
		
		System.out.println("K1 "+ K1);  
		System.out.println("K2 "+ K2);  
		System.out.println("K3 "+ K3);  
		System.out.println("K4 "+ K4);  
		System.out.println("K5 "+ K5);  
		System.out.println("K6 "+ K6);  
		System.out.println("K7 "+ K7);
		System.out.println("K8 "+ K8);
		System.out.println("K9 "+ K9);
		System.out.println("K10 "+ K10);
		*/
	}

	public void check_SVAJ() {
		bk();
		
		do {
			
			MxStp = jMax/B2;
			MnStp = jMin/B8;
			
		jerkEquations();	
		accelerationEquations();
		velocityEquations();
		displacementEquations();
		
		if(v[0] < 0 ) {
			//jMax = 0.00001;
			p += 0.01;
		}
		
		jMax += 0.000001;
		jMin = - p * jMax;
		
		
		for(int i=1 ; i<(int)seta  ; i++) {
			sMinus = Math.min(s[i] , sMinus);
		}
		
		x = s[K10] - s[0];
		/*
		if(x>h ) {
			jMax += 0.0001;
		}
		else if (x<h ) {
			
			jMin -= 0.00001;
		}
		*/
		
		
		}while(Double.parseDouble(dformat.format(x)) != h || v[0]<0);
	
		
	}


	public void jerkEquations() {
		
		
		// K1 , B1
		for(int i=0 ; i<=K1 ; i++) {
			j[i] = 0;
		}
		// K2 , B2
		for(int i=K1+1,z=1 ; i<=K2 && z<=B2 ; i++,z++) {
			j[i] = MxStp * z ;
		}
		// K3 , B3
		for(int i=K2+1,z=1 ; i<=K3 && z<=B3 ; i++,z++) {
			j[i] = ( jMax - (MxStp*z) );
		}
		// K4 , B4
		for(int i=K3+1 ; i<=K4 ; i++) {
			j[i] = 0;
		}
		// K5 , B5
		for(int i=K4+1,z=1 ; i<=K5 && z<=B5 ; i++,z++) {
			j[i] = -(MxStp*z);
		}
		// K6 , B6
		for(int i=K5+1,z=1 ; i<=K6 && z<=B6 ; i++,z++) {
			j[i] = ( -jMax + (MxStp*z) );
		}
		// K7 , B7
		for(int i=K6+1 ; i<=K7 ; i++) {
			j[i] = 0;
		}
		// K8 , B8
		for(int i=K7+1,z=1 ; i<=K8 && z<=B8 ; i++,z++) {
			j[i] = MnStp * z;
		}
		// K9 , B9
		for(int i=K8+1,z=1 ; i<=K9 && z<=B9 ; i++,z++) {
			j[i] = ( jMin - (MnStp*z) );
		}
		// K10, B10
		for(int i=K9+1 ; i<=K10 ; i++) {
			j[i] = 0;
		}
		
		
	}
	
	public void accelerationEquations() {
		
		
		// K1 , B1
		for(int i=0 ; i<=K1 ; i++) {
			a[i] = 0;
		}
		// K2 , B2
		for(int i=K1+1,z=1 ; i<=K2 && z<=B2 ; i++,z++) {
			a[i] = (MxStp/2)*(z*z) ;
		}
		// K3 , B3
		for(int i=K2+1,z=1 ; i<=K3 && z<=B3 ; i++,z++) {
			a[i] = ( (jMax*z) - ((MxStp/2)*(z*z)) + a[K2] );
		}
		// K4 , B4
		for(int i=K3+1 ; i<=K4 ; i++) {
			a[i] = a[K3];
		}
		// K5 , B5
		for(int i=K4+1,z=1 ; i<=K5 && z<=B5 ; i++,z++) {
			a[i] = -((MxStp/2)*(z*z)) + a[K4];
		}
		// K6 , B6
		for(int i=K5+1,z=1 ; i<=K6 && z<=B6 ; i++,z++) {
			a[i] = ( -(jMax*z) + ((MxStp/2)*(z*z)) + a[K5] );
		}
		// K7 , B7
		for(int i=K6+1 ; i<=K7 ; i++) {
			a[i] = a[K6];
		}
		// K8 , B8
		for(int i=K7+1,z=1 ; i<=K8 && z<=B8 ; i++,z++) {
			a[i] = ((MnStp/2)*(z*z)) + a[K7];
		}
		// K9 , B9
		for(int i=K8+1,z=1 ; i<=K9 && z<=B9 ; i++,z++) {
			a[i] = (jMin*z) - ((MnStp/2)*(z*z)) + a[K8];
		}
		// K10, B10
		for(int i=K9+1 ; i<=K10 ; i++) {
			a[i] = a[K9];
		}
		
		
	}
	
	public void velocityEquations() {
		
		
		v[K10] = 0;
		v[K9]  = v[K10] - (a[K9]*B10);
		v[K8]  = v[K9] - ((jMin/2)*(B9*B9)) + ((MnStp/6)*(B9*B9*B9)) - (a[K8]*B9);
		v[K7]  = v[K8] - ((MnStp/6)*(B8*B8*B8)) - (a[K7]*B8);
		v[K6]  = v[K7] - (a[K6]*B7);
		v[K5]  = v[K6] + ((jMax/2)*(B6*B6)) - ((MxStp/6)*(B6*B6*B6)) - (a[K5]*B6);
		v[K4]  = v[K5] + ((MxStp/6)*(B5*B5*B5)) - (a[K4]*B5) ;
		v[K3]  = v[K4] - (a[K3]*B4);
		v[K2]  = v[K3] - ((jMax/2)*(B3*B3)) + ((MxStp/6)*(B3*B3*B3)) - (a[K2]*B3);
		v[K1]  = v[K2] - ((MxStp/6)*(B2*B2*B2)) ;
		v[0]   = v[K1];
		
		
		// K1 , B1
		for(int i=1 ; i<K1 ; i++) {
			v[i] = v[0];
		}
		// K2 , B2
		for(int i=K1+1,z=1 ; i<K2 && z<B2 ; i++,z++) {
			v[i] = ((MxStp/6)*(z*z*z)) + v[K1];
		}
		// K3 , B3
		for(int i=K2+1,z=1 ; i<K3 && z<B3 ; i++,z++) {
			v[i] = ((jMax/2)*(z*z)) - ((MxStp/6)*(z*z*z)) + (a[K2]*z) + v[K2];
		}
		// K4 , B4
		for(int i=K3+1,z=1 ; i<K4 && z<B4 ; i++,z++) {
			v[i] = (a[K3]*z) + v[K3];
		}
		// K5 , B5
		for(int i=K4+1,z=1 ; i<K5 && z<B5 ; i++,z++) {
			v[i] = -((MxStp/6)*(z*z*z)) + (a[K4]*z) + v[K4];
		}
		// K6 , B6
		for(int i=K5+1,z=1 ; i<K6 && z<B6 ; i++,z++) {
			v[i] = -((jMax/2)*(z*z)) + ((MxStp/6)*(z*z*z)) + (a[K5]*z) + v[K5];
		}
		// K7 , B7
		for(int i=K6+1,z=1 ; i<K7 && z<B7 ; i++,z++) {
			v[i] = (a[K6]*z) + v[K6];
		}
		// K8 , B8
		for(int i=K7+1,z=1 ; i<K8 && z<B8 ; i++,z++) {
			v[i] = ((MnStp/6)*(z*z*z)) + (a[K7]*z) + v[K7];
		}
		// K9 , B9
		for(int i=K8+1,z=1 ; i<K9 && z<B9 ; i++,z++) {
			v[i] = ((jMin/2)*(z*z)) - ((MnStp/6)*(z*z*z)) + (a[K8]*z) + v[K8];
		}
		// K10, B10
		for(int i=K9+1,z=1 ; i<K10 && z<B10 ; i++,z++) {
			v[i] = (a[K9]*z) + v[K9];
		}
		
		
	}
	
	public void displacementEquations() {
		

		 
		s[K10] = h;
		s[K9]  = s[K10] - ((a[K9]/2)*(B10*B10)) - (v[K9]*B10) ;
		s[K8]  = s[K9] - ((jMin/6)*(B9*B9*B9)) + ((MnStp/24)*(B9*B9*B9*B9)) - ((a[K8]/2)*(B9*B9)) - (v[K8]*B9) ;
		s[K7]  = s[K8] - ((MnStp/24)*(B8*B8*B8*B8)) - ((a[K7]/2)*(B8*B8)) - (v[K7]*B8) ;
		s[K6]  = s[K7] - ((a[K6]/2)*(B7*B7)) - (v[K6]*B7) ;
		s[K5]  = s[K6] + ((jMax/6)*(B6*B6*B6)) - ((MxStp/24)*(B6*B6*B6*B6)) - ((a[K5]/2)*(B6*B6)) - (v[K5]*B6) ;
		s[K4]  = s[K5] + ((MxStp/24)*(B5*B5*B5*B5)) - ((a[K4]/2)*(B5*B5)) - (v[K4]*B5) ;
		s[K3]  = s[K4] - ((a[K3]/2)*(B4*B4)) - (v[K3]*B4) ;
		s[K2]  = s[K3] - ((jMax/6)*(B3*B3*B3)) + ((MxStp/24)*(B3*B3*B3*B3)) - ((a[K2]/2)*(B3*B3)) - (v[K2]*B3) ;
		s[K1]  = s[K2] - ((MxStp/24)*(B2*B2*B2*B2)) - (v[K1]*B2)  ;
		//s[0]   = 0;
		s[0]   = s[K1] - (v[0]*B1);
		
		
		// K1 , B1
		for(int i=1,z=1 ; i<K1 && z<B1 ; i++,z++) {
			//s[i] = v[0]*z;
			s[i] = (v[K1]*z) + s[0] ;
		}
		// K2 , B2
		for(int i=K1+1,z=1 ; i<K2 && z<B2 ; i++,z++) {
			s[i] = ((MxStp/24)*(z*z*z*z)) + (v[K1]*z) + s[K1];
		}
		// K3 , B3
		for(int i=K2+1,z=1 ; i<K3 && z<B3 ; i++,z++) {
			s[i] = ((jMax/6)*(z*z*z)) - ((MxStp/24)*(z*z*z*z)) + ((a[K2]/2)*(z*z)) + (v[K2]*z) + s[K2];
		}
		// K4 , B4
		for(int i=K3+1,z=1 ; i<K4 && z<B4 ; i++,z++) {
			s[i] = ((a[K3]/2)*(z*z)) + (v[K3]*z) + s[K3];
		}
		// K5 , B5
		for(int i=K4+1,z=1 ; i<K5 && z<B5 ; i++,z++) {
			s[i] = -((MxStp/24)*(z*z*z*z)) + ((a[K4]/2)*(z*z)) + (v[K4]*z) + s[K4];
		}
		// K6 , B6
		for(int i=K5+1,z=1 ; i<K6 && z<B6 ; i++,z++) {
			s[i] = -((jMax/6)*(z*z*z)) + ((MxStp/24)*(z*z*z*z)) + ((a[K5]/2)*(z*z)) + (v[K5]*z) + s[K5];
		}
		// K7 , B7
		for(int i=K6+1,z=1 ; i<K7 && z<B7 ; i++,z++) {
			s[i] = ((a[K6]/2)*(z*z)) + (v[K6]*z) + s[K6];
		}
		// K8 , B8
		for(int i=K7+1,z=1 ; i<K8 && z<B8 ; i++,z++) {
			s[i] = ((MnStp/24)*(z*z*z*z)) + ((a[K7]/2)*(z*z)) + (v[K7]*z) + s[K7];
		}
		// K9 , B9
		for(int i=K8+1,z=1 ; i<K9 && z<B9 ; i++,z++) {
			s[i] = ((jMin/6)*(z*z*z)) - ((MnStp/24)*(z*z*z*z)) + ((a[K8]/2)*(z*z)) + (v[K8]*z) + s[K8];
		}
		// K10, B10
		for(int i=K9+1,z=1 ; i<K10 && z<B10 ; i++,z++) {
			s[i] = ((a[K9]/2)*(z*z)) + (v[K9]*z) + s[K9];
		}
		
		
	}
	

	public double[] jerk() {
		check_SVAJ();
		/*System.out.println("jMax : " + jMax);
		System.out.println("jMin : " + jMin);
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
		System.out.println("sMinus : " + sMinus);
		
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
		
		
		return jMax;
	}
	public double minJerk() {
		check_SVAJ();
		
		return jMin;
		}
	public double maxAcceleration() {
		check_SVAJ();
		double aMax = 0;
		
		for(int i=0 ; i<(int)seta ; i++) {
			aMax = Math.max(aMax, a[i]);
		}
		
		return aMax;
	}
	public double minAcceleration() {
		check_SVAJ();
		double aMin = 0;
		
		for(int i=0 ; i<(int)seta ; i++) {
			aMin = Math.min(aMin, a[i]);
		}
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
