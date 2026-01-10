@echo off
echo Building the project...
mvn clean package
if %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    pause
    exit /b %ERRORLEVEL%
)
echo Build successful!
pause
