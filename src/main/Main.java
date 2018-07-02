package main;

import javax.xml.bind.DatatypeConverter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String data="02:f5:04:01:01:00:00";		String data1="AAAc";
		data=data.replaceAll(":", "");
		System.out.println(data);
		System.out.println(Utilite.ByteToHexa(DatatypeConverter.parseHexBinary(data)));	
		byte a=Utilite.HexaToByte(data)[1];
		int deci=(a & 255);
		
		Paquet p=new Paquet(DatatypeConverter.parseHexBinary(data));
		System.out.print(p);
	}

}
