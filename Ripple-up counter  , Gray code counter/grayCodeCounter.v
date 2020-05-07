`timescale 1ns / 1ps

module grayCodeCounter(clk,sonuc);
 
	input clk;	

	wire   [3:0] result;
	output [3:0] sonuc ;

	RippleCounter r1(clk,result);
	
	not(sonuc[3],~result [3]);
	xor(sonuc[2],result[3],result[2] );
	xor(sonuc[1],result[2],result[1] );
	xor(sonuc[0],result[1],result[0] );
	
	
endmodule