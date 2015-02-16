// build flow

import jenkins.model.Jenkins 
//on old version
//import jenkins.model.Hudson
import hudson.model.AbstractProject
 
def jenkins = Jenkins.getInstance()
//on old version
//def jenkins = Hudson.getInstance()
out.println("--number of jobs ${jenkins.getAllItems(AbstractProject).size()}")


// groovy postbuild
import hudson.model.AbstractProject
 
def jenkins = manager.hudson
def logger = manager.listener.logger
logger.println("--number of jobs ${jenkins.getAllItems(AbstractProject).size()}")



// build flow

import jenkins.model.Jenkins
import hudson.model.AbstractProject
  
def jenkins = Jenkins.getInstance()
 
def job = jenkins.items.find { job -> job.isBuildable() && job.name == 'tc.blacklist-gate' }
if (job) {
    out.println("--- found ${job}")
    def triggers = job.getTriggers()            
    for (trigger in triggers.values().findAll{ it.class.toString() =~ /com.sonyericsson.hudson.plugins.gerrit.trigger.hudsontrigger/}) {
        out.println("--- found ${trigger.class.toString()}")
        out.println("--- gerrit projects size ${trigger.getGerritProjects().size()}")
        for(project in trigger.getGerritProjects()) {
              out.println("--- gerrit project filepath size ${project.getFilePaths().size()}")
              for (path in project.getFilePaths()) {
                   out.println("--- compare type ${path.getCompareType()}, pattern ${path.getPattern()}")
              }        
        }
    }
}
