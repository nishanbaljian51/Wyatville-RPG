@echo off
rem Compiles and starts Wyatville RPG on Windows
cd /d "%~dp0"

where javac >nul 2>nul
if errorlevel 1 (
    echo Java isn't installed yet. See "Step 1: Install Java" in README.md.
    pause
    exit /b 1
)

javac -d bin src\*.java
if errorlevel 1 (
    pause
    exit /b 1
)
java -cp bin Game %*
pause
