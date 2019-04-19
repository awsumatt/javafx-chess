tput bold
echo
echo "Compiling...."
echo
tput sgr0

javac com/javafxChess/Controller.java
javac com/javafxChess/javaFxChess.java

tput bold
echo
echo "Enjoy!"
echo
tput sgr0

java com.javafxChess.javaFxChess
