import java.io.*;


public abstract class Program {

	private static BST tree = new BST();
	
	public static void work(String input ,String output) {
		
		String information ;       
		String   []tempInformationList;	
		
		FileWriter fWriter = null;               BufferedWriter writer = null;
		
		try {

			FileInputStream fStream  =    new FileInputStream(input);      // input.txt opens        
    		DataInputStream dStream =     new DataInputStream(fStream);				
    		BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
			fWriter = new FileWriter(output);    // output.txt opens
			writer =  new BufferedWriter(fWriter);
			
			while( (information = bReader.readLine() )  != null){     
    			
    			if(information.length() != 0) {   // Empty line  checking
        			
    				tempInformationList = information.split(" ");  // Each line splitting
    					
    				try { // If else part , else for errors 
        				
    					if(tempInformationList[0].equals("CreateBST") && tempInformationList.length>1 ) {
        					
        					tree.createBTS(tempInformationList[1]);
        					//System.out.println("BST created with elements:"+tree.inOrder(tree.getRoot()));
        					writer.write("BST created with elements:"+tree.inOrder(tree.getRoot()));
        				}
        				else if(tempInformationList[0].equals("FindHeight") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null ) {
        					
        					//System.out.println("Height:"+tree.findHeight(tree.getRoot()));
        					writer.write("Height:"+(tree.findHeight(tree.getRoot())-1));
        				}
        				else if(tempInformationList[0].equals("FindWidth") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null ) {
        					
        					//System.out.println("Width:"+tree.findWidth(tree.getRoot()));
        					writer.write("Width:"+tree.findWidth(tree.getRoot()));
        				}
        				else if(tempInformationList[0].equals("Preorder") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null ) {
        					
        					//System.out.println("Preorder:"+tree.preOrder(tree.getRoot()));
        					writer.write("Preorder:"+tree.preOrder(tree.getRoot()));
        				}
        				else if(tempInformationList[0].equals("LeavesAsc") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null ) {
        					
        					//System.out.println("LeavesAsc:"+tree.leavesAsc(tree.getRoot()));
        					writer.write("LeavesAsc:"+tree.leavesAsc(tree.getRoot()));
        				}
        				else if(tempInformationList[0].equals("DelRoot") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null ) {
        					
        						//System.out.println("Root Deleted:"+tree.getRoot().getData());
        						writer.write("Root Deleted:"+tree.getRoot().getData());
        						tree.setRoot( tree.delete( tree.getRoot() ));
        				}
        				else if(tempInformationList[0].equals("DelRootLc") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null &&
        						tree.getRoot().getLeft() != null ) {
        					
        						//System.out.println("Left Child of Root Deleted:"+tree.getRoot().getLeft().getData());
        						writer.write("Left Child of Root Deleted:"+tree.getRoot().getLeft().getData());
        						tree.getRoot().setLeft( tree.delete( tree.getRoot().getLeft() ));  
        				}
        				else if(tempInformationList[0].equals("DelRootRc") && 
        						tempInformationList.length == 1 &&
        						tree.getRoot() != null &&
        						tree.getRoot().getRight() != null ) {

        						//System.out.println("Right Child of Root Deleted:"+tree.getRoot().getRight().getData());
        						writer.write("Right Child of Root Deleted:"+tree.getRoot().getRight().getData());
        						tree.getRoot().setRight( tree.delete( tree.getRoot().getRight() ));
                        }
        				else if(tempInformationList[0].equals("CreateBSTH") && tempInformationList.length == 2) { 
        					
        						int temp = Integer.parseInt( tempInformationList[1] ); // error
            					if(temp < 1) throw new Exception();                   // error
        						
        						tree.createFullBST(temp);
        						//System.out.print("A full BST created with elements:");
        						writer.write("A full BST created with elements:");
        						for(int i=1 ; i< Math.pow(2, temp+1) ; i++) {
        							//System.out.print(i+" ");
        							writer.write(i+" ");
        						}
        						//System.out.println();		
            		    }
        				else throw new Exception();
        				
    				}catch(Exception e) { writer.write("error");  }
    				writer.newLine();
    			}	
    		}
			writer.close();
			bReader.close();
    	}catch(Exception e){  System.out.println("The file was not found ");  }
	}
}
