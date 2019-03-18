@Grab(group='mysql', module='mysql-connector-java', version='8.0.15')

import com.mysql.cj.xdevapi.Session
import com.mysql.cj.xdevapi.SessionFactory
import com.mysql.cj.xdevapi.DocResult

def port = 33060

SessionFactory sessionFactory = new SessionFactory();
Session session = sessionFactory.getSession("mysqlx://root@127.0.0.1:${port}/hogehoge?user=root&password=mysql");

def schema = session.getDefaultSchema()
def colletion = schema.getCollection("clct")

def findFuture = colletion.find().executeAsync()
DocResult found = findFuture.get()

// 各Docmentは以下のクラスで表現される
// https://dev.mysql.com/doc/dev/connector-j/8.0/com/mysql/cj/xdevapi/DbDoc.html
// java.util.Map を継承しているため、Map記法でアクセス可能
found.forEach { println "id: ${it._id}, a: ${it.a}" }

colletion.add("""{"a": "added from groovy"}""").executeAsync().get()

DocResult found2 = colletion.find().executeAsync().get()
found2.forEach { println "id: ${it._id}, a: ${it.a}" }


