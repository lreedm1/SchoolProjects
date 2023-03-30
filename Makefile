runTests: compile
	java -jar junit5.jar -cp . -c DataWranglerTests

compile: 
	javac Car.java
	javac CarInterface.java
	javac CarReaderInterface.java
	javac -cp .:junit5.jar DataWranglerTests.java
	

clean:
	rm *.class
