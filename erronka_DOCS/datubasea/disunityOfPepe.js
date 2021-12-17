var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
var collectionList = ["pertsona", "partida"];

MongoClient.connect(url, function(err, db) {
   var dbase = db.db("DisunityOfPepe");
   console.log("\nDB created");
  collectionList.forEach(function(collectionName) {dbase.createCollection(collectionName)});
 // dbase.listCollections().toArray().then(cols => console.log("Collections", cols));
  dbase.addUser(
  {
    user: "tester",
    pwd: "testpwd",
    roles: [{ role: "read", db:"DisunityOfPepe"}]
  });
  //console.log(dbase.getCollectionNames());
  /*
  console.log("succeding...");
  db.createCollection("pertsona", function(err, res) {
    //if (err) throw err;
    console.log("pertsona created!");
  
  "_id" : "admin.admin", "user" : "admin","db" : "admin","roles" : [{ "role" : "dbAdminAnyDatabase","db" : "admin"},{ "role" : "clusterAdmin","db" : "admin"}] }




  }
    db.createCollection("partida", function(err, res) {
    //if (err) throw err;
    console.log("pertsona created!");
  }*/
  db.close();
});