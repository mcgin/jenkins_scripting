import com.cloudbees.plugins.credentials.CredentialsProvider
import com.cloudbees.jenkins.plugins.sshcredentials.SSHUser
CredentialsProvider.lookupCredentials(SSHUser.class).each { u ->
  println("----${u.id}, ${u.username}")
  u.properties.each { println it}
}
