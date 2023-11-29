# Makefile

JAVA_SOURCE_FILE = BaseGraph.java

.PHONY: p1 p2 p3 p4 p5

p1: # lists the inline comments in a java file: //
	@grep -nE "//.*" $(JAVA_SOURCE_FILE)

p2: # lists the opening comment blocks in a java file: /*
	@grep -nE "/\*.*" $(JAVA_SOURCE_FILE)

p3: # lists the public constructors in a java file
	@grep -nE "public\s+\w+\s*\(" $(JAVA_SOURCE_FILE)

p4: # lists the public java method definitions in a java file
	@grep -nE " public.*(.*).*{" $(JAVA_SOURCE_FILE)

p5: # lists the protected java fields in a java file
	@grep -nE "protected" $(JAVA_SOURCE_FILE)
