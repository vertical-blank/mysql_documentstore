
```
docker run --name mysql5.7 -e MYSQL_ROOT_PASSWORD=mysql -d -p 3307:3306 -p 33070:33060 mysql:5.7
```

```
mysql -h127.0.0.1 -P3307 -u mysql -p
install plugin mysqlx soname 'mysqlx.so';
```

```
mysqlsh root@127.0.0.1:33070
```

MySQL8 であれば _id は不要
```
hoge = session.createSchema('hogehoge')
clct = hoge.createCollection('clct')

clct.add({ _id: 'hogehoge1', "a": 1234 })
Query OK, 1 item affected (0.0093 sec)
clct.add({ _id: 'hogehoge2', "a": 12345 })
Query OK, 1 item affected (0.0091 sec)
```

```
clct.find()
[
    {
        "_id": "hogehoge1", 
        "a": 1234
    },
    {
        "_id": "hogehoge2", 
        "a": 12345
    }
]
2 documents in set (0.0015 sec)
```




