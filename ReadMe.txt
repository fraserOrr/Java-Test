Read ME


For running the api have the WordLengthPackage in the root folder, all commands should also be run from the root folder.
in a testing or importing file the import command is
        "  import WordLengthPackage.*; "
       for running see example

       "WordLength wordLengthFinder = new WordLength();
       		wordLengthFinder.Evaluate("tests/" + args[0]);"

       		with args being the filename of the txt to test should go into the tests folder

the original java files are located in WordLengthFinder folder

pom.xml was generated using maven command

