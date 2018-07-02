package main;

import java.util.Arrays;

public class Paquet {

	byte[] data;
	int id;
	int size;
	
	
	//datainitaile c'est les donnes dans le paquet recu 
	public Paquet(byte []datainitiale) {
		
		super();
		
		short header =  (short) ((datainitiale[0] & 255)<<8 | (datainitiale[1] & 255 ))  ;
			
		this.id =  (header >> 2);
		short sizeofsize =  (short) (header & 3);
		
		switch(sizeofsize)
		{
			case 0 	: 	size = 0;break;
			case 1 	:	size = datainitiale[2] & 255;break;
			case 2	:	size = ((datainitiale[2] & 255)<<8 | datainitiale[3]& 255);break;
			default :	size = (((datainitiale[2] & 255 )<< 16 | (datainitiale[3]& 255) << 8) | datainitiale[4] & 255);	
		}
		
		this.data = new byte[size]; 
		for(int i = 0; i < size ; ++i)
			data[i] = datainitiale[i+2 + sizeofsize];
	}


	@Override
	public String toString() {
		return "Paquet [data=" + Arrays.toString(data) + ", id=" + id + ", size=" + size + "]";
	}
	
	
	
}
