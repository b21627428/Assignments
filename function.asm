# s0 = a ,     s1 = b  ,  s3 = result

main:

    addi $s3, $0, 0           # result = 0
    addi $s0, $0, 3           # a = 5
    addi $s1, $0, 3           # b = 3

    beq $s0, $s1, else        # a == b go to else

    jal compare               # compare works
    add $s3, $v0, $0          # result = compare(a,b)
    add $v0, $s3, $0          # return result
	j done                    # finish program


else: 

    add $s3, $s0, $s1         # result = a + b
    add $v0, $s3, $0          # return result
    j done 					  # finish program

compare:

    addi $sp, $sp, -4                          # stack pointer allocate 
    sw $ra, 0($sp)                             # return address assigned to stack pointer
    ###############
    
    
    slt $t0, $s0, $s1                          # if a<b                 

    bne $t0, $0, punish                        #if a<b go punish
    jal award                                  #else go award
    
    
    #############
    lw $ra, 0($sp)                             # return address getting from stack pointer
    jr $ra                                     # return 


punish:

    sub $v0, $s0, $s1                          # a-b
    sll $v0, $v0, 1                            # 2(a-b)
    jr $ra                                     # return

award:

    add $v0, $s0, $s1                          # a+b
    sll $v0, $v0, 1                            # 2(a+b)
    jr $ra                                     # return
    
done:

	addi $sp, $sp, 4                           # stack pointer reallocate
	
