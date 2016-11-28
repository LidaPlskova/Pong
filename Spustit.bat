@echo off

rem Je nutne nize nastavit CLASS_TO_BE_RUN na spravnou spousteci tridu!!!!
set CLASS_TO_BE_RUN=net.sevecek.SpousteciTrida
set PREFERRED_JDK_HOME=C:\Java-Training\JDK
set EXE_NAME=javaw
if not exist aplikace.jar    set EXE_NAME=java


if exist "%PREFERRED_JDK_HOME%\bin\%EXE_NAME%.exe"   goto SET_JAVA_HOME
if not "%JAVA_HOME%" == ""   goto SET_JAVA_EXE

:DETECT_JAVA
for /f %%i in ('where  %EXE_NAME%') do set JAVA_EXE=%%i
if not "%JAVA_EXE%" == ""   goto RUN

msg   "%USERNAME%"   "Bohuzel jsme nenasli Javu na vasem pocitaci. Bud si ji nainstalujte z http://java.oracle.com/ nebo stahnete instalci z http://java.czechitas.sevecek.net/"
goto END


:SET_JAVA_HOME
set   "JAVA_HOME=%PREFERRED_JDK_HOME%"


:SET_JAVA_EXE
set   "JAVA_EXE=%JAVA_HOME%\bin\%EXE_NAME%"


:RUN
if exist aplikace.jar    goto RUN_JAR

:RUN_BUILD
"%JAVA_EXE%"   -classpath "build\classes;lib\Sevecek.net Utils\sevecek-net-utils.jar"   %CLASS_TO_BE_RUN%
if not errorlevel 1   goto END
echo.
echo Pokud nelze nalezt main class "%CLASS_TO_BE_RUN%", presvedcte se, ze se opravdu ma jmenovat "%CLASS_TO_BE_RUN%"
echo.
echo Kandidat pro skutecnou main class by mohl byt napriklad zde:
for /R build\classes   %%f in (SpousteciTrida.class) do (
    if exist %%f  echo %%f
)
echo Jmeno tridy dostanete odstranenim "%~dp0build\classes\" a predelanim zbylych "\" na "."
echo.
pause
goto END


:RUN_JAR
start   "Java aplikace"   "%JAVA_EXE%"   -classpath "aplikace.jar;lib\sevecek-net-utils.jar"   %CLASS_TO_BE_RUN%
goto END


:END
