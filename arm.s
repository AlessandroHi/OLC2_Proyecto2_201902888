.data
heap: .space 4096

.text
.global _start
_start:
   adr x10, heap
// Declaración de función
// Función: sumar
// Declaración de función
// Función: obtenerNumero
// Declaración de función
// Función: factorial
// Declaración de función
// Función: ackermann
// Declarar variable: sumado
// Llamada a función
MOV x0, #16
SUB sp, sp, x0
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Integer: 2
MOV x0, #2
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
MOV x0, #32
ADD sp, sp, x0
MOV x0, #8
SUB x0, sp, x0
ADR x1, L23
STR x1, [SP, #-8]!
STR x29, [SP, #-8]!
ADD x29, x0, xzr
MOV x0, #24
SUB sp, sp, x0
// Llamando a función: sumar
BL sumar
// Fin de función: sumar
L23:
MOV x4, #32
SUB x4, x29, x4
LDR x4, [x4, #0]
MOV x1, #8
SUB x1, sp, x1
LDR x29, [x1, #0]
MOV x0, #40
ADD sp, sp, x0
STR x4, [SP, #-8]!
// Pushing object of type Int to stack
// Fin de llamada a función
// Print
// Identifier: sumado
MOV x0, #0
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV X0, x0
BL print_integer
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Declarar variable: numero
// Llamada a strconv.Atoi
// String: 123
STR x10, [SP, #-8]!
// Pushing character 49 to heap
MOV w0, #49
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 50 to heap
MOV w0, #50
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 51 to heap
MOV w0, #51
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 0 to heap
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing object of type String to stack
// Popping object of type String from stack
// Popping object of type String from stack
LDR x0, [SP], #8
// Convertir cadena a entero usando atoi
BL atoi
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Print
// String: Número:
STR x10, [SP, #-8]!
// Pushing character 78 to heap
MOV w0, #78
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 250 to heap
MOV w0, #250
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 109 to heap
MOV w0, #109
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 101 to heap
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 114 to heap
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 111 to heap
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 58 to heap
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 0 to heap
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing object of type String to stack
// Popping object of type String from stack
// Popping object of type String from stack
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Imprimir espacio
MOV x0, #32
MOV x1, #1
MOV x2, #1
MOV w8, #64
SVC #0
// Identifier: numero
MOV x0, #0
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV X0, x0
BL print_integer
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Declarar variable: numero2
// Llamada a strconv.ParseFloat
// String: 123.45
STR x10, [SP, #-8]!
// Pushing character 49 to heap
MOV w0, #49
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 50 to heap
MOV w0, #50
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 51 to heap
MOV w0, #51
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 46 to heap
MOV w0, #46
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 52 to heap
MOV w0, #52
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 53 to heap
MOV w0, #53
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing character 0 to heap
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Pushing object of type String to stack
// Popping object of type String from stack
// Popping object of type String from stack
LDR x0, [SP], #8
// Convertir cadena a flotante usando parse_float
BL parse_float
STR d0, [SP, #-8]!
// Pushing object of type Float to stack
// Llamada a función
// Popping object of type Float from stack
// Popping object of type Float from stack
LDR x0, [SP], #8

   // Finalizar programa
   mov x0, #0
   mov x8, #93
   svc #0

// Funciones definidas
// Pushing object of type Int to stack
// Pushing object of type Int to stack
// Inicio de función: sumar
sumar:
// Estoy en return
// Estoy en AddSub
// Evaluando expresión izquierda
// Identifier: a
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Evaluando expresión derecha
// Identifier: b
MOV x0, #3
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
ADD x0, x1, x0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #32
SUB x1, x29, x1
STR x0, [x1, #0]
B L0
// End of return statement
L0:
ADD x0, x29, xzr
LDR x30, [x0, #0]
BR x30
// Fin de función: sumar
// Popping object of type Int from stack
// Popping object of type Int from stack
// Inicio de función: obtenerNumero
obtenerNumero:
// Estoy en return
// Integer: 42
MOV x0, #42
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #16
SUB x1, x29, x1
STR x0, [x1, #0]
B L1
// End of return statement
L1:
ADD x0, x29, xzr
LDR x30, [x0, #0]
BR x30
// Fin de función: obtenerNumero
// Pushing object of type Int to stack
// Inicio de función: factorial
factorial:
// Estoy en If
// Estoy en Relacional
// Identifier: n
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
CMP x0, x1
BLE L3
MOV x0, #0
STR x0, [SP, #-8]!
B L4
L3:
MOV x0, #1
STR x0, [SP, #-8]!
L4:
// Pushing object of type Bool to stack
LDR x0, [SP], #8
CBZ x0, L5
// Inicia bloque
// Estoy en return
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #24
SUB x1, x29, x1
STR x0, [x1, #0]
B L2
// End of return statement
L5:
// Estoy en return
// Estoy MulDivMod
// izquierda: 
// Identifier: n
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// derecha: 
// Llamada a función
MOV x0, #16
SUB sp, sp, x0
// Estoy en AddSub
// Evaluando expresión izquierda
// Identifier: n
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Evaluando expresión derecha
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
SUB x0, x1, x0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
MOV x0, #24
ADD sp, sp, x0
MOV x0, #8
SUB x0, sp, x0
ADR x1, L6
STR x1, [SP, #-8]!
STR x29, [SP, #-8]!
ADD x29, x0, xzr
MOV x0, #16
SUB sp, sp, x0
// Llamando a función: factorial
BL factorial
// Fin de función: factorial
L6:
MOV x4, #24
SUB x4, x29, x4
LDR x4, [x4, #0]
MOV x1, #8
SUB x1, sp, x1
LDR x29, [x1, #0]
MOV x0, #32
ADD sp, sp, x0
STR x4, [SP, #-8]!
// Pushing object of type Int to stack
// Fin de llamada a función
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MUL x0, x0, x1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #24
SUB x1, x29, x1
STR x0, [x1, #0]
B L2
// End of return statement
L2:
ADD x0, x29, xzr
LDR x30, [x0, #0]
BR x30
// Fin de función: factorial
// Popping object of type Int from stack
// Pushing object of type Int to stack
// Pushing object of type Int to stack
// Inicio de función: ackermann
ackermann:
// Estoy en If
// Identifier: m
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Integer: 0
MOV x0, #0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
CMP x0, x1
BEQ L8
MOV x0, #0
STR x0, [SP, #-8]!
B L9
L8:
MOV x0, #1
STR x0, [SP, #-8]!
L9:
// Pushing object of type Bool to stack
LDR x0, [SP], #8
CBZ x0, L10
// Inicia bloque
// Estoy en return
// Estoy en AddSub
// Evaluando expresión izquierda
// Identifier: n
MOV x0, #3
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Evaluando expresión derecha
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
ADD x0, x1, x0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #32
SUB x1, x29, x1
STR x0, [x1, #0]
B L7
// End of return statement
B L11
L10:
// Estoy en If
// Estoy en And
// Estoy en Relacional
// Identifier: m
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Integer: 0
MOV x0, #0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
CMP x0, x1
BGT L12
MOV x0, #0
STR x0, [SP, #-8]!
B L13
L12:
MOV x0, #1
STR x0, [SP, #-8]!
L13:
// Pushing object of type Bool to stack
// Popping object of type Bool from stack
// Popping object of type Bool from stack
LDR x0, [SP], #8
CMP x0, #0
BEQ L14
// Identifier: n
MOV x0, #3
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Integer: 0
MOV x0, #0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
CMP x0, x1
BEQ L16
MOV x0, #0
STR x0, [SP, #-8]!
B L17
L16:
MOV x0, #1
STR x0, [SP, #-8]!
L17:
// Pushing object of type Bool to stack
// Popping object of type Bool from stack
// Popping object of type Bool from stack
LDR x0, [SP], #8
CMP x0, #0
BEQ L14
MOV x0, #1
B L15
L14:
MOV x0, #0
L15:
STR x0, [SP, #-8]!
// Pushing object of type Bool to stack
LDR x0, [SP], #8
CBZ x0, L18
// Inicia bloque
// Estoy en return
// Llamada a función
MOV x0, #16
SUB sp, sp, x0
// Estoy en AddSub
// Evaluando expresión izquierda
// Identifier: m
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Evaluando expresión derecha
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
SUB x0, x1, x0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
MOV x0, #32
ADD sp, sp, x0
MOV x0, #8
SUB x0, sp, x0
ADR x1, L20
STR x1, [SP, #-8]!
STR x29, [SP, #-8]!
ADD x29, x0, xzr
MOV x0, #24
SUB sp, sp, x0
// Llamando a función: ackermann
BL ackermann
// Fin de función: ackermann
L20:
MOV x4, #32
SUB x4, x29, x4
LDR x4, [x4, #0]
MOV x1, #8
SUB x1, sp, x1
LDR x29, [x1, #0]
MOV x0, #40
ADD sp, sp, x0
STR x4, [SP, #-8]!
// Pushing object of type Int to stack
// Fin de llamada a función
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #32
SUB x1, x29, x1
STR x0, [x1, #0]
B L7
// End of return statement
// Remover 8 bytes del stack
MOV x0, #8
ADD sp, sp, x0
// Remover 8 bytes del stack
B L19
L18:
// Inicia bloque
// Estoy en return
// Llamada a función
MOV x0, #16
SUB sp, sp, x0
// Estoy en AddSub
// Evaluando expresión izquierda
// Identifier: m
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Evaluando expresión derecha
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
SUB x0, x1, x0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Llamada a función
MOV x0, #16
SUB sp, sp, x0
// Identifier: m
MOV x0, #2
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Estoy en AddSub
// Evaluando expresión izquierda
// Identifier: n
MOV x0, #3
SUB x0, x29, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Evaluando expresión derecha
// Integer: 1
MOV x0, #1
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x1, [SP], #8
SUB x0, x1, x0
STR x0, [SP, #-8]!
// Pushing object of type Int to stack
MOV x0, #32
ADD sp, sp, x0
MOV x0, #8
SUB x0, sp, x0
ADR x1, L22
STR x1, [SP, #-8]!
STR x29, [SP, #-8]!
ADD x29, x0, xzr
MOV x0, #24
SUB sp, sp, x0
// Llamando a función: ackermann
BL ackermann
// Fin de función: ackermann
L22:
MOV x4, #32
SUB x4, x29, x4
LDR x4, [x4, #0]
MOV x1, #8
SUB x1, sp, x1
LDR x29, [x1, #0]
MOV x0, #40
ADD sp, sp, x0
STR x4, [SP, #-8]!
// Pushing object of type Int to stack
// Fin de llamada a función
MOV x0, #32
ADD sp, sp, x0
MOV x0, #8
SUB x0, sp, x0
ADR x1, L21
STR x1, [SP, #-8]!
STR x29, [SP, #-8]!
ADD x29, x0, xzr
MOV x0, #24
SUB sp, sp, x0
// Llamando a función: ackermann
BL ackermann
// Fin de función: ackermann
L21:
MOV x4, #32
SUB x4, x29, x4
LDR x4, [x4, #0]
MOV x1, #8
SUB x1, sp, x1
LDR x29, [x1, #0]
MOV x0, #40
ADD sp, sp, x0
STR x4, [SP, #-8]!
// Pushing object of type Int to stack
// Fin de llamada a función
// Popping object of type Int from stack
// Popping object of type Int from stack
LDR x0, [SP], #8
MOV x1, #32
SUB x1, x29, x1
STR x0, [x1, #0]
B L7
// End of return statement
L19:
L11:
L7:
ADD x0, x29, xzr
LDR x30, [x0, #0]
BR x30
// Fin de función: ackermann
// Popping object of type Int from stack
// Popping object of type Int from stack

// Biblioteca estándar

//--------------------------------------------------------------
// print_integer - Prints a signed integer to stdout
//
// Input:
//   x0 - The integer value to print
//--------------------------------------------------------------
print_integer:
    // Save registers
    stp x29, x30, [sp, #-16]!  // Save frame pointer and link register
    stp x19, x20, [sp, #-16]!  // Save callee-saved registers
    stp x21, x22, [sp, #-16]!
    stp x23, x24, [sp, #-16]!
    stp x25, x26, [sp, #-16]!
    stp x27, x28, [sp, #-16]!
    
    // Check if number is negative
    mov x19, x0                // Save original number
    cmp x19, #0                // Compare with zero
    bge positive_number        // Branch if greater or equal to zero
    
    // Handle negative number
    mov x0, #1                 // fd = 1 (stdout)
    adr x1, minus_sign         // Address of minus sign
    mov x2, #1                 // Length = 1
    mov w8, #64                // Syscall write
    svc #0
    
    neg x19, x19               // Make number positive
    
positive_number:
    // Prepare buffer for converting result to ASCII
    sub sp, sp, #32            // Reserve space on stack
    mov x22, sp                // x22 points to buffer
    
    // Initialize digit counter
    mov x23, #0                // Digit counter
    
    // Handle special case for zero
    cmp x19, #0
    bne convert_loop
    
    // If number is zero, just write '0'
    mov w24, #48               // ASCII '0'
    strb w24, [x22, x23]       // Store in buffer
    add x23, x23, #1           // Increment counter
    b print_result             // Skip conversion loop
    
convert_loop:
    // Divide the number by 10
    mov x24, #10
    udiv x25, x19, x24         // x25 = x19 / 10 (quotient)
    msub x26, x25, x24, x19    // x26 = x19 - (x25 * 10) (remainder)
    
    // Convert remainder to ASCII and store in buffer
    add x26, x26, #48          // Convert to ASCII ('0' = 48)
    strb w26, [x22, x23]       // Store digit in buffer
    add x23, x23, #1           // Increment digit counter
    
    // Prepare for next iteration
    mov x19, x25               // Quotient becomes the new number
    cbnz x19, convert_loop     // If number is not zero, continue
    
    // Reverse the buffer since digits are in reverse order
    mov x27, #0                // Start index
reverse_loop:
    sub x28, x23, x27          // x28 = length - current index
    sub x28, x28, #1           // x28 = length - current index - 1
    
    cmp x27, x28               // Compare indices
    bge print_result           // If crossed, finish reversing
    
    // Swap characters
    ldrb w24, [x22, x27]       // Load character from start
    ldrb w25, [x22, x28]       // Load character from end
    strb w25, [x22, x27]       // Store end character at start
    strb w24, [x22, x28]       // Store start character at end
    
    add x27, x27, #1           // Increment start index
    b reverse_loop             // Continue reversing
    
print_result:
    // Print the result
    mov x0, #1                 // fd = 1 (stdout)
    mov x1, x22                // Buffer address
    mov x2, x23                // Buffer length
    mov w8, #64                // Syscall write
    svc #0

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0
    
    // Clean up and restore registers
    add sp, sp, #32            // Free buffer space
    ldp x27, x28, [sp], #16    // Restore callee-saved registers
    ldp x25, x26, [sp], #16
    ldp x23, x24, [sp], #16
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16    // Restore frame pointer and link register
    ret                        // Return to caller
    

//--------------------------------------------------------------
// atoi - Converts a null-terminated string to an integer
//
// Input:
//   x0 - Address of the null-terminated string
// Output:
//   x0 - The integer value
//--------------------------------------------------------------
atoi:
    stp x29, x30, [sp, #-16]!
    stp x19, x20, [sp, #-16]!
    stp x21, x22, [sp, #-16]!

    mov x19, x0        // x19 = puntero a la cadena
    mov x20, #0        // x20 = resultado acumulado
    mov x21, #0        // x21 = signo (0 = positivo, 1 = negativo)
    mov x1, #0         // x1 = sin error por defecto

    // Leer primer caracter
    ldrb w0, [x19]
    cmp w0, #'0'
    b.lt .check_minus
    b .parse_digits

.check_minus:
    cmp w0, #'-'
    b.ne .check_plus
    mov x21, #1        // es negativo
    add x19, x19, #1   // avanzar al siguiente caracter
    b .parse_digits

.check_plus:
    cmp w0, #'+'       // opcional
    b.ne .parse_digits
    add x19, x19, #1

.parse_digits:
    ldrb w0, [x19]
    cbz w0, .done      // fin de cadena

    cmp w0, #'.'       // detectar decimal
    beq .error

    cmp w0, #'0'
    blt .error
    cmp w0, #'9'
    bgt .error

    // convertir ASCII a número
    sub w0, w0, #'0'

    // multiplicar acumulador por 10
    mov x22, #10
    mul x20, x20, x22

    // sumar dígito (extensión de 32 a 64 bits)
    add x20, x20, w0, uxtw

    // avanzar al siguiente caracter
    add x19, x19, #1
    b .parse_digits

.done:
    cmp x21, #0
    beq .return
    neg x20, x20

.return:
    mov x0, x20        // devolver resultado en x0
    b .cleanup

.error:
    mov x1, #1         // error: valor inválido
    mov x0, #0         // resultado = 0

.cleanup:
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret
    

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
    

//--------------------------------------------------------------
// parse_float - Converts a null-terminated string to a float
//
// Input:
//   x0 - Address of the null-terminated string
// Output:
//   d0 - The float value
//--------------------------------------------------------------
// parse_float
// Entrada: x0 = dirección de cadena null-terminada
// Salida:  d0 = float64 resultante
//          x1 = 0 si éxito, 1 si error

parse_float:
    // Guardar registros
    stp x29, x30, [sp, #-16]!
    stp x19, x20, [sp, #-16]!
    stp x21, x22, [sp, #-16]!

    mov x19, x0        // x19 = puntero a cadena
    mov x20, #0        // parte entera
    mov x21, #0        // signo (0 = positivo)
    mov x1, #0         // sin error

    ldr x2, =zero_double
    ldr d0, [x2]       // d0 = 0.0

    ldr x2, =one_double
    ldr d1, [x2]       // d1 = 1.0 (divisor actual)

    // Revisar si hay signo '-'
    ldrb w0, [x19]
    cmp w0, #'-'
    b.ne .check_plus2
    mov x21, #1
    add x19, x19, #1
    b .parse_digits2

.check_plus2:
    cmp w0, #'+'
    b.ne .parse_digits2
    add x19, x19, #1

.parse_digits2:
    ldrb w0, [x19]
    cbz w0, .combine    // fin de cadena

    cmp w0, #'.'
    beq .parse_fraction

    cmp w0, #'0'
    blt .error2
    cmp w0, #'9'
    bgt .error2

    sub w0, w0, #'0'     // ASCII a dígito

    mov x3, #10
    mul x20, x20, x3

    uxtw x3, w0
    add x20, x20, x3

    add x19, x19, #1
    b .parse_digits2

.parse_fraction:
    add x19, x19, #1       // pasar el '.'

    ldr x2, =ten_double
    ldr d2, [x2]           // d2 = 10.0

.frac_loop:
    ldrb w0, [x19]
    cbz w0, .combine

    cmp w0, #'0'
    blt .error2
    cmp w0, #'9'
    bgt .error2

    sub w0, w0, #'0'
    scvtf d3, w0           // d3 = float(digito)
    fdiv d3, d3, d1        // d3 /= divisor actual
    fadd d0, d0, d3        // acumular fracción
    fmul d1, d1, d2        // divisor *= 10.0

    add x19, x19, #1
    b .frac_loop

.combine:
    scvtf d3, x20          // convertir parte entera
    fadd d0, d0, d3        // resultado = entero + fracción

    cmp x21, #0
    beq .return2
    fneg d0, d0            // si negativo, cambiar signo

.return2:
    // Restaurar registros
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret

.error2:
    ldr x2, =zero_double
    ldr d0, [x2]
    mov x1, #1
    b .return2


zero_double:
    .double 0.0

one_double:
    .double 1.0

ten_double:
    .double 10.0

    
minus_sign: .ascii "-"
newline: .ascii "\n"
dot_char: .ascii "."
zero_char: .ascii "0"
