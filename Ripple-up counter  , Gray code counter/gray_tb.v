`timescale 1ns / 1ps


module gray_tb;

	// Inputs
	reg clk = 1;

	// Outputs
	wire [3:0] sonuc;

	// Instantiate the Unit Under Test (UUT)
	grayCodeCounter uut (
		.clk(clk), 
		.sonuc(sonuc)
	);


	
	always #25 clk = ~clk;
      
endmodule
