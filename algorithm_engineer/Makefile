runTests:
	javac -cp .:junit5.jar AlgorithmEngineerTests.java RedBlackTree.java RedBlackTreeInterface.java SortedCollectionInterface.java
	java -cp .:junit5.jar org.junit.platform.console.ConsoleLauncher --scan-class-path

clean:
	rm -f *.class
