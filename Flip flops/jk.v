`timescale 1ns / 1ps

module jk(J,K,clk,Q);

	input J,K,clk;
	output reg Q = 0;
	
	always@(posedge clk)
	begin
		if( J == 0 & K == 1 )
		begin
			Q= 0;
		end
		else if( J==1 & K== 0 )
		begin
			Q = 1;
		end
		else if( J==1 & K== 1)
		begin
			Q = ~Q;
		end
	end

endmodule
