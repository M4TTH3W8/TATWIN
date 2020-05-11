from robot.api import ResultWriter
from robot.api import TestSuiteBuilder

class MyRunner:
    def run_test(self):
        suite = TestSuiteBuilder().build(".")
        suite.filter(included_suites=['HelloWorld'])
        suite.run(output="output.xml")
        ResultWriter("output.xml").write_results(report="Report.html", log_level='TRACE', log="Logs.html")


suites = MyRunner()
suites.run_test()
