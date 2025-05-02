"use client";
import { Editor } from "@monaco-editor/react";
import { useState } from "react";
import Menu from "./components/navbar";
import Image from "next/image";
import go from "../public/img/go.png";
import arm from "../public/img/logo.png";
import { Console } from "console";
import { useRef } from "react";



const API_URL = "http://localhost:5159";
//const API_URL = "http://localhost:5024";

export default function Home() {
  const [code, setCode] = useState<string>("");
  const [output, setOutput] = useState<string>("");
  const [listSymbols, setListSymbols] = useState<
    | {
        id: string;
        tipo: string;
        tipoDato: string;
        ambito: string;
        linea: number;
        columna: number;
      }[]
    | null
  >(null);
  const [isError, setIsError] = useState<boolean>(false); // Estado para controlar el color del output
  const [cursorPosition, setCursorPosition] = useState<{
    line: number;
    column: number;
  }>({
    line: 1,
    column: 1,
  });

  const outputRef = useRef<HTMLPreElement>(null);


  const handleCopyConsole = () => {
    const text = outputRef.current?.innerText;
    if (text) {
      navigator.clipboard.writeText(text);
      alert("Contenido copiado al portapapeles.");
    }
  };
  

  const handleExecute = async () => {
    try {
      const response = await fetch(`${API_URL}/compile`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ code }),
      });

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.error || "Error desconocido");
      }

      setOutput(data.result);
      setListSymbols(data.symbols);
      setIsError(false); // Si no hay error
    } catch (err) {
      setOutput(err instanceof Error ? err.message : "Error desconocido");
      setIsError(true); // Si hay error
    }
  };

  const handleFileOpen = (event: React.ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files?.[0];
    if (!file) {
      console.error("No file selected");
      return;
    }

    if (!file.name.endsWith(".glt")) {
      console.error("Invalid file type. Only .gtl files are allowed.");
      alert("Solo se permiten archivos con extensión .gtl");
      return;
    }
  };

  const handleFileUpload = (content: string) => {
    setCode(content);
  };

  return (
    <div className="flex flex-col h-screen bg-gray-900 text-white">
      {/* Barra de herramientas */}
      <div className="w-full bg-gray-700 p-4 flex justify-between items-center shadow-md relative h-15">
        <div className="flex items-center space-x-4">
          <Image src={go} alt="Logo" width={50} height={50} />
          <h1 className="text-2xl font-bold">+</h1>
          <Image src={arm} alt="Logo" width={50} height={50} />
          <Menu
            code={code}
            onFileUpload={handleFileUpload}
            listSymbols={listSymbols}
          />
        </div>

        <div className="flex space-x-2">
          <button
            className="bg-green-700 hover:bg-green-600 transition-colors text-white font-semibold py-2 px-5 rounded-lg shadow"
            onClick={handleExecute}
          >
            Compilar
          </button>
          <button
            className="bg-red-600 hover:bg-red-700 transition-colors text-white font-semibold py-2 px-5 rounded-lg shadow"
            onClick={() => setCode("")}
          >
            Limpiar
          </button>
        </div>
      </div>

      {/* Contenedor principal (Editor + Consola) */}
      <div className="flex-grow flex flex-row p-6 space-x-6 overflow-hidden bg-gray-600">
        {/* Editor de código */}
        <div className="w-[50%] h-full relative border border-gray-700 rounded-lg shadow-lg overflow-hidden flex flex-col">
          <div className="flex-1">
            <Editor
              height="100%"
              defaultLanguage="go"
              theme="vs-dark"
              value={code}
              onChange={(value) => setCode(value || "")}
              onMount={(editor) => {
                editor.onDidChangeCursorPosition((event) => {
                  setCursorPosition({
                    line: event.position.lineNumber,
                    column: event.position.column,
                  });
                });
              }}
            />
          </div>
          <div className="bg-gray-800 text-gray-400 p-2 text-sm border-t border-gray-700">
            Línea: {cursorPosition.line} | Columna: {cursorPosition.column}
          </div>
        </div>

        {/* Consola/Terminal */}
        <div
          className={`w-[53%] h-full p-5 rounded-lg font-mono border border-gray-700 shadow-md overflow-auto ${
            isError ? "bg-black text-red-400" : "bg-black text-green-400"
          }`}
        >
          <div className="flex justify-end mb-2">
            <button
              onClick={handleCopyConsole}
              title="Copiar al portapapeles"
              className="text-white bg-transparent hover:text-blue-400 p-1"
            >
              📋
            </button>
          </div>
          <pre ref={outputRef} className="whitespace-pre-wrap">{output || "Output"}</pre>

        </div>
      </div>
      {/* Footer */}
      <footer className="bg-gray-800 text-gray-400 text-center py-3 text-sm">
        © {new Date().getFullYear()} Ivan Hilario 201902888 - Proyecto 2
      </footer>
    </div>
  );
}
