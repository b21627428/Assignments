`timescale 1ns / 1ps

module d(D,clk,Q);
	input D,clk;
	output reg Q = 0;
	
	always@(posedge clk)
	begin
	
		Q = D;
	end

endmodule

module seq100_d(input x,clk,output y);
	
	wire w1,w2;
	
	d d1(x,clk,w1);
	
	d d2((w1&~x),clk,w2);
	
	assign y = (~x & ~w1 & w2) ;

endmodule
