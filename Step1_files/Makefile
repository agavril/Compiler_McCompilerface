CLASSPATH := antlr-4.7.1-complete.jar

ANTLR := step1.g4

compiler:
	rm -rf build
	mkdir build
	java -cp $(CLASSPATH) org.antlr.v4.Tool -o build $(ANTLR)
	rm -rf classes
	mkdir classes
	javac -cp $(CLASSPATH) -d classes  build/*.java
	
clean:
	rm -rf classes build

team:
	$(info Team: Compiler McCompilerface)
	$(info )
	$(info Alexandru Gavrila)
	$(info agavril)
	$(info )
	$(info Austin Applegate)
	$(info aappleg)