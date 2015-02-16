//setup_log_parser_plugin.groovy
import hudson.plugins.logparser.LogParserPublisher
import hudson.plugins.logparser.ParserRuleFile
env = System.getenv()
build_parsing_rules = "/var/lib/jenkins/build_parsing_rules"
servicetest_parsing_rules = "/var/lib/jenkins/servicetest_parsing_rules"
desc = LogParserPublisher.DescriptorImpl.DESCRIPTOR
desc.parsingRulesGlobal = new ParserRuleFile[2]
desc.parsingRulesGlobal[0] = new ParserRuleFile('build_parsing_rules',build_parsing_rules)
desc.parsingRulesGlobal[1] = new ParserRuleFile('servicetest_parsing_rules',servicetest_parsing_rules)
desc.save()
new File(build_parsing_rules).withWriter { out ->
  out.write(
"""
error /error (CS|MSB)\\d+/
error /^\\[failed\\] Test/
error /Build timed out/
warn /warning (CS|MSB)\\d+/
start /rake build/
start /Searching for unit test libraries/
start /rake package/
""")
}
 
 
new File(servicetest_parsing_rules).withWriter { out ->
  out.write(
"""
error /^\\[failed\\] Test/
error /Build timed out/
""")
}
