runTests: runFrontendDeveloperTests

runFrontendDeveloperTests: FrontendDeveloperTests.java 
	javac -cp .:junit5.jar FrontendDeveloperTests.java
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FrontendDeveloperTests    

clean:
	rm *.class

