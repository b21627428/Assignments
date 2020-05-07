`timescale 1ns / 1ps


module ripple_up_tb;

	// Inputs
	reg clk = 1;

	// Outputs
	wire [3:0] sonuc ;

	// Instantiate the Unit Under Test (UUT)
	RippleCounter uut (
		.clk(clk), 
		.sonuc(sonuc)
	);

	always  #25 clk = ~clk; 
      
endmodule
