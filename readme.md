# Exploring Circe

see the source file & test file

# does it work?

```
$ sbt test
[info] welcome to sbt 1.7.1 (Azul Systems, Inc. Java 11.0.12)
[info] loading global plugins from /Users/nfunnell/.sbt/1.0/plugins
[info] loading settings for project circe_explore-build-build from metals.sbt ...
[info] loading project definition from /Users/nfunnell/tmp/circe/circe_explore/project/project
[info] loading settings for project circe_explore-build from metals.sbt ...
[info] loading project definition from /Users/nfunnell/tmp/circe/circe_explore/project
[success] Generated .bloop/circe_explore-build.json
[success] Total time: 1 s, completed Oct 11, 2022, 10:45:23 AM
[info] loading settings for project root from build.sbt ...
[info] set current project to circe_explore (in build file:/Users/nfunnell/tmp/circe/circe_explore/)
[info] HelloSpec:
[info] The Hello object
[info] - should say hello
[info] test setup
[info] - should be valid
[info] json things
[info] - should become a string
[info] decoder
[info] - should json string -> object
[info] gtag
[info] - should exist
[info] gtag good decode
[info] - should become gtag
[info] gtag json that isn't an object
[info] - should become a None
[info] gtag json that is numbers
[info] - should become a None
[info] Run completed in 666 milliseconds.
[info] Total number of tests run: 8
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 8, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 1 s, completed Oct 11, 2022, 10:45:25 AM
```

## Other Thoughts

Should this be a blog post?

