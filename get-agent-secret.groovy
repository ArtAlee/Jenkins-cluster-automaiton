import jenkins.model.Jenkins

println Jenkins.instance.getComputer('slave-node-1').getJnlpMac()
