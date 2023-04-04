runTests: BackendDeveloperTests.class
	java -jar junit5.jar -cp . --select-class=BackendDeveloperTests
clean:
	rm *.class
BackendDeveloperTests.class: BackendDeveloperTests.java AlgorithmEngineerBD.class CarBD.class CarReaderBD.class CarSearchBackendBD.class
	javac -cp .:junit5.jar BackendDeveloperTests.java
AlgorithmEngineerBD.class: AlgorithmEngineerBD.java
	javac AlgorithmEngineerBD.java
CarBD.class: CarBD.java
	javac CarBD.java
CarReaderBD.class: CarReaderBD.java
	javac CarReaderBD.java
CarSearchBackendBD.class: CarSearchBackendBD.java
	javac CarSearchBackendBD.java
