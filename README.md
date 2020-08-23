# coolstuff

```
1. Get Spring Boot
```

The starter project comes with https://start.spring.io/ (Spring Initializer)


```
2. Install Cassandra
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


Thanks!

References 
-----------
A combination of below posts and my own workarounds was used to create this.
* [Download Apache Cassandra] (http://cassandra.apache.org/download/) (This is different from the Datastax distro)
* [Install Cassandra 2.1 on Mac OS X] (http://exponential.io/blog/2015/01/28/install-cassandra-2_1-on-mac-os-x/)
* [This Gist] (https://gist.github.com/Micka33/89897e1490240a56c036)

