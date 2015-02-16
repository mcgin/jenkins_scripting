jenkins = Jenkins.getInstance()
pluginId = 'log-parser'
  
plugin = jenkins.getUpdateCenter().getPlugin(pluginId);  
if (plugin) {
  e = plugin.deploy(true).get().getError();
  if (e){
    println("Failed to install plugin '${pluginId}'")
  } else {
    println("Plugin '${pluginId}' is successfully installed")      
  }
} else {
  println("Plugin '${pluginId}' is not found")
}
