import jenkins.model.Jenkins
jenkins = Jenkins.getInstance()
 
// all online nodes labeled with 'windows'
nodes = jenkins.nodes.findAll {node-> node.channel != null && node.getLabelString().split().any {it -> it == 'windows'} }
 
nodes.each { node ->
   out.println(node.getDisplayName())
   
   def output = new java.io.ByteArrayOutputStream();
   def listener = new hudson.util.StreamTaskListener(output);
   def launcher = node.createLauncher(listener);
   def command = new hudson.util.ArgumentListBuilder();
   command.addTokenized("git --version");
   def ps = launcher.launch();
   ps = ps.cmds(command).stdout(listener);
   
   def proc = launcher.launch(ps);
   def exitCode = proc.join();
  
   out.println("--- git --version returns ${exitCode}\n\t${output.toString()}")
}
