## Flow

Create build flow style project

**dsl**

Description: Specify groovy DSL for a flow job

Multiple: Override

Example:

    builder.flow 'ops-post' do
      dsl <<EOS
    build("ops-" + params["GERRIT_BRANCH"],
     GERRIT_REFSPEC: "refs/heads/${params["GERRIT_BRANCH"]}",
     GERRIT_BRANCH: params["GERRIT_BRANCH"])
    EOS

    end
