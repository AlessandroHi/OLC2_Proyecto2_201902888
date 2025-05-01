using System.Security.Cryptography;
using System.Text;
using Antlr4.Runtime.Atn;
using Microsoft.AspNetCore.Routing.Constraints;


public class StackObject
{
   public enum StackObjectType{ Int, Float, String , Bool, Rune, Undefined} // se maneja como el value grapper
    public StackObjectType Type { get; set; }

    public int Length { get; set; } // tamaño en staclk
    public int Depth { get; set; } // anidados
    public string? Id { get; set; } //nombre asociado
    public int Offset { get; set; } // offset en el stack
}

public class ARMGenerator 
{
    public  List<string> instructions = new List<string>();

    public List<string> funcInstructions = new List<string>();
    private readonly StandardLibrary stdLib = new StandardLibrary();

    private List<StackObject> stack = new List<StackObject>(); // stack virtual

    private int depth = 0; // nivel de anidamiento

    private int labelCounter = 0; // contador de etiquetas

    public string GetLabel()
    {
        return $"L{labelCounter++}";
    }

    public void SetLabel(string label)
    {
        instructions.Add($"{label}:");
    }

    // -- stack operations --

    public StackObject TopObject()
    {

        return stack.Last();
    }



    public void PushObject(StackObject obj)
    {
        Comment($"Pushing object of type {obj.Type} to stack");
        stack.Add(obj);
 
    }

    public void PushConstant(StackObject obj, object value)
    {
        switch (obj.Type)
        {
            case StackObject.StackObjectType.Int: // int
                Mov(Register.X0, (int)value);
                Push(Register.X0);
                break;


            case StackObject.StackObjectType.Float:
                long valorFloat = BitConverter.DoubleToInt64Bits((double)value);
                ushort[] partes = new ushort[4]; // aquí usamos ushort
                for (int i = 0; i < 4; i++)
                {
                    partes[i] = (ushort)((valorFloat >> (i * 16)) & 0xFFFF); // conversión explícita a ushort
                }
                instructions.Add($"MOVZ x0, #{partes[0]}, LSL #0");

                for (int i = 1; i < 4; i++)
                {
                

                    instructions.Add($"MOVK x0, #{partes[i]}, LSL #{i * 16}");
                }
                Push(Register.X0);
                break;

            case StackObject.StackObjectType.String: // string


                 List<byte> stringArray = Utils.StringToBytes((string)value);

                 Push(Register.HP);
                 for (int i = 0; i < stringArray.Count; i++)
                 {
                    var charCode = stringArray[i];  
                    Comment($"Pushing character {charCode} to heap");
                    Mov("w0", charCode);
                    Strb("w0", Register.HP);
                    Mov(Register.X0, 1);
                    Add(Register.HP, Register.HP, Register.X0);  
                 }

                 break;

            case StackObject.StackObjectType.Bool: // bool
               Mov(Register.X0, (bool)value ? 1 : 0);
               Push(Register.X0);
               break;

            case StackObject.StackObjectType.Rune: // rune
            
                Mov(Register.X0, value is string s ? s[0] : (char)value);
                Push(Register.X0);
                break;

            default:
                throw new ArgumentException("Tipo de objeto no soportado.");
        }

        PushObject(obj);
    }


    public void PopObject( )
    {
        Comment($"Popping object of type {stack.Last().Type} from stack");
        
        try
        {
            stack.RemoveAt(stack.Count - 1);
        }
        catch (System.Exception)
        {
            throw new ArgumentException("No hay objetos en el stack para hacer pop.");
        }
    }


    public StackObject PopObject(string rd)
    {
        Comment($"Popping object of type {stack.Last().Type} from stack");
        var obj = stack.Last();
        
        PopObject();

        Pop(rd);
        return obj;
    }

