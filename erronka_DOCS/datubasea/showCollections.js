
      var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
var collectionList = ["pertsona", "partida"];

MongoClient.connect(url, function(err, db) {
   var dbase = db.db("DisunityOfPepe");
      collectionList.forEach(function(collectionName) {console.log(dbase.collection(collectionName))});


   //console.log(dbase.listCollections());
  /*
   dbase.listCollections()
            .toArray().then(cols => console.log("Collections", cols));
  */
  db.close();
});