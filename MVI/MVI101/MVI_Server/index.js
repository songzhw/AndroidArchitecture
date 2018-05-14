var DbHelper = require('./dbhelper')
var db = new DbHelper()

// 下面均是第三方模块, 均要安装先
var express = require('express')
var app = express()
var bodyParser = require('body-parser')

var urlEncodedParser = bodyParser.urlencoded({ extended: false })
app.use(urlEncodedParser)

app.get('/todos', function (req, resp) {

})

app.post('/addTodo', function (req, resp) {

})

app.delete('/delTodo', function (req, resp) {

})

app.listen(8899, function () {
      console.log("MVI Server started on port 8899...")
})