    public StackObject IntObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Int,
            Length = 8,
            Depth = depth,
            Id = null
        };
    }

    public StackObject FloatObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Float,
            Length = 8,
            Depth = depth,
            Id = null
        };
    }
    public StackObject StringObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.String,
            Length = 8,
            Depth = depth,
            Id = null
        };
    }

    public StackObject BoolObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Bool,
            Length = 8,
            Depth = depth,
            Id = null
        };
    }

    public StackObject RuneObject(){
        return new StackObject
        {
            Type = StackObject.StackObjectType.Rune,
            Length = 8,
            Depth = depth,
            Id = null
        };
    }


    public StackObject CloneObject(StackObject obj)
    {
        return new StackObject
        {
            Type = obj.Type,
            Length = obj.Length,
            Depth = obj.Depth,
            Id = obj.Id
        };
        
    }
    // -----------------------


    // Environment management

    public void NewScope()
    {
        depth++;
    }

    public int endScope()
    {
        int byteOffset = 0;
        for(int i = stack.Count - 1; i >= 0; i--)
        {
           if(stack[i].Depth == depth)
            {
                byteOffset += stack[i].Length;
                stack.RemoveAt(i);
            }
            else{
                break;
            }
        }
        depth--;
        return byteOffset;
    }


