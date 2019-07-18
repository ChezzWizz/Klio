# ProjectKlio
Project Klio is a one player, text based RPG in the same vein as Zork and other similar text
adventures with rouge like elements. Project Klio aims to provide a story built on dynamic blocks
of text with user interaction as text commands that are processed using a custom natural language
parser.

+ [Design Document](https://github.com/ChezzWizz/Klio/wiki/Design-Document)

To compile and run the code from the project src directory, use the standard java compiler "javac"
and jvm command "java" from the `Klio\src` directory:

    javac klio\*.java
    java klio.Klio

With the default file located in the working directory when the application is run, this application
will currently print out the data straight from the XML([YAML]? [JSON]?) file showing that the maps have been
populated and the Scene and Npc objects have been instantiated.

[YAML]: https://yaml.org/spec/1.2/spec.html "YAML Specification"
[JSON]: http://www.ietf.org/rfc/rfc4627.txt "JSON RFC"
[JSON]: http://json.org "JSON Homepage"
