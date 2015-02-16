// groovy postbuild

def logger = manager.listener.logger
def build = manager.build
 
def scheduled = build.getTimeInMillis()
def started = build.getStartTimeInMillis()
def now =  System.currentTimeMillis()
 
logger.println "it takes ${now - scheduled} ms to complete"
logger.println "it waits ${started - scheduled} ms in queue"
