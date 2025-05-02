using System.Collections.Generic;
//min 46 de la penultima toca la concatenacion de 2 strings 
// recorrer str 1 hasta el null terminator y copiarlo en el segundo
// y luego ponerle un final null terminator

//min 47 explica eso de simbolos
public class StandardLibrary
{
    private readonly HashSet<string> UsedFunctions = new HashSet<string>();
    private readonly HashSet<string> UsedSymbols = new HashSet<string>();

    public void Use(string function)
    {
        UsedFunctions.Add(function);

        if (function == "print_integer")
        {
            UsedSymbols.Add("minus_sign");
            UsedSymbols.Add("newline");
        }
        else if (function == "print_double")
        {
            UsedSymbols.Add("dot_char");
            UsedSymbols.Add("zero_char");
            UsedSymbols.Add("newline");

        }else if (function == "print_boolean")
        {
            UsedSymbols.Add("str_true");
            UsedSymbols.Add("str_false");
            UsedSymbols.Add("newline");
        }else if (function == "print_string")
        {
            UsedSymbols.Add("newline");
        }
        else if(function == "print_rune")
        {
    
            UsedSymbols.Add("print_rune");
        }
        else if (function == "concat_strings")
        {
            UsedSymbols.Add("newline");

        } else if (function == "atoi")
        {
            UsedSymbols.Add("dot_char");
            UsedSymbols.Add("zero_char");
            UsedSymbols.Add("newline");

        } else if (function == "parse_float")
        {
            UsedSymbols.Add("zero_double");
            UsedSymbols.Add("one_double");
            UsedSymbols.Add("ten_double");

        }
    }

