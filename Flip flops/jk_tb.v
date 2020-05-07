`timescale 1ns / 1ps

module jk_tb;

	// Inputs
	reg J;
	reg K;
	reg clk;

	// Outputs
	wire Q;

	// Instantiate the Unit Under Test (UUT)
	jk uut (
		.J(J), 
		.K(K), 
		.clk(clk), 
		.Q(Q)
	);

	initial begin
		// Initialize Inputs
		J = 0;
		K = 0;
		clk = 0;
		
		// Wait 100 ns for global reset to finish
	end

		always #25  clk = ~clk;
		always #45   J = ~J;
		always #65   K = ~K;
        
		// Add stimulus here

	
      
endmodule

