@echo off
set proPath= "%~dp0"
set browserPath= "C:\Program Files (x86)\Google"
cd %proPath%
call mvn clean verify
cd /d %browserPath%
for /f "delims=" %%i in ('dir chrome.exe /b/s ') do (
    start "" "%%i" http://localhost:63342/web-ui-bdd/target/site/serenity/index.html
)


exit