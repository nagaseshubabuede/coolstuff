# coolstuff

```
Get Spring Boot
```

The starter project comes with https://start.spring.io/ (Spring Initializer)


```
Install Cassandra
```


Caution!
---------
Version Number might change!! The versions of all softwares mentioned here, including Cassandra will change as newer versions are launched. 

Install Homebrew 
----------------
Homebrew is a great little package manager for OS X. If you haven't already, installing it is pretty easy:
```
ruby -e "$(curl -fsSL https://raw.github.com/Homebrew/homebrew/go/install)"
```

Install Python
--------------
Mac OS X has a copy of Python preinstalled, but this makes sure you get the newest version.
```
brew install python
```

Two Ways to Install Cassandra
-----------
A] Using Homebrew (This led to connection refused and compilatoin errors during cassandra and cqlsh startups for me)
B] Using Binaries

A] Using Homebrew
-----------
Install cql
-----------
To use cqlsh, the Cassandra query language shell, you need to install cql:
```
pip install cql
pip install cassandra-driver
```
Install Cassandra
-----------------
This installs Apache Cassandra:
```
brew install cassandra
```

Starting Cassandra
------------------
At the end of the install, brew will tell you about two ways to launch Cassandra. The first will launch it when the computer restarts, but this isn't recommended because you may not want to always run Cassandra. Instead use this command:
```
launchctl load ~/Library/LaunchAgents/homebrew.mxcl.cassandra.plist
```
Or even easier:
```
launchctl start homebrew.mxcl.cassandra
```
and to stop:
```
launchctl stop homebrew.mxcl.cassandra
```

On Mavericks, Homebrew failed to move the plist file into LaunchAgents. Which gives this error message:
```
launchctl: Couldn't start("/Users/username/Library/LaunchAgents/homebrew.mxcl.cassandra.plist"): No such file or directory
```

To fix this just issue the following command. Then, try using the ```launchctl load``` command again:
```
cp /usr/local/Cellar/cassandra/2.1.2/homebrew.mxcl.cassandra.plist ~/Library/LaunchAgents/
```

Cassandra file locations
------------------------
Properties: /usr/local/etc/cassandra  
Logs: /usr/local/var/log/cassandra  
Data: /usr/local/var/lib/cassandra/data  

Finally cqlsh should connect to cassandra:
------------------------------------------
```
$> cqlsh
Connected to Test Cluster at 127.0.0.1:9042.
[cqlsh 5.0.1 | Cassandra 2.1.2 | CQL spec 3.2.0 | Native protocol v3]
Use HELP for help.
cqlsh>
cqlsh>
```

B] Using Binaries
-----------
Here, we use Apache Cassandra as well as it's own bundled ```cqlsh``` tool instead of an external one.
We install Cassandra 3.5 as a standalone, single node cluster. A single node cluster is an easy way to get started learning Cassandra on your laptop.

These installation steps show how to install a local copy of Cassandra. The benefits of a local copy are that you do not need root or sudo to install Cassandra, updating versions is quick and easy, and you can control how/when to install updates.

Install the Oracle JDK
-----------
Ensure that you have at least Java JDK version 7 installed.

Install Cassandra
-----------
```
mkdir -p ~/opt/packages && cd $_

curl -O http://psg.mtu.edu/pub/apache/cassandra/3.5/apache-cassandra-3.5-bin.tar.gz

gzip -dc apache-cassandra-3.5-bin.tar.gz | tar xf -

ln -s ~/opt/packages/apache-cassandra-3.5 ~/opt/cassandra
```
Create data directories for Cassandra
-----------
In this step we need to create several directories that are used by Cassandra. Each directory is used by the following configuration variable in ```conf/cassandra.yaml```:
* data_file_directories: ~/opt/cassandra/data/data
* commitlog_directory: ~/opt/cassandra/data/commitlog
* saved_caches_directory: ~/opt/cassandra/data/saved_caches

The ```logs``` directory is used by logback which is configured via the ```conf/logback.xml``` file.
```
mkdir -p ~/opt/cassandra/data/data

mkdir -p ~/opt/cassandra/data/commitlog

mkdir -p ~/opt/cassandra/data/saved_caches

mkdir -p ~/opt/cassandra/logs
```
Add Cassandra to your PATH
-----------
Update your PATH to include Cassandra.
```open -a TextEdit ~/.bash_profile```
Paste the following into your ```.bash_profile``` file.
```
# include locally installed Cassandra in PATH
if [ -d "$HOME/opt" ]; then
    PATH="$PATH:$HOME/opt/cassandra/bin"
fi
```
Source your ```.bash_profile``` file.
```source .bash_profile```

Start the Cassandra server
-----------
We’re going to run Cassandra in the foreground during development. Cassandra will output a lot of information to the terminal when we start the server. However, this information can be useful during development in case there is a problem with the server.
```cassandra -f```
Press ```Ctrl + C``` when you are ready to stop the server.

Use Apache's bundled ```cqlsh```
-----------
One can also use a symlink, but I created an alias in my .zshrc file to point to Cassandra's own ```cqlsh``` tool instead of an external one:
```
alias cqlsh="~/opt/packages/apache-cassandra-3.5/bin/cqlsh"
```
Now type and hit return:
```
cqlsh
```
You should see this:
```
Connected to Test Cluster at 127.0.0.1:9042.
[cqlsh 5.0.1 | Cassandra 3.5 | CQL spec 3.4.0 | Native protocol v4]
Use HELP for help.
```
Thanks!

References 
-----------
A combination of below posts and my own workarounds was used to create this.
* [Download Apache Cassandra] (http://cassandra.apache.org/download/) (This is different from the Datastax distro)
* [Install Cassandra 2.1 on Mac OS X] (http://exponential.io/blog/2015/01/28/install-cassandra-2_1-on-mac-os-x/)
* [This Gist] (https://gist.github.com/Micka33/89897e1490240a56c036)

