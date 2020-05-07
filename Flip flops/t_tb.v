`timescale 1ns / 1ps


module t_tb;

	// Inputs
	reg T;
	reg clk;

	// Outputs
	wire Q;

	// Instantiate the Unit Under Test (UUT)
	t uut (
		.T(T), 
		.clk(clk), 
		.Q(Q)
	);
	
	initial begin
		// Initialize Inputs
	
		T = 0;
		clk = 0;
		


		// Wait 100 ns for global reset to finish
	end
	
		always #50 clk = ~clk;
		always #75 T = ~T;
        
		// Add stimulus here

	
      
endmodule

