## Ruby Job Builder DSL

Wonga has pretty complex continous integration system in which we employ Jenkins to build SOAP components and run different test suites. As we favor infrastructure as code, we want the creation of Jenkins jobs configuration done using code instead of using Web UI.

Initially we used the [Openstack Job Builder Python](http://ci.openstack.org/jenkins-job-builder/), which allows us to create a job's configuration in YAML. Maintain jobs configuration in YAML is huge step forward comparing to Web UI, however we soon discovered that YAML has several limitations lacking of both composition and abstraction causing repetitive work and maintenance issues. This is driving factor for the birth of Ruby Job Builder DSL.

Ruby Jobs Builder DSL is designed as Ruby internal DSL, so it offers full fledged programming experience at the same time concise, focused vocabularies for job's creation.

Ruby Jobs Builder DSL can generate Jenkins XML job configuration files deploy jobs directly into Jenkins Server.

## Example

Step 1 - Create a ruby file e.g. `hello-world.rb` with the following content

    $ cat hello-world.rb
    require 'rubyjobbuilderdsl'
    builder = JenkinsJob::Builder.new
    builder.freestyle 'hello-world' do
      shell 'echo hello world'
    end
    JenkinsJob::Deployer.new(builder).run

Step 2 - Run it

    $ cat localhost.ini
    [jenkins]
    url=http://localhost:8080/
    user=jenkins-jobs
    password=7bb352e4f3da683c17247f3abf88f47c

    $ bundle exec ruby hello_world.rb --deploy ----config-file=localhost.ini
    deploying hello-world

## References

* http://ci.openstack.org/jenkins-job-builder/
* https://github.com/jenkinsci/jenkins.rb
* https://github.com/jenkinsci/job-dsl-plugin/wiki/Job-DSL-Commands