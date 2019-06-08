.data

A: .word 6, 2, 8, 4, 10
B: .word 1, 7, 3, 9, 5

.text

main:

    la $t1, A
    la $t2, B

    addi $s0, $0, 0                    # s0 = i
    addi $t0, $0, 5                    # t0 = 5

while: 

    beq $s0, $t0, done

    lw $t3, 0($t1)            # A[0]
    lw $t4, 0($t2)            # B[0]

    slt $t5, $t3, $t4        #if A[0]<B[0] continue
    bne $t5, $0, continue

    jal swap                 #else swap
    jal continue

continue:

    addi $s0, $s0, 1          # i++

    addi $t1, $t1, 4          # array base adress++ for A
    addi $t2, $t2, 4		  # array base adress++ for B	

    j while

swap:

    sw $t3, 0($t2)            # swap part
    sw $t4, 0($t1)
    jr $ra
    
done: