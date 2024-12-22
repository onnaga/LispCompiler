1_  

java -jar antlr-4.13.2-complete.jar -Dlanguage=Java -no-listener -no-visitor -o src/main/java -Xlog src/main/antlr/MyGrammar.g4

2_ javac -cp ".;antlr-4.13.2-complete.jar" -d build src/main/java/*.java

3_ java -cp ".;antlr-4.13.2-complete.jar;build" Main


