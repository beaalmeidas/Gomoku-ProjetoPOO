@echo off
echo Compilando o projeto...
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
echo Compilação concluída!
