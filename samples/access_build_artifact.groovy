import hudson.FilePath

// read a file 
b = build('test-artifact')
p = new FilePath(b.getArtifactsDir())
f = p.child("myartifact.ini")
out.println("--${f.getRemote()} exists ? ${f.exists()}" )
if (f.exists()) {
  content = f.readToString()
  out.println "--content\n${content}"
}

// create a file

import hudson.FilePath
import hudson.FilePath.FileCallable
 
def logger = manager.listener.logger
def b = manager.build
path = new FilePath(b.getArtifactsDir())
logger.println("--- will create this file sample.txt in ${path.getRemote()}")
def callable = { dir, channel ->  
  if (!dir.exists()) {
    dir.mkdir()
  }  
  def f = new File(dir, 'sample.txt')
  f << 'hello world'
} as FileCallable
 
path.act(callable)