    public string GetFunctionDefinitions()
    {
        var functions = new List<string>();

        foreach (var function in UsedFunctions)
        {
            if (FunctionDefinitions.TryGetValue(function, out var definition))
            {
                functions.Add(definition);
            }
        }

        var fnDefs = string.Join("\n", functions);

        var symbols = new List<string>();
        foreach (var symbol in UsedSymbols)
        {
            if (Symbols.TryGetValue(symbol, out var definition))
            {
                symbols.Add(definition);
            }
        }
        var symbolsDefs = string.Join("\n", symbols);

        return fnDefs + "\n" + symbolsDefs;
    }


private readonly static Dictionary<string, string> FunctionDefinitions = new Dictionary<string, string>
    {
        { "print_integer", @"
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
    "
    },
   { "print_boolean", @"
//--------------------------------------------------------------
// print_boolean - Prints a bool (true/false) to stdout
//
// Input:
//   x0 - The bool value to print (0 = false, != 0 = true)
//--------------------------------------------------------------
print_boolean:
    cmp x0, #0
    bne .print_true

.print_false:
    adr x1, str_false
    mov x2, #5
    b .print

.print_true:
    adr x1, str_true
    mov x2, #4

.print:
    mov x0, #1          // fd = stdout
    mov w8, #64         // syscall write
    svc #0

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0

    ret
    "},

    {
        "print_string", @"
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
    "},
    {
    "concat_strings", @"
//--------------------------------------------------------------
// concat_strings - Concatenates two null-terminated strings
//
// Input:
//   SP+0: Address of the second string
//   SP+8: Address of the first string
// Output:
//   X0: Address of the concatenated string
//--------------------------------------------------------------
concat_strings:
    stp x29, x30, [sp, #-16]!
    stp x19, x20, [sp, #-16]!
    stp x21, x22, [sp, #-16]!

    // Cargar las direcciones de los strings desde la pila
    ldr x19, [sp, #48]  // Primer string
    ldr x20, [sp, #56]  // Segundo string

    // Calcular longitud del primer string
    mov x21, #0
strlen1_loop:
    ldrb w0, [x19, x21]
    cbz w0, strlen1_done
    add x21, x21, #1
    b strlen1_loop
strlen1_done:

    // Calcular longitud del segundo string
    mov x22, #0
strlen2_loop:
    ldrb w0, [x20, x22]
    cbz w0, strlen2_done
    add x22, x22, #1
    b strlen2_loop
strlen2_done:

    // Reservar espacio en el heap (x10 es el heap pointer)
    mov x0, x21
    add x0, x0, x22
    add x0, x0, #1  // Para el terminador nulo
    add x10, x10, x0  // Mover el heap pointer

    // Copiar el primer string
    mov x0, x19
    mov x1, x10
    sub x1, x1, x21
    sub x1, x1, x22
    sub x1, x1, #1
    mov x2, x21
copy1_loop:
    ldrb w3, [x0], #1
    strb w3, [x1], #1
    subs x2, x2, #1
    bne copy1_loop

    // Copiar el segundo string
    mov x0, x20
    mov x2, x22
copy2_loop:
    ldrb w3, [x0], #1
    strb w3, [x1], #1
    subs x2, x2, #1
    bne copy2_loop

    // Agregar terminador nulo
    mov w3, #10        // ASCII '\n'
    strb w3, [x1], #1  // Guardar '\n' y avanzar
    mov w3, #0
    strb w3, [x1]

    // Devolver la dirección del nuevo string
    mov x0, x10
    sub x0, x0, x21
    sub x0, x0, x22
    sub x0, x0, #1

    // Restaurar registros
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret
    "},    { "atoi", @"
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
    "},
    
    { "print_rune", @"
//--------------------------------------------------------------
// print_rune - Prints a single UTF-8 rune (char) to stdout
//
// Input:
//   w0 - The rune value to print (ASCII expected)
//--------------------------------------------------------------
print_rune:
    // Guardar registros necesarios
    stp x29, x30, [sp, #-16]!

    // Mover el valor de w0 a una ubicación temporal
    // Creamos un buffer en stack
    sub sp, sp, #16
    strb w0, [sp]        // Guardamos solo 1 byte
    mov x0, #1           // fd = stdout
    mov x1, sp           // dirección del buffer
    mov x2, #1           // longitud = 1 byte
    mov w8, #64          // syscall write
    svc #0

    // Liberar buffer
    add sp, sp, #16

    // Restaurar registros
    ldp x29, x30, [sp], #16
    ret
" },

    {
        "print_double", @"
//--------------------------------------------------------------
// print_double - Prints a double precision float to stdout
//
// Input:
//   d0 - The double value to print
//--------------------------------------------------------------

print_double:
    // Save context
    stp x29, x30, [sp, #-16]!    
    stp x19, x20, [sp, #-16]!
    stp x21, x22, [sp, #-16]!
    stp x23, x24, [sp, #-16]!
    
    // Check if number is negative
    fmov x19, d0
    tst x19, #(1 << 63)       // Comprueba el bit de signo
    beq skip_minus

    // Print minus sign
    mov x0, #1
    adr x1, minus_sign
    mov x2, #1
    mov x8, #64
    svc #0

    // Make value positive
    fneg d0, d0

skip_minus:
    // Convert integer part
    fcvtzs x0, d0             // x0 = int(d0)
    bl print_integer

    // Print dot '.'
    mov x0, #1
    adr x1, dot_char
    mov x2, #1
    mov x8, #64
    svc #0

    // Get fractional part: frac = d0 - float(int(d0))
    frintm d4, d0             // d4 = floor(d0)
    fsub d2, d0, d4           // d2 = d0 - floor(d0) (exact fraction)

    // Para 2.5, d2 debe ser exactamente 0.5

    // Multiplicar por 1_000_000 (6 decimales)
    movz x1, #0x000F, lsl #16
    movk x1, #0x4240, lsl #0   // x1 = 1000000
    scvtf d3, x1              // d3 = 1000000.0
    fmul d2, d2, d3           // d2 = frac * 1_000_000
    
    // Redondear al entero más cercano para evitar errores de precisión
    frintn d2, d2             // d2 = round(d2)
    fcvtzs x0, d2             // x0 = int(d2)

    // Imprimir ceros a la izquierda si es necesario
    mov x20, x0               // x20 = fracción entera
    movz x21, #0x0001, lsl #16
    movk x21, #0x86A0, lsl #0  // x21 = 100000
    mov x22, #0               // inicializar contador de ceros
    mov x23, #10              // constante para división

leading_zero_loop:
    udiv x24, x20, x21        // x24 = x20 / x21
    cbnz x24, done_leading_zeros  // Si hay un dígito no cero, salir del bucle

    // Imprimir '0'
    mov x0, #1
    adr x1, zero_char
    mov x2, #1
    mov x8, #64
    svc #0

    udiv x21, x21, x23        // x21 /= 10
    add x22, x22, #1          // incrementar contador de ceros
    cmp x21, #0               // verificar si llegamos al final
    beq print_remaining       // si divisor es 0, saltar a imprimir el resto
    b leading_zero_loop

done_leading_zeros:
    // Print the remaining fractional part
    mov x0, x20
    bl print_integer
    b exit_function

print_remaining:
    // Caso especial cuando la parte fraccionaria es 0 después de imprimir ceros
    cmp x20, #0
    bne exit_function
    
    // Ya imprimimos todos los ceros necesarios
    // No hace falta imprimir nada más

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0

exit_function:
    // Restore context
    ldp x23, x24, [sp], #16
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret
    "},
    { "parse_float", @"
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

    "}
    };
    private readonly static Dictionary<string, string> Symbols = new Dictionary<string, string>
    {
        { "minus_sign", @"minus_sign: .ascii ""-""" },
        { "dot_char", @"dot_char: .ascii "".""" },
        { "zero_char", @"zero_char: .ascii ""0""" },

        {"str_true", @"str_true: .ascii ""true""" },
        {"str_false", @"str_false: .ascii ""false""" },
        {"newline", @"newline: .ascii ""\n""" },

        {"zero_double:", @"zero_double: .double 0.0" },
        {"one_double:", @"one_double: .double 1.0" },
        {"ten_double:", @"ten_double: .double 10.0" }

    };
}

