 Common

**artifactory**

Description: Deploy artifacts to Artifactory Server

Context: freestyle/flow

Multiple: Override

Example

    builder.freestyle 'frontoffice-build' do
      artifactory do
        server 'artifactory.aws.wonga.com'
        repository 'devprod'
        deploy 'frontoffice-1.0.$BUILD_NUMBER.zip'
      end
    end
