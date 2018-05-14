var url = 'mongodb://localhost:27017'
var MongoClient = require('mongodb').MongoClient
var col = 'todos'

function DB() {
}

function doDB(callback){
      MongoClient.connect(url, function (err, client) {
            if (err) throw err
            db = client.db('firstdb')
            callback()
            client.close()
      })    
}

DB.prototype.insert = function (data) {
      doDB(function(){
            db.collection(col).insertOne(data, function(err, result){
                  if(err) throw err
                  consolog.log("insert : ", result)

            })
      })
}

DB.prototype.query = function (callback) {
      doDB(function(){
            var result = db.collection(col).find() 
            callback(result) // 写成callback(db.collection(col).find())竟然不行, 像是卡死在这没动静了
      })
}

DB.prototype.delete = function(itemName){
      doDB(function() {
            var deleteItem = {"item":itemName}
            db.collection(col).deleteOne(deleteItem)   
      })
}

module.exports = DB