//addGerritServer.groovy
import com.sonyericsson.hudson.plugins.gerrit.trigger.PluginImpl  
import com.sonyericsson.hudson.plugins.gerrit.trigger.GerritServer
import com.sonyericsson.hudson.plugins.gerrit.trigger.config.Config
import net.sf.json.JSONObject
import net.sf.json.JSONArray
    
categories = new JSONArray()
[
    [
        'verdictValue': 'Code-Review',
        'verdictDescription': 'Code Review'
    ],
    [
        'verdictValue': 'Verified',
        'verdictDescription': 'Verified'
    ]
].each() { it ->
    jsonCat = new JSONObject()
    jsonCat.accumulateAll(it)
    categories.add(jsonCat)
}
serverConfig = new JSONObject()
serverConfig.accumulateAll([
    'gerritHostName': 'gerrit.wonga.com',
    'gerritSshPort': 29418,
    'gerritFrontEndUrl': 'https://gerrit.wonga.com',
    'gerritUserName': 'builduser',
    'gerritEmail': 'builduser@wonga.com',
    'gerritAuthKeyFile': '/var/lib/jenkins/.ssh/builduser',
    'gerritBuildStartedVerifiedValue': 0,
    'gerritBuildSuccessfulVerifiedValue': 1,
    'gerritBuildFailedVerifiedValue': -1,
    'gerritBuildUnstableVerifiedValue': 0,
    'gerritBuildNotBuiltVerifiedValue': 0,
    'gerritBuildStartedCodeReviewValue': 0,
    'gerritBuildSuccessfulCodeReviewValue': 1,
    'gerritBuildFailedCodeReviewValue': -1,
    'gerritBuildUnstableCodeReviewValue': 0,
    'gerritBuildUnstableCodeReviewValue': 0,
    'gerritVerifiedCmdBuildStarted': '',
    'gerritVerifiedCmdBuildSuccessful': "gerrit review <CHANGE>,<PATCHSET> --message 'Build Successful <BUILDS_STATS>' --label Verified=<VERIFIED> --code-review <CODE_REVIEW>",
    'gerritVerifiedCmdBuildFailed': "gerrit review <CHANGE>,<PATCHSET> --message 'Build Failed <BUILDS_STATS>' --label Verified=<VERIFIED> --code-review <CODE_REVIEW>",
    'gerritVerifiedCmdBuildUnstable': "gerrit review <CHANGE>,<PATCHSET> --message 'Build Unstable <BUILDS_STATS>' --label Verified=<VERIFIED> --code-review <CODE_REVIEW>",
    'gerritVerifiedCmdBuildNotBuilt': "gerrit review <CHANGE>,<PATCHSET> --message 'No Builds Executed <BUILDS_STATS>' --label Verified=<VERIFIED> --code-review <CODE_REVIEW>",
    'enableManualTrigger': true,
    'enablePluginMessages': true,
    'verdictCategories': categories
])
server = new GerritServer('gerrit.wonga.com')
server.setConfig(new Config(serverConfig))
plugin.setServers([server] as LinkedList)
plugin.save()

