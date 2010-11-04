# MarkdownPapers benchmark #

This benchmark includes:

1. [MarkdownPapers](http://github.com/lruiz/MarkdownPapers)
2. [Pegdown](http://github.com/sirthias/pegdown)
3. [MarkdonwJ](http://www.markdownj.org)

At the moment Pegdown is not distributed through a maven repository, you have to install it manually.

    mvn install:install-file -Dfile=lib/parboiled-0.9.7.3.jar -DgroupId=org.parboiled -DartifactId=parboiled -Dversion=0.9.7.3 -DcreateChecksum=true -Dpackaging=jar
    mvn install:install-file -Dfile=lib/pegdown-0.8.5.1.jar -DgroupId=org.pegdown -DartifactId=pegdown -Dversion=0.8.5.1 -DcreateChecksum=true -Dpackaging=jar