public void TagObject(string id)
{
    if (stack.Count == 0)
    {
        // Crear un nuevo objeto con valor por defecto
        var defaultObj = new StackObject
        {
            Type = StackObject.StackObjectType.Undefined,
            Length = 8,
            Depth = depth,
            Id = id
        };
        stack.Add(defaultObj);
    }
    else
    {
        stack.Last().Id = id;
    }
}

    public (int, StackObject) GetObject(string id)
    {
        int byteOffset = 0;
        for (int i = stack.Count - 1; i >= 0; i--)
        {
            if (stack[i].Id == id)
            {
                return (byteOffset, stack[i]);
            }
            byteOffset += stack[i].Length;
        }
        throw new ArgumentException($"No se encontró el objeto con ID: {id} en el stack.");
    }

    // -- arithmetic operations --


    public void Add(string rd, string rs1, string rs2)
    {
        instructions.Add($"ADD {rd}, {rs1}, {rs2}");
    }

    public void Adr(string rd, string rs1) /// -------------- REVISAR ACA LUEGO
    {
        instructions.Add($"ADR {rd}, {rs1}");
    }

    public void Sub(string rd, string rs1, string rs2)
    {
        instructions.Add($"SUB {rd}, {rs1}, {rs2}");
    }

    public void Mul(string rd, string rs1, string rs2)
    {
        instructions.Add($"MUL {rd}, {rs1}, {rs2}");
    }

    public void Div(string rd, string rs1, string rs2)
    {
        instructions.Add($"DIV {rd}, {rs1}, {rs2}");
    }

    public void Addi(string rd, string rs1, int imm)
    {
        instructions.Add($"ADDI {rd}, {rs1}, #{imm}");
    }

        public void Mod(string rd, string rn, string rm)
    {
        instructions.Add($"SDIV {Register.X9}, {rn}, {rm}");
        instructions.Add($"MSUB {rd}, {Register.X9}, {rm}, {rn}");
    }

        public void Sdiv(string rd, string rn, string rm)
    {
        instructions.Add($"SDIV {rd}, {rn}, {rm}");
    }

    
    // --memory operations--
    public void Str(string rs1, string rs2, int offset = 0)
    {
        instructions.Add($"STR {rs1}, [{rs2}, #{offset}]");
    }

    public void Strb(string rs1, string rs2)
    {
        instructions.Add($"STRB {rs1}, [{rs2}]");
    }

    public void Ldr(string rd, string rs1, int offset = 0)
    {
        instructions.Add($"LDR {rd}, [{rs1}, #{offset}]");
    }

    public void Mov(string rd, int imm)
    {
        instructions.Add($"MOV {rd}, #{imm}");
    }


    public void Push(string rs)
    {
       instructions.Add($"STR {rs}, [SP, #-8]!");
    }

    public void Pop(string rd)
    {
        instructions.Add($"LDR {rd}, [SP], #8");
    }

    // float operations 

 public void Scvtf(string rd, string registro)
    {
         instructions.Add($"SCVTF {rd}, {registro}");
    }
    public void Fmov(string rd, string registro)
    {
        instructions.Add($"FMOV {rd}, {registro}");
    }
    public void Fmov1(string rd, double value)
{
    var valStr = value.ToString(System.Globalization.CultureInfo.InvariantCulture);
    instructions.Add($"FMOV {rd}, {valStr}");
}
    public void Fadd(string rd, string registro1, string registro2)
    {
        instructions.Add($"FADD {rd}, {registro1}, {registro2}");
    }
    public void Fsub(string rd, string registro1, string registro2)
    {
        instructions.Add($"FSUB {rd}, {registro1}, {registro2}");
    }
    public void Fmul(string rd, string registro1, string registro2)
    {
        instructions.Add($"FMUL {rd}, {registro1}, {registro2}");
    }
    public void Fdiv(string rd, string registro1, string registro2)
    {
        instructions.Add($"FDIV {rd}, {registro1}, {registro2}");
    }

    public void Fcmp(string registro1, string registro2)
    {
        instructions.Add($"FCMP {registro1}, {registro2}");
    }
      



    //-------------


    public void Cmp(string rs1, string rs2)
    {
        instructions.Add($"CMP {rs1}, {rs2}");
    }

    public void Beq(string label)
    {
        instructions.Add($"BEQ {label}");
    }

    public void Bne(string label)
    {
        instructions.Add($"BNE {label}");
    }

    public void Bgt(string label)
    {
        instructions.Add($"BGT {label}");
    }

    public void Blt(string label)
    {
        instructions.Add($"BLT {label}");
    }

    public void B(string etiqueta)
    {
        instructions.Add($"B {etiqueta}");
    }
    public void Bl(string label)
    {

        instructions.Add($"BL {label}");
    }

        public void Bge(string etiqueta)
    {
        instructions.Add($"BGE {etiqueta}");
    }

    public void Br(string etiqueta)
    {
        instructions.Add($"BR {etiqueta}");
    }

    public void Ble(string etiqueta)
    {
        instructions.Add($"BLE {etiqueta}");
    }

    public void Cbz(string rs, string etiqueta)
    {
        instructions.Add($"CBZ {rs}, {etiqueta}");
    }


        public void Neg(string destino, string origen) // Negación unaria
    {
        Comment("Negación unaria");
        Mov(destino, 0);
        Sub(destino, destino, origen); // destino = 0 - origen
    }




    public void Svc(){
        instructions.Add($"SVC #0");
    }

    public void EndProgram()
    {
        Mov(Register.X0, 0);
        Mov(Register.X8, 93);
        Svc();
    }

    // -- standard library operations --
    public void PrintInteger(string rs)
    {
        stdLib.Use("print_integer"); 
        instructions.Add($"MOV X0, {rs}");
        instructions.Add($"BL print_integer");
    }

    public void PrintString(string rs)
    {
        stdLib.Use("print_string");
        instructions.Add($"MOV X0, {rs}");
        instructions.Add($"BL print_string");
    }

    public void PrintDouble()
    {
        stdLib.Use("print_integer");
        stdLib.Use("print_double");
        instructions.Add($"BL print_double");
    }

     public void PrintBool(string registro)
    {
        stdLib.Use("print_boolean");
        instructions.Add($"MOV X0, {registro}");
        instructions.Add($"BL print_boolean");
    }

    public void PrintRune(string registro)
    {
     
        stdLib.Use("print_rune");
        instructions.Add($"MOV X0, {registro}");
        instructions.Add($"BL print_rune");
    }   

    
    public void Comment(string comment)
    {
        instructions.Add($"// {comment}");
    }

    public override string ToString()
    {
       var sb = new StringBuilder();
       sb.AppendLine(".data");
       sb.AppendLine("heap: .space 4096");
       sb.AppendLine(".text");
       sb.AppendLine(".global _start");
       sb.AppendLine("_start:");
       sb.AppendLine("   adr x10, heap");

       EndProgram();

       foreach (var instruction in instructions)
         {
              sb.AppendLine(instruction);
         }
         sb.AppendLine("\n \n //Start of Standard Library");
         sb.AppendLine(stdLib.GetFunctionDefinitions());     

        return sb.ToString();

    }

public StackObject GetFrameLocal(int index)
{
    var undefinedObjects = stack.Where(o => o.Type == StackObject.StackObjectType.Undefined).ToList();
    if (index >= undefinedObjects.Count)
    {
        throw new IndexOutOfRangeException($"No hay suficiente espacio en el frame local para el índice {index}");
    }
    return undefinedObjects[index];
}


}