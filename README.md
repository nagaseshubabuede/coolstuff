# coolstuff

Get Spring Boot Project Using Spring Intializer 
===============================================
Spring Initializer is the coolest way to develop spring project on fly by simply using below URI :

```
https://start.spring.io/
```


Installing Cassandra on Mac OS X
================================


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
```brew install cassandra```

Cassandra version
-----------------
```cassandra -v```

start cassandra
---------------
```cassandra```

Create Keyspace
----------------
``` 
create keyspace mykeyspace with replication = {'class':'SimpleStrategy','replication_factor' : 2}; 
use mykeyspace;
```

Create Table
------------
```  create table customer
(
  id         UUID primary key,
  first_name varchar,
  last_name  varchar,
  date_time  timestamp
); ```

Drop Table
-----------

``` drop table customer;```


Thanks!

References 
-----------
A combination of below posts and my own workarounds was used to create this.
* [Download Apache Cassandra] (http://cassandra.apache.org/download/) (This is different from the Datastax distro)
* [Install Cassandra 2.1 on Mac OS X] (http://exponential.io/blog/2015/01/28/install-cassandra-2_1-on-mac-os-x/)
* [This Gist] (https://gist.github.com/Micka33/89897e1490240a56c036)

