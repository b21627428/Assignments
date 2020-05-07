`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   15:01:05 12/12/2018
// Design Name:   seq100_jk
// Module Name:   /home/ogr/b21627428/sequence_detector/seq100_tb_jk.v
// Project Name:  sequence_detector
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: seq100_jk
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module seq100_tb_jk;

	// Inputs
	reg x;
	reg clk;

	// Outputs
	wire y;

	// Instantiate the Unit Under Test (UUT)
	seq100_jk uut (
		.x(x), 
		.clk(clk), 
		.y(y)
	);
	
	reg[5:0] data;
	integer k;
	
	initial begin
		clk = 0;
		k=0;
		data = 6'b001001;
		x=0;
	end
	
	always@(posedge clk)
	begin
		x = data>>k;
		k=k+1;
	end
	
	always #25 clk = ~clk;
	initial #400 $stop;
	
      
endmodule

