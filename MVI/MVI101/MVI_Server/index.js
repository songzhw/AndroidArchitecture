var DbHelper = require('./dbhelper')
var db = new DbHelper()

// 下面均是第三方模块, 均要安装先
var express = require('express')
var app = express()
var bodyParser = require('body-parser')

var urlEncodedParser = bodyParser.urlencoded({ extended: false })
app.use(urlEncodedParser)

app.get('/todos', function (req, resp) {
      db.query(function (result) {
            result.toArray(function (err, data) {
                  var ary = [] // an array to hold all the data
                  data.forEach(function (aItem, pos) {
                        var obj = {
                              "pos": pos,
                              "desp":aItem.item
                        }
                        ary.push(obj)
                  })
                  var ret = {"code":2000, "msg":"", "todos":ary}
                  resp.json(ret) // 若用resp.json(JSON.stringify(ret)), 则最终发出起的 " 变成了 /"
            })
      })
})

app.post('/addTodo', function (req, resp) {
      var item = ''
      req.setEncoding('utf-8')
      req.on('data', function (chunk) {
            console.log('post chunk = ' + chunk)
            item += chunk
      })
      req.on('end', function () {
            console.log("szw insert : ", item)
            var obj = { "item": item }
            db.insert(obj)
            resp.json({"code":2000, "msg":"add successfully"})
      })
})

app.delete('/delTodo', function (req, resp) {

})

app.listen(8899, function () {
      console.log("MVI Server started on port 8899...")
})

