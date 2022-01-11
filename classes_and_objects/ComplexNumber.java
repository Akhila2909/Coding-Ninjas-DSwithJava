package classes_and_objects;

public class ComplexNumber {

	private int real;
    private int imag;
    
    public ComplexNumber(int real,int imag)
    {
        this.real=real;
        this.imag=imag;
    }
    
    
    public void setReal(int real) {
    	this.real=real;
    	}
    
    
    public void setImaginary(int imag) {
    	this.imag=imag;
    	}  
    
    
    public void print()
    {
        System.out.println(real+" + "+imag+"i");
	}
    
    public void add(ComplexNumber c2)
    {
        this.real=this.real+c2.real;
        this.imag=this.imag+c2.imag;
	}
    
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2)
    {
    	ComplexNumber c=new ComplexNumber(c1.real+c2.real,c1.imag+c2.imag);
    	return c;
	}
    
    public ComplexNumber conjugate()
    {
    	
    	ComplexNumber c1=new ComplexNumber(this.real,this.imag*-1);
    	return c1;
	}
    
    
    
	public void multiply(ComplexNumber c2)
    {
        int r=this.real;
        int i=this.imag;
        this.real=r*c2.real-i*c2.imag;
        this.imag=r*c2.imag+i*c2.real;
	}
}
