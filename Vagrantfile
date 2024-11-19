# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.define "master-node" do |master|
    master.vm.box = "ubuntu/focal64"
    master.vm.hostname = "master-node"
    master.vm.network "forwarded_port", guest: 8080, host: 8080
    master.vm.network "private_network", type: "dhcp", ip: "192.168.56.5"

    master.vm.provider "virtualbox" do |vb|
      vb.memory = "2048" # Set memory to 2 GB
    end
    master.vm.provision "ansible" do |ansible|
      ansible.playbook = "provision.yml"
      ansible.groups = {
        "master" => ["master-node"],
        "all_nodes" => ["master-node", "worker-node-1", "worker-node-2"]
      }
    end
  end

  config.vm.define "worker-node-1" do |worker1|
    worker1.vm.box = "ubuntu/focal64"
    worker1.vm.hostname = "worker-node-1"
    worker1.vm.network "private_network", type: "dhcp", ip: "192.168.56.6"
    worker1.vm.provider "virtualbox" do |vb|
      vb.memory = "2048" # Set memory to 2 GB
    end
    worker1.vm.provision "ansible" do |ansible|
      ansible.playbook = "provision.yml"
      ansible.groups = {
        "worker" => ["worker-node-1"],
        "all_nodes" => ["master-node", "worker-node-1", "worker-node-2"]
      }
    end
  end

  config.vm.define "worker-node-2" do |worker2|
    worker2.vm.box = "ubuntu/focal64"
    worker2.vm.hostname = "worker-node-2"
    worker2.vm.network "private_network", type: "dhcp", ip: "192.168.56.7"
    worker2.vm.provider "virtualbox" do |vb|
      vb.memory = "2048" # Set memory to 2 GB
    end
    worker2.vm.provision "ansible" do |ansible|
      ansible.playbook = "provision.yml"
      ansible.groups = {
        "worker" => ["worker-node-2"],
        "all_nodes" => ["master-node", "worker-node-1", "worker-node-2"]
      }
    end
  end
end

