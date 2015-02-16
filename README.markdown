## Overview

Jenkins API is huge and complex, taking long time and effort to understand. So we provide some typical examples in form of 
groovy snippet to help peoples not familiar with Jenkins internal implementation to do some useful stuffs

There are few options to access Jenkins API

* run groovy script in admin console
* run groovy script in job using build-flow-plugin
* run groovy script in post build of job using groovy-postbuild
* write your own plugin see https://wiki.jenkins-ci.org/display/JENKINS/Extend+Jenkins

In different to admin console, build-flow-plugin and  groovy-postbuild give us a sort of variable to access the current build

## Jenkins Domain Model

Jenkins fundamental objects are

* Job aka Project (these terms are used interchangeably)  : Project specifies how a thing will be built, from what and under which condition. A project has triggers, builders, publishers
* Build : Build is created when we build a Project usually when source code is changed. A build has a Cause, Action, Result, Log, Artifacts. 
* Jenkins aka Hudson : It exists in form of  singleton and represents entire Jenkins System. From the Jenkins instance we can navigate to projects, views, Queue,  
* FilePath: represents path to a file in distributed environment i.e. on remote machine
* Action: a build is a composite of actions (aka non core information elements) that are displayed on UI canvas (SystemInfoLink) and/or also served as input (e.g. parameter) for the build. See https://wiki.jenkins-ci.org/display/JENKINS/Action+and+its+family+of+subtypes

## Navigation

Access current build in build flow DSL

    build

Access current build in postbuild groovy DSL
    
    manager.build

Access root object in build flow DSL
    
     import jenkins.model.Jenkins 
     //on old version
     //import jenkins.model.Hudson

    def jenkins = Jenkins.getInstance()
    //on old version
    //def jenkins = Hudson.getInstance()

Access root object in  postbuild groovy DSL

    manager.hudson 
  
   
    
     
      
       
        
