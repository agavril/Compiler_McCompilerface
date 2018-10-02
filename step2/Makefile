ANTLR := step2.g4

compiler:
	rm -rf build
	mkdir build
	java -cp $(CLASSPATH) org.antlr.v4.Tool -o build $(ANTLR)
	rm -rf classes
	mkdir classes
	javac -cp $(CLASSPATH) -d classes -source 1.7 -target 1.7 src/*.java build/*.java

team:
	$(info Team: Compiler McCompilerface)
	$(info )
	$(info Alexandru Gavrila)
	$(info agavril)
	$(info )
	$(info Austin Applegate)
	$(info aappleg)

clean:
	rm -rf classes/ build/
