//addServicetestCategory.goorvy
import jenkins.model.Jenkins
import hudson.plugins.throttleconcurrents.ThrottleJobProperty.DescriptorImpl
import hudson.plugins.throttleconcurrents.ThrottleJobProperty.ThrottleCategory
desc = Jenkins.instance.getDescriptorByType(DescriptorImpl.class)
cat = new ThrottleCategory('servicetest', 1, 0, null)
desc.setCategories([cat])
desc.save()
