# scala-timing-tests

Collection of examples that illustrare best practices for testing concurrent code with global time scale factor. 

# Usage

Run `sbt test`. All tests should fail because your machine is too slow :) Fear not - set environment variable `AKKA_TEST_TIMEFACTOR` to 2, and run tests again. The tests, being more patient, will pass. 
