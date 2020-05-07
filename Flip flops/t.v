`timescale 1ns / 1ps

module t(T,clk,Q);
	input T , clk;
	output reg Q = 0;
	
	always @(posedge clk)
	begin
		if(T==1)
		begin
			Q = ~Q;
		end
	end 



endmodule
