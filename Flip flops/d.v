`timescale 1ns / 1ps

module d(D,clk,Q);
	
	input D , clk ;
	output reg Q = 0;
	
	always @(posedge clk)
	begin
	
		Q = D;
	
	end


endmodule