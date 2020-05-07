`timescale 1ns / 1ps

module RippleCounter(clk , sonuc);

	input clk;	
	wire[3:0] result;
	output [3:0] sonuc ;

 
	jk jk0(1 ,1, clk, result[0] );
	jk jk1(1 ,1, ~result[0] , result[1] );
	jk jk2(1 ,1, ~result[1] , result[2] );
	jk jk3(1 ,1, ~result[2] , result[3] );
 
	assign sonuc = result;
 
 

 
endmodule