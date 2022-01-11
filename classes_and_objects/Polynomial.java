package classes_and_objects;

public class Polynomial {

	int pol[];
    int l;
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    public Polynomial()
    {
	pol=new int[5];//initial polynomial array size 5
    l=5;    //length =5
    }
	 public Polynomial(int l)
    {
	pol=new int[l];//initial polynomial array 
    this.l=l; //length 
    }

    private void reconstruct(int d)
    {
	int temp[]=pol;//temp points to original poly array
    pol=new int[d*2];//pol now points to new array of double the size of degree
    for(int i=0;i<l;i++)
        pol[i]=temp[i];//copying elements of temp to pol
    l=d*2;//new length of pol
    }
    
	public void setCoefficient(int degree, int coeff){
		if(degree>=l)
            reconstruct(degree);
	pol[degree]=coeff;
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print()
    {
		String s="";
	for(int i=0;i<l;i++)
	{
		if(pol[i]!=0)
         s=s+pol[i]+"x"+i+" ";   
    }
			
        System.out.println(s);
    }
    
    public int get(int d)
    {
        if(d>=l)
            return -1;
        else
            return(pol[d]);
	}
    
    
	public Polynomial add(Polynomial p){
        int min=Math.min(p.l,this.l);
        int max=Math.max(p.l,this.l);
        Polynomial p1=new Polynomial(max);
        int temp[];
        for(int i=0;i<min;i++)
        {
            int d1=this.get(i);
            int d2=p.get(i);
            int d=d1+d2;
            p1.setCoefficient(i,d);
        }
        if(p.l!=min)
            temp=p.pol;
        else
            temp=this.pol;
        for(int i=min;i<max;i++)
        {
        int d3=temp[i];
        p1.setCoefficient(i,d3);
    	}
        return(p1);
    }
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		 int min=Math.min(p.l,this.l);
	        int max=Math.max(p.l,this.l);
	        Polynomial p1=new Polynomial(max);
	        int temp[];
	        for(int i=0;i<min;i++)
	        {
	            int d1=this.get(i);
	            int d2=p.get(i);
	            int d=d1-d2;
	            p1.setCoefficient(i,d);
	        }
	        if(p.l!=min)
	            temp=p.pol;
	        else
	            temp=this.pol;
	        for(int i=min;i<max;i++)
	        {
	        int d3=temp[i];
	        p1.setCoefficient(i,d3);
	    	}
	        return(p1);
    }
	
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
	Polynomial p1=new Polynomial(this.l+p.l);
    int temp[]=p1.pol;
    for(int i=0;i<this.l;i++)    
        for(int j=0;j<p.l;j++) 
            temp[i+j]=temp[i+j]+(this.get(i)*p.get(j));
    return(p1);
    	}
	
	}