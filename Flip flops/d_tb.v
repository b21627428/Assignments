`timescale 1ns / 1ps


module d_tb;

	// Inputs
	reg D;
	reg clk;

	// Outputs
	wire Q;

	// Instantiate the Unit Under Test (UUT)
	d uut (
		.D(D), 
		.clk(clk), 
		.Q(Q)
	);

	initial begin
		// Initialize Inputs
		D = 0;
		clk = 0;

		// Wait 100 ns for global reset to finish
	
	end
	
		always #25 clk = ~clk;
		always #50 D = ~D;
		
		//initial #100 $stop
        
		// Add stimulus here
      
endmodule

