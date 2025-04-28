#!/usr/bin/env bash
set -e  # Detiene el script si ocurre un error

# Solicitar el nombre del archivo
echo -e "Ingresar El Nombre Del Archivo (sin extensión):"
read file

# Verificar si el archivo existe
if [ ! -f "$file.s" ]; then
    echo "Error: El archivo $file.s no existe."
    exit 1
fi

echo "--------------- ENSAMBLADO ----------------"
echo "Ensamblando Archivo: $file.s - $(date +%H:%M:%S)"
aarch64-linux-gnu-as -g -o "$file.o" "$file.s"  # Incluye soporte de depuración con -g

echo "Ensamblado Exitoso"

echo "=========================================="

echo "---------------- ENLAZADO -----------------"
echo "Enlazando Archivo: $file.o - $(date +%H:%M:%S)"
aarch64-linux-gnu-ld -o "$file" "$file.o"

echo "Ejecutable Creado"

echo "=========================================="

# Solicitar el puerto para depuración o usar el puerto por defecto
read -p "Ingrese el puerto para la depuración (por defecto 1234): " debug_port
debug_port=${debug_port:-1234}

# Liberar el puerto si está en uso
if lsof -i :$debug_port &>/dev/null; then
    echo "El puerto $debug_port está en uso. Liberando el puerto..."
    sudo fuser -k "$debug_port"/tcp
fi

# Preguntar si se desea depurar el archivo
while true; do
    read -p "¿Desea depurar el archivo con GDB? (s/n): " debug_choice
    case "$debug_choice" in
        [Ss])
            echo "Iniciando GDB en el puerto $debug_port..."
            qemu-aarch64 -g "$debug_port" "./$file" &
            sleep 1  # Esperar un momento para que qemu-aarch64 inicie
            gdb-multiarch -ex "target remote :$debug_port" -ex "set architecture aarch64" "$file"
            break
            ;;
        [Nn])
            echo "Ejecutando el archivo $file \n"
            echo " "
            qemu-aarch64 "./$file"
            break
            ;;
        *)
            echo "Por favor, responde 's' para sí o 'n' para no."
            ;;
    esac
done

# Limpieza opcional (descomentar si deseas borrar los archivos temporales)
# rm "$file.o" "$file"