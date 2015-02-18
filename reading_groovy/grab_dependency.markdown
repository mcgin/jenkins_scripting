Groovy allows specify dependencies directly in script e.g.

    @Grab(group='org.apache.sshd', module='apache-sshd', version='0.12.0')
    import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider
