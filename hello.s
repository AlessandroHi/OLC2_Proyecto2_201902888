.data
heap: .space 4096
.text
.global _start
_start:
   adr x10, heap
// Estoy en If
// Boolean: false
MOV x0, #0
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CBZ x0, L0
// Inicia bloque
// Print
// String: Hola
STR x10, [SP, #-8]!
// Pushing character 72 to heap
MOV w0, #72
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 111 to heap
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 108 to heap
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 97 to heap
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 0 to heap
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Poping value
LDR x0, [SP], #8
MOV X0, x0
BL print_string
B L1
L0:
// Estoy en If
// Boolean: false
MOV x0, #0
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CBZ x0, L2
// Inicia bloque
// Print
// String: Adios
STR x10, [SP, #-8]!
// Pushing character 65 to heap
MOV w0, #65
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 100 to heap
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 105 to heap
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 111 to heap
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 115 to heap
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 0 to heap
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Poping value
LDR x0, [SP], #8
MOV X0, x0
BL print_string
B L3
L2:
// Inicia bloque
// Print
// String: else
STR x10, [SP, #-8]!
// Pushing character 101 to heap
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 108 to heap
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 115 to heap
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 101 to heap
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 0 to heap
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Poping value
LDR x0, [SP], #8
MOV X0, x0
BL print_string
L3:
L1:
MOV x0, #0
MOV x8, #93
SVC #0

 
 //Start of Standard Library

//--------------------------------------------------------------
// print_string - Prints a null-terminated string to stdout
//
// Input:
//   x0 - The address of the null-terminated string to print
//--------------------------------------------------------------
print_string:
    // Save link register and other registers we'll use
    stp     x29, x30, [sp, #-16]!
    stp     x19, x20, [sp, #-16]!
    
    // x19 will hold the string address
    mov     x19, x0
    
print_loop:
    // Load a byte from the string
    ldrb    w20, [x19]
    
    // Check if it's the null terminator (0)
    cbz     w20, print_done
    
    // Prepare for write syscall
    mov     x0, #1              // File descriptor: 1 for stdout
    mov     x1, x19             // Address of the character to print
    mov     x2, #1              // Length: 1 byte
    mov     x8, #64             // syscall: write (64 on ARM64)
    svc     #0                  // Make the syscall
    
    // Move to the next character
    add     x19, x19, #1
    
    // Continue the loop
    b       print_loop
    
print_done:

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0

    // Restore saved registers
    ldp     x19, x20, [sp], #16
    ldp     x29, x30, [sp], #16
    ret
    // Return to the caller
    
newline: .ascii "\n"