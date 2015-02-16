import hudson.model.StringParameterValue
import hudson.model.ParametersAction
import hudson.model.Action
def logger = manager.listener.logger
def actions = manager.build.actions
def parametersAction = actions.find {it.class == ParametersAction} 
def param = new StringParameterValue('PARAMTEST', "somestring")  
def modified = parametersAction.parameters.collect {it}
modified.add(param)
actions.remove(parametersAction)
actions.add(new ParametersAction(modified))
