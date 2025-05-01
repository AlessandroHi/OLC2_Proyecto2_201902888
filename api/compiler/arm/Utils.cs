
public static class Utils
{
    public static List<byte> StringToByteArray(string str)
    {

        var resultado = new List<byte>();//Aqui ira el caracter del resultado en ascci

        int elementoIndex = 0;

        while(elementoIndex < str.Length)
        {
            resultado.Add((byte)str[elementoIndex]);
            elementoIndex++;
          
        }
        resultado.Add(0); // Null terminator para identificar el final de la cadena
        return resultado;
    }

}