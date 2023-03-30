runTests: compile
	java -jar junit5.jar -cp . -c AlgorithmEngineerTests

compile: 
	javac AE_Car.java
	javac RedBlackTree.java
	javac RedBlackTreeInterface.java
	javac SortedCollectionInterface.java
	javac CarInterface.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java
	

clean:
	rm *.class
