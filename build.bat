@echo off
setlocal
cd /d "%~dp0"
python build.py %*
if errorlevel 1 (
    echo Build failed.
    exit /b 1
)
endlocal
