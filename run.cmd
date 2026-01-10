@echo off
if not exist target\veneclicker-1.0-SNAPSHOT.jar (
    echo Jar file not found! Please run build.cmd first.
    pause
    exit /b 1
)
echo Running veneclicker...
java -jar target\veneclicker-1.0-SNAPSHOT.jar
pause
